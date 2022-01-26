package com.dev.paging;

public class Paging {

	 public int rowNo = 5;
	 public int size = 5;
	 public int totalRowCount = 0;
	   
	 public int currentPage = 0;
	 
	 public Paging(int rowNo, int size, int totalRowCount, int currentPage){
	     this.rowNo = rowNo;  // 한 페이지에 보여지는 개수
	     this.size = size;	  // 페이저 개수
	     this.totalRowCount = totalRowCount; // 전체 글 개수
	     this.currentPage = currentPage;	// 현재 페이지
	 }
	    
	 public int maxPage() {
	     int maxpage;
	     if(totalRowCount % rowNo !=0) {
	         maxpage = totalRowCount/rowNo + 1;
	     }else {
	         maxpage = totalRowCount/rowNo;
	     }
	     return maxpage;
	 }
	  
	 public int startNo() {
	     return ((currentPage-1)/size)*size+1;
	 }
	    
	 public int endNo() {
		 int result = (((currentPage-1)/size) +1)*size;
		 if(result > maxPage()) {
			 result = maxPage();
		 }
		 
	     return result;
	 }
	    
	 public boolean isPre() {
	     boolean b =false;
	     if(startNo() != 1) {
	         b = true;
	     }else {
	         b = false;
	     }
	     return b;
	 }
	 
	 public boolean isNext() {
	     boolean b = false;
	     if(endNo()>=maxPage()) {
	         b=false;
	     }else {
	         b=true;
	     }
	     return b;
	 }
	 
	 public int prePage() {
		 if(isPre()) {
			 currentPage = startNo()-1;
		 }
		 return currentPage;
	 }
	 
	 public int nextPage() {
		 if(isNext()) {
			 currentPage = endNo()+1;
		 }
		 return currentPage;
	 }
	 
	 public int rowStarNo() {
		 return (currentPage-1) * rowNo + 1;
	 }
	 
	 public int rowEndNo() {
		 return currentPage*rowNo;
	 }
}
