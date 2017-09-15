package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class MoodHappy extends Mood{

	public MoodHappy(){
		super();
	}

	public MoodHappy(Date date){
		super(date);
	}

	@Override
	public String toString(){
		return "Happy";
	}
}
