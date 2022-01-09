package sorteddatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import database.ZamerDBSchema;

/**
 * Created by LossDeMoss on 13.10.2018.
 */

public class SortedZamerBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 8;
    private static final String DATABASE_NAME = "sortedZamerBase.db";

    public SortedZamerBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table " + SortedZamerDBSchema.SortedZamerTable.NAME + " (" +
                " _id integer primary key autoincrement, " +
                SortedZamerDBSchema.SortedZamerTable.Cols.UUID + ", " +
                SortedZamerDBSchema.SortedZamerTable.Cols.BS + ", " +
                SortedZamerDBSchema.SortedZamerTable.Cols.IU + ", " +
                SortedZamerDBSchema.SortedZamerTable.Cols.LIU + ", " +
                SortedZamerDBSchema.SortedZamerTable.Cols.BU + ", " +
                SortedZamerDBSchema.SortedZamerTable.Cols.TYPE + ", " +
                SortedZamerDBSchema.SortedZamerTable.Cols.TWODAYSAGO + ", " +
                SortedZamerDBSchema.SortedZamerTable.Cols.YESTERDAY + ", " +
                SortedZamerDBSchema.SortedZamerTable.Cols.DATE +
                ") "
        );

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    }
    public Cursor raw() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + "sortedZamerBase.db" , new String[]{});

        return res;
    }
}
