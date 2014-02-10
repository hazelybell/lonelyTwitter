package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class LonelyTweetModel {
	private String text;
	protected Date timestamp;
	
	public String getText() {
		return text;
	}
	
	public LonelyTweetModel(String text) {
		super();
		this.text = text;
		timestamp = new Date();
	}
	
	public LonelyTweetModel(String text, Date timestamp) {
		super();
		this.text = text;
		this.timestamp = timestamp;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public abstract Date getTimestamp();
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public boolean equals(Object other) {
		if (other == null || !(other instanceof LonelyTweetModel)) {
			return false;
		}
		
		LonelyTweetModel otherTweet = (LonelyTweetModel) other;
		return timestamp.equals(otherTweet.timestamp) && text.equals(otherTweet.text);
	}
	
	@Override
	public String toString() {
		return new String(timestamp.toString() + " | " + getText());
	}
}
