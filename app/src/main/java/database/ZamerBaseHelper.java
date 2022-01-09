package database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteOpenHelper;

import com.lossdemoss.dialog_dnevnick.Zamer;

import database.ZamerDBSchema.ZamerTable;

/**
 * Created by LossDeMoss on 08.08.2018.
 */

public class ZamerBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 8;
    private static final String DATABASE_NAME = "zamerBase.db";

    public ZamerBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table " + ZamerTable.NAME + " (" +
        " _id integer primary key autoincrement, " +
                        ZamerTable.Cols.UUID + ", " +
                        ZamerTable.Cols.BS + ", " +
                        ZamerTable.Cols.IU + ", " +
                        ZamerTable.Cols.LIU + ", " +
                        ZamerTable.Cols.BU + ", " +
                        ZamerTable.Cols.TYPE + ", " +
                        ZamerTable.Cols.TWO_DAYS_AGO + ", " +
                        ZamerTable.Cols.YESTERDAY + ", " +
                        ZamerTable.Cols.DATE +
                        ") "
        );

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    }
    public Cursor raw() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + "zamerBase.db" , new String[]{});

        return res;
    }
}
