package com.lossdemoss.dialog_dnevnick;

/**
 * Created by LossDeMoss on 27.10.2018.
 */

public class SplashPhrase {
    int mId;
    String Phrase;

    public SplashPhrase(int id, String phrase) {
        mId = id;
        Phrase = phrase;
    }

    public SplashPhrase(int id) {
        mId = id;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getPhrase() {
        return Phrase;
    }

    public void setPhrase(String phrase) {
        Phrase = phrase;
    }
}
