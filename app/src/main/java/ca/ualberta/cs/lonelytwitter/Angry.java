package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Angry extends Mood {

    public Angry(Date date) {
        super(date);
    }

    public Angry() {
        super();
    }

    @Override
    String format() {
        return "Angry";
    }
}
