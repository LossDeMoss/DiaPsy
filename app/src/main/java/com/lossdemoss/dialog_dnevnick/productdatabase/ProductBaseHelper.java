    package com.lossdemoss.dialog_dnevnick.productdatabase;

    import android.content.Context;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;

    import sorteddatabase.SortedZamerDBSchema;

    /**
 * Created by LossDeMoss on 03.11.2018.
 */

public class ProductBaseHelper extends SQLiteOpenHelper {
        private static final int VERSION = 8;
        private static final String DATABASE_NAME = "productBase.db";

        public ProductBaseHelper(Context context){
            super(context, DATABASE_NAME, null, VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL("create table " + ProductDBSchema.ProductTable.NAME + " (" +
                    " _id integer primary key autoincrement, " +
                    ProductDBSchema.ProductTable.Cols.UUID + ", " +
                    ProductDBSchema.ProductTable.Cols.NAME + ", " +
                    ProductDBSchema.ProductTable.Cols.TYPE + ", " +
                    ProductDBSchema.ProductTable.Cols.GRAMS +
                    ") "
            );

        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        }
        public Cursor raw() {

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor res = db.rawQuery("SELECT * FROM " + "productBase.db" , new String[]{});

            return res;
        }
}

