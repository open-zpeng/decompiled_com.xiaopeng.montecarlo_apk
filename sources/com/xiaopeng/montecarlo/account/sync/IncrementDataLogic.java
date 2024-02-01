package com.xiaopeng.montecarlo.account.sync;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.account.AccountManager;
import com.xiaopeng.montecarlo.account.IThreadOperation;
import com.xiaopeng.montecarlo.account.sync.datahelper.XpFavDataManager;
import com.xiaopeng.montecarlo.navcore.account.ObjectConvertor;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDataPullResponse;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountSettingInfo;
import com.xiaopeng.montecarlo.navcore.bean.sync.IncrementDataRecord;
import com.xiaopeng.montecarlo.navcore.bean.sync.XPFavoriteItem;
import com.xiaopeng.montecarlo.navcore.bean.sync.XPHistoryRecordItem;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.DataOperation;
import com.xiaopeng.montecarlo.navcore.setting.SettingVersionHelper;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.util.MapModeUtil;
import com.xiaopeng.montecarlo.navcore.util.NaviLogUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.SettingSyncUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class IncrementDataLogic {
    private static final L.Tag TAG = new L.Tag("Xp_Sync_IncreLogic");
    private IThreadOperation mIThreadOperation = null;

    public void setIThreadOperation(IThreadOperation iThreadOperation) {
        this.mIThreadOperation = iThreadOperation;
    }

    public void handlePullResponse(@NonNull AccountDataPullResponse accountDataPullResponse) {
        int serverVersion = accountDataPullResponse.getData() != null ? accountDataPullResponse.getData().getServerVersion() : 0;
        List<DataOperation> parsePullResponse = parsePullResponse(accountDataPullResponse);
        if (parsePullResponse != null && parsePullResponse.size() > 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<DataOperation> incrementDataOp = IncrementDataManager.getInstance().getIncrementDataOp();
            if (incrementDataOp == null) {
                incrementDataOp = new ArrayList<>();
            }
            IncrementDataManager.getInstance().compareServerDataOperation(incrementDataOp, parsePullResponse, arrayList, arrayList2);
            L.Tag tag = TAG;
            L.i(tag, "handlePullResponse serverOpsList.size = " + parsePullResponse.size() + ", serverModifyList.size = " + arrayList.size() + ", intersectionList.size = " + arrayList2.size());
            applyDataOperation(serverVersion, arrayList, arrayList2, incrementDataOp.size() > arrayList2.size());
            return;
        }
        L.Tag tag2 = TAG;
        L.i(tag2, "handlePullResponse server list is empty set serVersion:" + serverVersion);
        updateLocalVersion(serverVersion);
    }

    private List<DataOperation> parsePullResponse(@NonNull AccountDataPullResponse accountDataPullResponse) {
        if (200 == accountDataPullResponse.getCode() && accountDataPullResponse.getData() != null && CollectionUtils.isNotEmpty(accountDataPullResponse.getData().getItemList())) {
            List<AccountDataPullResponse.DataBean.ItemListBean> itemList = accountDataPullResponse.getData().getItemList();
            if (itemList.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < itemList.size(); i++) {
                    arrayList.add(new DataOperation(itemList.get(i)));
                }
                return arrayList;
            }
            return null;
        }
        return null;
    }

    private void applyDataOperation(int i, List<DataOperation> list, List<DataOperation> list2, boolean z) {
        if (CollectionUtils.isNotEmpty(list)) {
            if (applyDataOperation(list)) {
                if (deleteDataOperation(list2)) {
                    updateLocalVersion(i);
                    return;
                }
                return;
            }
            L.w(TAG, "applyDataOperation success fail");
            return;
        }
        L.w(TAG, "applyDataOperation version not uniform, but serverModifyList is empty");
        if (deleteDataOperation(list2)) {
            updateLocalVersion(i);
        }
        if (z) {
            startXpUploadSync();
        }
    }

    private void startXpUploadSync() {
        AccountManager.getInstance().getAccountSyncSession().startSync(2);
    }

    public boolean applyDataOperation(List<DataOperation> list) {
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        ArrayList arrayList4 = null;
        DataOperation dataOperation = null;
        for (DataOperation dataOperation2 : list) {
            int dataType = dataOperation2.getDataType();
            if (dataType == 1) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(dataOperation2);
            } else if (dataType == 2) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(dataOperation2);
            } else if (dataType == 3) {
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                }
                arrayList3.add(dataOperation2);
            } else if (dataType == 4) {
                dataOperation = dataOperation2;
            } else if (dataType == 5) {
                if (arrayList4 == null) {
                    arrayList4 = new ArrayList();
                }
                arrayList4.add(dataOperation2);
            }
        }
        if (CollectionUtils.isNotEmpty(arrayList)) {
            handleFavDataOperation(arrayList);
        }
        if (CollectionUtils.isNotEmpty(arrayList2)) {
            handleHistoryDataOperation(arrayList2);
        }
        if (CollectionUtils.isNotEmpty(arrayList3)) {
            handleSettingsDataOperation(arrayList3);
        }
        if (dataOperation != null) {
            handleVolumeDataOperation(dataOperation);
        }
        if (CollectionUtils.isNotEmpty(arrayList4)) {
            handleAngleDataOperation(arrayList4);
        }
        return true;
    }

    private void handleFavDataOperation(@NonNull List<DataOperation> list) {
        DataOperation dataOperation;
        if (L.ENABLE) {
            L.d(TAG, "handleFavDataOperation list.size = " + list.size());
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            DataOperation dataOperation2 = list.get(i);
            if (dataOperation2 != null && ((dataOperation = (DataOperation) hashMap.get(dataOperation2.getDataId())) == null || dataOperation2.getVersion() > dataOperation.getVersion())) {
                hashMap.put(dataOperation2.getDataId(), dataOperation2);
            }
        }
        ArrayList arrayList = new ArrayList(hashMap.values());
        if (CollectionUtils.isEmpty(arrayList)) {
            L.i(TAG, "handleFavDataOperation list empty ");
            return;
        }
        FavoriteAddress favoriteAddress = null;
        FavoriteAddress favoriteAddress2 = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            DataOperation dataOperation3 = (DataOperation) arrayList.get(i2);
            int operationType = dataOperation3.getOperationType();
            String dataContent = dataOperation3.getDataContent();
            if (!TextUtils.isEmpty(dataContent)) {
                try {
                    XPFavoriteItem jsonToXPFavoriteItem = ObjectConvertor.jsonToXPFavoriteItem(dataContent);
                    if (jsonToXPFavoriteItem != null && !isNameAddressEmpty(jsonToXPFavoriteItem)) {
                        FavoriteAddress favoriteAddress3 = new FavoriteAddress(dataOperation3.getDataId(), jsonToXPFavoriteItem);
                        if (1 != operationType && 2 != operationType) {
                            if (3 == operationType) {
                                if (arrayList3 == null) {
                                    arrayList3 = new ArrayList();
                                }
                                arrayList3.add(favoriteAddress3);
                            }
                        }
                        if (2 == favoriteAddress3.getFavoriteType()) {
                            favoriteAddress = favoriteAddress3;
                        } else if (3 == favoriteAddress3.getFavoriteType()) {
                            favoriteAddress2 = favoriteAddress3;
                        } else {
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList2.add(favoriteAddress3);
                        }
                    }
                } catch (Exception e) {
                    DatabaseExceptionUtil.handleException(e);
                }
            }
        }
        setHome(favoriteAddress);
        setCompany(favoriteAddress2);
        if (isThreadInterrupted()) {
            if (L.ENABLE) {
                L.d(TAG, "handleFavDataOperation isThreadInterrupted()");
                return;
            }
            return;
        }
        if (CollectionUtils.isNotEmpty(arrayList2)) {
            if (L.ENABLE) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    L.d(TAG, "insertOrReplace favoriteAddress = " + NaviLogUtil.dumpXPPOIInfo(((FavoriteAddress) it.next()).getXPPoiInfo()));
                }
            }
            List<FavoriteAddress> arrayList4 = new ArrayList<>();
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                FavoriteAddress favoriteAddress4 = (FavoriteAddress) arrayList2.get(i3);
                if (!arrayList4.contains(favoriteAddress4)) {
                    arrayList4.add(favoriteAddress4);
                } else if (L.ENABLE) {
                    L.d(TAG, "handleFavDataOperation insertOrReplaceFavoriteList duplicate i :" + i3 + " data:" + NaviLogUtil.dumpXPPOIInfo(favoriteAddress4.getXPPoiInfo()));
                }
            }
            int insertOrReplaceFavoriteList = XpFavDataManager.getInstance().insertOrReplaceFavoriteList(arrayList4);
            if (L.ENABLE) {
                L.d(TAG, "handleFavDataOperation insertOrReplaceFavoriteList count:" + insertOrReplaceFavoriteList);
            }
        }
        if (!isThreadInterrupted() && CollectionUtils.isNotEmpty(arrayList3)) {
            if (L.ENABLE) {
                Iterator<FavoriteAddress> it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    L.d(TAG, "delete favoriteAddress = " + NaviLogUtil.dumpXPPOIInfo(it2.next().getXPPoiInfo()));
                }
            }
            int deleteFavoriteList = XpFavDataManager.getInstance().deleteFavoriteList(arrayList3);
            if (L.ENABLE) {
                L.d(TAG, "handleFavDataOperation deleteFavoriteList count:" + deleteFavoriteList);
            }
        }
    }

    private void setHome(FavoriteAddress favoriteAddress) {
        if (L.ENABLE && favoriteAddress != null) {
            L.Tag tag = TAG;
            L.d(tag, "setHome homeAddress = " + NaviLogUtil.dumpXPPOIInfo(favoriteAddress.getXPPoiInfo()));
        }
        if (isThreadInterrupted() || favoriteAddress == null) {
            return;
        }
        XpFavDataManager.getInstance().setHome(favoriteAddress);
    }

    private void setCompany(FavoriteAddress favoriteAddress) {
        if (L.ENABLE && favoriteAddress != null) {
            L.Tag tag = TAG;
            L.d(tag, "setCompany companyAddress = " + NaviLogUtil.dumpXPPOIInfo(favoriteAddress.getXPPoiInfo()));
        }
        if (isThreadInterrupted() || favoriteAddress == null) {
            return;
        }
        XpFavDataManager.getInstance().setCompany(favoriteAddress);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:
        r1 = new java.util.ArrayList();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void handleHistoryDataOperation(@androidx.annotation.NonNull java.util.List<com.xiaopeng.montecarlo.navcore.httpclient.dto.DataOperation> r8) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.account.sync.IncrementDataLogic.handleHistoryDataOperation(java.util.List):void");
    }

    private void handleSettingsDataOperation(@NonNull List<DataOperation> list) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "handleSettingsDataOperation list.size = " + list.size());
        }
        ArrayList arrayList = null;
        for (int i = 0; i < list.size(); i++) {
            String dataContent = list.get(i).getDataContent();
            if (!TextUtils.isEmpty(dataContent)) {
                try {
                    AccountSettingInfo jsonToSettingInfo = ObjectConvertor.jsonToSettingInfo(dataContent);
                    if (jsonToSettingInfo != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(jsonToSettingInfo);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (!isThreadInterrupted() && CollectionUtils.isNotEmpty(arrayList)) {
            setAccountSettingInfos(arrayList);
        }
    }

    private void handleVolumeDataOperation(@NonNull DataOperation dataOperation) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "handleVolumeDataOperation " + NaviLogUtil.dumpDataOperation(dataOperation));
        }
        AccountSettingInfo accountSettingInfo = null;
        String dataContent = dataOperation.getDataContent();
        if (!TextUtils.isEmpty(dataContent)) {
            try {
                accountSettingInfo = ObjectConvertor.jsonToSettingInfo(dataContent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (isThreadInterrupted() || accountSettingInfo == null) {
            return;
        }
        setVolumeSettingInfo(accountSettingInfo);
    }

    private void handleAngleDataOperation(@NonNull List<DataOperation> list) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "handleAngleDataOperation list.size = " + list.size());
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String dataContent = list.get(i).getDataContent();
            if (!TextUtils.isEmpty(dataContent)) {
                try {
                    AccountSettingInfo jsonToSettingInfo = ObjectConvertor.jsonToSettingInfo(dataContent);
                    if (jsonToSettingInfo != null) {
                        arrayList.add(jsonToSettingInfo);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (!isThreadInterrupted() && CollectionUtils.isNotEmpty(arrayList)) {
            setNavCruiseAngleInfo(arrayList);
        }
    }

    public boolean updateRecordTime(long j) {
        if (isThreadInterrupted()) {
            return false;
        }
        L.Tag tag = TAG;
        L.i(tag, "updateRecordTime recordTime = " + j);
        if (j > 0) {
            XpAccountUtil.updateRecordTime(j);
            return deleteDataOperation(j);
        }
        return true;
    }

    public void updateLocalVersion(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateLocalVersion serverVersion = " + i);
        }
        if (isThreadInterrupted()) {
            return;
        }
        XpAccountUtil.updateLocalVersion(i);
    }

    public long getLastestRecordTime(List<DataOperation> list) {
        long j = 0;
        if (CollectionUtils.isNotEmpty(list)) {
            for (DataOperation dataOperation : list) {
                if (dataOperation.getUpdateTime() >= j) {
                    j = dataOperation.getUpdateTime();
                }
            }
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getLastestRecordTime lastestTime = " + j);
        }
        return j;
    }

    private boolean deleteDataOperation(long j) {
        return IncrementDataManager.getInstance().deleteIncrementDataOperation(j);
    }

    private boolean deleteDataOperation(List<DataOperation> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            L.Tag tag = TAG;
            L.i(tag, "deleteDataOperation list.size = " + list.size());
            ArrayList arrayList = new ArrayList();
            for (DataOperation dataOperation : list) {
                deleteDataOperation(arrayList, dataOperation);
                if (L.ENABLE) {
                    L.Tag tag2 = TAG;
                    L.d(tag2, "deleteDataOperation : " + NaviLogUtil.dumpDataOperation(dataOperation));
                }
            }
            if (CollectionUtils.isNotEmpty(arrayList)) {
                if (isThreadInterrupted()) {
                    return false;
                }
                IncrementDataManager.getInstance().resumeThread();
                boolean insertIncrementRecords = IncrementDataManager.getInstance().insertIncrementRecords(arrayList);
                L.Tag tag3 = TAG;
                L.i(tag3, "deleteDataOperation insertIncrementRecords result =  " + insertIncrementRecords);
                return insertIncrementRecords;
            }
            return true;
        }
        return true;
    }

    public void deleteDataOperation(List<IncrementDataRecord> list, DataOperation dataOperation) {
        IncrementDataRecord incrementDataRecord = new IncrementDataRecord(dataOperation);
        incrementDataRecord.setOperationType(1);
        long currentTimeMillis = System.currentTimeMillis();
        incrementDataRecord.setCreateTime(currentTimeMillis);
        incrementDataRecord.setUpdateTime(currentTimeMillis);
        list.add(incrementDataRecord);
        IncrementDataRecord incrementDataRecord2 = new IncrementDataRecord(dataOperation);
        incrementDataRecord2.setOperationType(3);
        long j = currentTimeMillis + 10;
        incrementDataRecord2.setCreateTime(j);
        incrementDataRecord2.setUpdateTime(j);
        list.add(incrementDataRecord2);
    }

    public void setAccountSettingInfos(@NonNull List<AccountSettingInfo> list) {
        int allSettingValue = SettingWrapper.getAllSettingValue();
        for (int i = 0; i < list.size(); i++) {
            if (isThreadInterrupted()) {
                return;
            }
            AccountSettingInfo accountSettingInfo = list.get(i);
            if (L.ENABLE) {
                L.d(TAG, "setAccountSettingInfos key = " + accountSettingInfo.getName() + ", value = " + accountSettingInfo.getValue());
            }
            if (!SettingSyncUtil.isExcludeSettingKey(accountSettingInfo.getName())) {
                if (SettingSyncUtil.ACCOUNT_KEY_SETTING_PREFERENCE.equals(accountSettingInfo.getName())) {
                    try {
                        SettingWrapper.saveSettingPreference(0, Integer.parseInt(accountSettingInfo.getValue()));
                        new SettingVersionHelper(1).checkAndUpdateUserSettingVersion();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    String originKey = SettingSyncUtil.getOriginKey(accountSettingInfo.getName(), false);
                    if (originKey != null) {
                        DataSetHelper.AccountSet.setNone(originKey, accountSettingInfo.getValue());
                    }
                }
            }
        }
        XPAccountServiceWrapper.getInstance().invokeRefreshSettingCallback(allSettingValue, SettingWrapper.getAllSettingValue());
    }

    public void setVolumeSettingInfo(@NonNull AccountSettingInfo accountSettingInfo) {
        if (isThreadInterrupted()) {
            return;
        }
        try {
            boolean parseBoolean = Boolean.parseBoolean(accountSettingInfo.getValue());
            L.Tag tag = TAG;
            L.i(tag, "setVolumeSettingInfo volume isMute = " + parseBoolean);
            DataSetHelper.AccountSet.setNone(DataSetHelper.AccountSet.KEY_MAP_VOLUME_MUTE_STATE, parseBoolean);
            SettingOperation.setVolumeMute(parseBoolean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setNavCruiseAngleInfo(@NonNull List<AccountSettingInfo> list) {
        boolean z = TBTManager.getInstance().getCurrentStatus() != 0;
        for (AccountSettingInfo accountSettingInfo : list) {
            if (isThreadInterrupted()) {
                return;
            }
            try {
                int parseInt = Integer.parseInt(accountSettingInfo.getValue());
                if (accountSettingInfo.getName().equals(SettingSyncUtil.SYNC_NAVI_ANGLE_KEY)) {
                    L.Tag tag = TAG;
                    L.i(tag, "setNavCruiseAngleInfo navi mapmode = " + parseInt);
                    MapModeUtil.saveMapMode(0, parseInt, true);
                    if (z) {
                        SettingOperation.setMapMode(parseInt);
                    }
                } else if (accountSettingInfo.getName().equals(SettingSyncUtil.SYNC_CRUISE_ANGLE_KEY)) {
                    L.Tag tag2 = TAG;
                    L.i(tag2, "setNavCruiseAngleInfo cruise mapmode = " + parseInt);
                    MapModeUtil.saveMapMode(0, parseInt, false);
                    if (!z) {
                        SettingOperation.setMapMode(parseInt);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isThreadInterrupted() {
        IThreadOperation iThreadOperation = this.mIThreadOperation;
        return iThreadOperation != null && iThreadOperation.isThreadInterrupted();
    }

    private boolean isNameAddressEmpty(XPFavoriteItem xPFavoriteItem) {
        if (xPFavoriteItem == null) {
            return true;
        }
        return TextUtils.isEmpty(xPFavoriteItem.getName()) && TextUtils.isEmpty(xPFavoriteItem.getAddress());
    }

    private boolean isNameAddressEmpty(XPHistoryRecordItem xPHistoryRecordItem) {
        if (xPHistoryRecordItem == null) {
            return true;
        }
        return TextUtils.isEmpty(xPHistoryRecordItem.getName()) && TextUtils.isEmpty(xPHistoryRecordItem.getAddress());
    }
}
