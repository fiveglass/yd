package co.shop.social.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.common.Command;
import co.shop.social.service.SocialService;
import co.shop.social.service.SocialVO;
import co.shop.social.service.Impl.SocialServiceImpl;

public class AjaxCheckAge implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		SocialService ss = new SocialServiceImpl();
		SocialVO vo = new SocialVO();
		vo.setSocialId(request.getParameter("id"));
		
		SocialVO vo2 = new SocialVO();
		vo2 = ss.socialSelect(vo);
		
		String str = "Ajax:";
		if(vo2 == null) {
			str += "Yes";
			
		} else {
			str += "No";
			
		}
		
		return str;
	}
		

}
