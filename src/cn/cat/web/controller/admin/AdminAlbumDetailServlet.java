package cn.cat.web.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.cat.dao.AlbumDao;
import cn.cat.dao.common.DaoFactory;
import cn.cat.entity.Album;
import cn.cat.entity.Blog;

/**
 * Servlet implementation class AdminAlbumDetailServlet
 */
@WebServlet("/manag/album_detail")
public class AdminAlbumDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlbumDao dao=(AlbumDao) DaoFactory.getInstance("albumDao");  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAlbumDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("content-type", "text/html;charset=UTF-8"); 
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String idStr = request.getParameter("id");	
		Album album = dao.findOne(Long.valueOf(idStr));
		
		request.setAttribute("album", album);
		request.getRequestDispatcher("/manag/album_detail.jsp").forward(request, response);
		
		
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
		
	}

}
