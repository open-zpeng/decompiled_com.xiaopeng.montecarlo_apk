package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class SearchDeleteResult implements Parcelable {
    public static final Parcelable.Creator<SearchDeleteResult> CREATOR = new Parcelable.Creator<SearchDeleteResult>() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchDeleteResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchDeleteResult createFromParcel(Parcel parcel) {
            return new SearchDeleteResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchDeleteResult[] newArray(int i) {
            return new SearchDeleteResult[i];
        }
    };
    private List<FavoriteAddress> mDeleteFavoritesList;
    private int mDeletedCount;
    private HistoryRecordInfo mDeletedHistoryRecord;
    private int mDeletedPosition;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SearchDeleteResult() {
        this.mDeletedCount = -1;
        this.mDeletedPosition = -1;
    }

    protected SearchDeleteResult(Parcel parcel) {
        this.mDeletedCount = -1;
        this.mDeletedPosition = -1;
        this.mDeletedCount = parcel.readInt();
        this.mDeletedPosition = parcel.readInt();
        this.mDeletedHistoryRecord = (HistoryRecordInfo) parcel.readParcelable(HistoryRecordInfo.class.getClassLoader());
        parcel.readTypedList(this.mDeleteFavoritesList, FavoriteAddress.CREATOR);
    }

    public int getDeletedCount() {
        return this.mDeletedCount;
    }

    public void setDeletedCount(int i) {
        this.mDeletedCount = i;
    }

    public int getDeletedPosition() {
        return this.mDeletedPosition;
    }

    public void setDeletedPosition(int i) {
        this.mDeletedPosition = i;
    }

    public HistoryRecordInfo getDeletedHistoryRecord() {
        return this.mDeletedHistoryRecord;
    }

    public void setDeletedHistoryRecord(HistoryRecordInfo historyRecordInfo) {
        this.mDeletedHistoryRecord = historyRecordInfo;
    }

    public List<FavoriteAddress> getDeleteFavoritesList() {
        return this.mDeleteFavoritesList;
    }

    public void setDeleteFavoritesList(List<FavoriteAddress> list) {
        this.mDeleteFavoritesList = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mDeletedCount);
        parcel.writeInt(this.mDeletedPosition);
        parcel.writeParcelable(this.mDeletedHistoryRecord, i);
        parcel.writeTypedList(this.mDeleteFavoritesList);
    }
}
