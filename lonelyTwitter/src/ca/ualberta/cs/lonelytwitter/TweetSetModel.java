package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TweetSetModel {
	private ArrayList<LonelyTweetModel> tweets;
	private int count = 0;
	public TweetSetModel(){
		super();
		tweets = new ArrayList<LonelyTweetModel>();
		count= 0;
	}
	public int countTweets() {
		return count;
	}

	public void addTweet(NormalTweetModel normalTweetModel) {
		count++;
		
		for(LonelyTweetModel ntm : tweets){
			if(ntm.equals(normalTweetModel)){
				throw(new IllegalArgumentException());
			}
		}
		tweets.add(normalTweetModel);
		
	}

	public LonelyTweetModel[] getTweets(){
		return (LonelyTweetModel[]) tweets.toArray();
	}
}
