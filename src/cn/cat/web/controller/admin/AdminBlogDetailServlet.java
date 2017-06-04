package cn.cat.web.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.cat.dao.BlogDao;
import cn.cat.dao.common.DaoFactory;
import cn.cat.entity.Blog;


/**
 * Servlet implementation class AdminBlogDetailServlet
 */
@WebServlet("/manag/blog_detail")
public class AdminBlogDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BlogDao dao=(BlogDao) DaoFactory.getInstance("blogDao"); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBlogDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String idStr = request.getParameter("id");	
		Blog blog = dao.findOne(Long.valueOf(idStr));
		
		request.setAttribute("blog", blog);
		request.getRequestDispatcher("/manag/blog_detail.jsp").forward(request, response);
		
		
	}

}
