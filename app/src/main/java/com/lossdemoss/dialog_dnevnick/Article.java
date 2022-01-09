package com.lossdemoss.dialog_dnevnick;

import java.util.UUID;

/**
 * Created by LossDeMoss on 26.08.2018.
 */

public class Article {
    //Определение статьи - ID, Ресурс картинки из R, Ресурс строк из Strings, Заголовок - небольшое описание


    public int mArticleTextId;
    public int mImgResId;
    public UUID mId;
    public String Title;
    public String mTitleForToolbar;

    public Article(int mImgResId, String title, int TextId, String mTitleForToolbar){
        mId = UUID.randomUUID();
        this.mImgResId = mImgResId;
        this.Title = title;
        this.mArticleTextId = TextId;
        this.mTitleForToolbar = mTitleForToolbar;
    }

    public String getTitleForToolbar() {
        return mTitleForToolbar;
    }

    public void setTitleForToolbar(String titleForToolbar) {
        mTitleForToolbar = titleForToolbar;
    }

    public int getArticleTextId() {
        return mArticleTextId;
    }

    public void setArticleTextId(int articleTextId) {
        mArticleTextId = articleTextId;
    }

    public int getImgResId() {
        return mImgResId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

}

