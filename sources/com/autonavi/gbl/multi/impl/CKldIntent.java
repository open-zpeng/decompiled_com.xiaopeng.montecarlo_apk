package com.autonavi.gbl.multi.impl;
/* loaded from: classes2.dex */
public class CKldIntent {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void clearExtra1Native(long j, CKldIntent cKldIntent, short[] sArr);

    private static native void clearExtraNative(long j, CKldIntent cKldIntent);

    private static native long cloneNative(long j, CKldIntent cKldIntent);

    private static native long createNativeObj();

    private static native long createNativeObj1(long j, CKldIntent cKldIntent);

    private static native void destroyNativeObj(long j);

    private static native boolean getBoolExtraNative(long j, CKldIntent cKldIntent, short[] sArr, boolean[] zArr);

    private static native boolean getDoubleExtraNative(long j, CKldIntent cKldIntent, short[] sArr, double[] dArr);

    private static native boolean getFloatExtraNative(long j, CKldIntent cKldIntent, short[] sArr, float[] fArr);

    private static native boolean getInt32ExtraNative(long j, CKldIntent cKldIntent, short[] sArr, int[] iArr);

    private static native boolean getInt64ExtraNative(long j, CKldIntent cKldIntent, short[] sArr, long[] jArr);

    private static native boolean getStringExtraNative(long j, CKldIntent cKldIntent, short[] sArr, String str);

    private static native boolean getUInt32ExtraNative(long j, CKldIntent cKldIntent, short[] sArr, long[] jArr);

    private static native boolean getUnicodeStringExtraNative(long j, CKldIntent cKldIntent, short[] sArr, short[] sArr2);

    private static native boolean putBoolExtraNative(long j, CKldIntent cKldIntent, short[] sArr, boolean z);

    private static native boolean putDoubleExtraNative(long j, CKldIntent cKldIntent, short[] sArr, double d);

    private static native boolean putFloatExtraNative(long j, CKldIntent cKldIntent, short[] sArr, float f);

    private static native boolean putInt32ExtraNative(long j, CKldIntent cKldIntent, short[] sArr, int i);

    private static native boolean putInt64ExtraNative(long j, CKldIntent cKldIntent, short[] sArr, long j2);

    private static native boolean putStringExtraNative(long j, CKldIntent cKldIntent, short[] sArr, String str);

    private static native boolean putUInt32ExtraNative(long j, CKldIntent cKldIntent, short[] sArr, long j2);

    private static native boolean putUnicodeStringExtraNative(long j, CKldIntent cKldIntent, short[] sArr, short[] sArr2);

    public CKldIntent(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CKldIntent cKldIntent) {
        if (cKldIntent == null) {
            return 0L;
        }
        return cKldIntent.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public CKldIntent() {
        this(createNativeObj(), true);
    }

    public CKldIntent(CKldIntent cKldIntent) {
        this(createNativeObj1(getCPtr(cKldIntent), cKldIntent), true);
    }

    /* renamed from: clone */
    public CKldIntent m82clone() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long cloneNative = cloneNative(j, this);
        if (cloneNative == 0) {
            return null;
        }
        return new CKldIntent(cloneNative, false);
    }

    public boolean putBoolExtra(short[] sArr, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return putBoolExtraNative(j, this, sArr, z);
    }

    public boolean getBoolExtra(short[] sArr, boolean[] zArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getBoolExtraNative(j, this, sArr, zArr);
    }

    public boolean putInt32Extra(short[] sArr, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return putInt32ExtraNative(j, this, sArr, i);
    }

    public boolean getInt32Extra(short[] sArr, int[] iArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getInt32ExtraNative(j, this, sArr, iArr);
    }

    public boolean putUInt32Extra(short[] sArr, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return putUInt32ExtraNative(j2, this, sArr, j);
    }

    public boolean getUInt32Extra(short[] sArr, long[] jArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getUInt32ExtraNative(j, this, sArr, jArr);
    }

    public boolean putInt64Extra(short[] sArr, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return putInt64ExtraNative(j2, this, sArr, j);
    }

    public boolean getInt64Extra(short[] sArr, long[] jArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getInt64ExtraNative(j, this, sArr, jArr);
    }

    public boolean putFloatExtra(short[] sArr, float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return putFloatExtraNative(j, this, sArr, f);
    }

    public boolean getFloatExtra(short[] sArr, float[] fArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getFloatExtraNative(j, this, sArr, fArr);
    }

    public boolean putDoubleExtra(short[] sArr, double d) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return putDoubleExtraNative(j, this, sArr, d);
    }

    public boolean getDoubleExtra(short[] sArr, double[] dArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDoubleExtraNative(j, this, sArr, dArr);
    }

    public boolean putStringExtra(short[] sArr, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return putStringExtraNative(j, this, sArr, str);
    }

    public boolean getStringExtra(short[] sArr, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getStringExtraNative(j, this, sArr, str);
    }

    public boolean putUnicodeStringExtra(short[] sArr, short[] sArr2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return putUnicodeStringExtraNative(j, this, sArr, sArr2);
    }

    public boolean getUnicodeStringExtra(short[] sArr, short[] sArr2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getUnicodeStringExtraNative(j, this, sArr, sArr2);
    }

    public void clearExtra() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearExtraNative(j, this);
    }

    public void clearExtra(short[] sArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearExtra1Native(j, this, sArr);
    }
}
