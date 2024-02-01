package com.xiaopeng.montecarlo.account.sync.datahelper;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.List;
/* loaded from: classes.dex */
public class XpFavDataManager extends FavoriteDataManager {
    private static final L.Tag TAG = new L.Tag("XpFavDataManager");
    private static final XpFavDataManager sInstance = new XpFavDataManager();

    @NonNull
    public static XpFavDataManager getInstance() {
        return sInstance;
    }

    @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager
    protected void notifyFavDataChange(int i, DataTransform dataTransform, List<DataTransform> list, List<DataTransform> list2) {
        FavoriteDataManager.getInstance().notifyFavDataChangeToExternal(i, dataTransform, list, list2);
        if (this.mIncreSyncFavDataChangeListener == null) {
            L.e(TAG, "notifyFavDataChangeToSync mIncreSyncFavDataChangeListener == null");
        } else {
            super.notifyFavDataChangeToSync(i, dataTransform, list, list2);
        }
    }
}
