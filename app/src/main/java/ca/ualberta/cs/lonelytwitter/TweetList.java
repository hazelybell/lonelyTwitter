package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by anju on 30/09/15.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet(Tweet tweet){
        if (tweets.contains(tweet)){
            throw new IllegalArgumentException("NO WAY JOSE!");
        }
        else {
            tweets.add(tweet);
        }

    }

    public void deleteTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    public Boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public int tweetCount(){
        return  tweets.size();
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public ArrayList<Tweet> getTweets(){
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet lhs, Tweet rhs) {
                return lhs.date.compareTo(rhs.date);
            }
        });
        return tweets;
    }

}
