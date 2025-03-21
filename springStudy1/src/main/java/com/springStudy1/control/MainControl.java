package com.springStudy1.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springStudy1.DTO.School;
import com.springStudy1.service.SchoolService;

@Controller
public class MainControl {
	
	@Autowired
	private SchoolService schoolService;
	
	@GetMapping("/test") // localhost/test
	public String testPage() {
		System.out.println(" 와  진짜 실행 된다....  한글 좋아...");
		return "hello.html";
	}
	
	@GetMapping("/signIn")
	public String login() {
		return "signIn.html";
	}
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/list")
	public ModelAndView listPage(@RequestParam String type) {
		System.out.println(type);
		ModelAndView mav = new ModelAndView("list");
		//mav.setViewName("");
		
		// 클라이언트가 요청한 유치원, 초등학교, 중학교, 고등학교 에 대해 조회 하기 위해
		// service클래스 객체 에 넘겨주고  필요한 데이터를 받아서  뷰페이지와 함께 클라이언트에게전달
		
		List<School> list = schoolService.typeSelect(type);
		mav.addObject("list",list); // ModelAndView에 저장
		
		return mav;
	}
}

//  주소 :  http://localhost/signIn
//  뷰 페이지 :  signIn.html  
//        내용 : 아이디 , 비밀번호 입력 가능하게

/*
 	 컨트롤 클래스의 역할 지정 - @Controller 를 클래스 위에 넣기 
 	 
 	 클라이언트의 요청 처리
 	   GET 방식으로 주소 요청 들어온다면  @GetMapping
 	   POST방식으로 주소 요청 들어 온다면  @PostMapping
 	   
 	   @GetMapping(" 주소 ")   
 	      @GetMapping("/list") -> localhost/list 주소 요청 시 동작
 	      
 	   주소 요청시 실행 할 코드는  메서드로 표현 한다.
 	   @PostMapping("/save")
 	   public String boardSave(){
 	   		
 	   }
 	   -> localhost/save 주소가 post방식으로 요청 되는 경우 boardSave 메서드 실행
 */



