package co.fiveglass.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.fiveglass.notice.common.Command;
import co.fiveglass.notice.service.NoticeService;
import co.fiveglass.notice.service.NoticeVO;
import co.fiveglass.notice.service.Impl.NoticeServiceImpl;

public class NoticeSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//게시글 상세보기
		NoticeService ns = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		vo.setNoticeId(Integer.valueOf(request.getParameter("noticeId")));
		vo = ns.noticeSelect(vo);
		request.setAttribute("notice", vo);
		
		return "notice/noticeSelect";
	}

}
