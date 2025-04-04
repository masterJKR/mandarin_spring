package com.talk.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Value("${uploadPath}")
	String uploadPath;
	
	// 실제 업로드경로와 웹에서 사용하는 경로(주소)를 연결 , 실제 업로드경로는 웹에서
	//  사용할수 없는 경로이기때문에  웹용으로 /files 를 쓰겠다 라고 등록
	// 웹에서  /files/12445.jpg 라는 이미지 요청이 들어오면
	// 실제경로는  c:/talkimage/12445.jpg의 이미지를 제공한다.
	
	@Override
	public void addResourceHandlers( ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/files/**")
				.addResourceLocations(uploadPath);
	}
	
	// WebMvcConfigurer 인터페이스는 
	// Spring MVC 설정을 사용자(개발자)정의 하기 위해 사용한다.
	// - 리소스 핸들러 설정 : 정적 리소스( css, javascript, 이미지, 파일 등)
	//      에 대한 경로를 설정 하고 캐싱정책을 을 적용 한다.
	//  - CORS : cross-origin resourece sharing 
	//            다른 도메인(주소-url)에서 현 재 도메이(주소-url)으로 API 요청 허용하
	//          도록 설정
	//  뷰 컨트롤러 등록 : URL요청에 대해 뷰이름을 직접 매핑, 
	//                  컨트롤러 없이 뷰를 반환 할수 있음
	//   경로 패턴 설정 :  URL 경로 패턴을 설정

}
