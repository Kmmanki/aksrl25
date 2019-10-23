package org.kakarrot.controller;

public class test {

public static void main(String[] args) {
		
		int page = 3;
		int total = 50;
		boolean prev = false;
		boolean next = false;
		
		//10
		int totalPage = (int)(Math.ceil(total/10.0));
		
		//10 
		int tempEnd = (int)(Math.ceil( page/ 5.0) * 10);
		
		//11
		int start = tempEnd - 9;
		
		prev = start != 1;
		
		int end = -1;
		
		if(totalPage < tempEnd) {
			end = totalPage;
		}else {
			end = tempEnd;
		}
		
		next = totalPage > tempEnd;
		
		System.out.println("Start: " + start);
		System.out.println("End: " + end);
		System.out.println("Prev: " + prev);
		System.out.println("Next: " + next);
		
		System.out.println("===========================");
		
		if(prev) {
			System.out.print("\t"+ (start-1));	
		}		
		
		for(int i = start; i <= end; i++) {
			
			System.out.print("\t" + i );			
			
		}
		
		if(next) {
			System.out.print("\t"+ (end + 1));	
		}		
		System.out.println();
		System.out.println("===========================");
		
		
		
		
	}
}
