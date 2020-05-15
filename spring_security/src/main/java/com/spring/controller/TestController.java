package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

//	스프링 스큐리티는 인허가 단계로 되어잇고 
//	인허가는 url 규정에서 해준다
	
	
	//자바가 아니다... //스프링 시큐리티 지식적
//	xml form.xml...
//	literal string...
	
	
	@RequestMapping("/admin/main")
	public void adminMain() {}
	
	@RequestMapping("/manager/main")
	public void managerMain() {}
	
	@RequestMapping("/home/main")
	public void homeMain() {}
	
	@RequestMapping("/member/main")
	public void memberMain() {}

}
