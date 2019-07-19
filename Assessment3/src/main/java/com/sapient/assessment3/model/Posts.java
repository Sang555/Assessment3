package com.sapient.assessment3.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Posts")
public class Posts implements Serializable{

    @Id
    @Column(name="id")
    private long id;

    @Column(name="user_id")
    private long user_id;
    
    @Column(name="title")
    private String title;
    
    @Column(name="body")
    private String body;

	public long getId() {
		return id;
	}

	public Posts()
	{
		
	}
	public void setId(long id) {
		this.id = id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Posts(long id, long user_id, String title, String body) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.title = title;
		this.body = body;
	}
    
}
