package co.fiveglass.notice;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.fiveglass.notice.command.NoticeList;
import co.fiveglass.notice.common.Command;
import co.fiveglass.notice.main.command.MainCommand;
import co.fiveglass.notice.member.command.MemberInsert;
import co.fiveglass.notice.member.command.MemberJoin;
import co.fiveglass.notice.member.command.MemberList;
import co.fiveglass.notice.member.command.memberLogin;
import co.fiveglass.notice.member.command.memberLoginForm;
import co.fiveglass.notice.member.command.AjaxCheck;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
	
 
    public FrontController() {
        super();
       
    }


	public void init(ServletConfig config) throws ServletException {
		// 처음 시작 될 때 동작하는 메소드, 요청한 것을 담아두는 곳
		map.put("/main.do", new MainCommand());//처음 들어오는 페이지 돌려준다.
		map.put("/noticeList.do", new NoticeList() ); //게시글 목록보기
		map.put("/memberList.do", new MemberList()); //멤버목록보기
		map.put("/memberJoin.do", new MemberJoin());
		map.put("/memberInsert.do", new MemberInsert());
		map.put("/AjaxCheck.do", new AjaxCheck());
		map.put("/memberLoginForm.do", new memberLoginForm());
		map.put("/memberLogin.do", new memberLogin());
	}

	//더하기 : request response 서버에서 만들어줌
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실제 서비스 하는 부분, 수행할 command를 찾아서 수행하고 결과 리턴
		request.setCharacterEncoding("utf-8"); //한글깨짐 방지
		String uri = request.getRequestURI(); //호출한 uri를 구함
		String contextPath = request.getContextPath(); //root 구함
		String page = uri.substring(contextPath.length()); //요청한 페이지를 구함
		
		Command command = map.get(page); //수행할 command를 가져옴
		String viewPage = command.exec(request, response); 
		
		if(!viewPage.endsWith(".do")) {
			
			if(viewPage.startsWith("Ajax : ")) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(viewPage); //결과가 *.do이면 위임해버림
			
		}
			
	}
	

}
