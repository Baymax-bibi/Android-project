package com.example.api;

public class CouponCategory {

    private String mStoreName;

    private String mPromoCode;

    private String mGotoStore;

    public CouponCategory(String storeName, String promoCode, String gotoStore) {
        mStoreName = storeName;
        mPromoCode = promoCode;
        mGotoStore = gotoStore;
    }

    //** Get the Magnitude of the earthquake*/
    public String getStoreName() { return mStoreName; }

    public String getPromoCode() { return mPromoCode; }

    public String getDescription() { return mGotoStore; }
}
