package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

//later changed to abstract as an example
public abstract class Tweet implements Tweetable {

    private Date date;
    private String message;
    private static final Integer MAX_CHARS = 140;

    Tweet() {
        this.date = new Date();
        this.message = "I am default message";
    }

    Tweet(String message) {
        // this is overloading
        this.date = new Date();
        this.message = message; //Tweet my Tweet = new Tweet("Blaurgh");
    }

    // getters and setters
    public Date getDate(){return this.date;}

    public String getMessage(){return this.message;}

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() <= this.MAX_CHARS) {
            this.message = message;
        } else {
            throw new TweetTooLongException();
        }
    }

    public abstract Boolean isImportant();

    public String toString(){
        return this.getMessage();
    }
}