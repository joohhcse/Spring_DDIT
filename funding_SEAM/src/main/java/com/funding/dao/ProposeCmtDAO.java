package com.funding.dao;

import java.sql.SQLException;
import java.util.List;

import com.funding.dto.ProjectProposeCmtVO;

public interface ProposeCmtDAO {
	List<ProjectProposeCmtVO> selectReplyList(int pjtprp_num)throws SQLException;
	
	int selectCmtCount(int pjtprp_num)throws SQLException;
	
	void insertReply(ProjectProposeCmtVO proposeCmt)throws SQLException;
	
	int selectReplySeqNext()throws SQLException;
	
	void disabledProposeCmt(int pjtprp_cmts_num)throws SQLException;
	
	void enabledProposeCmt(int pjtprp_cmts_num)throws SQLException;
	
	void modifyCmt(ProjectProposeCmtVO cmtVO)throws SQLException;
	
	void deleteCmt(int pjtprp_cmts_num)throws SQLException;
}
