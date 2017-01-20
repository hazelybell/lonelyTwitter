package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


public class Tweet {
    private Date date;
    private String message;

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public Tweet(Date date, String message){
        this.date = date;
        this.message = message;
    }

    public Tweet(){
        super();
        this.date = new Date();
    }

}
