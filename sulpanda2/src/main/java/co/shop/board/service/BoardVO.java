package co.shop.board.service;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {

	private int boardId;
	private String memberId;
	private String boardTitle;
	private String boardContent;
	private Date boardDate;
	private int boardHit;
	private String boardSecret;
	private String boardRepleState;
	private int boardRepleId;
}
