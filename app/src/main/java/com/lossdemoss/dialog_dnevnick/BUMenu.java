package com.lossdemoss.dialog_dnevnick;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.SearchView;
import android.widget.Toast;

import java.util.List;


public class BUMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SearchView.OnQueryTextListener {
    //Данная активность не доработана, сейчас доводится до ума фуннкция поиска с инфлатацией списка продуктов, от этого активность провереяет, инфлатирован ли список продуктов
    public ProductLab prodLab;
    public BUProductListFragment mBUProductListFragment;
    public BUProductListFragment.ProductAdapter mAdapter;
    private boolean productsInflated;
    private FloatingActionButton mAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bumenu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_for_products);

        if (fragment == null){
            fragment = new BUTypesListFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container_for_products, fragment)
                    .commit();
        }
        //
        //Создание масива продуктов из ProductLab
        prodLab = ProductLab.get(getApplicationContext());
        productsInflated = false;
        mBUProductListFragment = new BUProductListFragment();
        mAdapter = mBUProductListFragment.mProductAdapter;

        //Кнопка для добавления продукта, в процессе UI-тестов было выяснено, что людям легче добавлять продукты с тулбара в BUProductListFragment. Принцип работы добавления новых продуктов и отображения существующих
        //будет реструктурирован.
        mAddButton = (FloatingActionButton) findViewById(R.id.fab_add_bumenu);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Создание продукта
                BUProduct product = new BUProduct();
                //Тип 1 ставится из-за того, что 1 группа - "Мои продукты", и продукт добавляется туда. В январском обновлении будет возможость выбирать категорию продукта.
                product.setTypeId(1);
                //Запрос на создание нового продукта в БД
                ProductLab.get(getApplicationContext()).addProduct(product);
                //Передача с интентой номер и тип продукта, старт AddNewProductActivity
                Intent intent = AddNewProductActivity.newIntent(getApplicationContext(), product.getId(), product.getTypeId());
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        if (productsInflated) {
            inflateTypes();
        }
        else {
            super.onBackPressed();
        }
    }
    //Недоделаный SearchView

    //@Override
    //public boolean onCreateOptionsMenu (Menu menu) {
    //    getMenuInflater().inflate(R.menu.search_in_bu, menu);
    //    MenuItem menuItem = menu.findItem(R.id.search_action);
    //    SearchView searchView = (SearchView) menuItem.getActionView();
    //    searchView.setOnQueryTextListener(this);
    //    menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
    //        @Override
    //        public boolean onMenuItemClick(MenuItem menuItem) {
    //            inflateProducts();
    //            return true;
    //        }
    //    });
    //    return true;
    //}


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            startZamerListActivity();
        } else if (id == R.id.nav_gallery) {
            startPsycology();
        } else if (id == R.id.nav_slideshow) {
            startStats();
        } else if (id == R.id.nav_manage) {

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
    private void startThanks(){
        Intent intent = new Intent(BUMenu.this, Thanks.class);
        startActivity(intent);
    }
    private void startVopros(){
        Uri uri = Uri.parse("http://diaunion.ru/diapsiholog/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    private void startAboutSpec(){
        Intent intent = new Intent(BUMenu.this, AboutSpec.class);
        startActivity(intent);
    }
    private void startZamerListActivity() {
        Intent intent = new Intent(BUMenu.this, ZamerListActivity.class);
        startActivity(intent);
    }
    private void startPsycology(){
        Intent intent = new Intent(BUMenu.this, Psycology.class);
        startActivity(intent);
    }
    private void startStats() {
        Intent intent = new Intent(BUMenu.this, Stats.class);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        //if (!s.equals("")) {
        //    mBUProductListFragment.updateSearchResults(s);
        //    return true;
        //}
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        mAdapter.getFilter().filter(s);
        return false;
    }


    //Инфлатация активностью списка продуктов
    public void inflateProducts(){
        productsInflated = true;
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_for_products);
        if (fragment != null){
            fragment = new BUProductListFragment();
            fm.beginTransaction()
                    .replace(R.id.fragment_container_for_products, fragment)
                    .commit();
        }
    }
    //Инфлатация активностью списка типов - категорий
    public void inflateTypes(){
        productsInflated = false;
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_for_products);
        if (fragment != null){
            fragment = new BUTypesListFragment();
            fm.beginTransaction()
                    .replace(R.id.fragment_container_for_products, fragment)
                    .commit();
        }
    }

}

