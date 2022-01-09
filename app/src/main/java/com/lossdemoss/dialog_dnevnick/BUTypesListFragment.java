package com.lossdemoss.dialog_dnevnick;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LossDeMoss on 23.10.2018.
 */

public class BUTypesListFragment extends Fragment{
    public RecyclerView mTypesRecyclerView;
    private TypeAdapter mTypeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_bu_list, container, false);
        mTypesRecyclerView = (RecyclerView) view.findViewById(R.id.types_recycler_view);
        mTypesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }
    private void updateUI(){
        BUTypeLab typeLab = BUTypeLab.get(getActivity());
        List<BUType> types = typeLab.getBUTypes();
        mTypeAdapter = new TypeAdapter(types);
        mTypesRecyclerView.setAdapter(mTypeAdapter);
    }
    private class TypeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private BUType mType;
        private TextView mNameTV;
        public TypeHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_parent_item_bumenu, parent, false ));
            mNameTV = (TextView) itemView.findViewById(R.id.type_of_product);
            itemView.setOnClickListener(this);
        }
        public void bind (BUType type){
            mType = type;
            mNameTV.setText(mType.getName());
        }
        @Override
        public void onClick(View view){
            Intent intent = ProductListActivity.newIntentbyType(getActivity(), mType.getId());
            startActivity(intent);
        }
    }
    private class TypeAdapter extends RecyclerView.Adapter<TypeHolder> {

        private List<BUType> mBUTypes;

        public TypeAdapter(List<BUType> BUTypes){
            mBUTypes = BUTypes;
        }
        @Override
        public TypeHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new TypeHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(TypeHolder holder, int position){
            BUType type = mBUTypes.get(position);
            holder.bind(type);
        }
        @Override
        public int getItemCount(){
            return mBUTypes.size();
        }
    }
}
