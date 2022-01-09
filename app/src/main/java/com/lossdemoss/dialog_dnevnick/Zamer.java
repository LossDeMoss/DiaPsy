package com.lossdemoss.dialog_dnevnick;

import android.provider.Contacts;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by LossDeMoss on 30.07.2018.
 */

public class Zamer {
    //Каждый замер имеет Id
    //Для информаии о замере были созданы сокращения:
    // BS - Blood Sugar - сахар крови
    // IU - Insuline Units - Еденицы инсулина
    // BU - Bread Units - Хлебные Единицы
    // LIU - Long Insuline Units - Единицы Длинного Инсулина
    // TypeOfEating - Дополнительная информация о замере
    // mYesterday - дополнительное поле для корректного отображения данных на графике
    // mTwoDaysAgo - дополнительное поле для корректного отображения данных на графике
    private UUID mId;
    private String mBS;
    private String mIU;
    private Date mDate;
    private String mBU;
    private String mLIU;
    private String mTypeOfEating;
    private long mYesterday;
    private long mTwoDaysAgo;

    public Zamer(){
        this(UUID.randomUUID());
    }
    public Zamer(UUID id){
        mId = id;
        mDate = new Date();
    }

    public long getYesterday() {
        return this.getDate().getTime() + 86400000;
    }

    public void setYesterday(long yesterday) {
        mYesterday = yesterday;
    }

    public long getTwoDaysAgo() {
        return this.getDate().getTime() + 86400000*2;
    }

    public void setTwoDaysAgo(long twoDaysAgo) {
        mTwoDaysAgo = twoDaysAgo;
    }

    public String getTypeOfEating() {
        return mTypeOfEating;
    }

    public void setTypeOfEating(String typeOfEating) {
        mTypeOfEating = typeOfEating;
    }

    public String getLIU() {
        return mLIU;
    }

    public void setLIU(String LIU) {
        mLIU = LIU;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getBS() {
        return mBS;
    }

    public void setBS(String BS) {
        mBS = BS;
    }

    public String getIU(){
        return mIU;
    }

    public void setIU(String iu) {
        mIU=iu;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date){
        mDate = date;
    }

    public String getBU(){
        return mBU;
    }

    public void setBU(String BU) {
        this.mBU = BU;
    }
    public void setDay(Date date) {

        Calendar crimeCalendar = Calendar.getInstance();
        crimeCalendar.setTime(mDate);

        Calendar newDate = Calendar.getInstance();
        newDate.setTime(date);

        //Set the TIME on the new date to the same time currently set
        newDate.set(Calendar.HOUR_OF_DAY, crimeCalendar.get(Calendar.HOUR_OF_DAY));
        newDate.set(Calendar.MINUTE, crimeCalendar.get(Calendar.MINUTE));

        mDate = newDate.getTime();
    }

    public void setTime(Date date) {
        Calendar crimeCalendar = Calendar.getInstance();
        crimeCalendar.setTime(mDate);

        Calendar newDate = Calendar.getInstance();
        newDate.setTime(date);

        //Set the DATE on the new date to the same day currently set
        newDate.set(Calendar.MONTH, crimeCalendar.get(Calendar.MONTH));
        newDate.set(Calendar.DAY_OF_MONTH, crimeCalendar.get(Calendar.DAY_OF_MONTH));
        newDate.set(Calendar.YEAR, crimeCalendar.get(Calendar.YEAR));

        mDate = newDate.getTime();
    }
}
