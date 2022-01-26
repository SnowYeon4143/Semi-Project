package com.dev.member.model.vo;

import java.sql.Timestamp;

public class MemberVo {

	private int memberNo;
	private String userId;
	private String userPwd;
	private String pwdCheck;
	private String userName;
	private String userEmail;
	private String userEmail2;
	private String userPhone;
	private String entYn;
	private int point;
	private Timestamp hireDate;
	private int reportCount;
	private int reviewtCount;
	private int qnaCount;
	private Timestamp updateDate;
	private String addr;
	private String addrDetail;
	private String yy;
	private String mm;
	private String dd;
	
	
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getPwdCheck() {
		return pwdCheck;
	}
	public void setPwdCheck(String pwdCheck) {
		this.pwdCheck = pwdCheck;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserEmail2() {
		return userEmail2;
	}
	public void setUserEmail2(String userEmail2) {
		this.userEmail2 = userEmail2;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getEntYn() {
		return entYn;
	}
	public void setEntYn(String entYn) {
		this.entYn = entYn;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Timestamp getHireDate() {
		return hireDate;
	}
	public void setHireDate(Timestamp hireDate) {
		this.hireDate = hireDate;
	}
	public int getReportCount() {
		return reportCount;
	}
	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}
	public int getReviewtCount() {
		return reviewtCount;
	}
	public void setReviewtCount(int reviewtCount) {
		this.reviewtCount = reviewtCount;
	}
	public int getQnaCount() {
		return qnaCount;
	}
	public void setQnaCount(int qnaCount) {
		this.qnaCount = qnaCount;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddrDetail() {
		return addrDetail;
	}
	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}
	public String getYy() {
		return yy;
	}
	public void setYy(String yy) {
		this.yy = yy;
	}
	public String getMm() {
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
	public String getDd() {
		return dd;
	}
	public void setDd(String dd) {
		this.dd = dd;
	}
	
	
	@Override
	public String toString() {
		return "MemberVo [memberNo=" + memberNo + ", userId=" + userId + ", userPwd=" + userPwd + ", pwdCheck="
				+ pwdCheck + ", userName=" + userName + ", userEmail=" + userEmail + ", userEmail2=" + userEmail2
				+ ", userPhone=" + userPhone + ", entYn=" + entYn + ", point=" + point + ", hireDate=" + hireDate
				+ ", reportCount=" + reportCount + ", reviewtCount=" + reviewtCount + ", qnaCount=" + qnaCount
				+ ", updateDate=" + updateDate + ", addr=" + addr + ", addrDetail=" + addrDetail + ", yy=" + yy
				+ ", mm=" + mm + ", dd=" + dd + "]";
	}

}
