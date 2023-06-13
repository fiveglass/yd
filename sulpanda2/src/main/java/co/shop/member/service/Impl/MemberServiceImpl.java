package co.shop.member.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.shop.common.DataSource;
import co.shop.member.service.MemberMapper;
import co.shop.member.service.MemberService;
import co.shop.member.service.MemberVO;

public class MemberServiceImpl implements MemberService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	MemberMapper map = sqlSession.getMapper(MemberMapper.class);
	@Override
	public List<MemberVO> memberSelectList() {
		// TODO Auto-generated method stub
		return map.memberSelectList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberInsert(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberUpdate(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberDelete(vo);
	}

}
