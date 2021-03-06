package com.funding.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.funding.dto.ProjectProposeCmtVO;

public class ProposeCmtDAOImpl implements ProposeCmtDAO{
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<ProjectProposeCmtVO> selectReplyList(int pjtprp_num) throws SQLException {
		List<ProjectProposeCmtVO> list = sqlSession.selectList("Propose-Mapper.selectReplyList",pjtprp_num);
		return list;
	}

	@Override
	public void insertReply(ProjectProposeCmtVO proposeCmt) throws SQLException {
		sqlSession.update("Propose-Mapper.insertReply",proposeCmt);
		
	}

	@Override
	public int selectReplySeqNext() throws SQLException {
		int seq = sqlSession.selectOne("Propose-Mapper.selectReplySeqNext");
		return seq;
	}

	@Override
	public void disabledProposeCmt(int pjtprp_cmts_num) throws SQLException {
		sqlSession.update("Propose-Mapper.disabledProposeCmt",pjtprp_cmts_num);
		
	}

	@Override
	public void enabledProposeCmt(int pjtprp_cmts_num) throws SQLException {
		sqlSession.update("Propose-Mapper.enabledProposeCmt",pjtprp_cmts_num);
		
	}

	@Override
	public void modifyCmt(ProjectProposeCmtVO cmtVO) throws SQLException {
		sqlSession.update("Propose-Mapper.modifyCmt",cmtVO);
		
	}

	@Override
	public void deleteCmt(int pjtprp_cmts_num) throws SQLException {
		sqlSession.update("Propose-Mapper.deleteCmt",pjtprp_cmts_num);
		
	}

	@Override
	public int selectCmtCount(int pjtprp_num) throws SQLException {
		int count = sqlSession.selectOne("Propose-Mapper.selectCmtCount",pjtprp_num);
		return count;
	}
}
