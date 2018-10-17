package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;

public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    // JUnit test method for adding tweet into TweetList
    public void testAddTweet() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("added tweet");
        tweetList.add(tweet);

        assertTrue(tweetList.hasTweet(tweet));
    }

    // JUnit test method for checking whether a tweet is in the TweetList
    public void testHasTweet() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        assertFalse(tweetList.hasTweet(tweet));

        tweetList.add(tweet);

        assertTrue(tweetList.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("get tweet check");

        tweetList.add(tweet);
        Tweet retrievedTweet = tweetList.getTweet(0);

        assertEquals(retrievedTweet.getMessage(), tweet.getMessage());
        assertEquals(retrievedTweet.getDate(), tweet.getDate());
    }

    public void testDeleteTweet() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("one for delete");

        tweetList.add(tweet);
        tweetList.delete(tweet);

        assertFalse(tweetList.hasTweet(tweet));
    }

    public void testTweetCount() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("a tweet");

        assertEquals(tweetList.getCount(), 0);

        tweetList.add(tweet);

        assertEquals(tweetList.getCount(), 1);
    }

    public void testGetTweets() {
        TweetList tweetList = new TweetList();
        Tweet tweet1 = new NormalTweet("1");
        Tweet tweet2 = new NormalTweet("2");
        ArrayList list = new ArrayList();

        tweetList.add(tweet1);
        tweetList.add(tweet2);
        list.add(tweet1);
        list.add(tweet2);

        assertEquals(tweetList, list);


    }

    public void testAddException() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("test");

        tweetList.add(tweet);
        assertTrue(tweetList.hasTweet(tweet));
    }


}
