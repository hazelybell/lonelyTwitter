package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TweetList {
    private ArrayList<Tweet> Tweets = new ArrayList<Tweet>();

    public TweetList() {

    }

    public Tweet getTweet(int index){
        return Tweets.get(index);
    }

    public boolean hasTweet(Tweet Tweet){
        return Tweets.contains(Tweet);
    }

    public void add(Tweet Tweet) {
        Tweets.add(Tweet);
    }

    public void delete(Tweet Tweet) {
        Tweets.remove(Tweet);
    }
}
