package com.funding.dao.project;

import java.sql.SQLException;
import java.util.List;

import com.funding.dto.Pjt_pay_detailVO;
import com.funding.request.MypagePaylistRequest;
import com.funding.request.PaylistSearchCriteria;
import com.funding.request.ProjectPayRequest;
import com.funding.request.SearchCriteria;

public interface Pjt_pay_detailDAO {

	public int selectPjtPaySum(int pjt_num)throws SQLException;
	
	public int selectBoardSeqNext()throws SQLException;
	
	public void insertPjtPay(Pjt_pay_detailVO pjt_pay_detail)throws SQLException;
	
	public List<ProjectPayRequest> selectPjtPayTableListByMemNum(SearchCriteria cri,int mem_num)throws SQLException;
	public int selectPjtPayTableListByMemNumCount(SearchCriteria cri,int mem_num)throws SQLException;
	
	public List<MypagePaylistRequest> selectPjtPayListByMemNum(SearchCriteria cri,int mem_num)throws SQLException;
	public int selectPjtPayListByMemNumCount(SearchCriteria cri,int mem_num)throws SQLException;

	public List<MypagePaylistRequest> selectPjtPayListForRefundByMemNum(SearchCriteria cri,int mem_num)throws SQLException;
	public int selectPjtPayListForRefundByMemNumCount(SearchCriteria cri,int mem_num)throws SQLException;
	
	public List<MypagePaylistRequest> selectPjtRefundListByMemNum(PaylistSearchCriteria cri,int mem_num)throws SQLException;
	public int selectPjtRefundListByMemNumCount(PaylistSearchCriteria cri,int mem_num)throws SQLException;

	public List<MypagePaylistRequest> selectPjtAllPayListByMemNum(PaylistSearchCriteria cri,int mem_num)throws SQLException;
	public int selectPjtAllPayListByMemNumCount(PaylistSearchCriteria cri,int mem_num)throws SQLException;

	public List<MypagePaylistRequest> selectSearchPjtAllPayListByMemNum(PaylistSearchCriteria cri,int mem_num)throws SQLException;
	public int selectSearchPjtAllPayListByMemNumCount(PaylistSearchCriteria cri,int mem_num)throws SQLException;

	public void updateAskRefundStateToOne(int pjt_pay_num) throws SQLException;
}
