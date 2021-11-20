package model;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import model.Table1;

public class DAO {
	private static Object Connect() {
		String path = "jdbc:mysql://localhost:3306/ticketdb";
		String user_id = "root";
		String pw = "";
		try {Connection conn = null;
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn = DriverManager.getConnection(path, user_id, pw);
		    conn.setAutoCommit(false);
		    return conn;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static List<Table2> SelectAllOfTable2() {
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Table2> list = new ArrayList<Table2>();
		try {
			String sql = "SELECT * FROM Table2";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Table2 t2 = new Table2();
				t2.setId(rs.getInt("id"));
				t2.setBiz_id(rs.getInt("biz_id"));
				t2.setTicket_code(rs.getString("ticket_code"));
				t2.setSales_interval_start(rs.getString("sales_interval_start"));
				t2.setSales_interval_end(rs.getString("sales_interval_end"));
				list.add(t2);
			}
			System.out.println(ps);
			rs.close();
			ps.close();
			conn.close();
			return list;
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static int CountTable2ByTicketCode(String ticket_code) {
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "SELECT * FROM Table2 WHERE ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ticket_code);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getInt("id") + " ");
				count += 1;
			}
			System.out.println(count + ":" + ps);
			rs.close();
			ps.close();
			conn.close();
			return count;
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	public static List<Table1> SelectAllOfTable1() {
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM Table1";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			Table1 t1 = new Table1();
			List<Table1> list1 = new ArrayList<Table1>();
			while(rs.next()) {
				t1 = new Table1();
				t1.setId(rs.getInt("id"));
				t1.setTicket_code(rs.getString("ticket_code"));
				list1.add(t1);
				
			}
			rs.close();
			ps.close();
			conn.close();
			return list1;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static Table1 SelectTable1ById(int id) {
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM Table1 WHERE id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			Table1 t1 = new Table1();
			rs.next();
			t1.setId(rs.getInt("id"));
			t1.setBiz_id(rs.getInt("biz_id"));
			t1.setTicket_code(rs.getString("ticket_code"));
			t1.setTickets_kind(rs.getInt("tickets_kind"));
			t1.setCreated_at(rs.getString("created_at"));
			t1.setUpdated_at(rs.getString("updated_at"));
			
			rs.close();
			ps.close();
			conn.close();
			return t1;
					
		}catch ( Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	public static Table1 SelectTable1ByBiz_idTicket_code(int biz_id ,String ticket_code) {
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM Table1 WHERE biz_id=? AND ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			rs.next();
				Table1 t1 = new Table1();
			    t1.setId(rs.getInt("id"));
			    t1.setBiz_id(rs.getInt("biz_id"));
			    t1.setTicket_code(rs.getString("ticket_code"));
			    t1.setTickets_kind(rs.getInt("tickets_kind"));
			    t1.setTicket_name(rs.getString("ticket_name"));
			    t1.setCreated_at(rs.getString("created_at"));
			    t1.setUpdated_at(rs.getString("updated_at"));
			
			rs.close();
			ps.close();
			conn.close();
			return t1;
					
		}catch ( Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	public static Table6 SelectTable6ByFK(String ticket_code) {
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM Table6 WHERE biz_id=? AND ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setString(2, ticket_code);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			Table6 t6 = new Table6();
			rs.next();
			t6.setId(rs.getInt("id"));
			t6.setBiz_id(rs.getInt("biz_id"));
			t6.setTicket_code(rs.getString("ticket_code"));
			t6.setSvc_id(rs.getInt("svc_id"));
			t6.setSvc_name(rs.getString("svc_name"));
			t6.setSvc_cautions(rs.getString("svc_cautions"));
			t6.setSvc_type(rs.getInt("svc_type"));
			t6.setSvc_select_type(rs.getInt("svc_select_type"));
			t6.setUsage_time(rs.getInt("usage_time"));
			t6.setCreated_at(rs.getString("created_at"));
			t6.setUpdated_at(rs.getString("updated_at"));
			
			rs.close();
			ps.close();
			conn.close();
			return t6;
					
		}catch ( Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	
	public static void InsertTable1(Table1 t1) {
		
		Connection conn = (Connection) Connect();
		try{

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
					i5 += ps.executeUpdate();
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
	public static int InsertTable27(Table2 t2,Table7 t7) {
		Connection conn = (Connection)Connect();
		String sql = null;
	  try {
		try {
			PreparedStatement ps = null;
			sql = "INSERT INTO Table2 (biz_id,ticket_code,sales_id,sales_interval_start,sales_interval_end) VALUES(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, t2.getBiz_id());
			ps.setString(2, t2.getTicket_code());
			ps.setInt(3, t2.getSales_id());
			ps.setString(4, t2.getSales_interval_start());
			ps.setString(5, t2.getSales_interval_end());
			System.out.println(ps);
			int i = ps.executeUpdate();
			
			sql = "INSERT INTO Table7 (biz_id,ticket_code,sales_id,ticket_interval_start,ticket_interval_end,ticket_days,ticket_num,ticket_min_num,ticket_max_num) VALUES (?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(i, t7.getBiz_id());
			ps.setString(2, t7.getTicket_code());
			ps.setInt(3, t7.getSales_id());
			ps.setString(4, t7.getTicket_interval_start());
			ps.setString(5, t7.getTicket_interval_end());
			ps.setInt(6, t7.getTicket_days());
			ps.setInt(7, t7.getTicket_num());
			ps.setInt(8, t7.getTicket_min_num());
			ps.setInt(9, t7.getTicket_max_num());
			System.out.println(ps);
			int i2 = ps.executeUpdate();
			
			conn.commit();
			System.out.println("Success_insertTable2&7:" + i + "," + i2);
			conn.close();
			ps.close();
			return 0;
		}catch (SQLException e) {
			conn.rollback();
			System.out.println(e.getMessage());
			return 1;
		}
	  }catch (Exception e) {
			System.out.println(e.getMessage());
			return 1;
		}
		
	}
}