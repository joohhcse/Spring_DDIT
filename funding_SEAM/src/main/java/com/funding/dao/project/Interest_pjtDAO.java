package com.funding.dao.project;

import java.sql.SQLException;

import com.funding.dto.Interest_pjtVO;

public interface Interest_pjtDAO {
	
	public void insertInterestPjt(Interest_pjtVO interest_pjt)throws SQLException;
	public void deleteInterestPjt(Interest_pjtVO interest_pjt)throws SQLException;
	public void deleteInterestPjtByIntPjtNum(Interest_pjtVO interest_pjt)throws SQLException;
	public Interest_pjtVO getInterestPjt(Interest_pjtVO interest_pjt)throws SQLException;
	
}
