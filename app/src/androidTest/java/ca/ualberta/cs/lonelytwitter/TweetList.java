package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 27/09/16.
 */

public class TweetList {
    List<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet){

        if (tweets.contains(tweet)){
            throw new IllegalArgumentException("Cannot add duplicates");
        }

        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int i){
        return tweets.get(i);
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }

    public List<Tweet> getTweets(){
        return tweets;
    }

    public int GetCount(){
        return tweets.size();
    }
}
