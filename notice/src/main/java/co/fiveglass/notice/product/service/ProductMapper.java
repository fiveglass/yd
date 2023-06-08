package co.fiveglass.notice.product.service;

import java.util.List;

public interface ProductMapper {
	List<ProductVO> productSelectList();
	//여러건을 받아오려면 조건을 넣어야함
	//select는 ProductVO인 이유는 데이터를 받아와야 하기 때문이고,
	//나머지는 잘 들어갔는지만 확인하면 되서 int값 반환
	ProductVO productSelect(ProductVO vo);
	int productInsert(ProductVO vo);
	int productUpdate(ProductVO vo);
	int productDelete(ProductVO vo);
}
