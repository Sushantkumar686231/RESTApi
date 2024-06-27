package com.example.demo.entity;

public class JournalEntity {

	private long Id;
	private String title;
	private String Content;
	
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public JournalEntity() {
		super();
	}
	public JournalEntity(long id, String title, String content) {
		super();
		Id = id;
		this.title = title;
		Content = content;
	}
	
	
	
}
