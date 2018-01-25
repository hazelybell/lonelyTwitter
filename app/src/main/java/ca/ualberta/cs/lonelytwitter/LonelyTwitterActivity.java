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
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "newfile.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetlist;
	private ArrayAdapter<Tweet> adapter;
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

				Tweet newtweet = new NormalTweet(text);
				tweetlist.add(newtweet);
				adapter.notifyDataSetChanged();

				saveInFile();
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
        loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweetlist);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			/*Taken from https://stackoverflow.com/questions/12384064/gson-convert-from-js
            24-02-2018*/
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetlist = gson.fromJson(in,listType);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweetlist = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			Gson gson = new Gson();
			gson.toJson(tweetlist, out);
			out.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void onDestroy(){
		super.onDestroy();
		Log.i("In Destroy meethod", "The app is closing");
	}
}