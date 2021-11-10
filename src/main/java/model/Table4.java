package model;

import java.io.Serializable;
import java.util.Date;

public class Table4 implements Serializable{
	
	private int id = 0;
	private int biz_id = 0;
	private String ticket_code = null;
	private int cautions_type = 0;
	private int cautions_index = 0;
	private String cautions_text = null;
	private Date created_at;
	private Date updated_at;
	
	public Table4() {}
	
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
	public int getCautions_type() {
		return cautions_type;
	}
	public void setCautions_type(int cautions_type) {
		this.cautions_type = cautions_type;
	}
	public int getCautions_index() {
		return cautions_index;
	}
	public void setCautions_index(int cautions_index) {
		this.cautions_index = cautions_index;
	}
	public String getCautions_text() {
		return cautions_text;
	}
	public void setCautions_text(String cautions_text) {
		this.cautions_text = cautions_text;
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