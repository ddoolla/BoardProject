package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.oreilly.servlet.MultipartRequest;

import model.dao.BoardDAO;
import model.dto.BoardDTO;

@WebServlet("/view/updatePost.do")
public class UpdatePostServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		ServletContext application = this.getServletContext();
		BoardDAO dao = new BoardDAO(application);
		BoardDTO dto = new BoardDTO();
		
		//cos라이브러리 사용 writeForm의 enctype속성이 "multipart/form-data"라서 request.getParameter 사용 못함
		String saveDirectory = application.getRealPath("/upload"); //upload 폴더 물리적 경로
		int maxPostSize = 1024 * 1000; //파일 최대 크기 1MB 설정
		String encoding = "UTF-8"; //인코딩 방식
		
		int num = 0; // updateWrite() 성공하면 1저장
		
		try {
			MultipartRequest mr = new MultipartRequest(req, saveDirectory, maxPostSize, encoding);
			
			if (mr.getFilesystemName("myFile") != null) { //파일을 새로 저장 했을때 (기존 이미지 말고)
				
				String fileName = mr.getFilesystemName("myFile"); //현재 파일 이름
					
				String extension = fileName.substring(fileName.lastIndexOf(".")); //파일 확장자 (파일이름 중간에 .이 들어갈 수 있으니깐 last로 쓴다.)
				String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date()); //오늘 날짜 시간을 가져온다 H: 0~24시간, S: 밀리세컨드
				String newFileName = now + extension; //새로운 파일 이름: 20230414_124013223.jsp 요런 형태로 들어감.

				File oldFile = new File(saveDirectory + File.separator + fileName); //원본 파일 객체를 생성
				File newFile = new File(saveDirectory + File.separator + newFileName); //새이름 파일 객체를 생성
				oldFile.renameTo(newFile); //원본 파일 이름을 새파일 이름으로 바꿈. 물리적 경로에 가보면 바뀌어 있음
				
				dto.setOriginalFile(fileName);
				dto.setNewNameFile(newFile.getName());
			}
			
			dto.setcNum(mr.getParameter("cNum"));
			dto.setTitle(mr.getParameter("title"));
			dto.setContent(mr.getParameter("content"));
			
			num = dao.updateWrite(dto);
			dao.close();
			
		} catch (Exception e) {
			System.out.println("updatePostServlet에서 예외발생");
			e.printStackTrace();
		}
		
		PrintWriter out = resp.getWriter();
		
		if (num == 1) { //성공하면 상세보기 페이지로 이동 
			String url = "/view/selectList.do?cNum=" + dto.getcNum();
			
			String jsFunc = "<script>"
					+ " alert('게시글이 수정되었습니다.'); "
					+ " location.href='" + url + "'; "
					+ " </script>";
			
			out.print(jsFunc);
			
		} else { //실패하면 게시글 수정페이지로
			String url = "/view/goUpdatePost.do?cNum=" + dto.getcNum();
			
			String jsFunc = "<script>"
					+ " alert('게시글을 다시 수정해주세요.'); "
					+ " location.href='" + url + "'; "
					+ " </script>";
			
			out.print(jsFunc);
		}
		
	}//doPost

}
















