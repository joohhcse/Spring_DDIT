package com.funding.dao;

import java.sql.SQLException;
import java.util.List;

import com.funding.dto.NoticeVO;
import com.funding.request.SearchCriteria;

public interface NoticeDAO {
	
	public List<NoticeVO> searchedNoticeList(SearchCriteria cri) throws SQLException;
	
	public int searchedNoticeListCount(SearchCriteria cri) throws SQLException;
	
	public List<NoticeVO> selectPointNoticeList(SearchCriteria cri) throws SQLException;
	
	public NoticeVO selectNoticeByNotice_num(int notice_num) throws SQLException;
 	
	public void insertNotice(NoticeVO notice)throws SQLException;
	
	public void updateNotice(NoticeVO notice)throws SQLException;
	
	public void deleteNotice(int notice_num)throws SQLException;
	
	public void increaseViewCnt(int notice_num)throws SQLException;
	
	public int selectNoticeSeqNext() throws SQLException;
	
	public List<NoticeVO> selectNoticeListAll()throws SQLException;
	
	public void pointNoticeUpdate(NoticeVO notice)throws SQLException;
	
	public NoticeVO next_notice_title(int notice_num)throws SQLException;

	public NoticeVO prev_notice_title(int notice_num)throws SQLException;

}
