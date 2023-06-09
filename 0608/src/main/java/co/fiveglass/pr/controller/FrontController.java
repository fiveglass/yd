package co.fiveglass.pr.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.fiveglass.pr.MainCommand;
import co.fiveglass.pr.common.Command;
import co.fiveglass.pr.member.command.Contact;
import co.fiveglass.pr.project.command.Projects;
import co.fiveglass.pr.resume.command.Resume;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
    
    public FrontController() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/resume.do", new Resume());
		map.put("/projects.do", new Projects());
		map.put("/contact.do", new Contact());
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		String uri = request.getRequestURI(); 
		String contextPath = request.getContextPath(); 
		String page = uri.substring(contextPath.length()); 
		
		Command command = map.get(page); 
		String viewPage = command.exec(request, response); 
		
		if(!viewPage.endsWith(".do")) {
			
			//viewPage = "WEB-INF/views/" + viewPage + ".jsp";
			viewPage += ".tiles";
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(viewPage); 
			
		}
	}

}
