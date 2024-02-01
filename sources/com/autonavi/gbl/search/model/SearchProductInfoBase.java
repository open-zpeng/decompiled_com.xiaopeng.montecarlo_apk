package com.autonavi.gbl.search.model;

import com.autonavi.gbl.search.model.SearchProductType;
import com.autonavi.gbl.util.model.QrCodeStream;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchProductInfoBase implements Serializable {
    public double currentPrice;
    public double discountRate;
    public String originalId;
    public double originalPrice;
    public QrCodeStream qrCode;
    public String skuId;
    public String spuId;
    public String spuName;
    public SearchTagInfo tagInfo;
    @SearchProductType.SearchProductType1
    public int type;

    public SearchProductInfoBase() {
        this.type = 0;
        this.originalPrice = 0.0d;
        this.currentPrice = 0.0d;
        this.discountRate = 0.0d;
        this.qrCode = new QrCodeStream();
        this.skuId = "";
        this.spuId = "";
        this.originalId = "";
        this.spuName = "";
        this.tagInfo = new SearchTagInfo();
    }

    public SearchProductInfoBase(@SearchProductType.SearchProductType1 int i, double d, double d2, double d3, QrCodeStream qrCodeStream, String str, String str2, String str3, String str4, SearchTagInfo searchTagInfo) {
        this.type = i;
        this.originalPrice = d;
        this.currentPrice = d2;
        this.discountRate = d3;
        this.qrCode = qrCodeStream;
        this.skuId = str;
        this.spuId = str2;
        this.originalId = str3;
        this.spuName = str4;
        this.tagInfo = searchTagInfo;
    }
}
