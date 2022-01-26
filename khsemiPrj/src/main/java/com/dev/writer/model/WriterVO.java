package com.dev.writer.model;

public class WriterVO 
{
	private int authorNumber;
	private String authorName;
	private String authorBirthday;
	private String award;

	private String bookTitle;
	private String bookPublisher;
	private int publicDate;
	
	public int getAuthorNumber() {
		return authorNumber;
	}
	public void setAuthorNumber(int authorNumber) {
		this.authorNumber = authorNumber;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorBirthday() {
		return authorBirthday;
	}
	public void setAuthorBirthday(String authorBirthday) {
		this.authorBirthday = authorBirthday;
	}
	public String getAward() {
		return award;
	}
	public void setAward(String award) {
		this.award = award;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public int getPublicDate() {
		return publicDate;
	}
	public void setPublicDate(int publicDate) {
		this.publicDate = publicDate;
	}
	
	

}
