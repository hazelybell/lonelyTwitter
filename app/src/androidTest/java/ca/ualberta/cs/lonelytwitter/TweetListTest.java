package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import java.util.List;

/**
 * Created by john on 27/09/16.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){

        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Hello World");

        assertFalse(list.hasTweet(tweet));
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));

    }

    public void testGetTweet(){

        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello");
        Tweet b = new NormalTweet("hi");

        list.add(a);
        list.add(b);

        assertEquals(a, list.getTweet(0));
        assertEquals(b, list.getTweet(1));
    }

    public void testDeleteTweet(){
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        list.add(a);

        list.delete(a);
        assertFalse(list.hasTweet(a));
    }


    public void testAddDuplicates(){
        try{
            TweetList list = new TweetList();
            Tweet a = new NormalTweet("Hello");

            list.add(a);
            list.add(a);

            assertTrue(false);
        }catch(IllegalArgumentException e){
            assertTrue(true);
        }
    }

    public void testChronologicallyOrder() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("hello");
        Tweet b = new NormalTweet("hello1");
        Tweet c = new NormalTweet("hello2");

        list.add(a);
        list.add(b);
        list.add(c);

        List<Tweet> testList = list.getTweets();

        assertEquals(testList.get(0), a);
        assertEquals(testList.get(1), b);
        assertEquals(testList.get(2), c);
    }

    public void testGetCount(){
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("hello");
        Tweet b = new NormalTweet("hello1");
        Tweet c = new NormalTweet("hello2");

        list.add(a);
        list.add(b);
        list.add(c);

        assertEquals(3, list.GetCount());

    }
}
