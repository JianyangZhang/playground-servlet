/*
 * 这个是Servlet, 并不是Controller
 * 一般MVC中没有Servlet, 只有Controller。Controller是对同类Servlet的一个"整合"
 * 一个Servlet是把一个url映射到一个类上
 * 那么我们可能有 CreateDemoServlet DeleteDemoServlet UpdateDemoServlet GetDemoServlet 四个servlet类
 * 这个就可以简化为一个Controller, 把一个url映射到一个方法上
 * 那么上述四个Servlet就可以作为四个方法写进一个DemoController类里 
 * */
package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/time")
public class HelloServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = dateFormat.format(new Date());
		req.setAttribute("currentTime", currentTime);
		req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
	}
}
