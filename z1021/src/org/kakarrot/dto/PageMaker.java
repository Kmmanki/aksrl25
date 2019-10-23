package org.kakarrot.dto;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageMaker {
	private Paging paging;
	private int start;
	private int end;
	private boolean prev, next;
	private int total;
	private int page;
	public PageMaker(Paging paging, int total) {
		super();
		this.paging = paging;
		this.total = total;
		
		int tempEnd = (int)Math.ceil(paging.getPage()/10.0)*10;
		this.start = tempEnd-9;
		this.prev = this.start != 1;
		int realEnd = (total/ paging.getAmount())+1;
		end = tempEnd > realEnd ? realEnd:  tempEnd;
		this.next = this.end* paging.getAmount()<total; 
		
	}
	public static void main(String[] args) {
		Paging dto = new Paging("10","10");
		PageMaker pm = new PageMaker(dto,100);
		System.out.println(pm);
	}
	
	
}
