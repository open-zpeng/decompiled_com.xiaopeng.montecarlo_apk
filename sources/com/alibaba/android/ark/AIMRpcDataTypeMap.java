package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class AIMRpcDataTypeMap implements Serializable {
    private static final long serialVersionUID = 5745851439676744670L;
    public AIMRpcDataType dataType;
    public boolean enableRetry;
    public HashMap<String, String> kvParams;
    public long timeoutMs;

    public AIMRpcDataTypeMap(AIMRpcDataType aIMRpcDataType, boolean z, long j, HashMap<String, String> hashMap) {
        this.dataType = AIMRpcDataType.DT_MSGPACK;
        this.enableRetry = false;
        this.timeoutMs = 40000L;
        if (aIMRpcDataType != null) {
            this.dataType = aIMRpcDataType;
        }
        this.enableRetry = z;
        this.timeoutMs = j;
        this.kvParams = hashMap;
    }

    public AIMRpcDataTypeMap() {
        this.dataType = AIMRpcDataType.DT_MSGPACK;
        this.enableRetry = false;
        this.timeoutMs = 40000L;
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

    public HashMap<String, String> getKvParams() {
        return this.kvParams;
    }

    public String toString() {
        return "AIMRpcDataTypeMap{dataType=" + this.dataType + ",enableRetry=" + this.enableRetry + ",timeoutMs=" + this.timeoutMs + ",kvParams=" + this.kvParams + "}";
    }
}
