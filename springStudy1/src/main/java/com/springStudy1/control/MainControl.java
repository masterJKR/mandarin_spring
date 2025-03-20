package com.springStudy1.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControl {
	
	@GetMapping("/test") // localhost/test
	public String testPage() {
		System.out.println(" 와  진짜 실행 된다....  한글 좋아...");
		return "hello.html";
	}
}


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



