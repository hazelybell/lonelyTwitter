package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<NormalTweet> tweets = new ArrayList<NormalTweet>();
    ArrayAdapter<NormalTweet> adapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
                tweets.add(new NormalTweet(text));
				saveInFile();
                adapter.notifyDataSetChanged();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
        adapter = new ArrayAdapter<NormalTweet>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
	}

	private void loadFromFile() {
        try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            //https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
            Type arraylistType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
            Gson gson = new Gson();
            tweets = gson.fromJson(in, arraylistType);

		} catch (FileNotFoundException e) {
			tweets = new ArrayList<NormalTweet>();
		} catch (IOException e) {
            throw new RuntimeException(e);
		}
    }

	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					0);
            BufferedWriter out =  new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(tweets, out);
			out.flush();
            fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
            throw new RuntimeException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
            throw new RuntimeException(e);
		}
	}
}