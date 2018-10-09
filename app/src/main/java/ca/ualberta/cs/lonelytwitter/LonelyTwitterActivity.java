/**
 * LonelyTwitterActivity runs the main application activity
 *
 * @author Joshua Charles Campbell, Shawna Dawson
 * @version 2.3
 */

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

	ArrayList<Tweet> tweetList;
	ArrayAdapter<Tweet> adapter;

	/**
	 * Called when the activity is first created.
	 * @param savedInstanceState
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			/**
			 * Adds a normal tweet to the list of tweets and updates the view
			 * @param v
			 */
			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);

				saveInFile();
				adapter.notifyDataSetChanged();

			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {

			/**
			 * Clears the tweet list and updates the view
			 * @param v
			 */
			public void onClick(View v) {
				tweetList.clear();

				saveInFile();
				adapter.notifyDataSetChanged();

			}
		});
	}


	/**
	 * Loads previous tweets from file on app start
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList); // takes list view and binds to data
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Loads previous tweets from disc
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson(); //library to save objects
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();

			tweetList = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Saves tweets to disc
	 */
	private void saveInFile() {
		//ArrayList<String> tweets = new ArrayList<>();
		//ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
		//ArrayList<Mood> moodList = new ArrayList<Mood>();
		//NormalTweet myTweet = new NormalTweet();
		//tweetList.add(myTweet);
		//Happy myMood = new Happy();
		//moodList.add(myMood);
		try {

			NormalTweet aTweet;
			aTweet = new NormalTweet("");
			aTweet.setMessage("I am a short message.");

			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE); //MODE_PRIVATE = can only be used by this application

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();


			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TweetTooLongException e) {
			//
			e.printStackTrace();
		}
	}
}