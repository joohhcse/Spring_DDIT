package com.spring.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.utils.FileUpload;

@Controller
public class AjaxFileUploadController {

	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping("/ajaxFileUploadForm")
	public void ajaxFileUploadForm() {}
	
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST,
					produces = "text/plain;charset=utf-8")	//한글깨짐 방지 : produces = "text/plain;charset=utf-8"
	@ResponseBody
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
		
		ResponseEntity<String> entity=null;
		
		String sourcePath = null;
		
		sourcePath = FileUpload.uploadFile(file, uploadPath);
				
		entity = new ResponseEntity<String>(sourcePath, HttpStatus.CREATED);
		
		return entity;
	}
}
