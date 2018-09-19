package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LonelyTwitterActivity extends Activity {

    private static final String FILENAME = "file.sav";
    private EditText bodyText;
    private ListView oldTweetsList;
    private CheckBox sadCheckBox;
    private CheckBox angryCheckbox;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bodyText = (EditText) findViewById(R.id.body);
        Button saveButton = (Button) findViewById(R.id.save);
        oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

        // get the mood checkboxes
        sadCheckBox = (CheckBox) findViewById(R.id.sadCheckBox);
        angryCheckbox = (CheckBox) findViewById(R.id.angryCheckBox);

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);

                // use the checkboxes to note what moods to add to the tweet
                // more advanced usage could be developed but this is a simple implementation
                ArrayList<Mood> moodList = new ArrayList<>();
                Date date = new Date(System.currentTimeMillis());
                if (sadCheckBox.isChecked()) {
                    moodList.add(new Sad(date));
                }
                if (angryCheckbox.isChecked()) {
                    moodList.add(new Angry(date));
                }

                String text = bodyText.getText().toString();
                saveInFile(text, date, moodList);

                // reset the angry and sad checkboxes
                sadCheckBox.setChecked(false);
                angryCheckbox.setChecked(false);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        String[] tweets = loadFromFile();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.list_item, tweets);
        oldTweetsList.setAdapter(adapter);
    }

    private String[] loadFromFile() {
        ArrayList<String> tweets = new ArrayList<>();
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

    private <T extends Mood> void saveInFile(String text, Date date, List<T> moodList) {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_APPEND);
            fos.write((date.toString() + " | " + moodList.toString() + " | " + text).getBytes());
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