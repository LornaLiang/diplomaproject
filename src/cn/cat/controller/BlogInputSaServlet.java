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
 * Servlet implementation class BlogInputSaServlet
 */
@WebServlet("/web_input_search")
public class BlogInputSaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogDao dao=(BlogDao) DaoFactory.getInstance("blogDao");  
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public BlogInputSaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		String i=request.getParameter("input");
		String in=new String(i.getBytes("ISO-8859-1"),"utf-8");
		String input="%"+in+"%";
		//获取输入框的字段
        //System.out.println(input+"%%%%");
		List<Blog> list=dao.finds(input);
		request.setAttribute("list", list);	
	
		request.getRequestDispatcher("/search_by_input.jsp").forward(request, response);
		
		
		
		
		
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
