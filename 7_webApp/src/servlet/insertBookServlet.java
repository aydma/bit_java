package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO_Oracle;
import dao.BookDAO_t;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;

/**
 * Servlet implementation class insertBookServlet
 */
@WebServlet("/insertBook.do")
public class insertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		System.out.println("/insertBook.do 요청 처리"); 
		
	
		BookDAO_t dao = new BookDAO_Oracle();
		BookService service = new BookServiceImpl(dao);
		
		BookVO vo = new BookVO();
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setBookname(request.getParameter("bookname"));
		vo.setPublisher(request.getParameter("publisher"));
		
		try {
			service.addBook(vo);			
			response.sendRedirect("listBook.do"); // 등록한 책을 리스트에 넣어 출력   응답이 가고 재요청이 오는게 sendRedirect
		} catch (Exception e) {
			
			request.setAttribute("exception", new Exception("등록 데이터 확인 후 다시 등록하세요 "));
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
		
	}

}
