package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	private String title;
	
	//방법1
	//private Date dueDate;//java.util.Date
	
	//방법2
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dueDate;//java.util.Date
}
