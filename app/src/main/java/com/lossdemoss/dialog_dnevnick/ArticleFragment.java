package com.lossdemoss.dialog_dnevnick;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.UUID;

/**
 * Created by LossDeMoss on 26.08.2018.
 */

public class ArticleFragment extends Fragment {
    private Article mArticle;

    //Фрагмент, "прокручивающий" текст статей

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        UUID atricleId = (UUID) getActivity().getIntent().getSerializableExtra(ArticleHoldingActivity.EXTRA_ARTICLE_ID);
        mArticle = ArticleLab.get(getActivity()).getArticle(atricleId);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.activity_scrolling, container, false);
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getActivity(), Psycology.class);
                startActivity(i);
            }
        });
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) v.findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle(mArticle.getTitleForToolbar());
        //Определение Tv,  в который упадёт текст статьи
        TextView LargeTextView = (TextView) v.findViewById(R.id.large_text_1);
        //Установка текста, он указывается в ArticleLab
        LargeTextView.setText(mArticle.getArticleTextId());

        ImageView mImageViewOnTollbar = (ImageView) v.findViewById(R.id.image_on_toolbar);
        mImageViewOnTollbar.setBackgroundResource(mArticle.getImgResId());
        return v;
    }
}
