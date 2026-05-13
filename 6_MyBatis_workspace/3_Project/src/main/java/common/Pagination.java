package common;

import common.model.vo.PageInfo;

public class Pagination {
	public static PageInfo getPageInfo(int currentPage, int listCount) {
		int pageLimit = 10; // 한 페이지에서 보여주는 페이지 수
		int maxPage;		// 전체 페이지 수에서 가장 마지막 페이지
		int startPage;		// 현재 페이지에서 보이는 페이지 버튼 중 시작 페이지
		int endPage;		// 현재 페이지에서 보이는 페이지 버튼 중 끝 페이지
		int boardLimit = 5;	// 한 페이지에서 보이는 게시글 수
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		// 1, 11, 21, 31, ... => 10n + 1 (n >= 0)
		// n = 0, startPage = 1  / currentPage 1~10
		// n = 1, startPage = 11 / currentPage 11~10
		// n = 2, startPage = 21 / currentPage 21~30
		// n = (currentPage - 1) / pageLimit
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		// startPage 1 , endPage 1+10-1 = 10
		// startPage 11, endPage 11+10-1 = 20
		// listCount 51, maxPage 11
		// 1 2 3 4 5 6 7 8 9 10 
		// 11 12 13 14 15 16 17 18 19 20
		
		
		return new PageInfo(currentPage, listCount, pageLimit, maxPage, startPage, endPage, boardLimit);
	}
}
