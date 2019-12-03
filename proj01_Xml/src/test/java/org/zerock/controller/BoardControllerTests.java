package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	//junit으로 테스트를 하니 추가한다.
@WebAppConfiguration 	//컨트롤러 테스트 용으로 추가한다.
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class BoardControllerTests {

	@Setter(onMethod_= {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	//짭 mvc를 만들어서 콘트롤러가 실행되게 한다.
	
	
	@Before// 모든 테스트 전에 매번 실행되는 메소드 
	public void setup() {
		this.mockMvc =MockMvcBuilders.webAppContextSetup(ctx).build();
		
	}
	
	@Test
	public void testList()throws Exception{
		
		log.info(
					mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
						).andReturn().getModelAndView().getModelMap());
				
	}

	@Test
	public void testRegister()throws Exception{
		
		String resultPage 
			=mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title","테스트 새글 제목")
				.param("content", "테스트 새글 내용")
				.param("writer","user00")
				).andReturn().getModelAndView().getViewName();
		
		log.info(
				resultPage);
		
	}

	@Test
	public void testModify()throws Exception{
		
		String resultPage 
		=mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
				.param("bno","1")
				.param("title", "수정된 테스트 새 글의 제목")
				.param("content", "수정된 테스트 새 글 내용")
				.param("writer","user00")
				).andReturn().getModelAndView().getViewName();
		
		log.info(
				resultPage);
		
	}

	@Test
	public void testGet()throws Exception{
				
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
						.param("bno","2")
						).andReturn()
				.getModelAndView().getModelMap());
		//특정 게시물을 조회하기 위해서는 bno가 필요하다.
	}

	@Test
	public void testRemove()throws Exception{
		
		//삭제하기전에 게시물 번호가 존재하는지 체크해야함
		String resultPage 
		=mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("bno","14")
				).andReturn().getModelAndView().getViewName();
		
		log.info(
				resultPage);
	}
	
	
	
}
