package com.talk.Dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSignUpDto {
	private String memberId;
	private String password;
	
	@NotBlank(message = "이름은 필수입니다.")
	private String name;
	
	@NotEmpty(message = "이메일은 필수입니다.")
	private String email;
	
	
	private String tel;
	
	
}


//   null ->  empty(true)  , blank(true)
//   ""   ->  empty(true) , blank(true)
//  "a"  ->  empty(false)  , blank(false)
//   " "   -> empty(false)  ,  blank(true)
//  "v aw  " -> empty(false)  , blank(false)











