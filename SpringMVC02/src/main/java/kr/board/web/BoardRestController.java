package kr.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.board.domain.Board;
import kr.board.mapper.BoardMapper;
import kr.board.service.BoardService;

@RestController
public class BoardRestController {

	@Autowired
	private BoardService service;
	
	@RequestMapping("/boardListAjax.do")
	public List<Board> boardListAjax() {
		List<Board> list = service.boardListAjax();
		return list;
	}
	
	@RequestMapping("boardInsertAjax.do")
	public void boardInsertAjax(Board vo) {
		service.boardInsertAjax(vo);
	}
	@RequestMapping("boardContentUpdateAjax.do")
	public void boardContentUpdateAjax(Board vo) {
		service.boardContentUpdateAjax(vo);
	}
	@GetMapping("boardDeleteAjax.do")
	public void boardDeleteAjax(int idx) {
		service.boardDeleteAjax(idx);
	}
	@RequestMapping("boardTWUpdateAjax.do")
	public void boardTWUpdateAjax(Board vo) {
		service.boardTWUpdateAjax(vo);
	}
	
	
}
