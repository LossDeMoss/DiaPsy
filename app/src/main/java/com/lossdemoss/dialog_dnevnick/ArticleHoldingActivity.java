package com.lossdemoss.dialog_dnevnick;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.UUID;

/**
 * Created by LossDeMoss on 30.08.2018.
 */

public class ArticleHoldingActivity extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    // Активность "держит" фрагмент, прокручивающий статьи
    public static final String EXTRA_ARTICLE_ID = "com.lossdemoss.android.dialog_dnevnick.article_id";

    public static Intent newIntent(Context packageContext, UUID articleID) {
        //Передача ID статьи
        Intent intent = new Intent(packageContext, ArticleHoldingActivity.class);
        intent.putExtra(EXTRA_ARTICLE_ID, articleID);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.holding_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.container_for_detail_articles);
        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.container_for_detail_articles, fragment)
                    .commit();
        }
    }
    protected Fragment createFragment() {
        return new ArticleFragment();
    }
}
