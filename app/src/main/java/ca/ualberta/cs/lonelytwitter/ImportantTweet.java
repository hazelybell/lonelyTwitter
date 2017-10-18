/* ImportantTweet
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
 * Creates an ImportantTweet class inherited from Tweet
 * Created by hrai on 9/13/17.
 * @author team X
 * @version 1.5
 * @see Tweet
 * @since 1.0
 */

public class ImportantTweet extends Tweet {
    public ImportantTweet(String message){
        super(message);

    }

    /**
     * Creates an ImportantTweet oject
     * @param message
     * @param date
     */
    public ImportantTweet(String message, Date date){
        super(message, date);
    }

    //@Override
    //public Boolean isImportant() {
    //    return Boolean.TRUE;
    //}
}
