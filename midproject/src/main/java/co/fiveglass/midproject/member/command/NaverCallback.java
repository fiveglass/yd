package co.fiveglass.midproject.member.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import co.fiveglass.midproject.common.Command;

public class NaverCallback implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String responseJsonString = getToken(request, response);
		
		Map<String, String> userInfoMap = getUserInfo(responseJsonString, request, response);
		
		String id = userInfoMap.get("id");
		String mobile = userInfoMap.get("mobile");
		String name = userInfoMap.get("name");
		
		System.out.println(id);
		System.out.println(mobile);
		System.out.println(name);
		
		//가입된 회원인지 확인
//		가입회원체크메서드()
//		"NAVER_" + id; 
//		NAVER_vPVsj5732Kh4BMl_D1iJGG9ceNBejwn9gD230f15fjo
//		
		//가입된 회원이면 로그인처리 아니면 회원가입 처리 후 로그인 처리
//	    if(가입되었다) {
//	    	
//	    } else (아니다) {
//	    	
//	    }
	    
		return "main/main";
	}
	
	// code로 token 값 가져오는 API 요청
	private String getToken(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		String clientId = "X9NAHBFGAzeE8b0LaUXS";
		String clientSecret = "SFhy__f3a9";
		String redirectURI = "";
		try {
			redirectURI = URLEncoder.encode("http://localhost/midproject/naverCallback.do", "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    String apiURL;
	    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	    apiURL += "client_id=" + clientId;
	    apiURL += "&client_secret=" + clientSecret;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&code=" + code;
	    apiURL += "&state=" + state;
	    String access_token = "";
	    String refresh_token = "";
	    System.out.println("apiURL="+apiURL);
	    
	    try {
	      URL url = new URL(apiURL);
	      HttpURLConnection con = (HttpURLConnection)url.openConnection();
	      con.setRequestMethod("GET");
	      int responseCode = con.getResponseCode();
	      BufferedReader br;
	      System.out.println("responseCode="+responseCode);
	      if(responseCode==200) { // 정상 호출
	        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	      } else {  // 에러 발생
	        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	      }
	      String inputLine;
	      StringBuffer res = new StringBuffer();
	      while ((inputLine = br.readLine()) != null) {
	        res.append(inputLine);
	      }
	      br.close();
	      
	      return res.toString();
	    } catch (Exception e) {
	      System.out.println(e);
	      
	      return "fail";
	      //send
	    }
	}
	
	private Map<String, String> getUserInfo(String responseJsonString, HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		Map<String,String> map = gson.fromJson(responseJsonString, Map.class);
		
		String accessToken = map.get("access_token");
		String header = "Bearer " + accessToken;
		
		String apiURL = "https://openapi.naver.com/v1/nid/me";

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Authorization", header);
        String responseBody = get(apiURL,requestHeaders);
        System.out.println("responseBody = " + responseBody);
        Map<String,Object> userInfoMap = gson.fromJson(responseBody, Map.class);
        String resultCode = (String)userInfoMap.get("resultcode");
        String message = (String)userInfoMap.get("message");

        LinkedTreeMap<String, Object> responseMap = (LinkedTreeMap<String, Object>) userInfoMap.get("response");
        
        String responseJson = gson.toJson(responseMap);

        Map<String, String> responseAsMap = gson.fromJson(responseJson, Map.class);
        
        return responseAsMap;
	}
	
	//	유저 정보 가져오는 API 통신
	private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
        	//	http 메서드 설정
            con.setRequestMethod("GET");
            //	헤더 설정
            for(Map.Entry<String, String> header : requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

    		//	API 통신 실제 실행
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
            //response.sendRedirect("~~~~/login.do?error=naverLogin")
        }
    }

	//	API를 요청하기 전 URL 클래스의 인스턴스 반환
    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

	//	API 통신 후 response의 body 정보를 읽어냄
    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);


        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();


            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }


            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }

}
