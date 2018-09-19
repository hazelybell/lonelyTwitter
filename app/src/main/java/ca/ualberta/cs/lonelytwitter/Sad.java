package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Sad extends Mood {

    public Sad(Date date) {
        super(date);
    }

    public Sad() {
        super();
    }

    @Override
    String format() {
        return "Sad";
    }
}
