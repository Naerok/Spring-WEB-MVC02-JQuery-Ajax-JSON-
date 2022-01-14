package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import kr.board.domain.Board;

public interface BoardMapper {
	public List<Board> boardList();
	public void boardInsert(Board vo); //SQL(insert~)
	public Board boardContent(int idx); //SQL(select ~ where idx=8)\
	
	@Delete("delete from board where idx=#{idx}")
	public void boardDelete(int idx); //SQL(delete)
	
	public void boardUpdate(Board vo); //SQL(update~)
	
	@Update("update board set contents=#{contents} where idx=#{idx}")
	public void boardContentUpdateAjax(Board vo);
	
	@Update("update board set title=#{title}, writer=#{writer} where idx=#{idx}")
	public void boardTWUpdateAjax(Board vo);
	
}
