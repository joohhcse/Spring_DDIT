package com.funding.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.funding.dto.Project_ProposeVO;
import com.funding.dto.Thumb_upVO;
import com.funding.request.SearchCriteria;

public interface ProjectProposeService {
	
	Map<String, Object> getProposeList(SearchCriteria cri) throws SQLException;
	
	List<Project_ProposeVO> selectLikeDesc()throws SQLException;
	
	int nextSeq()throws SQLException;
	
	int selectMemberNum(String mem_name)throws SQLException;
	
	int selectEnabled(int pjtprp_num)throws SQLException;
	
	void insertPropose(Project_ProposeVO propose)throws SQLException;
	
	void updatePropose(Project_ProposeVO propose)throws SQLException;
	
	void deletePropose(int pjtprp_num)throws SQLException;
	
	void disabledPropose(int pjtprp_num)throws SQLException;
	
	void enabledPropose(int pjtprp_num)throws SQLException;
	
	void listDisabledPropose(int pjtprp_num)throws SQLException;
	
	void proposeLikePlusCnt(int pjtprp_num)throws SQLException;
	
	void proposeLikeMinusCnt(int pjtprp_num)throws SQLException;
	
	void successPropose(int pjtprp_num)throws SQLException;
	
	List<Thumb_upVO> selectLikeClick(int mem_num)throws SQLException;
	
	
	//조회수 증가하는 detail
	Project_ProposeVO selectProposeBy_num(int pjtprp_num)throws SQLException;
	
	//조회수 증가x(수정했을 때)
	Project_ProposeVO selectProposeBynum(int pjtprp_num)throws SQLException;
	
	Project_ProposeVO proposeByNum(int pjtprp_num)throws SQLException;
	
	
	Project_ProposeVO checkTodayRegist(int mem_num)throws SQLException;
	
	
}
