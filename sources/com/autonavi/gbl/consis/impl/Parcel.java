package com.autonavi.gbl.consis.impl;
/* loaded from: classes.dex */
public class Parcel {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native long createNativeObj1(long j);

    private static native long createNativeObj2(long j, Parcel parcel);

    private static native long createNativeObj3(String str, int i);

    private static native long dataCapacityNative(long j, Parcel parcel);

    private static native String dataNative(long j, Parcel parcel);

    private static native long dataPositionNative(long j, Parcel parcel);

    private static native long dataSizeNative(long j, Parcel parcel);

    private static native void destroyNativeObj(long j);

    private static native boolean readBoolNative(long j, Parcel parcel, boolean[] zArr);

    private static native boolean readDoubleNative(long j, Parcel parcel, double[] dArr);

    private static native boolean readFloatNative(long j, Parcel parcel, float[] fArr);

    private static native boolean readInt64Native(long j, Parcel parcel, long[] jArr);

    private static native boolean readIntNative(long j, Parcel parcel, int[] iArr);

    private static native String readStringNative(long j, Parcel parcel);

    private static native String releaseBufNative(long j, Parcel parcel, int[] iArr);

    private static native void setDataPositionNative(long j, Parcel parcel, long j2);

    private static native boolean writeBoolNative(long j, Parcel parcel, boolean z);

    private static native boolean writeDoubleNative(long j, Parcel parcel, double d);

    private static native boolean writeFloatNative(long j, Parcel parcel, float f);

    private static native boolean writeInt64Native(long j, Parcel parcel, long j2);

    private static native boolean writeIntNative(long j, Parcel parcel, int i);

    private static native boolean writeNative(long j, Parcel parcel, long j2, long j3);

    private static native boolean writeStringNative(long j, Parcel parcel, String str);

    public Parcel(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Parcel parcel) {
        if (parcel == null) {
            return 0L;
        }
        return parcel.swigCPtr;
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

    public Parcel() {
        this(createNativeObj(), true);
    }

    public Parcel(long j) {
        this(createNativeObj1(j), true);
    }

    public Parcel(Parcel parcel) {
        this(createNativeObj2(getCPtr(parcel), parcel), true);
    }

    public Parcel(String str, int i) {
        this(createNativeObj3(str, i), true);
    }

    public String data() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return dataNative(j, this);
    }

    public long dataSize() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return dataSizeNative(j, this);
    }

    public long dataPosition() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return dataPositionNative(j, this);
    }

    public long dataCapacity() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return dataCapacityNative(j, this);
    }

    public void setDataPosition(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setDataPositionNative(j2, this, j);
    }

    public boolean write(long j, long j2) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        return writeNative(j3, this, j, j2);
    }

    public boolean writeBool(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return writeBoolNative(j, this, z);
    }

    public boolean writeInt(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return writeIntNative(j, this, i);
    }

    public boolean writeInt64(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return writeInt64Native(j2, this, j);
    }

    public boolean writeFloat(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return writeFloatNative(j, this, f);
    }

    public boolean writeDouble(double d) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return writeDoubleNative(j, this, d);
    }

    public boolean writeString(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return writeStringNative(j, this, str);
    }

    public boolean readBool(boolean[] zArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readBoolNative(j, this, zArr);
    }

    public boolean readInt(int[] iArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readIntNative(j, this, iArr);
    }

    public boolean readInt64(long[] jArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readInt64Native(j, this, jArr);
    }

    public boolean readFloat(float[] fArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readFloatNative(j, this, fArr);
    }

    public boolean readDouble(double[] dArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readDoubleNative(j, this, dArr);
    }

    public String readString() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readStringNative(j, this);
    }

    public String releaseBuf(int[] iArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return releaseBufNative(j, this, iArr);
    }
}
