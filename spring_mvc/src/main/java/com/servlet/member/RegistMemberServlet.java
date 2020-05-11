package com.servlet.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.request.member.RegistMemberRequest;

//@WebServlet("/member/regist")
public class RegistMemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/member/regist.jsp";
		System.out.println("RegistMemberServlet doGet()");
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="https://www.ddit.or.kr";
		System.out.println("RegistMemberServlet doPost()");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		RegistMemberRequest registReq = new RegistMemberRequest();
		registReq.setId(id);
		registReq.setPassword(password);
		registReq.setName(name);
		registReq.setEmail(email);
		registReq.setPhone(phone);
		
		System.out.println(registReq.toString());		// 
		
		// MemberVO member = registReq.toMemberVO();
		// try{
		// memberService.regist(member);
		// }
		// catch(SQLException e) {
		// url = "error/500_error";
		// }
		
		
		
		
		response.sendRedirect(url);
	}

}
