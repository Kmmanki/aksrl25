package org.zerock.service;

import java.util.ArrayList;
import java.util.List;

public enum SampleService {
	instace;
	
	private List<String> list;
	
	SampleService() {
		list = new ArrayList<String>();
	}
	
	public void add (String str) {
		list.add(str);
	}
	
	public List<String> getList(){
		return list;
	}
	
}
