package ca.ualberta.cs.lonelytwitter;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Created by joshua2 on 9/29/15.
 */
public class TweetList {
    private Tweet mostRecentTweet;
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) {
        mostRecentTweet = tweet;
        tweets.add(tweet);
    }

    public Tweet getMostRecentTweet() {
        return mostRecentTweet;
    }

    public int count() {
        return tweets.size();
    }
}
