package cn.cat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.cat.dao.AlbumDao;
import cn.cat.dao.common.DaoFactory;
import cn.cat.entity.Album;
import cn.cat.entity.common.Page;

/**
 * Servlet implementation class AlbumListServlet
 */
@WebServlet("/web_album_list")
public class AlbumListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlbumDao dao = (AlbumDao)DaoFactory.getInstance("albumDao");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
		int size = 12;
		
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
			size = 12;
		}
		
		//List<Album> list = dao.findAll();
		Page<Album> pager = dao.findAll(page, size);
		request.setAttribute("list", pager);
		request.getRequestDispatcher("/album.jsp").forward(request, response);
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
