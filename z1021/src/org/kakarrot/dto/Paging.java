package org.kakarrot.dto;

import lombok.Data;

public class Paging {
	private int page;
	private int amount;

	public Paging() {
		this.page = 1;
		this.amount = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <=0) return;
		this.page = page;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}