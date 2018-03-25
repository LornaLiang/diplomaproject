package cn.cat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.cat.dao.BlogDao;
import cn.cat.dao.CommentDao;
import cn.cat.dao.common.DaoException;
import cn.cat.dao.common.DaoFactory;
import cn.cat.entity.Blog;
import cn.cat.entity.Comment;

/**
 * Servlet implementation class CommentAddServlet
 */
@WebServlet("/web/add_comment")
public class CommentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   private CommentDao dao=(CommentDao) DaoFactory.getInstance("commentDao");  
   private BlogDao daob=(BlogDao) DaoFactory.getInstance("blogDao");
   
   /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentAddServlet() {
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
	//	response.setCharacterEncoding("UTF-8");
        Long blog_id=Long.parseLong(request.getParameter("blog_id"));
        String content = request.getParameter("content");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式	
		String create_time=df.format(new Date());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
     	Comment comm = new Comment();
     	comm.setUsername(username);
		comm.setEmail(email);
		comm.setContent(content);
		comm.setCreate_time(create_time);
		comm.setBlog_id(blog_id);
		dao.save(comm);
	    System.out.println(content);
		
	    	
		//统计对应评论数量
		String idStr = request.getParameter("blog_id");	
		Blog blog = daob.findOne(Long.valueOf(idStr));
		int count = blog.getComment_times();
		if(count != 0){
		       count++;
		    	  }
		    else{
		    	  count = 1;	 	
		    	  }
		    request.setAttribute("comment_times", count);
        
		    //将数据写进数据库
		    
		    blog.setComment_times(count);

			try {
				daob.update(blog);
				
				
			} catch (DaoException e) {
				e.printStackTrace();
			}
		   
		   System.out.println("评论***"+count);
		   
		   int read=blog.getClick_times()-1;
		  
		   blog.setClick_times(read);
		   request.getRequestDispatcher("/web/list_comment?id="+blog_id).forward(request, response);	
		   
		 
		
	}

	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		doGet(request,response);	
}
}
