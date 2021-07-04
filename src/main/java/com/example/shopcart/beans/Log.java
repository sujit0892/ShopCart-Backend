package com.example.shopcart.beans;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Log {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int log_id;
	
	@Column
	private String keyword;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
	private User user;

	@Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Log(String keyword, User user, Date date) {
		super();
		this.keyword = keyword;
		this.user = user;
		this.date = date;
	}

	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getLog_id() {
		return log_id;
	}

	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
