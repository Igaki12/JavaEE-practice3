package model;

import java.io.Serializable;

public class PageProperty implements Serializable{
	
	private int page = 0;
	
	public PageProperty() {}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}