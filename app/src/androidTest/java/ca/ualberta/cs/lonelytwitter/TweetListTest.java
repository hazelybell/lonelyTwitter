package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState); // view
		setContentView(R.layout.main);      // view

		bodyText = (EditText) findViewById(R.id.body);               // view
		Button saveButton = (Button) findViewById(R.id.save);        // view
      //Button clearButton = (Button) findViewById(R.id.clear);      // view
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList); // view

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
                String text = bodyText.getText().toString();  // controller - changes stuff for user
				tweets.add(new NormalTweet(text));            // controller - changes stuff for user
				adapter.notifyDataSetChanged();               // view -- doesn't notify of any changes
                saveInFile();                                 // model - changes stuff on disk, not for user
			}
		});

      /*clearButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
               // tweets.deleteFile(FILENAME);
                tweets.clear();                              // controller
                adapter.notifyDataSetChanged();              // view
                saveInFile();                                // model

            }
        });
*/

	}

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();                                                       // model
        loadFromFile();                                                        // model
        adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);   // model
        oldTweetsList.setAdapter(adapter);                                     // model
    }

    private void loadFromFile() {  // entire function is model, only adjusting things on disk
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            // Taken from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 2015-09-22
            Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
            tweets = gson.fromJson(in, listType);
        } catch (FileNotFoundException e) {
            tweets = new ArrayList<Tweet>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveInFile() { // entire function is model
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(tweets, writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
