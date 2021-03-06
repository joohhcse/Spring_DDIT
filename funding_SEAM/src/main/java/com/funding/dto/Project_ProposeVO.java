package com.funding.dto;

import java.util.Date;

public class Project_ProposeVO {
	private int pjtprp_num;	//제안게시판 번호
	private String pjtprp_title; //제안게시판 제목  
	private String pjtprp_contents; //제안게시판 내용
	private String pjtprp_cheerup;//제안게시판 응원하기
	private String pjtprp_like;//제안게시판 좋아요
	private Date pjtprp_regdate;//제안게시판 등록일자
	private Date pjtprp_moddate;//제안게시판 수정일자
	private int pjtprp_view_cnt;//제안게시판 조회수
	private int pjtprp_enabled;//제안게시판 노출/비노출
	private int mem_num;//제안게시판 등록회원
	private String mem_name;//회원 이름
	private int cmt_count;
	
	
	
	
	public int getCmt_count() {
		return cmt_count;
	}
	public void setCmt_count(int cmt_count) {
		this.cmt_count = cmt_count;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public int getPjtprp_num() {
		return pjtprp_num;
	}
	public void setPjtprp_num(int pjtprp_num) {
		this.pjtprp_num = pjtprp_num;
	}
	public String getPjtprp_title() {
		return pjtprp_title;
	}
	public void setPjtprp_title(String pjtprp_title) {
		this.pjtprp_title = pjtprp_title;
	}
	public String getPjtprp_contents() {
		return pjtprp_contents;
	}
	public void setPjtprp_contents(String pjtprp_contents) {
		this.pjtprp_contents = pjtprp_contents;
	}
	public String getPjtprp_cheerup() {
		return pjtprp_cheerup;
	}
	public void setPjtprp_cheerup(String pjtprp_cheerup) {
		this.pjtprp_cheerup = pjtprp_cheerup;
	}
	public String getPjtprp_like() {
		return pjtprp_like;
	}
	public void setPjtprp_like(String pjtprp_like) {
		this.pjtprp_like = pjtprp_like;
	}
	public Date getPjtprp_regdate() {
		return pjtprp_regdate;
	}
	public void setPjtprp_regdate(Date pjtprp_regdate) {
		this.pjtprp_regdate = pjtprp_regdate;
	}
	public Date getPjtprp_moddate() {
		return pjtprp_moddate;
	}
	public void setPjtprp_moddate(Date pjtprp_moddate) {
		this.pjtprp_moddate = pjtprp_moddate;
	}
	public int getPjtprp_view_cnt() {
		return pjtprp_view_cnt;
	}
	public void setPjtprp_view_cnt(int pjtprp_view_cnt) {
		this.pjtprp_view_cnt = pjtprp_view_cnt;
	}
	public int getPjtprp_enabled() {
		return pjtprp_enabled;
	}
	public void setPjtprp_enabled(int pjtprp_enabled) {
		this.pjtprp_enabled = pjtprp_enabled;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	
	
	
	
	
}
