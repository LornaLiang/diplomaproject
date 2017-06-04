package cn.cat.web.controller.admin;

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
 * Servlet implementation class AdminBlogEditServlet
 */
@WebServlet("/manag/blog_edit")
public class AdminBlogEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogDao dao = (BlogDao) DaoFactory.getInstance("blogDao");  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBlogEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String type = request.getParameter("type");
		String pic_url=request.getParameter("pic_url");
		
		Blog blo = dao.findOne(Long.valueOf(id));
		blo.setTitle(title);
		blo.setContent(content);
		blo.setType(type);
		//blo.setPic_url(pic_url);
		try {
			dao.update(blo);
			
			response.sendRedirect(request.getContextPath() + "/blog_list");
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
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
