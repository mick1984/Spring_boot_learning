package com.example.model;

public class Hello {
	private String title;
	private String content;
	private String url;
	
	public Hello()
	{
	}
	
	public Hello(String t_title,String t_content,String t_url)
	{
		this.title=t_title;
		this.content = t_content;
		this.url = t_url;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
