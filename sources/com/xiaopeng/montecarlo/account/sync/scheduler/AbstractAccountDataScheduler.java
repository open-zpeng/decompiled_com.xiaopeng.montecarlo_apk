package com.xiaopeng.montecarlo.account.sync.scheduler;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.xiaopeng.montecarlo.account.IThreadOperation;
import com.xiaopeng.montecarlo.account.sync.datahelper.AccountMessage;
import com.xiaopeng.montecarlo.navcore.account.XpUserData;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes.dex */
public abstract class AbstractAccountDataScheduler implements Handler.Callback {
    public static final int FAVORITE_SYNC_ADDFAVORITEFORAMAP = 103;
    public static final int FAVORITE_SYNC_PULL = 100;
    public static final int FAVORITE_SYNC_UPLOAD = 101;
    protected static final int MSG_BL_INIT = 1000;
    protected static final int MSG_BL_MERGE = 1003;
    protected static final int MSG_UPLOAD_RETRY = 1005;
    protected static final int MSG_XP_PULL_INIT = 1001;
    protected static final int MSG_XP_UPLOAD_INIT = 1002;
    private static final L.Tag TAG = new L.Tag("Sync_Base_Scheduler");
    protected Handler mHandler;
    protected boolean mIsLogout = false;
    private IThreadOperation mThreadOperation;
    protected XpUserData mUserData;

    protected abstract boolean hasMessages(AccountMessage accountMessage);

    protected abstract void run(AccountMessage accountMessage);

    public abstract void start(AccountMessage accountMessage);

    public boolean isLogout() {
        return this.mIsLogout;
    }

    public void setUserData(XpUserData xpUserData) {
        this.mUserData = xpUserData;
    }

    public XpUserData getUserData() {
        return this.mUserData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractAccountDataScheduler(IThreadOperation iThreadOperation) {
        this.mThreadOperation = iThreadOperation;
        this.mHandler = new Handler(iThreadOperation.getLooper(), this) { // from class: com.xiaopeng.montecarlo.account.sync.scheduler.AbstractAccountDataScheduler.1
            @Override // android.os.Handler
            public void dispatchMessage(Message message) {
                switch (message.what) {
                    case 1000:
                    case 1001:
                    case 1002:
                        AbstractAccountDataScheduler.this.run((AccountMessage) message.obj);
                        return;
                    default:
                        super.dispatchMessage(message);
                        return;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isThreadInterrupted() {
        return this.mThreadOperation.isThreadInterrupted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resumeThread() {
        this.mThreadOperation.resumeThread();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IThreadOperation getThreadOperation() {
        return this.mThreadOperation;
    }

    public void close() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getXpSyncLoginStatus() {
        XpUserData xpUserData = this.mUserData;
        if (xpUserData == null) {
            return false;
        }
        String sid = xpUserData.getSid();
        String openId = this.mUserData.getOpenId();
        if (TextUtils.isEmpty(sid) || TextUtils.isEmpty(openId)) {
            return false;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "AccountSyncSession getXpSyncLoginStatus sid = " + sid + ", openId = " + openId);
            return true;
        }
        return true;
    }

    protected String getSid() {
        XpUserData xpUserData = this.mUserData;
        if (xpUserData != null) {
            return xpUserData.getSid();
        }
        return null;
    }

    protected String getOpenId() {
        XpUserData xpUserData = this.mUserData;
        if (xpUserData != null) {
            return xpUserData.getOpenId();
        }
        return null;
    }
}
