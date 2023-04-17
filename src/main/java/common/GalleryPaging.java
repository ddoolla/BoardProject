package common;

public class GalleryPaging {

	public static String galleryPagingStr(int allContent, int pageNum) {
		int pageSize = 10;
		int pageBlock = 5;
		String url = "./gallery.do";
		
		String pagingStr = "";
		
		//전체 페이지 개수
		int totalPages = (int)(Math.ceil((double)allContent / pageSize));
		
		// << < 1 | 2 | 3 | 4 | 5 > >> 형태 만들기
		
		int pageTemp = (((pageNum - 1) / pageBlock) * pageBlock) + 1; //각 블록 시작 페이지 번호 1, 6, 11, ...
		
		// << <
		if (pageTemp != 1) {
			pagingStr += "<a href='" + url + "?pageNum=1'>《 </a>"; //첫 페이지로 이동
			pagingStr += "<a href='" + url + "?pageNum=" + (pageTemp - 1)+ "'>〈 </a>"; //이전 블록으로 이동
		}
		
		// 1 | 2 | 3 | 4 | 5
		int cnt = 1; //5번을 만들기 위한 카운트
		while (cnt <= pageBlock && pageTemp <= totalPages) { //5번 반복 단,시작번호가 전체페이지번호보다 클수는 없게(게시물이 있는 페이지까지만)
			
			if (pageTemp == pageNum) { //현재페이지는 링크를 걸지 않는다.
				pagingStr += "<span>" + pageTemp + "</span>";
			} else {
				pagingStr += "<a href='" + url + "?pageNum=" + pageTemp;
				pagingStr += "'>" + pageTemp + "</a>";
			}
			
			if (cnt != pageBlock) { //페이지 번호 사이에 구분기호를 추가한다.(마지막은 안들어가게 조건)
				pagingStr += " | ";
			}
			pageTemp++; //시작번호를 1씩 증가시켜서 하나씩 큰번호를 출력한다.
			cnt++;
		}
		
		// > >>
		if (pageTemp <= totalPages) {
			pagingStr += "<a href='" + url + "?pageNum=" + pageTemp + "'> 〉 </a>"; //while문에서 pageStart가 증가되어있다.
			pagingStr += "<a href='" + url + "?pageNum=" + totalPages + "'> 》</a>";
		}
		
		return pagingStr;
		
	}
	
}

