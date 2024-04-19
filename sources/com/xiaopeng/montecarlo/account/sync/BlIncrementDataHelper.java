package com.xiaopeng.montecarlo.account.sync;

import android.text.TextUtils;
import com.autonavi.gbl.user.behavior.model.FavoriteItem;
import com.autonavi.gbl.user.behavior.model.SimpleFavoriteItem;
import com.xiaopeng.montecarlo.account.AccountManager;
import com.xiaopeng.montecarlo.account.IThreadOperation;
import com.xiaopeng.montecarlo.navcore.account.AccountBehaviorServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.favorite.BlBehaviorServiceHelper;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteUtil;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class BlIncrementDataHelper {
    private IThreadOperation mIThreadOperation = null;

    public void setIThreadOperation(IThreadOperation iThreadOperation) {
        this.mIThreadOperation = iThreadOperation;
    }

    public IThreadOperation getIThreadOperation() {
        return this.mIThreadOperation;
    }

    public void insertOrReplaceFavoriteForSync(FavoriteAddress favoriteAddress, boolean z) {
        if (isThreadInterrupted() || favoriteAddress == null || TextUtils.isEmpty(BlBehaviorServiceHelper.insertOrReplaceFavorite(favoriteAddress)) || !z) {
            return;
        }
        startFavoriteSyncPullService();
    }

    public void deleteFavoriteForSync(FavoriteAddress favoriteAddress, boolean z) {
        if (isThreadInterrupted() || favoriteAddress == null || TextUtils.isEmpty(BlBehaviorServiceHelper.deleteFavorite(favoriteAddress)) || !z) {
            return;
        }
        startFavoriteSyncPullService();
    }

    public void clearFavorite(boolean z) {
        if (!isThreadInterrupted() && BlBehaviorServiceHelper.clearFavorite() == 0) {
            resetHomeCompanyConflictStatus();
            if (z) {
                startFavoriteSyncUploadService();
            }
        }
    }

    public void clearNormalFavorite() {
        ArrayList arrayList;
        if (!isThreadInterrupted() && FavoriteUtil.needBlAccountSync()) {
            ArrayList<SimpleFavoriteItem> simpleHomeList = AccountBehaviorServiceWrapper.getInstance().getSimpleHomeList();
            ArrayList arrayList2 = null;
            if (simpleHomeList == null || simpleHomeList.size() <= 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (int i = 0; i < simpleHomeList.size(); i++) {
                    if (isThreadInterrupted()) {
                        return;
                    }
                    arrayList.add(FavoriteUtil.getFavoriteItem(simpleHomeList.get(i)));
                }
            }
            ArrayList<SimpleFavoriteItem> simpleCompanyList = AccountBehaviorServiceWrapper.getInstance().getSimpleCompanyList();
            if (simpleCompanyList != null && simpleCompanyList.size() > 0) {
                arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < simpleCompanyList.size(); i2++) {
                    if (isThreadInterrupted()) {
                        return;
                    }
                    arrayList2.add(FavoriteUtil.getFavoriteItem(simpleCompanyList.get(i2)));
                }
            }
            if (!isThreadInterrupted() && BlBehaviorServiceHelper.clearFavorite() == 0) {
                if (arrayList != null && arrayList.size() > 0) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (isThreadInterrupted()) {
                            return;
                        }
                        BlBehaviorServiceHelper.addFavorite((FavoriteItem) arrayList.get(i3));
                    }
                }
                if (arrayList2 != null && arrayList2.size() > 0) {
                    for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                        if (isThreadInterrupted()) {
                            return;
                        }
                        BlBehaviorServiceHelper.addFavorite((FavoriteItem) arrayList2.get(i4));
                    }
                }
                startFavoriteSyncUploadService();
            }
        }
    }

    public void addFavList(List<FavoriteAddress> list) {
        if (!isThreadInterrupted() && CollectionUtils.isNotEmpty(list)) {
            for (FavoriteAddress favoriteAddress : list) {
                if (isThreadInterrupted()) {
                    return;
                }
                insertOrReplaceFavoriteForSync(favoriteAddress, false);
            }
            startFavoriteSyncPullService();
        }
    }

    public void addFavListNoSync(List<FavoriteAddress> list) {
        if (!isThreadInterrupted() && CollectionUtils.isNotEmpty(list)) {
            for (FavoriteAddress favoriteAddress : list) {
                if (isThreadInterrupted()) {
                    return;
                }
                insertOrReplaceFavoriteForSync(favoriteAddress, false);
            }
        }
    }

    public void updateFavList(List<FavoriteAddress> list) {
        if (!isThreadInterrupted() && CollectionUtils.isNotEmpty(list)) {
            for (FavoriteAddress favoriteAddress : list) {
                if (isThreadInterrupted()) {
                    return;
                }
                insertOrReplaceFavoriteForSync(favoriteAddress, false);
            }
            startFavoriteSyncPullService();
        }
    }

    public void removeFavList(List<FavoriteAddress> list) {
        if (!isThreadInterrupted() && CollectionUtils.isNotEmpty(list)) {
            for (FavoriteAddress favoriteAddress : list) {
                if (isThreadInterrupted()) {
                    return;
                }
                deleteFavoriteForSync(favoriteAddress, false);
            }
            startFavoriteSyncPullService();
        }
    }

    public void addOrUpdateFavList(List<FavoriteAddress> list, List<FavoriteAddress> list2) {
        if (isThreadInterrupted()) {
            return;
        }
        boolean isEmpty = CollectionUtils.isEmpty(list);
        boolean isEmpty2 = CollectionUtils.isEmpty(list2);
        if (isEmpty && isEmpty2) {
            return;
        }
        if (!isEmpty) {
            for (FavoriteAddress favoriteAddress : list) {
                if (isThreadInterrupted()) {
                    return;
                }
                insertOrReplaceFavoriteForSync(favoriteAddress, false);
            }
        }
        if (!isEmpty2) {
            for (FavoriteAddress favoriteAddress2 : list2) {
                if (isThreadInterrupted()) {
                    return;
                }
                insertOrReplaceFavoriteForSync(favoriteAddress2, false);
            }
        }
        startFavoriteSyncPullService();
    }

    public void replaceFavItem(List<FavoriteAddress> list, List<FavoriteAddress> list2) {
        boolean z;
        if (isThreadInterrupted()) {
            return;
        }
        boolean isEmpty = CollectionUtils.isEmpty(list);
        boolean isEmpty2 = CollectionUtils.isEmpty(list2);
        if (isEmpty && isEmpty2) {
            return;
        }
        if (!isEmpty2) {
            for (FavoriteAddress favoriteAddress : list2) {
                if (isThreadInterrupted()) {
                    return;
                }
                int favoriteType = favoriteAddress.getFavoriteType();
                if (favoriteType == 2 || favoriteType == 3) {
                    break;
                }
                deleteFavoriteForSync(favoriteAddress, false);
            }
        }
        if (isEmpty) {
            z = false;
        } else {
            z = false;
            for (FavoriteAddress favoriteAddress2 : list) {
                if (isThreadInterrupted()) {
                    return;
                }
                int favoriteType2 = favoriteAddress2.getFavoriteType();
                if (favoriteType2 == 2 || favoriteType2 == 3) {
                    z = true;
                }
                insertOrReplaceFavoriteForSync(favoriteAddress2, false);
            }
        }
        if (z) {
            startFavoriteSyncUploadService();
        } else {
            startFavoriteSyncPullService();
        }
    }

    private void resetHomeCompanyConflictStatus() {
        if (isThreadInterrupted()) {
            return;
        }
        FavoriteSyncUtil.resetHomeCompanyConflictStatus();
    }

    private boolean isThreadInterrupted() {
        IThreadOperation iThreadOperation = this.mIThreadOperation;
        return iThreadOperation != null && iThreadOperation.isThreadInterrupted();
    }

    private void startFavoriteSyncPullService() {
        if (isThreadInterrupted()) {
            return;
        }
        AccountManager.getInstance().getAccountSyncSession().startSync(55);
    }

    private void startFavoriteSyncUploadService() {
        if (isThreadInterrupted()) {
            return;
        }
        AccountManager.getInstance().getAccountSyncSession().startSync(56);
    }
}
