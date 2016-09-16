package ca.ualberta.cs.lonelytwitter;

/**
 * Created by tymathieu on 2016-09-15.
 */
public class ImportantTweet extends Tweet{

    public ImportantTweet(String message){
        super(message);
    }

    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }
}
