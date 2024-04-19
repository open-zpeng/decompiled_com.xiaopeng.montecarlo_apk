package com.xiaopeng.montecarlo.views.poicard;

import com.xiaopeng.montecarlo.root.dataprovider.DataProviderException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class PoiCardDataException extends DataProviderException {
    public static final int ERROR_CODE_SUB_DETAIL_FETCH_CANCELED = 1;
    private int mSubDetailFetchErrorCode;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PoiCardDataProviderErrorCode {
    }

    public PoiCardDataException(String str) {
        super(str);
    }

    public PoiCardDataException(int i) {
        super("");
        this.mSubDetailFetchErrorCode = i;
    }

    public PoiCardDataException(int i, String str) {
        super(str == null ? "" : str);
        this.mSubDetailFetchErrorCode = i;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.DataProviderException
    public int getErrorCode() {
        return this.mSubDetailFetchErrorCode;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.DataProviderException
    public void setErrorCode(int i) {
        this.mSubDetailFetchErrorCode = i;
    }
}
