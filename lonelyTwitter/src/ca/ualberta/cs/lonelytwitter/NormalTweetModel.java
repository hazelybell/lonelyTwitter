package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

import com.google.gson.Gson;

public class NormalTweetModel extends LonelyTweetModel {
	
	public NormalTweetModel() {
		super("", new Date());
	}
	
	public NormalTweetModel(String text, Date timestamp) {
		super(text, timestamp);
	}
	
	public NormalTweetModel(String text) {
		super(text);
	}

	@Override
	public Date getTimestamp() {
		return timestamp;
	}
	
	@Override
	public boolean equals(Object other) {
		return super.equals(other) && (other instanceof NormalTweetModel);
	}

	public static NormalTweetModel fromJSON(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, NormalTweetModel.class);
	}
	
	public String toJSON() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
