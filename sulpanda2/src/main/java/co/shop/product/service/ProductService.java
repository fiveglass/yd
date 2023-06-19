package co.shop.product.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ProductService {
	List<ProductVO> getAllProducts(); // 전체상품조회
	List<ProductVO> searchProductsName(String productName); // 상품이름검색
	Integer productInsert(ProductVO vo);
	int productUpdate(ProductVO vo);
	int productDelete(ProductVO vo);

	List<ProductVO> recommendResult(@Param("productKind") String productKind, @Param("productTaste") String productTaste, @Param("productSparkling") String productSparkling); //추천상품 조회
	
}
