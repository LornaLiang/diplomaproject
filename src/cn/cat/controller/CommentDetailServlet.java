package cn.cat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.cat.dao.CommentDao;
import cn.cat.dao.common.DaoFactory;
import cn.cat.entity.Comment;

/**
 * Servlet implementation class CommentDetailServlet
 */
@WebServlet("/web/comment_detail")
public class CommentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentDao dao=(CommentDao) DaoFactory.getInstance("commentDao");  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String idStr = request.getParameter("id");	
		Comment comment = dao.findOne(Long.valueOf(idStr));
		
		request.setAttribute("comment", comment);
		request.getRequestDispatcher("/blogdetail.jsp").forward(request, response);
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
