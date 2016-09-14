package ca.ualberta.cs.lonelytwitter;

/**
 * Created by watts1 on 9/13/16.
 */
public class NormalTweet extends Tweet implements Tweetable {

    public NormalTweet(String message){
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
