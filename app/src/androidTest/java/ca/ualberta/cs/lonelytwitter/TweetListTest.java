package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by makepeac on 9/29/16.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest(){
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet Tweet = new NormalTweet("adding Tweet");
        tweets.add(Tweet);
        assertTrue(tweets.hasTweet(Tweet));
    }

    public void testDelete(){
        TweetList list = new TweetList();
        Tweet Tweet = new NormalTweet("test");
        list.add(Tweet);
        list.delete(Tweet);
        assertFalse(list.hasTweet(Tweet));
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList(); //
        Tweet Tweet = new NormalTweet("test");
        tweets.add(Tweet);
        Tweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getMessage(), Tweet.getMessage());
    }

    public void testHasTweet(){
        TweetList list = new TweetList();
        Tweet Tweet = new NormalTweet("test");
        list.add(Tweet);
        assertTrue(list.hasTweet(Tweet));
    }
}
