package model;

import java.io.Serializable;

public class PageProperty implements Serializable{
	
	private int page = 0;
	private int kind = 0;
	
	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public PageProperty() {}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}