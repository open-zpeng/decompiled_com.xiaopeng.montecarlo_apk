package com.autonavi.gbl.data.model.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.data.model.DetailListParser;
import java.util.ArrayList;
@IntfAuto(target = DetailListParser.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class DetailListParserImpl {
    private static BindTable BIND_TABLE = new BindTable(DetailListParserImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native boolean getAdcodeListNative(long j, DetailListParserImpl detailListParserImpl, ArrayList<Integer> arrayList);

    private static native int getEhpValueNative(long j, DetailListParserImpl detailListParserImpl);

    private static native boolean getMapDataVersionNative(long j, DetailListParserImpl detailListParserImpl, String[] strArr);

    private static native boolean getVoiceListNative(long j, DetailListParserImpl detailListParserImpl, ArrayList<String> arrayList);

    public DetailListParserImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof DetailListParserImpl) && getUID(this) == getUID((DetailListParserImpl) obj);
    }

    private static long getUID(DetailListParserImpl detailListParserImpl) {
        long cPtr = getCPtr(detailListParserImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(DetailListParserImpl detailListParserImpl) {
        if (detailListParserImpl == null) {
            return 0L;
        }
        return detailListParserImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    protected synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public int[] getAdcodeList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (!getAdcodeList(arrayList) || arrayList.size() <= 0) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = arrayList.get(i).intValue();
        }
        return iArr;
    }

    public String[] getVoiceList() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (getVoiceList(arrayList)) {
            try {
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public String getMapDataVersion() {
        String[] strArr = new String[1];
        if (getMapDataVersion(strArr)) {
            return strArr[0];
        }
        return null;
    }

    public int getEhpValue() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getEhpValueNative(j, this);
    }

    private boolean getAdcodeList(ArrayList<Integer> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAdcodeListNative(j, this, arrayList);
    }

    private boolean getVoiceList(ArrayList<String> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVoiceListNative(j, this, arrayList);
    }

    private boolean getMapDataVersion(String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMapDataVersionNative(j, this, strArr);
    }
}
