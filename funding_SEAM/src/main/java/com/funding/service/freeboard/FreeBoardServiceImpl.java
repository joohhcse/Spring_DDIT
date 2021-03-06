package com.funding.service.freeboard;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.funding.dao.freeboard.FreeBoardCmtsDAO;
import com.funding.dao.freeboard.FreeBoardDAO;
import com.funding.dto.FreeBoardVO;
import com.funding.request.PageMaker;
import com.funding.request.PreOrNextForBoardRequest;
import com.funding.request.SearchCriteria;

public class FreeBoardServiceImpl implements FreeBoardService {

	@Autowired
	private FreeBoardDAO freeBoardDAO;
	public void setFreeBoardDAO(FreeBoardDAO freeBoardDAO) {
		this.freeBoardDAO = freeBoardDAO;
	}
	
	@Autowired
	private FreeBoardCmtsDAO freeBoardCmtsDAO;
	public void setFreeBoardCmtsDAO(FreeBoardCmtsDAO freeBoardCmtsDAO) {
		this.freeBoardCmtsDAO = freeBoardCmtsDAO;
	}
	
	@Override
		
	public Map<String, Object> getFreeBoardList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
		List<FreeBoardVO> freeBoardList = freeBoardDAO.selectSearchFreeBoardList(cri);

		//댓글 개수
		for(FreeBoardVO freeBoard : freeBoardList) {
			int freeCmtsCount = freeBoardCmtsDAO.countFreeBoardCmts(freeBoard.getFree_num());
			freeBoard.setFree_cmts_cnt(freeCmtsCount);
		}
		
		//전체 글 개수
		int totalCount = freeBoardDAO.selectSearchFreeBoardListTotalCount(cri);

		//PageMaker 생성.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("freeBoardList", freeBoardList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public Map<String, Object> getSearchFreeBoardListForEnabled(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
		List<FreeBoardVO> freeBoardList = freeBoardDAO.selectSearchFreeBoardListForEnabled(cri);
		
		//전체 글 개수
		int totalCount = freeBoardDAO.selectSearchFreeBoardListForEnabledTotalCount(cri);
		
		//댓글 개수
		for(FreeBoardVO freeBoard : freeBoardList) {
			int freeCmtsCount = freeBoardCmtsDAO.countFreeBoardCmts(freeBoard.getFree_num());
			freeBoard.setFree_cmts_cnt(freeCmtsCount);
		}
		
		//PageMaker 생성.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("freeBoardList", freeBoardList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public List<FreeBoardVO> getFreeBoardList() throws SQLException {
		List<FreeBoardVO> freeBoardList = freeBoardDAO.selectFreeBoardList();
		return freeBoardList;
	}
	

	@Override
	public FreeBoardVO getFreeBoard(int free_num) throws SQLException {
		FreeBoardVO board = freeBoardDAO.selectFreeBoardByFreeNum(free_num);
		
		//조회수 증가
		freeBoardDAO.increaseFreeViewCnt(free_num);

		return board;
	}

	@Override
	public FreeBoardVO getFreeBoardForModify(int free_num) throws SQLException {
		FreeBoardVO freeBoard = freeBoardDAO.selectFreeBoardByFreeNum(free_num);
		return freeBoard;
	}

	@Override
	public void regist(FreeBoardVO freeBoard) throws SQLException {
		
		int free_num = freeBoardDAO.selectFreeBoardSeqNext();
		freeBoard.setFree_num(free_num);
		
		freeBoardDAO.registFreeBoard(freeBoard);;
	}

	@Override
	public void modify(FreeBoardVO freeBoard) throws SQLException {
		freeBoardDAO.modifyFreeBoard(freeBoard);
	}

	@Override
	public void modifyEnabled(FreeBoardVO freeBoard) throws SQLException {
		freeBoardDAO.modifyFreeBoardEnabled(freeBoard);
	}

	@Override
	public void remove(int free_num) throws SQLException {
		freeBoardDAO.removeFreeBoard(free_num);
	}

	@Override
	public void modifyFreeLike(int free_num, String str) throws SQLException {
		if(str.equals("add")) {
			freeBoardDAO.increaseFreeLike(free_num);
		}else if(str.equals("sub")) {
			freeBoardDAO.decreaseFreeLike(free_num);
		}
	}

}
