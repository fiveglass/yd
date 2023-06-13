package co.shop.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.common.Command;
import co.shop.member.service.MemberService;
import co.shop.member.service.MemberVO;
import co.shop.member.service.Impl.MemberServiceImpl;

public class AjaxSearchPw implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberService ms = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("id"));
		vo.setMemberTel(request.getParameter("tel"));
		vo = ms.memberSelect(vo);
		
		String str="Ajax:";
		if(vo == null) {
			str += "등록된 정보가 없습니다.";
		} else {
			str += "회원님의 비밀번호는 [ " + vo.getMemberPw() + " ] 입니다.";
		}
		
		return str;
	}

}
