package cn.cat.web.controller.admin;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

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
		/*String id = request.getParameter("id");
		String title = request.getParameter("title");
		String url=request.getParameter("url");
			
		Album alb = dao.findOne(Long.valueOf(id));
		alb.setTitle(title);
		//alb.setUrl(url);
		 * */
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		//Request 对象在 HTTP 请求期间，检索客户端浏览器传递给服务器的值 
		if (!isMultipart) {
			request.setAttribute("message", "表单提交有误，请重新提交");
			request.getRequestDispatcher("/album_list").forward(
					request, response);
			return;
		}
		
		//public DiskFileItemFactory()
	      //采用默认临界值和系统临时文件夹构造文件项工厂对象。
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//方法可以将通过表单中每一个HTML标签提交的数据封装成一个FileItem对象，然后以List列表的形式返回。
		ServletFileUpload sfu = new ServletFileUpload(factory);
		List<FileItem> items = null;
		try {
			items = sfu.parseRequest(request);
			
			/*  parseRequest 方法是ServletFileUpload类的重要方法，
			 * 它是对HTTP请求消息体内容进行解析的入口方法。它解析出FORM表单中的每个字段的数据，
			 * 并将它们分别包装成独立的FileItem对象，
			 * 然后将这些FileItem对象加入进一个List类型的集合对象中返回*/
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			System.err.println("无法获取对象！！！");
			e.printStackTrace();
		}
		Album alb= new Album();
		for (FileItem item : items) {
			/*item.isFormField()用来判断当前对象是否是file表单域的数据  
			如果返回值是true说明不是 就是普通表单域 
			*/
			// 封装这些基本数据到Album中
			System.out.println(item.getFieldName()+item.isFormField()+")))))))))");
			if (item.isFormField()) {
				String filedName = item.getFieldName();
				System.out.println(filedName);
				String filedValue = item.getString(request.getCharacterEncoding());
				System.out.println(filedValue);
				try {
					BeanUtils.setProperty(alb, filedName, filedValue);
				} catch (IllegalAccessException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					System.err.println("找不到BeaUtils对应属性名！！！");
					e.printStackTrace();
				}
			} else {
				// 文件上传
				String fileName = item.getName();
				// 改文件名
				if (fileName != null && fileName.trim() != "") {
					fileName = UUID.randomUUID().toString() + "."
							+ FilenameUtils.getExtension(fileName);
					System.out.println(fileName+"************************");
					// 计算存贮路径
					String storeDirecotry = getServletContext().getRealPath(
							"/images");
					System.out.println("***********"+storeDirecotry);
					String photoPath =makeDirs(storeDirecotry, fileName);					
				    alb.setUrl(photoPath);
					alb.setPhotoname(fileName);
					System.out.println("^^^^^^^^^^^^^^^^^"+photoPath);
					System.out.println("************************"+fileName);

					// 上传
					
					try {
						item.write(new File(storeDirecotry + photoPath + "/" + fileName));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
		
		try {
			dao.update(alb);
			
			response.sendRedirect(request.getContextPath() + "/album_list");
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		
	}

	//产生多级目录
		public String makeDirs(String storeDirecotry, String filename) {
			int hashCode = filename.hashCode();
			int dir1 = hashCode & 0xf;
			int dir2 = (hashCode & 0xf0) >> 4;
			String newPath = "/" + dir1 + "/" + dir2;
			File file = new File(storeDirecotry, newPath);
			if (!file.exists()) {
				file.mkdirs();
			}
			return newPath;
		}
		 
		/*
		try {
			dao.update(alb);
			
			response.sendRedirect(request.getContextPath() + "/album_list");
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		
	
	}
*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
