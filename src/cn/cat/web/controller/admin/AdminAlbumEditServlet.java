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
import cn.cat.entity.Album;


/**
 * Servlet implementation class AdminAlbumEditServlet
 */
@WebServlet("/manag/album_edit")
public class AdminAlbumEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlbumDao dao = (AlbumDao) DaoFactory.getInstance("albumDao");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAlbumEditServlet() {
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
		String url=request.getParameter("url");
			
		Album alb = dao.findOne(Long.valueOf(id));
		alb.setTitle(title);
		//alb.setUrl(url);
		
		try {
			dao.update(alb);
			
			response.sendRedirect(request.getContextPath() + "/album_list");
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
