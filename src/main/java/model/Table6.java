package model;

import java.io.Serializable;
import java.util.Date;

public class Table6 implements Serializable {
	private int id = 0;
	private int biz_id = 0;
	private String ticket_code = null;
	private int svc_id = 0;
	private String svc_name = null;
	private String svc_cautions = null;
	private int svc_type = 0;
	private int svc_select_type = 0;
	private int usage_time = 0;
	private Date created_at;
	private Date updated_at;
	
	public Table6() {}

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

	public int getSvc_id() {
		return svc_id;
	}

	public void setSvc_id(int svc_id) {
		this.svc_id = svc_id;
	}

	public String getSvc_name() {
		return svc_name;
	}

	public void setSvc_name(String svc_name) {
		this.svc_name = svc_name;
	}

	public String getSvc_cautions() {
		return svc_cautions;
	}

	public void setSvc_cautions(String svc_cautions) {
		this.svc_cautions = svc_cautions;
	}

	public int getSvc_type() {
		return svc_type;
	}

	public void setSvc_type(int svc_type) {
		this.svc_type = svc_type;
	}

	public int getSvc_select_type() {
		return svc_select_type;
	}

	public void setSvc_select_type(int svc_select_type) {
		this.svc_select_type = svc_select_type;
	}

	public int getUsage_time() {
		return usage_time;
	}

	public void setUsage_time(int usage_time) {
		this.usage_time = usage_time;
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