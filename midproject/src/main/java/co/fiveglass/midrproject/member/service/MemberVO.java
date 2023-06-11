package co.fiveglass.midrproject.member.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberAddr;
	private String memberBirth;
	private String memberTel;
	private String memberGrade;
	private String memberType;
	private String memberAccsseToken;
	private String memberRefreshToken;
}
