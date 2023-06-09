package co.fiveglass.exam.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.fiveglass.exam.MainCommand;
import co.fiveglass.exam.common.Command;
import co.fiveglass.exam.member.command.MemberInsert;
import co.fiveglass.exam.member.command.MemberJoin;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>(); 
	
    public FrontController() {
        super();
        
    }


	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/mamberJoin.do", new MemberJoin());
		map.put("/memberInsert.do", new MemberInsert());
//		map.put("/AjaxCheck.do", new AjaxCheck());
//		map.put("/memberLoginForm.do", new memberLoginForm());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  
		String uri = request.getRequestURI();   
		String contextPath = request.getContextPath(); 
		String page = uri.substring(contextPath.length()); 
		
		Command command = map.get(page);  
		String viewPage = command.exec(request, response);
		
		if(!viewPage.endsWith(".do")) {
			
			viewPage +=  ".tiles";
			//viewPage = "WEB-INF/views/" + viewPage + ".jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(viewPage);   
		}	
	}

}
