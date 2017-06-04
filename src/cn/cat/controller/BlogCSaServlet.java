package cn.cat.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.cat.entity.Blog;
import cn.cat.dao.BlogDao;

import cn.cat.dao.common.DaoFactory;

/**
 * Servlet implementation class BlogCSaServlet
 */
@WebServlet("/web_class_search")
public class BlogCSaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogDao dao=(BlogDao) DaoFactory.getInstance("blogDao");   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogCSaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int t=Integer.parseInt(request.getParameter("type"));
		String type=null;
        if(t==0){
        	
        	 type="学习";
        }
        else{ 
        	
        	type="生活";
        }
		
		System.out.println(type+"######");
		
		List<Blog> list=dao.find(type);
		System.out.println(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/blog_search.jsp").forward(request, response);
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
