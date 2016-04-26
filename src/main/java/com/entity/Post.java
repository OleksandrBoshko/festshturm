package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	

	@Column(length=10000, name="text")
	private String text;

	@Column(name = "subject")
	private String subject;
	
	@Column(name = "publishedDate")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date publishedDate;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "slug")
	private String slug;
	

	
	public Post(String text, String slug, String subject) {
		super();
		this.text = text;
		this.subject = subject;
//		this.publishedDate = publishedDate;
//		this.status = status;
		this.slug = slug;
	}
	
	@PrePersist
	public void currentDate(){
		publishedDate = new Date();
	}
	
	public Post() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	
}


