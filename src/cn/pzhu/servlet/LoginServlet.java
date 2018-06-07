package cn.pzhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhu.dao.UserDAO;
import cn.pzhu.dao.UserDAOImp;
import cn.pzhu.pojo.User;
import cn.pzhu.util.Conver2MD5;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		password = Conver2MD5.getMD5(password);
		UserDAO dao = new UserDAOImp();
		if (dao.login(new User(username, password))) {
			//将登录标志位保存到session作用域中
			//servlet中不能直接使用session
			request.getSession().setAttribute("login","yes");
			request.getSession().setAttribute("username",username);
			
			String isSave = request.getParameter("isSave");
			if (isSave==null) {
				//不保存，将原来的信息清除掉
				clearInfo(request, response);
			} else {
				//保存信息
				saveInfo( request, response);
			}		
			
			out.print("<script>alert('登录成功!');window.location.href='index.jsp'</script>");
			
		} else {
			out.print("<script>alert('登录失败!');window.location.href='login.jsp'</script>");
		}
		
		
	}

	private void saveInfo(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		//对中文进行编码
		try {
			username = URLEncoder.encode(username, "UTF-8");
			password = URLEncoder.encode(password, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		
		Cookie cookie_username = new Cookie("username", username);
		response.addCookie(cookie_username);
		
		Cookie cookie_password = new Cookie("password", password);
		response.addCookie(cookie_password);
	}

	private void clearInfo(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookie_username = new Cookie("username", "");
		cookie_username.setMaxAge(0);
		response.addCookie(cookie_username);
		
		Cookie cookie_password = new Cookie("password", "");
		cookie_username.setMaxAge(0);
		response.addCookie(cookie_password);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
