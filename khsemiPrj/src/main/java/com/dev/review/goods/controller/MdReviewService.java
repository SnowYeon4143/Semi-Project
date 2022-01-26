package com.dev.review.goods.controller;

import static com.dev.common.JDBCTemplate.close;
import static com.dev.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.dev.paging.Paging;
import com.dev.progoods.model.ProgoodsDao;
import com.dev.review.goods.medel.dao.MdReviewDao;
import com.dev.review.goods.modelVo.MdReviewVo;

public class MdReviewService {

	public int totalMdReviewCount(int pro_no) {
		Connection conn = getConnection();
		int total = new MdReviewDao().totalReviewCount(conn, pro_no);
		close(conn);
		return 0;
	}

	public List<MdReviewVo> mdReviewList(Paging page, int pro_no) {
		Connection conn = getConnection();
		int startNo = page.startNo();
		int endNo =page.endNo();
		List<MdReviewVo> mdReList = new MdReviewDao().mdReList(conn,pro_no,startNo,endNo );
		close(conn);
		return null;
	}

	public boolean insertR(int m_no, int pro_no, String mr_cont) {
		Connection conn = getConnection();
		boolean result = new MdReviewDao().insertR(conn, m_no, pro_no, mr_cont);
		close(conn);
		System.out.println("service called");
		return result;
	}

	public List<MdReviewVo> mdReportList() {
		Connection conn = getConnection();
		List<MdReviewVo> mdReportList = new MdReviewDao().mdReportList(conn);
		close(conn);
		return null;
	}

}
