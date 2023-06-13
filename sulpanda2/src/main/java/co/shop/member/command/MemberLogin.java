package co.shop.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.common.Command;
import co.shop.member.service.MemberService;
import co.shop.member.service.MemberVO;
import co.shop.member.service.Impl.MemberServiceImpl;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberService ms = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPw(request.getParameter("memberPw"));
		
		vo = ms.memberSelect(vo);
		
		HttpSession session = request.getSession();
		
		if(vo != null) {
			session.setAttribute("id", vo.getMemberId());
			session.setAttribute("name", vo.getMemberName());
			return "main/main";
		} else {
			session.setAttribute("errMsg", "로그인 정보가 올바르지 않습니다.");
			return "member/Login";
		}
		
	}

}
