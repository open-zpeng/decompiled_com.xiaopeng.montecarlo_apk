package com.autonavi.gbl.util.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.LanguageTool;
@IntfAuto(target = LanguageTool.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class LanguageToolImpl {
    private static BindTable BIND_TABLE = new BindTable(LanguageToolImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native int convertS2TNative(String str, String[] strArr);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    public LanguageToolImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof LanguageToolImpl) && getUID(this) == getUID((LanguageToolImpl) obj);
    }

    private static long getUID(LanguageToolImpl languageToolImpl) {
        long cPtr = getCPtr(languageToolImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(LanguageToolImpl languageToolImpl) {
        if (languageToolImpl == null) {
            return 0L;
        }
        return languageToolImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public static String convertS2T(String str) {
        String[] strArr = new String[1];
        Integer.valueOf(convertS2T(str, strArr));
        return strArr[0];
    }

    private static int convertS2T(String str, String[] strArr) {
        return convertS2TNative(str, strArr);
    }

    public LanguageToolImpl() {
        this(createNativeObj(), true);
    }
}
