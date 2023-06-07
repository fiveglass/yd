package co.fiveglass.notice.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.fiveglass.notice.common.Command;
import co.fiveglass.notice.service.NoticeService;
import co.fiveglass.notice.service.NoticeVO;
import co.fiveglass.notice.service.Impl.NoticeServiceImpl;

public class NoticeInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 등록
		NoticeService ns = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeWriter(request.getParameter("noticeWriter"));
		vo.setNoticeTitle(request.getParameter("noticeTitle"));
		vo.setNoticeWdate(Date.valueOf(request.getParameter("noticeWdate")));
		vo.setNoticeSubject(request.getParameter("noticeSubject"));
		
		int n = ns.noticeInsert(vo);
		if(n != 0) {
			request.setAttribute("message", "정상적으로 등록 되었습니다.");
		}else {
			request.setAttribute("message", "게시글 등록 실패하였습니다.");
		}
		
		return "notice/noticeMessage";
	}

}
