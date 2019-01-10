package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Anger extends Mood {
    // Standard constructors for the class
    public Anger(){
        this.date = new Date(0);
    }
    public Anger(Date date){
        this.date = date;
    }
    // Do the format. May need to add a String input, since otherwise this is no better than an emoticon
    public String format(){
        return "I am angry! :(";
    }
}
