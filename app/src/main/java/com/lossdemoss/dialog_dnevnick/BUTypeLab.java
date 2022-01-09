package com.lossdemoss.dialog_dnevnick;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by LossDeMoss on 24.10.2018.
 */

public class BUTypeLab {
    private static BUTypeLab mBUTypeLab;

    private List<BUType> mBUTypes;

    public static BUTypeLab get (Context context){
        if (mBUTypeLab==null) {
            mBUTypeLab = new BUTypeLab(context);
        }
        return mBUTypeLab;
    }
    private BUTypeLab(Context context){
        mBUTypes = new ArrayList<>();
        //Массив типов
        BUType buType = new BUType("Мои продукты", 1);
        BUType buType1 = new BUType("Выпечка", 2);
        BUType buType2 = new BUType("Крупы, макароны",3);
        BUType buType3 = new BUType("Овощи",4);
        BUType buType4 = new BUType("Грибы", 5);
        BUType buType5 = new BUType("Ягоды, фрукты",6);
        BUType buType6 = new BUType("Сухофрукты",7);
        BUType buType7 = new BUType("Экзотические фрукты",8);
        BUType buType8 = new BUType("Соки",9);
        BUType buType9 = new BUType("Орехи, семечки",10);
        BUType buType10 = new BUType("Молочные продукты",11);
        BUType buType11 = new BUType("Сладкое",12);
        //BUType buTypeShocolad = new BUType("Кафе Шоколадница", 13);
        BUType buTypeMac = new BUType("МакДональдс", 14);
        //Добавление типов
        mBUTypes.add(buType);
        mBUTypes.add(buType1);
        mBUTypes.add(buType2);
        mBUTypes.add(buType3);
        mBUTypes.add(buType4);
        mBUTypes.add(buType5);
        mBUTypes.add(buType6);
        mBUTypes.add(buType7);
        mBUTypes.add(buType8);
        mBUTypes.add(buType9);
        mBUTypes.add(buType10);
        mBUTypes.add(buType11);
        //mBUTypes.add(buTypeShocolad);
        mBUTypes.add(buTypeMac);
    }
    public List<BUType> getBUTypes(){
        return mBUTypes;
    }

    public BUType getBUType (int id){
        for(BUType type : mBUTypes){
            if (type.getId() == id){
                return type;
            }
        }
        return null;
    }
}
