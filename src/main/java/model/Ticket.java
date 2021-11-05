package  model;

import java.io.Serializable;

public class Ticket implements Serializable {
	
	private String ticket_name = null;
	private String ticket_code = null;
	private String type_money1 = null;
	
	public String getTicket_name() {
		return ticket_name;
	}

	public void setTicket_name(String ticket_name) {
		this.ticket_name = ticket_name;
	}

	public String getTicket_code() {
		return ticket_code;
	}

	public void setTicket_code(String ticket_code) {
		this.ticket_code = ticket_code;
	}

	public String getType_money1() {
		return type_money1;
	}

	public void setType_money1(String type_money1) {
		this.type_money1 = type_money1;
	}

	public Ticket() { }
	
	
}