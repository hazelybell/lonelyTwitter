package ca.ualberta.cs.lonelytwitter;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LonelyTwitterActivityTest {
    @Test
    public void addTest(){
        LonelyTwitterActivity holder = new LonelyTwitterActivity();
        Tweet temp1 = new Tweet("HI");
        Tweet temp2 = new Tweet("HI");
        try{
            holder.addTweet(temp1);
        } catch(IllegalArgumentException e){
            assertEquals(1,-1);
        }
        try{
            holder.addTweet(temp1);
            assertEquals(1,-1);
        } catch(IllegalArgumentException e){
        }
        try {
            holder.addTweet(temp2);
        } catch (IllegalArgumentException e){
            assertEquals(1,-1);
        }
    }

    @Test
    public void getTweetsTest(){
        LonelyTwitterActivity holder = new LonelyTwitterActivity();
        Tweet temp1 = new Tweet("ZI");
        Tweet temp2 = new Tweet("HI");
        Tweet temp3 = new Tweet("AI");
        Tweet temp4 = new Tweet("AI");
        ArrayList<Tweet> expected = new ArrayList<Tweet>();
        ArrayList<Tweet> obtained = holder.getTweets();
        assertEquals(expected.toArray(), obtained.toArray());
        holder.addTweet(temp3);
        assertNotEquals(expected.toArray(), holder.getTweets().toArray());
        expected.add(temp3);
        assertEquals(expected.toArray(), holder.getTweets().toArray());
        holder.addTweet(temp1);
        assertNotEquals(expected.toArray(), holder.getTweets().toArray());
        expected.add(temp1);
        assertEquals(expected.toArray(), holder.getTweets().toArray());
        holder.addTweet(temp4);
        assertNotEquals(expected.toArray(), holder.getTweets().toArray());
        expected.add(temp4);
        assertEquals(expected.toArray(), holder.getTweets().toArray());
        holder.addTweet(temp2);
        assertNotEquals(expected.toArray(), holder.getTweets().toArray());
        expected.add(temp2);
        assertEquals(expected.toArray(), holder.getTweets().toArray());
    }

    @Test
    public void hasTest(){

    }

    @Test
    public void getCountTest(){
        
    }
}
