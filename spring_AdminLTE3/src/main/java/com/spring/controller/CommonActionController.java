package com.spring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.MemberVO;
import com.spring.exception.InvalidPasswordException;
import com.spring.exception.NotFoundIDException;
import com.spring.service.MemberService;

@Controller
@RequestMapping("/commons/*")
public class CommonActionController {
	
	@Autowired
	private MemberService memberService;// = MemberServiceImpl.getInstance();
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(value = "login.do ", method = RequestMethod.POST)
	public String loginPost(String id, String pwd, 
							HttpServletRequest request,
							HttpSession session) {
		String url = "redirect:/member/list.do";
		
		// 로그인 실패시 추가한 attribute 를 삭제.
		session.removeAttribute("msg");
		
		String message=null;
		try {
			memberService.login(id, pwd);
			
			MemberVO loginUser=memberService.getMember(id);			
			if(loginUser.getEnabled()==0) { //사용정지
				message="사용중지된 아이디로 이용이 제한됩니다.";
				url="redirect:/commons/loginForm.do";
			}else{ // 사용가능
				session.setAttribute("loginUser", loginUser);
				session.setMaxInactiveInterval(60*6);
			}
			
		} catch (NotFoundIDException e) {
			message="아이디가 존재하지 않습니다.";			
			url="redirect:login";			
		} catch (InvalidPasswordException e) {
			message="패스워드가 일치하지 않습니다.";
			url="redirect:login";
		} catch (SQLException e) {
			e.printStackTrace();
			message="시스템장애로 로그인이 불가합니다.";	
			url="redirect:login";
		}
		
		session.setAttribute("msg",message);
		session.setAttribute("id",id);
		
		return url;
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) throws Exception {
		String url="redirect:/commons/loginForm.do";
		HttpSession session = request.getSession();
		session.invalidate();
		
		return url;
	}
	
	@RequestMapping("loginForm.do")
	public String loginForm() throws Exception {
		String url="commons/loginForm";
		
		return url;
	}
	

	
	
	
}
