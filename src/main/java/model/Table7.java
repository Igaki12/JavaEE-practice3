package model;

import java.io.Serializable;

public class Table7 implements Serializable {
	private int id = 0;
	private int biz_id = 0;
	private String ticket_code = null;
	private int sales_id = 0;
	private String ticket_interval_start = null;
	private String ticket_interval_end = null;
	private int ticket_days = 0;
	private int ticket_num = 0;
	private int ticket_min_num = 0;
	private int ticket_max_num = 0;
	private String created_at = null;
	private String updated_at = null;
	
	public Table7() {}

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

	public String getTicket_interval_start() {
		return ticket_interval_start;
	}

	public void setTicket_interval_start(String ticket_interval_start) {
		this.ticket_interval_start = ticket_interval_start;
	}

	public String getTicket_interval_end() {
		return ticket_interval_end;
	}

	public void setTicket_interval_end(String ticket_interval_end) {
		this.ticket_interval_end = ticket_interval_end;
	}

	public int getTicket_days() {
		return ticket_days;
	}

	public void setTicket_days(int ticket_days) {
		this.ticket_days = ticket_days;
	}

	public int getTicket_num() {
		return ticket_num;
	}

	public void setTicket_num(int ticket_num) {
		this.ticket_num = ticket_num;
	}

	public int getTicket_min_num() {
		return ticket_min_num;
	}

	public void setTicket_min_num(int ticket_min_num) {
		this.ticket_min_num = ticket_min_num;
	}

	public int getTicket_max_num() {
		return ticket_max_num;
	}

	public void setTicket_max_num(int ticket_max_num) {
		this.ticket_max_num = ticket_max_num;
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