package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDAO;
import model.dto.MemberDTO;

@WebServlet("/view/login.do")
public class LoginServlet extends HttpServlet {

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
		
		//아이디 기억하기 체크시 'ck'값을 받아온다. 체크 안할시 null값 처리 해줘야한다.
		String chkId = req.getParameter("chkId");

		
		MemberDTO dto = dao.loginCheck(userId);
		
		//로그인폼에서 포스트 요청을 포워드로 다른 페이지넘겨줬을 때 get요청과 연결되면 오류나는것 같다.? 리다이렉트 써야함.
		if (userId.equals(dto.getUserId()) && userPass.equals(dto.getUserPass())) {
			//아이디 기억하기 체크시 쿠키생성
			if (chkId != null && chkId.equals("ck")) { //체크를 안하면 파라미터가 null을 가져오니깐 null과 "ck"를 비교하다가 에러가 발생해서 null 조건도 넣어줘야한다.
				Cookie cookie = new Cookie("userId", userId);
				cookie.setPath("/");
				cookie.setMaxAge(60 * 60 *24);
				
				Cookie cookie2 = new Cookie("checked", "checked");
				cookie2.setPath("/");
				cookie2.setMaxAge(60 * 60 *24);
				
				resp.addCookie(cookie);
				resp.addCookie(cookie2);
			} else { //체크 안할 시 쿠키 유지시간 만료시키기
				Cookie cookie = new Cookie("userId", null);
				cookie.setPath("/");
				cookie.setMaxAge(0);
				
				Cookie cookie2 = new Cookie("checked", null);
				cookie2.setPath("/");
				cookie2.setMaxAge(0);
				
				resp.addCookie(cookie);
				resp.addCookie(cookie2);
			}
			
			session.setAttribute("loginOK", dto);
			resp.sendRedirect("/view/home.do");
		} else {
			//아래 응답 url에는 get요청이 없기에 포워드 가능
			req.setAttribute("message", "ID 또는 PW를 확인하세요.");
			req.getRequestDispatcher("/view/loginForm.jsp").forward(req, resp);
		}
	}

}
