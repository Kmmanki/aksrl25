package org.kakarrot.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private Long pno ,view_count;
	private String tilte, writer, content;
	private Date regdate,updatedate;

}
