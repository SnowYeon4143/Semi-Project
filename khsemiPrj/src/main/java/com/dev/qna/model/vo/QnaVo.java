package com.dev.qna.model.vo;

import java.sql.Timestamp;

public class QnaVo {
	private int qnaNo;
	private String qnaTitle;
	private String qnaContent;
	private Timestamp qnaDate;
	private String qnaId;
	private int qnaView;
	private char delYN;
	private char reptYN;

	//기본 생성자
	public QnaVo() {

	}
	
	//qna 리스트 볼 때 사용하는 생성자
	public QnaVo(int qnaNo, String qnaTitle, Timestamp qnaDate, String qnaId, int qnaView) {
		this.qnaNo = qnaNo;
		this.qnaTitle = qnaTitle;
		this.qnaDate = qnaDate;
		this.qnaId = qnaId;
		this.qnaView = qnaView;
	}
	
	//qna 자세히 볼 때 사용하는 생성자(qna 신고된 리스트 볼때도 사용함)
	public QnaVo(int qnaNo, String qnaTitle, String qnaContent, Timestamp qnaDate, String qnaId, int qnaView) {
		this.qnaNo = qnaNo;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaDate = qnaDate;
		this.qnaId = qnaId;
		this.qnaView = qnaView;
	}

	//qna 작성할 때 사용하는 생성자
	public QnaVo(String qnaTitle, String qnaContent, int qnaNo) {
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaNo = qnaNo;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public Timestamp getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(Timestamp qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getQnaId() {
		return qnaId;
	}

	public void setQnaId(String qnaId) {
		this.qnaId = qnaId;
	}

	public int getQnaView() {
		return qnaView;
	}

	public void setQnaView(int qnaView) {
		this.qnaView = qnaView;
	}

	public char getDelYN() {
		return delYN;
	}

	public void setDelYN(char delYN) {
		this.delYN = delYN;
	}

	public char getReptYN() {
		return reptYN;
	}

	public void setReptYN(char reptYN) {
		this.reptYN = reptYN;
	}

	@Override
	public String toString() {
		return "QnaVo [qnaNo=" + qnaNo + ", qnaTitle=" + qnaTitle + ", qnaContent=" + qnaContent + ", qnaDate="
				+ qnaDate + ", qnaId=" + qnaId + ", qnaView=" + qnaView + ", delYN=" + delYN + ", reptYN=" + reptYN
				+ "]";
	}
	
}
