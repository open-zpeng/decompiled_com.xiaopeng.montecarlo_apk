package com.xiaopeng.montecarlo.aimessage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.xiaopeng.montecarlo.aimessage.AiMsgManager;
import com.xiaopeng.montecarlo.aimessage.type.MapAiBtnContent;
import com.xiaopeng.montecarlo.aimessage.type.MapRouteMsg;
import com.xiaopeng.montecarlo.appengine.RouteByPhoneService;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import com.xiaopeng.montecarlo.stat.NaviGuiderStatUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class MapControlModel implements AiMsgManager.MsgListener {
    private static final L.Tag TAG = new L.Tag("MapControlModel");
    private static MapControlModel sInstance = new MapControlModel();
    private boolean mIsBindService = false;
    private boolean mIsOnlyMapShow = false;
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.xiaopeng.montecarlo.aimessage.MapControlModel.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(RouteByPhoneService.PONE_ROUTE_ACTION)) {
                MapControlModel.this.readSend2CarRouteContent();
            }
        }
    };
    private LocalAiMsgService mService;

    @Override // com.xiaopeng.montecarlo.aimessage.AiMsgManager.MsgListener
    public String getName() {
        return "MapControlModel";
    }

    private MapControlModel() {
        registerThirdPartLoginReceiver();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MapControlModel getInstance() {
        return sInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006c A[Catch: IOException -> 0x0070, TRY_LEAVE, TryCatch #7 {IOException -> 0x0070, blocks: (B:39:0x0067, B:41:0x006c), top: B:51:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.Reader, java.io.InputStreamReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String readJsonFile(java.lang.String r5) {
        /*
            java.lang.String r0 = "close json file error"
            java.io.File r1 = new java.io.File
            r1.<init>(r5)
            r5 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L4a
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L4a
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43
            java.lang.String r1 = "utf-8"
            r3.<init>(r4, r1)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            r5.<init>()     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
        L1e:
            int r1 = r3.read()     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            r4 = -1
            if (r1 == r4) goto L2a
            char r1 = (char) r1     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            r5.append(r1)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            goto L1e
        L2a:
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            r2.close()     // Catch: java.io.IOException -> L35
            r3.close()     // Catch: java.io.IOException -> L35
            goto L61
        L35:
            com.xiaopeng.montecarlo.root.util.L$Tag r1 = com.xiaopeng.montecarlo.aimessage.MapControlModel.TAG
            com.xiaopeng.montecarlo.root.util.L.i(r1, r0)
            goto L61
        L3b:
            r5 = move-exception
            r1 = r5
            goto L64
        L3e:
            r5 = move-exception
            r1 = r5
            goto L45
        L41:
            r1 = move-exception
            goto L65
        L43:
            r1 = move-exception
            r3 = r5
        L45:
            r5 = r2
            goto L4c
        L47:
            r1 = move-exception
            r2 = r5
            goto L65
        L4a:
            r1 = move-exception
            r3 = r5
        L4c:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L62
            if (r5 == 0) goto L54
            r5.close()     // Catch: java.io.IOException -> L5a
        L54:
            if (r3 == 0) goto L5f
            r3.close()     // Catch: java.io.IOException -> L5a
            goto L5f
        L5a:
            com.xiaopeng.montecarlo.root.util.L$Tag r5 = com.xiaopeng.montecarlo.aimessage.MapControlModel.TAG
            com.xiaopeng.montecarlo.root.util.L.i(r5, r0)
        L5f:
            java.lang.String r5 = ""
        L61:
            return r5
        L62:
            r1 = move-exception
            r2 = r5
        L64:
            r5 = r3
        L65:
            if (r2 == 0) goto L6a
            r2.close()     // Catch: java.io.IOException -> L70
        L6a:
            if (r5 == 0) goto L75
            r5.close()     // Catch: java.io.IOException -> L70
            goto L75
        L70:
            com.xiaopeng.montecarlo.root.util.L$Tag r5 = com.xiaopeng.montecarlo.aimessage.MapControlModel.TAG
            com.xiaopeng.montecarlo.root.util.L.i(r5, r0)
        L75:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.aimessage.MapControlModel.readJsonFile(java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bind(LocalAiMsgService localAiMsgService) {
        if (this.mIsBindService) {
            return;
        }
        this.mIsBindService = true;
        this.mService = localAiMsgService;
        localAiMsgService.register(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnlyMapShow(boolean z) {
        this.mIsOnlyMapShow = z;
    }

    @Override // com.xiaopeng.montecarlo.aimessage.AiMsgManager.MsgListener
    public void onReceive(@NonNull AiMsgManager.IpcMessage ipcMessage) {
        MapAiBtnContent mapAiBtnContent;
        L.Tag tag = TAG;
        L.i(tag, "onReceive message mIsOnlyMapShow:" + this.mIsOnlyMapShow + " message=" + ipcMessage.toString());
        if ("com.xiaopeng.aiassistant".equals(ipcMessage.getSenderPackageName()) && 10011 == ipcMessage.mMsgID && (mapAiBtnContent = (MapAiBtnContent) GsonUtil.fromJson(ipcMessage.getMsg(), (Class<Object>) MapAiBtnContent.class)) != null) {
            if ("LocalCommModel".equals(mapAiBtnContent.getTag())) {
                LocalCommModel.getInstance().onReceive(mapAiBtnContent);
                return;
            }
            MapRouteMsg mapRouteMsg = (MapRouteMsg) GsonUtil.fromJson(ipcMessage.getMsg(), (Class<Object>) MapRouteMsg.class);
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "msg:" + mapRouteMsg);
            }
            if (mapRouteMsg == null) {
                return;
            }
            int functionId = mapRouteMsg.getFunctionId();
            if (functionId == 0) {
                if (AiMsgUtils.getInstance().isAppInBackground()) {
                    AiMsgUtils.getInstance().sendMapToFront();
                }
                if (StateManager.getInstance().getState() == 1) {
                    StateManager.getInstance().switchActiveState();
                }
                if (mapRouteMsg.isRoute()) {
                    return;
                }
                AiMsgUtils.getInstance().doRoute(mapRouteMsg, functionId, false);
                return;
            }
            if (1 == functionId) {
                NaviGuiderStatUtil.bIWechatSend2CarStartRoute(AiMsgUtils.getInstance().getCurrentSceneMode(), mapRouteMsg);
            } else if (2 == functionId) {
                NaviGuiderStatUtil.bIXpSend2CarStartRoute(AiMsgUtils.getInstance().getCurrentSceneMode(), mapRouteMsg);
            } else if (3 == functionId) {
                AiMsgUtils.getInstance().chargeSearch();
                return;
            } else if (4 == functionId) {
                NaviGuiderStatUtil.bIXpRouteSend2CarStartRoute(AiMsgUtils.getInstance().getCurrentSceneMode(), mapRouteMsg);
            } else {
                L.Tag tag3 = TAG;
                L.e(tag3, "msg error:" + mapRouteMsg);
            }
            if (StateManager.getInstance().getState() == 1) {
                StateManager.getInstance().switchActiveState();
            }
            LocalAiMsgService localAiMsgService = this.mService;
            if (localAiMsgService != null) {
                localAiMsgService.sendToMessageCenter(ipcMessage.getMsg(), false);
            }
            AiMsgUtils.getInstance().doRoute(mapRouteMsg, functionId);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getRouteResult() {
        return AiMsgUtils.getInstance().getRouteResult();
    }

    private void registerThirdPartLoginReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RouteByPhoneService.PONE_ROUTE_ACTION);
        LocalBroadcastManager.getInstance(ContextUtils.getContext()).registerReceiver(this.mReceiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readSend2CarRouteContent() {
        Observable.create(new ObservableOnSubscribe<String>() { // from class: com.xiaopeng.montecarlo.aimessage.MapControlModel.3
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<String> observableEmitter) {
                String str = RootUtil.SD_CARD_NAVI_PATH + "/debug/" + RouteByPhoneService.PHONE_ROUTE_SEND2CAR_CONTENT;
                String readJsonFile = FileUtil.existFile(str) ? MapControlModel.readJsonFile(str) : null;
                if (TextUtils.isEmpty(readJsonFile)) {
                    return;
                }
                L.i(MapControlModel.TAG, "SEND2CAR json in file: " + readJsonFile);
                observableEmitter.onNext(readJsonFile);
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() { // from class: com.xiaopeng.montecarlo.aimessage.MapControlModel.2
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            @Override // io.reactivex.Observer
            public void onNext(String str) {
                MapControlModel.this.onReceive(new AiMsgManager.IpcMessage("com.xiaopeng.aiassistant", 10011, str));
            }
        });
    }
}
