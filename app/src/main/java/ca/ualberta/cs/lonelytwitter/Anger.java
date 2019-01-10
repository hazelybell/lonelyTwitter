package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Anger extends Mood {
    public Anger(){
        this.date = new Date(0);
    }
    public Anger(Date date){
        this.date = date;
    }
    public String format(){
        return "I am angry! :(";
    }
}
