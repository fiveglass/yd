package co.shop.mapper;

import java.util.List;

import co.shop.model.CartDTO;

public interface CartMapper {

		//카트 추가
		public int addCart(CartDTO cart);
		//cart table의 열을 추가하는 메서드
		//member_id, product_id, product_count 값을 한번에 묶어 CartDTO를 
		//파라미터 변수로 선언, 반환값 int : 열 추가 성공 시 1, 실패시 0 반환
		
		
		//카트 삭제
		public int deleteCart(int cart_id);
		
		
		//카드 수량 변경
		public int modifyCount(CartDTO cart);
		//어떤 열인지, cart_id와 몇개의 수량으로 변경할 지에 대한 product_count 요함
		//성공여부를 알기위해 int로 지정
		
		
		//카트 목록
		public List<CartDTO> getCart(String member_id);
		//cart에서 지정한 모든 회원의 열을 갖고오는 메소드
		//어떤 회원인지 정보를 알아야 하기에 String 타입 변수
		//반환 타입은 여러개의 장바구니 데이터 반환 받아야 해서 List<CartDTO>로 지정 
		
		//카트 확인
		public CartDTO checkCart(CartDTO cart);
		//member_id, product_id를 한번에 넘겨 열이 존재하는 지 확인
		
	
}
