package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;

public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }
    // JUnit test methods for adding tweet into TweetList
    public void testAddTweet() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("Added tweet");
        tweetList.addTweet(tweet);

        assertTrue(tweetList.hasTweet(tweet));
    }
    // JUnit test method for checking whether a tweet is in the TweetList
    public void testHasTweet() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("Hello");
        assertFalse(tweetList.hasTweet(tweet));

        tweetList.addTweet(tweet);

        assertTrue(tweetList.hasTweet(tweet));

    }
//    // JUnit test method for checking whether a tweet is in the TweetList
    public void testGetTweet() {

        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("get tweet check");

        tweetList.addTweet(tweet);
        Tweet retrievedTweet = tweetList.getTweet(0);
        assertEquals(retrievedTweet.getMessage(), tweet.getMessage());
        assertEquals(retrievedTweet.getDate(), tweet.getDate());

    }

    public void testDeleteTweet() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("one for delete");
        tweetList.addTweet(tweet);
        tweetList.delete(tweet);
        assertFalse(tweetList.hasTweet(tweet));
    }

    public void testGetTweets() {
        TweetList tweetList = new TweetList();
        Tweet tweet1 = new NormalTweet("tweet1");
        Tweet tweet2 = new NormalTweet("tweet2");
        Tweet tweet3 = new NormalTweet("tweet3");
        tweetList.addTweet(tweet1);
        tweetList.addTweet(tweet2);
        tweetList.addTweet(tweet3);
        ArrayList<Tweet> newTweetList = tweetList.getTweets();
        assertTrue(tweetList.getTweets() == newTweetList);


    }

    public void testGetCount() {
        TweetList tweetList = new TweetList();
        assertTrue(tweetList.getCount() == 0);
        Tweet tweet = new NormalTweet("Hello");
        tweetList.addTweet(tweet);
        assertTrue(tweetList.getCount() == 1);
    }

}
