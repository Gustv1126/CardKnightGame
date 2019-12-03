package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	// 맵퍼의 위치가 어디서 사용되는지는 모르겠지만 정해진 위치가 아니면 인식을 못하고 오류가 난다.
	// zerock 에 넣었더니 오류남

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Test
	public void testGetList() {
		log.info("--------------getList -------------- ");
		mapper.getList().forEach(board -> log.info(board));
		log.info("--------------getList END-------------- ");
	}

//	@Test
//	public void testInsert() {
//		// bno null로 저장됨
//		log.info("--------------INSERT-------------- ");
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글");
//		board.setContent("새로 작성하는 글");
//		board.setWriter("newbie-zang");
//
//		mapper.insert(board);
//
//		log.info(board);
//
//	}
	
	
//	@Test
//	public void testInsertSelectkey() {
//
//		log.info("--------------SelectKey-------------- ");
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글 select key");
//		board.setContent("새로 작성하는 글 select key");
//		board.setWriter("newbie-zang");
//
//		mapper.insertSelectKey(board); // 이부분도 다르다.
//
//		log.info(board);
//		
//		log.info("--------------SelectKeyEND-------------- ");
//	}

	@Test
	public void testRead() {
		log.info("--------------READ -------------- ");
		// 존재하는 게시물 번호 테스트
		BoardVO board = mapper.read(5L);
		log.info(board);
	}

	
//	
//	@Test
//	public void testDelete() {
//
//		log.info("delete count: " + mapper.delete(3L)); //3번 삭제
//	}
	
	
	@Test
	public void testUpdate() {
		BoardVO board =new BoardVO();
		//실제하는 번호인지 확인할것
		log.info("--------------UPDATE -------------- ");
		board.setBno(5L);
		board.setContent("수정된 제목");
		board.setTitle("수정된 내용");
		board.setWriter("user-Oldbie");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT : " + count);
		
	}

}
