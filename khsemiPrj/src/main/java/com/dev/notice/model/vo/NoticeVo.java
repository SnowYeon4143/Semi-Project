package com.dev.notice.model.vo;

import java.sql.Timestamp;

public class NoticeVo {
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private Timestamp noticeDate;
	private int noticeView;
	private char delYN;
	
	//기본생성자
	public NoticeVo() {
	}

	//공지사항 작성 시 사용할 생성자
	public NoticeVo(String noticeTitle, String noticeContent) {
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
	}
	
	//공지사항 리스트 보여줄 때 사용할 생성자
	public NoticeVo(int noticeNo, String noticeTitle, Timestamp noticeDate, int noticeView) {
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeDate = noticeDate;
		this.noticeView = noticeView;
	}
	
	
	//공지사항 자세히 볼 때 사용할 생성자
	public NoticeVo(int noticeNo, String noticeTitle, String noticeContent, Timestamp noticeDate, int noticeView) {
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeView = noticeView;
	}

	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Timestamp getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Timestamp noticeDate) {
		this.noticeDate = noticeDate;
	}
	public int getNoticeView() {
		return noticeView;
	}
	public void setNoticeView(int noticeView) {
		this.noticeView = noticeView;
	}
	public char getDelYN() {
		return delYN;
	}
	public void setDelYN(char delYN) {
		this.delYN = delYN;
	}

	@Override
	public String toString() {
		return "NoticeVo [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeDate=" + noticeDate + ", noticeView=" + noticeView + ", delYN=" + delYN + "]";
	}
	
}
