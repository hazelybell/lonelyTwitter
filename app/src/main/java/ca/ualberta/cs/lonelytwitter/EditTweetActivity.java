package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        String tweet= getIntent().getStringExtra("Tweet");
        TextView tweetText = (TextView) findViewById(R.id.textView);
        tweetText.setText(tweet);

    }
}
