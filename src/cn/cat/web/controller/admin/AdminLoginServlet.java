package cn.cat.web.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.cat.dao.AdminDao;
import cn.cat.dao.common.DaoFactory;
import cn.cat.entity.Admin;


/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/adm_login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminDao dao = (AdminDao) DaoFactory.getInstance("adminDao"); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		Admin man = dao.findByName(name);
		if (man == null) {
			out.println("用户名不存在,请<a href='login.jsp'>重新输入</a>");
		} else if (!password.equals(man.getPassword())) {
			out.println("密码错误,请<a href='login.jsp'>重新输入</a>");
		} else {
			//将man对象存到session域中
			request.getSession().setAttribute("man", man);
			//重定向
			response.sendRedirect(request.getContextPath() + "/manag/success.jsp");
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
