package com.lossdemoss.dialog_dnevnick.productdatabase;

/**
 * Created by LossDeMoss on 03.11.2018.
 */

public class ProductDBSchema {
    public static final class ProductTable {
        public static final String NAME = "products";

        public static  final class Cols {
            public static final String UUID = "uuid";
            public static final String TYPE = "type";
            public static final String NAME = "name";
            public static final String GRAMS = "grams";
        }
    }
}
