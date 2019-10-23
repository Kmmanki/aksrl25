package org.zerock.demo;

import org.zerock.anno.Job;

public class EnglishCalcurator {
	
	@Job("plus")
	public void plus() {
		System.out.println("plus...");
	}
	
	@Job("minus")
	public void sub() {
		System.out.println("sub...");
	}
}
