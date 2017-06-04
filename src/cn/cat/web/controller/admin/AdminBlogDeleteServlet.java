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


/**
 * Servlet implementation class AdminBlogDeleteServlet
 */
@WebServlet("/manag/blog_delete")
public class AdminBlogDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogDao dao=(BlogDao) DaoFactory.getInstance("blogDao");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBlogDeleteServlet() {
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
		
		try {
			dao.delete(Long.valueOf(id));
			
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
