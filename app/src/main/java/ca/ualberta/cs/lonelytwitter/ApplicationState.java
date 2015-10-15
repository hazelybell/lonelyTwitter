package ca.ualberta.cs.lonelytwitter;

/**
 * Created by wz on 13/10/15.
 */
public class ApplicationState {
    private static ApplicationState ourInstance = new ApplicationState();

    public static ApplicationState getInstance() {
        return ourInstance;
    }

    private Tweet editingTweet;

    private ApplicationState() {
    }

    public Tweet getEditingTweet() {
        return editingTweet;
    }

    public void setEditingTweet(Tweet editingTweet) {
        this.editingTweet = editingTweet;
    }
}
