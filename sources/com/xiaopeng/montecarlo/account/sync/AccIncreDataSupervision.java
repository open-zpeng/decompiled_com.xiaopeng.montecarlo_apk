package com.xiaopeng.montecarlo.account.sync;

import com.xiaopeng.montecarlo.account.sync.datahelper.BlFavDataManager;
import com.xiaopeng.montecarlo.account.sync.datahelper.XpFavDataManager;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountSettingInfo;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingVersionHelper;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.SettingSyncUtil;
import com.xiaopeng.montecarlo.util.AudioUtil;
import java.util.List;
/* loaded from: classes.dex */
public class AccIncreDataSupervision implements AudioUtil.IAudioChangedListener {
    private static final L.Tag TAG = new L.Tag("Sync_supervision");
    private IncrementDataManager mIncrementDataManager;
    FavoriteDataManager.OnUserDataChangeListener mOnUserDataChangeListener = new FavoriteDataManager.OnUserDataChangeListener() { // from class: com.xiaopeng.montecarlo.account.sync.AccIncreDataSupervision.1
        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnUserDataChangeListener
        public void onDeleteUserData(int i, int i2) {
            AccIncreDataSupervision.this.mIncrementDataManager.deleteUserData(i, i2);
        }
    };
    FavoriteDataManager.OnFavoriteDataChangeListener mFavoriteDataChangeListener = new FavoriteDataManager.OnFavoriteDataChangeListener() { // from class: com.xiaopeng.montecarlo.account.sync.AccIncreDataSupervision.2
        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavItemUpdate(FavoriteAddress favoriteAddress) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "onFavItemUpdate--- ");
                AccIncreDataSupervision.this.dumpFavInfo(favoriteAddress);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.updateFavItem(1, favoriteAddress);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavItemAdded(FavoriteAddress favoriteAddress) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "onFavItemAdded--- ");
                AccIncreDataSupervision.this.dumpFavInfo(favoriteAddress);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.addFavItem(1, favoriteAddress);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavItemRemoved(FavoriteAddress favoriteAddress) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "onFavItemRemoved--- ");
                AccIncreDataSupervision.this.dumpFavInfo(favoriteAddress);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.removeFavItem(1, favoriteAddress);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onNormalFavClear(List<FavoriteAddress> list) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "onNormalFavClear--- ");
            }
            AccIncreDataSupervision.this.mIncrementDataManager.clearNormalFav(list);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavClear(List<FavoriteAddress> list) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "onFavClear--- ");
            }
            AccIncreDataSupervision.this.mIncrementDataManager.clearAllFav(list);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavListAdded(List<FavoriteAddress> list) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "onFavListAdded--- ");
                AccIncreDataSupervision.this.dumpFavInfo(list);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.addFavList(1, list);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavListUpdate(List<FavoriteAddress> list) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "onFavListUpdate--- ");
                AccIncreDataSupervision.this.dumpFavInfo(list);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.updateFavList(1, list);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavListRemoved(List<FavoriteAddress> list) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "onFavListRemoved--- ");
                AccIncreDataSupervision.this.dumpFavInfo(list);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.removeFavList(1, list);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavListAddOrUpdate(List<FavoriteAddress> list, List<FavoriteAddress> list2) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "onFavListAddOrUpdate--addList--> ");
                AccIncreDataSupervision.this.dumpFavInfo(list);
                L.d(AccIncreDataSupervision.TAG, "onFavListAddOrUpdate--updateList--> ");
                AccIncreDataSupervision.this.dumpFavInfo(list2);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.addOrUpdateFavList(1, list, list2);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavItemReplace(List<FavoriteAddress> list, List<FavoriteAddress> list2) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "onFavItemReplace addList: ");
                AccIncreDataSupervision.this.dumpFavInfo(list);
                L.d(AccIncreDataSupervision.TAG, "onFavItemReplace deleteList: ");
                AccIncreDataSupervision.this.dumpFavInfo(list2);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.replaceFavItem(1, list, list2);
        }
    };
    private FavoriteDataManager.OnFavoriteDataChangeListener mXpDataChangeListener = new FavoriteDataManager.OnFavoriteDataChangeListener() { // from class: com.xiaopeng.montecarlo.account.sync.AccIncreDataSupervision.3
        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavItemReplace(List<FavoriteAddress> list, List<FavoriteAddress> list2) {
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavItemUpdate(FavoriteAddress favoriteAddress) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "mXpDataChangeListener onFavItemUpdate--- ");
            }
            AccIncreDataSupervision.this.mIncrementDataManager.updateFavItem(2, favoriteAddress);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavItemAdded(FavoriteAddress favoriteAddress) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "mXpDataChangeListener onFavItemAdded--- ");
                AccIncreDataSupervision.this.dumpFavInfo(favoriteAddress);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.addFavItem(2, favoriteAddress);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavItemRemoved(FavoriteAddress favoriteAddress) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "mXpDataChangeListener onFavItemRemoved--- ");
                AccIncreDataSupervision.this.dumpFavInfo(favoriteAddress);
            }
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onNormalFavClear(List<FavoriteAddress> list) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "mXpDataChangeListener onNormalFavClear--- ");
                AccIncreDataSupervision.this.dumpFavInfo(list);
            }
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavClear(List<FavoriteAddress> list) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "mXpDataChangeListener onFavClear--- ");
                AccIncreDataSupervision.this.dumpFavInfo(list);
            }
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavListAdded(List<FavoriteAddress> list) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "mXpDataChangeListener onFavListAdded--- ");
                AccIncreDataSupervision.this.dumpFavInfo(list);
            }
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavListUpdate(List<FavoriteAddress> list) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "mXpDataChangeListener onFavListUpdate--- ");
                AccIncreDataSupervision.this.dumpFavInfo(list);
            }
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavListRemoved(List<FavoriteAddress> list) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "mXpDataChangeListener onFavListRemoved--- ");
                AccIncreDataSupervision.this.dumpFavInfo(list);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.removeFavList(2, list);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavListAddOrUpdate(List<FavoriteAddress> list, List<FavoriteAddress> list2) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "mXpDataChangeListener onFavListAddOrUpdate-addList-- ");
                AccIncreDataSupervision.this.dumpFavInfo(list);
                L.d(AccIncreDataSupervision.TAG, "mXpDataChangeListener onFavListAddOrUpdate-updateList-- ");
                AccIncreDataSupervision.this.dumpFavInfo(list2);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.addOrUpdateFavList(2, list, list2);
        }
    };
    private FavoriteDataManager.OnFavoriteDataChangeListener mBlDataChangeListener = new FavoriteDataManager.OnFavoriteDataChangeListener() { // from class: com.xiaopeng.montecarlo.account.sync.AccIncreDataSupervision.4
        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavItemUpdate(FavoriteAddress favoriteAddress) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "mBlDataChangeListener onFavItemUpdate--- ");
                AccIncreDataSupervision.this.dumpFavInfo(favoriteAddress);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.updateFavItem(3, favoriteAddress);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavItemAdded(FavoriteAddress favoriteAddress) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "mBlDataChangeListener onFavItemAdded--- ");
                AccIncreDataSupervision.this.dumpFavInfo(favoriteAddress);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.addFavItem(3, favoriteAddress);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavItemRemoved(FavoriteAddress favoriteAddress) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "mBlDataChangeListener onFavItemRemoved--- ");
                AccIncreDataSupervision.this.dumpFavInfo(favoriteAddress);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.removeFavItem(3, favoriteAddress);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onNormalFavClear(List<FavoriteAddress> list) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "mBlDataChangeListener onNormalFavClear--- ");
            }
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavClear(List<FavoriteAddress> list) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "mBlDataChangeListener onFavClear--- ");
            }
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavListAdded(List<FavoriteAddress> list) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "mBlDataChangeListener onFavListAdded--- ");
            }
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavListUpdate(List<FavoriteAddress> list) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "mBlDataChangeListener onFavListUpdate--- ");
            }
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavListRemoved(List<FavoriteAddress> list) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "mBlDataChangeListener onFavListRemoved--- ");
                AccIncreDataSupervision.this.dumpFavInfo(list);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.removeFavList(3, list);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavListAddOrUpdate(List<FavoriteAddress> list, List<FavoriteAddress> list2) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "mBlDataChangeListener onFavListAddOrUpdate-addList-- ");
                AccIncreDataSupervision.this.dumpFavInfo(list);
                L.d(AccIncreDataSupervision.TAG, "mBlDataChangeListener onFavListAddOrUpdate-updateList-- ");
                AccIncreDataSupervision.this.dumpFavInfo(list2);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.addOrUpdateFavList(3, list, list2);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnFavoriteDataChangeListener
        public void onFavItemReplace(List<FavoriteAddress> list, List<FavoriteAddress> list2) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "mBlDataChangeListener onFavItemReplace-addList-- ");
                AccIncreDataSupervision.this.dumpFavInfo(list);
                L.d(AccIncreDataSupervision.TAG, "mBlDataChangeListener onFavItemReplace-deleteList-- ");
                AccIncreDataSupervision.this.dumpFavInfo(list2);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.replaceFavItem(3, list, list2);
        }
    };
    private FavoriteDataManager.OnHistoryDataChangeListener mHistoryDataChangeListener = new FavoriteDataManager.OnHistoryDataChangeListener() { // from class: com.xiaopeng.montecarlo.account.sync.AccIncreDataSupervision.5
        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnHistoryDataChangeListener
        public void onHistoryItemUpdate(HistoryRecordInfo historyRecordInfo) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "onHistoryItemUpdate--- ");
                AccIncreDataSupervision.this.dumpHistroyInfo(historyRecordInfo);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.updateHistoryRecordInfo(historyRecordInfo);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnHistoryDataChangeListener
        public void onHistoryItemAdded(HistoryRecordInfo historyRecordInfo) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "onHistoryItemAdded--- ");
                AccIncreDataSupervision.this.dumpHistroyInfo(historyRecordInfo);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.addHistoryRecordInfo(historyRecordInfo);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnHistoryDataChangeListener
        public void onHistoryItemRemoved(HistoryRecordInfo historyRecordInfo) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "onHistoryItemRemoved--- ");
                AccIncreDataSupervision.this.dumpHistroyInfo(historyRecordInfo);
            }
            AccIncreDataSupervision.this.mIncrementDataManager.removeHistoryRecordInfo(historyRecordInfo);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnHistoryDataChangeListener
        public void onHistoryRecordInfoClear(List<HistoryRecordInfo> list) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "onHistoryRecordInfoClear--- ");
            }
            AccIncreDataSupervision.this.mIncrementDataManager.clearAllHistoryRecordInfo(list);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnHistoryDataChangeListener
        public void onHistoryListAdded(List<HistoryRecordInfo> list) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "onHistoryListAdded--- ");
            }
            AccIncreDataSupervision.this.mIncrementDataManager.addHistoryRecordInfoList(list);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnHistoryDataChangeListener
        public void onHistoryListUpdate(List<HistoryRecordInfo> list) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "onHistoryListUpdate--- ");
            }
            AccIncreDataSupervision.this.mIncrementDataManager.updateHistoryRecordInfoList(list);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnHistoryDataChangeListener
        public void onHistoryListRemoved(List<HistoryRecordInfo> list) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "onHistoryListRemoved--- ");
            }
            AccIncreDataSupervision.this.mIncrementDataManager.removeHistoryRecordInfoList(list);
        }

        @Override // com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager.OnHistoryDataChangeListener
        public void onHistoryListAddOrUpdate(List<HistoryRecordInfo> list, List<HistoryRecordInfo> list2) {
            if (L.ENABLE) {
                L.d(AccIncreDataSupervision.TAG, "onHistoryListAddOrUpdate--- ");
            }
            AccIncreDataSupervision.this.mIncrementDataManager.addOrUpdateHistoryRecordInfoList(list, list2);
        }
    };
    private DataSetHelper.DataSetChangeListener mDataSetListener = new DataSetHelper.DataSetChangeListener() { // from class: com.xiaopeng.montecarlo.account.sync.AccIncreDataSupervision.6
        @Override // com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.DataSetChangeListener
        public void dataChange(int i, boolean z, String str, String str2) {
            L.Tag tag = AccIncreDataSupervision.TAG;
            L.i(tag, "DataSetChangeListener dataChange notifyType = " + i + ", key = " + str + ", value = " + str2);
            if (1 == i || 3 == i) {
                if (!z || SettingSyncUtil.isGlobalSettingKeys(str)) {
                    if (z || SettingSyncUtil.isAccountSettingKeys(str)) {
                        if (L.ENABLE) {
                            L.d(AccIncreDataSupervision.TAG, "DataSetChangeListener dataChange execute");
                        }
                        String customKey = SettingSyncUtil.getCustomKey(str, z);
                        if (customKey != null) {
                            AccountSettingInfo accountSettingInfo = new AccountSettingInfo();
                            accountSettingInfo.setName(customKey);
                            accountSettingInfo.setValue(str2);
                            IncrementDataManager.getInstance().insertSetting(accountSettingInfo);
                        }
                    }
                }
            }
        }

        @Override // com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.DataSetChangeListener
        public void onAccountSetLoadComplete() {
            new SettingVersionHelper(1).checkAndUpdateUserSettingVersion();
        }
    };

    public void init() {
        this.mIncrementDataManager = IncrementDataManager.getInstance();
        AudioUtil.getInstance().addAudioChangedListener(this);
        FavoriteDataManager.getInstance().setOnUserDataChangeListener(this.mOnUserDataChangeListener);
        FavoriteDataManager.getInstance().setIncreSyncFavDataChangeListener(this.mFavoriteDataChangeListener);
        FavoriteDataManager.getInstance().setIncreSyncHistoryDataChangeListener(this.mHistoryDataChangeListener);
        XpFavDataManager.getInstance().setIncreSyncFavDataChangeListener(this.mXpDataChangeListener);
        BlFavDataManager.getInstance().setIncreSyncFavDataChangeListener(this.mBlDataChangeListener);
        DataSetHelper.registerDataSetChangeListener(this.mDataSetListener);
    }

    public void unInit() {
        FavoriteDataManager.getInstance().removeOnFavDataChangeListener(this.mFavoriteDataChangeListener);
        FavoriteDataManager.getInstance().removeOnHistoryDataChangeListener(this.mHistoryDataChangeListener);
        XpFavDataManager.getInstance().removeOnFavDataChangeListener(this.mXpDataChangeListener);
        BlFavDataManager.getInstance().removeOnFavDataChangeListener(this.mBlDataChangeListener);
        DataSetHelper.unRegisterDataSetChangeListener(this.mDataSetListener);
        AudioUtil.getInstance().removeAudioChangedListener(this);
    }

    @Override // com.xiaopeng.montecarlo.util.AudioUtil.IAudioChangedListener
    public void onAudioChanged(boolean z) {
        boolean isMute = AudioUtil.getInstance().isMute();
        boolean volumeMuteState = SettingWrapper.getVolumeMuteState();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onAudioChanged newMute = " + isMute + ", oldMute = " + volumeMuteState);
        }
        if (isMute != volumeMuteState) {
            SettingWrapper.setVolumeMuteState(isMute);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dumpHistroyInfo(HistoryRecordInfo historyRecordInfo) {
        if (historyRecordInfo == null || historyRecordInfo.getXPPoiInfo() == null) {
            return;
        }
        L.Tag tag = TAG;
        L.d(tag, "dumpHistroyInfo --poiId- " + historyRecordInfo.getXPPoiInfo().getPoiId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dumpFavInfo(FavoriteAddress favoriteAddress) {
        if (favoriteAddress == null || favoriteAddress.getXPPoiInfo() == null) {
            return;
        }
        L.Tag tag = TAG;
        L.d(tag, "dumpFavInfo fav--poiId- " + favoriteAddress.getXPPoiInfo().getPoiId() + "  blItemId:" + favoriteAddress.getBLItemId() + "  favType:" + favoriteAddress.getFavoriteType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dumpFavInfo(List<FavoriteAddress> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            for (FavoriteAddress favoriteAddress : list) {
                if (favoriteAddress != null && favoriteAddress.getXPPoiInfo() != null) {
                    L.Tag tag = TAG;
                    L.d(tag, "dumpFavInfo fav--poiId- " + favoriteAddress.getXPPoiInfo().getPoiId() + "  blItemId:" + favoriteAddress.getBLItemId() + "  favType:" + favoriteAddress.getFavoriteType());
                }
            }
        }
    }
}
