package co.fiveglass.notice.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.fiveglass.notice.common.Command;
import co.fiveglass.notice.service.NoticeService;
import co.fiveglass.notice.service.NoticeVO;
import co.fiveglass.notice.service.Impl.NoticeServiceImpl;

public class NoticeUpdate implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시물을 데이터베이스에 수정해서 저장한다.
		NoticeService ns =new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(Integer.valueOf(request.getParameter("noticeId")));
		vo.setNoticeWdate(Date.valueOf(request.getParameter("noticeWdate")));
		vo.setNoticeTitle(request.getParameter("noticeTitle"));
		vo.setNoticeSubject(request.getParameter("noticeSubject"));
		
		int n =  ns.noticeUpdate(vo);
		if(n != 0) {
			request.setAttribute("message", "정상적으로 수정 되었습니다.");
		}else {
			request.setAttribute("message", "게시글 수정 실패하였습니다.");
		}

		return "notice/noticeMessage";
	}

}
