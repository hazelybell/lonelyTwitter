package ca.ualberta.cs.lonelytwitter.test;

import java.util.Date;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TweetSetModel;

public class TweetSetModelAddTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public TweetSetModelAddTest() {
		super(LonelyTwitterActivity.class);
		
	}
	
	public void testAdd(){
		TweetSetModel tsm = new TweetSetModel();
		Date dt = new Date(System.currentTimeMillis());
		NormalTweetModel ntm = new NormalTweetModel("test", dt);
		
		tsm.addTweet(ntm);
		try{
			tsm.addTweet(ntm);
			fail();
		}
		catch (IllegalArgumentException e){
			
		}
		
	}
	

}
