package com.lossdemoss.dialog_dnevnick;

import java.util.UUID;

/**
 * Created by LossDeMoss on 23.10.2018.
 */

public class BUProduct {
    //определение продукта. Продукт имеет Id, название, Id Типа  - категории, Граммы на хе.
    private int mTypeId;
    private UUID mId;
    private String mProductName;
    private String mGrammsForBU;

    //При создании нового продукта из приложения
    public BUProduct() {
        this(UUID.randomUUID());

    }
    //При создании продуктов в ProductLab (во встроенном массиве)
    public BUProduct(int typeId, String productName, String grammsForBU) {
        this.mId = (UUID.randomUUID());
        mTypeId = typeId;
        mProductName = productName;
        mGrammsForBU = grammsForBU;
    }

    public BUProduct(UUID id){
        mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getProductName() {
        return mProductName;
    }

    public void setProductName(String productName) {
        mProductName = productName;
    }

    public String getGrammsForBU() {
        return mGrammsForBU;
    }

    public void setGrammsForBU(String grammsForBU) {
        mGrammsForBU = grammsForBU;
    }

    public int getTypeId() {
        return mTypeId;
    }

    public void setTypeId(int typeId) {
        mTypeId = typeId;
    }
}
