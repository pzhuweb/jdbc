package cn.pzhu.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhu.dao.CarDAO;
import cn.pzhu.dao.CarDAOImp;
import cn.pzhu.pojo.Car;
import cn.pzhu.util.DataUtil;

/**
 * Servlet implementation class SelectCarServlet
 */
@WebServlet("/SelectCarServlet")
public class SelectCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CarDAO dao = new CarDAOImp();
		ArrayList<Car> list =dao.select();
		//二次加工
		String s_page = request.getParameter("page");
		String s_num = request.getParameter("num");
		int page = 1;
		int num = 10;
		try {
			page = Integer.parseInt(s_page);
		} catch (Exception e) {
			page=1;			
		}
		try {
			num = Integer.parseInt(s_num);
		} catch (Exception e) {
			num = 10;
		}
		
		StringBuffer bar = DataUtil.createBar(list, num, page);
				
		list = DataUtil.split(list, num, page);
		request.getSession().setAttribute("list", list);
		request.getSession().setAttribute("bar", bar);
		response.sendRedirect("show.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
