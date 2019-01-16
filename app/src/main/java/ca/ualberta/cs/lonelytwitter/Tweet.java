package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Tweet {
    private String message;
    private Date date;
    public Tweet(String message){
        this.message = message;
    }
    public void setMessage (String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
