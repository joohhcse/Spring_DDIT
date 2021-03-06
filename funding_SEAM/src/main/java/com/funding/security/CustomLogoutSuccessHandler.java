package com.funding.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.funding.dto.MemberVO;
import com.funding.service.MemberService;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request,
								HttpServletResponse response, 
								Authentication auth)	throws IOException, ServletException {
		 
		if (auth != null && auth.getDetails() != null) 
		{
			try {
				User user = (User) auth.getDetails();
				MemberVO loginUser = user.getMemberVO();

//				memberService.recentLoginTime(loginUser.getMem_email());
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		response.sendRedirect(request.getContextPath() + "/main");
	}

	
	
}
