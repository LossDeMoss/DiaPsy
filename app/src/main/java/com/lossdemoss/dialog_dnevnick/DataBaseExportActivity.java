package com.lossdemoss.dialog_dnevnick;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresPermission;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import database.ZamerBaseHelper;

public class DataBaseExportActivity extends AppCompatActivity {
    //Активность не включена в проект, т.к. логика не создана и не прописана. Активность должна создавать CSV-фаил для вывода замеров за определённый период времени.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_export);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button ExpButton = (Button) findViewById(R.id.export_button);
        ExpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WriteHello(getApplicationContext(), "Zamers", "hi");
            }
        });


    }
    public void WriteHello(Context context, String sFileName, String sBody) {
        String file_name = "Zamers.txt";
        String txt = "Дарова";

        FileOutputStream fileOutputStream = null;
        File mFile = new File(file_name);

        try {
            fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
            fileOutputStream.write(txt.getBytes());

            Toast.makeText(context, "OK", Toast.LENGTH_SHORT).show();
        } catch (IOException e){
            Toast.makeText(context, "NOT OK", Toast.LENGTH_SHORT).show();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e){
                
            }
        }
    }

    /*public void WriteHello(Context context, String sFileName, String sBody) {
        try {
            if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                Toast.makeText(context, "Вставьте SD-карту!", Toast.LENGTH_SHORT).show();
                //handle case of no SDCARD present
            } else {
                String filename = "Zamers.txt";
                String fileContents = "Мы внутри";
                FileOutputStream outputStream;
                Toast.makeText(context, "Ваши замеры сохранены", Toast.LENGTH_SHORT).show();

                try {
                    outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                    outputStream.write(fileContents.getBytes());
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, "NOT Saved", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "NOT Saved", Toast.LENGTH_SHORT).show();
        }
    }*/
}
