package co.shop.orderproduct.service.Impl;

import org.apache.ibatis.session.SqlSession;

import co.shop.common.DataSource;
import co.shop.orderproduct.service.OrderProductMapper;
import co.shop.orderproduct.service.OrderProductService;
import co.shop.orderproduct.service.OrderProductVO;

public class OrderProductServiceImpl implements OrderProductService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	OrderProductMapper map = sqlSession.getMapper(OrderProductMapper.class);
	
	
	@Override
	public int OrderProductInsert(OrderProductVO vo) {
		// TODO Auto-generated method stub
		return map.OrderProductInsert(vo);
	}

	

}
