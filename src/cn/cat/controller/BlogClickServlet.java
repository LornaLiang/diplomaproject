package cn.cat.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.cat.dao.BlogDao;
import cn.cat.dao.common.DaoFactory;
import cn.cat.entity.Blog;

/**
 * Servlet implementation class BlogClickServlet
 */
@WebServlet("/web_click_order")
public class BlogClickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogDao dao = (BlogDao) DaoFactory.getInstance("blogDao");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogClickServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8");	
		
		List<Blog> list = dao.findRead();
		
		request.setAttribute("list",list);
		
		request.getRequestDispatcher("/commonindex.jsp").forward(request, response);
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
