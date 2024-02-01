package com.xiaopeng.montecarlo.account.sync.datahelper;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.account.AccountManager;
import com.xiaopeng.montecarlo.account.IThreadOperation;
import com.xiaopeng.montecarlo.account.sync.IncrementDataLogic;
import com.xiaopeng.montecarlo.account.sync.IncrementDataManager;
import com.xiaopeng.montecarlo.account.sync.SyncNetworkWrapper;
import com.xiaopeng.montecarlo.navcore.account.XpUserData;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDataPullResponse;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDataUploadResponse;
import com.xiaopeng.montecarlo.navcore.bean.sync.ErrorItem;
import com.xiaopeng.montecarlo.navcore.bean.sync.IncrementDataRecord;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.DataOperation;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class XpAccountDataUploadHelper {
    private static final L.Tag TAG = new L.Tag("Xp_Sync_UploadHelper");
    private final IThreadOperation mThreadOperation;
    private XpUserData mUserData;
    private boolean mIsLogout = false;
    private IncrementDataLogic mIncrementDataLogic = new IncrementDataLogic();

    public boolean isLogout() {
        return this.mIsLogout;
    }

    public void setLogout(boolean z) {
        this.mIsLogout = z;
    }

    public XpAccountDataUploadHelper(@NonNull IThreadOperation iThreadOperation, @NonNull XpUserData xpUserData) {
        this.mThreadOperation = iThreadOperation;
        this.mUserData = xpUserData;
        this.mIncrementDataLogic.setIThreadOperation(this.mThreadOperation);
    }

    public boolean uploadAccountDataToCloud(@NonNull XpUserData xpUserData, List<DataOperation> list) {
        if (CollectionUtils.isEmpty(list)) {
            if (isThreadInterrupted() || this.mIsLogout) {
                L.Tag tag = TAG;
                L.i(tag, "uploadAccountDataToCloud isThreadInterrupted():" + isThreadInterrupted() + " mIsLogout:" + this.mIsLogout);
                return false;
            }
            list = getIncrementDataOperations();
        }
        if (CollectionUtils.isEmpty(list)) {
            L.i(TAG, "uploadAccountDataToCloud increment data is empty, not need to upload");
            return true;
        }
        AccountDataUploadResponse syncAccountData = SyncNetworkWrapper.syncAccountData(xpUserData, false, list, !this.mIsLogout);
        if (syncAccountData != null) {
            handleUploadResponse(syncAccountData, xpUserData, list);
            return syncAccountData.getCode() == 200;
        }
        return false;
    }

    private void handleUploadResponse(@NonNull AccountDataUploadResponse accountDataUploadResponse, @NonNull XpUserData xpUserData, List<DataOperation> list) {
        if (isThreadInterrupted() || this.mIsLogout) {
            return;
        }
        if (11081122 == accountDataUploadResponse.getCode()) {
            L.i(TAG, "handleUploadResponse version inconform start pull cloud data");
            AccountDataPullResponse accountSyncData = SyncNetworkWrapper.getAccountSyncData(xpUserData, !this.mIsLogout);
            if (accountSyncData != null) {
                this.mIncrementDataLogic.handlePullResponse(accountSyncData);
            } else {
                L.w(TAG, "handleUploadResponse version inconform pull cloud data error");
            }
        } else if (200 == accountDataUploadResponse.getCode()) {
            List<ErrorItem> hasErrorItemList = hasErrorItemList(accountDataUploadResponse);
            if (CollectionUtils.isNotEmpty(hasErrorItemList)) {
                L.i(TAG, "handleUploadResponse has error item list");
                List<IncrementDataRecord> hasErrorRecordList = hasErrorRecordList(hasErrorItemList, list);
                if (CollectionUtils.isNotEmpty(hasErrorRecordList)) {
                    boolean insertIncrementRecords = IncrementDataManager.getInstance().insertIncrementRecords(hasErrorRecordList);
                    if (L.ENABLE) {
                        L.Tag tag = TAG;
                        L.d(tag, "handleUploadResponse insertIncrementRecords result = " + insertIncrementRecords);
                    }
                    if (insertIncrementRecords) {
                        AccountManager.getInstance().getAccountSyncSession().startSync(2);
                        return;
                    }
                    return;
                }
                return;
            }
            long lastestRecordTime = this.mIncrementDataLogic.getLastestRecordTime(list);
            if (accountDataUploadResponse.getData() == null || !this.mIncrementDataLogic.updateRecordTime(lastestRecordTime)) {
                return;
            }
            this.mIncrementDataLogic.updateLocalVersion(accountDataUploadResponse.getData().getServerVersion());
        }
    }

    private List<ErrorItem> hasErrorItemList(@NonNull AccountDataUploadResponse accountDataUploadResponse) {
        if (accountDataUploadResponse.getData() != null) {
            return accountDataUploadResponse.getData().getErrorItemList();
        }
        return null;
    }

    private List<IncrementDataRecord> hasErrorRecordList(@NonNull List<ErrorItem> list, @NonNull List<DataOperation> list2) {
        L.Tag tag = TAG;
        L.i(tag, "hasErrorRecordList errorItemList.size = " + list.size());
        HashMap hashMap = new HashMap();
        for (DataOperation dataOperation : list2) {
            hashMap.put(dataOperation.getDataId(), dataOperation);
        }
        if (CollectionUtils.isNotEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (ErrorItem errorItem : list) {
                String dataId = errorItem.getDataId();
                if (L.ENABLE) {
                    L.d(TAG, errorItem.dumpInfo());
                }
                if (hashMap.containsKey(dataId)) {
                    DataOperation dataOperation2 = (DataOperation) hashMap.get(dataId);
                    int errorType = errorItem.getErrorType();
                    if (errorType != 99) {
                        switch (errorType) {
                            case 1:
                                handleNotExistError(arrayList, dataOperation2);
                                break;
                            case 2:
                                handleIsExistError(arrayList, dataOperation2);
                                break;
                            case 3:
                                handleInvalidDataTypeError(arrayList, dataOperation2);
                                break;
                        }
                    }
                    handleInvalidDataFmtError(arrayList, dataOperation2);
                }
            }
            return arrayList;
        }
        return null;
    }

    private void handleNotExistError(List<IncrementDataRecord> list, DataOperation dataOperation) {
        this.mIncrementDataLogic.deleteDataOperation(list, dataOperation);
    }

    private void handleIsExistError(List<IncrementDataRecord> list, DataOperation dataOperation) {
        if (1 == dataOperation.getOperationType()) {
            IncrementDataRecord incrementDataRecord = new IncrementDataRecord(dataOperation);
            incrementDataRecord.setOperationType(3);
            long currentTimeMillis = System.currentTimeMillis();
            incrementDataRecord.setCreateTime(currentTimeMillis);
            incrementDataRecord.setUpdateTime(currentTimeMillis);
            list.add(incrementDataRecord);
            return;
        }
        this.mIncrementDataLogic.deleteDataOperation(list, dataOperation);
    }

    private void handleInvalidDataTypeError(List<IncrementDataRecord> list, DataOperation dataOperation) {
        IncrementDataRecord incrementDataRecord;
        int operationType = dataOperation.getOperationType();
        if (1 == operationType) {
            incrementDataRecord = new IncrementDataRecord(dataOperation);
            incrementDataRecord.setOperationType(3);
        } else if (3 == operationType) {
            this.mIncrementDataLogic.deleteDataOperation(list, dataOperation);
            incrementDataRecord = null;
        } else if (4 == operationType) {
            incrementDataRecord = new IncrementDataRecord(dataOperation);
            incrementDataRecord.setOperationType(3);
        } else {
            incrementDataRecord = new IncrementDataRecord(dataOperation);
            incrementDataRecord.setOperationType(3);
        }
        if (incrementDataRecord != null) {
            long currentTimeMillis = System.currentTimeMillis();
            incrementDataRecord.setCreateTime(currentTimeMillis);
            incrementDataRecord.setUpdateTime(currentTimeMillis);
            list.add(incrementDataRecord);
        }
    }

    private void handleInvalidDataFmtError(List<IncrementDataRecord> list, DataOperation dataOperation) {
        this.mIncrementDataLogic.deleteDataOperation(list, dataOperation);
    }

    public List<DataOperation> getIncrementDataOperations() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getAllDataOperations starttime = " + System.currentTimeMillis());
        }
        List<DataOperation> incrementDataOp = IncrementDataManager.getInstance().getIncrementDataOp();
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "getAllDataOperations finishtime = " + System.currentTimeMillis());
        }
        return incrementDataOp;
    }

    private boolean isThreadInterrupted() {
        return this.mThreadOperation.isThreadInterrupted();
    }
}
