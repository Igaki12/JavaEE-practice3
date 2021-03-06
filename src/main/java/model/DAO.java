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
	
	
	
	public static int CountUserByLogin_idPassword(String login_id, String password) {
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(*) AS num FROM user WHERE login_id=? AND password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, login_id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			int num = 0;
			rs.next();
			num = rs.getInt("num");
			System.out.println(ps);
			
			rs.close();
			ps.close();
			conn.close();
			return num;
		}catch(Exception e ) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	public static int SumBuy_total_numFromTable10WhereTable8Ticket_code(String ticket_code){
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT SUM(buy_num) FROM Table10 WHERE reserv_code = (SELECT reserv_code FROM Table8 WHERE ticket_code=?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ticket_code);
			rs = ps.executeQuery();
		
			int sum = 0;
			rs.next();
			sum = rs.getInt("SUM(buy_num)");
			System.out.println(ps);
			rs.close();
			ps.close();
			conn.close();
			return sum;
		}catch(Exception e ) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	public static List<SumPriceList> ViewSumPricesDuringThisMonth(String startDatetime,String endDatetime) {
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<SumPriceList> list = new ArrayList<SumPriceList>();
		String DatetimeNow = model.CalendarCuliculator.StrCalendarNowTime();
		try {
			String sql = "SELECT Table8.ticket_code,tickets_kind,ticket_start,ticket_end,type_name,type_money,cancel_money,sum(buy_num) AS buy_num_sum,type_money*sum(buy_num) AS sum_money,ticket_status,svc_start FROM Table10 INNER JOIN Table8 ON Table8.reserv_code=Table10.reserv_code INNER JOIN Table9 ON Table8.reserv_code=Table9.reserv_code WHERE ticket_status=0 AND ticket_end<? AND ticket_end BETWEEN ? AND ? GROUP BY ticket_code,type_name,ticket_status"
					 + " UNION ALL "
					 + "SELECT Table8.ticket_code,tickets_kind,ticket_start,ticket_end,type_name,type_money,cancel_money,sum(buy_num) AS buy_num_sum,type_money*sum(buy_num) AS sum_money,ticket_status,svc_start FROM Table10 INNER JOIN Table8 ON Table8.reserv_code=Table10.reserv_code INNER JOIN Table9 ON Table8.reserv_code=Table9.reserv_code WHERE ticket_status=1 AND Table9.svc_start BETWEEN ? AND ? GROUP BY ticket_code,type_name,ticket_status"
					 + " UNION ALL "
					 + "SELECT Table8.ticket_code,tickets_kind,ticket_start,ticket_end,type_name,type_money,cancel_money,sum(buy_num) AS buy_num_sum,type_money*sum(buy_num) AS sum_money,ticket_status,svc_start FROM Table10 INNER JOIN Table8 ON Table8.reserv_code=Table10.reserv_code INNER JOIN Table9 ON Table8.reserv_code=Table9.reserv_code WHERE ticket_status=2 AND Table9.svc_start BETWEEN ? AND ? GROUP BY ticket_code,type_name,ticket_status"
					 + " UNION ALL "
					 + "SELECT Table8.ticket_code,tickets_kind,ticket_start,ticket_end,type_name,type_money,cancel_money,sum(buy_num) AS buy_num_sum,type_money*sum(buy_num) AS sum_money,ticket_status,svc_start FROM Table10 INNER JOIN Table8 ON Table8.reserv_code=Table10.reserv_code INNER JOIN Table9 ON Table8.reserv_code=Table9.reserv_code WHERE ticket_status=3 AND ticket_end<? AND ticket_end BETWEEN ? AND ? GROUP BY ticket_code,type_name,ticket_status"
					 + " UNION ALL "
					 + "SELECT Table8.ticket_code,tickets_kind,ticket_start,ticket_end,type_name,type_money,cancel_money,sum(buy_num) AS buy_num_sum,type_money*sum(buy_num) AS sum_money,ticket_status,svc_start FROM Table10 INNER JOIN Table8 ON Table8.reserv_code=Table10.reserv_code INNER JOIN Table9 ON Table8.reserv_code=Table9.reserv_code WHERE ticket_status=9 AND Table8.updated_at BETWEEN ? AND ? GROUP BY ticket_code,type_name,ticket_status"
					 + " UNION ALL "
					 + "SELECT Table8.ticket_code,tickets_kind,ticket_start,ticket_end,type_name,type_money,cancel_money,sum(buy_num) AS buy_num_sum,cancel_money*sum(buy_num) AS sum_money,ticket_status,svc_start FROM Table10 INNER JOIN Table8 ON Table8.reserv_code=Table10.reserv_code INNER JOIN Table9 ON Table8.reserv_code=Table9.reserv_code WHERE ticket_status=10 AND Table8.updated_at BETWEEN ? AND ? GROUP BY ticket_code,type_name,ticket_status"
					 + " ORDER BY ticket_code,type_name,ticket_status";
			ps = conn.prepareStatement(sql);
			ps.setString(1, DatetimeNow);
			ps.setString(2, startDatetime);
			ps.setString(3, endDatetime);
			ps.setString(4, startDatetime);
			ps.setString(5, endDatetime);
			ps.setString(6, startDatetime);
			ps.setString(7, endDatetime);
			ps.setString(8, DatetimeNow);
			ps.setString(9, startDatetime);
			ps.setString(10, endDatetime);
			ps.setString(11, startDatetime);
			ps.setString(12, endDatetime);
			ps.setString(13, startDatetime);
			ps.setString(14, endDatetime);
			System.out.println(ps);
			rs = ps.executeQuery();
			SumPriceList sum = new SumPriceList();
			sum.setTicket_code("");
			sum.setType_name("");
			while(rs.next()) {
				if(rs.getString("ticket_code").equals(sum.getTicket_code()) == false || rs.getString("type_name").equals(sum.getType_name()) == false  ) {
					list.add(sum);
				    sum = new SumPriceList();
				    sum.setTicket_code(rs.getString("ticket_code"));
				    sum.setTickets_kind(rs.getInt("tickets_kind"));
				    sum.setTicket_interval_start(rs.getString("ticket_start"));
				    sum.setTicket_interval_end(rs.getString("ticket_end"));
				    sum.setType_name(rs.getString("type_name"));
				    sum.setType_money(rs.getInt("type_money"));
				    sum.setCancel_money(rs.getInt("cancel_money"));
				    sum.setBuy_num(0);
				    sum.setCanceled_num_before(0);
				    sum.setCanceled_num_at_last_moment(0);
				    sum.setSum_money(0);
				    
				}
				if(rs.getInt("ticket_status") < 4) {
					sum.setBuy_num(sum.getBuy_num() + rs.getInt("buy_num_sum"));
					sum.setSum_money(sum.getSum_money() + rs.getInt("sum_money"));
				}if(rs.getInt("ticket_status") == 9) {
					sum.setCanceled_num_before(rs.getInt("buy_num_sum"));
				}if(rs.getInt("ticket_status") == 10) {
					sum.setCanceled_num_at_last_moment(rs.getInt("buy_num_sum"));
					sum.setSum_money(sum.getSum_money() + rs.getInt("sum_money"));
				}
				
			}
			list.add(sum);
			list.remove(0);
			rs.close();
			ps.close();
			conn.close();
			return list;
			
		}catch(Exception e) {
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
				t2.setSales_id(rs.getInt("sales_id"));
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
	
	public static Table2 SelectTable2ById(int id) {
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM Table2 WHERE id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
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
			
			
		}catch(Exception e) {
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
	
	public static Table3 SelectTable3ByBiz_idTicket_codeContents_type(int biz_id,String ticket_code,int contents_type) {
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM Table3 WHERE biz_id=? AND ticket_code=? AND contents_type=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			ps.setInt(3, contents_type);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			rs.next();
			Table3 t3 = new Table3();
			    t3.setId(rs.getInt("id"));
			    t3.setBiz_id(rs.getInt("biz_id"));
			    t3.setTicket_code(rs.getString("ticket_code"));
			    t3.setContents_type(rs.getInt("contents_type"));
			    t3.setContents_index(rs.getInt("contents_index"));
			    t3.setContents_data(rs.getString("contents_data"));
			
			
			rs.close();
			ps.close();
			conn.close();
			return t3;
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
	
	public static Table4 SelectTable4ByBiz_idTicket_codeCautions_type(int biz_id, String ticket_code, int cautions_type) {
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM Table4 WHERE biz_id=? AND ticket_code=? AND cautions_type=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			ps.setInt(3, cautions_type);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			rs.next();	
			Table4 t4 = new Table4();
			    t4.setId(rs.getInt("id"));
			    t4.setBiz_id(rs.getInt("biz_id"));
			    t4.setTicket_code(rs.getString("ticket_code"));
			    t4.setCautions_type(rs.getInt("cautions_type"));
			    t4.setCautions_index(rs.getInt("cautions_index"));
			    t4.setCautions_text(rs.getString("cautions_text"));
			   
			
			rs.close();
			ps.close();
			conn.close();
			return t4;
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
	
	public static Table8 SelectTable8ByBiz_idTicket_code(int biz_id,String ticket_code) {
		
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM Table8 WHERE biz_id=? AND ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			rs.next();
			Table8 t8 = new Table8();
			t8.setId(rs.getInt("id"));
			t8.setReserv_code(rs.getString("reserv_code"));
			t8.setBiz_id(rs.getInt("biz_id"));
			t8.setTicket_code(rs.getString("ticket_code"));
			t8.setSales_id(rs.getInt("sales_id"));
			t8.setUser_id(rs.getInt("user_id"));
			t8.setTicket_name(rs.getString("ticket_name"));
			t8.setTickets_kind(rs.getInt("tickets_kind"));
			t8.setTicket_buyday(rs.getString("ticket_buyday"));
			t8.setTicket_interval_start(rs.getString("ticket_interval_start"));
			t8.setTicket_interval_end(rs.getString("ticket_interval_end"));
			t8.setTicket_start(rs.getString("ticket_start"));
			t8.setTicket_end(rs.getString("ticket_end"));
			t8.setTicket_total_num(rs.getInt("ticket_total_num"));
			t8.setCancel_limit_start(rs.getString("cancel_limit_start"));
			t8.setCancel_end(rs.getString("cancel_end"));
			t8.setTicket_status(rs.getInt("ticket_status"));
			t8.setCreated_at(rs.getString("created_at"));
			t8.setUpdated_at(rs.getString("updated_at"));
			t8.setDeleted_at(rs.getString("deleted_at"));
			
			
			rs.close();
			ps.close();
			conn.close();
			return t8;
					
		}catch ( Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
public static int SumTicket_total_numOfTable8WhereBiz_idTicket_code(int biz_id,String ticket_code) {
		
		Connection conn = (Connection)Connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT SUM(ticket_total_num) AS total FROM Table8 WHERE biz_id=? AND ticket_code=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, biz_id);
			ps.setString(2, ticket_code);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			rs.next();
			int ticket_total_num = rs.getInt("total");
			
			
			rs.close();
			ps.close();
			conn.close();
			return ticket_total_num;
					
		}catch ( Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
		
	}

    public static int InsertUser(User user) {
    	Connection conn = (Connection)Connect();
    	PreparedStatement ps = null;
    	try {
    		try {
    			String sql = "INSERT INTO user(login_id,password) VALUES(?,?)";
    			ps = conn.prepareStatement(sql);
    			ps.setString(1, user.getLogin_id());
    			ps.setString(2, user.getPassword());
    			System.out.println(ps);
    			int i = ps.executeUpdate();
    			conn.commit();
    			System.out.println("Success_InsertUser" + i);
    			
    			ps.close();
    			conn.close();
    			return 0;
    			
    			
    		}catch(SQLException e) {
    			System.out.println(e.getMessage());
    			conn.rollback();
    			return 1;
    		}
    	}catch(Exception f) {
    		System.out.println(f.getMessage());
    		return 1;
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
	public static int InsertTable8to10(Table8 t8, Table9 t9, List<Table10> list10){
		Connection conn = (Connection)Connect();
		String sql = null;
		PreparedStatement ps = null;
		
		try {
			try {
				sql = "INSERT INTO Table8(reserv_code,biz_id,ticket_code,sales_id,user_id,ticket_name,tickets_kind,ticket_buyday,ticket_interval_start,ticket_interval_end,ticket_start,ticket_end,ticket_total_num,cancel_limit_start,cancel_end,ticket_status,created_at,updated_at) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, t8.getReserv_code());
				ps.setInt(2, t8.getBiz_id());
				ps.setString(3, t8.getTicket_code());
				ps.setInt(4, t8.getSales_id());
				ps.setInt(5, t8.getUser_id());
				ps.setString(6, t8.getTicket_name());
				ps.setInt(7, t8.getTickets_kind());
				ps.setString(8, t8.getTicket_buyday());
				ps.setString(9, t8.getTicket_interval_start());
				ps.setString(10, t8.getTicket_interval_end());
				ps.setString(11, t8.getTicket_start());
				ps.setString(12, t8.getTicket_end());
				ps.setInt(13, t8.getTicket_total_num());
				ps.setString(14, t8.getCancel_limit_start());
				ps.setString(15, t8.getCancel_end());
				ps.setInt(16, t8.getTicket_status());
				ps.setString(17, t8.getCreated_at());
				ps.setString(18, t8.getUpdated_at());
				System.out.println(ps);
				int i8 = ps.executeUpdate();
				
				sql = "INSERT INTO Table9(reserv_code,svc_id,svc_name,svc_type,svc_select_type,select_btn_id,usage_time,svc_status,svc_start,svc_end,created_at,updated_at) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1,t9.getReserv_code());
				ps.setInt(2, t9.getSvc_id());
				ps.setString(3, t9.getSvc_name());
				ps.setInt(4, t9.getSvc_type());
				ps.setInt(5, t9.getSvc_select_type());
				ps.setInt(6, t9.getSelect_btn_id());
				ps.setInt(7, t9.getUsage_time());
				ps.setInt(8, t9.getSvc_status());
				ps.setString(9, t9.getSvc_start());
				ps.setString(10, t9.getSvc_end());
				ps.setString(11, t9.getCreated_at());
				ps.setString(12, t9.getUpdated_at());
				System.out.println(ps);
				int i9 = ps.executeUpdate();
				
				int i10 = 0;
				for(Table10 t10: list10) {
					sql = "INSERT INTO Table10(reserv_code,type_id,type_name,type_money,buy_num,cancel_money,created_at,updated_at) VALUES (?,?,?,?,?,?,?,?)";
					ps = conn.prepareStatement(sql);
					ps.setString(1, t10.getReserv_code());
					ps.setInt(2, t10.getType_id());
					ps.setString(3, t10.getType_name());
					ps.setInt(4, t10.getType_money());
					ps.setInt(5, t10.getBuy_num());
					ps.setInt(6, t10.getCancel_money());
					ps.setString(7, t10.getCreated_at());
					ps.setString(8, t10.getUpdated_at());
					System.out.println(ps);
					i10 += ps.executeUpdate();
				}
				
				
				
				conn.commit();
				System.out.println("Success_InsertTable8-10:" + i8 + "," + i9 + "," + i10);
				ps.close();
				conn.close();
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
				
//				Table5?????????????????V???K???????????????????\?????????A??????x?????????????????f???[???^??????S??????????????????????????????????????????
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