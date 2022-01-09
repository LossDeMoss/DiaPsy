package com.lossdemoss.dialog_dnevnick;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;

/**
 * Created by LossDeMoss on 01.08.2018.
 */

public class ZamerListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_for_zamers);
        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container_for_zamers, fragment)
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    //@Override
    //public boolean onKeyDown(int keyCode, KeyEvent event)  {
    //    if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
    //        return true;
    //    }
//
    //    return super.onKeyDown(keyCode, event);
    //}
//
    @Override
     public void onBackPressed() {
        super.onBackPressed();
   }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {
            startPsycology();
        } else if (id == R.id.nav_slideshow) {
            startStats();
        } else if (id == R.id.nav_manage) {
            startBUMenu();
        } else if (id == R.id.vopros) {
            startVopros();
        } else if (id == R.id.nav_share) {
            startAboutSpec();
        }else if (id == R.id.nav_send) {
            startThanks();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void startBUMenu(){
        Intent intent= new Intent(ZamerListActivity.this, BUMenu.class);
        startActivity(intent);}
    private void startThanks(){
        Intent intent = new Intent(ZamerListActivity.this, Thanks.class);
        startActivity(intent);
    }
    private void startVopros(){
        Uri uri = Uri.parse("http://diaunion.ru/diapsiholog/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    private void startAboutSpec(){
        Intent intent = new Intent(ZamerListActivity.this, AboutSpec.class);
        startActivity(intent);
    }
    private void startPsycology(){
        Intent intent = new Intent(ZamerListActivity.this, Psycology.class);
        startActivity(intent);
    }
    private void startStats() {
        Intent intent = new Intent(ZamerListActivity.this, Stats.class);
        startActivity(intent);
    }

    protected Fragment createFragment() {
        return new ZamerListFragment();
    }
}
