package kr.hanG.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.board.domain.Board;
import kr.board.mapper.BoardMapper;

@RestController
public class BoardRestController {

	@Autowired
	private BoardMapper mapper;
	
	@RequestMapping("/boardListAjax.do")
	public List<Board> boardListAjax() {
		List<Board> list = mapper.boardList();
		return list;
	}
	
	@RequestMapping("boardInsertAjax.do")
	public void boardInsertAjax(Board vo) {
		mapper.boardInsert(vo);
	}
	@RequestMapping("boardContentUpdateAjax.do")
	public void boardContentUpdateAjax(Board vo) {
		mapper.boardContentUpdateAjax(vo);
	}
	@GetMapping("boardDeleteAjax.do")
	public void boardDeleteAjax(int idx) {
		mapper.boardDelete(idx);
	}
	@RequestMapping("boardTWUpdateAjax.do")
	public void boardTWUpdateAjax(Board vo) {
		mapper.boardTWUpdateAjax(vo);
	}
	
	
}
