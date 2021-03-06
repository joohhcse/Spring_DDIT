package com.funding.controller.project;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.funding.dto.Project_cmtsVO;
import com.funding.service.project.Project_cmtsService;

@Controller
@RequestMapping("/pjtReplies")
public class ProjectReplyController {
	@Autowired
	private Project_cmtsService project_cmtsService;
	
	@RequestMapping(value = "/{pjt_num}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("pjt_num") int pjt_num)throws SQLException {
		ResponseEntity<Map<String, Object>> entity = null;


		try {
			Map<String, Object> dataMap = project_cmtsService.replyList(pjt_num);
			entity = new ResponseEntity<Map<String, Object>>(dataMap, HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return entity;
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> regist(@RequestBody Project_cmtsVO project_cmts)throws SQLException{
		ResponseEntity<String> entity = null;
		
		try {
			project_cmtsService.registReply(project_cmts);
			entity=new ResponseEntity<String>(HttpStatus.OK);
		}catch(SQLException e) {
			entity=new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	
	@RequestMapping(value="/{pjt_cmts_num}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> remove(@PathVariable("pjt_cmts_num") int pjt_cmts_num)throws Exception{
		
		ResponseEntity<String> entity=null;
		try{
			project_cmtsService.removeReply(pjt_cmts_num);
			entity=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}catch(SQLException e){
			e.printStackTrace();
			entity=new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/{pjt_cmts_num}", method = { RequestMethod.PUT, RequestMethod.PATCH })
	@ResponseBody
	public ResponseEntity<String> update(@RequestBody Project_cmtsVO project_cmts)  throws Exception {
		ResponseEntity<String> entity = null;
		
		try {
			project_cmtsService.modifyReply(project_cmts);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/enabled/{pjt_num}")
	@ResponseBody
	public ResponseEntity<String> enabled(@RequestBody Map<String,Object> map)throws Exception{
		ResponseEntity<String> entity=null;
		
		
		List<String> list = (List<String>) map.get("pjt_cmts_num");
		int pjtnum=Integer.parseInt((String) map.get("pjt_num"));
		
		
		try {
			project_cmtsService.enabled(pjtnum);
			
			for(int i=0;i<list.size();i++) {
				int pjtCmtsNum = Integer.parseInt((String)list.get(i).toString());
				System.out.println(pjtCmtsNum);
				
				project_cmtsService.enabledCancle(pjtCmtsNum);
			}
			
			entity=new ResponseEntity<String>(HttpStatus.OK);
		}catch(SQLException e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
}
