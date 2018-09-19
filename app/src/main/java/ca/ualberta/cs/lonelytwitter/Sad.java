package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Sad extends Mood {

    Sad () {
        super();
    }

    Sad (Date date) {
        super(date);
    }

    @Override
    public String getMood(){
        return ":(";
    }

}
