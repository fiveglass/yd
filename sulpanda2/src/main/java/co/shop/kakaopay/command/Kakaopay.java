package co.shop.kakaopay.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import co.shop.common.Command;
import co.shop.kakaopay.service.KakaopayResponseVO;

public class Kakaopay implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String orderNo = request.getParameter("orderNo");
		String totalPrice = request.getParameter("totalPrice");
		String totalQuantity = request.getParameter("totalQuantity");
		String productName = "";
		String address = "";
		String membertel = request.getParameter("membertel");
		String deliveryMessage = "";
		String cartId = request.getParameter("cartId");
		System.out.println("cartID = " + cartId);
		
		try {
			productName = URLDecoder.decode(request.getParameter("productName"), "UTF-8");
			address = URLDecoder.decode(request.getParameter("address"), "UTF-8");
			deliveryMessage = URLDecoder.decode(request.getParameter("deliveryMessage"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("orderNo", orderNo);
		session.setAttribute("address", address);
		session.setAttribute("membertel", membertel);
		session.setAttribute("deliveryMessage", deliveryMessage);
		session.setAttribute("cartId", cartId);
		session.setAttribute("totalPrice", totalPrice);
		
		String memberId = (String) session.getAttribute("id");
		KakaopayResponseVO vo = getTid(orderNo, memberId, productName, Integer.parseInt(totalQuantity), Integer.parseInt(totalPrice));
		String redirectUrl = vo.getNextRedirectPcUrl();
		
		session.setAttribute("tid", vo.getTid());

		return redirectUrl;
	}
	
	private KakaopayResponseVO getTid(String orderNo, String memberId, String productName, int totalQuantity, int totalPrice) {
		KakaopayResponseVO vo = new KakaopayResponseVO();
		
		try {
            // API 엔드포인트(도착지점) URL 설정
            URL url = new URL("https://kapi.kakao.com/v1/payment/ready");

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
            requestBody.append("&partner_order_id=").append(URLEncoder.encode(orderNo, StandardCharsets.UTF_8));
            requestBody.append("&partner_user_id=").append(URLEncoder.encode(memberId, StandardCharsets.UTF_8));
            requestBody.append("&item_name=").append(URLEncoder.encode(productName, StandardCharsets.UTF_8));
            requestBody.append("&quantity=").append(totalQuantity);
            requestBody.append("&total_amount=").append(totalPrice);
            requestBody.append("&tax_free_amount=").append(0);
            requestBody.append("&approval_url=").append(URLEncoder.encode("http://localhost/meddle/kakaopayApproval.do", StandardCharsets.UTF_8));
            requestBody.append("&cancel_url=").append(URLEncoder.encode("http://localhost/meddle/kakaoMessage.do?status=cancel", StandardCharsets.UTF_8));
            requestBody.append("&fail_url=").append(URLEncoder.encode("http://localhost/meddle/kakaoMessage.do?status=fail", StandardCharsets.UTF_8));

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
                String tid = responseBodyObject.get("tid").getAsString();
                String nextRedirectPcUrl = responseBodyObject.get("next_redirect_pc_url").getAsString();
            	System.out.println("tid = " + tid);
            	System.out.println("next = " + nextRedirectPcUrl);
            	
                vo.setTid(tid);
                vo.setNextRedirectPcUrl(nextRedirectPcUrl);
            }

            // 연결 종료
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return vo;
	}

}
