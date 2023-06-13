package co.shop.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.common.Command;
import co.shop.member.service.MemberService;
import co.shop.member.service.MemberVO;
import co.shop.member.service.Impl.MemberServiceImpl;

public class MemberInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberService ms = new MemberServiceImpl();
		MemberVO vo = new MemberVO();

		
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPw(request.getParameter("memberPassword"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberTel(request.getParameter("memberTel"));
		String postcode=request.getParameter("sample6_postcode");
		String addr=request.getParameter("sample6_address");
		String detailaddr=request.getParameter("sample6_detailAddress");
		String extraaddr=request.getParameter("sample6_extraAddress");
		vo.setMemberAddr("("+postcode+")"+addr+" "+detailaddr+extraaddr);
		vo.setMemberGrade("1레벨");
		
		int n = ms.memberInsert(vo);
		
		if(n!=0) {
			request.setAttribute("message", "회원가입이 정상적으로 처리되었습니다.");
			
		}else {
			request.setAttribute("message", "회원가입이 실패했습니다. 다시 가입해주시길 바랍니다.");
		}
		return "member/memberMessage";
	}

}
