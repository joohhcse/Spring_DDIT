package com.funding.request;

public class PreOrNextForBoardRequest {
	
	private int free_num;
	private int pjtprp_num;
	private int pre_no;
	private int next_no;
	private int pjtprp_enabled;
	private String pre_title;
	private String next_title;
	
	public PreOrNextForBoardRequest() {}

	public PreOrNextForBoardRequest(int free_num, int pjtprp_num, int pre_no, int next_no, String pre_title,
			String next_title, int pjtprp_enabled) {
		super();
		this.free_num = free_num;
		this.pjtprp_num = pjtprp_num;
		this.pre_no = pre_no;
		this.next_no = next_no;
		this.pre_title = pre_title;
		this.next_title = next_title;
		this.pjtprp_enabled = pjtprp_enabled;
	}
	
	
	
	public int getPjtprp_enabled() {
		return pjtprp_enabled;
	}

	public void setPjtprp_enabled(int pjtprp_enabled) {
		this.pjtprp_enabled = pjtprp_enabled;
	}

	public int getFree_num() {
		return free_num;
	}

	public void setFree_num(int free_num) {
		this.free_num = free_num;
	}

	public int getPjtprp_num() {
		return pjtprp_num;
	}

	public void setPjtprp_num(int pjtprp_num) {
		this.pjtprp_num = pjtprp_num;
	}

	public int getPre_no() {
		return pre_no;
	}

	public void setPre_no(int pre_no) {
		this.pre_no = pre_no;
	}

	public int getNext_no() {
		return next_no;
	}

	public void setNext_no(int next_no) {
		this.next_no = next_no;
	}

	public String getPre_title() {
		return pre_title;
	}

	public void setPre_title(String pre_title) {
		this.pre_title = pre_title;
	}

	public String getNext_title() {
		return next_title;
	}

	public void setNext_title(String next_title) {
		this.next_title = next_title;
	}

	@Override
	public String toString() {
		return "PreOrNextForBoardRequest [free_num=" + free_num + ", pjtprp_num=" + pjtprp_num + ", pre_no=" + pre_no
				+ ", next_no=" + next_no + ", pre_title=" + pre_title + ", next_title=" + next_title + "]";
	}
	
}
