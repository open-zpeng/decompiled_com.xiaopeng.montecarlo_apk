package com.xiaopeng.montecarlo.root.httpclient.constants;

import com.xiaopeng.montecarlo.navcore.datarecord.SrDataRecordStrategyInfo;
import com.xiaopeng.montecarlo.root.util.GsonEnum;
/* loaded from: classes3.dex */
public enum HttpEnvironment implements GsonEnum<HttpEnvironment> {
    NETWORK_ENVIRONMENT_DEVELOP(0, "develop"),
    NETWORK_ENVIRONMENT_TEST(1, SrDataRecordStrategyInfo.UserRole.USER_ROLE_TEST),
    NETWORK_ENVIRONMENT_STAGING(2, "staging"),
    NETWORK_ENVIRONMENT_PRODUCT(3, "product");
    
    String mDescription;
    int mValue;

    HttpEnvironment(int i, String str) {
        this.mValue = i;
        this.mDescription = str;
    }

    public int getIntValue() {
        return this.mValue;
    }

    public static HttpEnvironment parseInt(int i) {
        HttpEnvironment[] values;
        for (HttpEnvironment httpEnvironment : values()) {
            if (httpEnvironment.getIntValue() == i) {
                return httpEnvironment;
            }
        }
        return NETWORK_ENVIRONMENT_PRODUCT;
    }

    @Override // com.xiaopeng.montecarlo.root.util.GsonEnum
    public String getValue() {
        return this.mDescription;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.root.util.GsonEnum
    public HttpEnvironment parse(String str) {
        HttpEnvironment[] values;
        for (HttpEnvironment httpEnvironment : values()) {
            if (httpEnvironment.getValue().equals(str)) {
                return httpEnvironment;
            }
        }
        return NETWORK_ENVIRONMENT_PRODUCT;
    }
}
