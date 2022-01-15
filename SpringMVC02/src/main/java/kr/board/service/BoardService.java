package kr.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.board.domain.Board;
import kr.board.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
		public List<Board> boardListAjax() {
		List<Board> list = mapper.boardList();
		return list;
	}
	
	public void boardInsertAjax(Board vo) {
		mapper.boardInsert(vo);
	}
	public void boardContentUpdateAjax(Board vo) {
		mapper.boardContentUpdateAjax(vo);
	}
	public void boardDeleteAjax(int idx) {
		mapper.boardDelete(idx);
	}
	public void boardTWUpdateAjax(Board vo) {
		mapper.boardTWUpdateAjax(vo);
	}
	
	
}
