package com.alex.angular.model;

/**
 * Created by Shishkov A.V. on 16.05.18.
 */
public class Greeting {
	private Long id;
	private String content;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
