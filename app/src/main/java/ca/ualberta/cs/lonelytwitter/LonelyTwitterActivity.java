/*
 * CMPUT 301
 *
 * Version 1.3
 *
 * 1/22/19 6:40 PM
 *
 * Copyright (c) 2019. All rights reserved.
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.firebase.client.Firebase;

import static android.content.ContentValues.TAG;

/**
 * Views the recent tweets and allows tweeting
 */
public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayAdapter<Tweet> adapter;
	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();

	
	/** Called when the activity is first created. Creates the body of the page */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Firebase.setAndroidContext(this);
		final Firebase ref = new Firebase("https://lonelytwitter-66293.firebaseio.com/");
		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet tweet = new Tweet(text);
				tweetList.add(tweet);
				// saveInFile(text, new Date(System.currentTimeMillis()));
				Firebase tweetchild = ref.child(tweet.getUnique().toString());
				tweetchild.setValue(tweet);
				saveInFile();
				adapter.notifyDataSetChanged();
				//finish();
			}
		});
		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				tweetList.clear();
				saveInFile();
				adapter.notifyDataSetChanged();
			}
		});
		ref.addValueEventListener(new ValueEventListener() {
			public void onDataChange(DataSnapshot dataSnapshot) {
				for (DataSnapshot d: dataSnapshot.getChildren()) {
					Tweet tweet = d.getValue(Tweet.class);
					if (tweet.getMessage().startsWith("/U")) {
						if(!tweet.getMessage().equals(tweet.getMessage().toUpperCase())) {
							tweet.setMessage(tweet.getMessage().toUpperCase());
							Firebase tweetchild = ref.child(tweet.getUnique().toString());
							tweetchild.setValue(tweet);
						}
					} else if (tweet.getMessage().startsWith("/L")) {
						if(!tweet.getMessage().equals(tweet.getMessage().toLowerCase())) {
							tweet.setMessage(tweet.getMessage().toLowerCase());
							Firebase tweetchild = ref.child(tweet.getUnique().toString());
							tweetchild.setValue(tweet);
						}
					}
					Log.d(TAG, "Tweet " + tweet.getUnique() + ": " + tweet.getMessage());
				}
			}

			public void onCancelled(FirebaseError firebaseError) {
				System.out.println("Firebase read failed");
			}
		});
	}

	@Override
	/**
	 * Called on Start
	 */
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Load the tweetList from the file
	 */
	private void loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();

			Type listType = new TypeToken<ArrayList<Tweet>>(){}.getType();
			tweetList  = gson.fromJson(in,listType);


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return tweets.toArray(new String[tweets.size()]);
	}

	/**
	 * Save the file with the tweetList
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			//FileWriter out = new FileWriter(FILENAME);
			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<Tweet>>(){}.getType();
			gson.toJson(tweetList,listType,out);
			System.out.print("Got here successfully");
			//fos.write(new String(date.toString() + " | " + text).getBytes());
			out.close();
			//fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addTweet(Tweet tweet){
		for(int i=0;i<tweetList.size();i++) {
			if (tweet.equals(tweetList.get(i))) {
				throw new IllegalArgumentException();
			}
		}
		tweetList.add(tweet);
	}
	public ArrayList<Tweet> getTweets(){
		return tweetList;
	}

	public boolean hasTweet(){
		for (int i = 0; i < tweetList.size()-1; i++){
			for (int j = i; j<tweetList.size(); j++){
				if (tweetList.get(i).equals(tweetList.get(j))){
					return true;
				}
			}
		}
		return false;
	}

	public int getCount(){
		return tweetList.size();
	}
}