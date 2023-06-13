package co.shop.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.shop.board.command.BoardList;
import co.shop.cart.command.cart;
import co.shop.common.Command;
import co.shop.main.command.MainCommand;
import co.shop.member.command.AjaxCheckId;
import co.shop.member.command.ForgetPw;
import co.shop.member.command.AjaxSearchPw;
import co.shop.member.command.ForgetId;
import co.shop.member.command.Login;
import co.shop.member.command.MemberInsert;
import co.shop.member.command.MemberLogin;
import co.shop.product.command.ProductModify;
import co.shop.recommend.command.Recommend;
import co.shop.recommend.command.RecommendResult;
import co.shop.product.command.Product;
import co.shop.product.command.ProductInsert;
import co.shop.product.command.ProductInsertForm;
import co.shop.social.command.AjaxCheckAge;
import co.shop.social.command.NaverCallback;
import co.shop.social.command.NaverLogin;
import co.shop.social.command.SocialLogin;
import co.shop.user.command.ManagerPage;
import co.shop.user.command.UserPage;



/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/login.do", new Login());
		map.put("/cart.do", new cart());
		map.put("/socialLogin.do", new SocialLogin());
		map.put("/ajaxCheckAge.do", new AjaxCheckAge());
		map.put("/memberLogin.do", new MemberLogin());
		map.put("/forgetPw.do", new ForgetPw());
		map.put("/ajaxSearchPw.do", new AjaxSearchPw());
		map.put("/boardList.do", new BoardList());
		map.put("/forgetId.do", new ForgetId());

		map.put("/naverLogin.do", new NaverLogin());
		map.put("/naverCallback.do", new NaverCallback());
		map.put("/memberInsert.do", new MemberInsert());
		map.put("/ajaxCheckId.do", new AjaxCheckId());
		map.put("/userpage.do", new UserPage());
		map.put("/managerpage.do",new ManagerPage());
		map.put("/productModify.do", new ProductModify());
		map.put("/product.do", new Product()); //전체상품페이지
		map.put("/productInsertForm.do", new ProductInsertForm()); //제품 등록 폼 호출
		map.put("/productInsert.do", new ProductInsert()); //제품 등록
		map.put("/recommend.do", new Recommend());
		map.put("/recommendResult.do", new RecommendResult());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri= request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);
		String viewPage = command.exec(request, response);
		
		if(!viewPage.endsWith(".do") && !viewPage.contains("naver") && !viewPage.contains("socialLogin.do")) {
			if(viewPage.startsWith("Ajax:")) {
				response.setContentType("text/html; charset = UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			if(viewPage.equals("member/Login")|| viewPage.equals("member/forgetPw")) {
				viewPage = "WEB-INF/views/" + viewPage + ".jsp";
			} else {
				viewPage = viewPage + ".tiles";
				
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(viewPage);
		}
	}
	

}