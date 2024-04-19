package com.xiaopeng.montecarlo.navcore.aimessage.type;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public final class AiButton implements Parcelable {
    public static final Parcelable.Creator<AiButton> CREATOR = new Parcelable.Creator<AiButton>() { // from class: com.xiaopeng.montecarlo.navcore.aimessage.type.AiButton.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AiButton createFromParcel(@NonNull Parcel parcel) {
            return new AiButton(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AiButton[] newArray(int i) {
            return new AiButton[i];
        }
    };
    private String mContent;
    private String mName;
    private String mPack;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AiButton() {
    }

    protected AiButton(Parcel parcel) {
        this.mContent = parcel.readString();
        this.mName = parcel.readString();
        this.mPack = parcel.readString();
    }

    public String toString() {
        return "AiButton{content='" + this.mContent + "', name='" + this.mName + "', pack='" + this.mPack + "'}";
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getPack() {
        return this.mPack;
    }

    public void setPack(String str) {
        this.mPack = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mContent);
        parcel.writeString(this.mName);
        parcel.writeString(this.mPack);
    }
}
