package com.dev.recommend.controller;

import static com.dev.common.JDBCTemplate.close;
import static com.dev.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.dev.probook.model.ProbookVO;
import com.dev.recommend.model.dao.MdRecommendDao;
import com.dev.review.goods.medel.dao.MdReviewDao;

public class MdRecommendService {

	public int totalCount() {
		Connection conn = getConnection();
		int total = new MdRecommendDao().totalCount(conn);
		close(conn);
		return 0;
	}

	public List<ProbookVO> bookList() {
		Connection conn = getConnection();
		List<ProbookVO> bookList = new MdRecommendDao().bookList(conn);
		close(conn);
		return bookList;
	}

	public int totalsearchCount(String search) {
		Connection conn = getConnection();
		int total = new MdRecommendDao().totalsearchCount(conn, search);
		close(conn);
		return 0;
	}

	public List<ProbookVO> booksearchList(String search) {
		Connection conn = getConnection();
		List<ProbookVO> bookList = new MdRecommendDao().booksearchList(conn, search);
		close(conn);
		return bookList;
	}

}
