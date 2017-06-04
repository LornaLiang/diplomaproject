package cn.cat.web.controller.admin;

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
import cn.cat.entity.common.Page;




/**
 * Servlet implementation class AdminBlogList
 */
@WebServlet("/blog_list")
public class AdminBlogList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogDao dao = (BlogDao) DaoFactory.getInstance("blogDao");
    /**
     * @see HttpServlet#HttpServlet()
     */
 	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
		int size = 10;
		
		//1.获取请求数据:分页参数
		request.setCharacterEncoding("UTF-8");
		String p = request.getParameter("page");
		String s = request.getParameter("size");
		if(null != p && !"".equals(p)){
			page = Integer.parseInt(p);
		}
		if(page < 1){
			page = 1;
		}
		if(null != s && !"".equals(s)){
			size = Integer.parseInt(s);
		}
		if(size < 1){
			size = 10;
		}
		
		
      //List<Blog> list = dao.findAll();
      Page<Blog> pager = dao.findAll(page, size);
		request.setAttribute("alist", pager);

		request.getRequestDispatcher("/manag/admin_bloglist.jsp").forward(request, response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
