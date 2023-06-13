package co.shop.social.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.common.Command;
import co.shop.social.service.SocialService;
import co.shop.social.service.SocialVO;
import co.shop.social.service.Impl.SocialServiceImpl;

public class SocialLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		SocialService ss = new SocialServiceImpl();
		SocialVO vo = new SocialVO();
		vo.setSocialId(request.getParameter("socialId"));
		vo.setSocialName(request.getParameter("socialName"));
		vo.setSocialTel(request.getParameter("socialTel"));
		SocialVO vovo = ss.socialSelect(vo);
		
		if(vovo == null) {
			ss.socialInsert(vo);
			HttpSession session = request.getSession();
			session.setAttribute("state", "social");
			session.setAttribute("name", request.getParameter("socialName"));
			session.setAttribute("id", request.getParameter("socialId"));
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("state", "social");
			session.setAttribute("name", request.getParameter("socialName"));
			session.setAttribute("id", request.getParameter("socialId"));
		}
		
		return "main/main";
	}

}
