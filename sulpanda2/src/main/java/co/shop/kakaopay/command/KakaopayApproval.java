package co.shop.kakaopay.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import co.shop.cart.service.CartService;
import co.shop.cart.service.CartVO;
import co.shop.cart.serviceImpl.CartServiceImpl;
import co.shop.common.Command;
import co.shop.kakaopay.service.KakaopayApprovalResponseVO;
import co.shop.kakaopay.service.KakaopayService;
import co.shop.kakaopay.service.KakaopayVO;
import co.shop.kakaopay.service.Impl.KakaopayServiceImpl;
import co.shop.orderproduct.service.OrderProductService;
import co.shop.orderproduct.service.OrderProductVO;
import co.shop.orderproduct.service.Impl.OrderProductServiceImpl;

public class KakaopayApproval implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String tid = (String) session.getAttribute("tid");
		String memberId = (String) session.getAttribute("id");
		String orderNo = (String) session.getAttribute("orderNo");
		String pgToken = request.getParameter("pg_token");
		String totalPrice = (String) session.getAttribute("totalPrice");
		
		KakaopayApprovalResponseVO vo = requestApproval(pgToken, tid, orderNo, memberId, totalPrice);
		
		//vo에 값들 이용해서 order 테이블에 값 저장하기
		KakaopayService ks = new KakaopayServiceImpl();
		KakaopayVO kvo = new KakaopayVO();
		
		kvo.setOrderId(orderNo);
		kvo.setMemberId(memberId);
		kvo.setMemberAddr((String) session.getAttribute("address"));
		kvo.setMemberTel((String) session.getAttribute("membertel"));
		kvo.setDeliveryMessage((String) session.getAttribute("deliveryMessage"));
		kvo.setPaymentType(vo.getPaymentMethodType());
		kvo.setOrderPrice(Integer.parseInt(vo.getAmount()));
		kvo.setAid(vo.getAid());
		kvo.setTid(tid);
		kvo.setCid(vo.getCid());
		
		int n = ks.kakaopayInsert(kvo);
		
		//cartId로 db에서 cart 정보값 다 가지고오기
		CartService cs = new CartServiceImpl();
		List<CartVO> cartproducts = new ArrayList<>();
		String[] cartIdArray = ((String) session.getAttribute("cartId")).split(",");
		cartproducts = cs.paymentOrder(cartIdArray);
		
		//cart 정보값 이용해서 order_product 값 저장하기
		OrderProductService os = new OrderProductServiceImpl();
		OrderProductVO ovo = new OrderProductVO();
		
		for(int i = 0; i<cartIdArray.length; i++) {
			ovo.setOrderId(orderNo);
			ovo.setProductName(cartproducts.get(i).getProductName());
			ovo.setProductCount(cartproducts.get(i).getProductCount());
			ovo.setProductFee(cartproducts.get(i).getProductFee());
			
			int m = os.OrderProductInsert(ovo);
		}
		
		//성공적으로 저장되었으면 cartId는 삭제처리하기
		int deleteResult = cs.orderSuccessDelete(cartIdArray);
		
		return "http://localhost/meddle/kakaopayMessage.do?status=success&orderNo="+orderNo;
	}

	public KakaopayApprovalResponseVO requestApproval(String pgToken, String tid, String orderNo, String memberId, String totalPrice) {
		KakaopayApprovalResponseVO vo = new KakaopayApprovalResponseVO();
		
		try {
            // API 엔드포인트(도착지점) URL 설정
            URL url = new URL("https://kapi.kakao.com/v1/payment/approve");

            // HttpURLConnection 생성
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 요청 메서드 설정 (GET, POST 등)
            connection.setRequestMethod("POST");

            // 요청 헤더 설정
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            connection.setRequestProperty("Authorization", "KakaoAK a46d8309f889d2307bb1b71681cb899b");

            // 요청 바디 작성
            StringBuilder requestBody = new StringBuilder();
            requestBody.append("cid=").append(URLEncoder.encode("TC0ONETIME", StandardCharsets.UTF_8));
            requestBody.append("&tid=").append(URLEncoder.encode(tid, StandardCharsets.UTF_8));
            requestBody.append("&partner_order_id=").append(URLEncoder.encode(orderNo, StandardCharsets.UTF_8));
            requestBody.append("&partner_user_id=").append(URLEncoder.encode(memberId, StandardCharsets.UTF_8));
            requestBody.append("&pg_token=").append(URLEncoder.encode(pgToken, StandardCharsets.UTF_8));

            // 요청 바디 전송
            connection.setDoOutput(true);
            try (OutputStream outputStream = connection.getOutputStream()) {
                byte[] input = requestBody.toString().getBytes(StandardCharsets.UTF_8);
                outputStream.write(input, 0, input.length);
            }

            

            // 응답 코드 확인
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // 응답 바디 읽기
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                System.out.println("Response Body: " + response.toString());

                // JSON 파싱
                Gson gson = new Gson();
                JsonObject responseBodyObject = gson.fromJson(response.toString(), JsonObject.class);

                // 필요한 필드 추출
                String responseAid = responseBodyObject.get("aid").getAsString();
                String responseTid = responseBodyObject.get("tid").getAsString();
                String responseCid = responseBodyObject.get("cid").getAsString();
                String partnerOrderId = responseBodyObject.get("partner_order_id").getAsString();
                String partnerUserId = responseBodyObject.get("partner_user_id").getAsString();
                String paymentMethodType = responseBodyObject.get("payment_method_type").getAsString();
                String amount = totalPrice;
                String itemName = responseBodyObject.get("item_name").getAsString();
            	
                vo.setAid(responseAid);
                vo.setTid(responseTid);
                vo.setCid(responseCid);
                vo.setPartnerOrderId(partnerOrderId);
                vo.setPartnerUserId(partnerUserId);
                vo.setPaymentMethodType(paymentMethodType);
                vo.setAmount(amount);
                vo.setItemName(itemName);
            }

            // 연결 종료
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		return vo;
	}
}
