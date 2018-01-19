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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class LonelyTwitterActivity extends Activity {

    private static final String FILENAME = "file.sav";
    private EditText bodyText;
    private ListView oldTweetsList;
    /////////////
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    /////////////////

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        /////////////////
        spinner = (Spinner)findViewById(R.id.setMood);
        adapter = ArrayAdapter.createFromResource(this,R.array.mood_list,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
/*
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" selected",Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
        /////////////////
        bodyText = (EditText) findViewById(R.id.body);
        Button saveButton = (Button) findViewById(R.id.save);
        oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                setResult(RESULT_OK);
                String text = bodyText.getText().toString();

                String currentMood = new String();
                MoodHappy MoodHappy = new MoodHappy();
                MoodSad MoodSad = new MoodSad();


                String theMood = spinner.getSelectedItem().toString();
                int ishappy;
                ishappy = theMood.compareTo("happy");
                if (ishappy == 0){
                    currentMood=MoodHappy.getCurrentMood();
                }
                else{
                    currentMood=MoodSad.getCurrentMood();
                }

                String newtext = "mood: "+currentMood+" |"+text;




                NormalTweet newtweet = new NormalTweet(text);
                NormalTweet newtweet2 = new NormalTweet(text, new Date());

                ImportantTweet imptweet = new ImportantTweet("this is a important tweet");

                NormalTweet normtweet = new NormalTweet("this is a normal tweet");

                ArrayList<Tweet> alltweets = new ArrayList<Tweet>();
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




                saveInFile(newtext, new Date(System.currentTimeMillis()));
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