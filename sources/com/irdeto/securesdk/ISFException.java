package com.irdeto.securesdk;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
/* loaded from: classes2.dex */
public class ISFException extends Exception {
    private static final String UNDEFINED = "undefined";
    private int errorCode;
    private String message;

    public ISFException(int i) {
        this(i, "");
    }

    public ISFException(int i, String str) {
        this.errorCode = i;
        this.message = TextUtils.isEmpty(str) ? UNDEFINED : str;
    }

    public ISFException(O000000o o000000o) {
        this(o000000o.O000000o(), o000000o.toString());
    }

    public ISFException(O000000o o000000o, String str) {
        this(o000000o.O000000o(), o000000o.toString());
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.message += LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}
