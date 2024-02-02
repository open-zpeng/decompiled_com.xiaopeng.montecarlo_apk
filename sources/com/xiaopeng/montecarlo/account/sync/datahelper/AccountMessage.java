package com.xiaopeng.montecarlo.account.sync.datahelper;

import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
/* loaded from: classes2.dex */
public class AccountMessage {
    private FavoriteAddress mFavoriteAddress;
    private int mFavoriteSyncMsgType;
    private boolean mNeedSync;

    public FavoriteAddress getFavoriteAddress() {
        return this.mFavoriteAddress;
    }

    public void setFavoriteAddress(FavoriteAddress favoriteAddress) {
        this.mFavoriteAddress = favoriteAddress;
    }

    public int getFavoriteSyncMsgType() {
        return this.mFavoriteSyncMsgType;
    }

    public void setFavoriteSyncMsgType(int i) {
        this.mFavoriteSyncMsgType = i;
    }

    public boolean isNeedSync() {
        return this.mNeedSync;
    }

    public void setNeedSync(boolean z) {
        this.mNeedSync = z;
    }
}
