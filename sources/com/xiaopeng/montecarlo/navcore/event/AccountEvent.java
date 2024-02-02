package com.xiaopeng.montecarlo.navcore.event;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.gbl.user.account.model.AccountAosResult;
/* loaded from: classes2.dex */
public class AccountEvent implements Parcelable {
    public static final Parcelable.Creator<AccountEvent> CREATOR = new Parcelable.Creator<AccountEvent>() { // from class: com.xiaopeng.montecarlo.navcore.event.AccountEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccountEvent createFromParcel(Parcel parcel) {
            return new AccountEvent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccountEvent[] newArray(int i) {
            return new AccountEvent[i];
        }
    };
    public static final int QRCODE_LOGIN_CONFIRM_RESULT_FAILED = 2;
    public static final int QRCODE_LOGIN_CONFIRM_RESULT_SUCCESS = 1;
    public static final int TYPE_REQUEST_GET_QRCODE_LOGIN = 0;
    private AccountAosResult mAccountAosResult;
    private Bitmap mBitmap;
    private int mStatus;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AccountEvent(AccountAosResult accountAosResult) {
        this.mAccountAosResult = accountAosResult;
    }

    protected AccountEvent(Parcel parcel) {
        this.mStatus = parcel.readInt();
        this.mBitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public AccountAosResult getAccountAosResult() {
        return this.mAccountAosResult;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mStatus);
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        parcel.writeParcelable(this.mBitmap, i);
    }
}
