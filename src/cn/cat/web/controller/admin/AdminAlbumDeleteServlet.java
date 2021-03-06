package cn.cat.web.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.cat.dao.AlbumDao;
import cn.cat.dao.common.DaoException;
import cn.cat.dao.common.DaoFactory;

/**
 * Servlet implementation class AdminAlbumDeleteServlet
 */
@WebServlet("/manag/album_delete")
public class AdminAlbumDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlbumDao dao=(AlbumDao) DaoFactory.getInstance("albumDao");  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAlbumDeleteServlet() {
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
			
			response.sendRedirect(request.getContextPath() + "/album_list");
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
