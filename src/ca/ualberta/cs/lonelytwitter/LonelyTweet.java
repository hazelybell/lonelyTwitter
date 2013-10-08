/**
 * 
 */
package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Date;

/**
 * @author joshua2
 *
 */
public class LonelyTweet implements Serializable {
	private Date tweetDate;
	private String tweetBody;
	/**
	 * @param tweetDate
	 * @param tweetBody
	 */
	public LonelyTweet(Date tweetDate, String tweetBody) {
		super();
		this.tweetDate = tweetDate;
		this.tweetBody = tweetBody;
	}
	/**
	 * @return the tweetDate
	 */
	public Date getTweetDate() {
		return tweetDate;
	}
	/**
	 * @param tweetDate the tweetDate to set
	 */
	public void setTweetDate(Date tweetDate) {
		this.tweetDate = tweetDate;
	}
	/**
	 * @return the tweetBody
	 */
	public String getTweetBody() {
		return tweetBody;
	}
	/**
	 * @param tweetBody the tweetBody to set
	 */
	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}

	private void writeObject(java.io.ObjectOutputStream out)
			throws IOException {
		out.writeObject(tweetDate);
		out.writeObject(tweetBody);
	}
	private void readObject(java.io.ObjectInputStream in)
			throws IOException, ClassNotFoundException {
		tweetDate = (Date) in.readObject();
		tweetBody = (String) in.readObject();
	}
	private void readObjectNoData() 
			throws ObjectStreamException {
	}
	public String toString() {
		return tweetDate.toString() + " | " + tweetBody;
	}
}
