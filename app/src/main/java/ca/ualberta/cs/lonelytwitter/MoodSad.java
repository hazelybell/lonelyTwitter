package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class MoodSad extends Mood{
	private Date date;

	public MoodSad(){
		super();
	}

	public MoodSad(Date date){
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
		return "Sad";
	}
}
