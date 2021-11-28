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
	public static int CalMaxOfSales_idByBiz_idTicket_code(int biz_id,String ticket_code){
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int max = 0;
		try {
			String sql = "SELECT * FROM Table2 WHERE biz_id=? AND ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				if(rs.getInt("sales_id") >= max) {
					max = rs.getInt("sales_id");
				}
			}
			
			System.out.println("MaxOfSales_id:" + max);
			rs.close();
			ps.close();
			conn.close();
			return max;
			
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
			    t1.setBiz_id(rs.getInt("biz_id"));
			    t1.setTicket_code(rs.getString("ticket_code"));
			    t1.setSpot_area_id(rs.getInt("spot_area_id"));
			    t1.setGenre_code1(rs.getString("genre_code1"));
			    t1.setGenre_code2(rs.getString("genre_code2"));
			    t1.setTickets_kind(rs.getInt("tickets_kind"));
			    t1.setTicket_name(rs.getString("ticket_name"));
			    t1.setTicket_remarks(rs.getString("ticket_remarks"));
			    t1.setMinors_flag(rs.getInt("minors_flag"));
			    t1.setCancel_limit(rs.getInt("cancel_limit"));
			    t1.setCreated_at(rs.getString("created_at"));
			    t1.setUpdated_at(rs.getString("updated_at"));
				
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
			t1.setSpot_area_id(rs.getInt("spot_area_id"));
			t1.setGenre_code1(rs.getString("genre_code1"));
			t1.setGenre_code2(rs.getString("genre_code2"));
			t1.setTicket_name(rs.getString("ticket_name"));
			t1.setTicket_remarks(rs.getString("ticket_remarks"));
			t1.setTickets_kind(rs.getInt("tickets_kind"));
			t1.setMinors_flag(rs.getInt("minors_flag"));
			t1.setCancel_flag(rs.getInt("cancel_flag"));
			t1.setCancel_limit(rs.getInt("cancel_limit"));
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
			    t1.setSpot_area_id(rs.getInt("spot_area_id"));
			    t1.setGenre_code1(rs.getString("genre_code1"));
			    t1.setGenre_code2(rs.getString("genre_code2"));
			    t1.setTickets_kind(rs.getInt("tickets_kind"));
			    t1.setTicket_name(rs.getString("ticket_name"));
			    t1.setTicket_remarks(rs.getString("ticket_remarks"));
			    t1.setMinors_flag(rs.getInt("minors_flag"));
			    t1.setCancel_limit(rs.getInt("cancel_limit"));
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
	
	public static Table2 SelectTable2ByBiz_idTicket_codeSales_id(int biz_id,String ticket_code,int sales_id) {
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM Table2 WHERE biz_id=? AND ticket_code=? AND sales_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			ps.setInt(3, sales_id);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			rs.next();
				Table2 t2 = new Table2();
				t2.setId(rs.getInt("id"));
				t2.setBiz_id(rs.getInt("biz_id"));
				t2.setTicket_code(rs.getString("ticket_code"));
				t2.setSales_id(rs.getInt("sales_id"));
				t2.setSales_interval_start(rs.getString("sales_interval_start"));
				t2.setSales_interval_end(rs.getString("sales_interval_end"));
				
				ps.close();
				rs.close();
				conn.close();
				
				return t2;
		}catch (Exception e ) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static List<Table2> SelectListOfTable2ByBiz_idTicket_code(int biz_id,String ticket_code){
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM Table2 WHERE biz_id=? AND ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			List<Table2> list2 = new ArrayList<>();
			while(rs.next()) {
				Table2 t2 = new Table2();
				t2.setId(rs.getInt("id"));
				t2.setBiz_id(rs.getInt("biz_id"));
				t2.setTicket_code(rs.getString("ticket_code"));
				t2.setSales_id(rs.getInt("sales_id"));
				t2.setSales_interval_start(rs.getString("sales_interval_start"));
				t2.setSales_interval_end(rs.getString("sales_interval_end"));
				list2.add(t2);
			}
			ps.close();
			rs.close();
			conn.close();
			return list2;
			
		}catch(Exception e ) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public static List<Table3> SelectListOfTable3ByBiz_idTicket_code(int biz_id,String ticket_code){
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM Table3 WHERE biz_id=? AND ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			List<Table3> list3 = new ArrayList<>();
			while(rs.next()) {
				Table3 t3 = new Table3();
			    t3.setId(rs.getInt("id"));
			    t3.setBiz_id(rs.getInt("biz_id"));
			    t3.setTicket_code(rs.getString("ticket_code"));
			    t3.setContents_type(rs.getInt("contents_type"));
			    t3.setContents_index(rs.getInt("contents_index"));
			    t3.setContents_data(rs.getString("contents_data"));
			    list3.add(t3);   
			}
			
			rs.close();
			ps.close();
			conn.close();
			return list3;
		}catch ( Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	public static List<Table4> SelectListOfTable4ByBiz_idTicket_code(int biz_id,String ticket_code){
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM Table4 WHERE biz_id=? AND ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			List<Table4> list4 = new ArrayList<>();
			while(rs.next()) {
				Table4 t4 = new Table4();
			    t4.setId(rs.getInt("id"));
			    t4.setBiz_id(rs.getInt("biz_id"));
			    t4.setTicket_code(rs.getString("ticket_code"));
			    t4.setCautions_type(rs.getInt("cautions_type"));
			    t4.setCautions_index(rs.getInt("cautions_index"));
			    t4.setCautions_text(rs.getString("cautions_text"));
			    
			    list4.add(t4);   
			}
			
			rs.close();
			ps.close();
			conn.close();
			return list4;
		}catch ( Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static List<Table5> SelectListOfTable5ByBiz_idTicket_code(int biz_id,String ticket_code) {
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM Table5 WHERE biz_id=? AND ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			List<Table5> list5 = new ArrayList<>();
			
			while(rs.next()) {
				Table5 t5 = new Table5();
			    t5.setId(rs.getInt("id"));
			    t5.setBiz_id(rs.getInt("biz_id"));
			    t5.setTicket_code(rs.getString("ticket_code"));
			    t5.setType_id(rs.getInt("type_id"));
			    t5.setType_name(rs.getString("type_name"));
			    t5.setType_money(rs.getInt("type_money"));
			    t5.setCancel_type(rs.getInt("cancel_type"));
			    t5.setCancel_rate(rs.getInt("cancel_rate"));
			    list5.add(t5);
			}
			
			rs.close();
			ps.close();
			conn.close();
			return list5;
					
		}catch ( Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static Table6 SelectTable6ByBiz_idTicket_code(int biz_id,String ticket_code) {
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM Table6 WHERE biz_id=? AND ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
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
	
	public static Table7 SelectTable7ByBiz_idTicket_codeSales_id(int biz_id,String ticket_code,int sales_id) {
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM Table7 WHERE biz_id=? AND ticket_code=? AND sales_id=?";
	  	    ps = conn.prepareStatement(sql);
	  	    ps.setInt(1, biz_id);
		    ps.setString(2, ticket_code);
		    ps.setInt(3, sales_id);
		    System.out.println(ps);
		    rs = ps.executeQuery();
		
         	rs.next();
			Table7 t7 = new Table7();
			t7.setId(rs.getInt("id"));
			t7.setBiz_id(rs.getInt("biz_id"));
			t7.setTicket_code(rs.getString("ticket_code"));
			t7.setSales_id(rs.getInt("sales_id"));
			t7.setTicket_interval_start(rs.getString("ticket_interval_start"));
			t7.setTicket_interval_end(rs.getString("ticket_interval_end"));
			t7.setTicket_days(rs.getInt("ticket_days"));
			t7.setTicket_num(rs.getInt("ticket_num"));
			t7.setTicket_min_num(rs.getInt("ticket_min_num"));
			t7.setTicket_max_num(rs.getInt("ticket_max_num"));
			
			ps.close();
			rs.close();
			conn.close();
			return t7;
						
		}catch(Exception e ) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static List<Table7> SelectListOfTable7ByBiz_idTicket_code(int biz_id,String ticket_code) {
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM Table7 WHERE biz_id=? AND ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			List<Table7> list7 = new ArrayList<>();
			while(rs.next()) {
				Table7 t7 = new Table7();
				t7.setId(rs.getInt("id"));
				t7.setBiz_id(rs.getInt("biz_id"));
				t7.setTicket_code(rs.getString("ticket_code"));
				t7.setSales_id(rs.getInt("sales_id"));
				t7.setTicket_interval_start(rs.getString("ticket_interval_start"));
				t7.setTicket_interval_end(rs.getString("ticket_interval_end"));
				t7.setTicket_days(rs.getInt("ticket_days"));
				t7.setTicket_num(rs.getInt("ticket_num"));
				t7.setTicket_min_num(rs.getInt("ticket_min_num"));
				t7.setTicket_max_num(rs.getInt("ticket_max_num"));
				
				list7.add(t7);				
			}
			
			rs.close();
			ps.close();
			conn.close();
			return list7;
					
		}catch ( Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	public static int InsertTable1(Table1 t1) {
		
		Connection conn = (Connection) Connect();
		try {
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
			return 0;
				
		}catch(SQLException e) {
			conn.rollback();
			System.out.println(e.getMessage());
			return 1;
			
		}}catch (Exception e) {
			System.out.println(e.getMessage());
			return 1;
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
	public static int UpdateTable1to6(Table1 t1, Table3 t3_1,Table3 t3_2,Table4 t4_1,Table4 t4_2,Table4 t4_3,List<Table5> list5, Table6 t6) {
		Connection conn = (Connection)Connect();
		try {
			  
			  try {
				  PreparedStatement ps = null;
				  
				  String sql = "UPDATE Table1 SET biz_id=?,ticket_code=?,spot_area_id=?,genre_code1=?,genre_code2=?,ticket_name=?,ticket_remarks=?,tickets_kind=?,"
							+ "minors_flag=?,cancel_flag=?,cancel_limit=? WHERE id=?";
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
				ps.setInt(12, t1.getId());
				System.out.println(ps);
				int i1 = ps.executeUpdate();
				
				sql = "UPDATE table3 SET contents_index=?,contents_data=? WHERE biz_id=? AND ticket_code=? AND contents_type=?";
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, t3_1.getContents_index());
				ps.setString(2, t3_1.getContents_data());
				ps.setInt(3, t3_1.getBiz_id());
				ps.setString(4, t3_1.getTicket_code());
				ps.setInt(5, t3_1.getContents_type());
				System.out.println(ps);
				int i3_1 = ps.executeUpdate();
				
				sql = "UPDATE table3 SET contents_index=? ,contents_data=? WHERE biz_id=? AND ticket_code=? AND contents_type=?";
				ps = conn.prepareStatement(sql);

				ps.setInt(1, t3_2.getContents_index());
				ps.setString(2, t3_2.getContents_data());
				ps.setInt(3, t3_2.getBiz_id());
				ps.setString(4, t3_2.getTicket_code());
				ps.setInt(5, t3_2.getContents_type());
				System.out.println(ps);
				int i3_2 = ps.executeUpdate();
				
				sql = "UPDATE table4 SET cautions_index=? ,cautions_text=? WHERE biz_id=? AND ticket_code=? AND cautions_type=?";
				ps = conn.prepareStatement(sql);

				ps.setInt(1, t4_1.getCautions_index());
				ps.setString(2, t4_1.getCautions_text());
				ps.setInt(3, t4_1.getBiz_id());
				ps.setString(4, t4_1.getTicket_code());
				ps.setInt(5, t4_1.getCautions_type());
				System.out.println(ps);
				int i4_1 = ps.executeUpdate();
				
				sql = "UPDATE table4 SET cautions_index=?,cautions_text=?  WHERE biz_id=? AND ticket_code=? AND cautions_type=?";
				ps = conn.prepareStatement(sql);

				ps.setInt(1, t4_2.getCautions_index());
				ps.setString(2, t4_2.getCautions_text());
				ps.setInt(3, t4_2.getBiz_id());
				ps.setString(4, t4_2.getTicket_code());
				ps.setInt(5, t4_2.getCautions_type());
				System.out.println(ps);
				int i4_2 = ps.executeUpdate();
				
				sql = "UPDATE table4 SET cautions_index=?,cautions_text=? WHERE biz_id=? AND ticket_code=? AND cautions_type=?";
				ps = conn.prepareStatement(sql);

				ps.setInt(1, t4_3.getCautions_index());
				ps.setString(2, t4_3.getCautions_text());
				ps.setInt(3, t4_3.getBiz_id());
				ps.setString(4, t4_3.getTicket_code());
				ps.setInt(5, t4_3.getCautions_type());
				System.out.println(ps);
				int i4_3 = ps.executeUpdate();
				
//				Table5だけは新規追加が可能なので、一度既存のデータを全削除して追加しなおす
				sql = "DELETE FROM Table5 WHERE biz_id=? AND ticket_code=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, t1.getBiz_id());
				ps.setString(2, t1.getTicket_code());
				System.out.println(ps);
				int i5_d = ps.executeUpdate();
				
				int i5_i = 0;
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
					i5_i += ps.executeUpdate();
				}
				int i5 = 0;
				i5 = i5_i - i5_d;
				
				
				sql = "UPDATE table6 SET svc_name=?,svc_cautions=?,svc_type=?,svc_select_type=?,usage_time=? WHERE biz_id=? AND ticket_code=? AND svc_id=?";
				ps = conn.prepareStatement(sql);

				ps.setString(1, t6.getSvc_name());
				ps.setString(2, t6.getSvc_cautions());
				ps.setInt(3, t6.getSvc_type());
				ps.setInt(4, t6.getSvc_select_type());
				ps.setInt(5, t6.getUsage_time());
				ps.setInt(6, t6.getBiz_id());
				ps.setString(7, t6.getTicket_code());
				ps.setInt(8, t6.getSvc_id());
				System.out.println(ps);
				int i6 = ps.executeUpdate();
				
				conn.commit();
				System.out.println("Success_UpdateTable1-6:" + i1+","+i3_1 + ","+i3_2 + ","+i4_1 + ","+i4_2 + ","+i4_3 + "," +i5 + ","+i6);
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
	
	public static int UpdateTable27(Table2 t2, Table7 t7) {
		Connection conn = (Connection)Connect();
		String sql = null;
		PreparedStatement ps = null;
		try {
			try {
				sql = "UPDATE Table2 SET sales_interval_start=?,sales_interval_end=? WHERE biz_id=? AND ticket_code=? AND sales_id=?";
				ps = conn.prepareStatement(sql);

				ps.setString(1, t2.getSales_interval_start());
				ps.setString(2, t2.getSales_interval_end());
				ps.setInt(3, t2.getBiz_id());
				ps.setString(4, t2.getTicket_code());
				ps.setInt(5, t2.getSales_id());
				System.out.println(ps);
				int i = ps.executeUpdate();
				
				sql = "UPDATE Table7 SET ticket_interval_start=?,ticket_interval_end=?,ticket_days=?,ticket_num=?,ticket_min_num=?,ticket_max_num=? WHERE biz_id=? AND ticket_code=? AND sales_id=?";
				ps = conn.prepareStatement(sql);

				ps.setString(1, t7.getTicket_interval_start());
				ps.setString(2, t7.getTicket_interval_end());
				ps.setInt(3, t7.getTicket_days());
				ps.setInt(4, t7.getTicket_num());
				ps.setInt(5, t7.getTicket_min_num());
				ps.setInt(6, t7.getTicket_max_num());
				ps.setInt(7, t7.getBiz_id());
				ps.setString(8, t7.getTicket_code());
				ps.setInt(9, t7.getSales_id());
				System.out.println(ps);
				int i2 = ps.executeUpdate();
				
				conn.commit();
				System.out.println("Success_updateTable2&7:" + i + "," + i2);
				conn.close();
				ps.close();
				return 0;
			}catch(SQLException q) {
				conn.rollback();
				System.out.println(q.getMessage());
				return 1;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return 1;
		}
	}
	
	public static int DeleteTableAllWhereBiz_idTicket_code(int biz_id,String ticket_code) {
		Connection conn = (Connection)Connect();
		String sql = null;
		PreparedStatement ps = null;
		try {
		try {
			
			sql = "DELETE FROM Table2 WHERE biz_id=? AND ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			System.out.println(ps);
			int i2 = ps.executeUpdate();
			
			sql = "DELETE FROM Table3 WHERE biz_id=? AND ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			System.out.println(ps);
			int i3 = ps.executeUpdate();
			
			sql = "DELETE FROM Table4 WHERE biz_id=? AND ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			System.out.println(ps);
			int i4 = ps.executeUpdate();
			
			sql = "DELETE FROM Table5 WHERE biz_id=? AND ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			System.out.println(ps);
			int i5 = ps.executeUpdate();
			
			sql = "DELETE FROM Table6 WHERE biz_id=? AND ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			System.out.println(ps);
			int i6 = ps.executeUpdate();
			
			sql = "DELETE FROM Table7 WHERE biz_id=? AND ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			System.out.println(ps);
			int i7 = ps.executeUpdate();
			
			sql = "DELETE FROM Table8 WHERE biz_id=? AND ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			System.out.println(ps);
			int i8= ps.executeUpdate();
			
			sql = "DELETE FROM Table1 WHERE biz_id=? AND ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			System.out.println(ps);
			int i1 = ps.executeUpdate();
			
			conn.commit();
			System.out.println("Success_DeleteTable1to6:" + i1 + ","+i2 + "," + i3 + ","+ i4 + ","+ i5 + ","+ i6 + "," + i7 + "," + i8);
			conn.close();
			ps.close();
			return 0;
			
		}catch (SQLException e ) {
			conn.rollback();
			System.out.println(e.getMessage());
			return 1;
		}}catch (Exception e ) {
			System.out.println(e.getMessage());
			return 1;
		}
	}
	
	public static int DeleteTable27ByBiz_idTicket_codeSales_id(int biz_id,String ticket_code,int sales_id) {
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		String sql = null;
		
		try {
			try {				
				sql = "DELETE FROM Table7 WHERE biz_id=? AND ticket_code=? AND sales_id=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, biz_id);
				ps.setString(2, ticket_code);
				ps.setInt(3, sales_id);
				System.out.println(ps);
				int i7 = ps.executeUpdate();
				
				sql = "DELETE FROM Table2 WHERE biz_id=? AND ticket_code=? AND sales_id=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, biz_id);
				ps.setString(2, ticket_code);
				ps.setInt(3, sales_id);
				System.out.println(ps);
				int i2 = ps.executeUpdate();

				conn.commit();
				System.out.println("Success_deleteTable2&7:" + i2 +"," + i7);
				return 0;
			}catch(SQLException e) {
				conn.rollback();
				System.out.println(e.getMessage());
				return 1;
			}
			
		}catch(Exception f) {
			System.out.println(f.getMessage());
			return 1;
		}
	}
}