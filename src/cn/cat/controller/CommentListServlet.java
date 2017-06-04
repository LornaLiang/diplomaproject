package cn.cat.controller;

import java.io.IOException;
import java.util.List;
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
 * Servlet implementation class CommentListServlet
 */
@WebServlet("/web/list_comment")
public class CommentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentDao dao=(CommentDao) DaoFactory.getInstance("commentDao");
	private BlogDao daos=(BlogDao) DaoFactory.getInstance("blogDao");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("blog_id");
	     List<Comment> list = dao.find(Long.parseLong(id));
	     //for(Comment c:list){
	     //输出测试System.out.println(c.getContent()+"**********");
	     //}	
	    
			
			
			
			Blog blog = daos.findOne(Long.valueOf(id));
			int read=blog.getClick_times();
			System.out.println("read="+read);		
			int r=read-1;
			System.out.println("r="+r);
		    blog.setClick_times(r);
		    try {
				daos.update(blog);
				
				
			} catch (DaoException e) {
				e.printStackTrace();
			}
		    request.setAttribute("list", list);
		    request.getRequestDispatcher("/web_blog_detail?id="+id).forward(request, response);
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
