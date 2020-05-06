package com.spring.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dto.MemberVO;
import com.spring.request.MemberModifyRequest;
import com.spring.request.MemberRegistRequest;
import com.spring.request.SearchCriteria;
import com.spring.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberActionController {

	@Autowired
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("list.do")
	public String list(SearchCriteria cri, Model model) throws Exception {
		String url = "member/list";
		
		Map<String, Object> dataMap = memberService.getMemberList(cri);
		
//		model.addAttribute("pageMaker", (PageMaker) dataMap.get("pageMaker"));
//		model.addAttribute("memberList", (List<MemberVO>) dataMap.get("memberList"));
		
		model.addAllAttributes(dataMap);
		
		return url;
	}
	
	@RequestMapping("detail.do")
	public String detail(String id, Model model) throws Exception {
		String url="/member/detail";
		
		MemberVO member = null;
		
		try {
			member = memberService.getMember(id);
		} catch (Exception e) {
			e.printStackTrace();
			url = "error/500_error";
		}
		
		model.addAttribute("member", member);
		
		return url;
	}
	
	@RequestMapping("regist.do")
	public String regist(MemberRegistRequest registReq,
						HttpServletResponse response) throws Exception {
		String url = null;
		
		MemberVO member = registReq.toMemberVO();
		
		try {
			memberService.regist(member);
		} catch (Exception e) {
			e.printStackTrace();
			url = "member/regist_fail";
		}
		
		return url;
	}
	
	@RequestMapping("registForm.do")
	public String registForm() throws Exception {
		String url = "member/regist";
		
		return url;
	}
	
	@RequestMapping("remove.do")
	public String remove(String id) throws Exception {
		String url = "member/remove_success";
		
		try {
			memberService.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return url;
	}
	
	@RequestMapping("modify.do")
	public String modify(MemberModifyRequest modifyReq,
						Model model,
						HttpServletRequest request,
						HttpServletResponse response) throws Exception {
		String url="member/modify_success";
		
		MemberVO member = modifyReq.toMemberVO();
		
		try {
			memberService.modify(member);
			
			HttpSession session = request.getSession();
			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			if(member.getId().equals(loginUser.getId())) {
				session.setAttribute("loginUser", member);
			}
		} catch (Exception e) {
			e.printStackTrace();
			url="member/modify_fail";
		}
		
//		request.setAttribute("id", id);
//		request.setAttribute("member", member);
		model.addAttribute("member", member);
		
		return url;
	}
	
	@RequestMapping("modifyForm.do")
	public String modifyForm(String id, Model model) throws Exception {
		String url="member/modify";
		
		MemberVO member = null;
		
		try {
			member = memberService.getMember(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("member", member);
		
		return url;
	}
	
}
