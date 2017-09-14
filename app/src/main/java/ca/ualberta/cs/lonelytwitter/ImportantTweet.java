package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
import java.util.List;

/**
 * Created by enzozafra on 2017-09-13.
 */

public class ImportantTweet extends Tweet {
    public ImportantTweet(String message, List<Mood> moodList) {
        super(message, moodList);
    }

    public ImportantTweet(String message, List<Mood> moodList, Date date) {
        super(message, moodList, date);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
