package com.lossdemoss.dialog_dnevnick;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import database.ZamerBaseHelper;
import database.ZamerCursorWrapper;
import database.ZamerDBSchema;
import sorteddatabase.SortedZamerBaseHelper;
import sorteddatabase.SortedZamerDBSchema;

/**
 * Created by LossDeMoss on 01.08.2018.
 */

public class ZamerLab {
    private static ZamerLab sZamerLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private SQLiteDatabase sortedDataBase;

    public static ZamerLab get(Context context) {
        if (sZamerLab == null) {
            sZamerLab = new ZamerLab(context);
        }
        return sZamerLab;
    }

    public ZamerLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new ZamerBaseHelper(mContext).getWritableDatabase();
        sortedDataBase = new SortedZamerBaseHelper(mContext).getWritableDatabase();
    }
    //Добавление нового замера
    public void addZamer(Zamer z){
       ContentValues values = getContentValues(z);
       mDatabase.insert(ZamerDBSchema.ZamerTable.NAME, null, values);
    }
    //Удаление замера
    public void deleteZamer(UUID zamerId)
    {
        String uuidString = zamerId.toString();
        mDatabase.delete(ZamerDBSchema.ZamerTable.NAME, ZamerDBSchema.ZamerTable.Cols.UUID + " = ?", new String[] {uuidString});
    }
    //Предоставление замеров из базы данных
    public List<Zamer> getZamers() {
        List<Zamer> zamers = new ArrayList<>();
        ZamerCursorWrapper cursor = queryZamers(null, null);
        try {
            cursor.moveToLast();
            while(!cursor.isBeforeFirst()){
                zamers.add(cursor.getZamer());
                cursor.moveToPrevious();
            }
        }finally{
            cursor.close();
        }
        return zamers;
    }
    //Предоставленный список замеров собирается, сортируется и добвляется в отсортированную БД. Это было сделано для корректного отображения грфиков в GraphFragment
    public List<Zamer> getSortedZamers() {
        List<Zamer> SortedZamers;
        SortedZamers = sZamerLab.getZamers();
        Collections.sort(SortedZamers, new Sorter());
        return SortedZamers;
    }

    class Sorter implements Comparator<Zamer>
    {
        public int compare(Zamer a, Zamer b)
        {
            return (int)( b.getDate().getTime() - a.getDate().getTime());
        }
    }

    //Предоставление отдельного замера для ZamerFragment
    public Zamer getZamer(UUID id) {
    ZamerCursorWrapper cursor = queryZamers(
            ZamerDBSchema.ZamerTable.Cols.UUID + "= ?",
            new String[] {id.toString()}
    );
    //Поиск по базе данных
    try {
        if (cursor.getCount() == 0) {
            return null;
        }
        cursor.moveToFirst();
        return cursor.getZamer();
    }finally{
        cursor.close();
        }
    }
    //Обновление замера в базе данных
    public void updateZamer(Zamer z){
        String uuidString = z.getId().toString();
        ContentValues values = getContentValues(z);
        mDatabase.update(ZamerDBSchema.ZamerTable.NAME, values, ZamerDBSchema.ZamerTable.Cols.UUID + " = ?", new String[] {uuidString});
    }

    private ZamerCursorWrapper queryZamers(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                ZamerDBSchema.ZamerTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        return new ZamerCursorWrapper(cursor);
    }

    //Предоставление данных замера в базу данных
    private static ContentValues getContentValues(Zamer zamer) {
        ContentValues values = new ContentValues();
        values.put(ZamerDBSchema.ZamerTable.Cols.UUID, zamer.getId().toString());
        values.put(ZamerDBSchema.ZamerTable.Cols.BS, zamer.getBS());
        values.put(ZamerDBSchema.ZamerTable.Cols.IU, zamer.getIU());
        values.put(ZamerDBSchema.ZamerTable.Cols.BU, zamer.getBU());
        values.put(ZamerDBSchema.ZamerTable.Cols.LIU, zamer.getLIU());
        values.put(ZamerDBSchema.ZamerTable.Cols.TYPE, zamer.getTypeOfEating());
        values.put(ZamerDBSchema.ZamerTable.Cols.DATE, zamer.getDate().getTime());
        values.put(ZamerDBSchema.ZamerTable.Cols.YESTERDAY, zamer.getYesterday());
        values.put(ZamerDBSchema.ZamerTable.Cols.TWO_DAYS_AGO, zamer.getTwoDaysAgo());
        return values;
    }
    //Предоставление данных замера в сортировнную базу данных
    private static ContentValues getSortedContentValues(Zamer zamer) {
        ContentValues values = new ContentValues();
        values.put(SortedZamerDBSchema.SortedZamerTable.Cols.UUID, zamer.getId().toString());
        values.put(SortedZamerDBSchema.SortedZamerTable.Cols.BS, zamer.getBS());
        values.put(SortedZamerDBSchema.SortedZamerTable.Cols.IU, zamer.getIU());
        values.put(SortedZamerDBSchema.SortedZamerTable.Cols.BU, zamer.getBU());
        values.put(SortedZamerDBSchema.SortedZamerTable.Cols.LIU, zamer.getLIU());
        values.put(SortedZamerDBSchema.SortedZamerTable.Cols.TYPE, zamer.getTypeOfEating());
        values.put(SortedZamerDBSchema.SortedZamerTable.Cols.DATE, zamer.getDate().getTime());
        values.put(SortedZamerDBSchema.SortedZamerTable.Cols.YESTERDAY, zamer.getYesterday());
        values.put(SortedZamerDBSchema.SortedZamerTable.Cols.TWODAYSAGO, zamer.getTwoDaysAgo());
        return values;
    }
    //Ввод данных в сортированную базу данных. Все замеры удаляются из сортированной базы, заносится новая таблица, чтобы не переставлять замеры "методом пузырька" - это увеличит время загрузки статистики.
    public void insertInSortedDB(){
        sortedDataBase.delete(SortedZamerDBSchema.SortedZamerTable.NAME, null, null);
        if (sZamerLab.getSortedZamers()!=null){
                if (!sZamerLab.getSortedZamers().isEmpty()){
        for (int i = sZamerLab.getSortedZamers().size()-1; i >= 0; i--) {
            Zamer zamer = sZamerLab.getSortedZamers().get(i);
            ContentValues values = getSortedContentValues(zamer);
            sortedDataBase.insert(SortedZamerDBSchema.SortedZamerTable.NAME, null, values);
                }
            }
        }
    }
}
