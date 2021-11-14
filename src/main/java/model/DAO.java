package model;

import java.util.List;
import java.sql.*;
import model.Table1;

public class DAO {
	private static String path = "jdbc:mysql://localhost:3306/ticketdb";
	private static String user_id = "root";
	private static String pw = "";
	
	public static Object Connect() {
		try {Connection conn = null;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn = DriverManager.getConnection(path, user_id, pw);
		conn.setAutoCommit(false);
		return conn;
		}catch (Exception e) {
			return null;
		}
		
		
	}
	
	
	
	public static void InsertTable1(Table1 t1) {
		
		Connection conn = (Connection) Connect();
		try{
//			この部分を上位メソッド（あるいはクラス）で統合したい

			PreparedStatement ps = null;
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

	public static void InsertTable5(Table5 t5) {
		try {
			Connection conn = null;
			PreparedStatement ps = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(path, user_id, pw);
			conn.setAutoCommit(false);

			String sql = "INSERT INTO table5(biz_id,ticket_code,type_id,type_name,type_money,cancel_type,cancel_rate) VALUES(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, t5.getBiz_id());
			ps.setString(2, t5.getTicket_code());
			ps.setInt(3, t5.getType_id());
			ps.setString(4, t5.getType_name());
			ps.setInt(5, t5.getType_money());
			ps.setInt(6, t5.getCancel_type());
			ps.setInt(7, t5.getCancel_rate());
			System.out.println(ps);
			int i = ps.executeUpdate();
			conn.commit();
			System.out.println("Success_insertTable5:" + i);
			
			conn.close();
			ps.close();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
//	ここまで動作確認済み
	
	public static void InsertTable6(Table6 t6) {
		try {
			Connection conn = null;
			PreparedStatement ps = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(path, user_id, pw);
			conn.setAutoCommit(false);

			String sql = "INSERT INTO table6(biz_id,ticket_code,svc_id,svc_name,svc_cautions,svc_type,svc_select_type,usage_time) VALUES(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, t6.getBiz_id());
			ps.setString(2, t6.getTicket_code());
			ps.setInt(3, t6.getSvc_id());
			ps.setString(4, t6.getSvc_name());
			ps.setString(5, t6.getSvc_cautions());
			ps.setInt(6, t6.getSvc_type());
			ps.setInt(7, t6.getSvc_select_type());
			ps.setInt(8, t6.getUsage_time());
			System.out.println(ps);
			int i = ps.executeUpdate();
			conn.commit();
			System.out.println("Success_insertTable6:" + i);
			
			conn.close();
			ps.close();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static int InsertTable1to6(Table1 t1, Table3 t3_1,Table3 t3_2,Table4 t4_1,Table4 t4_2,Table4 t4_3,List<Table5> list5, Table6 t6) {
		
		Connection conn = (Connection)Connect();
		try {
			  
			  try {
				  PreparedStatement ps = null;
				  
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
				int i1 = ps.executeUpdate();
				
				sql = "INSERT INTO table3(biz_id,ticket_code,contents_type,contents_index,contents_data) VALUES(?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, t3_1.getBiz_id());
				ps.setString(2, t3_1.getTicket_code());
				ps.setInt(3, t3_1.getContents_type());
				ps.setInt(4, t3_1.getContents_index());
				ps.setString(5, t3_1.getContents_data());
				System.out.println(ps);
				int i3_1 = ps.executeUpdate();
				
				sql = "INSERT INTO table3(biz_id,ticket_code,contents_type,contents_index,contents_data) VALUES(?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, t3_2.getBiz_id());
				ps.setString(2, t3_2.getTicket_code());
				ps.setInt(3, t3_2.getContents_type());
				ps.setInt(4, t3_2.getContents_index());
				ps.setString(5, t3_2.getContents_data());
				System.out.println(ps);
				int i3_2 = ps.executeUpdate();
				
				sql = "INSERT INTO table4(biz_id,ticket_code,cautions_type,cautions_index,cautions_text) VALUES(?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, t4_1.getBiz_id());
				ps.setString(2, t4_1.getTicket_code());
				ps.setInt(3, t4_1.getCautions_type());
				ps.setInt(4, t4_1.getCautions_index());
				ps.setString(5, t4_1.getCautions_text());
				System.out.println(ps);
				int i4_1 = ps.executeUpdate();
				
				sql = "INSERT INTO table4(biz_id,ticket_code,cautions_type,cautions_index,cautions_text) VALUES(?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, t4_2.getBiz_id());
				ps.setString(2, t4_2.getTicket_code());
				ps.setInt(3, t4_2.getCautions_type());
				ps.setInt(4, t4_2.getCautions_index());
				ps.setString(5, t4_2.getCautions_text());
				System.out.println(ps);
				int i4_2 = ps.executeUpdate();
				
				sql = "INSERT INTO table4(biz_id,ticket_code,cautions_type,cautions_index,cautions_text) VALUES(?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, t4_3.getBiz_id());
				ps.setString(2, t4_3.getTicket_code());
				ps.setInt(3, t4_3.getCautions_type());
				ps.setInt(4, t4_3.getCautions_index());
				ps.setString(5, t4_3.getCautions_text());
				System.out.println(ps);
				int i4_3 = ps.executeUpdate();
				
				int i5 = 0;
				
				for (Table5 t5 : list5) {
					sql = "INSERT INTO table5(biz_id,ticket_code,type_id,type_name,type_money,cancel_type,cancel_rate) VALUES(?,?,?,?,?,?,?)";
					ps = conn.prepareStatement(sql);
					ps.setInt(1, t5.getBiz_id());
					ps.setString(2, t5.getTicket_code()); 
					ps.setInt(3, t5.getType_id());
					ps.setString(4, t5.getType_name());
					ps.setInt(5, t5.getType_money());
					ps.setInt(6, t5.getCancel_type());
					ps.setInt(7, t5.getCancel_rate());
					System.out.println(ps);
					i5 = ps.executeUpdate();
				}
				
				
				
				sql = "INSERT INTO table6(biz_id,ticket_code,svc_id,svc_name,svc_cautions,svc_type,svc_select_type,usage_time) VALUES(?,?,?,?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, t6.getBiz_id());
				ps.setString(2, t6.getTicket_code());
				ps.setInt(3, t6.getSvc_id());
				ps.setString(4, t6.getSvc_name());
				ps.setString(5, t6.getSvc_cautions());
				ps.setInt(6, t6.getSvc_type());
				ps.setInt(7, t6.getSvc_select_type());
				ps.setInt(8, t6.getUsage_time());
				System.out.println(ps);
				int i6 = ps.executeUpdate();
				
				conn.commit();
				System.out.println("Success_insertTable1-6:" + i1+","+i3_1 + ","+i3_2 + ","+i4_1 + ","+i4_2 + ","+i4_3 + "," +i5 + ","+i6);
				conn.close();
				ps.close();
				return 0;
				
			  }catch (SQLException e) {
				  conn.rollback();
				  System.out.println(e.getMessage());
				  return 1;
			  }
			  
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return 1;
		}
		
	}
}