package com.lossdemoss.dialog_dnevnick;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by LossDeMoss on 26.08.2018.
 */

public class ArticleLab {
        //Класс содержит массив данных статей
        private static ArticleLab sArticleLab;

        private  List<Article> mArticles;

        public static ArticleLab get(Context context) {
            if (sArticleLab==null) {
                sArticleLab = new ArticleLab(context);
            }
            return sArticleLab;
        }
        private  ArticleLab(Context context){
            //Создание, инициализация и добавление статей в массив
            mArticles = new ArrayList<>();
                Article article1 = new Article(R.drawable.illustration1,"Процесс принятия диабета происходит постепенно и занимает примерно год. Путь принятия никогда не бывает легким. Только пройдя через определенные эмоциональные этапы...",R.string._1_1,"Как принять диабет?");
                Article article2 = new Article(R.drawable.illustration2, "Возможно, узнав о своем диабете, ты испытал целый спектр чувств от растерянности и неверия, до злости, гнева, бессилия, обиды. Твои чувства естественны. Человек так устроен...",R.string._2_1, "Почему Я?");
                Article article3 = new Article(R.drawable.illustration3, "Это непростой вопрос, особенно когда ты только узнал про диабет. Говорить о диабете в школе, друзьям, родственникам?..", R.string._3_1, "Стоит ли скрывать диабет от окружающих?");
                Article article4 = new Article(R.drawable.illustration4,"Как ты думаешь, на что обращают внимание окружающие люди, когда ты собираешься сообщить им нечто важное? В своей...", R.string._4_1, "Как сказать о своём диабете?");
                Article article5 = new Article(R.drawable.illustration5,"Все люди, даже не имея диабета, время от времени устают, это абсолютно нормально. Что говорить, если тебе необходимо 3-4 раза в день делать инъекции, 5-8 раз колоть пальцы и изм...",R.string._5_1, "Если ты устал...");
                Article article6 = new Article(R.drawable.illustration6,"Я понимаю тебя. Тяжело, когда есть диабет и он присутствует в твоей жизни 24 часа в сутки... Дети и взрослые во всём мире очень хотели бы, чтобы диабета не было вовсе. До того...",R.string._6_1, "Свобода - разумная ответственность.");
                Article article7 = new Article(R.drawable.illustration7,"Диабет возникает независимо от наших поступков, воли и желания. Не пытайся найти виноватых или винить себя...", R.string._7_1, "Рецепт на каждый день");
                mArticles.add(article1);
                mArticles.add(article2);
                mArticles.add(article3);
                mArticles.add(article4);
                mArticles.add(article5);
                mArticles.add(article6);
                mArticles.add(article7);
        }
        //Возвращает все статьи
        public List<Article> getArticles() {
            return  mArticles;
        }

        //Возвращает статью по UUID
        public  Article getArticle(UUID id) {
            for (Article article : mArticles) {
                if (article.getId().equals(id)) {
                    return article;
                }
            }
            return null;
        }


}
