package model;

import java.io.Serializable;

public class Table9 implements Serializable{
	
	private int id = 0;
	private String reserv_code;
	private int svc_id = 0;
	private String svc_name;
	private int svc_type= 0;
	private int svc_select_type = 0;
	private int select_btn_id = 0;
	private int usage_time = 0;
	private int svc_status = 0;
	private String svc_start;
	private String svc_end;
	private String created_at;
	private String updated_at;
	private String deleted_at;
	
	public Table9() {}
	
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
	public int getSelect_btn_id() {
		return select_btn_id;
	}
	public void setSelect_btn_id(int select_btn_id) {
		this.select_btn_id = select_btn_id;
	}
	public int getUsage_time() {
		return usage_time;
	}
	public void setUsage_time(int usage_time) {
		this.usage_time = usage_time;
	}
	public int getSvc_status() {
		return svc_status;
	}
	public void setSvc_status(int svc_status) {
		this.svc_status = svc_status;
	}
	public String getSvc_start() {
		return svc_start;
	}
	public void setSvc_start(String svc_start) {
		this.svc_start = svc_start;
	}
	public String getSvc_end() {
		return svc_end;
	}
	public void setSvc_end(String svc_end) {
		this.svc_end = svc_end;
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