package com.xiaopeng.montecarlo.navcore.favorite;

import android.util.LruCache;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class FavoriteCache {
    private static final L.Tag TAG = new L.Tag("FavoriteCache");
    private FavoriteAddress mHomeAddress = null;
    private FavoriteAddress mCompanyAddress = null;
    private LruCache mCommonFavoriteCache = null;
    private LruCache mHistoryRecordCache = null;

    public void clearCommonFavoriteCache() {
    }

    public void clearHistoryCache() {
    }

    public synchronized FavoriteAddress getHomeAddress() {
        return this.mHomeAddress;
    }

    public synchronized void setHomeAddress(FavoriteAddress favoriteAddress) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("setHomeAddress homeAddress:");
            sb.append(favoriteAddress != null ? GsonUtil.toJson(favoriteAddress) : " null obj");
            L.d(tag, sb.toString());
        }
        this.mHomeAddress = favoriteAddress;
    }

    public synchronized FavoriteAddress getCompanyAddress() {
        return this.mCompanyAddress;
    }

    public synchronized void setCompanyAddress(FavoriteAddress favoriteAddress) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("setCompanyAddress companyAddress:");
            sb.append(favoriteAddress != null ? GsonUtil.toJson(favoriteAddress) : " null obj");
            L.d(tag, sb.toString());
        }
        this.mCompanyAddress = favoriteAddress;
    }

    public synchronized void clearFavoriteCache() {
        if (L.ENABLE) {
            L.d(TAG, "clearFavoriteCache--");
        }
        this.mHomeAddress = null;
        this.mCompanyAddress = null;
    }
}
