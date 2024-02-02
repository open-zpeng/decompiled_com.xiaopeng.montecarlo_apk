package com.xiaopeng.montecarlo.navcore.xptbt;

import android.app.Application;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.xuimanager.XUIManager;
import com.xiaopeng.xuimanager.XUIServiceNotConnectedException;
import com.xiaopeng.xuimanager.contextinfo.ContextInfoManager;
import com.xiaopeng.xuimanager.xapp.XAppManager;
/* loaded from: classes2.dex */
public class XUIServiceManager {
    private static final int MSG_INIT_XUI_APP_MANAGER = 4001;
    private static final int MSG_INIT_XUI_CONTEXTINFO_MANAGER = 4000;
    public static final int NAV_TTS_TYPE_ACC = 1;
    public static final int NAV_TTS_TYPE_MANUAL = 2;
    public static final int NGP_STRONG_ALERT_TYPE_CLOSE = 0;
    public static final int NGP_STRONG_ALERT_TYPE_FCW = 2;
    public static final int NGP_STRONG_ALERT_TYPE_NONE = -1;
    public static final int NGP_STRONG_ALERT_TYPE_TAKE_OVER = 1;
    private static final int XUI_SERVICE_EVENT_TYPE_NAV_TTS = 3;
    private static final int XUI_SERVICE_EVENT_TYPE_NGP_STRONG_ALERT = 2;
    private static final int XUI_SERVICE_EVENT_TYPE_NGP_TTS = 1;
    private XUIManager mXUIManager;
    private static final L.Tag TAG = new L.Tag("XUIServiceManager");
    private static final XUIServiceManager sInstance = new XUIServiceManager();
    private ContextInfoManager mContextInfoManager = null;
    private XAppManager mXAppManager = null;
    private ContextInfoManager.ContextInfoEventListener mContextInfoEventListener = new ContextInfoManager.ContextInfoEventListener() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.XUIServiceManager.1
        public void onAccelerationEvent(float f) {
        }

        public void onAngularVelocityEvent(float f) {
        }

        public void onErrorEvent(int i, int i2) {
        }

        public void onNavigationEnable(boolean z) {
            L.Tag tag = XUIServiceManager.TAG;
            L.i(tag, "====onNavigationEnable=== enable:" + z);
            if (z) {
                return;
            }
            TBTManager.getInstance().stopNavi(true);
        }
    };
    private final Handler mHandler = new Handler(WorkThreadUtil.getInstance().getNavThreadLooper()) { // from class: com.xiaopeng.montecarlo.navcore.xptbt.XUIServiceManager.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 4000) {
                XUIServiceManager.this.initXUIContextInfoManager();
            } else if (i != 4001) {
            } else {
                XUIServiceManager.this.initXAppManager();
            }
        }
    };

    private XUIServiceManager() {
    }

    @NonNull
    public static XUIServiceManager getInstance() {
        return sInstance;
    }

    public void init(@NonNull Application application) {
        this.mXUIManager = XUIManager.createXUIManager(application, new ServiceConnection() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.XUIServiceManager.3
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                XUIServiceManager.this.mHandler.sendEmptyMessage(4000);
                XUIServiceManager.this.mHandler.sendEmptyMessage(4001);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                XUIServiceManager.this.mContextInfoManager = null;
                XUIServiceManager.this.mXAppManager = null;
            }
        });
        this.mXUIManager.connect();
    }

    public void unInit() {
        XUIManager xUIManager = this.mXUIManager;
        if (xUIManager != null) {
            xUIManager.disconnect();
        }
        ContextInfoManager contextInfoManager = this.mContextInfoManager;
        if (contextInfoManager != null) {
            try {
                contextInfoManager.unregisterListener(this.mContextInfoEventListener);
            } catch (XUIServiceNotConnectedException e) {
                e.printStackTrace();
            }
        }
        this.mContextInfoManager = null;
        this.mXAppManager = null;
    }

    public void updateNavigationInfo(String str) {
        ContextInfoManager contextInfoManager = this.mContextInfoManager;
        if (contextInfoManager != null) {
            try {
                contextInfoManager.setNavigationInfo(str);
                return;
            } catch (XUIServiceNotConnectedException e) {
                L.i(TAG, ">>> updateNavigationInfo fail");
                e.printStackTrace();
                return;
            }
        }
        L.i(TAG, ">>> updateNavigationInfo but service can not connect");
    }

    public void sendXPilotTTS(int i) {
        if (this.mContextInfoManager != null) {
            try {
                L.Tag tag = TAG;
                L.i(tag, "sendContextEvent XUI_SERVICE_EVENT_TYPE_NGP_TTS:" + i);
                this.mContextInfoManager.sendContextEvent(1, i);
                return;
            } catch (XUIServiceNotConnectedException e) {
                L.i(TAG, ">>> sendXPilotTTS fail");
                e.printStackTrace();
                return;
            }
        }
        L.i(TAG, ">>> sendXPilotTTS but service can not connect");
    }

    public void sendXPilotStrongAlert(int i) {
        if (this.mContextInfoManager != null) {
            try {
                L.Tag tag = TAG;
                L.i(tag, "sendContextEvent XUI_SERVICE_EVENT_TYPE_NGP_STRONG_ALERT:" + i);
                this.mContextInfoManager.sendContextEvent(2, i);
                return;
            } catch (XUIServiceNotConnectedException e) {
                L.i(TAG, ">>> sendXPilotStrongAlert fail");
                e.printStackTrace();
                return;
            }
        }
        L.i(TAG, ">>> sendXPilotStrongAlert but service can not connect");
    }

    public void sendNavTTS(int i) {
        if (this.mContextInfoManager != null) {
            try {
                L.Tag tag = TAG;
                L.i(tag, "sendContextEvent XUI_SERVICE_EVENT_TYPE_NAV_TTS:" + i);
                this.mContextInfoManager.sendContextEvent(3, i);
                return;
            } catch (XUIServiceNotConnectedException e) {
                L.i(TAG, ">>> sendNavTTS fail");
                e.printStackTrace();
                return;
            }
        }
        L.i(TAG, ">>> sendNavTTS but service can not connect");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initXUIContextInfoManager() {
        try {
            L.i(TAG, ">>> initXUIContextInfoManager");
            this.mContextInfoManager = (ContextInfoManager) this.mXUIManager.getXUIServiceManager("contextinfo");
            if (this.mContextInfoManager != null) {
                this.mContextInfoManager.registerListener(this.mContextInfoEventListener);
            }
            TBTManager.getInstance().resetNaviInfo();
        } catch (XUIServiceNotConnectedException e) {
            L.e(TAG, ">>> initXUIContextInfoManager get manager fail");
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initXAppManager() {
        try {
            L.i(TAG, ">>> initXAppManager");
            this.mXAppManager = (XAppManager) this.mXUIManager.getXUIServiceManager("xapp");
        } catch (XUIServiceNotConnectedException e) {
            L.e(TAG, ">>> initXAppManager get manager fail");
            e.printStackTrace();
        }
    }

    public void closeCancelableDialog() {
        if (this.mXAppManager != null) {
            try {
                L.i(TAG, "closeCancelableDialog");
                this.mXAppManager.closeCancelableDialog();
            } catch (NoSuchMethodError e) {
                L.w(TAG, "closeCancelableDialog failure:NoSuchMethodError ");
                e.printStackTrace();
            } catch (XUIServiceNotConnectedException e2) {
                L.w(TAG, "closeCancelableDialog failure:XUIServiceNotConnectedException");
                e2.printStackTrace();
            }
        }
    }
}
