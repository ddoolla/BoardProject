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
		
		String cNum = req.getParameter("cNum");
		
		BoardDAO dao = new BoardDAO(application);
		
		BoardDTO dto = dao.selectTitle(cNum);
		
		req.setAttribute("BoardDTO", dto);
		
		req.getRequestDispatcher("/view/selectList.jsp").forward(req, resp);
		
		
	}
}





















