package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class lonelyTweetModel {
	private String text;
	private Date timestamp;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public lonelyTweetModel(String text, Date timestamp) {
		super();
		this.text = text;
		this.timestamp = timestamp;
	}
	public lonelyTweetModel(String text) {
		super();
		this.text = text;
		this.timestamp = new Date();
	}
	
}
