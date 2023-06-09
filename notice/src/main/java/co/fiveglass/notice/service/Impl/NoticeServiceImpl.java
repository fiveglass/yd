package co.fiveglass.notice.service.Impl;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.fiveglass.notice.common.DataSource;
import co.fiveglass.notice.service.NoticeMapper;
import co.fiveglass.notice.service.NoticeService;
import co.fiveglass.notice.service.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);
	
	@Override
	public List<NoticeVO> noticeSelectList() {

		return map.noticeSelectList();
	}
	

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {

		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
	
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
	
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
	
		return map.noticeDelete(vo);
	}

}
