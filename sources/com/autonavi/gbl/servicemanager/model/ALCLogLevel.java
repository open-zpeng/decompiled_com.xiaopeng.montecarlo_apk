package com.autonavi.gbl.servicemanager.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public enum ALCLogLevel implements Parcelable {
    P0(0),
    P1(1),
    P2(2),
    P3(3),
    P4(4),
    P5(5),
    LOG_TRACING(512),
    LOG_PERFORMANCE(256),
    LOG_DEBUG(8),
    LOG_INFO(16),
    LOG_WARN(32),
    LOG_ERROR(64),
    LOG_FATAL(128);
    
    private long num;
    public static final long DEFAULT_LOG_LEVEL = (LOG_WARN.getNum() | LOG_ERROR.getNum()) | LOG_FATAL.getNum();
    public static final long LogLevelNone = P0.getNum();
    public static final long LogLevelError = LOG_FATAL.getNum() | LOG_ERROR.getNum();
    public static final long LogLevelWarn = (LOG_FATAL.getNum() | LOG_ERROR.getNum()) | LOG_WARN.getNum();
    public static final long LogLevelInfo = ((LOG_FATAL.getNum() | LOG_ERROR.getNum()) | LOG_WARN.getNum()) | LOG_INFO.getNum();
    public static final long LogLevelDebug = (((LOG_FATAL.getNum() | LOG_ERROR.getNum()) | LOG_WARN.getNum()) | LOG_INFO.getNum()) | LOG_DEBUG.getNum();
    public static final long LogLevelVerbose = (((((LOG_FATAL.getNum() | LOG_ERROR.getNum()) | LOG_WARN.getNum()) | LOG_INFO.getNum()) | LOG_DEBUG.getNum()) | LOG_PERFORMANCE.getNum()) | LOG_TRACING.getNum();
    public static final Parcelable.Creator<ALCLogLevel> CREATOR = new Parcelable.Creator<ALCLogLevel>() { // from class: com.autonavi.gbl.servicemanager.model.ALCLogLevel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ALCLogLevel createFromParcel(Parcel parcel) {
            int readInt = parcel != null ? parcel.readInt() : 0;
            if (readInt != 0) {
                if (readInt != 1) {
                    if (readInt != 2) {
                        if (readInt != 3) {
                            if (readInt != 4) {
                                if (readInt != 5) {
                                    if (readInt != 8) {
                                        if (readInt != 16) {
                                            if (readInt != 32) {
                                                if (readInt != 64) {
                                                    if (readInt != 128) {
                                                        if (readInt != 256) {
                                                            if (readInt == 512) {
                                                                return ALCLogLevel.LOG_TRACING;
                                                            }
                                                            return ALCLogLevel.P5;
                                                        }
                                                        return ALCLogLevel.LOG_PERFORMANCE;
                                                    }
                                                    return ALCLogLevel.LOG_FATAL;
                                                }
                                                return ALCLogLevel.LOG_ERROR;
                                            }
                                            return ALCLogLevel.LOG_WARN;
                                        }
                                        return ALCLogLevel.LOG_INFO;
                                    }
                                    return ALCLogLevel.LOG_DEBUG;
                                }
                                return ALCLogLevel.P5;
                            }
                            return ALCLogLevel.P4;
                        }
                        return ALCLogLevel.P3;
                    }
                    return ALCLogLevel.P2;
                }
                return ALCLogLevel.P1;
            }
            return ALCLogLevel.P0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ALCLogLevel[] newArray(int i) {
            return new ALCLogLevel[0];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    ALCLogLevel(long j) {
        this.num = j;
    }

    public long getNum() {
        return this.num;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel != null) {
            parcel.writeInt(i);
        }
    }
}
