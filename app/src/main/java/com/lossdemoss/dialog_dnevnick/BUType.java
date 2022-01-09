package com.lossdemoss.dialog_dnevnick;

import java.util.UUID;

/**
 * Created by LossDeMoss on 23.10.2018.
 */

public class BUType {
    private String mName;
    private int mId;

    public BUType (String name, int id){
        this.mName = name;
        this.mId = id;
    }
    public BUType (String name){
        this.mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }
}
