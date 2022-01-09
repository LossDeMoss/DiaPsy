package com.lossdemoss.dialog_dnevnick;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.UUID;

public class ProductListActivity extends AppCompatActivity {

    private static final String EXTRA_TYPE_ID = "com.lossdemoss.android.dialog_dnevnick.type_id";
    private LinearLayout mLayout;
    private RecyclerView ProductRecycleView;
    private ProductAdapter mProductAdapter;

    public static Intent newIntentbyType (Context packageContext, int type_id){
        Intent intent = new Intent(packageContext, ProductListActivity.class);
        intent.putExtra(EXTRA_TYPE_ID, type_id);
        return intent;
    }
    private void updateUI(){
        int typeID = (int) getIntent().getSerializableExtra(EXTRA_TYPE_ID);
        ProductLab prodLab = ProductLab.get(getApplicationContext());
        //передача  типа продуктов в метод, пополняющий лист.
        List<BUProduct> products = prodLab.getBUProducts(typeID);
        if (mProductAdapter == null){
        // загрузка листа в адаптер.
        mProductAdapter = new ProductAdapter(products);
        ProductRecycleView.setAdapter(mProductAdapter);
        }else {
            // загрузка листа в адаптер.
            mProductAdapter = new ProductAdapter(products);
            ProductRecycleView.setAdapter(mProductAdapter);
            mProductAdapter.notifyDataSetChanged();
        }
        ProductLab prodlab = ProductLab.get(getApplicationContext());
        List<BUProduct> products1 = prodlab.getBUProducts(typeID);

        //Проверка Листа на пустоту - если лист пуст, отображается DiaPsy с фразой.
        mLayout.setVisibility((products1.size() > 0? View.GONE : View.VISIBLE));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prods);
        mLayout = findViewById(R.id.empty_layout);
        ProductRecycleView = (RecyclerView) findViewById(R.id.recycle_for_products);
        ProductRecycleView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        updateUI();
    }
    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
    @Override
    public void onPause() {
        super.onPause();
        updateUI();
    }
    private class ProductHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private BUProduct mBUProduct;
        private TextView mNameTV;
        private TextView mGramsForBUTV;

        public ProductHolder (LayoutInflater inflater, ViewGroup vg){
            super(inflater.inflate(R.layout.list_child_item_bumenu, vg, false));
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            mNameTV = (TextView) itemView.findViewById(R.id.product_name);
            mGramsForBUTV = (TextView) itemView.findViewById(R.id.product_weight);
        }
        public void bind(BUProduct prod) {
            mBUProduct = prod;
            if (mBUProduct.getTypeId() != 13 & mBUProduct.getTypeId()!= 14) {
                String title = getString(R.string.on_he, mBUProduct.getGrammsForBU());
                mGramsForBUTV.setText(title);
                mNameTV.setText(mBUProduct.getProductName());
            }
            else {
                String title = getString(R.string.he, mBUProduct.getGrammsForBU());
                mGramsForBUTV.setText(title);
                mNameTV.setText(mBUProduct.getProductName());
            }
        }
        @Override
        public void onClick (View view){
            //Элементы из меню кафе не должны нажиматься - порции уже посчитаны.
            if (mBUProduct.getTypeId() != 13 & mBUProduct.getTypeId()!= 14) {
                Intent intent = BUProdCalc.newIntentForProduct(getBaseContext(), mBUProduct.getGrammsForBU(), mBUProduct.getProductName());
                startActivity(intent);
            }
        }

        @Override
        public boolean onLongClick(View view) {
            //Изменить можно только свои продукты
            if (mBUProduct.getTypeId() == 1) {
                Intent intent = AddNewProductActivity.newIntent(getApplicationContext(), mBUProduct.getId(), mBUProduct.getTypeId());
                startActivity(intent);
            }
            return true;
        }
    }
    private class ProductAdapter extends RecyclerView.Adapter<ProductHolder>{
        private List<BUProduct> mBUProducts;
        public ProductAdapter(List<BUProduct> products) {
            mBUProducts = products;
        }

        @Override
        public ProductHolder onCreateViewHolder(ViewGroup vg, int viewtype){
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            return new ProductHolder(layoutInflater, vg);
        }
        @Override
        public void onBindViewHolder(ProductHolder holder, int pos){
            BUProduct prod = mBUProducts.get(pos);
            holder.bind(prod);
        }
        @Override
        public int getItemCount(){
            return mBUProducts.size();
        }
    }


}