package ca.ualberta.cs.lonelytwitter;

import android.util.Log;

public class Cat extends Animal {

    public Cat(String type, String food) {
        super(type,food);
    }

    @Override
    public void swim() {
        Log.d("cmput-301","Hey, I hate swimming");
    }
}
