package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.GalleryPaging;
import model.dao.BoardDAO;
import model.dto.BoardDTO;

@WebServlet("/view/gallery.do")
public class GalleryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Map<String, Object> map = new HashMap<>(); 
		ServletContext application = this.getServletContext();
		BoardDAO dao = new BoardDAO(application);	
		
		// 페이징 시작
		int pageSize = 10;

		int pageNum = 1; // 기본 1페이지
		int allContents = dao.allGalleryContents();
		String pageTemp = req.getParameter("pageNum"); // 페이지 번호 클릭하면 쿼리스트링으로 요청하는 파라미터
		if (pageTemp != null && !pageTemp.equals("")) {
			pageNum = Integer.parseInt(pageTemp);
		}

		int start = (pageNum - 1) * pageSize + 1; // rownum 쿼리에 들어갈 시작번호
		int end = pageNum * pageSize; // 끝번호
		map.put("start", start);
		map.put("end", end);

		String pagingStr = GalleryPaging.galleryPagingStr(allContents, pageNum);
		req.setAttribute("pagingStr", pagingStr);
		// 페이징 끝 
		
		List<BoardDTO> list = dao.selectGallery(map);
		dao.close();
		
		req.setAttribute("galleryList", list);
		
		req.getRequestDispatcher("/view/gallery.jsp").forward(req, resp);
		
	}//doGet

}





















