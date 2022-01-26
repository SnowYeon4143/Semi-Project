package com.dev.event.model.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class EventVo {
	private int eventNo;
	private String eventTitle;
	private String eventContent;
	private Timestamp eventDate;
	private Timestamp eventStart;
	private Timestamp eventEnd;
	private String eventImgUrl;
	private int eventView;
	private char delYN;

	public EventVo() {

	}

	public int getEventNo() {
		return eventNo;
	}

	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getEventContent() {
		return eventContent;
	}

	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}

	public Timestamp getEventDate() {
		return eventDate;
	}

	public void setEventDate(Timestamp eventDate) {
		this.eventDate = eventDate;
	}

	public Timestamp getEventStart() {
		return eventStart;
	}

	public void setEventStart(Timestamp eventStart) {
		this.eventStart = eventStart;
	}

	public Timestamp getEventEnd() {
		return eventEnd;
	}

	public void setEventEnd(Timestamp eventEnd) {
		this.eventEnd = eventEnd;
	}

	public String getEventImgUrl() {
		return eventImgUrl;
	}

	public void setEventImgUrl(String eventImgUrl) {
		this.eventImgUrl = eventImgUrl;
	}

	public int getEventView() {
		return eventView;
	}

	public void setEventView(int eventView) {
		this.eventView = eventView;
	}

	public char getDelYN() {
		return delYN;
	}

	public void setDelYN(char delYN) {
		this.delYN = delYN;
	}

	@Override
	public String toString() {
		return "EventVo [eventNo=" + eventNo + ", eventTitle=" + eventTitle + ", eventContent=" + eventContent
				+ ", eventDate=" + eventDate + ", eventStart=" + eventStart + ", eventEnd=" + eventEnd
				+ ", eventImgUrl=" + eventImgUrl + ", eventView=" + eventView + ", delYN=" + delYN + "]";
	}

}
