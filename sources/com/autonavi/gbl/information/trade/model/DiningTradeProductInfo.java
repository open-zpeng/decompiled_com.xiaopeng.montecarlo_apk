package com.autonavi.gbl.information.trade.model;

import com.autonavi.gbl.search.model.ShelfSourceType;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DiningTradeProductInfo implements Serializable {
    public int buyLimit;
    public String imageUrl;
    public ArrayList<String> label;
    public String name;
    @ShelfSourceType.ShelfSourceType1
    public int shelfSource;
    public String shopName;
    public String skuId;

    public DiningTradeProductInfo() {
        this.imageUrl = "";
        this.name = "";
        this.shopName = "";
        this.skuId = "";
        this.buyLimit = -1;
        this.shelfSource = -1;
        this.label = new ArrayList<>();
    }

    public DiningTradeProductInfo(String str, String str2, String str3, String str4, int i, @ShelfSourceType.ShelfSourceType1 int i2, ArrayList<String> arrayList) {
        this.imageUrl = str;
        this.name = str2;
        this.shopName = str3;
        this.skuId = str4;
        this.buyLimit = i;
        this.shelfSource = i2;
        this.label = arrayList;
    }
}
