package com.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.MemberVO;
import com.spring.request.PageMaker;
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
	
	
}
