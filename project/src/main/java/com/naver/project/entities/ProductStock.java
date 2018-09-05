package com.naver.project.entities;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ProductStock {
	private String procode;
	private String year;
	private String month;
	private String day;
	private int preddstock;
	private int changestock;
	private int curstock;
}
