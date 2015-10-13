package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private ListView list;
    private EditText bodyText;
    private Button save;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testEdit() {
        LonelyTwitterActivity main = (LonelyTwitterActivity) getActivity();
        save = main.getSaveButton();
        bodyText = main.getBodyText();
        list = main.getOldTweetsList();
        // add a item
        main.runOnUiThread(new Runnable() {
            public void run() {
                bodyText.setText("hamburger");
                save.performClick();
            }
        });
        getInstrumentation().waitForIdleSync();
        Tweet tweet = (Tweet) list.getItemAtPosition(0);
        assertEquals("hamburger", tweet.getText());

        main.runOnUiThread(new Runnable() {
            public void run() {
                View firstItem = list.getChildAt(0);
                list.performItemClick(firstItem, 0, firstItem.getId());
            }
        });

        // from https://developer.android.com/training/activity-testing/activity-functional-testing.html 2015-10-13
        Instrumentation.ActivityMonitor receiverActivityMonitor = getInstrumentation().addMonitor(EditTweetActivity.class.getName(), null, false);
        getInstrumentation().waitForIdleSync();
        EditTweetActivity receiverActivity = (EditTweetActivity) receiverActivityMonitor.waitForActivityWithTimeout(1000);
        assertNotNull("ReceiverActivity is null", receiverActivity);
        assertEquals("Monitor for ReceiverActivity has not been called", 1, receiverActivityMonitor.getHits());
        assertEquals("Activity is of wrong type", EditTweetActivity.class, receiverActivity.getClass());
        getInstrumentation().removeMonitor(receiverActivityMonitor);
    }
}