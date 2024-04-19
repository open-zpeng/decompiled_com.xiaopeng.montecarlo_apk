package com.xiaopeng.montecarlo.scenes.settingscene.dataprovider;

import com.xiaopeng.montecarlo.root.dataprovider.DataProviderException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class SettingDataException extends DataProviderException {
    public static final int ERROR_CODE_BINDAMAP = 1;
    private int mErrorCode;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SettingDataProviderErrorCode {
    }

    public SettingDataException(String str) {
        super(str);
    }

    public SettingDataException(int i) {
        super("");
        this.mErrorCode = i;
    }

    public SettingDataException(int i, String str) {
        super(str == null ? "" : str);
        this.mErrorCode = i;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.DataProviderException
    public int getErrorCode() {
        return this.mErrorCode;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.DataProviderException
    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }
}
