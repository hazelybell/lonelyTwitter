package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Ken on 21-Sep-2017.
 */

public class Happy extends Mood{
    public Happy(){
        super();
    }

    public Happy(Date date){
        super(date);
    }

    @Override
    public String getMood(){
        return "Good";
    }
}
