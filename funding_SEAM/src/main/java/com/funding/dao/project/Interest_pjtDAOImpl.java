package com.funding.dao.project;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.funding.dto.Interest_pjtVO;

public class Interest_pjtDAOImpl implements Interest_pjtDAO {
	
	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void insertInterestPjt(Interest_pjtVO interest_pjt) throws SQLException {
		sqlSession.update("Interest_pjt-Mapper.insertInterestPjt",interest_pjt);
	}

	@Override
	public void deleteInterestPjt(Interest_pjtVO interest_pjt) throws SQLException {
		sqlSession.update("Interest_pjt-Mapper.deleteInterestPjt",interest_pjt);

	}

	@Override
	public Interest_pjtVO getInterestPjt(Interest_pjtVO interest_pjt) throws SQLException {
		Interest_pjtVO InterestPjt = sqlSession.selectOne("Interest_pjt-Mapper.getInterestPjt",interest_pjt);
		return InterestPjt;
	}

	@Override
	public void deleteInterestPjtByIntPjtNum(Interest_pjtVO interest_pjt) throws SQLException {
		sqlSession.update("Interest_pjt-Mapper.deleteInterestPjtByIntPjtNum",interest_pjt);
	}

}
