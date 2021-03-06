package com.funding.service.project;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.funding.dao.project.Interest_pjtDAO;
import com.funding.dto.Interest_pjtVO;

public class Interest_pjtServiceImpl implements Interest_pjtService {
	
	@Autowired
	private Interest_pjtDAO interest_pjtDAO;
	public void setInterest_pjtDAO(Interest_pjtDAO interest_pjtDAO) {
		this.interest_pjtDAO = interest_pjtDAO;
	}

	@Override
	public void interestPjt(Interest_pjtVO interest_pjt) throws SQLException {
		interest_pjtDAO.insertInterestPjt(interest_pjt);
	}

	@Override
	public void interestPjtCancle(Interest_pjtVO interest_pjt) throws SQLException {
		interest_pjtDAO.deleteInterestPjt(interest_pjt);
	}

	@Override
	public Interest_pjtVO getInterestPjt(Interest_pjtVO interest_pjt) throws SQLException {
		Interest_pjtVO interestPjt = interest_pjtDAO.getInterestPjt(interest_pjt);
		return interestPjt;
	}

	@Override
	public void interestPjtCancleByIntPjtNum(Interest_pjtVO interest_pjt) throws SQLException {
		interest_pjtDAO.deleteInterestPjtByIntPjtNum(interest_pjt);
	}

}
