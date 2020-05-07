package com.spring.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.command.FileUploadCommand;
import com.spring.exception.EmptyMultipartFileException;
import com.spring.exception.OverflowFileSizeException;
import com.spring.utils.FileUpload;

@Controller
public class FileUploadController {
	
	@RequestMapping("/fileUploadForm")
	public void form() {}
	
	//issue는 ***파라미터*** 
	
	@RequestMapping(value = "/multipartFile", method = RequestMethod.POST)
	public String uploadByMultipartFile(String title,
										@RequestParam("file") MultipartFile multi,
										HttpServletRequest request,
										Model model) throws Exception {
//		System.out.println(title);
//		System.out.println(multi.getOriginalFilename());
//		System.out.println("size : " + multi.getSize() + " byte");
		
		String url = "fileUpload_success";
		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
		
		try {
			File uploadFile = FileUpload.saveFile(multi,request);
			
			model.addAttribute("title", title);
			model.addAttribute("originalFileName", multi.getOriginalFilename());
			model.addAttribute("uploadedFileName", uploadFile.getName());
			model.addAttribute("uploadPath", uploadFile.getAbsolutePath());
			
		} catch (EmptyMultipartFileException | OverflowFileSizeException e) {
			e.printStackTrace();
//			out.println("<script>alert('파일이 없습니다.!');</script>");
//			out.println("<script>history.go(-1);</script>");
			model.addAttribute("exception", e);
			url = "fileUpload_fail";
		} 
//		catch(IOException e) {
//			url = "error/500_error";	//서버 에러 //control advice
//		}
		
		return url;
	
//		//파일 유뮤 확인
//		if(multi.isEmpty()) {
//			response.setContentType("text/html;charset=utf-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>alert('파일이 없습니다.');</script>");
//			out.println("<script>history.go(-1);</script>");
//			return null;
//		}
//		
//		//용량제한 5MB
//		if(multi.getSize() > 1024 * 1024 * 5) {
//			response.setContentType("text/html;charset=utf-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>alert('용량초과입니다!');</script>");
//			out.println("<script>history.go(-1);</script>");
//			return null;
//		}
		
	}
	
	@RequestMapping("multipartHttpServletRequest")
	public String uploadByMultipartHttpServletRequest(
			MultipartHttpServletRequest request,
			Model model) throws IOException {
		String url = "fileUpload_success";
		
		String title = request.getParameter("title");
		MultipartFile multi = request.getFile("file");
		
		try {
			File uploadFile = FileUpload.saveFile(multi,request);
			
			model.addAttribute("title", title);
			model.addAttribute("originalFileName", multi.getOriginalFilename());
			model.addAttribute("uploadedFileName", uploadFile.getName());
			model.addAttribute("uploadPath", uploadFile.getAbsolutePath());
			
		} catch (EmptyMultipartFileException | OverflowFileSizeException e) {
			e.printStackTrace();
//			out.println("<script>alert('파일이 없습니다.!');</script>");
//			out.println("<script>history.go(-1);</script>");
			model.addAttribute("exception", e);
			url = "fileUpload_fail";
		} 
		
		return url;
	}
	
	@RequestMapping(value = "/commandObject", method = RequestMethod.POST)
	public String uploadByCommandObject(FileUploadCommand command,
										HttpServletRequest request, 
										Model model) throws IOException {
		String url = "fileUplaod_success";
		MultipartFile multi = command.getFile();
		String title = command.getTitle();
		
		try {
			File uploadFile = FileUpload.saveFile(multi,request);
			
			model.addAttribute("title", title);
			model.addAttribute("originalFileName", multi.getOriginalFilename());
			model.addAttribute("uploadedFileName", uploadFile.getName());
			model.addAttribute("uploadPath", uploadFile.getAbsolutePath());
			
		} catch (EmptyMultipartFileException | OverflowFileSizeException e) {
			e.printStackTrace();
			model.addAttribute("exception", e);
			url = "fileUpload_fail";
		} 
		
		return null;
	}
	
}
