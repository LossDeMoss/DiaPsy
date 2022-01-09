package com.lossdemoss.dialog_dnevnick;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Splash extends AppCompatActivity {

    private GifImageView mGif;
    private TextView SplashTV;
    private SplashPhrasesLab mLab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Заставка со случайными фразами.
        super.onCreate(savedInstanceState);
        SplashPhrasesLab mLab = new SplashPhrasesLab(getApplicationContext());
        List<SplashPhrase> mPhrases = mLab.getSplashPhrases();
        setContentView(R.layout.activity_splash);
        mGif = (GifImageView) findViewById(R.id.gif_splash);
        SplashTV = (TextView) findViewById(R.id.splash_text);
        //Выбор из заготовленной базы фраз
        int random_number1 = (int) (Math.random() * 24);
        SplashTV.setText(mPhrases.get(random_number1).getPhrase());
        try {
            InputStream inputStream = getAssets().open("splash1.gif");
            byte [] bytes = IOUtils.toByteArray(inputStream);
            mGif.setBytes(bytes);
            mGif.startAnimation();
        }
        catch (IOException e){}

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Splash.this.startActivity(new Intent(Splash.this, ZamerListActivity.class));
            }
        }, 5000);

    }
}
