package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by sboulet on 9/29/15.
 */

public class TweetList {
    private Tweet mostRecentTweet;
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) {
        if (this.hasTweet(tweet)) {
            throw new IllegalArgumentException("you've already tweeted this!");
        }
        else {
            mostRecentTweet = tweet;
            tweets.add(tweet);
        }
    }

    public Tweet getMostRecentTweet() {
        return mostRecentTweet;
    }

    public Boolean hasTweet(Tweet tweet) {
        if (tweets.contains(tweet)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void removeTweet(Tweet tweet) {
        if (this.hasTweet(tweet)) {
            tweets.remove(tweet);
        }
        else {

        }
    }

    public int getCount() {
        return tweets.size();
    }
}
