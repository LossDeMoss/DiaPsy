package com.lossdemoss.dialog_dnevnick;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewParent;

import java.util.List;
import java.util.UUID;

/**
 * Created by LossDeMoss on 04.08.2018.
 */

public class ZamerPagerActivity extends AppCompatActivity {
    //Между замерами можно преремещаться свайпом влево-вправо
    private static final String EXTRA_ZAMER_ID = "com.lossdemoss.android.dialog_dnevnick.zamer_id";
    private ViewPager mViewPager;
    private List<Zamer> mZamers;

    //Интента для перехода из ZamerListActivity
    public static Intent newIntent(Context packageContext, UUID zamer_id){
        Intent intent = new Intent(packageContext, ZamerPagerActivity.class);
        intent.putExtra(EXTRA_ZAMER_ID, zamer_id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zamer_pager);
        //Определение замера.
        UUID zamerID = (UUID) getIntent().getSerializableExtra(EXTRA_ZAMER_ID);
        mViewPager = (ViewPager) findViewById(R.id.zamer_view_pager);
        //Предача PagerActivity списка замеров.
        mZamers = ZamerLab.get(this).getSortedZamers();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Zamer zamer = mZamers.get(position);
                return ZamerFragment.newInstance(zamer.getId());
            }

            @Override
            public int getCount() {
                return mZamers.size();
            }
        });

        for (int i=0; i<mZamers.size(); i++){
            if (mZamers.get(i).getId().equals(zamerID)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
