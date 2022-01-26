package com.dev.notice.model.service;

import static com.dev.common.JDBCTemplate.close;
import static com.dev.common.JDBCTemplate.commit;
import static com.dev.common.JDBCTemplate.getConnection;
import static com.dev.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.dev.notice.model.dao.NoticeDao;
import com.dev.notice.model.vo.NoticeVo;
import com.dev.paging.Paging;
import com.dev.qna.model.dao.QnaDao;
import com.dev.qna.model.vo.QnaVo;

public class NoticeService {
	// notice리스트 조회
	public List<NoticeVo> noticeList(Paging page) {
		// 커넥션
		Connection conn = getConnection();

		int rowStartNo = page.rowStarNo();
		int rowEndNo = page.rowEndNo();

		System.out.println("selectNoticeList currenpage = " + page.currentPage);
		System.out.println("selectNoticeList startno = " + page.startNo());

		List<NoticeVo> noticeList = new NoticeDao().noticeList(conn, rowStartNo, rowEndNo);
		System.out.println("noticeservice.noticeList called... ");
		close(conn);

		return noticeList;
	}

	// notice 글 개수 확인
	public int totalNoticeCount() {
		// 커넥션
		Connection conn = getConnection();

		int total = new NoticeDao().totalCount(conn);

		return total;
	}

	// notice 글 작성
	public int writeNotice(NoticeVo q) {
		// 커넥션
		Connection conn = getConnection();

		int result = 0;
		result = insertNotice(conn, q);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}

	private int insertNotice(Connection conn, NoticeVo n) {
		// dao 불러서 쿼리 실행
		// dao 한테 쿼리 실행 결과 받기
		return new NoticeDao().insertNotice(conn, n);
	}

	public NoticeVo noticeSelect(int noticeNo) {
		// 커넥션
		Connection conn = getConnection();

		NoticeDao nd = new NoticeDao();
		NoticeVo n = nd.noticeSelect(conn, noticeNo);
		nd.noticeViewPlus(conn, noticeNo);

		System.out.println("noticeservice.noticeselect called... ");
		close(conn);

		return n;
	}

	public int noticeDelete(int noticeNo) {
		// 커넥션
		Connection conn = getConnection();

		int result = new NoticeDao().noticeDelete(conn, noticeNo);
		System.out.println("noticeservice.noticedelete called... ");
		close(conn);

		return result;
	}

	public int noticeUpdate(NoticeVo n) {
		// 커넥션
		Connection conn = getConnection();

		int result = new NoticeDao().noticeUpdate(conn, n);

		System.out.println("noticeservice.noticeupdate called... ");
		close(conn);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}
}
