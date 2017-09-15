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

	public Date getDate(){ return date; }

	public void setDate(Date date){ this.date = date; }

	public abstract String toString();
}
