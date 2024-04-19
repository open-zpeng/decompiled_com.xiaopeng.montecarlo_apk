package com.xiaopeng.montecarlo.root.dataprovider;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public abstract class BaseResultData implements Parcelable {
    protected String mId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BaseResultData() {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseResultData(Parcel parcel) {
        this.mId = parcel.readString();
    }
}
