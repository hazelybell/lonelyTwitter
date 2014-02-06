package ca.ualberta.cs.lonelytwitter.test;

import java.util.Date;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;

public class ImportantTweetEqualsTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public ImportantTweetEqualsTest() {
		super(LonelyTwitterActivity.class);
	}

	public void testEquals(){
		Date dt = new Date(System.currentTimeMillis());
		ImportantTweetModel itm = new ImportantTweetModel("test", dt);
		NormalTweetModel ntm = new NormalTweetModel("test", dt);
		boolean a = itm.equals(ntm);
		assertEquals("Should pass now.", false, a);

	}
}
