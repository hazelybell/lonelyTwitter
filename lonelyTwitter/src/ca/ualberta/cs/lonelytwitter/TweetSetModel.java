package ca.ualberta.cs.lonelytwitter;

public class TweetSetModel {

	int count = 0;
	public int countTweets() {
		return count;
	}

	public void addTweet(NormalTweetModel normalTweetModel) {
		count++;
		
	}

}
