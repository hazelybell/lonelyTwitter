package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by fady on 16/02/17.
 */

public class TweetList {
    private ArrayList<NormalTweet> tweets = new ArrayList<NormalTweet>();

    public void add(NormalTweet tweet) throws IllegalArgumentException {
        tweets.add(tweet);
        for(int i = 0; i < tweets.size(); i++){
            NormalTweet temp = tweets.get(i);
            if(temp == tweet) throw new IllegalArgumentException("There is a duplicate tweet");
        }

    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public NormalTweet getTweet(int index) {
        return tweets.get(index);
    }

    public ArrayList<NormalTweet> getTweets() {
        Collections.sort(tweets, new Comparator<NormalTweet>() {
            public int compare(NormalTweet normalTweet, NormalTweet t1) {
                return normalTweet.getDate().compareTo(t1.getDate());
            }
        });
        return tweets;
    }

    public void delete(NormalTweet tweet) {
        tweets.remove(tweet);
    }

    public int getCount() {
        return tweets.size();
    }
}
