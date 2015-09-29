package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by joshua2 on 9/28/15.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public Boolean contains(Tweet tweet) {
        return tweets.contains(tweet);
    }
}
