package com.spring.controller;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.BoardVO;
import com.spring.request.ModifyBoardRequest;
import com.spring.request.PageMaker;
import com.spring.request.RegistBoardRequest;
import com.spring.request.SearchCriteria;
import com.spring.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardActionController {
	
	@Autowired
	private BoardService boardService;
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("list.do")
	public String list(SearchCriteria cri, Model model) throws Exception {
		String url="board/list.open";
		
		Map<String,Object> dataMap=boardService.getBoardList(cri);
		model.addAllAttributes(dataMap);
		
		return url;
	}
	
//	@RequestMapping("regist.do")
//	public String regist(Model model,
//						@RequestParam(value="title") String title,
//						@RequestParam(value="content") String content,
//						@RequestParam(value="writer") String writer,
//						HttpServletResponse response
//						) throws Exception {
//		String url = null;
//		
//		BoardVO board = new RegistBoardRequest(title, content, writer).toBoardVO();
//		
//		try {
//			boardService.write(board);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out=response.getWriter();
//		out.println("<script>");
//		out.println("window.opener.location.href='list.do';window.close();");
//		out.println("</script>");
//		
//		return url;
//	}
	
	@RequestMapping(value="regist.do",method=RequestMethod.POST)
	public void registPost(RegistBoardRequest registReq,
							 HttpServletResponse response)throws Exception{
		
		BoardVO board = registReq.toBoardVO();
		
		boardService.write(board);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("window.opener.location.href='list.do';window.close();");
		out.println("</script>");
		
	}
	
	@RequestMapping("registForm.do")
	public String registForm() throws Exception {
		String url = "board/registBoard.page";
		return url;
	}
	
	@RequestMapping("modifyForm.do")
	public String modifyForm(int bno,Model model)throws Exception{
		String url = "board/modifyBoard.open";
		
		BoardVO board = boardService.getBoard(bno);
		
		model.addAttribute("board",board);
		
		return url;				
	}

//	@RequestMapping(value="modify.do",method=RequestMethod.POST)
//	public String modifyPost(ModifyBoardRequest modifyReq,
//							 SearchCriteria cri)throws Exception{
//		String url="board/detail.do";
//		
//		PageMaker pageMaker = new PageMaker();
//		pageMaker.getCri();
//		
//		url=url+pageMaker.makeQuery();
//		
//		BoardVO board = modifyReq.toBoardVO();
//		
//		System.out.println("BAConn :: " + url);
//		
//		boardService.modify(board);
//		
//		return url;
//	}
	@RequestMapping(value="modify.do",method=RequestMethod.POST)
	public String modifyPost(ModifyBoardRequest modifyReq,
							 SearchCriteria cri)throws Exception{
		String url="redirect:board/detail.do";
						
		url=url+PageMaker.makeQuery(cri)+"&bno="+modifyReq.getBno();
		
		BoardVO board = modifyReq.toBoardVO();
		
		boardService.modify(board);
		
		return url;
	}
	
	@RequestMapping("remove.do")
	public void remove(int bno,HttpServletResponse response)throws Exception{
		boardService.remove(bno);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("alert('삭제되었습니다');");
		out.println("window.opener.location.reload(true);window.close();");
		out.println("</script>");	
	}
	
//	@RequestMapping("detail.do")
//	public String detail(@RequestParam(value="bno") int bno,
//						 Model model) throws Exception {
//		String url = "board/detailBoard";
//		
//		try {
//			BoardVO board = boardService.getBoard(bno);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			url = "error/500_error";
//		}
//				
//		return url;
//	}
	
	@RequestMapping("detail.do")
	public String detail(int bno, Model model) throws Exception{
		String url="board/detailBoard.open";
		
		BoardVO board = boardService.getBoard(bno);
		
		model.addAttribute("board",board);
		
		return url;
	}
	
}
