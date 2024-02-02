package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import com.xiaopeng.montecarlo.root.dataprovider.BaseParameter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
/* loaded from: classes3.dex */
public class SearchRequestParam extends BaseParameter {
    public static final int SEARCH_TYPE_ALONG_ROUTE = 2;
    public static final int SEARCH_TYPE_CHARGE = 5;
    public static final int SEARCH_TYPE_CHARGE_ALONG_WAY = 6;
    public static final int SEARCH_TYPE_DELETE_ALL_FAVOURITE = 9;
    public static final int SEARCH_TYPE_DELETE_ALL_HISTORY = 10;
    public static final int SEARCH_TYPE_DELETE_FAVOURITE = 7;
    public static final int SEARCH_TYPE_DELETE_HISTORY = 8;
    public static final int SEARCH_TYPE_DETAILINFO = 12;
    public static final int SEARCH_TYPE_FAVOURITE = 0;
    public static final int SEARCH_TYPE_HISTORY = 1;
    public static final int SEARCH_TYPE_INVALID = -1;
    public static final int SEARCH_TYPE_KEYWORD = 4;
    public static final int SEARCH_TYPE_KEYWORD_AROUND = 13;
    public static final int SEARCH_TYPE_LOAD_DISTANCE = 11;
    public static final int SEARCH_TYPE_NAVI_SEARCH = 14;
    public static final int SEARCH_TYPE_NORMAL_FAV_COUNT = 15;
    public static final int SEARCH_TYPE_SUGGESTION = 3;
    private boolean mIsLoad;
    private List<String> mPoiIdList;
    private int mSearchDest;
    private int mSearchId;
    private int mSearchMode;
    private long mShowTime;
    private long mUpdateTime;
    protected int mSearchType = -1;
    protected volatile boolean mIsAborted = false;
    private boolean mIsPaging = false;
    private int mPageSize = 20;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SearchType {
    }

    public void setShowTime(long j) {
        this.mShowTime = j;
    }

    public long getShowTime() {
        return this.mShowTime;
    }

    public long getUpdateTime() {
        return this.mUpdateTime;
    }

    public void setUpdateTime(long j) {
        this.mUpdateTime = j;
    }

    public void setPaging(boolean z) {
        this.mIsPaging = z;
    }

    public boolean isPaging() {
        return this.mIsPaging;
    }

    public void setPoiIdList(List<String> list) {
        this.mPoiIdList = list;
    }

    public List<String> getPoiIdList() {
        return this.mPoiIdList;
    }

    public void setPageSize(int i) {
        this.mPageSize = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public int getSearchDest() {
        return this.mSearchDest;
    }

    public void setSearchDest(int i) {
        this.mSearchDest = i;
    }

    public void setSearchMode(int i) {
        this.mSearchMode = i;
    }

    public int getSearchMode() {
        return this.mSearchMode;
    }

    public boolean isLoad() {
        return this.mIsLoad;
    }

    public void setLoad(boolean z) {
        this.mIsLoad = z;
    }

    public int getSearchType() {
        return this.mSearchType;
    }

    public void setSearchType(int i) {
        this.mSearchType = i;
    }

    public boolean isAborted() {
        return this.mIsAborted;
    }

    public void setAborted(boolean z) {
        this.mIsAborted = z;
    }

    public int getSearchId() {
        return this.mSearchId;
    }

    public void setSearchId(int i) {
        this.mSearchId = i;
    }
}
