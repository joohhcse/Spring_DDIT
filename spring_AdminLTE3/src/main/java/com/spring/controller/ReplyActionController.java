package com.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.request.SearchCriteria;
import com.spring.service.MemberService;
import com.spring.service.ReplyService;


//url : /replies
///replies/all/{bno}		list : GET방식, bno번 게시글의 댓글 목록
///replies/{rno}			modify : PUT,PATCH방식, rno 댓글의 수정 
///replies/{rno}			remove : DELETE 방식, rno 댓글의 삭제
///replies 					regist : POST 방식 : 댓글 입력
///replies/{bno}/{page} 	page list: GET방식 
//bno번 게시글의 페이징 처리된 댓글 목록

@Controller
@RequestMapping("/replies/*")
public class ReplyActionController {

	@Autowired
	private ReplyService replyService;// = ReplyServiceImpl.getInstance();
	public void setReplyService(ReplyService replyService) {
		this.replyService=replyService;
	}
	
//	@RequestMapping("list.do")
//	public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		int bno = Integer.parseInt(request.getParameter("bon"));
//		int page = Integer.parseInt(request.getParameter("page"));
//		
//		SearchCriteria cri = new SearchCriteria();
//		cri.setPage(page);
//		cri.setPerPageNum(10);
//		
//		try {
//			Map<String,Object> dataMap = replyService.getReplyList(bno, cri);
//			
//			ObjectMapper mapper=new ObjectMapper();
//			
//			response.setContentType("application/json;charset=utf-8");
//			PrintWriter out=response.getWriter();
//			
//			out.println(mapper.writeValueAsString(dataMap));
//			
//			out.close();
//		} catch (SQLException e) {			
//			e.printStackTrace();
//		}
//	}
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("list.do")
	@ResponseBody //화면url으로 리턴 x, String로 리턴	//@ResponseBody 없으면 404뜸, 해당 jsp가 없으니까//jsp가 아니라 String을 붙여서 리턴한다//결론은 sitemesh만 제껴주면됨
	public Map<String, Object> list(int bno, SearchCriteria cri) throws Exception {
		
		Map<String, Object> dataMap = replyService.getReplyList(bno, cri);
		
		return dataMap;
	}
	
	
}
