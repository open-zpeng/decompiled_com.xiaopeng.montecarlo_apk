package com.xiaopeng.montecarlo.navcore.mapdisplay;

import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
/* loaded from: classes3.dex */
public class PoolBytes {
    private static final int MAX_POOL_SIZE = 50;
    private static PoolBytes sPool;
    public byte[] mBytes;
    public int mHeight;
    PoolBytes mNext;
    public int mWidth;
    public static final Object sPoolSync = new Object();
    private static int sPoolSize = 0;

    PoolBytes(byte[] bArr, int i, int i2) {
        this.mBytes = bArr;
        this.mWidth = i;
        this.mHeight = i2;
    }

    public static PoolBytes obtainBytes(int i, int i2, int i3) {
        synchronized (sPoolSync) {
            if (sPool != null) {
                PoolBytes poolBytes = sPool;
                sPool = poolBytes.mNext;
                poolBytes.mNext = null;
                sPoolSize--;
                if (poolBytes.mBytes.length != i) {
                    poolBytes.mBytes = new byte[i];
                }
                poolBytes.mWidth = i2;
                poolBytes.mHeight = i3;
                return poolBytes;
            }
            return new PoolBytes(new byte[i], i2, i3);
        }
    }

    public void recycle() {
        synchronized (sPoolSync) {
            if (sPoolSize < 50) {
                this.mNext = sPool;
                sPool = this;
                sPoolSize++;
            }
        }
    }

    public void raw2RGB565(byte[] bArr, int i, int i2) {
        synchronized (sPoolSync) {
            if (this.mBytes != null && bArr != null) {
                if (i == this.mWidth && i2 == this.mHeight) {
                    System.arraycopy(this.mBytes, 0, bArr, 0, i * i2 * 2);
                } else {
                    for (int i3 = 0; i3 < this.mHeight; i3++) {
                        System.arraycopy(this.mBytes, this.mWidth * i3 * 2, bArr, i3 * i * 2, i * 2);
                    }
                }
            }
        }
    }

    public void raw2RGB888(byte[] bArr, int i, int i2) {
        synchronized (sPoolSync) {
            if (this.mBytes != null) {
                int i3 = this.mWidth * this.mHeight * 2;
                int i4 = 0;
                int i5 = 0;
                while (i4 < i3) {
                    int i6 = ((i * 2) + i4) - 1;
                    int i7 = i5;
                    for (int i8 = i4; i8 <= i6; i8 += 2) {
                        int i9 = i8 + 1;
                        byte b = (byte) (this.mBytes[i9] & 248);
                        byte b2 = (byte) ((this.mBytes[i9] << 5) | ((this.mBytes[i8] & 224) >> 3));
                        byte b3 = (byte) (this.mBytes[i8] << 3);
                        bArr[i7] = (byte) (b | ((b & 56) >> 3));
                        bArr[i7 + 1] = (byte) (b2 | ((b2 & MqttWireMessage.MESSAGE_TYPE_PINGREQ) >> 2));
                        bArr[i7 + 2] = (byte) (((b3 & 56) >> 3) | b3);
                        i7 += 3;
                    }
                    i4 += this.mWidth * 2;
                    i5 = i7;
                }
            }
        }
    }

    public void raw2RGB8888(byte[] bArr, int i, int i2) {
        synchronized (sPoolSync) {
            if (this.mBytes != null && bArr != null) {
                if (i == this.mWidth && i2 == this.mHeight) {
                    System.arraycopy(this.mBytes, 0, bArr, 0, i * i2 * 4);
                } else {
                    for (int i3 = 0; i3 < this.mHeight; i3++) {
                        System.arraycopy(this.mBytes, this.mWidth * i3 * 4, bArr, i3 * i * 4, i * 4);
                    }
                }
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        recycle();
    }
}
