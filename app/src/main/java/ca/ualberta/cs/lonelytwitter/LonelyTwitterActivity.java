package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;


	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);

		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);


//		Tweet tweet = null;
//		try {
//			tweet = new NormalTweet("a");
//			Tweet tweet2 = new NormalTweet(new Date(),"b");
//			Tweet iptTweet = new ImportantTweet("important");
//			iptTweet.getDate();
//
//
//			NormalTweet nt = new NormalTweet("a message");
//			ArrayList<Tweet> arrayList = new ArrayList<Tweet>();
//			arrayList.add(tweet);
//			arrayList.add(tweet2);
//			arrayList.add(iptTweet);
//		} catch (TweetTooLongException e) {
//			e.printStackTrace();
//		}
//
//		try {
//			tweet.setMessage("message for first tweet");
//		} catch (TweetTooLongException e) {
//			e.printStackTrace();
//		}


		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				tweetList.clear();
				deleteFile(FILENAME);
				adapter.notifyDataSetChanged();
			}
		});



		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet tweet = new NormalTweet(text);

				tweetList.add(tweet);
				adapter.notifyDataSetChanged();

				//saveInFile(text, new Date(System.currentTimeMillis()));
				saveInFile();
				//finish();
			}
		});
	}



	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//String[] tweets = loadFromFile();

		loadFromFile();

		//tweetList = new ArrayList<Tweet>();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {
		//ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));



			Gson gson = new Gson();
			//new TypeToken<ArrayList<Tweet>>(){}.getType();
			// get from stack overflow
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in,listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		//return tweets.toArray(new String[tweets.size()]);
	}
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);

			BufferedWriter out = new BufferedWriter((new OutputStreamWriter(fos)));
			//fos.write(new String(date.toString() + " | " + text)
			//		.getBytes());

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();


			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Handle the Exception properly later
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}