package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO_Oracle;
import dao.BookDAO_t;
import service.BookService;
import service.BookServiceImpl;

//@WebServlet("/deleteBook.do")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
//		String bookid = request.getParameter("bookid");
		String[] bookid = request.getParameterValues("bookid");
//		System.out.println("deleteBook.do  =>  "+Arrays.toString(bookid));
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
	}
}