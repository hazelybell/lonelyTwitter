package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class MoodHappy extends Mood{
	private Date date;

	public MoodHappy(){
		super();
	}

	public MoodHappy(Date date){
		super(date);
	}

	public Date getDate(){
		return date;
	}

	public void setDate(Date date){
		this.date = date;
	}

	@Override
	public String toString(){
		return "Happy";
	}
}
