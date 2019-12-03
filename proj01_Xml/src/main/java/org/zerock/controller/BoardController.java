package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller	//빈으로 인식
@Log4j	//로그 확인용 
@RequestMapping("/board/*")	//board로 시작되는 모든처리를 이 컨트롤러가 하도록 한다.
@AllArgsConstructor  //생성자 생성용 이거 아니면 온메소드 옽 와이어드 쓰자
public class BoardController {
	
	
	private BoardService service;
	
	
	//게시물 목록 전달
	@GetMapping("/list")
	public void list(Model model) {
		
		log.info("list");
		model.addAttribute("list",service.getList());
	}

	//입력 페이지를 보여주는 역할만 한다.
	@GetMapping("/register")
	public void register() {
		
	}
	
	//조회
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno,Model model) {
		
		log.info("/get");
		model.addAttribute("board",service.get(bno));
	}

	//등록처리
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		log.info("register : "+ board);
		service.register(board);
		rttr.addFlashAttribute("result",board.getBno());
		
		return "redirect:/board/list";
		
		//등록 작업이 끝난후에 다시 목록 화면으로 이동하기 위해서 스트링으로 받는다.
		//리다이엑트란 접두어를 이용하면 알아서 스프링에서는 샌드 리다이렉트를 해준다.
		
	}
	
	//수정처리
	@PostMapping("/modify")//수정하는 화면들어갈때는 get이지만 수정을 하고나서는 보안을 위해 post로 변경
	public String modify(BoardVO board, RedirectAttributes rttr) {
		
		log.info("modify : "+ board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result","success");	
		}

		return "redirect:/board/list";
		
		//등록 작업이 끝난후에 다시 목록 화면으로 이동하기 위해서 스트링으로 받는다.
		//리다이엑트란 접두어를 이용하면 알아서 스프링에서는 샌드 리다이렉트를 해준다.
		
	}
	
	//삭제처리
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		
		log.info("remove .....  "+ bno);
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result","success");	
		}
		
		return "redirect:/board/list";
		
		//삭제 작업이 끝난후에 다시 목록 화면으로 이동하기 위해서 스트링으로 받는다.
		//리다이엑트란 접두어를 이용하면 알아서 스프링에서는 샌드 리다이렉트를 해준다.
		
	}
	
	
}
