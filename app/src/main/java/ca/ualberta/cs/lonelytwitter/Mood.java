package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Mood {
    private String mood;
    private Date date;

    public Mood(String current_mood, Date date){
        this.mood = mood;
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
