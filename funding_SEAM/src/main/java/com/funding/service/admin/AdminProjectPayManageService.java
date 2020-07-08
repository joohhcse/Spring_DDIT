package com.funding.service.admin;

import java.sql.SQLException;
import java.util.Map;

import com.funding.request.AdminMemberDetailRequest;
import com.funding.request.AdminProjectPaySearchCriteria;

public interface AdminProjectPayManageService {
	
	//결제 내역 리스트 조회 + 검색
	Map<String, Object> getProjectPayList(AdminProjectPaySearchCriteria cri) throws SQLException;
	
	//결제 내역 상세 조회
	Map<String, Object> getProjectPayDetail(int pjt_pay_num) throws SQLException;
	
	//환불 완료 처리
	void updateRefund(int pjt_pay_num) throws SQLException;

}
