package ca.ualberta.cs.lonelytwitter;

/**
 * Created by john on 13/09/16.
 */
public class ImportantTweet  extends Tweet implements Tweetable{

    public ImportantTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
