package com.autonavi.gbl.consis.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.ChannelParcel;
@IntfAuto(target = ChannelParcel.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ChannelParcelImpl {
    private static BindTable BIND_TABLE = new BindTable(ChannelParcelImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native long createNativeObj1(byte[] bArr);

    private static native void destroyNativeObj(long j);

    private static native byte[] getBufNative(long j, ChannelParcelImpl channelParcelImpl);

    private static native long getDataCapacityNative(long j, ChannelParcelImpl channelParcelImpl);

    private static native long getDataPositionNative(long j, ChannelParcelImpl channelParcelImpl);

    private static native long getDataSizeNative(long j, ChannelParcelImpl channelParcelImpl);

    private static native boolean readBoolNative(long j, ChannelParcelImpl channelParcelImpl, boolean[] zArr);

    private static native boolean readCharNative(long j, ChannelParcelImpl channelParcelImpl, byte[] bArr);

    private static native boolean readDataNative(long j, ChannelParcelImpl channelParcelImpl, byte[] bArr);

    private static native boolean readDoubleNative(long j, ChannelParcelImpl channelParcelImpl, double[] dArr);

    private static native boolean readFloatNative(long j, ChannelParcelImpl channelParcelImpl, float[] fArr);

    private static native boolean readInt16Native(long j, ChannelParcelImpl channelParcelImpl, short[] sArr);

    private static native boolean readInt64Native(long j, ChannelParcelImpl channelParcelImpl, long[] jArr);

    private static native boolean readIntNative(long j, ChannelParcelImpl channelParcelImpl, int[] iArr);

    private static native String readStringNative(long j, ChannelParcelImpl channelParcelImpl);

    private static native boolean readUInt16Native(long j, ChannelParcelImpl channelParcelImpl, short[] sArr);

    private static native boolean readUnSignedCharNative(long j, ChannelParcelImpl channelParcelImpl, byte[] bArr);

    private static native byte[] releaseBufNative(long j, ChannelParcelImpl channelParcelImpl);

    private static native void setDataPositionNative(long j, ChannelParcelImpl channelParcelImpl, long j2);

    private static native boolean writeBoolNative(long j, ChannelParcelImpl channelParcelImpl, boolean z);

    private static native boolean writeCharNative(long j, ChannelParcelImpl channelParcelImpl, byte b);

    private static native boolean writeDoubleNative(long j, ChannelParcelImpl channelParcelImpl, double d);

    private static native boolean writeFloatNative(long j, ChannelParcelImpl channelParcelImpl, float f);

    private static native boolean writeInt16Native(long j, ChannelParcelImpl channelParcelImpl, short s);

    private static native boolean writeInt64Native(long j, ChannelParcelImpl channelParcelImpl, long j2);

    private static native boolean writeIntNative(long j, ChannelParcelImpl channelParcelImpl, int i);

    private static native boolean writeNative(long j, ChannelParcelImpl channelParcelImpl, byte[] bArr);

    private static native boolean writeStringNative(long j, ChannelParcelImpl channelParcelImpl, String str);

    private static native boolean writeUInt16Native(long j, ChannelParcelImpl channelParcelImpl, int i);

    private static native boolean writeUnSignedCharNative(long j, ChannelParcelImpl channelParcelImpl, short s);

    public ChannelParcelImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ChannelParcelImpl) && getUID(this) == getUID((ChannelParcelImpl) obj);
    }

    private static long getUID(ChannelParcelImpl channelParcelImpl) {
        long cPtr = getCPtr(channelParcelImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ChannelParcelImpl channelParcelImpl) {
        if (channelParcelImpl == null) {
            return 0L;
        }
        return channelParcelImpl.swigCPtr;
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

    public ChannelParcelImpl() {
        this(createNativeObj(), true);
    }

    public ChannelParcelImpl(byte[] bArr) {
        this(createNativeObj1(bArr), true);
    }

    public long getDataSize() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDataSizeNative(j, this);
    }

    public long getDataPosition() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDataPositionNative(j, this);
    }

    public long getDataCapacity() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDataCapacityNative(j, this);
    }

    public void setDataPosition(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setDataPositionNative(j2, this, j);
    }

    public boolean write(byte[] bArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return writeNative(j, this, bArr);
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

    public boolean writeInt16(short s) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return writeInt16Native(j, this, s);
    }

    public boolean writeUInt16(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return writeUInt16Native(j, this, i);
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

    public boolean writeUnSignedChar(short s) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return writeUnSignedCharNative(j, this, s);
    }

    public boolean writeChar(byte b) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return writeCharNative(j, this, b);
    }

    public boolean writeString(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return writeStringNative(j, this, str);
    }

    public boolean readBool() {
        boolean[] zArr = new boolean[1];
        Boolean.valueOf(readBool(zArr));
        return zArr[0];
    }

    private boolean readBool(boolean[] zArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readBoolNative(j, this, zArr);
    }

    public int readInt() {
        int[] iArr = new int[1];
        Boolean.valueOf(readInt(iArr));
        return iArr[0];
    }

    private boolean readInt(int[] iArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readIntNative(j, this, iArr);
    }

    public long readInt64() {
        long[] jArr = new long[1];
        Boolean.valueOf(readInt64(jArr));
        return jArr[0];
    }

    private boolean readInt64(long[] jArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readInt64Native(j, this, jArr);
    }

    public short readInt16() {
        short[] sArr = new short[1];
        Boolean.valueOf(readInt16(sArr));
        return sArr[0];
    }

    private boolean readInt16(short[] sArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readInt16Native(j, this, sArr);
    }

    public short readUInt16() {
        short[] sArr = new short[1];
        Boolean.valueOf(readUInt16(sArr));
        return sArr[0];
    }

    private boolean readUInt16(short[] sArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readUInt16Native(j, this, sArr);
    }

    public float readFloat() {
        float[] fArr = new float[1];
        Boolean.valueOf(readFloat(fArr));
        return fArr[0];
    }

    private boolean readFloat(float[] fArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readFloatNative(j, this, fArr);
    }

    public double readDouble() {
        double[] dArr = new double[1];
        Boolean.valueOf(readDouble(dArr));
        return dArr[0];
    }

    private boolean readDouble(double[] dArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readDoubleNative(j, this, dArr);
    }

    public byte readUnSignedChar() {
        byte[] bArr = new byte[1];
        Boolean.valueOf(readUnSignedChar(bArr));
        return bArr[0];
    }

    private boolean readUnSignedChar(byte[] bArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readUnSignedCharNative(j, this, bArr);
    }

    public byte readChar() {
        byte[] bArr = new byte[1];
        Boolean.valueOf(readChar(bArr));
        return bArr[0];
    }

    private boolean readChar(byte[] bArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readCharNative(j, this, bArr);
    }

    public boolean readData(byte[] bArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readDataNative(j, this, bArr);
    }

    public String readString() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readStringNative(j, this);
    }

    public byte[] releaseBuf() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return releaseBufNative(j, this);
    }

    public byte[] getBuf() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getBufNative(j, this);
    }
}
