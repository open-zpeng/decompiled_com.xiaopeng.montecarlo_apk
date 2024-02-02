package com.xiaopeng.montecarlo.account.sync.datahelper;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.List;
/* loaded from: classes2.dex */
public class BlFavDataManager extends FavoriteDataManager {
    private static final L.Tag TAG = new L.Tag("BlFavDataManager");
    private static final BlFavDataManager sInstance = new BlFavDataManager();

    @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager
    protected void notifyHistoryDataChange(int i, DataTransform dataTransform, List<DataTransform> list, List<DataTransform> list2) {
    }

    @NonNull
    public static BlFavDataManager getInstance() {
        return sInstance;
    }

    @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager
    public void notifyFavDataChange(int i, DataTransform dataTransform, List<DataTransform> list, List<DataTransform> list2) {
        FavoriteDataManager.getInstance().notifyFavDataChangeToExternal(i, dataTransform, list, list2);
        if (this.mIncreSyncFavDataChangeListener == null) {
            L.e(TAG, "notifyFavDataChangeToSync mIncreSyncFavDataChangeListener == null");
        } else if (i == 11 && (CollectionUtils.isEmpty(list) || CollectionUtils.isNotEmpty(list2))) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "REPLACE_HOME_OR_COMPANY CollectionUtils.isEmpty(dtList):" + CollectionUtils.isEmpty(list) + " CollectionUtils.isNotEmpty(suppleList)：" + CollectionUtils.isNotEmpty(list2));
            }
        } else {
            super.notifyFavDataChangeToSync(i, dataTransform, list, list2);
        }
    }
}
