package com.funding.dto;

import java.util.Date;

public class FreeBoardVO {

	private int free_num; //번호
	private String free_title; //제목
	private String free_contents; //내용
	private int free_like; //좋아요
	private Date free_regdate; //작성일자
	private Date free_moddate; //수정일자
	private int free_view_cnt; //조회수
	private int free_enabled; //활성화 여부
	private int mem_num; //작성자
	
	private String mem_name; //free_board 테이블엔 없음
	private String mem_email; //free_board 테이블엔 없음
	
	private int free_cmts_cnt; //댓글 개수
	
	public FreeBoardVO() {}

	public FreeBoardVO(int free_num, String free_title, String free_contents, int free_like, Date free_regdate,
			Date free_moddate, int free_view_cnt, int free_enabled, int mem_num, String mem_name, String mem_email,
			int free_cmts_cnt) {
		super();
		this.free_num = free_num;
		this.free_title = free_title;
		this.free_contents = free_contents;
		this.free_like = free_like;
		this.free_regdate = free_regdate;
		this.free_moddate = free_moddate;
		this.free_view_cnt = free_view_cnt;
		this.free_enabled = free_enabled;
		this.mem_num = mem_num;
		this.mem_name = mem_name;
		this.mem_email = mem_email;
		this.free_cmts_cnt = free_cmts_cnt;
	}

	public int getFree_num() {
		return free_num;
	}

	public void setFree_num(int free_num) {
		this.free_num = free_num;
	}

	public String getFree_title() {
		return free_title;
	}

	public void setFree_title(String free_title) {
		this.free_title = free_title;
	}

	public String getFree_contents() {
		return free_contents;
	}

	public void setFree_contents(String free_contents) {
		this.free_contents = free_contents;
	}

	public int getFree_like() {
		return free_like;
	}

	public void setFree_like(int free_like) {
		this.free_like = free_like;
	}

	public Date getFree_regdate() {
		return free_regdate;
	}

	public void setFree_regdate(Date free_regdate) {
		this.free_regdate = free_regdate;
	}

	public Date getFree_moddate() {
		return free_moddate;
	}

	public void setFree_moddate(Date free_moddate) {
		this.free_moddate = free_moddate;
	}

	public int getFree_view_cnt() {
		return free_view_cnt;
	}

	public void setFree_view_cnt(int free_view_cnt) {
		this.free_view_cnt = free_view_cnt;
	}

	public int getFree_enabled() {
		return free_enabled;
	}

	public void setFree_enabled(int free_enabled) {
		this.free_enabled = free_enabled;
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	
	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	
	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	
	public int getFree_cmts_cnt() {
		return free_cmts_cnt;
	}

	public void setFree_cmts_cnt(int free_cmts_cnt) {
		this.free_cmts_cnt = free_cmts_cnt;
	}

	@Override
	public String toString() {
		return "FreeBoardVO [free_num=" + free_num + ", free_title=" + free_title + ", free_contents=" + free_contents
				+ ", free_like=" + free_like + ", free_regdate=" + free_regdate + ", free_moddate=" + free_moddate
				+ ", free_view_cnt=" + free_view_cnt + ", free_enabled=" + free_enabled + ", mem_num=" + mem_num
				+ ", mem_name=" + mem_name + ", mem_email=" + mem_email + ", free_cmts_cnt=" + free_cmts_cnt + "]";
	}
	
}
