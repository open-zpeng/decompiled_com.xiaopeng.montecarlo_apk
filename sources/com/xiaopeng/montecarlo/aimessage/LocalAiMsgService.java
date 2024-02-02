package com.xiaopeng.montecarlo.aimessage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.montecarlo.aimessage.AiMsgManager;
import com.xiaopeng.montecarlo.aimessage.type.AiMsgBroadcastEvent;
import com.xiaopeng.montecarlo.datalog.DataLogHelper;
import com.xiaopeng.montecarlo.navcore.apirouter.IpcRouterUtil;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class LocalAiMsgService {
    private static final long MAX_CAR_STATE_MSG_WAIT = 30000;
    private static final long MAX_WAIT = 500;
    private static final L.Tag TAG = new L.Tag("LocalAiMsgService");
    private static final LocalAiMsgService sInstance = new LocalAiMsgService();
    private IIpcService mService;
    private final Object mLock = new Object();
    private List<AiMsgManager.MsgListener> mList = new ArrayList();
    private boolean mIsListenEvent = false;
    private volatile boolean mIsRequestingCarState = false;
    private BlockingQueue<AiMsgManager.MsgListener> mCarStateCallQueue = new LinkedBlockingDeque();
    private AiMsgManager.MsgListener mCurrentCarStateRequester = null;
    private Runnable mCarStateRunnable = new Runnable() { // from class: com.xiaopeng.montecarlo.aimessage.LocalAiMsgService.1
        @Override // java.lang.Runnable
        public void run() {
            while (LocalAiMsgService.this.isRequestingCarState()) {
                try {
                    synchronized (LocalAiMsgService.this.mLock) {
                        LocalAiMsgService.this.mCurrentCarStateRequester = (AiMsgManager.MsgListener) LocalAiMsgService.this.mCarStateCallQueue.poll(LocalAiMsgService.MAX_WAIT, TimeUnit.MILLISECONDS);
                        if (LocalAiMsgService.this.mCurrentCarStateRequester != null) {
                            L.Tag tag = LocalAiMsgService.TAG;
                            L.i(tag, "request car state for: " + LocalAiMsgService.this.mCurrentCarStateRequester);
                            LocalAiMsgService.this.requestCarState();
                            LocalAiMsgService.this.mLock.wait(LocalAiMsgService.MAX_CAR_STATE_MSG_WAIT);
                            if (LocalAiMsgService.this.mCurrentCarStateRequester != null) {
                                String str = IpcConfig.App.MESSAGE_CENTER;
                                if (CarFeatureManager.INSTANCE.isIpcExchange2Apirouter()) {
                                    str = "com.xiaopeng.aiassistant";
                                }
                                LocalAiMsgService.this.mCurrentCarStateRequester.onReceive(new AiMsgManager.IpcMessage(str, 10012, null, 0));
                                L.e(LocalAiMsgService.TAG, "request car state time out!");
                                LocalAiMsgService.this.mCurrentCarStateRequester = null;
                            }
                        } else {
                            L.i(LocalAiMsgService.TAG, "request car state runnable STOP ");
                            LocalAiMsgService.this.setRequestingCarState(false);
                        }
                    }
                } catch (InterruptedException unused) {
                    L.e(LocalAiMsgService.TAG, "car state requesting interrupt");
                }
            }
        }
    };
    private Object mEventListener = new Object() { // from class: com.xiaopeng.montecarlo.aimessage.LocalAiMsgService.2
        @Subscribe(threadMode = ThreadMode.BACKGROUND)
        public void onEvent(IIpcService.IpcMessageEvent ipcMessageEvent) {
            L.Tag tag = LocalAiMsgService.TAG;
            L.i(tag, "receive Event:" + ipcMessageEvent);
            if (ipcMessageEvent == null) {
                LocalAiMsgService.this.releaseLock();
                return;
            }
            LocalAiMsgService.this.handleAiMsgEvent(ipcMessageEvent.getMsgID(), ipcMessageEvent.getSenderPackageName(), ipcMessageEvent.getPayloadData());
        }

        @Subscribe(threadMode = ThreadMode.BACKGROUND)
        public void onEvent(IpcRouterUtil.IpcRouterEvent ipcRouterEvent) {
            if (CarFeatureManager.INSTANCE.isIpcExchange2Apirouter()) {
                if (ipcRouterEvent == null) {
                    LocalAiMsgService.this.releaseLock();
                    return;
                }
                L.Tag tag = LocalAiMsgService.TAG;
                L.i(tag, "receive Event:" + ipcRouterEvent);
                LocalAiMsgService.this.handleAiMsgEvent(ipcRouterEvent.getMsgID(), ipcRouterEvent.getSenderPkgName(), ipcRouterEvent.getPayloadData());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void handleAiMsgEvent(int r7, java.lang.String r8, android.os.Bundle r9) {
        /*
            r6 = this;
            if (r9 == 0) goto Lea
            if (r8 != 0) goto L6
            goto Lea
        L6:
            java.lang.String r0 = "com.xiaopeng.device.communication"
            boolean r0 = r0.equals(r8)
            r1 = 0
            if (r0 != 0) goto L1f
            java.lang.String r0 = "com.xiaopeng.message.center"
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L1f
            java.lang.String r0 = "com.xiaopeng.aiassistant"
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L58
        L1f:
            java.lang.String r0 = "string_msg"
            java.lang.String r0 = r9.getString(r0, r1)
            r2 = -1
            java.lang.String r3 = "int_value"
            int r9 = r9.getInt(r3, r2)
            boolean r3 = com.xiaopeng.montecarlo.root.util.L.ENABLE
            if (r3 == 0) goto L4f
            com.xiaopeng.montecarlo.root.util.L$Tag r3 = com.xiaopeng.montecarlo.aimessage.LocalAiMsgService.TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "receive messageContent:"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r5 = "  intv:"
            r4.append(r5)
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            com.xiaopeng.montecarlo.root.util.L.d(r3, r4)
        L4f:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L5a
            if (r9 == r2) goto L58
            goto L5a
        L58:
            r2 = r1
            goto L5f
        L5a:
            com.xiaopeng.montecarlo.aimessage.AiMsgManager$IpcMessage r2 = new com.xiaopeng.montecarlo.aimessage.AiMsgManager$IpcMessage
            r2.<init>(r8, r7, r0, r9)
        L5f:
            if (r2 != 0) goto L65
            r6.releaseLock()
            return
        L65:
            boolean r7 = com.xiaopeng.montecarlo.aimessage.AiMsgUtils.isCarStateMsg(r2)
            if (r7 == 0) goto Lb5
            java.lang.Object r7 = r6.mLock
            monitor-enter(r7)
            com.xiaopeng.montecarlo.aimessage.AiMsgManager$MsgListener r8 = r6.mCurrentCarStateRequester     // Catch: java.lang.Throwable -> Lb2
            if (r8 == 0) goto Lab
            com.xiaopeng.montecarlo.aimessage.AiMsgManager$MsgListener r8 = r6.mCurrentCarStateRequester     // Catch: java.lang.Throwable -> Lb2
            r8.onReceive(r2)     // Catch: java.lang.Throwable -> Lb2
            boolean r8 = com.xiaopeng.montecarlo.root.util.L.ENABLE     // Catch: java.lang.Throwable -> Lb2
            if (r8 == 0) goto La9
            com.xiaopeng.montecarlo.aimessage.AiMsgManager$MsgListener r8 = r6.mCurrentCarStateRequester     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r8 = r8.getName()     // Catch: java.lang.Throwable -> Lb2
            com.xiaopeng.montecarlo.root.util.L$Tag r9 = com.xiaopeng.montecarlo.aimessage.LocalAiMsgService.TAG     // Catch: java.lang.Throwable -> Lb2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2
            r0.<init>()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = "send car state msg to listener:"
            r0.append(r2)     // Catch: java.lang.Throwable -> Lb2
            r0.append(r8)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r8 = ", "
            r0.append(r8)     // Catch: java.lang.Throwable -> Lb2
            com.xiaopeng.montecarlo.aimessage.AiMsgManager$MsgListener r8 = r6.mCurrentCarStateRequester     // Catch: java.lang.Throwable -> Lb2
            java.lang.Class r8 = r8.getClass()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r8 = r8.getSimpleName()     // Catch: java.lang.Throwable -> Lb2
            r0.append(r8)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r8 = r0.toString()     // Catch: java.lang.Throwable -> Lb2
            com.xiaopeng.montecarlo.root.util.L.d(r9, r8)     // Catch: java.lang.Throwable -> Lb2
        La9:
            r6.mCurrentCarStateRequester = r1     // Catch: java.lang.Throwable -> Lb2
        Lab:
            java.lang.Object r8 = r6.mLock     // Catch: java.lang.Throwable -> Lb2
            r8.notify()     // Catch: java.lang.Throwable -> Lb2
            monitor-exit(r7)     // Catch: java.lang.Throwable -> Lb2
            goto Le9
        Lb2:
            r8 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> Lb2
            throw r8
        Lb5:
            java.util.List<com.xiaopeng.montecarlo.aimessage.AiMsgManager$MsgListener> r7 = r6.mList
            java.util.Iterator r7 = r7.iterator()
        Lbb:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto Le9
            java.lang.Object r8 = r7.next()
            com.xiaopeng.montecarlo.aimessage.AiMsgManager$MsgListener r8 = (com.xiaopeng.montecarlo.aimessage.AiMsgManager.MsgListener) r8
            boolean r9 = com.xiaopeng.montecarlo.root.util.L.ENABLE
            if (r9 == 0) goto Le5
            java.lang.String r9 = r8.getName()
            com.xiaopeng.montecarlo.root.util.L$Tag r0 = com.xiaopeng.montecarlo.aimessage.LocalAiMsgService.TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "send msg to listener:"
            r1.append(r3)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.xiaopeng.montecarlo.root.util.L.d(r0, r9)
        Le5:
            r8.onReceive(r2)
            goto Lbb
        Le9:
            return
        Lea:
            r6.releaseLock()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.aimessage.LocalAiMsgService.handleAiMsgEvent(int, java.lang.String, android.os.Bundle):void");
    }

    private LocalAiMsgService() {
        TrafficWaringModel.getInstance().bind(this);
        MapControlModel.getInstance().bind(this);
        LocalCommModel.getInstance().bind(this);
        BLMsgPushCommModel.getInstance().bind();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.xiaopeng.montecarlo.TEST_AIMSG");
        ContextUtils.getContext().registerReceiver(new BroadcastReceiver() { // from class: com.xiaopeng.montecarlo.aimessage.LocalAiMsgService.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                L.i(LocalAiMsgService.TAG, "LocalAiMsgService TEST Receiver");
                LocalAiMsgService.this.requestCarState();
            }
        }, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LocalAiMsgService getInstance() {
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseLock() {
        if (isRequestingCarState()) {
            if (L.ENABLE) {
                L.d(TAG, "releaseLock");
            }
            synchronized (this.mLock) {
                this.mLock.notifyAll();
            }
        }
    }

    private IIpcService getService() {
        if (this.mService == null) {
            this.mService = (IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class);
        }
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendData(int i, Bundle bundle, String... strArr) {
        if (CarFeatureManager.INSTANCE.isIpcExchange2Apirouter()) {
            IpcRouterUtil.sendData(i, bundle, strArr[0]);
            return;
        }
        IIpcService service = getService();
        if (service != null) {
            service.sendData(i, bundle, strArr);
        } else {
            L.e(TAG, "sendData Error! service is null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendToMessageCenter(String str, boolean z) {
        PageType pageType;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendToMessageCenter:" + str);
        }
        Bundle bundle = new Bundle();
        bundle.putString(IpcConfig.IPCKey.STRING_MSG, str);
        if (CarFeatureManager.INSTANCE.isIpcExchange2Apirouter()) {
            sendData(10009, bundle, "com.xiaopeng.aiassistant");
        } else {
            sendData(10009, bundle, IpcConfig.App.MESSAGE_CENTER);
        }
        if (z && (PageType.OTHER != (pageType = DataLogHelper.getPageType()) || PageType.NONE != pageType)) {
            DataLogUtil.sendStatData(pageType, BtnType.AI_SEND_MESSAGE_CENTER_TRAFFIC_WARNING, new Object[0]);
        }
        EventBus.getDefault().post(new AiMsgBroadcastEvent(1000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestCarState() {
        if (L.ENABLE) {
            L.d(TAG, "requestCarState");
        }
        if (CarFeatureManager.INSTANCE.isIpcExchange2Apirouter()) {
            sendData(10012, null, "com.xiaopeng.aiassistant");
        } else {
            sendData(10012, null, IpcConfig.App.MESSAGE_CENTER);
        }
    }

    void registerEvent(boolean z) {
        if (z) {
            EventBus.getDefault().register(this.mEventListener);
        } else {
            EventBus.getDefault().unregister(this.mEventListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean isRequestingCarState() {
        return this.mIsRequestingCarState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setRequestingCarState(boolean z) {
        this.mIsRequestingCarState = z;
    }

    public boolean requestCarState(AiMsgManager.MsgListener msgListener) {
        if (msgListener == null || TextUtils.isEmpty(msgListener.getName())) {
            return false;
        }
        try {
            L.Tag tag = TAG;
            L.i(tag, "requestCarState add to car state requester queue: " + msgListener + ", mIsRequestingCarState: " + isRequestingCarState());
            this.mCarStateCallQueue.offer(msgListener, MAX_WAIT, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            L.i(TAG, "requestCarState interrupted");
        }
        if (!isRequestingCarState()) {
            setRequestingCarState(true);
            WorkThreadUtil.getInstance().executeBusinessTask(this.mCarStateRunnable);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void register(AiMsgManager.MsgListener msgListener) {
        if (msgListener != null) {
            String name = msgListener.getName();
            if (TextUtils.isEmpty(name)) {
                return;
            }
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "register listener:" + name);
            }
            if (this.mList.contains(msgListener)) {
                return;
            }
            this.mList.add(msgListener);
            if (this.mIsListenEvent) {
                return;
            }
            this.mIsListenEvent = true;
            if (L.ENABLE) {
                L.d(TAG, "register mEventListener");
            }
            registerEvent(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unregister(AiMsgManager.MsgListener msgListener) {
        if (msgListener != null) {
            String name = msgListener.getName();
            if (TextUtils.isEmpty(name)) {
                return;
            }
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "unregister listener:" + name);
            }
            this.mList.remove(msgListener);
        }
        if (this.mIsListenEvent && this.mList.isEmpty()) {
            this.mIsListenEvent = false;
            if (L.ENABLE) {
                L.d(TAG, "unregister mEventListener");
            }
            registerEvent(false);
        }
    }
}
