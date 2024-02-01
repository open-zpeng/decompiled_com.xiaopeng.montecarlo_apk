package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class AIMRpcRequestHeader implements Serializable {
    private static final long serialVersionUID = 1465810832578810487L;
    public AIMRpcDataType dataType;
    public boolean enableRetry;
    public HashMap<String, String> kvParams;
    public boolean noNeedAuth;
    public long timeoutMs;

    public AIMRpcRequestHeader(AIMRpcDataType aIMRpcDataType, boolean z, long j, boolean z2, HashMap<String, String> hashMap) {
        this.dataType = AIMRpcDataType.DT_MSGPACK;
        this.enableRetry = false;
        this.timeoutMs = 40000L;
        this.noNeedAuth = false;
        if (aIMRpcDataType != null) {
            this.dataType = aIMRpcDataType;
        }
        this.enableRetry = z;
        this.timeoutMs = j;
        this.noNeedAuth = z2;
        this.kvParams = hashMap;
    }

    public AIMRpcRequestHeader() {
        this.dataType = AIMRpcDataType.DT_MSGPACK;
        this.enableRetry = false;
        this.timeoutMs = 40000L;
        this.noNeedAuth = false;
    }

    public AIMRpcDataType getDataType() {
        return this.dataType;
    }

    public boolean getEnableRetry() {
        return this.enableRetry;
    }

    public long getTimeoutMs() {
        return this.timeoutMs;
    }

    public boolean getNoNeedAuth() {
        return this.noNeedAuth;
    }

    public HashMap<String, String> getKvParams() {
        return this.kvParams;
    }

    public String toString() {
        return "AIMRpcRequestHeader{dataType=" + this.dataType + ",enableRetry=" + this.enableRetry + ",timeoutMs=" + this.timeoutMs + ",noNeedAuth=" + this.noNeedAuth + ",kvParams=" + this.kvParams + "}";
    }
}
