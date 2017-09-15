package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Mood{
	private Date date;

	public Mood(){
		date = new Date(1000000);
	}

	public Mood(Date date){
		this.date = date;
	}

	public abstract Date getDate();

	public abstract void setDate(Date date);

	public abstract String toString();
}
