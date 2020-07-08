package com.funding.security;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.funding.dto.MemberVO;
import com.funding.service.MemberService;
import com.funding.util.NaverCaptchaKey;


public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler  {

	private static String stcKeys;
	
	private String username;
	private String password;
	private String errormsgname;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getErrormsgname() {
		return errormsgname;
	}
	public void setErrormsgname(String errormsgname) {
		this.errormsgname = errormsgname;
	}
	public MemberService getMemberService() {
		return memberService;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Autowired
	private MemberService memberService;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
										HttpServletResponse response,
										AuthenticationException exception) throws IOException, ServletException {
		request.setAttribute("msg",exception.getMessage());
//		request.setAttribute("msg", "아이디 혹은 패스워드가 일치하지 않습니다.");
//		request.setAttribute("msg", "onAuthenticationFailure");
		System.out.println("로그인 실패하면 여기 타나??");
		
		String url = "/commons/loginFail";
		String id = request.getParameter(username);
		String pw = request.getParameter(password);
		int loginFailCnt = 0;
		String errormsg = exception.getMessage();
		
		
		if(errormsg != null || !errormsg.equals("")) {
			switch(errormsg) {
			case "미가입회원":
			case "승인대기중":
				url = "/commons/loginFail";
				break;
				
			case "비밀번호오류":
				
				url = "/commons/loginFail";
				try {
					memberService.updatePlusLoginFailCount(id);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					loginFailCnt = memberService.getLoginFailCount(id);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				if(loginFailCnt > 4) {
//					url = "/commons/login_capcha";
					url = "/commons/loginFormWithCapcha";
					request.setAttribute("mem_email", id);
				}
				break;
			default :
				url = "redirect:/commons/loginForm";
				break;
			}
			
//			errormsg += "\n 로그인 실패 횟수 : " + loginFailCnt;

			request.setAttribute("errormsg", errormsg);
			request.setAttribute("loginFailCnt", loginFailCnt);
			request.getRequestDispatcher(url).forward(request, response);

		}
		
//		if(exception instanceof BadCredentialsException) {
//			try {
//				memberService.updatePlusLoginFailCount(id);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		
//		int loginFailCnt = 0;
//		try {
//			loginFailCnt = memberService.getLoginFailCount(id);
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		
//		if(loginFailCnt > 4) {
//			url = "/commons/login_capcha";
//			
//			request.setAttribute("mem_email", id);
//			
//			request.getRequestDispatcher(url).forward(request, response);	//ward
//			return;
//		}
		
		super.onAuthenticationFailure(request, response, exception);
		
	}
/*	
    protected void loginFailureCount(String mem_email) {
    	memberService.updatePlusLoginFailCount(mem_email);
    	
    	String message=null;
		MemberVO loginUser = null;
		int loginFailCnt = 0;
		loginFailCnt = memberService.getLoginFailCount(mem_email);
		
		if(loginFailCnt > 4) {
			url = "commons/login_capcha";
			
			String naverid = "CdDmuUEG8PE0B6pdNVZl";
			String naverkey = "PR1202TAvY";

			String key = NaverCaptchaKey.keyGo(naverid, naverkey);

			int idx = key.indexOf(":");
			int idx2 = key.lastIndexOf("}");

			String keys = key.substring(idx + 2, idx2 - 1);
			System.out.println(keys);
			stcKeys = keys;
			request.setAttribute("keys", keys);
    }*/


}
