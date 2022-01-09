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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BUProdCalc extends AppCompatActivity {
    private static final String EXTRA_PROD_NAME = "com.lossdemoss.android.dialog_dnevnick.product_name";
    private static final String EXTRA_PROD_GRAMS = "com.lossdemoss.android.dialog_dnevnick.product_grams";
    private String mEditedBU;
    private String mEditedGrams;
    private String mCalculatedBU;
    private String mCalculatedGrams;
    private BUProduct mBUProduct;
    private TextView mProductNameView;
    private TextView mGramsOnTitleView;
    private TextView mBUTextView;
    private TextView mGramsTextView;
    private EditText mBUEditText;
    private EditText mGramsEditText;
    private Button mCalcToBUBtn;
    private Button mCalcToGramsButton;

    //Метод, создающий интенту, которая передаёт данные о продукте в BUProdCalc
    public static Intent newIntentForProduct (Context packageContext, String grams, String name){
        Intent intent = new Intent(packageContext, BUProdCalc.class);
        intent.putExtra(EXTRA_PROD_GRAMS, grams);
        intent.putExtra(EXTRA_PROD_NAME, name);
        return intent;
    }
    private void updateUI(){
        //Передача "Граммов на Единицу" и названия продуктов в соответствующие TextView
        String mProductName = (String) getIntent().getSerializableExtra(EXTRA_PROD_NAME);
        mProductNameView.setText(mProductName);
        String mProductGrams = (String) getIntent().getSerializableExtra(EXTRA_PROD_GRAMS);
        mGramsOnTitleView.setText(mProductGrams + " г на ХЕ");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String mProductGrams = (String) getIntent().getSerializableExtra(EXTRA_PROD_GRAMS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buprod_calc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mProductNameView = (TextView) findViewById(R.id.product_name_textview);
        mGramsOnTitleView = (TextView) findViewById(R.id.product_grams_on_bu_textview);
        mBUEditText = (EditText) findViewById(R.id.bu_edit);
        mGramsEditText = (EditText) findViewById(R.id.grams_edit);
        mBUTextView = (TextView) findViewById(R.id.bu_view);
        mGramsTextView = (TextView) findViewById(R.id.grams_view);

        // Ввод Хлебных Едениц, на кол-во которых необходимо посчитать Граммы
        mBUEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mEditedBU = charSequence.toString();

            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        // Ввод Граммов, на кол-во которых необходимо посчитать Хлебные Еденицы
        mGramsEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mEditedGrams = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        updateUI();
        //Кнопка рассчёта. При нажатии проверяет кол-во грамм на еденицу и введёные граммы на NPE. Выводит результат в ХЕ в соответствующий TV.
        mCalcToBUBtn = (Button) findViewById(R.id.calc_to_bu_btn);
        mCalcToBUBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double mResultBUs;

                if (mEditedGrams != null && !mEditedGrams.isEmpty() && mProductGrams != null && !mProductGrams.isEmpty()){
                    mResultBUs = Double.valueOf(mEditedGrams)/Double.valueOf(mProductGrams);
                    mBUTextView.setText(String.valueOf(mResultBUs));
                } else {
                    mBUTextView.setText("Ошибка");
                }
            }
        });
        //Вторая кнопка рассчёта. При нажатии проверяет кол-во грамм на еденицу и введёные граммы на NPE. Выводит результат в граммах в соответствующий TV.
        mCalcToGramsButton = (Button) findViewById(R.id.calc_to_grams_btn);
        mCalcToGramsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double mResultBUs;

                if (mEditedBU != null && !mEditedBU.isEmpty() && mProductGrams != null && !mProductGrams.isEmpty()){
                    mResultBUs = Double.valueOf(mEditedBU)*Double.valueOf(mProductGrams);
                    mGramsTextView.setText(String.valueOf(mResultBUs));
                } else {
                    mGramsTextView.setText("Ошибка");
                }
            }
        });
    }
}
