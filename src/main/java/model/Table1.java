package model;

import java.io.Serializable;
import java.util.Date;

public class Table1 implements Serializable {
	
	private int id = 0;
	private int biz_id = 0;
	private String ticket_code = null;
	private int spot_area_id = 0;
	private String genre_code1 = null;
	private String genre_code2 = null;
	private String ticket_name = null;
	private String ticket_remarks = null;
	private int tickets_kind = 0;
	private int minors_flag = 0;
	private int cancel_flag = 0;
	private int cancel_limit = 0;
	private String created_at;
	private String updated_at;
	
	public int getSpot_area_id() {
		return spot_area_id;
	}

	public void setSpot_area_id(int spot_area_id) {
		this.spot_area_id = spot_area_id;
	}
	
	public int getBiz_id() {
		return biz_id;
	}

	public void setBiz_id(int biz_id) {
		this.biz_id = biz_id;
	}

	public int getCancel_flag() {
		return cancel_flag;
	}

	public void setCancel_flag(int cancel_flag) {
		this.cancel_flag = cancel_flag;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTicket_code() {
		return ticket_code;
	}

	public void setTicket_code(String ticket_code) {
		this.ticket_code = ticket_code;
	}

	public String getGenre_code1() {
		return genre_code1;
	}

	public void setGenre_code1(String genre_code1) {
		this.genre_code1 = genre_code1;
	}

	public String getGenre_code2() {
		return genre_code2;
	}

	public void setGenre_code2(String genre_code2) {
		this.genre_code2 = genre_code2;
	}

	public String getTicket_name() {
		return ticket_name;
	}

	public void setTicket_name(String ticket_name) {
		this.ticket_name = ticket_name;
	}

	public String getTicket_remarks() {
		return ticket_remarks;
	}

	public void setTicket_remarks(String ticket_remarks) {
		this.ticket_remarks = ticket_remarks;
	}

	public int getTickets_kind() {
		return tickets_kind;
	}

	public void setTickets_kind(int tickets_kind) {
		this.tickets_kind = tickets_kind;
	}

	public int getMinors_flag() {
		return minors_flag;
	}

	public void setMinors_flag(int minors_flag) {
		this.minors_flag = minors_flag;
	}

	public int getCancel_limit() {
		return cancel_limit;
	}

	public void setCancel_limit(int cancel_limit) {
		this.cancel_limit = cancel_limit;
	}

	public Table1() {}
	
	
}