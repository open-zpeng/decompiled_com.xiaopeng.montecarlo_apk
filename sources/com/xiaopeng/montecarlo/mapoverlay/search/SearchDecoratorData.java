package com.xiaopeng.montecarlo.mapoverlay.search;

import android.os.Parcelable;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchDecoratorData {
    private final Parcelable mFavoritePoi;
    private final int mFirstVisibleItemPosition;
    private final ArrayList<XPPoiInfo> mPoiList;
    private final int mSearchType;

    public int getSearchType() {
        return this.mSearchType;
    }

    public int getFirstVisibleItemPposition() {
        return this.mFirstVisibleItemPosition;
    }

    public ArrayList<XPPoiInfo> getPoiList() {
        return this.mPoiList;
    }

    public Parcelable getFavoritePoi() {
        return this.mFavoritePoi;
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private Parcelable mFavoritePoi;
        private int mFirstVisibleItemPosition;
        private ArrayList<XPPoiInfo> mPoiList;
        private int mSearchType;

        public Builder searchType(int i) {
            this.mSearchType = i;
            return this;
        }

        public Builder firstVisibleItemPosition(int i) {
            this.mFirstVisibleItemPosition = i;
            return this;
        }

        public Builder poiList(ArrayList<XPPoiInfo> arrayList) {
            this.mPoiList = arrayList;
            return this;
        }

        public Builder favoritepPoi(Parcelable parcelable) {
            this.mFavoritePoi = parcelable;
            return this;
        }

        public SearchDecoratorData builder() {
            return new SearchDecoratorData(this);
        }
    }

    private SearchDecoratorData(Builder builder) {
        this.mSearchType = builder.mSearchType;
        this.mFirstVisibleItemPosition = builder.mFirstVisibleItemPosition;
        this.mFavoritePoi = builder.mFavoritePoi;
        this.mPoiList = builder.mPoiList;
    }
}
