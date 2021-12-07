package model;

import java.io.Serializable;

public class Table8 implements Serializable{
	
	private int id = 0;
	private String reserv_code = null;
	private int biz_id = 0;
	private String ticket_code = null;
	private int sales_id = 0;
	private int user_id = 0;
	private String ticket_name = null;
	private int tickets_kind = 0;
	private String ticket_buyday;
	private String ticket_interval_start;
	private String ticket_interval_end;
	private String ticket_start;
	private String ticket_end;
	private int ticket_total_num = 0;
	private String cancel_limit_start;
	private String cancel_end;
	private int ticket_status = 0;
	private String created_at;
	private String updated_at;
	private String deleted_at;
	
	public Table8() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReserv_code() {
		return reserv_code;
	}
	public void setReserv_code(String reserv_code) {
		this.reserv_code = reserv_code;
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getTicket_name() {
		return ticket_name;
	}
	public void setTicket_name(String ticket_name) {
		this.ticket_name = ticket_name;
	}
	public int getTickets_kind() {
		return tickets_kind;
	}
	public void setTickets_kind(int tickets_kind) {
		this.tickets_kind = tickets_kind;
	}
	public String getTicket_buyday() {
		return ticket_buyday;
	}
	public void setTicket_buyday(String ticket_buyday) {
		this.ticket_buyday = ticket_buyday;
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
	public String getTicket_start() {
		return ticket_start;
	}
	public void setTicket_start(String ticket_start) {
		this.ticket_start = ticket_start;
	}
	public String getTicket_end() {
		return ticket_end;
	}
	public void setTicket_end(String ticket_end) {
		this.ticket_end = ticket_end;
	}
	public int getTicket_total_num() {
		return ticket_total_num;
	}
	public void setTicket_total_num(int ticket_total_num) {
		this.ticket_total_num = ticket_total_num;
	}
	public String getCancel_limit_start() {
		return cancel_limit_start;
	}
	public void setCancel_limit_start(String cancel_limit_start) {
		this.cancel_limit_start = cancel_limit_start;
	}
	public String getCancel_end() {
		return cancel_end;
	}
	public void setCancel_end(String cancel_end) {
		this.cancel_end = cancel_end;
	}
	public int getTicket_status() {
		return ticket_status;
	}
	public void setTicket_status(int ticket_status) {
		this.ticket_status = ticket_status;
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
	public String getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}
}