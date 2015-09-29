package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by kstember on 9/29/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testHoldsStuff() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet); //fails originally b/c no add method
        assertSame(list.getMostRecentTweet(), tweet);
    }

    public void testHoldsManyThings() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertEquals(list.count(), 1);
        list.add(new NormalTweet("test"));
        assertEquals(list.count(), 2);
    }




    public void testGetTweets() {
        ArrayList<Tweet> tweets2 = new ArrayList<Tweet>();
        TweetList list = new TweetList();
        Tweet tweet1 = new NormalTweet("catScan");
        Tweet tweet2 = new NormalTweet("dogScan");
        list.add(tweet1);
        list.add(tweet2);
        tweets2.add(tweet1);
        tweets2.add(tweet2);
        tweets = list.getTweets();
        assertEquals(tweets, tweets2);
    }

    public void testRemoveTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("catScan");
        list.add(tweet);
        list.removeTweet(tweet);
        assertEquals(false, list.hasTweet(tweet));
    }
    public void testGetCount() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertEquals(list.count(), 1);
        list.add(new NormalTweet("test"));
        assertEquals(list.count(), 2);
    }
    public void testAddTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        assertEquals(false, list.addTweet(tweet));

       }


}