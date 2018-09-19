package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Happy extends Mood {

    Happy () {
        super();
    }

    Happy (Date date) {
        super(date);
    }

    @Override
    public String getMood(){
        return ":)";
    }

}
