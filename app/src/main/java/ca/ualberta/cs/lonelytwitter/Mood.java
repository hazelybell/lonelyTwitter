package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Mood {
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    Mood(){
        this.date = new Date();
    }

    Mood(Date date){
        this.date = date;
    }
}
