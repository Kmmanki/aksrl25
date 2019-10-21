package org.zerock.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VO {
	private int sno;
	private String sname;
	private double lat;
	private double lng;
}
