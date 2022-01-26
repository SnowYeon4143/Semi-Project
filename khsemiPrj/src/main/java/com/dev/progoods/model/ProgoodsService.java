package com.dev.progoods.model;

import java.sql.Connection;
import java.util.List;

import com.dev.paging.Paging;

import static com.dev.common.JDBCTemplate.*;

public class ProgoodsService {
	
	public int insert(ProgoodsVo g){
		
		Connection conn = getConnection();
		int insert = new ProgoodsDao().insertProG(conn, g);
		close(conn);
		return insert;
	}

	public int totalGoodsCount(String category) {
		Connection conn = getConnection();
		int total = new ProgoodsDao().totalCount(conn, category);
		close(conn);
		return total ;
	}
	
	public List<ProgoodsVo> goodsList(Paging page, String category) {
		Connection conn = getConnection();
		
		int rowStartNo = page.rowStarNo();
		rowStartNo = 1;
		int rowEndNo = page.rowEndNo();
		rowEndNo = 6;
		List<ProgoodsVo> goodsListAll = new ProgoodsDao().categoryGoods(conn, rowStartNo, rowEndNo, category);
		close(conn);
		
		System.out.println("=======서비스================");
		System.out.println("curPage:"+ page.currentPage);
		System.out.println("startNo:"+ page.startNo());
		System.out.println("endNo:"+ page.endNo());
		System.out.println("prePage:"+ page.prePage());
		System.out.println("nextPage:"+ page.nextPage());
		System.out.println("category:"+category);
		System.out.println("========================");
		return goodsListAll;
	}


	public List<ProgoodsVo> likedesc(Paging page, String category) {
		Connection conn = getConnection();
		
		List<ProgoodsVo> goodsListAll = new ProgoodsDao().likedesc(conn, page, category);
		close(conn);
		return goodsListAll;
	}

	public List<ProgoodsVo> salesdesc(Paging page, String category) {
		Connection conn = getConnection();
		
		List<ProgoodsVo> goodsListAll = new ProgoodsDao().salesdesc(conn, page, category);
		close(conn);
		return goodsListAll;
	}

	public int totalGoodsCountAll() {
		Connection conn = getConnection();
		int total = new ProgoodsDao().totalCountAll(conn);
		close(conn);
		return total ;
	}

	public List<ProgoodsVo> goodsAll(Paging page) {
		Connection conn = getConnection();
		
		int rowStartNo = page.rowStarNo();
		int rowEndNo = page.rowEndNo();
		
		List<ProgoodsVo> goodsListAll = new ProgoodsDao().goodsAll(conn, rowStartNo, rowEndNo);
		close(conn);
		return goodsListAll;
	}
	
//	------------------- update------------------------------

	public int updateProName(int pro_no , String pro_name) {
		Connection conn = getConnection();
		int update =  new ProgoodsDao().updateProName(conn, pro_no, pro_name) ;
		close(conn);
		return update;
	}
	
	public int updateUnitPrice(int pro_no ,int unit_price) {
		Connection conn = getConnection();
		int update =  new ProgoodsDao().updateUnitPrice(conn, pro_no, unit_price) ;
		close(conn);
		return update;
	}
	
	public int updateStock(int pro_no, int stock) {
		Connection conn = getConnection();
		int update =  new ProgoodsDao().updateStock(conn, pro_no, stock) ;
		close(conn);
		return update;
	}
	
	public int updatemdCate(int pro_no, String md_cate) {
		Connection conn = getConnection();
		int update =  new ProgoodsDao().updatemdCate(conn, pro_no, md_cate) ;
		close(conn);
		return update;
	}
	
	public int updateMaker(int pro_no, String maker) {
		Connection conn = getConnection();
		int update =  new ProgoodsDao().updateMaker(conn, pro_no, maker) ;
		close(conn);
		return update;
	}
	
	public int updateCountry(int pro_no, String country) {
		Connection conn = getConnection();
		int update =  new ProgoodsDao().updateCountry(conn, pro_no, country) ;
		close(conn);
		return update;
	}
		
	public int updateProImg(int pro_no, String filePath) {
		Connection conn = getConnection();
		int update =  new ProgoodsDao().updateProImg(conn, pro_no, filePath) ;
		close(conn);
		return update;
	}
	public int updateProInf(int pro_no, String filePath2) {
		Connection conn = getConnection();
		int update =  new ProgoodsDao().updateProInf(conn, pro_no, filePath2) ;
		close(conn);
		return update;
	}

	public int deleteMd(int pro_no) {
		Connection conn = getConnection();
		System.out.println("md 서비스");
		int result = new ProgoodsDao().deleteMd(conn, pro_no);
		close(conn);
		return result;
	}
	
	public int deletePro(int pro_no) {
		Connection conn = getConnection();
		System.out.println("pro 서비스");
		int result = new ProgoodsDao().deletePro(conn, pro_no);
		close(conn);
		return result;
	}

	public ProgoodsVo mdDetail(int pro_no) {
		Connection conn = getConnection();
		ProgoodsVo pvo = new ProgoodsDao().mdDetail(conn, pro_no);
		close(conn);
		return pvo;
	}
	
}
