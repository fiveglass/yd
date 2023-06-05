package co.fiveglass.notice.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.fiveglass.notice.common.Command;
import co.fiveglass.notice.member.service.MemberService;
import co.fiveglass.notice.member.service.MemberVO;
import co.fiveglass.notice.member.service.Impl.MemberServiceImpl;

public class AjaxCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberService ms = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("id"));
		vo = ms.memberSelect(vo);
		String str = "Ajax : ";
		
		if(vo != null) {
			str += "No";
		}else {
			str+= "Yes";
		}
		return str;
	}

}
