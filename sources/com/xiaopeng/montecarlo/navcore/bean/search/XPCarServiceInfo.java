package com.xiaopeng.montecarlo.navcore.bean.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.montecarlo.root.util.L;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class XPCarServiceInfo implements Parcelable, Serializable {
    private String mAutoId;
    private boolean mChargeable;
    private boolean mDelCenter;
    private boolean mExpCenter;
    private boolean mSerCenter;
    private int mStatus;
    private int mType;
    private boolean mVisible;
    private static final L.Tag TAG = new L.Tag("XPCarServiceInfo");
    public static final Parcelable.Creator<XPCarServiceInfo> CREATOR = new Parcelable.Creator<XPCarServiceInfo>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPCarServiceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPCarServiceInfo createFromParcel(Parcel parcel) {
            return new XPCarServiceInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPCarServiceInfo[] newArray(int i) {
            return new XPCarServiceInfo[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof XPCarServiceInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof XPCarServiceInfo) {
            XPCarServiceInfo xPCarServiceInfo = (XPCarServiceInfo) obj;
            if (xPCarServiceInfo.canEqual(this) && isChargeable() == xPCarServiceInfo.isChargeable() && isVisible() == xPCarServiceInfo.isVisible() && getStatus() == xPCarServiceInfo.getStatus() && getType() == xPCarServiceInfo.getType() && isExpCenter() == xPCarServiceInfo.isExpCenter() && isDelCenter() == xPCarServiceInfo.isDelCenter() && isSerCenter() == xPCarServiceInfo.isSerCenter()) {
                String autoId = getAutoId();
                String autoId2 = xPCarServiceInfo.getAutoId();
                return autoId != null ? autoId.equals(autoId2) : autoId2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int status = (((((((((((((isChargeable() ? 79 : 97) + 59) * 59) + (isVisible() ? 79 : 97)) * 59) + getStatus()) * 59) + getType()) * 59) + (isExpCenter() ? 79 : 97)) * 59) + (isDelCenter() ? 79 : 97)) * 59) + (isSerCenter() ? 79 : 97);
        String autoId = getAutoId();
        return (status * 59) + (autoId == null ? 43 : autoId.hashCode());
    }

    public void setAutoId(String str) {
        this.mAutoId = str;
    }

    public void setChargeable(boolean z) {
        this.mChargeable = z;
    }

    public void setDelCenter(boolean z) {
        this.mDelCenter = z;
    }

    public void setExpCenter(boolean z) {
        this.mExpCenter = z;
    }

    public void setSerCenter(boolean z) {
        this.mSerCenter = z;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void setVisible(boolean z) {
        this.mVisible = z;
    }

    public String toString() {
        return "XPCarServiceInfo(mAutoId=" + getAutoId() + ", mChargeable=" + isChargeable() + ", mVisible=" + isVisible() + ", mStatus=" + getStatus() + ", mType=" + getType() + ", mExpCenter=" + isExpCenter() + ", mDelCenter=" + isDelCenter() + ", mSerCenter=" + isSerCenter() + ")";
    }

    public String getAutoId() {
        return this.mAutoId;
    }

    public boolean isChargeable() {
        return this.mChargeable;
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public int getType() {
        return this.mType;
    }

    public boolean isExpCenter() {
        return this.mExpCenter;
    }

    public boolean isDelCenter() {
        return this.mDelCenter;
    }

    public boolean isSerCenter() {
        return this.mSerCenter;
    }

    public XPCarServiceInfo() {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAutoId);
        parcel.writeByte(this.mChargeable ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mVisible ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mStatus);
        parcel.writeInt(this.mType);
        parcel.writeByte(this.mExpCenter ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mDelCenter ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mSerCenter ? (byte) 1 : (byte) 0);
    }

    protected XPCarServiceInfo(Parcel parcel) {
        this.mAutoId = parcel.readString();
        this.mChargeable = parcel.readByte() != 0;
        this.mVisible = parcel.readByte() != 0;
        this.mStatus = parcel.readInt();
        this.mType = parcel.readInt();
        this.mExpCenter = parcel.readByte() != 0;
        this.mDelCenter = parcel.readByte() != 0;
        this.mSerCenter = parcel.readByte() != 0;
    }
}
