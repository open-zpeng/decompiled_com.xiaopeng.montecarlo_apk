package com.xiaopeng.montecarlo.scenes.searchscene;

import android.os.Parcelable;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PresenterData {
    private static final L.Tag TAG = new L.Tag("PresenterData");
    private final int mAnimType;
    private final XPPoiInfo mAroundPoi;
    private final int mFromSceneChildIndex;
    private final int mFromSceneIndex;
    private final boolean mHasSaveState;
    private final boolean mIsOnWayOfVF;
    private final int mPreviousSceneMode;
    private final String mSaveEtSearch;
    private final List<FavoriteAddress> mSaveFavoriteAddressList;
    private final List<HistoryRecordInfo> mSaveHistoryRecordList;
    private final ArrayList<XPPoiInfo> mSaveSearchData;
    private final int mSearchDest;
    private final String mSearchFromKey;
    private final String mSearchKeywordText;
    private final int mSearchMode;
    private final int mSearchModeView;
    private final int mSearchRadius;
    private final ArrayList<XPPoiInfo> mSearchResult;
    private final Parcelable mSearchResultFavoritePoi;
    private final Parcelable mSearchResultSearchParams;
    private final int mSearchType;
    private final int mStartFrom;
    private final int mSubContainerType;

    private PresenterData(Builder builder) {
        this.mSearchMode = builder.mSearchMode;
        this.mSearchModeView = builder.mSearchModeView;
        this.mFromSceneIndex = builder.mFromSceneIndex;
        this.mFromSceneChildIndex = builder.mFromSceneChildIndex;
        this.mAroundPoi = builder.mAroundPoi;
        this.mSearchDest = builder.mSearchDest;
        this.mSearchType = builder.mSearchType;
        this.mSearchResult = builder.mSearchResult;
        this.mSearchResultSearchParams = builder.mSearchResultSearchParams;
        this.mSearchResultFavoritePoi = builder.mSearchResultFavoritePoi;
        this.mSearchFromKey = builder.mSearchFromKey;
        this.mAnimType = builder.mAnimType;
        this.mSearchKeywordText = builder.mSearchKeywordText;
        this.mSearchRadius = builder.mSearchRadius;
        this.mHasSaveState = builder.mHasSaveState;
        this.mSubContainerType = builder.mSubContainerType;
        this.mSaveEtSearch = builder.mSaveEtSearch;
        this.mSaveSearchData = builder.mSaveSearchData;
        this.mSaveFavoriteAddressList = builder.mSaveFavoriteAddressList;
        this.mSaveHistoryRecordList = builder.mSaveHistoryRecordList;
        this.mStartFrom = builder.mStartFrom;
        this.mIsOnWayOfVF = builder.mIsOnWayOfVF;
        this.mPreviousSceneMode = builder.mPreviousSceneMode;
    }

    public int getSearchType() {
        return this.mSearchType;
    }

    public int getSearchRadius() {
        return this.mSearchRadius;
    }

    public int getSearchModeView() {
        return this.mSearchModeView;
    }

    public boolean isOnWayOfVoiceFusion() {
        return this.mIsOnWayOfVF;
    }

    public int getSearchMode() {
        return this.mSearchMode;
    }

    public int getPreviousSceneMode() {
        return this.mPreviousSceneMode;
    }

    public int getFromSceneIndex() {
        return this.mFromSceneIndex;
    }

    public int getFromSceneChildIndex() {
        return this.mFromSceneChildIndex;
    }

    public XPPoiInfo getAroundPoi() {
        return this.mAroundPoi;
    }

    public int getSearchDest() {
        return this.mSearchDest;
    }

    public ArrayList<XPPoiInfo> getSearchResult() {
        return this.mSearchResult;
    }

    public Parcelable getSearchResultSearchParams() {
        return this.mSearchResultSearchParams;
    }

    public String getSearchFromKey() {
        return this.mSearchFromKey;
    }

    public Parcelable getSearchResultFavoritePoi() {
        return this.mSearchResultFavoritePoi;
    }

    public int getAnimType() {
        return this.mAnimType;
    }

    public String getSearchKeywordText() {
        return this.mSearchKeywordText;
    }

    public boolean hasSaveState() {
        return this.mHasSaveState;
    }

    public List<HistoryRecordInfo> getSaveHistoryRecordList() {
        return this.mSaveHistoryRecordList;
    }

    public List<FavoriteAddress> getSaveFavoriteAddressList() {
        return this.mSaveFavoriteAddressList;
    }

    public String getSaveEtSearch() {
        return this.mSaveEtSearch;
    }

    public ArrayList<XPPoiInfo> getSaveSearchData() {
        return this.mSaveSearchData;
    }

    public int getSubContainerType() {
        return this.mSubContainerType;
    }

    public int getStartFrom() {
        return this.mStartFrom;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private int mAnimType;
        private XPPoiInfo mAroundPoi;
        private int mFromSceneChildIndex;
        private int mFromSceneIndex;
        private boolean mHasSaveState;
        private boolean mIsOnWayOfVF = false;
        private int mPreviousSceneMode = StatusConst.Mode.EMPTY.ordinal();
        private String mSaveEtSearch;
        private List<FavoriteAddress> mSaveFavoriteAddressList;
        private List<HistoryRecordInfo> mSaveHistoryRecordList;
        private ArrayList<XPPoiInfo> mSaveSearchData;
        private int mSearchDest;
        private String mSearchFromKey;
        private String mSearchKeywordText;
        private int mSearchMode;
        private int mSearchModeView;
        private int mSearchRadius;
        private ArrayList<XPPoiInfo> mSearchResult;
        private Parcelable mSearchResultFavoritePoi;
        private Parcelable mSearchResultSearchParams;
        private int mSearchType;
        private int mStartFrom;
        private int mSubContainerType;

        public Builder previousSceneMode(int i) {
            this.mPreviousSceneMode = i;
            return this;
        }

        public Builder searchMode(int i) {
            this.mSearchMode = i;
            return this;
        }

        public Builder searchModeView(int i) {
            this.mSearchModeView = i;
            return this;
        }

        public Builder fromSceneIndex(int i) {
            this.mFromSceneIndex = i;
            return this;
        }

        public Builder fromSceneChildIndex(int i) {
            this.mFromSceneChildIndex = i;
            return this;
        }

        public Builder aroundPoi(XPPoiInfo xPPoiInfo) {
            this.mAroundPoi = xPPoiInfo;
            return this;
        }

        public Builder searchDest(int i) {
            this.mSearchDest = i;
            return this;
        }

        public Builder searchType(int i) {
            this.mSearchType = i;
            return this;
        }

        public Builder searchResult(ArrayList<XPPoiInfo> arrayList) {
            if (arrayList != null && arrayList.size() > 50) {
                L.Tag tag = PresenterData.TAG;
                L.i(tag, "searchResult xpPoiInfos.size():" + arrayList.size());
                this.mSearchResult = new ArrayList<>(arrayList.subList(0, 49));
            } else {
                this.mSearchResult = arrayList;
            }
            return this;
        }

        public Builder searchResultSearchParams(Parcelable parcelable) {
            this.mSearchResultSearchParams = parcelable;
            return this;
        }

        public Builder searchResultFavoritePoi(Parcelable parcelable) {
            this.mSearchResultFavoritePoi = parcelable;
            return this;
        }

        public Builder searchFromKey(String str) {
            this.mSearchFromKey = str;
            return this;
        }

        public Builder animType(int i) {
            this.mAnimType = i;
            return this;
        }

        public Builder searchKeywordText(String str) {
            this.mSearchKeywordText = str;
            return this;
        }

        public Builder searchRadius(int i) {
            this.mSearchRadius = i;
            return this;
        }

        public Builder hasSaveState(boolean z) {
            this.mHasSaveState = z;
            return this;
        }

        public Builder subContainerType(int i) {
            this.mSubContainerType = i;
            return this;
        }

        public Builder saveEtSearch(String str) {
            this.mSaveEtSearch = str;
            return this;
        }

        public Builder saveSearchData(ArrayList<XPPoiInfo> arrayList) {
            this.mSaveSearchData = arrayList;
            return this;
        }

        public Builder saveHistoryRecordList(List<HistoryRecordInfo> list) {
            this.mSaveHistoryRecordList = list;
            return this;
        }

        public Builder saveFavoriteAddressList(List<FavoriteAddress> list) {
            this.mSaveFavoriteAddressList = list;
            return this;
        }

        public Builder startFrom(int i) {
            this.mStartFrom = i;
            return this;
        }

        public Builder isOnWayOfVoiceFusion(boolean z) {
            this.mIsOnWayOfVF = z;
            return this;
        }

        public PresenterData build() {
            return new PresenterData(this);
        }
    }
}
