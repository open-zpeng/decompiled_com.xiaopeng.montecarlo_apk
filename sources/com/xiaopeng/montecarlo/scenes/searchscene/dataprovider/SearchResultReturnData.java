package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.montecarlo.navcore.event.SearchResponseEvent;
import com.xiaopeng.montecarlo.root.dataprovider.BaseResultData;
/* loaded from: classes3.dex */
public class SearchResultReturnData extends BaseResultData implements Parcelable {
    public static final Parcelable.Creator<SearchResultReturnData> CREATOR = new Parcelable.Creator<SearchResultReturnData>() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchResultReturnData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchResultReturnData createFromParcel(Parcel parcel) {
            return new SearchResultReturnData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchResultReturnData[] newArray(int i) {
            return new SearchResultReturnData[i];
        }
    };
    protected boolean mIsFromCached;
    protected SearchResponseEvent mSearchResponseEvent;
    protected int mSearchType;

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SearchResponseEvent getSearchResponseEvent() {
        return this.mSearchResponseEvent;
    }

    public void setSearchResponseEvent(SearchResponseEvent searchResponseEvent) {
        this.mSearchResponseEvent = searchResponseEvent;
    }

    public int getSearchType() {
        return this.mSearchType;
    }

    public void setSearchType(int i) {
        this.mSearchType = i;
    }

    public boolean isFromCached() {
        return this.mIsFromCached;
    }

    public void setFromCached(boolean z) {
        this.mIsFromCached = z;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mSearchType);
        parcel.writeByte(this.mIsFromCached ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.mSearchResponseEvent, i);
    }

    public SearchResultReturnData() {
        this.mIsFromCached = false;
    }

    protected SearchResultReturnData(Parcel parcel) {
        super(parcel);
        this.mIsFromCached = false;
        this.mSearchType = parcel.readInt();
        this.mIsFromCached = parcel.readByte() != 0;
        this.mSearchResponseEvent = (SearchResponseEvent) parcel.readParcelable(SearchResponseEvent.class.getClassLoader());
    }
}
