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

/**
 * This class is the main view of the project <br/> In this class, user interaction and file manipulation
 * is performed.
 * All the files are in the form of "json" files that are stored in Emulator accessible from
 * <pre>
 *     pres-formatted text: <br/>
 *     File explorer -> data -> data -> ca.ualberta.cs.lonelytwitter -> files -> file.sav
 * </pre>
 * <code> begin <br>
 * some pseduo code <br>
 * end </code>
 * The file name is indicated in the &nbsp &nbsp &nbsp FILENAME constant
 * <ul>
 *     <li>item 1</li>
 *     <li>item 2</li>
 * </ul>
 *
 * <ol>
 *     <li>item 1</li>
 *     <li>item 2</li>
 * </ol>
 *
 *
 * @author fady
 * @version 1.0
 * @see  Tweet
 * @since 0.5
 */

public class LonelyTwitterActivity extends Activity {
    /**
     * This file that all the tweets are saved there. the format of the ifle is JSON
     * @see #loadFromFile()
     * @see #saveInFile()
     */


	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();

				saveInFile();

			}
		});

		clearButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				deleteFile(FILENAME);
				tweetList.clear();
				adapter.notifyDataSetChanged();
			}
		});

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		loadFromFile();


		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

    /**
     * Loads file from
     * @throws TweetTooLongException if the tweet is too long
     * @exception FileNotFoundException if the file is not created first
     */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();
			//Taken from HTTP://www.stackoverflow.com/questions/....
			//2017-01-24
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();
			fos.close();


		} catch (FileNotFoundException e) {
			// TODO Handle the exception properly later
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}