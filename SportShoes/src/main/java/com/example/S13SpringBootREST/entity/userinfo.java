package com.example.S13SpringBootREST.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userinfo")
public class userinfo {
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private int log_id;
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	private int id;
	private LocalDateTime logtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getLogtime() {
		return logtime;
	}
	public void setLogtime(LocalDateTime logtime) {
		this.logtime = logtime;
	}
	

}
