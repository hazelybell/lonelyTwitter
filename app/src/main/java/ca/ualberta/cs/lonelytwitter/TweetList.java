package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Rohan on 10/11/2017.
 */

public class TweetList implements Comparator<Tweet> {

    private List<Tweet> mTweetList;

    public TweetList() {
        mTweetList = new ArrayList<Tweet>();
    }

    public void addTweet(Tweet tweet) {
        if (mTweetList.contains(tweet)) {
            throw new IllegalArgumentException();
        } else {
            mTweetList.add(tweet);
        }

    }

    public boolean hasTweet(Tweet tweet) {
        return mTweetList.contains(tweet);
    }

    public void deleteTweet(Tweet tweet) {
        mTweetList.remove(tweet);
    }

    public int compare(Tweet t1, Tweet t2) {
        return t1.getDate().compareTo(t2.getDate());
    }

    public int getCount() {
        return mTweetList.size();
    }

    public Tweet getTweet(int index) {
        return mTweetList.get(index);
    }

    public ArrayList<Tweet> getTweets() {
        ArrayList<Tweet> mChronologicalTweets = new ArrayList<Tweet>();
        mChronologicalTweets.addAll(mTweetList);
        Collections.sort(mChronologicalTweets, this);
        return mChronologicalTweets;
    }

}
