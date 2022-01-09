package com.lossdemoss.dialog_dnevnick;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by LossDeMoss on 27.10.2018.
 */

public class SplashPhrasesLab {
    private static SplashPhrasesLab mSplashPhrasesLab;

    private List<SplashPhrase> mSplashes;

    public static SplashPhrasesLab get(Context context){
        if (mSplashPhrasesLab==null) {
            mSplashPhrasesLab = new SplashPhrasesLab(context);
        }
        return mSplashPhrasesLab;
    }
    public SplashPhrasesLab(Context context){
        mSplashes = new ArrayList<>();
        //Массив заготовленных фраз для SplashActivity
        SplashPhrase splashPhrase1 = new SplashPhrase(1, "Успех - это сумма небольших усилий, повторяющихся изо дня в день.");
        SplashPhrase splashPhrase2 = new SplashPhrase(2, "Чтобы дойти до цели, нужно идти.");
        SplashPhrase splashPhrase3 = new SplashPhrase(3, "Это своего рода забава, делать невозможное.");
        SplashPhrase splashPhrase4 = new SplashPhrase(4, "Кто хочет – ищет возможности. Кто не хочет – ищет причины. ");
        SplashPhrase splashPhrase5 = new SplashPhrase(5, "Будь собой! Прочие роли уже заняты. ");
        SplashPhrase splashPhrase6 = new SplashPhrase(6, "Жизнь — как вождение велосипеда. Чтобы сохранить равновесие, ты должен двигаться. ");
        SplashPhrase splashPhrase7 = new SplashPhrase(7, "Секрет успешной жизни — это понять, что вам предназначено делать, и делать это.");
        SplashPhrase splashPhrase8 = new SplashPhrase(8, "Мы сами должны стать теми переменами, которые хотим видеть в мире.");
        SplashPhrase splashPhrase9 = new SplashPhrase(9, "Любое достижение начинается с решения попробовать.");
        SplashPhrase splashPhrase10 = new SplashPhrase(10, "Даже трудности в жизни для чего-то нужны.");
        SplashPhrase splashPhrase11 = new SplashPhrase(11, "Сделай шаг, и дорога появится сама собой.");
        SplashPhrase splashPhrase12 = new SplashPhrase(12, "Наиболее верный путь к успеху - всё время пробовать ещё один раз.");
        SplashPhrase splashPhrase13 = new SplashPhrase(13, "Никогда не теряй терпения - это последний ключ, открывающий двери.");
        SplashPhrase splashPhrase14 = new SplashPhrase(14, "Самая чистая вода бывает в тех источниках, в которых она пробивается сквозь препятствия.");
        SplashPhrase splashPhrase15 = new SplashPhrase(15, "Сила характера - не в умении пробивать стены, а в умении находить двери.");
        SplashPhrase splashPhrase16 = new SplashPhrase(16, "Чтобы увидеть радугу, нужно пережить дождь.");
        SplashPhrase splashPhrase17 = new SplashPhrase(17, "Жизнь - это искусство извлекать значительные выгоды из незначительных обстоятельств.");
        SplashPhrase splashPhrase18 = new SplashPhrase(18, "Человек способен сделать путь великим, но великим человека делает путь.");
        SplashPhrase splashPhrase19 = new SplashPhrase(19, "Главное в этом мире не то, где мы стоим, а в том, в каком направлении мы движемся.");
        SplashPhrase splashPhrase20 = new SplashPhrase(20, "Ложный шаг не раз приводил к открытию новых дорог.");
        SplashPhrase splashPhrase21 = new SplashPhrase(21, "Всегда выбирайте самый трудный путь - там вы не встретите конкурентов.");
        SplashPhrase splashPhrase22 = new SplashPhrase(22, "Искусство быть счастливым заключается в способности находить счастье в простых вещах.");
        SplashPhrase splashPhrase23 = new SplashPhrase(23, "Быть героем - значит сражаться против всесильной судьбы.");
        SplashPhrase splashPhrase24 = new SplashPhrase(24, "Будущее всегда начинается сейчас.");
        SplashPhrase splashPhrase25 = new SplashPhrase(25, "Истинные ценности всегда поддерживают жизнь, поскольку ведут к свободе и росту.");


        mSplashes.add(splashPhrase1);
        mSplashes.add(splashPhrase2);
        mSplashes.add(splashPhrase3);
        mSplashes.add(splashPhrase4);
        mSplashes.add(splashPhrase5);
        mSplashes.add(splashPhrase6);
        mSplashes.add(splashPhrase7);
        mSplashes.add(splashPhrase8);
        mSplashes.add(splashPhrase9);
        mSplashes.add(splashPhrase10);
        mSplashes.add(splashPhrase11);
        mSplashes.add(splashPhrase12);
        mSplashes.add(splashPhrase13);
        mSplashes.add(splashPhrase14);
        mSplashes.add(splashPhrase15);
        mSplashes.add(splashPhrase16);
        mSplashes.add(splashPhrase17);
        mSplashes.add(splashPhrase18);
        mSplashes.add(splashPhrase19);
        mSplashes.add(splashPhrase20);
        mSplashes.add(splashPhrase21);
        mSplashes.add(splashPhrase22);
        mSplashes.add(splashPhrase23);
        mSplashes.add(splashPhrase24);
        mSplashes.add(splashPhrase25);


    }
    public List<SplashPhrase> getSplashPhrases(){
        return mSplashes;
    }

    public SplashPhrase getPhrase (int id){
        for(SplashPhrase phrase : mSplashes){
            if (phrase.getId() == id){
                return phrase;
            }
        }
        return null;
    }
}
