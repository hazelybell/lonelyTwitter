package ca.ualberta.cs.lonelytwitter.test;

import java.io.FileNotFoundException;
import java.util.Date;

import ca.ualberta.cs.lonelytwitter.LonelyTweet;
import ca.ualberta.cs.lonelytwitter.LonelyTweetDB;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

public class testLonelyTweetDB extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
		
	public testLonelyTweetDB() {
		super(LonelyTwitterActivity.class);
	}

	public void testDBLoad() {
		LonelyTweetDB ltdb = new LonelyTweetDB(this.getActivity());
		ltdb.load();
	}
	
	public void testDBAddSaveLoad() {
		LonelyTweetDB ltdb = new LonelyTweetDB(this.getActivity());
		ltdb.add(new LonelyTweet(new Date(System.currentTimeMillis()), "test tweet"));
		ltdb.save();
		ltdb.load();
		assertEquals(ltdb.getLts().get(ltdb.getLts().size()-1).getTweetBody(), "test tweet");
	}
	
	public void testDBClear() {
		LonelyTweetDB ltdb = new LonelyTweetDB(this.getActivity());
		ltdb.clear();
		ltdb.load();
		assertEquals(ltdb.getLts().size(), 0);
	}

}
