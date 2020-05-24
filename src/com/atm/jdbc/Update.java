package com.atm.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * ͨ�õ���ɾ�Ĳ���
 * @author �ܱ���
 *
 */
public class Update {
	public static int update(String sql, Object ... objs) {
		Connection conn = null;
		PreparedStatement st = null;
		int count = 0;
		try {
			conn = JDBC.getmysql();
			st = conn.prepareStatement(sql);
			if(objs != null) {
				for(int i = 0; i < objs.length; i++) {
					st.setObject(i + 1, objs[i]);					
				}
			}
			count = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBC.closeResourse(conn, st, null);
		}
		return count;	
	}
	
	/**
	 *ͨ�õ���ɾ�Ĳ���,���������ݿ�����
	 * @return
	 */
	public static int update2(Connection conn, String sql, Object ... objs) {
		PreparedStatement st = null;
		int count = 0;
		try {
			st = conn.prepareStatement(sql);
			if(objs != null) {
				for(int i = 0; i < objs.length; i++) {
					st.setObject(i + 1, objs[i]);					
				}
			}
			count = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBC.closeResourse(null, st, null);
		}
		return count;	
	}
}