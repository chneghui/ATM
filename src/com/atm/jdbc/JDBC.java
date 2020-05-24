package com.atm.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库连接
 * @author 周宝辉
 *
 */
public class JDBC {
	private static ComboPooledDataSource c = new ComboPooledDataSource("helloc3p0");

	public static Connection getmysql() throws Exception {
		Connection conn = c.getConnection();
		return conn;
	}

	public static void closeResourse(Connection conn, Statement st, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}