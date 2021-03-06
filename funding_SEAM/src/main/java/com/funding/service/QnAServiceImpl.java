package com.funding.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.funding.dao.QnADAO;
import com.funding.dto.QnAVO;
import com.funding.request.PageMaker;
import com.funding.request.SearchCriteria;

public class QnAServiceImpl implements QnAService{
	
@Autowired
private QnADAO qnaDAO;
public void setQnaDAO(QnADAO qnaDAO) {
	this.qnaDAO = qnaDAO;
}


	@Override
	public Map<String, Object> getAllQnAList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<QnAVO> list = qnaDAO.selectQnAList(cri);
		
		int totalCnt = qnaDAO.selectSearchQnAListTotalCount(cri);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCnt);
		
		dataMap.put("list", list);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public Map<String, Object> getAllQnAListExptDisabled(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<QnAVO> list = qnaDAO.selectQnAListExptDisabled(cri);
		
		int totalCnt = qnaDAO.selectSearchQnAListTotalCountExptDisabled(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCnt);
		
		dataMap.put("list", list);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
		
	}


	@Override
	public QnAVO getDetail(int qna_num) throws SQLException {
		qnaDAO.increaseQnAViewCnt(qna_num);
		QnAVO qna = qnaDAO.selectQnAByqna_Num(qna_num);
		return qna;
	}
	

/*	
	@Override
	public boolean chkPwd(String qna_pwd) throws SQLException {
		return qnaDAO.selectSecretQnA(qna_pwd);
		
	}
*/


	@Override
	public QnAVO getModForm(int qna_num) throws SQLException {
		return qnaDAO.selectQnAByqna_Num(qna_num);
	}


	@Override
	public void regist(QnAVO qna) throws SQLException {
		String pwd = qna.getQna_pwd();
		int qna_no=qnaDAO.selectQnASeqNext();
		qna.setQna_num(qna_no);
		
		if(pwd == null) {
			qna.setQna_secret(1);
			qnaDAO.registQnAnone(qna);
			
		}else {
			qna.setQna_secret(0);
			qnaDAO.registQnA(qna);
		}
		
	}


	@Override
	public void modify(QnAVO qna) throws SQLException {
		qnaDAO.modifyQnA(qna);
		
	}


	@Override
	public void remove(int qna_num) throws SQLException {
		qnaDAO.removeQnA(qna_num);
		
	}


	@Override
	public List<QnAVO> getCmts(int qna_num) throws SQLException {
		List<QnAVO> cmtsList = qnaDAO.selectQnACmtsList(qna_num);
		return cmtsList;
		
	}


	@Override
	public QnAVO cmtsDetail(int qna_cmts_num) throws SQLException {
		QnAVO cmts = (QnAVO) qnaDAO.countQnACmts(qna_cmts_num);
		return cmts;
		
	}


	@Override
	public void registCmts(QnAVO qna) throws SQLException {
		int qna_no=qnaDAO.selectQnASeqNext();
		qna.setQna_num(qna_no);
		
		qnaDAO.registCmts(qna);
	
	}


	@Override
	public void modifyCmts(QnAVO qna) throws SQLException {
		qnaDAO.modifyCmts(qna);
		
	}


	@Override
	public void removeCmts(int qna_cmts_num) throws SQLException {
		qnaDAO.removeCmts(qna_cmts_num);
		
	}


	@Override
	public void enabled(int qna_num) throws SQLException {
		qnaDAO.checkQnAEnabled(qna_num);
	
	}


	@Override
	public void disabled(int qna_num) throws SQLException {
		qnaDAO.checkQnADisabled(qna_num);
		
	}


}
