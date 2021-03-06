package com.funding.security;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import com.funding.controller.EmailSender;
import com.funding.dto.EmailVO;
import com.funding.dto.MemberVO;
import com.funding.service.MemberService;
import com.funding.util.NaverCaptchaKey;
import com.funding.util.NaverCaptchaResult;
import com.funding.util.TempKey;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

//	private static String stcKeys;

	public EmailSender mailSender;
	public void setEmailSender(EmailSender mailSender) {
		this.mailSender = mailSender;
	}
	
//	@Autowired
//	public EmailVO email;
//	public void setEmail(EmailVO email) {
//		this.email = email;
//	}
	
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	private RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();
	
	private String username;
	private String password;
		
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

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		String id = request.getParameter(username);
		String pw = request.getParameter(password);
		String url = "";

		clearAuthenticationAttributes(request);

		User user = (User) authentication.getDetails();

		MemberVO loginUser = user.getMemberVO();

		HttpSession session = request.getSession();

		try {
			//clear login fail count
			memberService.updateClearLoginFailCount(id);
			
			memberService.updateLoginLastDate(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String strDormantMember = null;
		try {
			strDormantMember = memberService.getDormantMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(strDormantMember != null) {
			url = "/commons/login_dormant";
			
			String uuid_key = TempKey.getKey(15, false);
			System.out.println("mem_email > " + id + " login uuid_key > " + uuid_key);
			
			try {
				memberService.updateUuidKey(uuid_key, id);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			EmailVO email = new EmailVO();
			email.setReceiver(id);	//수신자 메일주소
			email.setContent("안녕하세요 FUN SEAM DING 입니다.\n 인증키는 " + uuid_key + "입니다.");
			email.setSubject(id + "님 휴면계정 해제를 위한 인증 메일입니다.");
			
			try {
				mailSender.SendEmail(email);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
//			getRedirectStrategy().sendRedirect(request, response, url);
			request.getRequestDispatcher(url).forward(request, response);
		}


		if (session != null) {
			session.setAttribute("loginUser", loginUser);
			session.setMaxInactiveInterval(20 * 60); // second
			
//			try {
//				memberService.getMemberLoginLastDate(id);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
			
//			String redirectUrl = (String) session.getAttribute("prevPage");
//			if (redirectUrl != null) {
//
//				session.removeAttribute("prevPage");
//				getRedirectStrategy().sendRedirect(request, response, redirectUrl);
//			}
			super.onAuthenticationSuccess(request, response, authentication);
		}
		

		// //로그인 로그 작성
		// try {
		// writeLoginLog(request, response, loginUser);
		// } catch (Exception e) {
		// //e.printStackTrace();
		// writeLoginLog(loginUser.getMem_email());
		// }
		/*
		 * response.setContentType("text/html;charset=utf-8"); PrintWriter out =
		 * response.getWriter();
		 * 
		 * if(!user.isAccountNonLocked()) { out.println("<script>");
		 * out.println("alert('휴직상태로 권한이 일반사용자로 제한됩니다.');");
		 * out.println("location.href='/"+request.getContextPath()+"';");
		 * out.println("</script>"); } else { super.onAuthenticationSuccess(request,
		 * response, authentication); }
		 */
		/* super.onAuthenticationSuccess(request, response, authentication); */

	}

	private void writeLoginLog(HttpServletRequest request, HttpServletResponse response, MemberVO loginUser) throws Exception {

		if (loginUser == null)
			return;

		// 로그인 정보를 스트링으로 저장.
		String tag = "[login:user]";
		String log = tag + "," + loginUser.getMem_email() + "," + request.getRemoteAddr() + ","
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

		// 로그 파일 생성
		String savePath = "e:\\log";
		File file = new File(savePath);
		if (!file.exists()) {
			file.mkdirs();
		}

		String logFilePath = savePath + File.separator + "login_user_groupware_log.csv";
		BufferedWriter out = new BufferedWriter(new FileWriter(logFilePath, true)); // true : 이어서 쓰기 //false : 새로쓰기
		// BufferedWriter : 텍스트
		// 바이너리 형식 inputStream 사용

		// 로그를 기록
		out.write(log);
		out.newLine();

		out.close();
	}

	private void writeLoginLog(String log) {
		System.out.println("[LoginLog] 생성 실패 : " + new Date());
	}
	
	protected void resultRedirectStrategy(HttpServletRequest request, HttpServletResponse response, Authentication authentication) 
			throws IOException, ServletException {
        
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        
        if(savedRequest!=null) {
            String targetUrl = savedRequest.getRedirectUrl();
            redirectStratgy.sendRedirect(request, response, "");
        } else {
            redirectStratgy.sendRedirect(request, response, "");
        }
        
    }
	
}
