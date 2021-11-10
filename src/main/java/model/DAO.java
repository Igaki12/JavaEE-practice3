package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import model.Table1;

public class DAO {
	private static String path = "jdbc:mysql://localhost:3306/ticketdb";
	private static String user_id = "root";
	private static String pw = "";
	public static void InsertTable1(Table1 t1) {
		try{
//			この部分を上位メソッド（あるいはクラス）で統合したい
			Connection conn = null;
			PreparedStatement ps = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(path, user_id, pw);
			conn.setAutoCommit(false);

			String sql = "INSERT INTO table1(biz_id,ticket_code,spot_area_id,genre_code1,genre_code2,ticket_name,ticket_remarks,tickets_kind,"
						+ "minors_flag,cancel_flag,cancel_limit) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,t1.getBiz_id());
			ps.setString(2,t1.getTicket_code());
			ps.setInt(3,t1.getSpot_area_id());
			ps.setString(4,t1.getGenre_code1());
			ps.setString(5,t1.getGenre_code2());
			ps.setString(6,t1.getTicket_name());
			ps.setString(7,t1.getTicket_remarks());
			ps.setInt(8,t1.getTickets_kind());
			ps.setInt(9,t1.getMinors_flag());
			ps.setInt(10, t1.getCancel_flag());
			ps.setInt(11,t1.getCancel_limit());
			System.out.println(ps);
			int i = ps.executeUpdate();
			conn.commit();
			System.out.println("Success_insertTable1:" + i);
			
			conn.close();
			ps.close();
				
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static void InsertTable3(Table3 t3) {
		try {
			Connection conn = null;
			PreparedStatement ps = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(path, user_id, pw);
			conn.setAutoCommit(false);

			String sql = "INSERT INTO table3(biz_id,ticket_code,contents_type,contents_index,contents_data) VALUES(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, t3.getBiz_id());
			ps.setString(2, t3.getTicket_code());
			ps.setInt(3, t3.getContents_type());
			ps.setInt(4, t3.getContents_index());
			ps.setString(5, t3.getContents_data());
			System.out.println(ps);
			int i = ps.executeUpdate();
			conn.commit();
			System.out.println("Success_insertTable3:" + i);
			
			conn.close();
			ps.close();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
//	ここまで動作確認済み
	
	public static void InsertTable4(Table4 t4) {
		try {
			Connection conn = null;
			PreparedStatement ps = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(path, user_id, pw);
			conn.setAutoCommit(false);

			String sql = "INSERT INTO table4(biz_id,ticket_code,cautions_type,cautions_index,cautions_text) VALUES(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, t4.getBiz_id());
			ps.setString(2, t4.getTicket_code());
			ps.setInt(3, t4.getCautions_type());
			ps.setInt(4, t4.getCautions_index());
			ps.setString(5, t4.getCautions_text());
			System.out.println(ps);
			int i = ps.executeUpdate();
			conn.commit();
			System.out.println("Success_insertTable4:" + i);
			
			conn.close();
			ps.close();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}