package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDAO;
import model.dto.BoardDTO;

@WebServlet("/view/selectList.do")
public class SelectListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		ServletContext application = this.getServletContext();
		BoardDAO dao = new BoardDAO(application);
		
		String cNum = req.getParameter("cNum");
		
		//조회수 1증가
		dao.updateVisitNum(cNum);				
		
		//상세 게시물 가져오기
		BoardDTO dto = dao.selectTitle(cNum);
		dao.close();
		
		req.setAttribute("BoardDTO", dto);
		
		req.getRequestDispatcher("/view/selectList.jsp").forward(req, resp);
		
		
	}
}





















