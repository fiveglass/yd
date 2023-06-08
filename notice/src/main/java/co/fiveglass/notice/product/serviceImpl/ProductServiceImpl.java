package co.fiveglass.notice.product.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.fiveglass.notice.common.DataSource;
import co.fiveglass.notice.product.service.ProductMapper;
import co.fiveglass.notice.product.service.ProductService;
import co.fiveglass.notice.product.service.ProductVO;

public class ProductServiceImpl implements ProductService {
	//SqlSession은 sql문 실행 역할을 해주기 때문에 불러줌
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	//매핑파일에서 실행할 sql을 가져와서 db에 sql을 실행해줌
	ProductMapper map = sqlSession.getMapper(ProductMapper.class);
	//datasource란? db 커낵션 관리(jdbc를 통해 sql접속하게 하는 객체)
	@Override
	public List<ProductVO> productSelectList() {
		
		return map.productSelectList();
	}

	@Override
	public ProductVO productSelect(ProductVO vo) {
		// TODO Auto-generated method stub
		return map.productSelect(vo);
	}

	@Override
	public int productInsert(ProductVO vo) {
		// TODO Auto-generated method stub
		return map.productInsert(vo);
	}

	@Override
	public int productUpdate(ProductVO vo) {
		// TODO Auto-generated method stub
		return map.productUpdate(vo);
	}

	@Override
	public int productDelete(ProductVO vo) {
		// TODO Auto-generated method stub
		return map.productDelete(vo);
	}

}
