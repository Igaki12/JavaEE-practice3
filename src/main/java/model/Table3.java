package model;

import java.io.Serializable;
import java.util.Date;

public class Table3 implements Serializable{
	private int id = 0;
	private int biz_id = 0;
	private String ticket_code = null;
	private int contents_type = 0;
	private int contents_index = 0;
	private String contents_data = null;
	private Date created_at;
	private Date updated_at;
	
	public Table3() {}

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

	public int getContents_type() {
		return contents_type;
	}

	public void setContents_type(int contents_type) {
		this.contents_type = contents_type;
	}

	public int getContents_index() {
		return contents_index;
	}

	public void setContents_index(int contents_index) {
		this.contents_index = contents_index;
	}

	public String getContents_data() {
		return contents_data;
	}

	public void setContents_data(String contents_data) {
		this.contents_data = contents_data;
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