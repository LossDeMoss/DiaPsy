package database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.lossdemoss.dialog_dnevnick.Zamer;

import java.util.Date;
import java.util.UUID;

/**
 * Created by LossDeMoss on 08.08.2018.
 */

public class ZamerCursorWrapper extends CursorWrapper {
    public ZamerCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Zamer getZamer(){
        String uuidSring = getString(getColumnIndex(ZamerDBSchema.ZamerTable.Cols.UUID));
        String bs = getString(getColumnIndex(ZamerDBSchema.ZamerTable.Cols.BS));
        String iu = getString(getColumnIndex(ZamerDBSchema.ZamerTable.Cols.IU));
        String bu = getString(getColumnIndex(ZamerDBSchema.ZamerTable.Cols.BU));
        String liu = getString(getColumnIndex(ZamerDBSchema.ZamerTable.Cols.LIU));
        String type = getString(getColumnIndex(ZamerDBSchema.ZamerTable.Cols.TYPE));
        long date = getLong(getColumnIndex(ZamerDBSchema.ZamerTable.Cols.DATE));
        long yesterday = getLong(getColumnIndex(ZamerDBSchema.ZamerTable.Cols.YESTERDAY));
        long twodaysago = getLong(getColumnIndex(ZamerDBSchema.ZamerTable.Cols.TWO_DAYS_AGO));


        Zamer zamer = new Zamer(UUID.fromString(uuidSring));
        zamer.setLIU(liu);
        zamer.setIU(iu);
        zamer.setBS(bs);
        zamer.setBU(bu);
        zamer.setTypeOfEating(type);
        zamer.setDate(new Date(date));
        zamer.setYesterday(yesterday);
        zamer.setTwoDaysAgo(twodaysago);
        return zamer;
    }
}
