package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.event.SearchResponseEvent;
import com.xiaopeng.montecarlo.root.dataprovider.BaseResultData;
import java.util.List;
/* loaded from: classes3.dex */
public class SearchResultData extends BaseResultData implements Parcelable {
    public static final Parcelable.Creator<SearchResultData> CREATOR = new Parcelable.Creator<SearchResultData>() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchResultData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchResultData createFromParcel(Parcel parcel) {
            return new SearchResultData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchResultData[] newArray(int i) {
            return new SearchResultData[i];
        }
    };
    protected List<FavoriteAddress> mFavouriteList;
    protected List<HistoryRecordInfo> mHistoryList;
    protected boolean mIsFromCached;
    public boolean mIsLoad;
    protected long mMaxRecordTime;
    protected int mNormalFavCount;
    protected SearchDeleteResult mSearchDeleteResult;
    protected SearchLoadDistanceResult mSearchLoadDistanceResult;
    protected SearchResponseEvent mSearchResponseEvent;
    protected int mSearchType;
    protected List<HistoryRecordInfo> mSuggestSearchXpPoiInfosFromCached;

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setNormalFavCount(int i) {
        this.mNormalFavCount = i;
    }

    public int getNormalFavCount() {
        return this.mNormalFavCount;
    }

    public void setMaxRecordTime(long j) {
        this.mMaxRecordTime = j;
    }

    public long getMaxRecordTime() {
        return this.mMaxRecordTime;
    }

    public void setLoad(boolean z) {
        this.mIsLoad = z;
    }

    public boolean isLoad() {
        return this.mIsLoad;
    }

    public List<FavoriteAddress> getFavouriteList() {
        return this.mFavouriteList;
    }

    public void setFavouriteList(List<FavoriteAddress> list) {
        this.mFavouriteList = list;
    }

    public List<HistoryRecordInfo> getHistoryList() {
        return this.mHistoryList;
    }

    public void setHistoryList(List<HistoryRecordInfo> list) {
        this.mHistoryList = list;
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

    public SearchDeleteResult getSearchDeleteResult() {
        return this.mSearchDeleteResult;
    }

    public void setSearchDeleteResult(SearchDeleteResult searchDeleteResult) {
        this.mSearchDeleteResult = searchDeleteResult;
    }

    public List<HistoryRecordInfo> getSuggestSearchXpPoiInfosFromCached() {
        return this.mSuggestSearchXpPoiInfosFromCached;
    }

    public void setSuggestSearchXpPoiInfosFromCached(List<HistoryRecordInfo> list) {
        this.mSuggestSearchXpPoiInfosFromCached = list;
    }

    public boolean isFromCached() {
        return this.mIsFromCached;
    }

    public void setFromCached(boolean z) {
        this.mIsFromCached = z;
    }

    public SearchLoadDistanceResult getSearchLoadDistanceResult() {
        return this.mSearchLoadDistanceResult;
    }

    public void setSearchLoadDistanceResult(SearchLoadDistanceResult searchLoadDistanceResult) {
        this.mSearchLoadDistanceResult = searchLoadDistanceResult;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mSearchType);
        parcel.writeByte(this.mIsFromCached ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.mFavouriteList);
        parcel.writeTypedList(this.mHistoryList);
        parcel.writeParcelable(this.mSearchResponseEvent, i);
        parcel.writeParcelable(this.mSearchDeleteResult, i);
        parcel.writeTypedList(this.mSuggestSearchXpPoiInfosFromCached);
        parcel.writeParcelable(this.mSearchLoadDistanceResult, i);
    }

    public SearchResultData() {
        this.mIsFromCached = false;
        this.mIsLoad = true;
    }

    protected SearchResultData(Parcel parcel) {
        super(parcel);
        this.mIsFromCached = false;
        this.mIsLoad = true;
        this.mSearchType = parcel.readInt();
        this.mIsFromCached = parcel.readByte() != 0;
        this.mFavouriteList = parcel.createTypedArrayList(FavoriteAddress.CREATOR);
        this.mHistoryList = parcel.createTypedArrayList(HistoryRecordInfo.CREATOR);
        this.mSearchResponseEvent = (SearchResponseEvent) parcel.readParcelable(SearchResponseEvent.class.getClassLoader());
        this.mSearchDeleteResult = (SearchDeleteResult) parcel.readParcelable(SearchDeleteResult.class.getClassLoader());
        this.mSuggestSearchXpPoiInfosFromCached = parcel.createTypedArrayList(HistoryRecordInfo.CREATOR);
        this.mSearchLoadDistanceResult = (SearchLoadDistanceResult) parcel.readParcelable(SearchLoadDistanceResult.class.getClassLoader());
    }
}
