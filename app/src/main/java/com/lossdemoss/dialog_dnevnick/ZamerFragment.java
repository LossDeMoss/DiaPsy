package com.lossdemoss.dialog_dnevnick;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.PopupMenu;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by LossDeMoss on 30.07.2018.
 */

public class ZamerFragment extends Fragment implements PopupMenu.OnMenuItemClickListener{

    private static final String ARG_ZAMER_ID = "zamer_id";
    private static final String DIALOG_DATE = "DialogDate";
    private static final String DIALOG_TIME = "DialogTime";
    private static final int REQUEST_TIME = 1;
    private static final int REQUEST_DATE = 0;

    private Zamer mZamer;
    private Button typeBtn;
    private EditText mBSField;
    private EditText mIUField;
    private EditText mBUField;
    private EditText mLIUField;
    private Button mDateButton;
    private Button mTimeButton;
    private FloatingActionButton mDelFab;
    private FloatingActionButton mOKFab;
    private TextView mDateView;
    private SimpleDateFormat mDateFormat;


    private static DateFormatSymbols myDateFormatSymbols = new DateFormatSymbols(){
        @Override
        public String[] getMonths() {
            return new String[]{"Января", "Февраля", "Марта", "Апреля", "Мая", "Июня",
                    "Июля", "Августа", "Сентября", "Октября", "Ноября", "Декабря"};
        }

    };

//Интента для перехода из ZamerListActivity
    public static ZamerFragment newInstance(UUID zamerId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_ZAMER_ID, zamerId);
        ZamerFragment fragment = new ZamerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID zamerId = (UUID) getArguments().getSerializable(ARG_ZAMER_ID);
        mZamer = ZamerLab.get(getActivity()).getZamer(zamerId);
    }

    @Override
    //Дополнительная информация о замере вводится при помощи pop-up меню.
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.before:
                typeBtn.setText(R.string.before);
                mZamer.setTypeOfEating("До еды");
                return true;
            case R.id.after:
                typeBtn.setText(R.string.after);
                mZamer.setTypeOfEating("После еды");
                return true;
            case R.id.sleep:
                typeBtn.setText(R.string.sleep);
                mZamer.setTypeOfEating("Сон");
                return true;
            case R.id.activity:
                typeBtn.setText(R.string.active);
                mZamer.setTypeOfEating("Активность");
                return true;
            case R.id.empty:
                typeBtn.setText(R.string.selecttype);
                mZamer.setTypeOfEating("");
        }
        return false;
    }

    public void showPopup(View view){
        PopupMenu popupMenu = new PopupMenu(getActivity(), view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_zamer_fragment);
        popupMenu.show();
    }

    @Override
    public void onResume(){
        super.onResume();
        ZamerLab.get(getActivity()).updateZamer(mZamer);
    }

    @Override
    public void onPause(){
        super.onPause();
        ZamerLab.get(getActivity()).updateZamer(mZamer);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_zamer, container, false);

        typeBtn = (Button) v.findViewById(R.id.typeBtn);
        typeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });

        //Поле ввода для Сахара крови
        mBSField = (EditText) v.findViewById(R.id.blood);

        mBSField.setText(mZamer.getBS());
        mBSField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Здесь и далее - обновление замера
                ZamerLab.get(getActivity()).updateZamer(mZamer);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mZamer.setBS(charSequence.toString());
                ZamerLab.get(getActivity()).updateZamer(mZamer);



            }

            @Override
            public void afterTextChanged(Editable editable) {
                ZamerLab.get(getActivity()).updateZamer(mZamer);

            }
        });
        //Поле ввода для Длинного инсулина
        mLIUField = (EditText) v.findViewById(R.id.long_insulin);
        mLIUField.setText(mZamer.getLIU());

            mLIUField.setEnabled(true);
            mLIUField.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    mZamer.setLIU(charSequence.toString());
                }

                @Override
                public void afterTextChanged(Editable editable) {
                }
            });

        //Поле ввода для Короткого инсулина
        mIUField = (EditText) v.findViewById(R.id.insulin);
        mIUField.setText(mZamer.getIU());
        mIUField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mZamer.setIU(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        //Поле ввода для Хлебных единиц
        mBUField = (EditText) v.findViewById(R.id.bread);
        mBUField.setText(mZamer.getBU());
        mBUField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mZamer.setBU(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        mDateView = (TextView) v.findViewById(R.id.date_view);

        mDateButton = (Button) v.findViewById(R.id.zamer_date);
        updateDate();
        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Вызов диалога выбора времени
                TimePickerFragment dialog = TimePickerFragment.newInstance(mZamer.getDate());
                FragmentManager manager = getFragmentManager();
                dialog.setTargetFragment(ZamerFragment.this, REQUEST_TIME);
                dialog.show(manager, DIALOG_TIME);
            }
        });

        mTimeButton = (Button) v.findViewById(R.id.zamer_time);
        updateDate();
        mTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment dialog = DatePickerFragment.newInstance(mZamer.getDate());
                FragmentManager manager = getFragmentManager();
                dialog.setTargetFragment(ZamerFragment.this, REQUEST_DATE);
                dialog.show(manager, DIALOG_DATE);
            }
        });
        //Удаление замера
        mDelFab = (FloatingActionButton) v.findViewById(R.id.zamer_delete_fab);
        mDelFab.setBackgroundColor(Color.rgb(255, 82, 82));
        mDelFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UUID mZamerId = mZamer.getId();
                ZamerLab.get(getActivity()).deleteZamer(mZamerId);
                getActivity().finish();
            }
        });
        //Сохранение замера
        mOKFab = (FloatingActionButton) v.findViewById(R.id.zamer_ok_fab);
        mOKFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
        return v;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK)
            return;

        //Когда активность сворачивается, дата обновляется.

        Date date = (Date) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
        mZamer.setDate(date);

        switch (requestCode) {
            case REQUEST_DATE:
                updateDate();
                break;
            case REQUEST_TIME:
                updateDate();
                break;
        }
    }

    private void updateDate() {
        mDateFormat = new SimpleDateFormat("HH:mm:ss d MMMM, EEEE", myDateFormatSymbols );
        mDateView.setText(mDateFormat.format(mZamer.getDate()));
        mZamer.setYesterday(mZamer.getDate().getTime() - 86400000);
    }
}

