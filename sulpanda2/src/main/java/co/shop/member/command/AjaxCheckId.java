package co.shop.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.common.Command;
import co.shop.member.service.MemberService;
import co.shop.member.service.MemberVO;
import co.shop.member.service.Impl.MemberServiceImpl;

public class AjaxCheckId implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
			MemberService ms = new MemberServiceImpl();
			MemberVO vo = new MemberVO();
			vo.setMemberId(request.getParameter("id"));
			vo = ms.memberSelect(vo);
			String str = "Ajax:";
			
			if(vo != null) {
				str += "No";
			}else {
				str+= "Yes";
			}
			return str;
		}
	

}
