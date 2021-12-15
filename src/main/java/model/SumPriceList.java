package model;

import java.io.Serializable;

public class SumPriceList implements Serializable{
	
	private int id = 0;
	private String ticket_code = null;
	private int tickets_kind = 0;
	private String ticket_interval_start;
	private String ticket_interval_end;
	private String type_name;
	private int type_money = 0;
	private int cancel_money = 0;
	private int buy_num = 0;
	private int canceled_num_before = 0;
	private int canceled_num_at_last_moment = 0;
	private int sum_money = 0;
	
	public SumPriceList() {}
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
	public int getTickets_kind() {
		return tickets_kind;
	}
	public void setTickets_kind(int tickets_kind) {
		this.tickets_kind = tickets_kind;
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
	
	public int getCancel_money() {
		return cancel_money;
	}
	public void setCancel_money(int cancel_money) {
		this.cancel_money = cancel_money;
	}
	
	public int getBuy_num() {
		return buy_num;
	}
	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
	}
	
	public int getCanceled_num_before() {
		return canceled_num_before;
	}
	public void setCanceled_num_before(int canceled_num_before) {
		this.canceled_num_before = canceled_num_before;
	}
	public int getCanceled_num_at_last_moment() {
		return canceled_num_at_last_moment;
	}
	public void setCanceled_num_at_last_moment(int canceled_num_at_last_moment) {
		this.canceled_num_at_last_moment = canceled_num_at_last_moment;
	}
	public int getSum_money() {
		return sum_money;
	}
	public void setSum_money(int sum_money) {
		this.sum_money = sum_money;
	}
}