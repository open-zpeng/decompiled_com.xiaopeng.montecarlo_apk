package com.xiaopeng.montecarlo.root.httpclient.constants;

import com.xiaopeng.montecarlo.root.util.GsonEnum;
/* loaded from: classes2.dex */
public enum RequestType implements GsonEnum<RequestType> {
    POST("post"),
    GET("get");
    
    String mValue;

    RequestType(String str) {
        this.mValue = str;
    }

    @Override // com.xiaopeng.montecarlo.root.util.GsonEnum
    public String getValue() {
        return this.mValue;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.root.util.GsonEnum
    public RequestType parse(String str) {
        RequestType[] values;
        for (RequestType requestType : values()) {
            if (requestType.getValue().equals(str)) {
                return requestType;
            }
        }
        return null;
    }
}
