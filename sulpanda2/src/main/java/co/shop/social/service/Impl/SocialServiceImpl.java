package co.shop.social.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.shop.common.DataSource;
import co.shop.social.service.SocialMapper;
import co.shop.social.service.SocialService;
import co.shop.social.service.SocialVO;

public class SocialServiceImpl implements SocialService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	SocialMapper map = sqlSession.getMapper(SocialMapper.class);

	@Override
	public List<SocialVO> socialSelectList() {
		// TODO Auto-generated method stub
		return map.socialSelectList();
	}

	@Override
	public SocialVO socialSelect(SocialVO vo) {
		// TODO Auto-generated method stub
		return map.socialSelect(vo);
	}

	@Override
	public int socialInsert(SocialVO vo) {
		// TODO Auto-generated method stub
		return map.socialInsert(vo);
	}

	@Override
	public int socialUpdate(SocialVO vo) {
		// TODO Auto-generated method stub
		return map.socialUpdate(vo);
	}

	@Override
	public int socialDelete(SocialVO vo) {
		// TODO Auto-generated method stub
		return map.socialDelete(vo);
	}

}
