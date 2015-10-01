package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * Created by anju on 30/09/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2{
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }
    public void testDeleteTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("anju");
        tweetList.addTweet(tweet);
        tweetList.deleteTweet(tweet);
        assertFalse(tweetList.hasTweet(tweet));
    }

    public void testAddTweetError(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("anju");
        tweetList.addTweet(tweet);
        try{
            tweetList.addTweet(tweet);
        }catch (Exception e){
            assertTrue(e instanceof IllegalArgumentException);
        }
    }

    public void testAddTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("anju");
        tweetList.addTweet(tweet);
    }

    //the test below and the test above are coupled together, one fails, so does the other
    public void testHasTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("anju");
        assertFalse(tweetList.hasTweet(tweet));
        tweetList.addTweet(tweet);
        assertTrue(tweetList.hasTweet(tweet));
    }
    public void testTweetCount(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("anju");
        Tweet tweet2 = new NormalTweet("eappen");
        tweetList.addTweet(tweet);
        tweetList.addTweet(tweet2);
        assertEquals(2, tweetList.tweetCount());
    }

    public void testGetTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("anju");
        tweetList.addTweet(tweet);
        Tweet returned = tweetList.getTweet(0);
        assertTrue(tweet.date.equals(returned.date) &&
                    tweet.getText().equals(returned.getText()));

    }

    public void testGetTweets(){
        TweetList tweetList = new TweetList();
        Date now = new Date();
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException ie){
            return;
        }

        Date later =  new Date();
        Tweet tweet2 =  new NormalTweet("eappen", later);
        Tweet tweet = new NormalTweet("anju", now);
        tweetList.addTweet(tweet2);
        tweetList.addTweet(tweet);

        ArrayList returnedList = tweetList.getTweets();
        ArrayList expected = new ArrayList();
        expected.add(tweet);
        expected.add(tweet2);
        assertEquals(returnedList.toArray(), expected);
    }




}