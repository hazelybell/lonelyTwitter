package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	
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


                NormalTweet newtweet = new NormalTweet(text);
                NormalTweet newtweet2 = new NormalTweet(text, new Date());

                ImportantTweet imptweet = new ImportantTweet("this is a important tweet");

                NormalTweet normtweet = new NormalTweet("this is a normal tweet");

                ArrayList<Tweet2> alltweets = new ArrayList<Tweet2>();
                alltweets.add(newtweet);
                alltweets.add(newtweet2);
                alltweets.add(imptweet);
                alltweets.add(normtweet);

                // write it to the log , just to check outputs
                //Log.v("Test", "Log error 1");


                try{
                    newtweet.setMessage("Message too long");

                }
                catch(Exception e){
                    // Show a error message
                    e.printStackTrace();
                }








				////////////////////////////
				Mood1 newmood = new Mood1(text);
				Mood1 newmood2 = new Mood1(text, new Date());

				Mood2 secondmood = new Mood2("this is mood 2");
				Mood1 firstmood = new Mood1("this is mood 1");

				ArrayList<Tweet> allmoods = new ArrayList<Tweet>();
				allmoods.add(newmood);
				allmoods.add(newmood2);
				allmoods.add(secondmood);
				allmoods.add(firstmood);

				// write it to the log, just to check outputs
				//Log.v("Test", "Log error 1");

				try{
					newmood.setMood("Mood too long");
				}
				catch(Exception e){
					// show a error message
					e.printStackTrace();
				}

                ////////////////////////////




				saveInFile(text, new Date(System.currentTimeMillis()));
				finish();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		String[] tweets = loadFromFile();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private String[] loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets.toArray(new String[tweets.size()]);
	}
	
	private void saveInFile(String text, Date date) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			fos.write(new String(date.toString() + " | " + text)
					.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}