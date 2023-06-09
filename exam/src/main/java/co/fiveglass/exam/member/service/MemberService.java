package co.fiveglass.exam.member.service;


public interface MemberService {
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
	
	MemberVO memberLogin(MemberVO vo);
}
