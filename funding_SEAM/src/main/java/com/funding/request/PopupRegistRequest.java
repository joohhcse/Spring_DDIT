package com.funding.request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.funding.dto.PopupVO;

public class PopupRegistRequest {
	private String p_name;
	private String p_url;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date p_enddate;
	private int p_top;
	private int p_left;
	private int p_width;
	private int p_height;
	private MultipartFile uploadFile;
	
	
	public String getP_url() {
		return p_url;
	}
	public void setP_url(String p_url) {
		this.p_url = p_url;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public Date getP_enddate() {
		return p_enddate;
	}
	public void setP_enddate(Date p_enddate) {
		this.p_enddate = p_enddate;
	}
	public int getP_top() {
		return p_top;
	}
	public void setP_top(int p_top) {
		this.p_top = p_top;
	}
	public int getP_left() {
		return p_left;
	}
	public void setP_left(int p_left) {
		this.p_left = p_left;
	}
	public int getP_width() {
		return p_width;
	}
	public void setP_width(int p_width) {
		this.p_width = p_width;
	}
	public int getP_height() {
		return p_height;
	}
	public void setP_height(int p_height) {
		this.p_height = p_height;
	}
	
	public PopupVO toPopupVO() {
		PopupVO popup = new PopupVO();
		popup.setP_name(p_name);
		popup.setP_url(p_url);
		popup.setP_top(p_top);
		popup.setP_left(p_left);
		popup.setP_width(p_width);
		popup.setP_height(p_height);
		popup.setP_enddate(p_enddate);
		
		return popup;
	}
}
