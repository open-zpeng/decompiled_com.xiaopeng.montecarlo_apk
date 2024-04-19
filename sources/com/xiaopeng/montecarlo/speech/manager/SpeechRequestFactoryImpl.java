package com.xiaopeng.montecarlo.speech.manager;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaopeng.lib.apirouter.ApiRouter;
import com.xiaopeng.montecarlo.IntentActions;
import com.xiaopeng.montecarlo.MainActivity;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.speech.request.ISpeechRequest;
import com.xiaopeng.montecarlo.navcore.speech.request.SpeechRequest;
import com.xiaopeng.montecarlo.navcore.speech.request.SpeechRequestFactory;
import com.xiaopeng.montecarlo.navcore.speech.test.SpeechTestReceiver;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.service.navi.INaviStatusService;
/* loaded from: classes3.dex */
public class SpeechRequestFactoryImpl implements ISpeechRequest {
    private static final String ACTION_NAVI_SERVICE = "com.xiaopeng.montecarlo.NAVI_ACTION";
    private static final String ACTION_NAVI_SPEECH_TEST = "com.xiaopeng.montecarlo.TEST_SPEECH";
    private static final String EXTRA_PARAM = "param";
    private static final String PARSER_APP_ID = "navi";
    private static final String PARSER_SERVICE = "NAVI_STATUS";
    private static final int PARSER_TYPE = 3;
    private static final L.Tag TAG = new L.Tag("SpeechRequestFactoryImpl");
    private INaviStatusService mNaviStatusService = null;

    public SpeechRequestFactoryImpl() {
        SpeechRequestFactory.getInstance().init(this);
        bindNaviStatusServices();
        if (RootUtil.isUserVersion()) {
            return;
        }
        ContextUtils.getContext().registerReceiver(new SpeechTestReceiver(), new IntentFilter("com.xiaopeng.montecarlo.TEST_SPEECH"));
    }

    @Override // com.xiaopeng.montecarlo.navcore.speech.request.ISpeechRequest
    public Object postRequestForResult(int i) {
        return postRequestForResult(i, null);
    }

    @Override // com.xiaopeng.montecarlo.navcore.speech.request.ISpeechRequest
    public Object postRequestForResult(int i, String str) {
        try {
            if (this.mNaviStatusService != null) {
                switch (i) {
                    case 10001:
                        return Boolean.valueOf(this.mNaviStatusService.isNavi());
                    case 10002:
                        return Boolean.valueOf(this.mNaviStatusService.isCruise());
                    case 10003:
                        return Boolean.valueOf(this.mNaviStatusService.isExplore());
                    case 10004:
                        return Boolean.valueOf(this.mNaviStatusService.isRoute());
                    case 10005:
                        return Boolean.valueOf(this.mNaviStatusService.isZoomInMax());
                    case 10006:
                        return Boolean.valueOf(this.mNaviStatusService.isZoomOutMin());
                    case 10007:
                        return this.mNaviStatusService.getNavigationInfo();
                    case 10008:
                        return this.mNaviStatusService.getCommonAddress(str);
                    case 10009:
                        return this.mNaviStatusService.getCurrentSceneName(false);
                    case 10010:
                        return this.mNaviStatusService.getCurrentSceneName(true);
                    case 10011:
                        return Boolean.valueOf(this.mNaviStatusService.isOpenOverViewMode());
                    case 10012:
                        return Integer.valueOf(this.mNaviStatusService.getMapMode());
                    case 10013:
                        return this.mNaviStatusService.getSettingInfo();
                    case 10014:
                        return Integer.valueOf(this.mNaviStatusService.getCurrentMapScaleLevel());
                    case 10015:
                        return Boolean.valueOf(this.mNaviStatusService.isLaneMode());
                    default:
                        return null;
                }
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.speech.request.ISpeechRequest
    public void postRequest(int i) {
        postRequest(i, (String) null);
    }

    @Override // com.xiaopeng.montecarlo.navcore.speech.request.ISpeechRequest
    public void postRequest(int i, boolean z) {
        postRequest(i, null, z);
    }

    @Override // com.xiaopeng.montecarlo.navcore.speech.request.ISpeechRequest
    public void postRequest(int i, String str) {
        postRequest(i, str, true);
    }

    @Override // com.xiaopeng.montecarlo.navcore.speech.request.ISpeechRequest
    public void postRequest(int i, String str, boolean z) {
        postRequest(new SpeechRequest().setType(i).setExtra(str), z);
    }

    @Override // com.xiaopeng.montecarlo.navcore.speech.request.ISpeechRequest
    public void postRequest(SpeechRequest speechRequest, boolean z) {
        if (speechRequest == null) {
            L.w(TAG, "postRequest, request is null");
            return;
        }
        if (20001 != speechRequest.getType()) {
            VoiceFusionUtil.getInstance().closeCancelableDialog();
        }
        boolean isTopActivity = RootUtil.isTopActivity();
        L.Tag tag = TAG;
        L.i(tag, "postRequest, isBackground=" + z + ", request=" + speechRequest.getType() + ",isTopActivity:" + isTopActivity + ",thread:" + Thread.currentThread());
        if (z || isTopActivity) {
            sentBackgroundSpeechEventByApiRouter(GsonUtil.toJson(speechRequest));
            return;
        }
        Bundle bundle = new Bundle();
        Intent intent = new Intent(ContextUtils.getContext(), MainActivity.class);
        bundle.putString(IntentActions.ActionsKey.KEY_ACTION, IntentActions.ACTION_SPEECH_COMMAND_DISPATCH);
        bundle.putString("operate_type", SpeechNaviEvent.SPEECH_OPERATE_TYPE_POST_REQUEST);
        bundle.putString(SpeechRequestFactory.PARAM_SPEECH_REQUEST, GsonUtil.toJson(speechRequest));
        intent.putExtras(bundle);
        ContextUtils.startActivityWithNewTask(intent);
    }

    public void sentBackgroundSpeechEventByApiRouter(final String str) {
        WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.speech.manager.SpeechRequestFactoryImpl.1
            @Override // java.lang.Runnable
            public void run() {
                L.i(SpeechRequestFactoryImpl.TAG, "try to sentBackgroundSpeechEvent");
                Uri.Builder builder = new Uri.Builder();
                builder.authority("com.xiaopeng.montecarlo.NaviSpeechParser").path("handleSpeechCmdFromApiRouter").appendQueryParameter("content", str);
                try {
                    ApiRouter.route(builder.build());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void bindNaviStatusServices() {
        Intent intent = new Intent("com.xiaopeng.montecarlo.NAVI_ACTION");
        intent.setPackage(ContextUtils.getContext().getPackageName());
        intent.putExtra("service", "NAVI_STATUS");
        intent.putExtra("app_id", "navi");
        boolean bindService = ContextUtils.getContext().bindService(intent, new ServiceConnection() { // from class: com.xiaopeng.montecarlo.speech.manager.SpeechRequestFactoryImpl.2
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (L.ENABLE) {
                    L.d(SpeechRequestFactoryImpl.TAG, "onServiceConnected");
                }
                SpeechRequestFactoryImpl.this.mNaviStatusService = INaviStatusService.Stub.asInterface(iBinder);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                if (L.ENABLE) {
                    L.d(SpeechRequestFactoryImpl.TAG, "onServiceDisconnected");
                }
                SpeechRequestFactoryImpl.this.mNaviStatusService = null;
            }
        }, 1);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getNaviStatus：" + bindService);
        }
    }
}
