package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDAO;
import model.dto.MemberDTO;

@WebServlet("/view/login.do")
public class loginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		ServletContext application = this.getServletContext();
		MemberDAO dao = new MemberDAO(application);
		HttpSession session = req.getSession();
		
		String userId = req.getParameter("userId");
		String userPass = req.getParameter("userPass");

		
		MemberDTO dto = dao.loginCheck(userId);
		//로그인폼에서 포스트 요청을 포워드로 다른 페이지넘겨줬을 때 get요청이 있으면 오류나는것 같다.? 리다이렉트 써야함.
		if (userId.equals(dto.getUserId()) && userPass.equals(dto.getUserPass())) {
			session.setAttribute("loginOK", dto);
			resp.sendRedirect("/view/home.do");
		} else {
			//아래 응답 url에는 get요청이 없기에 포워드 가능
			req.setAttribute("message", "ID 또는 PW를 확인하세요.");
			req.getRequestDispatcher("/view/loginForm.jsp").forward(req, resp);
		}
	}

}
