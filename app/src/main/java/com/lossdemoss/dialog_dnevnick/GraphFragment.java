package com.lossdemoss.dialog_dnevnick;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import database.ZamerBaseHelper;
import database.ZamerDBSchema;
import sorteddatabase.SortedZamerBaseHelper;
import sorteddatabase.SortedZamerDBSchema;

/**
 * Created by LossDeMoss on 22.08.2018.
 */

public class GraphFragment extends Fragment {


    SQLiteDatabase sortedDatabase;
    SortedZamerBaseHelper sortedHelper;
    Zamer mZamer;
    ZamerLab mZamerLab;
    Date ddd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.graph_fragment, container, false);

        mZamer = new Zamer();
        sortedHelper = new SortedZamerBaseHelper(getActivity());
        sortedDatabase = sortedHelper.getWritableDatabase();
        ddd = mZamer.getDate();
        ZamerLab sZamerLab = new ZamerLab(getActivity());




        GraphView graph1 = (GraphView) v.findViewById(R.id.graph_one);
        GraphView graph2 = (GraphView) v.findViewById(R.id.graph_two);


        //------------------------------------------------------------------------------------------

        //Series for graph1

        //Data series

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(getDataPointForFirstGV());

        series.setDrawDataPoints(true);
        series.setThickness(7);
        series.setDataPointsRadius(13);
        series.setColor(Color.argb(255, 25, 118, 210));
        graph1.addSeries(series);

        //Decorate series

        LineGraphSeries<DataPoint> decorate_series = new LineGraphSeries<>(getDataPointForFirstGV());

        decorate_series.setThickness(0);
        decorate_series.setDrawDataPoints(true);
        decorate_series.setDataPointsRadius(7);
        decorate_series.setColor(Color.rgb(225, 255, 255));
        graph1.addSeries(decorate_series);
        // activate horizontal zooming and scrolling

        graph1.getViewport().setScalable(true);

        // activate horizontal scrolling

        graph1.getViewport().setScrollable(true);

        // activate horizontal and vertical zooming and scrolling

        graph1.getViewport().setScalableY(true);

        // activate vertical scrolling

        graph1.getViewport().setScrollableY(true);

        // grid render 1

        graph1.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
        graph1.getGridLabelRenderer().setNumHorizontalLabels(2);
        //------------------------------------------------------------------------------------------

        //Series for graph2

        //Data series for graph 2

        LineGraphSeries<DataPoint> series_today = new LineGraphSeries<>(getDataPointForToday());
        series_today.setDrawDataPoints(true);
        series_today.setThickness(7);
        series_today.setDataPointsRadius(13);
        series_today.setColor(Color.argb(255, 25, 118, 210));

        LineGraphSeries<DataPoint> series_yesterday = new LineGraphSeries<>(getDataPointForYesterday());
        series_yesterday.setDrawDataPoints(true);
        series_yesterday.setThickness(7);
        series_yesterday.setDataPointsRadius(13);
        series_yesterday.setColor(Color.argb(255, 255, 82, 82));

        LineGraphSeries<DataPoint> decorate_4_today = new LineGraphSeries<>(getDataPointForToday());
        decorate_4_today.setThickness(0);
        decorate_4_today.setDrawDataPoints(true);
        decorate_4_today.setDataPointsRadius(7);
        decorate_4_today.setColor(Color.argb(255, 25, 118, 210));


        LineGraphSeries<DataPoint> decorate_4_yesterday = new LineGraphSeries<>(getDataPointForYesterday());
        decorate_4_yesterday.setThickness(0);
        decorate_4_yesterday.setDrawDataPoints(true);
        decorate_4_yesterday.setDataPointsRadius(7);
        decorate_4_yesterday.setColor(Color.argb(255, 255, 82, 82));



        LineGraphSeries<DataPoint> series_two_days_ago = new LineGraphSeries<>(getDataPointForTwoDaysAgo());
        series_two_days_ago.setDrawDataPoints(true);
        series_two_days_ago.setThickness(7);
        series_two_days_ago.setDataPointsRadius(13);
        series_two_days_ago.setColor(Color.argb(255, 139, 195, 74));


        graph2.addSeries(series_today);
        graph2.addSeries(series_yesterday);
        graph2.addSeries(decorate_4_today);
        graph2.addSeries(decorate_4_yesterday);
        graph2.addSeries(series_two_days_ago);


        // activate horizontal zooming and scrolling

        graph2.getViewport().setScalable(true);

        // activate horizontal scrolling

        graph2.getViewport().setScrollable(true);

        // activate horizontal and vertical zooming and scrolling

        graph2.getViewport().setScalableY(true);

        // activate vertical scrolling

        graph2.getViewport().setScrollableY(true);

        // grid render 2

        graph2.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
        graph2.getGridLabelRenderer().setNumHorizontalLabels(2);

        series_two_days_ago.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPointInterface) {
                String pattern = "HH:mm:ss";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(new Date());
                String msg = ("Позавчера, \nСахар крови: " + dataPointInterface.getY() + "\nВремя: " + simpleDateFormat.format(dataPointInterface.getX()));
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
            }
        });

        decorate_4_yesterday.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPointInterface) {
                String pattern = "HH:mm:ss";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(new Date());
                String msg = ("Вчера, \nСахар крови: " + dataPointInterface.getY() + "\nВремя: " + simpleDateFormat.format(dataPointInterface.getX()));
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
            }
        });

        decorate_4_today.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPointInterface) {
                String pattern = "HH:mm:ss";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(new Date());
                String msg = ("Сегодня, \nСахар крови: " + dataPointInterface.getY() + "\nВремя: " + simpleDateFormat.format(dataPointInterface.getX()));
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
            }
        });


        series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPointInterface) {
                String pattern = "MM-dd-yyyy/HH:mm:ss";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(new Date());
                String msg = ("Сахар крови: " + dataPointInterface.getY() + "\nДата/Время: " + simpleDateFormat.format(dataPointInterface.getX()));
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
   // @Override
   // public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
   //     super.onCreateOptionsMenu(menu, inflater);
   //     inflater.inflate(R.menu.type_zamers_in_scv, menu);
   // }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.type_em_of:
                Intent intent = new Intent(getActivity(), DataBaseExportActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public DataPoint[] getDataPointForFirstGV() {
        String[] columns = {"DATE", "BS"};
        Calendar today = Calendar.getInstance();
        String mToday = String.valueOf(today.getTimeInMillis());
        String mYesturday = String.valueOf(today.getTimeInMillis() - 86400000);
        Cursor query = sortedDatabase.query("sortedZamers", columns, "BS != ? AND DATE > " + String.valueOf(mYesturday) + " AND DATE < " + String.valueOf(mToday), new String[]{("0.0")}, null, null, null);
        DataPoint[] dp = new DataPoint[query.getCount()];
        query.moveToFirst();
        for (int i = 0; i < query.getCount(); i++) {
            dp[i] = new DataPoint(query.getDouble(0), query.getDouble(1));
            query.moveToNext();
        }
        query.close();
        return dp;
    }


    public DataPoint[] getDataPointForToday() {
        String[] columns = {"DATE", "BS"};
        Calendar today = Calendar.getInstance();
        String mToday = String.valueOf(today.getTimeInMillis());
        String mYesturday = String.valueOf(today.getTimeInMillis() - 86400000);
        Cursor query = sortedDatabase.query("sortedZamers", columns, "BS != ? AND DATE > " + String.valueOf(mYesturday) + " AND DATE <= " + String.valueOf(mToday), new String[]{("0.0")}, null, null, null);
        DataPoint[] dp = new DataPoint[query.getCount()];
        query.moveToFirst();
        for (int i = 0; i < query.getCount(); i++) {
            dp[i] = new DataPoint(query.getLong(0), query.getDouble(1));
            query.moveToNext();
        }
        query.close();
        return dp;
    }

    public DataPoint[] getDataPointForYesterday() {
        String[] columns = {"YESTERDAY", "BS"};
        Calendar today = Calendar.getInstance();
        String mToday = String.valueOf(today.getTimeInMillis());
        String mYesturday = String.valueOf(today.getTimeInMillis() - 86400000);
        Cursor query = sortedDatabase.query("sortedZamers", columns, "BS != ? AND YESTERDAY > " + String.valueOf(mYesturday) + " AND YESTERDAY <= " + String.valueOf(mToday), new String[]{("0.0")}, null, null, null);
        DataPoint[] dp = new DataPoint[query.getCount()];
        query.moveToFirst();
        for (int i = 0; i < query.getCount(); i++) {
            dp[i] = new DataPoint(query.getLong(0), query.getDouble(1));
            query.moveToNext();}
        query.close();

        return dp;


    }

    public DataPoint[] getDataPointForTwoDaysAgo() {
        String[] columns = {"TWODAYSAGO", "BS"};
        Calendar today = Calendar.getInstance();
        String mToday = String.valueOf(today.getTimeInMillis());
        String mYesturday = String.valueOf(today.getTimeInMillis()-86400000);
        Cursor query = sortedDatabase.query("sortedZamers", columns, "BS != ? AND TWODAYSAGO > " + String.valueOf(mYesturday) + " AND TWODAYSAGO <= " + String.valueOf(mToday), new String[]{("0.0")}, null, null, null);
        DataPoint[] dp = new DataPoint[query.getCount()];
        query.moveToFirst();
        for (int i = 0; i < query.getCount(); i++) {
            dp[i] = new DataPoint(query.getLong(0), query.getDouble(1));
            query.moveToNext();
        }
        query.close();
        return dp;
    }
}

