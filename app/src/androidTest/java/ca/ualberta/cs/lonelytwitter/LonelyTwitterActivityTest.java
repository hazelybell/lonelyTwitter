package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
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

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testEdit() {
        LonelyTwitterActivity main = (LonelyTwitterActivity) getActivity();
        Button save = main.getSaveButton();
        EditText bodyText = main.getBodyText();
        ListView list = main.getOldTweetsList();
        // add a item
        bodyText.setText("hamburger");
        save.performClick();
        Tweet tweet = (Tweet) list.getItemAtPosition(0);
        assertEquals("hamburger", tweet.getText());

        View firstItem = list.getChildAt(0);
        list.performItemClick(firstItem, 0, firstItem.getId());
    }
}