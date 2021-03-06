package com.funding.dto;

import java.util.Date;

public class Thumb_upVO {

	private int thumbup_num; //좋아요 번호
	private int mem_num; //회원 번호
	private int pjtprp_num; //프로젝트 제안 글 번호
	private int pjtprp_cmts_num; //프로젝트 제안 댓글 번호
	private int free_num; //자유게시판 글 번호
	private int free_cmts_num; //자유게시판 댓글 번호
	private Date thumbup_regdate; //좋아요 등록 날짜
	private String mem_name; //회원 이름
	
	public Thumb_upVO() {}
	
	public Thumb_upVO(int thumbup_num, int mem_num, int pjtprp_num, int pjtprp_cmts_num, int free_num,
			int free_cmts_num, Date thumbup_regdate) {
		super();
		this.thumbup_num = thumbup_num;
		this.mem_num = mem_num;
		this.pjtprp_num = pjtprp_num;
		this.pjtprp_cmts_num = pjtprp_cmts_num;
		this.free_num = free_num;
		this.free_cmts_num = free_cmts_num;
		this.thumbup_regdate = thumbup_regdate;
	}
	
	

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public int getThumbup_num() {
		return thumbup_num;
	}

	public void setThumbup_num(int thumbup_num) {
		this.thumbup_num = thumbup_num;
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public int getPjtprp_num() {
		return pjtprp_num;
	}

	public void setPjtprp_num(int pjtprp_num) {
		this.pjtprp_num = pjtprp_num;
	}

	public int getPjtprp_cmts_num() {
		return pjtprp_cmts_num;
	}

	public void setPjtprp_cmts_num(int pjtprp_cmts_num) {
		this.pjtprp_cmts_num = pjtprp_cmts_num;
	}

	public int getFree_num() {
		return free_num;
	}

	public void setFree_num(int free_num) {
		this.free_num = free_num;
	}

	public int getFree_cmts_num() {
		return free_cmts_num;
	}

	public void setFree_cmts_num(int free_cmts_num) {
		this.free_cmts_num = free_cmts_num;
	}

	public Date getThumbup_regdate() {
		return thumbup_regdate;
	}

	public void setThumbup_regdate(Date thumbup_regdate) {
		this.thumbup_regdate = thumbup_regdate;
	}

	@Override
	public String toString() {
		return "Thumb_upVO [thumbup_num=" + thumbup_num + ", mem_num=" + mem_num + ", pjtprp_num=" + pjtprp_num
				+ ", pjtprp_cmts_num=" + pjtprp_cmts_num + ", free_num=" + free_num + ", free_cmts_num=" + free_cmts_num
				+ ", thumbup_regdate=" + thumbup_regdate + "]";
	}
	
}
