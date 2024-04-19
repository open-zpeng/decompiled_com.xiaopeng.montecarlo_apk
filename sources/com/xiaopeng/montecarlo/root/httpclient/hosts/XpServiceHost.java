package com.xiaopeng.montecarlo.root.httpclient.hosts;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.datarecord.SrDataRecordStrategyInfo;
/* loaded from: classes3.dex */
public class XpServiceHost {
    @SerializedName("develop")
    private String mDevelop;
    @SerializedName("product")
    private String mProduct;
    @SerializedName("staging")
    private String mStaging;
    @SerializedName(SrDataRecordStrategyInfo.UserRole.USER_ROLE_TEST)
    private String mTest;

    protected boolean canEqual(Object obj) {
        return obj instanceof XpServiceHost;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof XpServiceHost) {
            XpServiceHost xpServiceHost = (XpServiceHost) obj;
            if (xpServiceHost.canEqual(this)) {
                String develop = getDevelop();
                String develop2 = xpServiceHost.getDevelop();
                if (develop != null ? develop.equals(develop2) : develop2 == null) {
                    String test = getTest();
                    String test2 = xpServiceHost.getTest();
                    if (test != null ? test.equals(test2) : test2 == null) {
                        String staging = getStaging();
                        String staging2 = xpServiceHost.getStaging();
                        if (staging != null ? staging.equals(staging2) : staging2 == null) {
                            String product = getProduct();
                            String product2 = xpServiceHost.getProduct();
                            return product != null ? product.equals(product2) : product2 == null;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String develop = getDevelop();
        int hashCode = develop == null ? 43 : develop.hashCode();
        String test = getTest();
        int hashCode2 = ((hashCode + 59) * 59) + (test == null ? 43 : test.hashCode());
        String staging = getStaging();
        int hashCode3 = (hashCode2 * 59) + (staging == null ? 43 : staging.hashCode());
        String product = getProduct();
        return (hashCode3 * 59) + (product != null ? product.hashCode() : 43);
    }

    public XpServiceHost setDevelop(String str) {
        this.mDevelop = str;
        return this;
    }

    public XpServiceHost setProduct(String str) {
        this.mProduct = str;
        return this;
    }

    public XpServiceHost setStaging(String str) {
        this.mStaging = str;
        return this;
    }

    public XpServiceHost setTest(String str) {
        this.mTest = str;
        return this;
    }

    public String toString() {
        return "XpServiceHost(mDevelop=" + getDevelop() + ", mTest=" + getTest() + ", mStaging=" + getStaging() + ", mProduct=" + getProduct() + ")";
    }

    public String getDevelop() {
        return this.mDevelop;
    }

    public String getTest() {
        return this.mTest;
    }

    public String getStaging() {
        return this.mStaging;
    }

    public String getProduct() {
        return this.mProduct;
    }
}
