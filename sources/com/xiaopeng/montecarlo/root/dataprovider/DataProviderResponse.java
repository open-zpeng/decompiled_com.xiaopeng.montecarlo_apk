package com.xiaopeng.montecarlo.root.dataprovider;

import com.xiaopeng.montecarlo.root.dataprovider.BaseResultData;
/* loaded from: classes2.dex */
public class DataProviderResponse<R extends BaseResultData> {
    private int mErrorCode = 0;
    private R mResultData;

    public R getResultData() {
        return this.mResultData;
    }

    public void setResultData(R r) {
        this.mResultData = r;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }
}
