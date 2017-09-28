/* Normal Tweet
 *
 * Version 1.0
 *
 * September 27, 2017
 *
 * Copyright (c) 2017 Team X, CMPUT301, University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code of Student Behavior at University of Alberta.
 * You can find a cope of the license in this project. Otherwise please contact contact@abc.ca
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Distinguishes a Tweet as Normal
 * Created by hrai on 9/13/17.
 * @author team X
 * @version 1.5
 * @see Tweet
 * @since 1.0
 */

public class NormalTweet extends Tweet{

    public NormalTweet(String message) {
        super(message);
    }

    /**
     * Constructs a NormalTweet object
     * @param message
     * @param date
     */
    public NormalTweet(String message, Date date){
        super(message, date);
    }

    /*@Override
    //public Boolean isImportant() {
        return Boolean.FALSE;
    }*/
}
