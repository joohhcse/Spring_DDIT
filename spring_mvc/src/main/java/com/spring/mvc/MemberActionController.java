package com.spring.mvc;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.request.member.RegistMemberRequest;

@Controller
@RequestMapping("/member/*")
public class MemberActionController {
	
	@RequestMapping(value="regist", method = RequestMethod.GET)
	public void regist_GET() throws Exception {}
	//url 값을 전달하는 역할 handler adaptor 가 함	
	
//	public String regist_GET() throws Exception {
//		String url = "member/regist";
//		System.out.println("regist_GET()");
//		return url;
//	}
	
	@RequestMapping(value="regist", method = RequestMethod.POST)
//	public String regist_POST(RegistMemberRequest registReq,String id, String password,	HttpServletRequest request, HttpServletRequest response,HttpSession session) throws Exception
	public String regist_POST(RegistMemberRequest registReq, @RequestParam(value="password") String pwd,
															 @RequestParam(defaultValue = "대전") String address,
															 @RequestParam(required = true) String authority) throws Exception {
		System.out.println("regist_POST()");
	
		System.out.println("MemberActionController regist_POST::" + registReq);
		String url = "redirect:https://www.naver.com";
		
//		System.out.println("id : " + id + ", password : " + password);
//		System.out.println(request);
//		System.out.println(response);
//		System.out.println(session);
//		//System.out.println(ctx);

		System.out.println(registReq);
		System.out.println(pwd);
		System.out.println(address);
		System.out.println(authority);
		
		return url;
	}
	
}
