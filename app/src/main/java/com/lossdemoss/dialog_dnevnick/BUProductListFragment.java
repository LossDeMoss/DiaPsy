package com.lossdemoss.dialog_dnevnick;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;;import java.util.ArrayList;
import java.util.List;

/**
 * Created by LossDeMoss on 04.11.2018.
 */

public class BUProductListFragment extends Fragment {
    //Фрагмент, содержащий RecyclerView и Adapter, инфлатируется активностью ProductListActivity, создаёт список продуктов отдельного типа.
    //Сейчас фрагмент дорабатывается для корректной работы поиска по массиву.
    public RecyclerView ProductRecycleView;
    public ProductAdapter mProductAdapter;
    public ProductLab prodLab;
    public LinearLayout mLayout;
    private List<BUProduct> publishList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_prods, container, false);
        ProductRecycleView = (RecyclerView) view.findViewById(R.id.recycle_for_products);
        ProductRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mLayout = view.findViewById(R.id.empty_layout);
        prodLab = ProductLab.get(getContext());
        List<BUProduct> products = prodLab.getAllBUProducts();
        mProductAdapter = new ProductAdapter(products);
        ProductRecycleView.setAdapter(mProductAdapter);
        return view;
    }



    private class ProductHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private BUProduct mBUProduct;
        private TextView mNameTV;
        private TextView mGramsForBUTV;

        public ProductHolder (LayoutInflater inflater, ViewGroup vg){
            //Создание элемсента списка
            super(inflater.inflate(R.layout.list_child_item_bumenu, vg, false));
            itemView.setOnClickListener(this);
            mNameTV = (TextView) itemView.findViewById(R.id.product_name);
            mGramsForBUTV = (TextView) itemView.findViewById(R.id.product_weight);
        }
        public void bind(BUProduct prod) {
            mBUProduct = prod;
            String title = getString(R.string.on_he, mBUProduct.getGrammsForBU());
            mGramsForBUTV.setText(title);
            mNameTV.setText(mBUProduct.getProductName());
        }
        @Override
        public void onClick (View view){
            //Интенка передающая граммы и имя продукта в BUProdCalc
            Intent intent = BUProdCalc.newIntentForProduct(getContext(), mBUProduct.getGrammsForBU(), mBUProduct.getProductName());
            startActivity(intent);
        }
    }
    public class ProductAdapter extends RecyclerView.Adapter <BUProductListFragment.ProductHolder> implements Filterable{
        //Включена имплементация Filtrable для настройки поиска
        private List<BUProduct> mBUProducts;
        public ProductAdapter(List<BUProduct> products) {
            mBUProducts = products;
        }

        @Override
        public BUProductListFragment.ProductHolder onCreateViewHolder(ViewGroup vg, int viewtype){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            return new ProductHolder(layoutInflater, vg);
        }
        @Override
        public void onBindViewHolder(BUProductListFragment.ProductHolder holder, int pos){
            BUProduct prod = mBUProducts.get(pos);
            holder.bind(prod);
        }
        @Override
        public int getItemCount(){
            return mBUProducts.size();
        }

        @Override
        public Filter getFilter() {
            return productFilter;
        }
        private Filter productFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                List<BUProduct> filteredlist = new ArrayList<>();
                if (charSequence == null || charSequence.length()==0){
                    ProductLab prodLab = ProductLab.get(getContext());
                    List<BUProduct> products = prodLab.getAllBUProducts();
                } else {
                    String filterPattern = charSequence.toString().toLowerCase().trim();
                    for (BUProduct prod : prodLab.getAllBUProducts()){
                        if (prod.getProductName().toLowerCase().contains(filterPattern)){
                            filteredlist.add(prod);
                        }
                    }
                }
                FilterResults results = new FilterResults();
                results.values = filteredlist;
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                publishList.clear();
                publishList.addAll((List)filterResults.values);
            }
        };
    }
    //Обновление списка при поиске
    public void updateSearchResults(String query){
        ProductLab prodLab = ProductLab.get(getContext());
        List<BUProduct> products = prodLab.provideSearchResult(query);
        ProductAdapter mProductAdapter = new ProductAdapter(products);
        ProductRecycleView.setAdapter(mProductAdapter);
    }
}
