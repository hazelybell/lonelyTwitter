package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Mood {
    private Date date;

    Mood() {
        this.date = new Date(System.currentTimeMillis());
    }

    Mood(Date date) {
        this.date = date;
    }

    /**
     * A mood-dependent format method which returns a string representing the mood.
     *
     * @return {@code String}
     */
    abstract String format();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return format() + " | " + date.toString();
    }
}
