package cn.cat.web.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.cat.dao.AlbumDao;
import cn.cat.dao.common.DaoFactory;
import cn.cat.entity.Album;
import cn.cat.entity.Blog;
import cn.cat.entity.common.Page;

/**
 * Servlet implementation class AdminAlbumList
 */
@WebServlet("/album_list")
public class AdminAlbumList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlbumDao dao = (AlbumDao)DaoFactory.getInstance("albumDao");  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAlbumList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
     //List<Album> list = dao.findAll();
		int page = 1;
		int size = 10;
		
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
			size = 10;
		}
		
		Page<Album> pager = dao.findAll(page, size);
		request.setAttribute("list", pager);
		request.getRequestDispatcher("/manag/admin_albumlist.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		doGet(request, response);
	}

}
