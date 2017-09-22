package com.xinpeng.servlet;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xinpeng.dao.UserDao;
import com.xinpeng.model.User;

public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if ("login".equals(flag)) { // 登录
			String userName = request.getParameter("userName");
			String userPassword = request.getParameter("userPassword");
			String checkbox = request.getParameter("checkbox");
			// System.out.println(checkbox);
			User user = UserDao.login(userName, userPassword);
			// 添加cookie的信息
			Cookie cookie = null;
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("username", user.getUsername());
				if ("on".equals(checkbox)) {
					cookie = new Cookie("userName", userName);
					cookie.setMaxAge(24 * 60 * 60);// 存放一天的时间
					response.addCookie(cookie);
					cookie = new Cookie("userPassword", userPassword);
					cookie.setMaxAge(24 * 60 * 60);// 存放一天的时间
					response.addCookie(cookie);
				}
				response.sendRedirect("admin/adminTemp.jsp");
			} else {
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(
						"<script>alert('用户名或密码不正确！');history.go(-1);</script>");
				// history是当前页面对象，go(-1)是倒退到前一个网页
			}
		} else if ("logout".equals(flag)) { // 退出登录
			request.getSession().invalidate();
			response.sendRedirect("login.jsp");
		} else if ("reg".equals(flag)) { // 注册
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			// 判断用户是否已被注册
			boolean isExist = UserDao.checkUserName(username);
			if (isExist) {
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(
						"<script>alert('该用户已注册！');history.go(-1);</script>");
				// history是当前页面对象，go(-1)是倒退到前一个网页
			} else {
				boolean isReg = UserDao.reg(user);
				if (isReg) {
					response.sendRedirect("login.jsp");
				} else {
					response.sendRedirect("admin/register.jsp");
				}
			}

		} else if ("userList".equals(flag)) { // 多用户查询
			String userid = request.getParameter("userid");
			List<User> userList = UserDao.getUsers(userid);
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("admin/userList.jsp").forward(request,response);
			
		}/* else if ("user".equals(flag)) { // 单用户查询ByID
			String userid = request.getParameter("userid");
			User user = UserDao.getUserByID(userid);
			request.setAttribute("user", user);
			request.getRequestDispatcher("admin/userList.jsp").forward(request,response);
			
		}*/
		  else if ("delete".equals(flag)) {	//	删除用户信息
			String uid = request.getParameter("userid");
			int userid = Integer.parseInt(uid);
			//boolean f = UserDao.deleteUserByID(userid);//	物理删除用户信息
			boolean f = UserDao.updateUserStateByID(userid);	//	逻辑删除用户信息
			if (f) {
				response.sendRedirect("admin/default.jsp");
				//request.getRequestDispatcher("UserServlet?flag=userList").forward(request,response);
			}else {
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(
						"<script>alert('删除失败！');history.go(-1);</script>");
			}
		} else if ("toUpdate".equals(flag)) { // 跳转到修改页	
			String userid = request.getParameter("userid");
			//根据ID查询用户信息
			User user = UserDao.getUserByID(userid);
			request.setAttribute("user", user);
			request.getRequestDispatcher("admin/userUpdate.jsp").forward(request,response);
			
		} else if ("update".equals(flag)) {	//	修改用户密码
			String uid = request.getParameter("userid");
			int userid = Integer.parseInt(uid);
			String password = request.getParameter("password");
			boolean f = UserDao.updateUserByID(userid,password);	//	修改用户密码
			if (f) {
				request.getRequestDispatcher("UserServlet?flag=userList").forward(request,response);
			}else {
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(
						"<script>alert('修改失败！');history.go(-1);</script>");
			}
		} 	
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
