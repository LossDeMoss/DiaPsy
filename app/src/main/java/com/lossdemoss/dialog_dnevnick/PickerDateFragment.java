package com.lossdemoss.dialog_dnevnick;

import android.support.v4.app.DialogFragment;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by LossDeMoss on 05.10.2018.
 */

public abstract class PickerDateFragment extends DialogFragment {
    //Фрагмент выбора времени
    private static final String ARG_DATE = "date";
    public static final String EXTRA_DATE = "com.lossdemoss.dialog_dnevnick.date";

    protected Calendar mCalendar;

    protected abstract View initLayout();
    protected abstract Date getDate();

    protected static Bundle getArgs(Date date) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_DATE, date);
        return args;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Date date = (Date) getArguments().getSerializable(ARG_DATE);
        mCalendar = Calendar.getInstance();
        mCalendar.setTime(date);

        View v = initLayout();

        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.date_picker_title)
                .setView(v)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Date date = getDate();
                        sendResult(Activity.RESULT_OK, date);
                    }
                })
                .create();
    }

    //Отправка результата выбора.
    private void sendResult(int resultCode, Date date) {
        if (getTargetFragment() == null)
            return;

        Intent intent = new Intent();
        intent.putExtra(EXTRA_DATE, date);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }
}
