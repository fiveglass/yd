package co.fiveglass.midproject.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.fiveglass.midproject.MainCommand;
import co.fiveglass.midproject.common.Command;
import co.fiveglass.midproject.member.command.NaverCallback;
import co.fiveglass.midproject.member.command.NaverFinalProcess;
import co.fiveglass.midproject.member.command.NaverLogin;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();  
    
    public FrontController() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/naverLogin.do", new NaverLogin());
		map.put("/naverCallback.do", new NaverCallback());
		
		
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //한글깨짐 방지
		String uri = request.getRequestURI(); //호출한 uri를 구함
		String contextPath = request.getContextPath(); //root 구함
		String page = uri.substring(contextPath.length()); //요청한 페이지를 구함
		
		Command command = map.get(page); //수행할 command를 가져옴
		String viewPage = command.exec(request, response); 
		
		if(!viewPage.endsWith(".do") && !viewPage.contains("naver")) {
			
			if(viewPage.startsWith("Ajax : ")) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(viewPage); //결과가 *.do이면 위임해버림
			
		}
	}

}
