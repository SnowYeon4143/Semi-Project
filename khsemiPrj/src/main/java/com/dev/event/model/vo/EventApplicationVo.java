package com.dev.event.model.vo;

public class EventApplicationVo {
	private int eaNo;
	private int eNo;
	private int mNo;
	private String eaId;
	private String eaEmail;
	private char winnerYN;
	
	public int getEaNo() {
		return eaNo;
	}
	public void setEaNo(int eaNo) {
		this.eaNo = eaNo;
	}
	public int geteNo() {
		return eNo;
	}
	public void seteNo(int eNo) {
		this.eNo = eNo;
	}
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public String getEaId() {
		return eaId;
	}
	public void setEaId(String eaId) {
		this.eaId = eaId;
	}
	public String getEaEmail() {
		return eaEmail;
	}
	public void setEaEmail(String eaEmail) {
		this.eaEmail = eaEmail;
	}
	public char getWinnerYN() {
		return winnerYN;
	}
	public void setWinnerYN(char winnerYN) {
		this.winnerYN = winnerYN;
	}
	
	@Override
	public String toString() {
		return "EventApplicationVo [eaNo=" + eaNo + ", eNo=" + eNo + ", mNo=" + mNo + ", eaId=" + eaId + ", eaEmail="
				+ eaEmail + ", winnerYN=" + winnerYN + "]";
	}
	
}
