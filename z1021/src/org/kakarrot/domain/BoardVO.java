package org.kakarrot.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {
	
	private Long pno;
	private String title, writer, content;
	private Date regdate,updatedate;
	private int view_count;
	private List<String> fnames;

}
