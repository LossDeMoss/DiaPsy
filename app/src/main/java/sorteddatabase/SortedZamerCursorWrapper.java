package sorteddatabase;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.lossdemoss.dialog_dnevnick.Zamer;

import java.util.Date;
import java.util.UUID;

import database.ZamerDBSchema;

/**
 * Created by LossDeMoss on 13.10.2018.
 */

public class SortedZamerCursorWrapper extends CursorWrapper {
    public SortedZamerCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Zamer getZamer(){
        String uuidSring = getString(getColumnIndex(SortedZamerDBSchema.SortedZamerTable.Cols.UUID));
        String bs = getString(getColumnIndex(SortedZamerDBSchema.SortedZamerTable.Cols.BS));
        String iu = getString(getColumnIndex(SortedZamerDBSchema.SortedZamerTable.Cols.IU));
        String bu = getString(getColumnIndex(SortedZamerDBSchema.SortedZamerTable.Cols.BU));
        String liu = getString(getColumnIndex(SortedZamerDBSchema.SortedZamerTable.Cols.LIU));
        String type = getString(getColumnIndex(SortedZamerDBSchema.SortedZamerTable.Cols.TYPE));
        long date = getLong(getColumnIndex(SortedZamerDBSchema.SortedZamerTable.Cols.DATE));
        long yesterday = getLong(getColumnIndex(SortedZamerDBSchema.SortedZamerTable.Cols.YESTERDAY));
        long twodaysago = getLong(getColumnIndex(SortedZamerDBSchema.SortedZamerTable.Cols.TWODAYSAGO));

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
