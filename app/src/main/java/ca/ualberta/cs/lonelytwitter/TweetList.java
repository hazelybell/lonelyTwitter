package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);

    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }
    public Tweet getTweet(int index) {
        return tweets.get(index);

    }
    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }
    public ArrayList<Tweet> getTweets() {
//        Comparator<Tweet> tweetComparator = new Comparator<Tweet>() {
//            @Override
//            public int compare(Tweet lhs, Tweet rhs) {
//                return lhs.getDate().compareTo(rhs.getDate());
//            }
//        }
        return tweets;
    }

    public int getCount() {
        return tweets.size();
    }



}
