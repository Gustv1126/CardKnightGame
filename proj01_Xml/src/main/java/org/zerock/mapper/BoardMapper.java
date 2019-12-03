package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	//@Select("select * from tbl_board where bno>0")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	public void insertSelectKey(BoardVO board);
	
	//read 처리
	public BoardVO read(Long bno);
	
	
	//delete 처리
	public int delete(Long bno);
	
	
	//update 처리
	public int update(BoardVO board);
	
	
}
