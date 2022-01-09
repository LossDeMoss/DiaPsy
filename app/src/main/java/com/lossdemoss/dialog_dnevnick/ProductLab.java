package com.lossdemoss.dialog_dnevnick;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lossdemoss.dialog_dnevnick.productdatabase.ProductBaseHelper;
import com.lossdemoss.dialog_dnevnick.productdatabase.ProductCursorWrapper;
import com.lossdemoss.dialog_dnevnick.productdatabase.ProductDBSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by LossDeMoss on 25.10.2018.
 */

public class ProductLab{
    private static ProductLab mBUProductLab;

    private List<BUProduct> mBUProductsByType;
    private List<BUProduct> mBUProducts;
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private ProductCursorWrapper queryProducts(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                ProductDBSchema.ProductTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        return new ProductCursorWrapper(cursor);
    }
    public static ProductLab get(Context context){
        if (mBUProductLab==null) {
            mBUProductLab = new ProductLab(context);
        }
        return mBUProductLab;
    }
    private ProductLab(Context context){
        //Создание встроенного массива продуктов
        mContext = context.getApplicationContext();
        mDatabase = new ProductBaseHelper(mContext).getWritableDatabase();
        mBUProducts = new ArrayList<>();
        BUProduct myProduct1 = new BUProduct(1, "Мамин пирог", "100");
        BUProduct buProd1 = new BUProduct(2,"Хлеб ржаной формовой", "25");
        BUProduct buProd2 = new BUProduct(2,"Хлеб столовый формовой", "20");
        BUProduct buProd3 = new BUProduct(2,"Батон белковоотрубной", "65");
        BUProduct buProd4 = new BUProduct(2,"Батон нарезной", "20");
        BUProduct buProd5 = new BUProduct(2,"Булочка сдоба", "20");
        BUProduct buProd6 = new BUProduct(2,"Крекеры", "15");
        BUProduct buProd7 = new BUProduct(2,"Мука (любая) и панировка", "15");
        BUProduct buProd8 = new BUProduct(3,"Вермишель, лапша, макароны", "50");
        BUProduct buProd9 = new BUProduct(3,"Гречка отварная", "50");
        BUProduct buProd10 = new BUProduct(3,"Кукуруза (початок)", "100");
        BUProduct buProd11 = new BUProduct(3,"Кукуруза консервированная", "60");
        BUProduct buProd12 = new BUProduct(3,"Кукурузные хлопья", "15");
        BUProduct buProd13 = new BUProduct(3,"Попкорн", "15");
        BUProduct buProd14 = new BUProduct(3,"Манная каша", "50");
        BUProduct buProd15 = new BUProduct(3,"Овсяная каша", "50");
        BUProduct buProd16 = new BUProduct(3,"Овсяные хлопья", "50");
        BUProduct buProd17 = new BUProduct(3,"Перловая каша", "50");
        BUProduct buProd18 = new BUProduct(3,"Пшеная каша", "50");
        BUProduct buProd19 = new BUProduct(3,"Рисовая каша", "50");
        BUProduct buProd20 = new BUProduct(4,"Морковь", "200");
        BUProduct buProd21 = new BUProduct(4,"Свекла", "150");
        BUProduct buProd22 = new BUProduct(4,"Бобы сухие", "20");
        BUProduct buProd23 = new BUProduct(4,"Горох свежий", "100");
        BUProduct buProd24 = new BUProduct(4,"Фасоль варёная", "50");
        BUProduct buProd25 = new BUProduct(4,"Карофель варёный", "75");
        BUProduct buProd26 = new BUProduct(4,"Карофельное пюре", "90");
        BUProduct buProd27 = new BUProduct(4,"Жареный картофель", "35");
        BUProduct buProd28 = new BUProduct(4,"Чипсы", "25");
        BUProduct buProd29 = new BUProduct(4,"Дыня Колхозница", "280");
        BUProduct buProd30 = new BUProduct(4,"Дыня Торпеда", "100");
        BUProduct buProd31 = new BUProduct(5,"Грибы белые, свежие", "625");
        BUProduct buProd32 = new BUProduct(5,"Грибы сушёные", "100");
        BUProduct buProd33 = new BUProduct(6,"Абрикосы", "110");
        BUProduct buProd34 = new BUProduct(6,"Арбуз без корки", "240");
        BUProduct buProd35 = new BUProduct(6,"Брусника", "140");
        BUProduct buProd36 = new BUProduct(6,"Виноград", "70");
        BUProduct buProd37 = new BUProduct(6,"Вишня с косточкой", "90");
        BUProduct buProd38 = new BUProduct(6,"Груша", "90");
        BUProduct buProd39 = new BUProduct(6,"Ежевика", "140");
        BUProduct buProd40 = new BUProduct(6,"Клубника, земляника", "160");
        BUProduct buProd41 = new BUProduct(6,"Крыжовник", "120");
        BUProduct buProd42 = new BUProduct(6,"Малина", "160");
        BUProduct buProd43 = new BUProduct(6,"Персик", "120");
        BUProduct buProd44 = new BUProduct(6,"Сливы", "90");
        BUProduct buProd45 = new BUProduct(6,"Смородина", "120");
        BUProduct buProd46 = new BUProduct(6,"Хурма", "70");
        BUProduct buProd47 = new BUProduct(6,"Черника", "90");
        BUProduct buProd48 = new BUProduct(6,"Яблоко", "90");
        BUProduct buProd49 = new BUProduct(7,"Изюм", "15");
        BUProduct buProd50 = new BUProduct(7,"Черонослив", "20");
        BUProduct buProd51 = new BUProduct(7,"Инжир сушёный", "20");
        BUProduct buProd52 = new BUProduct(7,"Финик сушёный", "15");
        BUProduct buProd53 = new BUProduct(8,"Айва", "140");
        BUProduct buProd54 = new BUProduct(8,"Ананас", "140");
        BUProduct buProd55 = new BUProduct(8,"Апельсин", "150");
        BUProduct buProd56 = new BUProduct(8,"Банан", "70");
        BUProduct buProd57 = new BUProduct(8,"Гранат", "170");
        BUProduct buProd58 = new BUProduct(8,"Грейп-фрут", "170");
        BUProduct buProd59 = new BUProduct(8,"Инжир", "80");
        BUProduct buProd60 = new BUProduct(8,"Киви", "110");
        BUProduct buProd61 = new BUProduct(8,"Манго", "110");
        BUProduct buProd62 = new BUProduct(8,"Мандарин", "150");
        BUProduct buProd63 = new BUProduct(9,"Лимонный свежевыжатый", "140");
        BUProduct buProd64 = new BUProduct(9,"Грейп-фрутовый свежевыжатый", "90");
        BUProduct buProd65 = new BUProduct(9,"Мандариновый свежевыжатый", "100");
        BUProduct buProd66 = new BUProduct(9,"Апельсиновый свежевыжатый", "100");
        BUProduct buProd67 = new BUProduct(9,"Яблочный свежевыжатый", "90");
        BUProduct buProd68 = new BUProduct(9,"Ананасовый свежевыжатый", "85");
        BUProduct buProd69 = new BUProduct(9,"Вишнёвый свежевыжатый", "80");
        BUProduct buProd70 = new BUProduct(9,"Смородиновый свежевыжатый", "75");
        BUProduct buProd71 = new BUProduct(9,"Томатный свежевыжатый", "200");
        BUProduct buProd72 = new BUProduct(9,"Морковный свежевыжатый", "200");
        BUProduct buProd73 = new BUProduct(10,"Кешью", "50");
        BUProduct buProd74 = new BUProduct(10,"Кедровые", "60");
        BUProduct buProd75 = new BUProduct(10,"Арахис", "75");
        BUProduct buProd76 = new BUProduct(10,"Семечки тыквенные", "60");
        BUProduct buProd77 = new BUProduct(10,"Миндаль", "60");
        BUProduct buProd78 = new BUProduct(10,"Фисташки", "60");
        BUProduct buProd79 = new BUProduct(10,"Грецкие орехи", "60");
        BUProduct buProd80 = new BUProduct(11,"Молоко обезжиренное", "210");
        BUProduct buProd81 = new BUProduct(11,"Молоко сухое", "25");
        BUProduct buProd82 = new BUProduct(11,"Йогурт натуральный", "200");
        BUProduct buProd83 = new BUProduct(12,"Сахар песок", "10");
        BUProduct buProd84 = new BUProduct(12,"Сахар кусковой", "10");
        BUProduct buProd85 = new BUProduct(12,"Газированная вода на сахаре", "100");
        BUProduct buProd86 = new BUProduct(12,"Мороженое", "65");
        BUProduct buProd87 = new BUProduct(12,"Шоколад", "20");
        BUProduct buProd88 = new BUProduct(12,"Мёд", "12");
        BUProduct buProd89 = new BUProduct(13,"Айс Ти Малина со сливками", "4.5");
        BUProduct buProd90 = new BUProduct(13,"Айс-капучино карамель", "4.6");
        BUProduct buProd91 = new BUProduct(13,"Айс-капучино шоколадница", "3");
        BUProduct buProd92 = new BUProduct(13,"Классический Айс Ти", "2.5");
        BUProduct buProd93 = new BUProduct(13,"Коктейль Витаминый заряд", "5.3");
        BUProduct buProd94 = new BUProduct(13,"Лимонад Домашний", "0.5");
        BUProduct buProd95 = new BUProduct(13,"Молочный коктейль в ассортименте", "6");
        BUProduct buProd96 = new BUProduct(13,"Мохито б/a", "2.5");
        BUProduct buProd97 = new BUProduct(13,"Мохито клубничный б/a", "3");
        BUProduct buProd98 = new BUProduct(13,"Смузи малина и базилик", "5");
        BUProduct buProd99 = new BUProduct(13,"Фрапетто Кофейно-карамельный", "0.5");
        BUProduct buProd100 = new BUProduct(13,"Черничная страсть", "6");
        BUProduct buProd101 = new BUProduct(13,"Американо 100 гр", "1");
        BUProduct buProd102 = new BUProduct(13,"Американо 250 гр", "2.5");
        BUProduct buProd103 = new BUProduct(13,"Двойной эспрессо 60 гр", "0.8");
        BUProduct buProd104 = new BUProduct(13,"Эспрессо 60 гр", "0.8");
        BUProduct buProd105= new BUProduct(13,"Эспрессо классик 30 гр", "0.4");
        BUProduct buProd106 = new BUProduct(13,"Эсперссо Кон Панна 75 гр", "0.5");
        BUProduct buProd107 = new BUProduct(13,"Бейл с сёмгой", "5");
        BUProduct buProd108 = new BUProduct(13,"Клаб-сендвич", "7");
        BUProduct buProd109 = new BUProduct(13,"Классический курассан с пармской ветчиной и сыром", "3");
        BUProduct buProd110 = new BUProduct(13,"Панини с курицей", "4");
        BUProduct buProd111 = new BUProduct(13,"Ролл Говядина гриль", "4");
        BUProduct buProd112 = new BUProduct(13,"Ролл Мексиканский", "4");
        BUProduct buProd113 = new BUProduct(13,"Ролл Цезарь", "3.5");
        BUProduct buProd114 = new BUProduct(13,"Ролл с сёмгой", "2.5");
        BUProduct buProd115 = new BUProduct(13,"Тост с ветчиной и сыром", "3");
        BUProduct buProd116 = new BUProduct(13,"Бельгийская вафля", "1.5");
        BUProduct buProd117 = new BUProduct(13,"Десерт Маракуйя и клубника", "3");
        BUProduct buProd118 = new BUProduct(13,"Десерт Панакота", "2.5");
        BUProduct buProd119 = new BUProduct(13,"Десерт из мороженого Снежная Королева", "1.3");
        BUProduct buProd120 = new BUProduct(13,"Желе Лесная Ягода", "4");
        BUProduct buProd121 = new BUProduct(13,"Клубника со сливками", "2.3");
        BUProduct buProd122 = new BUProduct(13,"Малина со сливками", "2.5");
        BUProduct buProd123 = new BUProduct(13,"Фондю шоколадное с фруктами", "13");
        BUProduct buProd124 = new BUProduct(13,"Блинный пирог с курицей и индейкой", "1.5");
        BUProduct buProd125 = new BUProduct(13,"Блинный пирог с сёмгой и шпинатом", "1");
        BUProduct buProd126 = new BUProduct(13,"Блинчики Шоколадница", "5");
        BUProduct buProd127 = new BUProduct(13,"Блинчики 3 шт", "3");
        BUProduct buProd128 = new BUProduct(13,"Блинчики Малиновые", "4.5");
        BUProduct buProd129 = new BUProduct(13,"Блинчики с красной икрой", "2");
        BUProduct buProd130 = new BUProduct(13,"Блинчики с мясом", "3");
        BUProduct buProd131 = new BUProduct(13,"Блинчики с сёмгой", "2");
        BUProduct buProd132 = new BUProduct(13,"Блинчики с сыром и ветчиной", "2.5");
        BUProduct buProd300 = new BUProduct(13,"Блинчики с творогом", "4.5");
        BUProduct buProd133 = new BUProduct(13,"Болисе Горячий", "7.5");
        BUProduct buProd134 = new BUProduct(13,"Болисе Холодный", "9.5");
        BUProduct buProd135 = new BUProduct(13,"Какао 240 гр", "2.5");
        BUProduct buProd136 = new BUProduct(13,"Какао 400 гр", "4");
        BUProduct buProd137 = new BUProduct(13,"Какао банановый 200 гр", "2.5");
        BUProduct buProd138 = new BUProduct(13,"Какао банановый 360 гр", "4.5");
        BUProduct buProd139 = new BUProduct(13,"Какао Венский 200 гр", "2");
        BUProduct buProd140 = new BUProduct(13,"Какао Венский 360 гр", "3.5");
        BUProduct buProd141 = new BUProduct(13,"Какао с маршмеллоу 240 гр", "3");
        BUProduct buProd142 = new BUProduct(13,"Какао с маршмеллоу 400 гр", "5");
        BUProduct buProd143 = new BUProduct(13,"Карамелла горячий", "9");
        BUProduct buProd144 = new BUProduct(13,"Карамелла холодный", "10");
        BUProduct buProd145 = new BUProduct(13,"Кармен грячий", "9");
        BUProduct buProd146 = new BUProduct(13,"Кармен Холодный", "10");
        BUProduct buProd147 = new BUProduct(13,"Ля Фантаж Горячий", "8");
        BUProduct buProd148 = new BUProduct(13,"Ля Фантаж Холодный", "9.5");
        BUProduct buProd149 = new BUProduct(13,"Маленький горячий шоколад 60 гр", "2.3");
        BUProduct buProd150 = new BUProduct(13,"МегаКакао 400 гр", "4");
        BUProduct buProd151 = new BUProduct(13,"МегаКакао банановый 360 гр", "4.5");
        BUProduct buProd152 = new BUProduct(13,"МегаКакао Венский 360 гр", "3.5");
        BUProduct buProd153 = new BUProduct(13,"МегаКакао с маршмеллоу 400 гр", "5");
        BUProduct buProd154 = new BUProduct(13,"МегаШоколад 240 гр", "11");
        BUProduct buProd155 = new BUProduct(13,"Орео", "3.5");
        BUProduct buProd156 = new BUProduct(13,"Шоколад 100 гр", "4.5");
        BUProduct buProd157 = new BUProduct(13,"Шоколад 240 гр", "11");
        BUProduct buProd158 = new BUProduct(13,"Глинтвейн б/а", "1.2");
        BUProduct buProd159 = new BUProduct(13,"Зелёный чай с имбирём", "2.5");
        BUProduct buProd160 = new BUProduct(13,"Чай Земляника и облепиха", "2.5");
        BUProduct buProd161 = new BUProduct(13,"Чай Зимний клубничный мохито", "2.5");
        BUProduct buProd162 = new BUProduct(13,"Чай Зимний мохито", "2");
        BUProduct buProd163 = new BUProduct(13,"Чай клубнично-малиновый", "3");
        BUProduct buProd164 = new BUProduct(13,"Чай облепиха", "2.5");
        BUProduct buProd165 = new BUProduct(13,"Чай Шиповник с мятой и апельсиновой цедрой", "2");
        BUProduct buProd166 = new BUProduct(13,"Гляссе 210 гр", "2.3");
        BUProduct buProd167 = new BUProduct(13,"Гляссе 310 гр", "3.5");
        BUProduct buProd168 = new BUProduct(13,"Капучино 320 гр", "2");
        BUProduct buProd169 = new BUProduct(13,"Капучино 400 гр", "2.5");
        BUProduct buProd170 = new BUProduct(13,"Капучино 190 гр", "1");
        BUProduct buProd171 = new BUProduct(13,"Капучино Шоколадница молочный", "2.7");
        BUProduct buProd172 = new BUProduct(13,"Капучино Шоколадница чёрный", "2.7");
        BUProduct buProd173 = new BUProduct(13,"Капучино Стронг 320 гр", "2");
        BUProduct buProd174 = new BUProduct(13,"Капучино Стронг 400 гр", "2.5");
        BUProduct buProd175 = new BUProduct(13,"Капучино Стронг 190 гр", "1");
        BUProduct buProd176 = new BUProduct(13,"Карамельный капучино 320 гр", "3.5");
        BUProduct buProd177 = new BUProduct(13,"Карамельный капучино 400 гр", "4");
        BUProduct buProd178 = new BUProduct(13,"Латте 240 гр", "1.5");
        BUProduct buProd179 = new BUProduct(13,"Латте 400 гр", "2.5");
        BUProduct buProd180 = new BUProduct(13,"Латте банановая карамель 240 гр", "2.5");
        BUProduct buProd181 = new BUProduct(13,"Латте банановая карамель 400 гр", "4.5");
        BUProduct buProd182 = new BUProduct(13,"Латте Карамельный 240 гр", "2");
        BUProduct buProd183 = new BUProduct(13,"Латте Карамельный 400 гр", "3.5");
        BUProduct buProd184 = new BUProduct(13,"Латте Миндальный 240 гр", "2");
        BUProduct buProd185 = new BUProduct(13,"Латте Миндальный 400 гр", "3.5");
        BUProduct buProd186 = new BUProduct(13,"Латте Халва 400 гр", "2.5");
        BUProduct buProd187 = new BUProduct(13,"Мегакапучино 400 гр", "2.5");
        BUProduct buProd188 = new BUProduct(13,"Мегакапучино Стронг 400 гр", "2.5");
        BUProduct buProd189 = new BUProduct(13,"Мокко Чёрный Шоколад 240 гр", "2");
        BUProduct buProd190 = new BUProduct(13,"Мокко Чёрный Шоколад 400 гр", "3.5");
        BUProduct buProd191 = new BUProduct(13,"Сливочный Кофе 400 гр", "2");
        BUProduct buProd192 = new BUProduct(13,"Какао банановый Лайт 360 гр", "4");
        BUProduct buProd193 = new BUProduct(13,"Какао Венский Лайт 200 гр", "2");
        BUProduct buProd194 = new BUProduct(13,"Какао Венский Лайт 360 гр", "3.3");
        BUProduct buProd195 = new BUProduct(13,"Какао Лайт 240 гр", "2.5");
        BUProduct buProd196 = new BUProduct(13,"Какао Лайт 400 гр", "3.7");
        BUProduct buProd197 = new BUProduct(13,"Какао с маршмеллоу лайт 240 гр", "2.8");
        BUProduct buProd198 = new BUProduct(13,"Какао с маршмеллоу лайт 400 гр", "4.5");
        BUProduct buProd199 = new BUProduct(13,"Капучино Лайт 320 гр", "2");
        BUProduct buProd200 = new BUProduct(13,"Капучино Лайт 400 гр", "2.5");
        BUProduct buProd201 = new BUProduct(13,"Капучино Лайт 190 гр", "1");
        BUProduct buProd202 = new BUProduct(13,"Карамельный Капучино Лайт 320 гр", "4");
        BUProduct buProd203 = new BUProduct(13,"Карамельный Капучино Лайт 400 гр", "5");
        BUProduct buProd204 = new BUProduct(13,"Латте Банановая карамель Лайт 270 гр", "3");
        BUProduct buProd205 = new BUProduct(13,"Латте Банановая карамель Лайт 400 гр", "4");
        BUProduct buProd206 = new BUProduct(13,"Латте Лайт 270 гр", "1.5");
        BUProduct buProd207 = new BUProduct(13,"Латте Миндальный Лайт 240 гр", "2");
        BUProduct buProd208 = new BUProduct(13,"Латте Миндальный Лайт 400 гр", "3.5");
        BUProduct buProd301 = new BUProduct(13,"Латте Карамельный Лайт 400 гр", "3.5");
        BUProduct buProd209 = new BUProduct(13,"Латте Халва Лайт 400 гр", "2.5");
        BUProduct buProd210 = new BUProduct(13,"МегаКакао Банановый Лайт 360 гр", "4");
        BUProduct buProd211 = new BUProduct(13,"МегаКакао Венский Лайт 360 гр", "3.5");
        BUProduct buProd212 = new BUProduct(13,"МегаКакао Лайт 400 гр", "4");
        BUProduct buProd213 = new BUProduct(13,"МегаКакао с маршмеллоу лайт 400 гр", "4.5");
        BUProduct buProd214 = new BUProduct(13,"Мегакапучино Лайт 400 гр", "2.5");
        BUProduct buProd215 = new BUProduct(13,"Мокко чёрный шоколад Лайт 270 гр", "2");
        BUProduct buProd216 = new BUProduct(13,"Мокко чёрный шоколад Лайт 400 гр", "3");
        BUProduct buProd217 = new BUProduct(13,"Мороженное в ассортименте 50 гр", "1");
        BUProduct buProd218 = new BUProduct(13,"Паста Болоньезе", "10");
        BUProduct buProd219 = new BUProduct(13,"Паста Карбонара", "10");
        BUProduct buProd220 = new BUProduct(13,"Паста с грибами и сливочным соусом", "2");
        BUProduct buProd221 = new BUProduct(13,"Паста томатная", "10");
        BUProduct buProd222 = new BUProduct(13,"Пельмени с кроликом", "1.5");
        BUProduct buProd223 = new BUProduct(13,"Пирожное Картошка", "4.5");
        BUProduct buProd224 = new BUProduct(13,"Тирамису", "4");
        BUProduct buProd225 = new BUProduct(13,"Тирамису Дольче вита", "4");
        BUProduct buProd226 = new BUProduct(13,"Торт Наполеон Гурме", "4");
        BUProduct buProd227 = new BUProduct(13,"Торт Наполеон", "2");
        BUProduct buProd228 = new BUProduct(13,"Торт Опера", "4");
        BUProduct buProd229 = new BUProduct(13,"Торт Прага от Шоколадницы", "4");
        BUProduct buProd230 = new BUProduct(13,"Торт Кафе Льежуа", "2.5");
        BUProduct buProd231 = new BUProduct(13,"Торт крем-брюле с миндалём", "3.2");
        BUProduct buProd232 = new BUProduct(13,"Торт крем-брюле с миндалём и ягодами", "3.5");
        BUProduct buProd233 = new BUProduct(13,"Черничный чизкейк", "2.5");
        BUProduct buProd234 = new BUProduct(13,"Черничный чизкейк с ягодами", "2.7");
        BUProduct buProd235 = new BUProduct(13,"Чизкейк Нью-Йорк Де Люкс", "3");
        BUProduct buProd236 = new BUProduct(13,"Чизкейк Нью-Йорк", "3");
        BUProduct buProd237 = new BUProduct(13,"Штрудель Яблочный", "6");
        BUProduct buProd238 = new BUProduct(13,"Эклер Ванильный", "2");
        BUProduct buProd239 = new BUProduct(13,"Эклер Шоколадный", "2.5");
        BUProduct buProd240 = new BUProduct(13,"Салат Греческий", "0.7");
        BUProduct buProd241 = new BUProduct(13,"Салат Капрезе", "0.4");
        BUProduct buProd242 = new BUProduct(13,"Салат Ницца", "0.7");
        BUProduct buProd243 = new BUProduct(13,"Салат Римская охота", "2");
        BUProduct buProd244 = new BUProduct(13,"Салат Цезарь", "1.4");
        BUProduct buProd245 = new BUProduct(13,"Салат Цезарь с креветками", "1.3");
        BUProduct buProd246 = new BUProduct(13,"Апельсиновый сок", "1.7");
        BUProduct buProd247 = new BUProduct(13,"Грейпфрутовый сок", "6");
        BUProduct buProd248 = new BUProduct(13,"Морковный сок", "0.7");
        BUProduct buProd249 = new BUProduct(13,"Яблочно-сельдереевый сок", "1");
        BUProduct buProd250 = new BUProduct(13,"Яблочный сок", "1");
        BUProduct buProd251 = new BUProduct(13,"Сливочный суп-крем из шампионьонов", "4.5");
        BUProduct buProd252 = new BUProduct(13,"Солянка мясная", "0.4");
        BUProduct buProd253 = new BUProduct(13,"Сырники мёд/корица", "4");
        BUProduct buProd254 = new BUProduct(13,"Сырники смета/клюквенный соус", "5");
        BUProduct buProd255 = new BUProduct(13,"Сырники сметана/малиновый соус", "5");
        BUProduct buProd256 = new BUProduct(13,"Сырники сметана/черничный соус", "5");
        BUProduct buProd257 = new BUProduct(13,"Сырники со сметаной и свежими ягодами", "5");
        BUProduct buProd258 = new BUProduct(14,"Биг Мак", "3.3");
        BUProduct buProd259 = new BUProduct(14,"Биг Тейсти", "4.1");
        BUProduct buProd260 = new BUProduct(14,"Биф а-ля Рус", "3.6");
        BUProduct buProd261 = new BUProduct(14,"Гамбургер", "2.5");
        BUProduct buProd262 = new BUProduct(14,"Двойной Чизбургер", "2.6");
        BUProduct buProd263 = new BUProduct(14,"Макчикен", "3.1");
        BUProduct buProd264 = new BUProduct(14,"Роял Де Люкс", "3");
        BUProduct buProd265 = new BUProduct(14,"Роял Чизбургер", "2.8");
        BUProduct buProd266 = new BUProduct(14,"Филе-о-фиш", "3");
        BUProduct buProd267 = new BUProduct(14,"Цезарь Ролл", "4");
        BUProduct buProd268 = new BUProduct(14,"Чизбургер", "2.5");
        BUProduct buProd269 = new BUProduct(14,"Чикен Бекон", "5");
        BUProduct buProd270 = new BUProduct(14,"Чикен Мифик", "4");
        BUProduct buProd271 = new BUProduct(14,"Чикен Эмменталь", "4");
        BUProduct buProd272 = new BUProduct(14,"Чикенбургер", "3");
        BUProduct buProd273 = new BUProduct(14,"Чикен Макнаггетс 1 шт.", "0.25");
        BUProduct buProd274 = new BUProduct(14,"Картофель по-деревенски", "3.1");
        BUProduct buProd275 = new BUProduct(14,"Картофель фри (большая порция)", "5.5");
        BUProduct buProd276 = new BUProduct(14,"Картофель фри (маленькая порция)", "2.4");
        BUProduct buProd277 = new BUProduct(14,"Картофель фри (стандартная порция)", "3.5");
        BUProduct buProd278 = new BUProduct(14,"Салат овощной МакДональдс", "0.8");
        BUProduct buProd279 = new BUProduct(14,"Салат Цезарь МакДональдс", "1.2");
        BUProduct buProd280 = new BUProduct(14,"Морковные палочки МакДональдс", "0.5");
        BUProduct buProd281 = new BUProduct(14,"Вафельный рожок", "1.8");
        BUProduct buProd282 = new BUProduct(14,"Вишнёвый пирожок", "2.4");
        BUProduct buProd283 = new BUProduct(14,"Макфлурри Де Люкс карамельно-шоколадный", "5");
        BUProduct buProd284 = new BUProduct(14,"Макфлурри Де Люкс клубнично-шоколадный", "4.5");
        BUProduct buProd285 = new BUProduct(14,"Макфлурри Де Люкс с рисовыми шариками", "4.6");
        BUProduct buProd286 = new BUProduct(14,"Макфлурри Де Люкс с шоколадно-вафельной крошкой", "3.3");
        BUProduct buProd287 = new BUProduct(14,"Маффин с чёрной смородиной", "3.3");
        BUProduct buProd288 = new BUProduct(14,"Маффин с шоколадом", "3.4");
        BUProduct buProd289 = new BUProduct(14,"Мороженое с карамелью", "4.8");
        BUProduct buProd290 = new BUProduct(14,"Мороженое с клубникой", "4");
        BUProduct buProd291 = new BUProduct(14,"Мороженое с шоколадом", "4.1");
        BUProduct buProd292 = new BUProduct(14,"Большой завтрак", "5.1");
        BUProduct buProd293 = new BUProduct(14,"Двойной МакМаффин с яйцом и свининой", "3.4");
        BUProduct buProd294 = new BUProduct(14,"Двой Фреш МакМаффин", "2.4");
        BUProduct buProd295 = new BUProduct(14,"МакМаффин с яйцом и беконом", "2.1");
        BUProduct buProd296 = new BUProduct(14,"МакМаффин с яйцом и свиной котдетой", "2.7");
        BUProduct buProd297 = new BUProduct(14,"МакМаффин с яйцом и сыром", "2.1");
        BUProduct buProd298 = new BUProduct(14,"Макмаффин со свиной котлетой", "2.7");
        BUProduct buProd299 = new BUProduct(14,"МакТост", "2.3");
        BUProduct buProd302 = new BUProduct(14,"МакТост с ветчиной", "2.3");
        BUProduct buProd303 = new BUProduct(14,"Фреш МакМаффин", "2.9");
        BUProduct buProd304 = new BUProduct(14,"Хашбраун", "1.3");
        BUProduct buProd305 = new BUProduct(14,"Чикен Фреш МакМаффин", "3.5");
        BUProduct buProd306 = new BUProduct(14,"Холодные напитки", "0");
        BUProduct buProd307 = new BUProduct(14,"Двойной Эспрессо", "0");
        BUProduct buProd308 = new BUProduct(14,"Капучино МакДональдс", "0.6");
        BUProduct buProd309 = new BUProduct(14,"Кофе Глясе МакДональдс", "1.6");
        BUProduct buProd310 = new BUProduct(14,"Кофе Латте МакДональдс", "1");
        BUProduct buProd311 = new BUProduct(14,"Коктейль Ванильный МакДональдс", "5.7");
        BUProduct buProd312 = new BUProduct(14,"Коктейль Клубничный МакДональдс", "5.8");
        BUProduct buProd313 = new BUProduct(14,"Коктейль Шоколадный МакДональдс", "5.6");





        mBUProducts.add(myProduct1);
        mBUProducts.add(buProd1);
        mBUProducts.add(buProd2);
        mBUProducts.add(buProd3);
        mBUProducts.add(buProd4);
        mBUProducts.add(buProd5);
        mBUProducts.add(buProd6);
        mBUProducts.add(buProd7);
        mBUProducts.add(buProd8);
        mBUProducts.add(buProd9);
        mBUProducts.add(buProd10);
        mBUProducts.add(buProd11);
        mBUProducts.add(buProd12);
        mBUProducts.add(buProd13);
        mBUProducts.add(buProd14);
        mBUProducts.add(buProd15);
        mBUProducts.add(buProd16);
        mBUProducts.add(buProd17);
        mBUProducts.add(buProd18);
        mBUProducts.add(buProd19);
        mBUProducts.add(buProd20);
        mBUProducts.add(buProd21);
        mBUProducts.add(buProd22);
        mBUProducts.add(buProd23);
        mBUProducts.add(buProd24);
        mBUProducts.add(buProd25);
        mBUProducts.add(buProd26);
        mBUProducts.add(buProd27);
        mBUProducts.add(buProd28);
        mBUProducts.add(buProd29);
        mBUProducts.add(buProd30);
        mBUProducts.add(buProd31);
        mBUProducts.add(buProd32);
        mBUProducts.add(buProd33);
        mBUProducts.add(buProd34);
        mBUProducts.add(buProd35);
        mBUProducts.add(buProd36);
        mBUProducts.add(buProd37);
        mBUProducts.add(buProd38);
        mBUProducts.add(buProd39);
        mBUProducts.add(buProd40);
        mBUProducts.add(buProd41);
        mBUProducts.add(buProd42);
        mBUProducts.add(buProd43);
        mBUProducts.add(buProd44);
        mBUProducts.add(buProd45);
        mBUProducts.add(buProd46);
        mBUProducts.add(buProd47);
        mBUProducts.add(buProd48);
        mBUProducts.add(buProd49);
        mBUProducts.add(buProd50);
        mBUProducts.add(buProd51);
        mBUProducts.add(buProd52);
        mBUProducts.add(buProd53);
        mBUProducts.add(buProd54);
        mBUProducts.add(buProd55);
        mBUProducts.add(buProd56);
        mBUProducts.add(buProd57);
        mBUProducts.add(buProd58);
        mBUProducts.add(buProd59);
        mBUProducts.add(buProd60);
        mBUProducts.add(buProd61);
        mBUProducts.add(buProd62);
        mBUProducts.add(buProd63);
        mBUProducts.add(buProd64);
        mBUProducts.add(buProd65);
        mBUProducts.add(buProd66);
        mBUProducts.add(buProd67);
        mBUProducts.add(buProd68);
        mBUProducts.add(buProd69);
        mBUProducts.add(buProd70);
        mBUProducts.add(buProd71);
        mBUProducts.add(buProd72);
        mBUProducts.add(buProd73);
        mBUProducts.add(buProd74);
        mBUProducts.add(buProd75);
        mBUProducts.add(buProd76);
        mBUProducts.add(buProd77);
        mBUProducts.add(buProd78);
        mBUProducts.add(buProd79);
        mBUProducts.add(buProd80);
        mBUProducts.add(buProd81);
        mBUProducts.add(buProd82);
        mBUProducts.add(buProd83);
        mBUProducts.add(buProd84);
        mBUProducts.add(buProd85);
        mBUProducts.add(buProd86);
        mBUProducts.add(buProd87);
        mBUProducts.add(buProd88);
        mBUProducts.add(buProd89);
        mBUProducts.add(buProd90);
        mBUProducts.add(buProd91);
        mBUProducts.add(buProd92);
        mBUProducts.add(buProd93);
        mBUProducts.add(buProd94);
        mBUProducts.add(buProd95);
        mBUProducts.add(buProd96);
        mBUProducts.add(buProd97);
        mBUProducts.add(buProd98);
        mBUProducts.add(buProd99);
        mBUProducts.add(buProd100);
        mBUProducts.add(buProd101);
        mBUProducts.add(buProd102);
        mBUProducts.add(buProd103);
        mBUProducts.add(buProd104);
        mBUProducts.add(buProd105);
        mBUProducts.add(buProd106);
        mBUProducts.add(buProd107);
        mBUProducts.add(buProd108);
        mBUProducts.add(buProd109);
        mBUProducts.add(buProd110);
        mBUProducts.add(buProd111);
        mBUProducts.add(buProd112);
        mBUProducts.add(buProd113);
        mBUProducts.add(buProd114);
        mBUProducts.add(buProd115);
        mBUProducts.add(buProd116);
        mBUProducts.add(buProd117);
        mBUProducts.add(buProd118);
        mBUProducts.add(buProd119);
        mBUProducts.add(buProd120);
        mBUProducts.add(buProd121);
        mBUProducts.add(buProd122);
        mBUProducts.add(buProd123);
        mBUProducts.add(buProd124);
        mBUProducts.add(buProd125);
        mBUProducts.add(buProd126);
        mBUProducts.add(buProd127);
        mBUProducts.add(buProd128);
        mBUProducts.add(buProd129);
        mBUProducts.add(buProd130);
        mBUProducts.add(buProd131);
        mBUProducts.add(buProd132);
        mBUProducts.add(buProd300);
        mBUProducts.add(buProd133);
        mBUProducts.add(buProd134);
        mBUProducts.add(buProd135);
        mBUProducts.add(buProd136);
        mBUProducts.add(buProd137);
        mBUProducts.add(buProd138);
        mBUProducts.add(buProd139);
        mBUProducts.add(buProd140);
        mBUProducts.add(buProd141);
        mBUProducts.add(buProd142);
        mBUProducts.add(buProd143);
        mBUProducts.add(buProd144);
        mBUProducts.add(buProd145);
        mBUProducts.add(buProd146);
        mBUProducts.add(buProd147);
        mBUProducts.add(buProd148);
        mBUProducts.add(buProd149);
        mBUProducts.add(buProd150);
        mBUProducts.add(buProd151);
        mBUProducts.add(buProd152);
        mBUProducts.add(buProd153);
        mBUProducts.add(buProd154);
        mBUProducts.add(buProd155);
        mBUProducts.add(buProd156);
        mBUProducts.add(buProd157);
        mBUProducts.add(buProd158);
        mBUProducts.add(buProd159);
        mBUProducts.add(buProd160);
        mBUProducts.add(buProd161);
        mBUProducts.add(buProd162);
        mBUProducts.add(buProd163);
        mBUProducts.add(buProd164);
        mBUProducts.add(buProd165);
        mBUProducts.add(buProd166);
        mBUProducts.add(buProd167);
        mBUProducts.add(buProd168);
        mBUProducts.add(buProd169);
        mBUProducts.add(buProd170);
        mBUProducts.add(buProd171);
        mBUProducts.add(buProd172);
        mBUProducts.add(buProd173);
        mBUProducts.add(buProd174);
        mBUProducts.add(buProd175);
        mBUProducts.add(buProd176);
        mBUProducts.add(buProd178);
        mBUProducts.add(buProd177);
        mBUProducts.add(buProd179);
        mBUProducts.add(buProd180);
        mBUProducts.add(buProd181);
        mBUProducts.add(buProd182);
        mBUProducts.add(buProd183);
        mBUProducts.add(buProd184);
        mBUProducts.add(buProd185);
        mBUProducts.add(buProd186);
        mBUProducts.add(buProd187);
        mBUProducts.add(buProd188);
        mBUProducts.add(buProd189);
        mBUProducts.add(buProd190);
        mBUProducts.add(buProd191);
        mBUProducts.add(buProd192);
        mBUProducts.add(buProd193);
        mBUProducts.add(buProd194);
        mBUProducts.add(buProd195);
        mBUProducts.add(buProd196);
        mBUProducts.add(buProd199);
        mBUProducts.add(buProd197);
        mBUProducts.add(buProd198);
        mBUProducts.add(buProd200);
        mBUProducts.add(buProd201);
        mBUProducts.add(buProd202);
        mBUProducts.add(buProd203);
        mBUProducts.add(buProd204);
        mBUProducts.add(buProd205);
        mBUProducts.add(buProd206);
        mBUProducts.add(buProd207);
        mBUProducts.add(buProd208);
        mBUProducts.add(buProd301);
        mBUProducts.add(buProd209);
        mBUProducts.add(buProd210);
        mBUProducts.add(buProd211);
        mBUProducts.add(buProd212);
        mBUProducts.add(buProd213);
        mBUProducts.add(buProd214);
        mBUProducts.add(buProd215);
        mBUProducts.add(buProd216);
        mBUProducts.add(buProd217);
        mBUProducts.add(buProd218);
        mBUProducts.add(buProd219);
        mBUProducts.add(buProd220);
        mBUProducts.add(buProd221);
        mBUProducts.add(buProd222);
        mBUProducts.add(buProd223);
        mBUProducts.add(buProd224);
        mBUProducts.add(buProd225);
        mBUProducts.add(buProd226);
        mBUProducts.add(buProd227);
        mBUProducts.add(buProd228);
        mBUProducts.add(buProd229);
        mBUProducts.add(buProd230);
        mBUProducts.add(buProd231);
        mBUProducts.add(buProd232);
        mBUProducts.add(buProd233);
        mBUProducts.add(buProd234);
        mBUProducts.add(buProd235);
        mBUProducts.add(buProd236);
        mBUProducts.add(buProd237);
        mBUProducts.add(buProd238);
        mBUProducts.add(buProd239);
        mBUProducts.add(buProd240);
        mBUProducts.add(buProd241);
        mBUProducts.add(buProd242);
        mBUProducts.add(buProd243);
        mBUProducts.add(buProd244);
        mBUProducts.add(buProd245);
        mBUProducts.add(buProd246);
        mBUProducts.add(buProd247);
        mBUProducts.add(buProd248);
        mBUProducts.add(buProd249);
        mBUProducts.add(buProd250);
        mBUProducts.add(buProd251);
        mBUProducts.add(buProd252);
        mBUProducts.add(buProd253);
        mBUProducts.add(buProd254);
        mBUProducts.add(buProd255);
        mBUProducts.add(buProd256);
        mBUProducts.add(buProd257);
        mBUProducts.add(buProd258);
        mBUProducts.add(buProd259);
        mBUProducts.add(buProd260);
        mBUProducts.add(buProd261);
        mBUProducts.add(buProd262);
        mBUProducts.add(buProd263);
        mBUProducts.add(buProd264);
        mBUProducts.add(buProd265);
        mBUProducts.add(buProd266);
        mBUProducts.add(buProd267);
        mBUProducts.add(buProd268);
        mBUProducts.add(buProd269);
        mBUProducts.add(buProd270);
        mBUProducts.add(buProd271);
        mBUProducts.add(buProd272);
        mBUProducts.add(buProd273);
        mBUProducts.add(buProd274);
        mBUProducts.add(buProd275);
        mBUProducts.add(buProd276);
        mBUProducts.add(buProd277);
        mBUProducts.add(buProd278);
        mBUProducts.add(buProd279);
        mBUProducts.add(buProd280);
        mBUProducts.add(buProd281);
        mBUProducts.add(buProd282);
        mBUProducts.add(buProd283);
        mBUProducts.add(buProd284);
        mBUProducts.add(buProd285);
        mBUProducts.add(buProd286);
        mBUProducts.add(buProd287);
        mBUProducts.add(buProd288);
        mBUProducts.add(buProd289);
        mBUProducts.add(buProd290);
        mBUProducts.add(buProd291);
        mBUProducts.add(buProd292);
        mBUProducts.add(buProd293);
        mBUProducts.add(buProd294);
        mBUProducts.add(buProd295);
        mBUProducts.add(buProd296);
        mBUProducts.add(buProd297);
        mBUProducts.add(buProd298);
        mBUProducts.add(buProd299);
        mBUProducts.add(buProd301);
        mBUProducts.add(buProd302);
        mBUProducts.add(buProd303);
        mBUProducts.add(buProd304);
        mBUProducts.add(buProd305);
        mBUProducts.add(buProd306);
        mBUProducts.add(buProd307);
        mBUProducts.add(buProd308);
        mBUProducts.add(buProd308);
        mBUProducts.add(buProd309);
        mBUProducts.add(buProd310);
        mBUProducts.add(buProd311);
        mBUProducts.add(buProd312);
        mBUProducts.add(buProd313);

    }
    public List<BUProduct> getAllBUProducts(){
        return mBUProducts;
    }

    public List<BUProduct> getBUProducts(int which){
        mBUProductsByType = new ArrayList<>();
        //условие выбора база-ArrayList
        if (which != 1) {
            for (int i = 0; i < mBUProducts.size(); ++i) {
                if (mBUProducts.get(i).getTypeId() == which) {
                    mBUProductsByType.add(mBUProducts.get(i));
                }
            }
            return mBUProductsByType;
        } else {
            ProductCursorWrapper cursorWrapper = queryProducts(null, null);
            try {
                cursorWrapper.moveToFirst();
                while (!cursorWrapper.isAfterLast()) {
                    mBUProductsByType.add(cursorWrapper.getProduct());
                    cursorWrapper.moveToNext();
                }
            }finally {
                cursorWrapper.close();
            }
            return mBUProductsByType;
        }
    }

    public BUProduct getBUProduct (UUID id, int type) {
        if (type != 1) {
            for (BUProduct prod : mBUProducts) {
                if (prod.getId().equals(id)) {
                    return prod;
                }
            }
            return null;
        }
        else {
            ProductCursorWrapper cursorWrapper = queryProducts(
                    ProductDBSchema.ProductTable.Cols.UUID + " = ?", new String [] {id.toString()}
            );
            try {
                if (cursorWrapper.getCount() == 0) {
                    return null;
                }
                cursorWrapper.moveToFirst();
                return cursorWrapper.getProduct();
            } finally {
                cursorWrapper.close();
            }
        }
    }
    //Удаление продукта
    public void deleteProduct(BUProduct product){
        String uuidToString = product.getId().toString();
        mDatabase.delete(ProductDBSchema.ProductTable.NAME, ProductDBSchema.ProductTable.Cols.UUID + " = ?", new String[] {uuidToString});}
    //Обновление продукта
    public void updateProduct(BUProduct product){
        String uuidToString = product.getId().toString();
        ContentValues values = getProductValues(product);
        mDatabase.update(ProductDBSchema.ProductTable.NAME, values, ProductDBSchema.ProductTable.Cols.UUID + " = ?", new String[] {uuidToString});
    }
    //Предоставление результатов при посике продуктов
    public List<BUProduct> provideSearchResult(String query){
        for (int i = 0; i < mBUProducts.size(); ++i){
            if (mBUProducts.get(i).getProductName().contains(query)){
                mBUProductsByType.add(mBUProducts.get(i));
            }
        }
        return mBUProductsByType;
    }
    //Добавление продукта
    public void addProduct(BUProduct product){
        ContentValues values = getProductValues(product);
        mDatabase.insert(ProductDBSchema.ProductTable.NAME, null, values);
    }
    //Передача данных продукта
    private static ContentValues getProductValues(BUProduct product) {
        ContentValues values = new ContentValues();
        values.put(ProductDBSchema.ProductTable.Cols.UUID, product.getId().toString());
        values.put(ProductDBSchema.ProductTable.Cols.NAME, product.getProductName());
        values.put(ProductDBSchema.ProductTable.Cols.GRAMS, product.getGrammsForBU());
        values.put(ProductDBSchema.ProductTable.Cols.TYPE, product.getTypeId());
        return values;
    }
}
