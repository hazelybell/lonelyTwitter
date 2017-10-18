package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EditTweetActivity extends Activity {

    private TextView message;
    private TextView date;
    private Tweet tweet;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        // Initialize the view objects
        message = (TextView) findViewById(R.id.message);
        date = (TextView) findViewById(R.id.date);

        // Get the passed tweet
        extras = getIntent().getExtras();
        tweet = (Tweet) extras.getSerializable("tweet");

        // Set views to tweet elements
        message.setText(tweet.getMessage());
        date.setText(tweet.getDate().toString());
    }
}
