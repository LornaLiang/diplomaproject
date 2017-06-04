package cn.cat.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.cat.dao.InfoDao;
import cn.cat.dao.common.DaoFactory;
import cn.cat.entity.Info;

/**
 * Servlet implementation class ConutClickSerrvlet
 */
@WebServlet("/web_click")
public class ConutClickSerrvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InfoDao dao=(InfoDao) DaoFactory.getInstance("infoDao");   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConutClickSerrvlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
				
		
		
		
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
