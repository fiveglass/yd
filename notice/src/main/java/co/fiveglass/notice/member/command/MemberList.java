package co.fiveglass.notice.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.fiveglass.notice.common.Command;
import co.fiveglass.notice.member.service.MemberService;
import co.fiveglass.notice.member.service.MemberVO;
import co.fiveglass.notice.member.service.Impl.MemberServiceImpl;

public class MemberList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//멤버 목록 가져오기
		MemberService ms = new MemberServiceImpl();
		List<MemberVO> members = new ArrayList<>();
		members = ms.memberSelectList();
		
		request.setAttribute("members", members);
		return "member/memberList";
	}

}
