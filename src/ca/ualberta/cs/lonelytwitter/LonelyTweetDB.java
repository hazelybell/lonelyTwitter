/**
 * 
 */
package ca.ualberta.cs.lonelytwitter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import android.app.Activity;

/**
 * @author joshua2
 *
 */
public class LonelyTweetDB {
	private ArrayList<LonelyTweet> lts;
	private Activity ctx;
	private static final String FILENAME = "file.sav";
	/**
	 * 
	 */
	public LonelyTweetDB(Activity a) {
		super();
		ctx = a;
		assert a != null;
		lts = new ArrayList<LonelyTweet>();
	}

	public ArrayList<LonelyTweet> getLts() {
		return lts;
	}

	public void load() {
		assert ctx != null;
		ArrayList<String> tweets = new ArrayList<String>();
		lts.clear();
		try {
			FileInputStream fis = ctx.openFileInput(FILENAME);
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (true) {
				LonelyTweet lt = (LonelyTweet) ois.readObject();
				tweets.add(lt.toString());
				lts.add(lt);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public void save() {
		try {
			FileOutputStream fos = ctx.openFileOutput(FILENAME, 0);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (LonelyTweet lti : getLts()) {
				oos.writeObject(lti);
			}
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void add(LonelyTweet lt) {
		lts.add(lt);
		save();
	}
	
	public void clear() {
		lts.clear();
		save();
	}
}
