package model;

import java.io.Serializable;

public class Table2 implements Serializable {
	private int id = 0;
	private int biz_id = 0;
	private String ticket_code = null;
	private int sales_id = 0;
	private String sales_interval_start = null;
	private String sales_interval_end = null;
	private String created_at = null;
	private String updated_at = null;
	
	public Table2() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBiz_id() {
		return biz_id;
	}

	public void setBiz_id(int biz_id) {
		this.biz_id = biz_id;
	}

	public String getTicket_code() {
		return ticket_code;
	}

	public void setTicket_code(String ticket_code) {
		this.ticket_code = ticket_code;
	}

	public int getSales_id() {
		return sales_id;
	}

	public void setSales_id(int sales_id) {
		this.sales_id = sales_id;
	}

	public String getSales_interval_start() {
		return sales_interval_start;
	}

	public void setSales_interval_start(String sales_interval_start) {
		this.sales_interval_start = sales_interval_start;
	}

	public String getSales_interval_end() {
		return sales_interval_end;
	}

	public void setSales_interval_end(String sales_interval_end) {
		this.sales_interval_end = sales_interval_end;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
}