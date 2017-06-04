package cn.cat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.cat.dao.BlogDao;
import cn.cat.dao.common.DaoException;
import cn.cat.dao.common.DaoFactory;
import cn.cat.entity.Blog;

/**
 * Servlet implementation class BlogDetailServlet
 */
@WebServlet("/web_blog_detail")
public class BlogDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogDao dao=(BlogDao) DaoFactory.getInstance("blogDao"); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogDetailServlet() {
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
		Blog blog = dao.findOne(Long.valueOf(idStr));
		request.setAttribute("blog", blog);
		//获取点击量
		int count=blog.getClick_times();
	    //Integer count = (Integer)request.getAttribute("click_times");
		    
		    if(count != 0){
		       count = 1 + count;
		    	  }
		    else{
		    	  count = 1;	 	
		    	  }
		  
		 request.setAttribute("click_times", count);
		 
        //将数据写进数据库
		    blog.setClick_times(count);
			

			try {
				dao.update(blog);
				
				
			} catch (DaoException e) {
				e.printStackTrace();
			}
		    //输出测试
		    //System.out.println("点击量"+count);
		
		
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
