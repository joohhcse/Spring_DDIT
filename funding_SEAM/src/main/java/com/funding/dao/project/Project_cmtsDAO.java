package com.funding.dao.project;

import java.sql.SQLException;
import java.util.List;

import com.funding.dto.Project_cmtsVO;

public interface Project_cmtsDAO {
	
	public void insertReply(Project_cmtsVO project_cmts)throws SQLException;
	public void updateReply(Project_cmtsVO project_cmts)throws SQLException;
	public void deleteReply(int pjt_cmts_num)throws SQLException;
	
	public List<Project_cmtsVO> selectReplyList(int pjt_num)throws SQLException;
	
	public void updateAllBlindCancle(int pjt_num)throws SQLException;
	public void updateBlind(int pjt_cmts_num)throws SQLException;
}
