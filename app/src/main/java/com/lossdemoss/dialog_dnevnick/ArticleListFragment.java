package com.lossdemoss.dialog_dnevnick;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LossDeMoss on 27.08.2018.
 */

public class ArticleListFragment extends Fragment {
    //Фрагмент, содержащий RecyclerView и Adapter, инфлатируется активностью Psychology
    private RecyclerView mArticleRecyclerView;
    private ArticleAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_article_list, container, false);
        mArticleRecyclerView = (RecyclerView) view.findViewById(R.id.article_recycler_view);
        mArticleRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI(){
        // Передача листа с определением статей в адаптер
        ArticleLab articleLab = ArticleLab.get(getActivity());
        List<Article> articles = articleLab.getArticles();
        mAdapter = new ArticleAdapter(articles);
        mArticleRecyclerView.setAdapter(mAdapter);
    }

    private class ArticleHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //Элемент спсиска, нажатие активирует ArticleHoldingActivity и инфлатацию ArticleFragment
        private Article mArticle;
        private TextView mTitleTextView;
        private ImageView mImageView;

        public ArticleHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_article, parent, false));
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.findViewById(R.id.article_about);
            mImageView = (ImageView) itemView.findViewById(R.id.ivImage);
        }
        @Override
        public void onClick(View view) {
            //Передача данных, переход к ArticleHoldingActivity
            Intent intent = ArticleHoldingActivity.newIntent(getActivity(), mArticle.getId());
            startActivity(intent);

        }

        public void bind(Article article){
            //Привязка элементов
            mArticle = article;
            mTitleTextView.setText(mArticle.getTitle());
            mImageView.setImageResource(mArticle.getImgResId());
        }
    }

    private class ArticleAdapter extends RecyclerView.Adapter<ArticleHolder>{

        private List<Article> mArticles;

        public ArticleAdapter(List<Article> articles){
            mArticles = articles;
        }

        @Override
        public ArticleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //Инфлатация layout-ов элементов спсиска
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new ArticleHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ArticleHolder holder, int position) {
        Article article = mArticles.get(position);
        holder.bind(article);
        }

        @Override
        public int getItemCount() {
            return mArticles.size();
        }
    }
}
