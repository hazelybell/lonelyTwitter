package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class ImportantTweet extends Tweet {

    ImportantTweet() {
        super();
    }

    ImportantTweet(String message) {
        super(message);

    }

    @Override
    public Boolean isImportant() {
        return true;
    }
}
