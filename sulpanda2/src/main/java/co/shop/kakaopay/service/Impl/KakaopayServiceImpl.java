package co.shop.kakaopay.service.Impl;

import org.apache.ibatis.session.SqlSession;

import co.shop.common.DataSource;
import co.shop.kakaopay.service.KakaopayMapper;
import co.shop.kakaopay.service.KakaopayService;
import co.shop.kakaopay.service.KakaopayVO;

public class KakaopayServiceImpl implements KakaopayService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	KakaopayMapper map = sqlSession.getMapper(KakaopayMapper.class);
	
	@Override
	public int kakaopayInsert(KakaopayVO vo) {
		// TODO Auto-generated method stub
		return map.kakaopayInsert(vo);
	}

	@Override
	public int depositInsert(KakaopayVO vo) {
		// TODO Auto-generated method stub
		return map.depositInsert(vo);
	}

	
}
