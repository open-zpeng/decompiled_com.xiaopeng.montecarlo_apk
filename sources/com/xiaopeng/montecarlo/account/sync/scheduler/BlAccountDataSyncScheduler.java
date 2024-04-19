package com.xiaopeng.montecarlo.account.sync.scheduler;

import android.os.Message;
import androidx.annotation.NonNull;
import com.autonavi.gbl.user.syncsdk.model.SyncEventType;
import com.autonavi.gbl.user.syncsdk.model.SyncRet;
import com.autonavi.gbl.user.syncsdk.observer.ISyncSDKServiceObserver;
import com.xiaopeng.montecarlo.account.IThreadOperation;
import com.xiaopeng.montecarlo.account.sync.datahelper.AccountMessage;
import com.xiaopeng.montecarlo.account.sync.datahelper.BlAccountDataSyncHelper;
import com.xiaopeng.montecarlo.navcore.account.AccountBehaviorServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteUtil;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.util.L;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public class BlAccountDataSyncScheduler extends AbstractAccountDataScheduler {
    private static final int MSG_BL_MERGE_DELAY_TIME = 1000;
    private static final int MSG_INIT_BL_USER_INFO = 12288;
    private static final L.Tag TAG = new L.Tag("Bl_Sync_Scheduler");
    private BlAccountDataSyncHelper mBlAccountDataSyncHelper;
    private int mCurSyncMessageType;
    private ISyncSDKServiceObserver mSyncSDKServiceObserver;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FavoriteSyncMessageType {
    }

    public BlAccountDataSyncScheduler(IThreadOperation iThreadOperation) {
        super(iThreadOperation);
        this.mSyncSDKServiceObserver = new ISyncSDKServiceObserver() { // from class: com.xiaopeng.montecarlo.account.sync.scheduler.BlAccountDataSyncScheduler.1
            @Override // com.autonavi.gbl.user.syncsdk.observer.ISyncSDKServiceObserver
            public void notify(@SyncEventType.SyncEventType1 int i, @SyncRet.SyncRet1 int i2) {
                if (L.ENABLE) {
                    L.Tag tag = BlAccountDataSyncScheduler.TAG;
                    L.d(tag, "IBehaviorServiceObserver notify syncEventType = [" + i + "], syncRet = [" + i2 + "]");
                }
                if (4 != i || BlAccountDataSyncScheduler.this.mHandler == null) {
                    return;
                }
                BlAccountDataSyncScheduler.this.mHandler.removeMessages(1003);
                BlAccountDataSyncScheduler.this.mHandler.sendEmptyMessage(1003);
            }
        };
    }

    public void setBlAccountDataSyncHelper(@NonNull BlAccountDataSyncHelper blAccountDataSyncHelper) {
        this.mBlAccountDataSyncHelper = blAccountDataSyncHelper;
        this.mBlAccountDataSyncHelper.setSyncScheduler(this);
        this.mBlAccountDataSyncHelper.setIThreadOperation(getThreadOperation());
    }

    public void initBlLoginInfo() {
        this.mHandler.sendEmptyMessage(MSG_INIT_BL_USER_INFO);
    }

    public void startBlSyncAccountData(int i) {
        startBlSyncAccountData(i, null, true);
    }

    public void startBlSyncAccountData(int i, FavoriteAddress favoriteAddress, boolean z) {
        AccountMessage accountMessage = new AccountMessage();
        accountMessage.setFavoriteSyncMsgType(i);
        accountMessage.setFavoriteAddress(favoriteAddress);
        accountMessage.setNeedSync(z);
        start(accountMessage);
    }

    @Override // com.xiaopeng.montecarlo.account.sync.scheduler.AbstractAccountDataScheduler
    public void start(AccountMessage accountMessage) {
        if (hasMessages(accountMessage)) {
            L.i(TAG, "BlAccountDataSyncScheduler already has sync message");
        } else {
            this.mHandler.obtainMessage(1000, accountMessage).sendToTarget();
        }
    }

    @Override // com.xiaopeng.montecarlo.account.sync.scheduler.AbstractAccountDataScheduler
    public void run(AccountMessage accountMessage) {
        if (accountMessage == null) {
            L.i(TAG, "sync start message null ");
        } else if (this.mBlAccountDataSyncHelper == null) {
            L.i(TAG, "sync start mBlAccountDataSyncHelper null ");
        } else {
            int favoriteSyncMsgType = accountMessage.getFavoriteSyncMsgType();
            if (!FavoriteUtil.isLoginXp()) {
                L.i(TAG, "sync start isLoginXp false");
            } else if (favoriteSyncMsgType != 103 && !this.mBlAccountDataSyncHelper.isLoginInfoReady()) {
                L.Tag tag = TAG;
                L.i(tag, "sync start bl userinfo not ready syncMsgType: " + favoriteSyncMsgType);
            } else {
                boolean amapLoginStatus = SettingWrapper.getAmapLoginStatus();
                if (!amapLoginStatus || !SettingWrapper.getBindAMapStatus()) {
                    L.Tag tag2 = TAG;
                    L.i(tag2, "sync start hasBinded false ---syncMsgType: " + favoriteSyncMsgType + "  amapLoginStatus:" + amapLoginStatus + "  bindAMapStatus:" + SettingWrapper.getBindAMapStatus());
                } else if (favoriteSyncMsgType != 103 && this.mBlAccountDataSyncHelper.isSyncing()) {
                    L.Tag tag3 = TAG;
                    L.i(tag3, "sync start isSyncing, not need sync again syncMsgType: " + favoriteSyncMsgType);
                } else {
                    resumeThread();
                    if (L.ENABLE) {
                        L.Tag tag4 = TAG;
                        L.d(tag4, "sync start  begin to run mode:  " + favoriteSyncMsgType);
                    }
                    this.mCurSyncMessageType = favoriteSyncMsgType;
                    Message obtainMessage = this.mHandler.obtainMessage();
                    obtainMessage.what = favoriteSyncMsgType;
                    obtainMessage.obj = accountMessage;
                    this.mHandler.sendMessage(obtainMessage);
                }
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.account.sync.scheduler.AbstractAccountDataScheduler
    protected boolean hasMessages(AccountMessage accountMessage) {
        if (accountMessage != null) {
            int favoriteSyncMsgType = accountMessage.getFavoriteSyncMsgType();
            if (100 == favoriteSyncMsgType && this.mHandler.hasMessages(100)) {
                return true;
            }
            return 101 == favoriteSyncMsgType && this.mHandler.hasMessages(101);
        }
        return false;
    }

    private void registerBehaviorObserver() {
        unRegisterBehaviorObserver();
        AccountBehaviorServiceWrapper.getInstance().addSyncSdkServiceObserver(this.mSyncSDKServiceObserver);
        if (L.ENABLE) {
            L.d(TAG, "BlAccountDataSyncScheduler registerBehaviorObserver()");
        }
    }

    private void unRegisterBehaviorObserver() {
        AccountBehaviorServiceWrapper.getInstance().removeSyncSdkServiceObserver(this.mSyncSDKServiceObserver);
        if (L.ENABLE) {
            L.d(TAG, "BlAccountDataSyncScheduler unRegisterBehaviorObserver()");
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 100) {
            registerBehaviorObserver();
            boolean startSync = this.mBlAccountDataSyncHelper.startSync();
            L.Tag tag = TAG;
            L.i(tag, "FAVORITE_SYNC_PULL syncResult = " + startSync);
        } else if (i == 101) {
            registerBehaviorObserver();
            boolean startSync2 = this.mBlAccountDataSyncHelper.startSync();
            L.Tag tag2 = TAG;
            L.i(tag2, "FAVORITE_SYNC_UPLOAD syncResult = " + startSync2);
        } else if (i == 103) {
            if (L.ENABLE) {
                L.d(TAG, "FAVORITE_SYNC_ADDFAVORITEFORAMAP ");
            }
            if (this.mBlAccountDataSyncHelper.addFavoriteForAmapSync()) {
                this.mCurSyncMessageType = 100;
                this.mBlAccountDataSyncHelper.initBlLoginInfo();
                if (this.mHandler != null) {
                    this.mHandler.sendEmptyMessageDelayed(1003, 1000L);
                }
            } else {
                L.w(TAG, "addFavoriteForAmapSync fail");
            }
        } else if (i == 1003) {
            int i2 = this.mCurSyncMessageType;
            if (100 == i2 || 101 == i2) {
                if (this.mBlAccountDataSyncHelper.isSyncing()) {
                    L.i(TAG, " MSG_MERGE isSyncing");
                    this.mHandler.removeMessages(1003);
                    this.mHandler.sendEmptyMessageDelayed(1003, 1000L);
                } else {
                    boolean z = this.mCurSyncMessageType == 100;
                    L.Tag tag3 = TAG;
                    L.i(tag3, " MSG_MERGE isNeedMerge = " + z);
                    this.mBlAccountDataSyncHelper.startMerge(z);
                    unRegisterBehaviorObserver();
                }
            }
        } else if (i == MSG_INIT_BL_USER_INFO) {
            if (L.ENABLE) {
                L.Tag tag4 = TAG;
                L.d(tag4, "MSG_INIT_BL_USER_INFO initBlLoginInfo  thread:" + Thread.currentThread().getName());
            }
            this.mBlAccountDataSyncHelper.initBlLoginInfo();
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.account.sync.scheduler.AbstractAccountDataScheduler
    public void close() {
        super.close();
        unRegisterBehaviorObserver();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    private void dumpFavInfo(AccountMessage accountMessage) {
        FavoriteAddress favoriteAddress;
        if (accountMessage == null || accountMessage.getFavoriteAddress() == null || (favoriteAddress = accountMessage.getFavoriteAddress()) == null || favoriteAddress.getXPPoiInfo() == null) {
            return;
        }
        L.Tag tag = TAG;
        L.d(tag, "dumpFavInfo fav--poiId- " + favoriteAddress.getXPPoiInfo().getPoiId() + "  blItemId:" + favoriteAddress.getBLItemId());
    }
}
