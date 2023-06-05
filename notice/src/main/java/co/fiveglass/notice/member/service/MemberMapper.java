package co.fiveglass.notice.member.service;

import java.util.List;

public interface MemberMapper {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo); //입력
	int memberUpdate(MemberVO vo); //수정
	int memberDelete(MemberVO vo); //삭제
	
	MemberVO memberLogin(MemberVO vo);
}
