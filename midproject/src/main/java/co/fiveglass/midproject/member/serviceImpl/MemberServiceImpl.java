package co.fiveglass.midproject.member.serviceImpl;

import org.apache.ibatis.session.SqlSession;

import co.fiveglass.midproject.common.DataSource;
import co.fiveglass.midrproject.member.service.MemberMapper;
import co.fiveglass.midrproject.member.service.MemberService;
import co.fiveglass.midrproject.member.service.MemberVO;

public class MemberServiceImpl implements MemberService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public int memberInsert(MemberVO vo) {
		
		return map.memberInsert(vo);
	}

}
