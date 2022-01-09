package com.lossdemoss.dialog_dnevnick.productdatabase;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.lossdemoss.dialog_dnevnick.BUProduct;
import com.lossdemoss.dialog_dnevnick.Zamer;

import java.util.Date;
import java.util.UUID;

import database.ZamerDBSchema;

/**
 * Created by LossDeMoss on 03.11.2018.
 */

public class ProductCursorWrapper extends CursorWrapper {
    public ProductCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public BUProduct getProduct() {
        String uuidSring = getString(getColumnIndex(ProductDBSchema.ProductTable.Cols.UUID));
        int type = getInt(getColumnIndex(ProductDBSchema.ProductTable.Cols.TYPE));
        String name = getString(getColumnIndex(ProductDBSchema.ProductTable.Cols.NAME));
        String grams = getString(getColumnIndex(ProductDBSchema.ProductTable.Cols.GRAMS));


        BUProduct product = new BUProduct(UUID.fromString(uuidSring));
        product.setTypeId(type);
        product.setProductName(name);
        product.setGrammsForBU(grams);
        return product;
    }
}
