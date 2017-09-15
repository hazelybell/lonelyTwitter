package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class MoodSad extends Mood{

	public MoodSad(){
		super();
	}

	public MoodSad(Date date){
		super(date);
	}

	@Override
	public String toString(){
		return "Sad";
	}
}
