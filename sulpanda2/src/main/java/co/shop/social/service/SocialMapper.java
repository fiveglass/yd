package co.shop.social.service;

import java.util.List;

public interface SocialMapper {
	List<SocialVO> socialSelectList();
	SocialVO socialSelect(SocialVO vo);
	int socialInsert(SocialVO vo);
	int socialUpdate(SocialVO vo);
	int socialDelete(SocialVO vo);
}
