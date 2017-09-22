package com.xinpeng.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xinpeng.model.User;
import com.xinpeng.util.JDBCUtil;

public class UserDao {
	// �������ݿ�����
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static User user;

/**
 * �û���¼
 * @param userName
 * @param userPassword
 * @return
 */
	public static User login(String userName, String userPassword) {

		// ����SQL���
		String sql = "select * from userdb where userstate = 0 and username = '" + userName + "' and password = '" + userPassword + "'";
		// �������ݿ�
		conn = JDBCUtil.getConnection();
		try {
			// ����SQL
			stmt = conn.prepareStatement(sql);
			// ���ò��� [��ѡ-Statement]

			// ִ��SQL��� ���һ�ȡ�����
			rs = stmt.executeQuery(sql);
			// �ж��Ƿ�Ϊ��
			while (rs.next()) { // ��ȡ�û������Ϣ
				user = new User();// ʹuser����null��
				user.setUserId(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUserType(rs.getInt("usertype"));
				user.setUserState(rs.getInt("userstate"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// �ر����ݿ�
			JDBCUtil.close(conn, stmt, null, rs);
		}
		return user;
	}
/**
 * �û�ע��
 * @param user
 * @return
 */
	public static boolean reg(User user) {
		// ����SQL���
		String sql = "insert into userdb(username,password,usertype,userstate) " + "values('" + user.getUsername() + "','" + user.getPassword() + "',0,0)";
		// �������ݿ�
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// ����SQL
			stmt = conn.prepareStatement(sql);
			// ���ò��� [��ѡ-Statement]

			// ִ��SQL��� ���һ�ȡ�����
			num = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// �ر����ݿ�
			JDBCUtil.close(conn, stmt, null, rs);
		}
		/*
		 * if (num > 0) { return true; }
		 */
		return num > 0;

	}
/**
 * ע���û�����
 * @param userName
 * @return
 */
	public static boolean checkUserName(String userName) {
		boolean flag = false;
		// ����SQL���
		String sql = "select * from userdb where username = '" + userName + "'";
		// �������ݿ�
		conn = JDBCUtil.getConnection();
		try {
			// ����SQL
			stmt = conn.prepareStatement(sql);
			// ���ò��� [��ѡ-Statement]

			// ִ��SQL��� ���һ�ȡ�����
			rs = stmt.executeQuery(sql);
			// �ж��Ƿ��Ѵ���
			flag = rs.next();// ���ڼ�fΪtrue
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// �ر����ݿ�
			JDBCUtil.close(conn, stmt, null, rs);
		}
		return flag;
	}
/**
 * ����ID��ȡ�û���Ϣ
 * @param userid
 * @return
 */
	public static User getUserByID(String userid) {
		// ����SQL���
				String sql = "select * from userdb where userid = '" + userid + "'";
				
				// �������ݿ�
				conn = JDBCUtil.getConnection();
				try {
					// ����SQL
					stmt = conn.prepareStatement(sql);
					// ���ò��� [��ѡ-Statement]

					// ִ��SQL��� ���һ�ȡ�����
					rs = stmt.executeQuery(sql);
					// �ж��Ƿ�Ϊ��
					while (rs.next()) { // ��ȡ�û������Ϣ
						user = new User();// ʹuser����null��
						user.setUserId(rs.getInt("userid"));
						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						user.setUserType(rs.getInt("usertype"));
						user.setUserState(rs.getInt("userstate"));
					}
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					// �ر����ݿ�
					JDBCUtil.close(conn, stmt, null, rs);
				}
				return user;
	}
/**
 * ��ȡ�����û���Ϣ
 * @param userid 
 * @param userid
 * @return
 */
	public static List<User> getUsers(String userid) {
				
				List<User> userList = new ArrayList<User>();
				// ����SQL���
				String sql = "select * from userdb where userstate = 0";
				if (!"".equals(userid)) {
					sql += "and userid = '" + userid + "'";
				}
				// �������ݿ�
				conn = JDBCUtil.getConnection();
				try {
					// ����SQL
					stmt = conn.prepareStatement(sql);
					// ���ò��� [��ѡ-Statement]

					// ִ��SQL��� ���һ�ȡ�����
					rs = stmt.executeQuery(sql);
					// �ж��Ƿ�Ϊ��
					while (rs.next()) { // ��ȡ�û������Ϣ��ֻѭ��һ��
						user = new User();// ʹuser����null��
						user.setUserId(rs.getInt("userid"));
						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						user.setUserType(rs.getInt("usertype"));
						user.setUserState(rs.getInt("userstate"));
						userList.add(user);//ÿ���򼯺ϼ���һ��userֵ
					}
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					// �ر����ݿ�
					JDBCUtil.close(conn, stmt, null, rs);
				}
				return userList;
	}
/**
 * ����ɾ���û���Ϣ
 * @param userid
 * @return
 */
	public static boolean deleteUserByID(int userid) {
		// ����SQL���
				String sql = "delete from userdb where userid = '"+ userid +"'";
				// �������ݿ�
				conn = JDBCUtil.getConnection();
				int num = 0;
				try {
					// ����SQL
					stmt = conn.prepareStatement(sql);
					// ���ò��� [��ѡ-Statement]

					// ִ��SQL��� ���һ�ȡ�����
					num = stmt.executeUpdate(sql);

				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					// �ر����ݿ�
					JDBCUtil.close(conn, stmt, null, rs);
				}
				/*
				 * if (num > 0) { return true; }
				 */
				return num > 0;
	}
/**
 * �߼�ɾ���û���Ϣ
 * @param userid
 * @return
 */
	public static boolean updateUserStateByID(int userid) {
		// ����SQL���
		String sql = "update userdb set userState = 1 where userid = '"+ userid +"'";
		// �������ݿ�
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// ����SQL
			stmt = conn.prepareStatement(sql);
			// ���ò��� [��ѡ-Statement]

			// ִ��SQL��� ���һ�ȡ�����
			num = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// �ر����ݿ�
			JDBCUtil.close(conn, stmt, null, rs);
		}
		/*
		 * if (num > 0) { return true; }
		 */
		return num > 0;
	}
/**
 * ����ID�޸��û���Ϣ
 * @param userid
 * @param password
 * @return
 */
	public static boolean updateUserByID(int userid,String password) {
		// ����SQL���
				String sql = "update userdb set password = '"+ password +"' where userid = '"+ userid +"'";
				// �������ݿ�
				conn = JDBCUtil.getConnection();
				int num = 0;
				try {
					// ����SQL
					stmt = conn.prepareStatement(sql);
					// ���ò��� [��ѡ-Statement]

					// ִ��SQL��� ���һ�ȡ�����
					num = stmt.executeUpdate(sql);

				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					// �ر����ݿ�
					JDBCUtil.close(conn, stmt, null, rs);
				}
				/*
				 * if (num > 0) { return true; }
				 */
				return num > 0;
	}
}
