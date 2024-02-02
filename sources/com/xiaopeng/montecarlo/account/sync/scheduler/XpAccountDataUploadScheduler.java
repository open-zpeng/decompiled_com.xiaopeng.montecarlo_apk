package com.xiaopeng.montecarlo.account.sync.scheduler;

import android.os.Message;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.account.IThreadOperation;
import com.xiaopeng.montecarlo.account.SyncAlarmManager;
import com.xiaopeng.montecarlo.account.sync.XpAccountUtil;
import com.xiaopeng.montecarlo.account.sync.datahelper.AccountMessage;
import com.xiaopeng.montecarlo.account.sync.datahelper.XpAccountDataUploadHelper;
import com.xiaopeng.montecarlo.navcore.account.XpUserData;
import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.DataOperation;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.List;
/* loaded from: classes2.dex */
public class XpAccountDataUploadScheduler extends AbstractAccountDataScheduler {
    private static final L.Tag TAG = new L.Tag("Xp_Sync_UploadScheduler");
    private static final int UPLOAD_FAIL_DELAY = 300000;
    private static final int UPLOAD_FAIL_TRY_TIMES = 3;
    private List<DataOperation> mDataOperationList;
    private int mUploadFailTryTimes;
    private XpAccountDataUploadHelper mXpAccountDataUploadHelper;

    public void setDataOperationList(List<DataOperation> list) {
        this.mDataOperationList = list;
    }

    public List<DataOperation> getDataOperationList() {
        return this.mDataOperationList;
    }

    public XpAccountDataUploadScheduler(IThreadOperation iThreadOperation, @NonNull XpUserData xpUserData) {
        super(iThreadOperation);
        this.mUploadFailTryTimes = 0;
        this.mDataOperationList = null;
        setUserData(xpUserData);
    }

    public void setXpAccountDataUploadHelper(XpAccountDataUploadHelper xpAccountDataUploadHelper) {
        this.mXpAccountDataUploadHelper = xpAccountDataUploadHelper;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "handleMessage msg = " + message);
        }
        if (message.what != 1005) {
            return false;
        }
        uploadAccountData();
        return false;
    }

    public void start() {
        start(null);
    }

    @Override // com.xiaopeng.montecarlo.account.sync.scheduler.AbstractAccountDataScheduler
    public void start(AccountMessage accountMessage) {
        if (hasMessages(accountMessage)) {
            L.i(TAG, "XpAccountDataUploadScheduler already has upload message");
        } else {
            this.mHandler.sendEmptyMessage(1002);
        }
    }

    @Override // com.xiaopeng.montecarlo.account.sync.scheduler.AbstractAccountDataScheduler
    public void run(AccountMessage accountMessage) {
        L.i(TAG, "XpAccountDataUploadScheduler sync start");
        if (!this.mIsLogout) {
            resumeThread();
        }
        if (!getXpSyncLoginStatus()) {
            L.i(TAG, "XpAccountDataUploadScheduler getXpSyncLoginStatus false");
        } else {
            uploadAccountData();
        }
    }

    @Override // com.xiaopeng.montecarlo.account.sync.scheduler.AbstractAccountDataScheduler
    protected boolean hasMessages(AccountMessage accountMessage) {
        return this.mHandler.hasMessages(1002) || this.mHandler.hasMessages(1005);
    }

    private void uploadAccountData() {
        XpAccountUtil.setUploadStatus(false);
        if (this.mUserData == null) {
            L.e(TAG, "uploadAccountData but userData is null!!");
            return;
        }
        boolean uploadAccountDataToCloud = this.mXpAccountDataUploadHelper.uploadAccountDataToCloud(this.mUserData, this.mDataOperationList);
        L.Tag tag = TAG;
        L.i(tag, "XpAccountDataUploadScheduler uploadAccountData uploadSuccess = " + uploadAccountDataToCloud + "  accountInfo: " + this.mUserData);
        if (!uploadAccountDataToCloud) {
            if (this.mIsLogout || isThreadInterrupted()) {
                return;
            }
            if (!sendUploadRetryMessage()) {
                SyncAlarmManager.setAccountSyncAlarm();
            }
        }
        List<DataOperation> list = this.mDataOperationList;
        if (list != null) {
            list.clear();
        }
        updateUploadTime();
        setUploadStatus();
        updateUploadCount();
        cancelAccountSyncAlarm();
        L.i(TAG, "XpAccountDataUploadScheduler sync success");
    }

    private void updateUploadTime() {
        if (isThreadInterrupted() || this.mIsLogout) {
            return;
        }
        XpAccountUtil.updateUploadTime();
    }

    private void setUploadStatus() {
        if (isThreadInterrupted() || this.mIsLogout) {
            return;
        }
        XpAccountUtil.setUploadStatus(true);
    }

    private void updateUploadCount() {
        if (isThreadInterrupted() || this.mIsLogout) {
            return;
        }
        XpAccountUtil.updateUploadCount();
    }

    private void cancelAccountSyncAlarm() {
        if (isThreadInterrupted() || this.mIsLogout) {
            return;
        }
        SyncAlarmManager.cancelAccountSyncAlarm();
    }

    private boolean sendUploadRetryMessage() {
        int i = this.mUploadFailTryTimes;
        if (i < 3) {
            this.mUploadFailTryTimes = i + 1;
            this.mHandler.removeMessages(1005);
            this.mHandler.sendEmptyMessageDelayed(1005, CityDataBean.UNZIPPING_BLOCKING_TIME);
            return true;
        }
        return false;
    }

    public void reset() {
        this.mHandler.removeMessages(1005);
        this.mUploadFailTryTimes = 0;
    }

    public void setLogout(boolean z) {
        this.mIsLogout = z;
        XpAccountDataUploadHelper xpAccountDataUploadHelper = this.mXpAccountDataUploadHelper;
        if (xpAccountDataUploadHelper != null) {
            xpAccountDataUploadHelper.setLogout(z);
        }
    }
}
