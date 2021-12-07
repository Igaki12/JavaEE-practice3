package model;

import java.io.Serializable;

public class Table10 implements Serializable{
	
	private int id = 0;
	private String reserv_code;
	private int type_id = 0;
	private String type_name;
	private int type_money = 0;
	private int buy_num = 0;
	private int cancel_money = 0;
	private String created_at;
	private String updated_at;
	private String deleted_at;
	
	public Table10() {}
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
	public int getBuy_num() {
		return buy_num;
	}
	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
	}
	public int getCancel_money() {
		return cancel_money;
	}
	public void setCancel_money(int cancel_money) {
		this.cancel_money = cancel_money;
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