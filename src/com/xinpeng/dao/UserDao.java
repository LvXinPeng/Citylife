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
	// 操作数据库数据
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static User user;

/**
 * 用户登录
 * @param userName
 * @param userPassword
 * @return
 */
	public static User login(String userName, String userPassword) {

		// 定义SQL语句
		String sql = "select * from userdb where userstate = 0 and username = '" + userName + "' and password = '" + userPassword + "'";
		// 连接数据库
		conn = JDBCUtil.getConnection();
		try {
			// 编译SQL
			stmt = conn.prepareStatement(sql);
			// 设置参数 [可选-Statement]

			// 执行SQL语句 并且获取结果集
			rs = stmt.executeQuery(sql);
			// 判断是否为空
			while (rs.next()) { // 获取用户相关信息
				user = new User();// 使user不是null，
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
			// 关闭数据库
			JDBCUtil.close(conn, stmt, null, rs);
		}
		return user;
	}
/**
 * 用户注册
 * @param user
 * @return
 */
	public static boolean reg(User user) {
		// 定义SQL语句
		String sql = "insert into userdb(username,password,usertype,userstate) " + "values('" + user.getUsername() + "','" + user.getPassword() + "',0,0)";
		// 连接数据库
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 编译SQL
			stmt = conn.prepareStatement(sql);
			// 设置参数 [可选-Statement]

			// 执行SQL语句 并且获取结果集
			num = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 关闭数据库
			JDBCUtil.close(conn, stmt, null, rs);
		}
		/*
		 * if (num > 0) { return true; }
		 */
		return num > 0;

	}
/**
 * 注册用户查重
 * @param userName
 * @return
 */
	public static boolean checkUserName(String userName) {
		boolean flag = false;
		// 定义SQL语句
		String sql = "select * from userdb where username = '" + userName + "'";
		// 连接数据库
		conn = JDBCUtil.getConnection();
		try {
			// 编译SQL
			stmt = conn.prepareStatement(sql);
			// 设置参数 [可选-Statement]

			// 执行SQL语句 并且获取结果集
			rs = stmt.executeQuery(sql);
			// 判断是否已存在
			flag = rs.next();// 存在即f为true
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 关闭数据库
			JDBCUtil.close(conn, stmt, null, rs);
		}
		return flag;
	}
/**
 * 根据ID获取用户信息
 * @param userid
 * @return
 */
	public static User getUserByID(String userid) {
		// 定义SQL语句
				String sql = "select * from userdb where userid = '" + userid + "'";
				
				// 连接数据库
				conn = JDBCUtil.getConnection();
				try {
					// 编译SQL
					stmt = conn.prepareStatement(sql);
					// 设置参数 [可选-Statement]

					// 执行SQL语句 并且获取结果集
					rs = stmt.executeQuery(sql);
					// 判断是否为空
					while (rs.next()) { // 获取用户相关信息
						user = new User();// 使user不是null，
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
					// 关闭数据库
					JDBCUtil.close(conn, stmt, null, rs);
				}
				return user;
	}
/**
 * 获取所有用户信息
 * @param userid 
 * @param userid
 * @return
 */
	public static List<User> getUsers(String userid) {
				
				List<User> userList = new ArrayList<User>();
				// 定义SQL语句
				String sql = "select * from userdb where userstate = 0";
				if (!"".equals(userid)) {
					sql += "and userid = '" + userid + "'";
				}
				// 连接数据库
				conn = JDBCUtil.getConnection();
				try {
					// 编译SQL
					stmt = conn.prepareStatement(sql);
					// 设置参数 [可选-Statement]

					// 执行SQL语句 并且获取结果集
					rs = stmt.executeQuery(sql);
					// 判断是否为空
					while (rs.next()) { // 获取用户相关信息，只循环一次
						user = new User();// 使user不是null，
						user.setUserId(rs.getInt("userid"));
						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						user.setUserType(rs.getInt("usertype"));
						user.setUserState(rs.getInt("userstate"));
						userList.add(user);//每次向集合加入一组user值
					}
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					// 关闭数据库
					JDBCUtil.close(conn, stmt, null, rs);
				}
				return userList;
	}
/**
 * 物理删除用户信息
 * @param userid
 * @return
 */
	public static boolean deleteUserByID(int userid) {
		// 定义SQL语句
				String sql = "delete from userdb where userid = '"+ userid +"'";
				// 连接数据库
				conn = JDBCUtil.getConnection();
				int num = 0;
				try {
					// 编译SQL
					stmt = conn.prepareStatement(sql);
					// 设置参数 [可选-Statement]

					// 执行SQL语句 并且获取结果集
					num = stmt.executeUpdate(sql);

				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					// 关闭数据库
					JDBCUtil.close(conn, stmt, null, rs);
				}
				/*
				 * if (num > 0) { return true; }
				 */
				return num > 0;
	}
/**
 * 逻辑删除用户信息
 * @param userid
 * @return
 */
	public static boolean updateUserStateByID(int userid) {
		// 定义SQL语句
		String sql = "update userdb set userState = 1 where userid = '"+ userid +"'";
		// 连接数据库
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 编译SQL
			stmt = conn.prepareStatement(sql);
			// 设置参数 [可选-Statement]

			// 执行SQL语句 并且获取结果集
			num = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 关闭数据库
			JDBCUtil.close(conn, stmt, null, rs);
		}
		/*
		 * if (num > 0) { return true; }
		 */
		return num > 0;
	}
/**
 * 根据ID修改用户信息
 * @param userid
 * @param password
 * @return
 */
	public static boolean updateUserByID(int userid,String password) {
		// 定义SQL语句
				String sql = "update userdb set password = '"+ password +"' where userid = '"+ userid +"'";
				// 连接数据库
				conn = JDBCUtil.getConnection();
				int num = 0;
				try {
					// 编译SQL
					stmt = conn.prepareStatement(sql);
					// 设置参数 [可选-Statement]

					// 执行SQL语句 并且获取结果集
					num = stmt.executeUpdate(sql);

				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					// 关闭数据库
					JDBCUtil.close(conn, stmt, null, rs);
				}
				/*
				 * if (num > 0) { return true; }
				 */
				return num > 0;
	}
}
