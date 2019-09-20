package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO_Oracle;
import dao.BookDAO_t;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;

//@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf('/'));
		System.out.println(action);
		if(action.equals("/login.do")) {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			System.out.println("/login.do 요청 처리"); 
			System.out.println(id+"/"+pw); 
			
			if(id==null||pw==null||id.length()==0||pw.length()==0) {
//				response.sendRedirect("./login.jsp");
				request.setAttribute("msg", "pw 정보를 입력하세요");
				request.setAttribute("id", id); // login.jsp로 돌아갔을때 입력했던 아이디 살림
				request.getRequestDispatcher("login.jsp").forward(request, response); // request로 login.jsp에 접근한다.
				return;
			}
			if(id.equals("java01") && pw.equals("1234")) {
				HttpSession session = request.getSession();
				session.setAttribute("login", id+"/홍자바");
				
				request.getRequestDispatcher("index.jsp").forward(request, response); 
				
			}else {
				request.setAttribute("msg", "로그인 실패");
				request.setAttribute("id", id); 
				
				request.getRequestDispatcher("login.jsp").forward(request, response); 
			}
			return;
		}
		if(action.equals("/listbook.do")) {
			HttpSession session = request.getSession();
	        String login = (String) session.getAttribute("login");
	        if(login ==  null) {
	        	request.setAttribute("msg", "로그인이 필요한 서비스입니다.");
	        	request.getRequestDispatcher("login.jsp").forward(request, response);
	        	return;
	        }
		
		BookDAO_t dao = new BookDAO_Oracle();
		BookService service = new BookServiceImpl(dao);
		List<BookVO> list = service.bookList();

		request.setAttribute("booklist", list);
		String view = "/booklist.jsp"; // booklist를 출력해주는 페이지
		
		getServletContext().getRequestDispatcher(view).forward(request, response); // view페이지로 제어권넘어감
		
			return;
		}
		if(action.equals("/deletebook.do")) {
			String[] bookid = request.getParameterValues("bookid");
			String img = request.getParameter("img");
			String fname = img.substring(img.lastIndexOf('/')+1);
			String path = request.getRealPath("/upload/");
			
			File f = new File(path+fname);
			if(f.exists()) { //존재하는지 확인
				f.delete();
			}
			
			
			BookDAO_t dao = new BookDAO_Oracle();
			BookService service = new BookServiceImpl(dao);
			
			try {
				for(String data:bookid) {
					
					service.deleteBook(Integer.parseInt(data));
				}
				
				response.sendRedirect("listBook.do");
			} catch (Exception e) {
				request.setAttribute("exception", e);
				
				request.getRequestDispatcher("/error.jsp").forward(request, response);;
			}	
			return;
		}
		
		if(action.equals("/logout.do")) {
			HttpSession session = request.getSession();
			if(session != null) {
				session.invalidate(); // 세션객체파괴
			}
			response.sendRedirect("./index.jsp");
		}
	
	
	}

}
