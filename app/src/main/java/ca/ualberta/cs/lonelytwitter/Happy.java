package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Happy extends Mood {
    public Happy(){
        this.date = new Date(0);
    }
    public Happy(Date date){
        this.date = date;
    }
    public String format(){
        return "I am happy! :)";
    }
}
