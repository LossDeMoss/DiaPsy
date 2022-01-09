package com.lossdemoss.dialog_dnevnick;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.UUID;

public class AddNewProductActivity extends AppCompatActivity {
    private static final String EXTRA_PRODUCT_ID = "com.lossdemoss.android.dialog_dnevnick.product_id";
    private static final String EXTRA_PRODUCT_TYPE= "com.lossdemoss.android.dialog_dnevnick.product_type";
    private BUProduct mBUProduct;
    public EditText mProductNameET;
    public EditText mProductGramsET;
    public FloatingActionButton mOkFAB;
    public FloatingActionButton mDeleteFAB;

    public static Intent newIntent(Context packageContext, UUID product_id, int typeId){
        //Передача типа продукта и его Id из BUMenu или BUProductListFragment
        Intent intent = new Intent(packageContext, AddNewProductActivity.class);
        intent.putExtra(EXTRA_PRODUCT_ID, product_id);
        intent.putExtra(EXTRA_PRODUCT_TYPE, typeId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Передача данных непосредственно в продукт
        UUID productId = (UUID) getIntent().getSerializableExtra(AddNewProductActivity.EXTRA_PRODUCT_ID);
        int typeId = (int) getIntent().getSerializableExtra(AddNewProductActivity.EXTRA_PRODUCT_TYPE);
        mBUProduct = ProductLab.get(getApplicationContext()).getBUProduct(productId, typeId);

        setContentView(R.layout.add_new_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Поле ввода имени продукта
        mProductNameET = (EditText) findViewById(R.id.product_name_edittext);
        mProductNameET.setText(mBUProduct.getProductName());
        mProductNameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Отправка запроса на обновление продукта
                mBUProduct.setProductName(charSequence.toString());
                ProductLab.get(getApplicationContext()).updateProduct(mBUProduct);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                ProductLab.get(getApplicationContext()).updateProduct(mBUProduct);
            }
        });
        //Поле ввода граммов на ХЕ
        mProductGramsET = (EditText) findViewById(R.id.product_grams_on_bu_edittext);
        mProductGramsET.setText(mBUProduct.getGrammsForBU());
        mProductGramsET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Отправка запроса на обновление продукта
                mBUProduct.setGrammsForBU(charSequence.toString());
                ProductLab.get(getApplicationContext()).updateProduct(mBUProduct);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                ProductLab.get(getApplicationContext()).updateProduct(mBUProduct);
            }
        });
        //Подтверждение создания продукта
       mOkFAB = (FloatingActionButton) findViewById(R.id.product_ok_fab);
       mOkFAB.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();
           }
       });

         //Удаление продукта
        mDeleteFAB = (FloatingActionButton) findViewById(R.id.product_delete_fab);
        mDeleteFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductLab.get(getApplicationContext()).deleteProduct(mBUProduct);
                finish();
            }

        });
    }
}
