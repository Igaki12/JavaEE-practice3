package model;

import java.io.Serializable;
import java.util.Date;

public class Table5 implements Serializable {
	
	private int id = 0;
	private int biz_id = 0;
	
	private String ticket_code = null;
	private int type_id = 0;
	private String type_name = null;
	private int type_money = 0;
	private int cancel_type = 0;
	private int cancel_rate = 0;
	private Date created_at;
	private Date updated_at;
	
	public Table5 () {}
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
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public int getType_money() {
		return type_money;
	}
	public void setType_money(int type_money) {
		this.type_money = type_money;
	}
	public int getCancel_type() {
		return cancel_type;
	}
	public void setCancel_type(int cancel_type) {
		this.cancel_type = cancel_type;
	}
	public int getCancel_rate() {
		return cancel_rate;
	}
	public void setCancel_rate(int cancel_rate) {
		this.cancel_rate = cancel_rate;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
}