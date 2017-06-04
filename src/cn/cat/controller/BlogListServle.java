package cn.cat.controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.cat.dao.BlogDao;
import cn.cat.dao.InfoDao;
import cn.cat.dao.common.DaoException;
import cn.cat.dao.common.DaoFactory;
import cn.cat.entity.Blog;
import cn.cat.entity.Info;
import cn.cat.entity.common.Page;

/**
 * Servlet implementation class BlogListServle
 */
@WebServlet("/web_blog_list")
public class BlogListServle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogDao dao = (BlogDao) DaoFactory.getInstance("blogDao");
	private InfoDao daoa = (InfoDao) DaoFactory.getInstance("infoDao");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogListServle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   
		int page = 1;
		int size = 5;
		
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
			size = 5;
		}
		
		//List<Blog> list = dao.findAll();
		Page<Blog> pager = dao.findAll(page, size);
		request.setAttribute("list", pager);

	
  
	request.getRequestDispatcher("/commonindex.jsp").forward(request, response);
	
	/*
	ServletContext application = getServletContext();
	
	Integer count = (Integer)application.getAttribute("history_click_times"); 
	
	
	  if(count !=  null){
	      count++;
		  }
	   else{
		  count = 1;	 	
		  }
	   
	    
	   application.setAttribute("history_click_times", count);   
	    
	   //将数据写进数据库
	   
		Info info = daoa.findC(Integer.valueOf(count));
	    info.setHistory_click_times(count);

	    try {
		daoa.update(info);
		
		
	    } catch (DaoException e) {
		e.printStackTrace();
	    }
			
	
	    System.out.print(count+"%%%%%");
	    */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
