package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by kstember on 9/29/15.
 */
public class TweetList {
    private Tweet mostRecentTweet;
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet){
        //mostRecentTweet = tweet;
        tweets.add(tweet);
    }
    public Tweet getMostRecentTweet(){
        return mostRecentTweet;
    }
    public int count() {
        return tweets.size();
    }
    //-- should return true if there is a tweet that equals() another tweet
    public boolean hasTweet(Tweet tweet){
        if (tweets.contains(tweet)) {
            return true;
        }
        return false;
    }

    //-- should return a list of tweets in chronological order
    public ArrayList<Tweet> getTweets() {
        return tweets;
    }


    //-- should remove a tweet
   public void removeTweet(Tweet tweet){
    tweets.remove(tweet);
   }

    //-- should accurately count up the tweets
   public int getCount(){
    return tweets.size();
   }

    //should throw an IllegalArgumentException when one tries to add a duplicate tweet
    public boolean addTweet(Tweet tweet){
        if (tweets.contains(tweet) == true )
         {
            if (tweets.contains(tweet)) {
                throw new IllegalArgumentException();
            }
        } else
            tweets.add(tweet);
            return false;

    }
}
