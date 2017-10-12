package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Rohan on 10/11/2017.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        tweets.addTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testDelete() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Adding some tweet");
        tweets.addTweet(tweet);
        tweets.deleteTweet(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }
    public void testHasTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("TEST");
        list.addTweet(tweet);
        try {
            list.addTweet(tweet);
            assertTrue(Boolean.FALSE);
        } catch (IllegalArgumentException e) {

        }
        assertTrue(list.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.addTweet(tweet);
        Tweet returnedTweet = list.getTweet(0);
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
    }

    public void testgetTweets(){
        TweetList list = new TweetList();
        Date d1 = new Date(14);
        Date d2 = new Date(25);
        Date d3 = new Date(35);
        Tweet tweet = new NormalTweet("test", d2);
        Tweet tweet2 = new NormalTweet("test2", d1);
        Tweet tweet3 = new NormalTweet("test3", d3);
        list.addTweet(tweet);
        list.addTweet(tweet2);
        list.addTweet(tweet3);
        List<Tweet> returnedTweets = list.getTweets();
        for (int i = 0; i < 2; i++) {
            if (returnedTweets.get(i).getDate().compareTo(returnedTweets.get(i+1).getDate()) > 0) {
                assertTrue(Boolean.FALSE);
            }
        }
    }

    public void testgetCount() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        Tweet tweet2 = new NormalTweet("test3");
        list.addTweet(tweet);
        list.addTweet(tweet2);
        assertEquals(2, list.getCount());
    }



}
