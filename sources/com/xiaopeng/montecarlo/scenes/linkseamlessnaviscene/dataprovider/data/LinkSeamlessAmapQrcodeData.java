package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.montecarlo.navcore.event.AccountEvent;
/* loaded from: classes3.dex */
public class LinkSeamlessAmapQrcodeData extends LinkSeamlessBaseData {
    public static final Parcelable.Creator<LinkSeamlessAmapQrcodeData> CREATOR = new Parcelable.Creator<LinkSeamlessAmapQrcodeData>() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessAmapQrcodeData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkSeamlessAmapQrcodeData createFromParcel(Parcel parcel) {
            LinkSeamlessAmapQrcodeData linkSeamlessAmapQrcodeData = new LinkSeamlessAmapQrcodeData();
            linkSeamlessAmapQrcodeData.setEvent((AccountEvent) parcel.readParcelable(AccountEvent.class.getClassLoader()));
            return linkSeamlessAmapQrcodeData;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkSeamlessAmapQrcodeData[] newArray(int i) {
            return new LinkSeamlessAmapQrcodeData[i];
        }
    };
    private AccountEvent mEvent;

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBaseData, com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AccountEvent getEvent() {
        return this.mEvent;
    }

    public void setEvent(AccountEvent accountEvent) {
        this.mEvent = accountEvent;
    }

    public LinkSeamlessAmapQrcodeData() {
    }

    protected LinkSeamlessAmapQrcodeData(Parcel parcel) {
        super(parcel);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBaseData, com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mEvent, 0);
    }
}
