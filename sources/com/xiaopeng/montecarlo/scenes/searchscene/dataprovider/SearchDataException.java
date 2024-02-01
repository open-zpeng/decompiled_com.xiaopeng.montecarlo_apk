package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import com.xiaopeng.montecarlo.root.dataprovider.DataProviderException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class SearchDataException extends DataProviderException {
    public static final int ERROR_CODE_SEARCH_CANCELED = 1;
    private int mSearchErrorCode;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SearchDataProviderErrorCode {
    }

    public SearchDataException(String str) {
        super(str);
    }

    public SearchDataException(int i) {
        super("");
        this.mSearchErrorCode = i;
    }

    public SearchDataException(int i, String str) {
        super(str == null ? "" : str);
        this.mSearchErrorCode = i;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.DataProviderException
    public int getErrorCode() {
        return this.mSearchErrorCode;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.DataProviderException
    public void setErrorCode(int i) {
        this.mSearchErrorCode = i;
    }
}
