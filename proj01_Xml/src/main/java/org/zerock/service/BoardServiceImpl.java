package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		
		//보드 서비스는 보이드 타입
		//예외처리 위해서는 int로 변형가능 꼭 숙지해놓자
		
		log.info("register ...... " +board);
		mapper.insertSelectKey(board);
		
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get........" + bno); //게시물의 번호가 파라미터 리턴해준다.
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("Modify........" + board); //해당 게시물을 풀력하고 고쳤는지 결과를 TF로 알려준다.
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove........" + bno); //게시물의 번호를 출력하고 삭제했는지 알려준다.
		return mapper.delete(bno)==1;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("getList................................");
		//리스트 가져오기
		return mapper.getList();
	}
	
	
}
