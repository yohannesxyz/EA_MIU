package bank.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class TraceRecord {
	@Id
	@GeneratedValue
	private long id;
	private Date date;
	private String message;
	public TraceRecord() {
	}
	public TraceRecord(Date date, String message) {
		this.date = date;
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String name) {
		this.message = name;
	}
	
	
	
}
