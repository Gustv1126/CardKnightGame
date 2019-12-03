package org.zerock.controller;


import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	//방법1
	//137
	//@InitBinder: parameter binding(파라미터 수집), 
	//             스프링 컨트롤러에서 파라미터를 바인딩할때 자동으로 호출을 통해서 변환처리
	//               (예)화면에서  '2019-11-1' 전달된 데이터를 java.util.Date타입 변환시
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, 
//				new CustomDateEditor(df, false));
//	}
	
   
	@RequestMapping("")
	public void basic() {
	   log.info("basic----------------------");
   }
	
    @RequestMapping("/basic")
    public void basic2() {
    	log.info("basic-22222---------------------");
    }
    
    @RequestMapping("/basicOnlyGet")
    public void basicGet2() {
    	log.info("basic get only Get----------");
    }
    //130
    //Controller의 파라미터으 수집
    @RequestMapping("/ex01")
    public String ex01(SampleDTO dto) {
    	log.info(dto);
		return "ex01";
    	
    }
    
    
    //131
    //int타입으로 선언된 age가 자동으로 숫자변환
    //@RequestParam("name"): request에서 특정 파라미터의 값을 찾아 낼때 사용하는 @
    //@GetMapping(): 요청을 get방식으로 한경우
    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name,
    				   @RequestParam("age") int age				   
    		) {
    	//String age = request.getParameter("age");
        //int age2 = Integer.parseInt(age;)
    	
    	log.info("name"+name);
    	log.info("age"+age);
		return "ex02";	
    }
    //132
    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
    	log.info("ids: "+ ids);
    	return "ex02List";
    }
    
    //133
    @GetMapping("/ex02Array")
    public String ex02Array(@RequestParam("ids") String[] ids) {
    	log.info("Array ids: "+ Arrays.toString(ids));
    	return "ex02Array";
    }
    //134
    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list) {
    	log.info("list dtos: "+ list);
    	return "ex02Bean";
    }
    
    //137
    @GetMapping("/ex03")
    public String ex03(TodoDTO todo) {
    	log.info("todo: "+todo);
		return "ex03";
    	
    }
    
    //140
    //@ModelAttribute를 사용하지 않은 상태
    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, int page) {
    	log.info("dto: "+dto);
    	log.info("page: "+page);
    	return "/sample/ex04";
    	
    }
    //144
    //String Type
    //@ModelAttribute를 사용했을때
    //@@ModelAttribute(): 자동으로 해당 객체를 view에 전달하는 역할
    @GetMapping("/ex044")
    public String ex044(SampleDTO dto, @ModelAttribute("page") int page) {
    	log.info("dto: "+dto);
    	log.info("page: "+page);
    	return "/sample/ex04";
    	
    }
    
    //144
    //void type
    //return type이  void인경우:URL과 동일한 이름의 jsp의미: http://localhost:8080/sample/ex05.jsp
    //                      : return없음에도 기본경로(http://localhost:8080)에 sample/ex0t.jsp 찾아서 실행
    @GetMapping("/ex05")
    public void ex05() {
    	log.info("ex05---------");
    }
    
    
    
    //@ResponseBody: 리턴 타입이 HTTP의 응답메시지로 전송,메소드나 파라미터로 사용
    //               SpringMVC는 자동으로 브라우저에 JSON타입으로 객체를 변환해서 전달
    //144
    @GetMapping("/ex06")
    public @ResponseBody SampleDTO ex06() {
		log.info("/ex06------");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
    	
    	return dto;	
    }
    
    //148
    //@ResponseEntity:header+data를 View에 전달
    @GetMapping("/ex07")
    public ResponseEntity<String> ex07() {
		log.info("/ex07------");
    	//{"name":"홍길동"}  : json data 형식
		String msg="{\"name\":\"홍길동\"}";
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
    	return new ResponseEntity<>(msg,header,HttpStatus.OK);
    	
    }
    
    //150
    //fileUpload Get방식
    //void방식이므로 webapp/WEB-INF/views/sample/exUpload.jsp찾는다.(생략)
    @GetMapping("/exUpload")
    public void exUpload() {
    	log.info("/exUpload````````");
    }
    
    //152
  //fileUpload POST방식
    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files) {
    	files.forEach(file ->{  //MultipartFile:file
    		log.info("------------------");
    		log.info("name: "+file.getOriginalFilename());
    		log.info("size: "+file.getSize());
    		
    	});
    }
    
}




















