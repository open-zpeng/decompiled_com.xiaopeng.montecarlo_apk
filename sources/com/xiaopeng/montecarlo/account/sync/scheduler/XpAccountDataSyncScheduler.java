package com.xiaopeng.montecarlo.account.sync.scheduler;

import android.os.Message;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.account.IThreadOperation;
import com.xiaopeng.montecarlo.account.sync.AccountDeleteUserDataResult;
import com.xiaopeng.montecarlo.account.sync.XpAccountUtil;
import com.xiaopeng.montecarlo.account.sync.datahelper.AccountMessage;
import com.xiaopeng.montecarlo.account.sync.datahelper.XpAccountDataSyncHelper;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.account.XpUserData;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDataPullResponse;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDataResponseCode;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDeleteUserDataResponse;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.List;
/* loaded from: classes2.dex */
public class XpAccountDataSyncScheduler extends AbstractAccountDataScheduler {
    private static final int FAIL_DELAY = 60000;
    private static final int MAX_PULL_FAIL_COUNT = 10;
    protected static final int MSG_XP_DEL_USER_DATA = 8193;
    protected static final int MSG_XP_PULL_CLOUD_DATA = 8194;
    private static final L.Tag TAG = new L.Tag("Xp_Sync_PullScheduler");
    private volatile boolean mIsPulling;
    private int mPullFailCount;
    private XpAccountDataSyncHelper mXpAccountDataSyncHelper;

    @Override // com.xiaopeng.montecarlo.account.sync.scheduler.AbstractAccountDataScheduler
    protected boolean hasMessages(AccountMessage accountMessage) {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.account.sync.scheduler.AbstractAccountDataScheduler
    public void run(AccountMessage accountMessage) {
    }

    @Override // com.xiaopeng.montecarlo.account.sync.scheduler.AbstractAccountDataScheduler
    public void start(AccountMessage accountMessage) {
    }

    public XpAccountDataSyncScheduler(IThreadOperation iThreadOperation, @NonNull XpUserData xpUserData) {
        super(iThreadOperation);
        this.mPullFailCount = 0;
        this.mIsPulling = false;
        setUserData(xpUserData);
    }

    public void setXpAccountDataSyncHelper(XpAccountDataSyncHelper xpAccountDataSyncHelper) {
        this.mXpAccountDataSyncHelper = xpAccountDataSyncHelper;
    }

    public void startPullAccountData() {
        if (this.mHandler.hasMessages(8194)) {
            return;
        }
        this.mHandler.sendEmptyMessage(8194);
    }

    public void startDelUserData() {
        this.mHandler.removeMessages(MSG_XP_DEL_USER_DATA);
        this.mHandler.sendEmptyMessage(MSG_XP_DEL_USER_DATA);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "handleMessage msg = " + message);
        }
        int i = message.what;
        if (i == MSG_XP_DEL_USER_DATA) {
            L.d(TAG, "del_user_data handle del msg--- ");
            if (this.mXpAccountDataSyncHelper.checkDeletedStatus()) {
                delUserData();
            }
        } else if (i == 8194) {
            this.mIsPulling = true;
            resumeThread();
            boolean isPullSuccess = isPullSuccess();
            L.Tag tag2 = TAG;
            L.i(tag2, "XpAccountDataSyncScheduler sync start lastPullSuccess：" + isPullSuccess);
            XpAccountUtil.setPullStatus(false);
            if (!getXpSyncLoginStatus()) {
                L.i(TAG, "XpAccountDataSyncScheduler getXpSyncLoginStatus false");
            } else {
                pullCloudData();
                if (XpAccountUtil.isPullSuccess() && this.mXpAccountDataSyncHelper.checkDeletedStatus()) {
                    L.i(TAG, "del_user_data pull success ready to del userdata");
                    delUserData();
                }
            }
            this.mIsPulling = false;
        }
        return true;
    }

    private void pullCloudData() {
        if (this.mUserData == null) {
            L.e(TAG, "pullCloudData mUserData is null!");
            return;
        }
        AccountDataPullResponse cloudDataResponse = this.mXpAccountDataSyncHelper.getCloudDataResponse(this.mUserData);
        boolean checkPullStatus = this.mXpAccountDataSyncHelper.checkPullStatus(cloudDataResponse);
        L.Tag tag = TAG;
        L.i(tag, "XpAccountDataSyncScheduler pullCloudData() isPullSuccess = " + checkPullStatus);
        if (!checkPullStatus) {
            if (!this.mIsLogout && !isThreadInterrupted()) {
                boolean checkSessionReason = checkSessionReason(cloudDataResponse);
                L.Tag tag2 = TAG;
                L.i(tag2, "pullCloudData isSessionReason:" + checkSessionReason);
                if (!checkSessionReason) {
                    retryPull();
                    return;
                }
            }
            this.mPullFailCount = 0;
            return;
        }
        this.mPullFailCount = 0;
        boolean checkCloudData = this.mXpAccountDataSyncHelper.checkCloudData(cloudDataResponse);
        L.Tag tag3 = TAG;
        L.i(tag3, "XpAccountDataSyncScheduler pullCloudData() hasCloudData = " + checkCloudData);
        if (checkCloudData) {
            this.mXpAccountDataSyncHelper.mergeCloudAccountData(cloudDataResponse);
        } else {
            this.mXpAccountDataSyncHelper.mergeGuestAccountData();
        }
        XpAccountUtil.setPullStatus(true);
        if (!SettingWrapper.getAmapLoginStatus() || !SettingWrapper.getBindAMapStatus()) {
            XPAccountServiceWrapper.getInstance().invokeAccountSyncFinishCallback();
        }
        SettingWrapper.setAccountDataPullTime(System.currentTimeMillis());
        L.i(TAG, "XpAccountDataSyncScheduler sync success");
    }

    private boolean checkSessionReason(AccountDataPullResponse accountDataPullResponse) {
        if (accountDataPullResponse == null) {
            return false;
        }
        return AccountDataResponseCode.isServerSessionError(accountDataPullResponse.getCode());
    }

    private void delUserData() {
        L.i(TAG, "del_user_data   start ");
        if (handleAccountDeleteUserDataResult(this.mXpAccountDataSyncHelper.delUserData()) == 11081122) {
            pullCloudData();
            if (XpAccountUtil.isPullSuccess()) {
                handleAccountDeleteUserDataResult(this.mXpAccountDataSyncHelper.delUserData());
            }
        }
    }

    private int handleAccountDeleteUserDataResult(List<AccountDeleteUserDataResult> list) {
        AccountDeleteUserDataResponse response;
        if (CollectionUtils.isEmpty(list)) {
            return -1;
        }
        for (AccountDeleteUserDataResult accountDeleteUserDataResult : list) {
            if (accountDeleteUserDataResult != null && (response = accountDeleteUserDataResult.getResponse()) != null) {
                int code = response.getCode();
                if (200 == code) {
                    L.i(TAG, "del_user_data  success");
                    int delType = accountDeleteUserDataResult.getDelType();
                    if (delType == 1) {
                        SettingWrapper.setDeletedAllNormalFavVersion(0);
                    } else if (delType == 2) {
                        SettingWrapper.setDeletedAllNormalHistoryVersion(0);
                    } else if (delType == 3) {
                        SettingWrapper.setDeletedAllNormalFavVersion(0);
                        SettingWrapper.setDeletedAllNormalHistoryVersion(0);
                    }
                    if (response.getData() != null) {
                        int serverVersion = response.getData().getServerVersion();
                        L.Tag tag = TAG;
                        L.i(tag, "del_user_data  set delVer 0 ---set localVer:" + serverVersion);
                        if (serverVersion > 0) {
                            SettingWrapper.setLocalVersion(serverVersion);
                        }
                    }
                } else if (11082202 == code) {
                    L.i(TAG, "del_user_data  duplicate clear error");
                    int delType2 = accountDeleteUserDataResult.getDelType();
                    if (delType2 == 1) {
                        SettingWrapper.setDeletedAllNormalFavVersion(0);
                    } else if (delType2 == 2) {
                        SettingWrapper.setDeletedAllNormalHistoryVersion(0);
                    } else if (delType2 == 3) {
                        SettingWrapper.setDeletedAllNormalFavVersion(0);
                        SettingWrapper.setDeletedAllNormalHistoryVersion(0);
                    }
                } else if (11081122 == code) {
                    return AccountDataResponseCode.LOCAL_SERVER_VERSION_INCONFORM;
                }
            }
        }
        return 0;
    }

    private void retryPull() {
        if (this.mHandler.hasMessages(8194)) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "retryPull mPullFailCount:" + this.mPullFailCount);
        }
        int i = this.mPullFailCount;
        if (i < 10) {
            this.mPullFailCount = i + 1;
            this.mHandler.sendEmptyMessageDelayed(8194, 60000L);
            return;
        }
        this.mPullFailCount = 0;
    }

    private void retryDelUserData() {
        if (this.mHandler.hasMessages(MSG_XP_DEL_USER_DATA)) {
            return;
        }
        this.mHandler.sendEmptyMessageDelayed(MSG_XP_DEL_USER_DATA, 60000L);
    }

    public boolean isWaitingToRun() {
        return this.mHandler.hasMessages(8194);
    }

    public void reset() {
        this.mHandler.removeMessages(8194);
    }

    public boolean isPulling() {
        return this.mIsPulling;
    }

    private boolean isPullSuccess() {
        return SettingWrapper.getAccountDataPullStatus();
    }

    public void setLogout(boolean z) {
        this.mIsLogout = z;
        XpAccountDataSyncHelper xpAccountDataSyncHelper = this.mXpAccountDataSyncHelper;
        if (xpAccountDataSyncHelper != null) {
            xpAccountDataSyncHelper.setLogout(z);
        }
    }
}
