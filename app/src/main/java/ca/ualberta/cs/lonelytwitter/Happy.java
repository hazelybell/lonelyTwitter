package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Happy extends Mood {
    // Constructors, default day is epoch time
    public Happy(){
        this.date = new Date(0);
    }
    public Happy(Date date){
        this.date = date;
    }
    // Do the format. May need to add a String input, since otherwise this is no better than an emoticon
    public String format(){
        return "I am happy! :)";
    }
}
