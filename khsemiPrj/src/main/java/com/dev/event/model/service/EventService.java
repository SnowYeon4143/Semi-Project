package com.dev.event.model.service;

import static com.dev.common.JDBCTemplate.close;
import static com.dev.common.JDBCTemplate.commit;
import static com.dev.common.JDBCTemplate.getConnection;
import static com.dev.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.dev.event.model.dao.EventDao;
import com.dev.event.model.vo.EventVo;
import com.dev.paging.Paging;

public class EventService {
	// event리스트 조회
		public List<EventVo> eventList(Paging page) {
			// 커넥션
			Connection conn = getConnection();

			int rowStartNo = page.rowStarNo();
			int rowEndNo = page.rowEndNo();

			System.out.println("selectEventList currenpage = " + page.currentPage);
			System.out.println("selectEventList startno = " + page.startNo());

			List<EventVo> eventList = new EventDao().eventList(conn, rowStartNo, rowEndNo);
			System.out.println("eventservice.eventList called... ");
			close(conn);

			return eventList;
		}

		// event 글 개수 확인
		public int totalEventCount() {
			// 커넥션
			Connection conn = getConnection();

			int total = new EventDao().totalCount(conn);

			return total;
		}

		// event 글 작성
		public int writeEvent(EventVo q) {
			// 커넥션
			Connection conn = getConnection();

			int result = 0;
			result = insertEvent(conn, q);

			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}

			return result;
		}

		private int insertEvent(Connection conn, EventVo n) {
			// dao 불러서 쿼리 실행
			// dao 한테 쿼리 실행 결과 받기
			return new EventDao().insertEvent(conn, n);
		}

		public EventVo eventSelect(int eventNo) {
			// 커넥션
			Connection conn = getConnection();

			EventDao ed = new EventDao();
			EventVo e = ed.eventSelect(conn, eventNo);
			ed.eventViewPlus(conn, eventNo);

			System.out.println("eventservice.eventselect called... ");
			close(conn);

			return e;
		}

		public int eventDelete(int eventNo) {
			// 커넥션
			Connection conn = getConnection();

			int result = new EventDao().eventDelete(conn, eventNo);
			System.out.println("eventservice.eventdelete called... ");
			close(conn);

			return result;
		}

		public int eventUpdate(EventVo n) {
			// 커넥션
			Connection conn = getConnection();

			int result = new EventDao().eventUpdate(conn, n);

			System.out.println("eventservice.eventupdate called... ");
			close(conn);

			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}

			return result;
		}
}
