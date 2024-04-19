package com.xiaopeng.montecarlo.navcore.sr;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SharedMemory;
import androidx.annotation.RequiresApi;
import io.reactivex.annotations.NonNull;
@RequiresApi(api = 27)
/* loaded from: classes3.dex */
public class XpuBinderData implements Parcelable {
    public static final Parcelable.Creator<XpuBinderData> CREATOR = new Parcelable.Creator<XpuBinderData>() { // from class: com.xiaopeng.montecarlo.navcore.sr.XpuBinderData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XpuBinderData createFromParcel(Parcel parcel) {
            return new XpuBinderData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XpuBinderData[] newArray(int i) {
            return new XpuBinderData[i];
        }
    };
    public long mCurrentTimeInMillis;
    public byte[] mGnssData;
    public byte[] mImuData;
    public long mIndex;
    public SharedMemory mProto2AMap;
    public SharedMemory mProto2App;
    public long mUpTimeInMillis;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private XpuBinderData(Parcel parcel) {
        this.mIndex = parcel.readLong();
        this.mUpTimeInMillis = parcel.readLong();
        this.mCurrentTimeInMillis = parcel.readLong();
        this.mProto2App = (SharedMemory) parcel.readParcelable(SharedMemory.class.getClassLoader());
        this.mProto2AMap = (SharedMemory) parcel.readParcelable(SharedMemory.class.getClassLoader());
        this.mImuData = parcel.createByteArray();
        this.mGnssData = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mIndex);
        parcel.writeLong(this.mUpTimeInMillis);
        parcel.writeLong(this.mCurrentTimeInMillis);
        parcel.writeParcelable(this.mProto2App, i);
        parcel.writeParcelable(this.mProto2AMap, i);
        parcel.writeByteArray(this.mImuData);
        parcel.writeByteArray(this.mGnssData);
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BinderData{hasProto2App=");
        sb.append(this.mProto2App != null);
        sb.append(", hasProto2AMap=");
        sb.append(this.mProto2AMap != null);
        sb.append(", hasImuData=");
        sb.append(this.mImuData != null);
        sb.append(", hasGnssData=");
        sb.append(this.mGnssData != null);
        sb.append(", mIndex=");
        sb.append(this.mIndex);
        sb.append(", mUpTimeInMillis=");
        sb.append(this.mUpTimeInMillis);
        sb.append(", mCurrentTimeInMillis=");
        sb.append(this.mCurrentTimeInMillis);
        sb.append('}');
        return sb.toString();
    }
}
