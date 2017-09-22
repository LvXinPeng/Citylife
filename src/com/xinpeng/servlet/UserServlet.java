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
		if ("login".equals(flag)) { // ��¼
			String userName = request.getParameter("userName");
			String userPassword = request.getParameter("userPassword");
			String checkbox = request.getParameter("checkbox");
			// System.out.println(checkbox);
			User user = UserDao.login(userName, userPassword);
			// ���cookie����Ϣ
			Cookie cookie = null;
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("username", user.getUsername());
				if ("on".equals(checkbox)) {
					cookie = new Cookie("userName", userName);
					cookie.setMaxAge(24 * 60 * 60);// ���һ���ʱ��
					response.addCookie(cookie);
					cookie = new Cookie("userPassword", userPassword);
					cookie.setMaxAge(24 * 60 * 60);// ���һ���ʱ��
					response.addCookie(cookie);
				}
				response.sendRedirect("admin/adminTemp.jsp");
			} else {
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(
						"<script>alert('�û��������벻��ȷ��');history.go(-1);</script>");
				// history�ǵ�ǰҳ�����go(-1)�ǵ��˵�ǰһ����ҳ
			}
		} else if ("logout".equals(flag)) { // �˳���¼
			request.getSession().invalidate();
			response.sendRedirect("login.jsp");
		} else if ("reg".equals(flag)) { // ע��
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			// �ж��û��Ƿ��ѱ�ע��
			boolean isExist = UserDao.checkUserName(username);
			if (isExist) {
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(
						"<script>alert('���û���ע�ᣡ');history.go(-1);</script>");
				// history�ǵ�ǰҳ�����go(-1)�ǵ��˵�ǰһ����ҳ
			} else {
				boolean isReg = UserDao.reg(user);
				if (isReg) {
					response.sendRedirect("login.jsp");
				} else {
					response.sendRedirect("admin/register.jsp");
				}
			}

		} else if ("userList".equals(flag)) { // ���û���ѯ
			String userid = request.getParameter("userid");
			List<User> userList = UserDao.getUsers(userid);
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("admin/userList.jsp").forward(request,response);
			
		}/* else if ("user".equals(flag)) { // ���û���ѯByID
			String userid = request.getParameter("userid");
			User user = UserDao.getUserByID(userid);
			request.setAttribute("user", user);
			request.getRequestDispatcher("admin/userList.jsp").forward(request,response);
			
		}*/
		  else if ("delete".equals(flag)) {	//	ɾ���û���Ϣ
			String uid = request.getParameter("userid");
			int userid = Integer.parseInt(uid);
			//boolean f = UserDao.deleteUserByID(userid);//	����ɾ���û���Ϣ
			boolean f = UserDao.updateUserStateByID(userid);	//	�߼�ɾ���û���Ϣ
			if (f) {
				response.sendRedirect("admin/default.jsp");
				//request.getRequestDispatcher("UserServlet?flag=userList").forward(request,response);
			}else {
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(
						"<script>alert('ɾ��ʧ�ܣ�');history.go(-1);</script>");
			}
		} else if ("toUpdate".equals(flag)) { // ��ת���޸�ҳ	
			String userid = request.getParameter("userid");
			//����ID��ѯ�û���Ϣ
			User user = UserDao.getUserByID(userid);
			request.setAttribute("user", user);
			request.getRequestDispatcher("admin/userUpdate.jsp").forward(request,response);
			
		} else if ("update".equals(flag)) {	//	�޸��û�����
			String uid = request.getParameter("userid");
			int userid = Integer.parseInt(uid);
			String password = request.getParameter("password");
			boolean f = UserDao.updateUserByID(userid,password);	//	�޸��û�����
			if (f) {
				request.getRequestDispatcher("UserServlet?flag=userList").forward(request,response);
			}else {
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(
						"<script>alert('�޸�ʧ�ܣ�');history.go(-1);</script>");
			}
		} 	
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
