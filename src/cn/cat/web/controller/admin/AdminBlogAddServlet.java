package cn.cat.web.controller.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import cn.cat.dao.BlogDao;
import cn.cat.dao.common.DaoFactory;
import cn.cat.entity.Album;
import cn.cat.entity.Blog;

/**
 * Servlet implementation class AdminBlogAddServlet
 */
@WebServlet("/manag/add_blog")
public class AdminBlogAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
private BlogDao dao=(BlogDao) DaoFactory.getInstance("blogDao");
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBlogAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		/*不带图片上传
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String type = request.getParameter("type");
		String pic_url = request.getParameter("pic_url");
		String content = request.getParameter("content");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式	
		String create_time=df.format(new Date());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
     	Blog blo = new Blog();
		blo.setTitle(title);
		blo.setType(type);
		blo.setPic_url(pic_url);
		blo.setContent(content);
		blo.setCreate_time(create_time);
		*/
		request.setCharacterEncoding("UTF-8");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			request.setAttribute("message", "表单提交有误，请重新提交");
			request.getRequestDispatcher("/blog_list").forward(
					request, response);
			return;
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		List<FileItem> items = null;
		try {
			items = sfu.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			System.err.println("无法获取对象！！！");
			e.printStackTrace();
		}
		Blog blog= new Blog();
		for (FileItem item : items) {
			// 封装这些基本数据到Blog中
			if (item.isFormField()) {
				String filedName = item.getFieldName();
				System.out.println(filedName);
				String filedValue = item.getString(request.getCharacterEncoding());
				System.out.println(filedValue);
				try {
					BeanUtils.setProperty(blog, filedName, filedValue);
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
				     blog.setPic_url(photoPath);
					blog.setPhotoname(fileName);
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
		
		dao.save(blog);
		response.sendRedirect(request.getContextPath() + "/blog_list");
		
		
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
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	

}
