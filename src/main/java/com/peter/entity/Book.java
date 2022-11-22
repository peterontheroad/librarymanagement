package com.peter.entity;

import lombok.Data;

@Data
public class Book {
	private long id;
	private String title;
	private String author;
	private long sn;
}
