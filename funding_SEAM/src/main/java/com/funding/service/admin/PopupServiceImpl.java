package com.funding.service.admin;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.funding.dao.admin.PopupDAO;
import com.funding.dto.PopupVO;
import com.funding.dto.Project_ProposeVO;
import com.funding.request.PageMaker;
import com.funding.request.SearchCriteria;

public class PopupServiceImpl implements PopupService{
	private PopupDAO popupDAO;
	
	public void setPopupDAO(PopupDAO popupDAO) {
		this.popupDAO = popupDAO;
	}
	
	@Override
	public Map<String, Object> selectPopupList(SearchCriteria cri) throws SQLException {
		List<PopupVO> list = popupDAO.selectPopupList(cri);
		Map<String,Object> dataMap = new HashMap<String, Object>();
		
		int totalCount = popupDAO.selectPopupListCount(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("popup", list);
		dataMap.put("pageMaker", pageMaker);
		return dataMap;
	}

	@Override
	public void registPopup(PopupVO popup) throws SQLException {
		int p_num = popupDAO.selectPopupSeqNext();
		popup.setP_num(p_num);
		popupDAO.registPopup(popup);
	}

	@Override
	public void deletePopup(int p_num) throws SQLException {
		popupDAO.deletePopup(p_num);
		
	}

	@Override
	public void popupDisabled(int p_num) throws SQLException {
		popupDAO.popupDisabled(p_num);
		
	}

	@Override
	public void popupEnabled(int p_num) throws SQLException {
		popupDAO.popupEnabled(p_num);
		
	}

	@Override
	public PopupVO selectPopupListByNum(int p_num) throws SQLException {
		PopupVO popup = popupDAO.selectPopupListByNum(p_num);
		return popup;
	}

	@Override
	public void modifyPopup(PopupVO popup) throws SQLException {
		popupDAO.modifyPopup(popup);
		
	}

	@Override
	public List<PopupVO> selectActivePopup() throws SQLException {
		List<PopupVO> popupList = popupDAO.selectActivePopup();
		return popupList;
	}

}
