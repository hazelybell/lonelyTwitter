package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Ken on 21-Sep-2017.
 */

public class Sad extends Mood{
    public Sad(){
        super();
    }

    public Sad(Date date){
        super(date);
    }

    @Override
    public String getMood(){
        return "Sad";
    }
}
