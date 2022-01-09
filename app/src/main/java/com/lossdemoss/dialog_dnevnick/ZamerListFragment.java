package com.lossdemoss.dialog_dnevnick;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by LossDeMoss on 01.08.2018.
 */

public class ZamerListFragment extends Fragment{
    //Фрагмент предоставляет список всех замеров за всё время. После появления вывода информации в CSV будет возможность удалять замеры блоками.



    private RecyclerView mZamerRecycleView;
    private ZamerAdapter mAdapter;
    private View mLayout;
    private SimpleDateFormat mDateFormat;


    private static DateFormatSymbols myDateFormatSymbols = new DateFormatSymbols(){
        @Override
        public String[] getMonths() {
            return new String[]{"Января", "Февраля", "Марта", "Апреля", "Мая", "Июня",
                    "Июля", "Августа", "Сентября", "Октября", "Ноября", "Декабря"};
        }

    };

    private class ZamerAdapter extends RecyclerView.Adapter<ZamerHolder>{
        private List<Zamer> mZamers;
        private ZamerAdapter(List<Zamer> zamers) {
            mZamers = zamers;
        }

        @Override
        public ZamerHolder  onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new ZamerHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(ZamerHolder holder, int position){
            Zamer zamer = mZamers.get(position);
            holder.bind(zamer);
        }

        @Override
        public int getItemCount() {
            return mZamers.size();
        }

        public void setZamers(List<Zamer> zamers) {
            mZamers = zamers;
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_zamer_list, container, false);
        mZamerRecycleView = (RecyclerView) view.findViewById(R.id.zamer_recycler_view);
        mZamerRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mLayout = view.findViewById(R.id.empty_layout);
        updateUI();
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_zamer_list, menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Добаление нового замера в базу.
            switch (item.getItemId()){
                case R.id.new_zamer:
                    Zamer zamer = new Zamer();
                    ZamerLab.get(getActivity()).addZamer(zamer);
                    Intent intent = ZamerPagerActivity.newIntent(getActivity(), zamer.getId());
                    startActivity(intent);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
    }


    private void updateUI(){
        ZamerLab zamerlab = ZamerLab.get(getActivity());
        List<Zamer> zamers = zamerlab.getSortedZamers();

        mLayout.setVisibility((zamers.size() > 0? View.GONE : View.VISIBLE));

        if (mAdapter == null) {
            mAdapter = new ZamerAdapter(zamers);
            mZamerRecycleView.setAdapter(mAdapter);
        }else{
            mAdapter.setZamers(zamers);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class ZamerHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //Отображение элемента списка
        private Zamer mZamer;
        private TextView mBloodView;
        private TextView mInsulView;
        private TextView mBreadView;
        private TextView mLongInsulView;
        private TextView mTypeView;
        private TextView mDateView;


        private ZamerHolder(LayoutInflater inflater, ViewGroup parent){

            super(inflater.inflate(R.layout.list_item_zamer, parent, false));
            itemView.setOnClickListener(this);
            mBloodView = (TextView) itemView.findViewById(R.id.blood_show);
            mInsulView = (TextView) itemView.findViewById(R.id.insul_show);
            mBreadView = (TextView) itemView.findViewById(R.id.bread_show);
            mLongInsulView = (TextView) itemView.findViewById(R.id.long_insulin_show);
            mDateView = (TextView) itemView.findViewById(R.id.zamer_date);
            mTypeView = (TextView) itemView.findViewById(R.id.zamer_type_show);
        }
        @Override
        public void onClick(View view) {
            //Изменение замера
            Intent intent = ZamerPagerActivity.newIntent(getActivity(), mZamer.getId());
            startActivity(intent);
        }
        public void bind(Zamer zamer) {
            mDateFormat = new SimpleDateFormat("HH:mm:ss d MMMM, EEEE", myDateFormatSymbols );
            mZamer = zamer;
            mLongInsulView.setText(mZamer.getLIU());
            mBloodView.setText(mZamer.getBS());
            mInsulView.setText(mZamer.getIU());
            mBreadView.setText(mZamer.getBU());
            mDateView.setText(mDateFormat.format(mZamer.getDate()));
            mTypeView.setText(mZamer.getTypeOfEating());
        }
    }


    }


