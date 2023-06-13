package co.shop.board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.board.service.BoardService;
import co.shop.board.service.BoardVO;
import co.shop.board.service.Impl.BoardServiceImpl;
import co.shop.common.Command;

public class BoardList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		BoardService bs = new BoardServiceImpl();
		List<BoardVO> articles = bs.boardSelectList();
		
		return "board/boardList";
	}

}
