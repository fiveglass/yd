package co.fiveglass.notice.service;

import java.util.List;
//Model 구현 시 사용되는 인터페이스
public interface NoticeService {
	List<NoticeVO> noticeSelectList(); //전체조회
	NoticeVO noticeSelect(NoticeVO vo); //한명조회
	int noticeInsert(NoticeVO vo); //입력
	int noticeUpdate(NoticeVO vo); //수정
	int noticeDelete(NoticeVO vo); //삭제

	
}
