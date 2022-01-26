package com.dev.qna.model.vo;

import java.sql.Timestamp;

public class QnaAnswersVo {
	private int ansNo;
	private int qnaNo;
	private String ansContent;
	private int answersLike;
	private Timestamp ansDate;
	private char ansDelYN;
	
	public QnaAnswersVo() {
	}

	public QnaAnswersVo(int qnaNo, String ansContent) {
		this.qnaNo = qnaNo;
		this.ansContent = ansContent;
	}

	public int getAnsNo() {
		return ansNo;
	}
	public void setAnsNo(int ansNo) {
		this.ansNo = ansNo;
	}
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getAnsContent() {
		return ansContent;
	}
	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}
	public int getAnswersLike() {
		return answersLike;
	}
	public void setAnswersLike(int answersLike) {
		this.answersLike = answersLike;
	}
	public Timestamp getAnsDate() {
		return ansDate;
	}
	public void setAnsDate(Timestamp ansDate) {
		this.ansDate = ansDate;
	}
	public char getAnsDelYN() {
		return ansDelYN;
	}
	public void setAnsDelYN(char ansDelYN) {
		this.ansDelYN = ansDelYN;
	}
	
	
}
