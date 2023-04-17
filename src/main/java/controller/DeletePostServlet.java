package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDAO;

@WebServlet("/view/deletePost.do")
public class DeletePostServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		ServletContext application = this.getServletContext();
		BoardDAO dao = new BoardDAO(application);
		
		String cNum = req.getParameter("cNum");
		int num = dao.deletePost(cNum); //삭제 성공시 1저장
		dao.close();
		
		PrintWriter out = resp.getWriter();
		if (num == 1) {
			String jsFunc = "<script>"
					+ " alert('게시글이 삭제되었습니다.'); "
					+ " location.href='/view/list.do'; "
					+ " </script>";
			
			out.print(jsFunc);
			
		} else {
			String jsFunc = "<script>"
					+ " alert('게시글 삭제에 실패했습니다.'); "
					+ " location.href='/view/list.do'; "
					+ " </script>";
			
			out.print(jsFunc);
		}
		
	}
}
