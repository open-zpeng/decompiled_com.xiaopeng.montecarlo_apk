package com.xiaopeng.montecarlo.navcore.bean.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.SearchRoadId;
/* loaded from: classes2.dex */
public class XPSearchRoadId implements Parcelable {
    public static final Parcelable.Creator<XPSearchRoadId> CREATOR = new Parcelable.Creator<XPSearchRoadId>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPSearchRoadId.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPSearchRoadId createFromParcel(@NonNull Parcel parcel) {
            return new XPSearchRoadId(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPSearchRoadId[] newArray(int i) {
            return new XPSearchRoadId[i];
        }
    };
    public long mRoadId;
    public long mTileId;
    public long mUrId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public XPSearchRoadId() {
        this.mUrId = 0L;
        this.mTileId = 0L;
        this.mRoadId = 0L;
    }

    public XPSearchRoadId(SearchRoadId searchRoadId) {
        this.mUrId = 0L;
        this.mTileId = 0L;
        this.mRoadId = 0L;
        this.mUrId = searchRoadId.urId;
        this.mTileId = searchRoadId.tileId;
        this.mRoadId = searchRoadId.roadId;
    }

    protected XPSearchRoadId(Parcel parcel) {
        this.mUrId = 0L;
        this.mTileId = 0L;
        this.mRoadId = 0L;
        this.mUrId = parcel.readLong();
        this.mTileId = parcel.readLong();
        this.mRoadId = parcel.readLong();
    }

    @NonNull
    public SearchRoadId toBLSearchRoadId() {
        SearchRoadId searchRoadId = new SearchRoadId();
        searchRoadId.urId = this.mUrId;
        searchRoadId.tileId = this.mTileId;
        searchRoadId.roadId = this.mRoadId;
        return searchRoadId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeLong(this.mUrId);
        parcel.writeLong(this.mTileId);
        parcel.writeLong(this.mRoadId);
    }
}
