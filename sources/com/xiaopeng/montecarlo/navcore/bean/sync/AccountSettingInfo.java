package com.xiaopeng.montecarlo.navcore.bean.sync;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform;
/* loaded from: classes2.dex */
public class AccountSettingInfo extends DataTransform implements Parcelable {
    public static final Parcelable.Creator<AccountSettingInfo> CREATOR = new Parcelable.Creator<AccountSettingInfo>() { // from class: com.xiaopeng.montecarlo.navcore.bean.sync.AccountSettingInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccountSettingInfo createFromParcel(Parcel parcel) {
            return new AccountSettingInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccountSettingInfo[] newArray(int i) {
            return new AccountSettingInfo[i];
        }
    };
    @SerializedName("mName")
    private String mName;
    @SerializedName("mValue")
    private String mValue;

    @Override // com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setValue(String str) {
        this.mValue = str;
    }

    public String getValue() {
        return this.mValue;
    }

    public AccountSettingInfo() {
    }

    protected AccountSettingInfo(Parcel parcel) {
        this.mName = parcel.readString();
        this.mValue = parcel.readString();
    }

    @Override // com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeString(this.mValue);
    }

    @Override // com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform
    @Nullable
    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", this.mName);
        contentValues.put("value", this.mValue);
        return contentValues;
    }

    @Override // com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform
    public void bindContentValues(Cursor cursor) {
        try {
            this.mName = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            this.mValue = cursor.getString(cursor.getColumnIndexOrThrow("value"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
