package com.atm.jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * 通用的查询操作
 * @author 周宝辉
 *
 */
public class Find {
	public static <T> T find(Class<T> clazz, String sql, Object ... objs) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			conn = JDBC.getmysql();
			st = conn.prepareStatement(sql);
			if(objs != null) {
				for(int i = 0; i < objs.length; i++) {
					st.setObject(i + 1, objs[i]);
				}
			}
			rs = st.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			while(rs.next()) {
				T t = clazz.newInstance();
				for(int i = 0; i < count; i++) {
					Object obj = rs.getObject(i + 1);
					String name = rsmd.getColumnLabel(i + 1);
					
					Field field = clazz.getDeclaredField(name);
					field.setAccessible(true);
					field.set(t, obj);
				}
				return t;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC.closeResourse(conn, st, rs);
		}		
		return null;
	}
}