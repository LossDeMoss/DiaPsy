package com.lossdemoss.dialog_dnevnick;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Psycology extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psycology);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_for_articles);

        //Инфлатируем ArticleListFragment

        if (fragment == null){
            fragment = new ArticleListFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container_for_articles, fragment)
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            startZamerListActivity();
        } else if (id == R.id.nav_gallery) {

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
        Intent intent= new Intent(Psycology.this, BUMenu.class);
        startActivity(intent);
    }
    private void startThanks(){
        Intent intent = new Intent(Psycology.this, Thanks.class);
        startActivity(intent);}

    private void startVopros(){
        Uri uri = Uri.parse("http://diaunion.ru/diapsiholog/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void startZamerListActivity() {
        Intent intent = new Intent(Psycology.this, ZamerListActivity.class);
        startActivity(intent);
    }
    private void startStats() {
        Intent intent = new Intent(Psycology.this, Stats.class);
        startActivity(intent);
    }
    private void startAboutSpec(){
        Intent intent = new Intent(Psycology.this, AboutSpec.class);
        startActivity(intent);
    }
}

