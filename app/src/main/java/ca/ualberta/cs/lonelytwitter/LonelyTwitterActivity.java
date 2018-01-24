package ca.ualberta.cs.lonelytwitter;

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

public class LonelyTwitterActivity extends Activity {

    private static final String FILENAME = "file.sav";
    private EditText bodyText;
    private ListView oldTweetsList;
    /////////////////
    //Spinner spinner;
    //ArrayAdapter<CharSequence> adapter;
    /////////////////

    private ArrayList<Tweet> tweetList;
    private ArrayAdapter<Tweet> adapter;




    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        /////////////////
        // my code added:
        //spinner = (Spinner)findViewById(R.id.setMood);
        //adapter = ArrayAdapter.createFromResource(this,R.array.mood_list,android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(adapter);
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




                ///////////////////////////////////////////////////////
                /* my code added:
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
                *//////////////////////////////////////////////////////


                setResult(RESULT_OK);
                String text = bodyText.getText().toString();

                NormalTweet tweet = new NormalTweet(text);
                tweetList.add(tweet);
                adapter.notifyDataSetChanged();
                saveInFile();

                //NormalTweet newtweet2 = new NormalTweet(text, new Date());

                //ImportantTweet imptweet = new ImportantTweet("this is a important tweet");

                //NormalTweet normtweet = new NormalTweet("this is a normal tweet");

                //ArrayList<Tweet> alltweets = new ArrayList<Tweet>();
                //alltweets.add(tweet);
                //alltweets.add(newtweet2);
                //alltweets.add(imptweet);
                //alltweets.add(normtweet);




                try{
                    tweet.setMessage("Message too long");

                }
                catch(Exception e){
                    // Show a error message
                    e.printStackTrace();
                }



                ///////////////////////////////////////////////////////
                // my code modified:
                //saveInFile(newtext, new Date(System.currentTimeMillis()));
                finish();
                ///////////////////////////////////////////////////////

            }
        });
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        loadFromFile();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.list_item);
        oldTweetsList.setAdapter(adapter);
    }

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            // Taken...<link>
            // date
            Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
            tweetList = gson.fromJson(in,listType);


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            tweetList = new ArrayList<Tweet>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }

    }

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(tweetList, out);
            out.flush();
            //fos.write(new String(date.toString() + " | " + text)
            //        .getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }
}