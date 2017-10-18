package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public TweetList(){

    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }
}
