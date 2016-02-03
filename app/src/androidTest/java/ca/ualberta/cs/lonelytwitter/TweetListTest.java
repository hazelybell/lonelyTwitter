package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.io.IOException;
import java.util.Date;

/**
 * Created by baydala on 1/26/16.
 */
//NOTE: simplescreenrecorder on the lab computers
//this is just testing data classes
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest(){
        //so we have access to everything else
        super(LonelyTwitterActivity.class);
    }

    // methods that don't start with "test" will be ignored
    // right click and hit "run"; can run methods or the whole class

    //they don't run in order so don't depend on that
    //every single test should be self contained
    public void testAdd() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.add(tweet);

        assertTrue(tweets.hasTweet(tweet));

    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        //if the tweets already in there before we added it, this test should fail
        assertFalse(tweets.hasTweet(tweet));

        tweets.add(tweet);
        tweets.hasTweet(tweet);

        assertTrue(tweets.hasTweet(tweet));
    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        tweets.add(tweet);
        tweets.delete(tweet);

        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hey");

        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        // could also check that the objects themselves are exactly equal
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
        assertEquals(returnedTweet.getDate(), tweet.getDate());

    }

    //http://stackoverflow.com/questions/3478222/java-how-to-do-pythons-try-except-else
    public void testAddTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hey");
        tweets.add(tweet);
        Boolean success = true;
        try {
            tweets.addTweet(tweet);
        } catch (IllegalArgumentException e) {
            success = false;
        }
        if (success) {
            fail();
        }
    }

    public void testGetTweets() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hey");
        Tweet tweet2 = new NormalTweet("hello");
        Tweet tweet3 = new NormalTweet("hi");
        tweets.add(tweet);
        tweets.add(tweet2);
        tweets.add(tweet3);

        String[] expected = {"hey", "hello", "hi"};
        assertEquals(expected, tweets.getTweets());



    }

}
