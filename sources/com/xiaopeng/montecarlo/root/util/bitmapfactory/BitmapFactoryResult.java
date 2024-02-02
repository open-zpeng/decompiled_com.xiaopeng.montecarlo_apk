package com.xiaopeng.montecarlo.root.util.bitmapfactory;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class BitmapFactoryResult implements Parcelable {
    public final Parcelable.Creator<BitmapFactoryResult> CREATOR = new Parcelable.Creator<BitmapFactoryResult>() { // from class: com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BitmapFactoryResult createFromParcel(Parcel parcel) {
            return new BitmapFactoryResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BitmapFactoryResult[] newArray(int i) {
            return new BitmapFactoryResult[i];
        }
    };
    public Bitmap mBitmap;
    public int mResid;
    public int mTextureId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BitmapFactoryResult(int i, Bitmap bitmap) {
        this.mResid = i;
        this.mBitmap = bitmap;
    }

    protected BitmapFactoryResult(Parcel parcel) {
        this.mResid = parcel.readInt();
        this.mBitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mResid);
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        parcel.writeParcelable(this.mBitmap, i);
    }
}
