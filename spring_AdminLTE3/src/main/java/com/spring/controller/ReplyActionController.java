package com.spring.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dto.ReplyVO;
import com.spring.request.DeleteReplyRequest;
import com.spring.request.ModifyReplyRequest;
import com.spring.request.PageMaker;
import com.spring.request.RegistReplyRequest;
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
	
	@Autowired
	private MemberService memberService;

	
	//jsp방식
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
	
	//SPRING
//	@RequestMapping("list.do")
//	@ResponseBody //화면url으로 리턴 x, String로 리턴	//@ResponseBody 없으면 404뜸, 해당 jsp가 없으니까//jsp가 아니라 String을 붙여서 리턴한다//결론은 sitemesh만 제껴주면됨
//					//jackson-databind 와 사용	//jackson에서 map정보를 JSON 객체화 
//	public Map<String, Object> list(int bno, SearchCriteria cri) throws Exception {
//		
//		Map<String, Object> dataMap = replyService.getReplyList(bno, cri);
//		
//		return dataMap;
//	}

	@RequestMapping("list.do")
	@ResponseBody 
	public ResponseEntity<Map<String, Object>> list(int bno, SearchCriteria cri) throws Exception {
		
		ResponseEntity<Map<String, Object>> entity = null;
		
		try {
//			if(true) throw new SQLException("예외처리 테스트");
			
			Map<String, Object> dataMap = replyService.getReplyList(bno, cri);
			entity = new ResponseEntity<Map<String, Object>>(dataMap, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}

	//jackson역할 : json<->객체
	
	// 나갈때 : jackson > adapter(String 그대로 내보낼거)
	// 들어올때 : adapter > body (string)    
	@RequestMapping("regist.do")
	@ResponseBody
	public ResponseEntity<Integer> regist(@RequestBody RegistReplyRequest registReq) throws Exception {
		System.out.println(registReq.toString());
		
//		String result="";
		ResponseEntity<Integer> entity = null;
		
		ReplyVO reply = registReq.toReplyVO();
		
		try {
			replyService.registReply(reply);

			//Exception text code
//			if(true) throw new SQLException();
			
			Map<String,Object> dataMap = replyService.getReplyList(registReq.getBno(),new SearchCriteria());
			PageMaker pageMaker = (PageMaker)dataMap.get("pageMaker");
			int realEndPage = pageMaker.getRealEndPage();
			
			dataMap.put("realEndPage", pageMaker.getRealEndPage());
//			result="SUCCESS,"+realEndPage;
			entity = new ResponseEntity<Integer>(realEndPage, HttpStatus.OK);	//Map<String, Object> <- dataMap // 
		}
		catch(SQLException e) {
			e.printStackTrace();
//			result="FAIL,1";
			entity = new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
//		return result;
		return entity;
	}
	
//	@RequestMapping("modify.do")
//	@ResponseBody
//	public String modify(@RequestBody ModifyReplyRequest modifyReq) throws Exception {
//		String result="";
//
//		ReplyVO reply = modifyReq.toReplyVO();
//
//		try {
//			replyService.modifyReply(reply);
//			result="SUCCESS";
//		} catch (Exception e) {
//			e.printStackTrace();
//			result="FAIL";
//		}
//		
//		return result;
//	}

	@RequestMapping("modify.do")
	@ResponseBody
	public ResponseEntity<String> modify(@RequestBody ModifyReplyRequest modifyReq) throws Exception {
//		String result="";
		ResponseEntity<String> entity = null;

		ReplyVO reply = modifyReq.toReplyVO();

		try {
			replyService.modifyReply(reply);
//			result="SUCCESS";
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
//			result="FAIL";
		}
		
//		return result;
		return entity;
	}
	
//	@RequestMapping("remove.do")
//	@ResponseBody
//	public String remove(@RequestBody DeleteReplyRequest removeReq) throws Exception {
//		String result="";
//		
//		try {
//			replyService.removeReply(removeReq.getRno());
//
//			SearchCriteria cri = new SearchCriteria();
//
//			Map<String, Object> dataMap = replyService.getReplyList(removeReq.getBno(), cri);
//			PageMaker pageMaker = (PageMaker) dataMap.get("pageMaker");
//			int page = removeReq.getPage();
//			int realEndPage = pageMaker.getRealEndPage();
//			if (page > realEndPage) {
//				page = realEndPage;
//			}
//			result = "SUCCESS," + page;
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//			result = "Fail,1";
//		}
//		
//		return result;
//	}
	
	@RequestMapping("remove.do")
	@ResponseBody
	public ResponseEntity<Integer> remove(@RequestBody DeleteReplyRequest removeReq) throws Exception {
//		String result="";
		ResponseEntity<Integer> entity = null;
		
		try {
			replyService.removeReply(removeReq.getRno());

			SearchCriteria cri = new SearchCriteria();

			Map<String, Object> dataMap = replyService.getReplyList(removeReq.getBno(), cri);
			PageMaker pageMaker = (PageMaker) dataMap.get("pageMaker");
			int page = removeReq.getPage();
			int realEndPage = pageMaker.getRealEndPage();
			if (page > realEndPage) {
				page = realEndPage;
			}
			entity = new ResponseEntity<Integer>(page, HttpStatus.OK);
		}
		catch (SQLException e) {
			e.printStackTrace();
//			result = "Fail,1";
			entity = new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
//		return result;
		return entity;
	}
	
	
	
	
	
	
}
