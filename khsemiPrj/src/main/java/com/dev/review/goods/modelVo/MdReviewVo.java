package com.dev.review.goods.modelVo;

public class MdReviewVo {
	
	private int mr_no =0;
	private int md_no =0;
	//title
	private String mr_cont = null;
	//rept_yn
	private int mr_like = 0;
	private String mr_date = null;
	//del_yn
	private String id = null;
	private String pro_img =null;
	
	
	
	public String getPro_img() {
		return pro_img;
	}
	public void setPro_img(String pro_img) {
		this.pro_img = pro_img;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getMr_no() {
		return mr_no;
	}
	public void setMr_no(int mr_no) {
		this.mr_no = mr_no;
	}
	public int getMd_no() {
		return md_no;
	}
	public void setMd_no(int md_no) {
		this.md_no = md_no;
	}
	public String getMr_cont() {
		return mr_cont;
	}
	public void setMr_cont(String mr_cont) {
		this.mr_cont = mr_cont;
	}
	public int getMr_like() {
		return mr_like;
	}
	public void setMr_like(int mr_like) {
		this.mr_like = mr_like;
	}
	public String getMr_date() {
		return mr_date;
	}
	public void setMr_date(String mr_date) {
		this.mr_date = mr_date;
	}
	
	
	
	
}
