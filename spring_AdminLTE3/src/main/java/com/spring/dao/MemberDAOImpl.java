package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.spring.dto.MemberVO;
import com.spring.request.SearchCriteria;

public class MemberDAOImpl implements MemberDAO {
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<MemberVO> selectMemberList() throws SQLException {
		List<MemberVO> memberList = sqlSession.selectList("Member-Mapper.selectMemberList", null);
		return memberList;
	}
	
	public List<MemberVO> selectMemberList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);

		List<MemberVO> memberList = null;
		
		memberList=sqlSession.selectList("Member-Mapper.selectSearchMemberList",
						cri,rowBounds);

		return memberList;
	}
	
	public int selectMemberListCount() throws SQLException {
		int count = sqlSession.selectOne("Member-Mapper.selectMemberListCount", null);
		return count;
	}
	
	public int selectMemberListCount(SearchCriteria cri) throws SQLException {
		int count=0;		
		count=sqlSession.selectOne("Member-Mapper.selectSearchMemberListCount",cri);
		return count;
	}
	
	public MemberVO selectMemberById(String id) throws SQLException {
		MemberVO member=sqlSession.selectOne("Member-Mapper.selectMemberById",id);			
		return member;
	}
	
	public void insertMember(MemberVO member) throws SQLException {
		sqlSession.update("Member-Mapper.insertMember",member);
	}
	
	public void updateMember(MemberVO member) throws SQLException {
		sqlSession.update("Member-Mapper.updateMember",member);
	}
	
	public void deleteMember(String id) throws SQLException {
		sqlSession.update("Member-Mapper.deleteMember",id);
	}
	
	public void disabledMember(String id) throws SQLException {
		sqlSession.update("Member-Mapper.disabledMember",id);
	}
	
	public void enabledMember(String id) throws SQLException {
		sqlSession.update("Member-Mapper.enabledMember",id);
	}
		
	
}







