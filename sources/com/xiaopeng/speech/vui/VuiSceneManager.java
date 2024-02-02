package com.xiaopeng.speech.vui;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewRootImpl;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.gson.Gson;
import com.xiaopeng.lib.apirouter.ApiRouter;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import com.xiaopeng.speech.apirouter.Utils;
import com.xiaopeng.speech.protocol.event.VuiEvent;
import com.xiaopeng.speech.vui.cache.VuiSceneBuildCache;
import com.xiaopeng.speech.vui.cache.VuiSceneCache;
import com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory;
import com.xiaopeng.speech.vui.cache.VuiSceneRemoveCache;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.speech.vui.listener.IVuiEventListener;
import com.xiaopeng.speech.vui.model.VuiEventInfo;
import com.xiaopeng.speech.vui.model.VuiFeedback;
import com.xiaopeng.speech.vui.model.VuiScene;
import com.xiaopeng.speech.vui.model.VuiSceneInfo;
import com.xiaopeng.speech.vui.model.VuiSceneState;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.speech.vui.utils.ResourceUtil;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import com.xiaopeng.vui.commons.IVuiElement;
import com.xiaopeng.vui.commons.IVuiElementChangedListener;
import com.xiaopeng.vui.commons.IVuiSceneListener;
import com.xiaopeng.vui.commons.VuiAction;
import com.xiaopeng.vui.commons.VuiElementType;
import com.xiaopeng.vui.commons.model.VuiElement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.paho.android.service.MqttServiceConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class VuiSceneManager {
    private static int SEND_UPLOAD_MESSAGE = 1;
    public static int TYPE_ADD = 2;
    public static int TYPE_BUILD = 0;
    public static int TYPE_REMOVE = 3;
    public static int TYPE_UPDATE = 1;
    public static int TYPE_UPDATEATTR = 4;
    private final String TAG;
    private String mActiveSceneId;
    private Handler mApiRouterHandler;
    private HandlerThread mApiRouterThread;
    private Binder mBinder;
    private Context mContext;
    private Handler mHandler;
    private boolean mIsInSpeech;
    private String mObserver;
    private String mPackageName;
    private String mPackageVersion;
    private String mProcessName;
    private VuiBroadCastReceiver mReceiver;
    private Runnable mSubscribeRunner;
    private HandlerThread mThread;
    private ConcurrentHashMap<String, VuiSceneInfo> mVuiSceneInfoMap;
    private ConcurrentHashMap<String, VuiSceneInfo> mVuiSubSceneInfoMap;
    private List<String> sceneIds;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasProcessFeature() {
        return true;
    }

    public void setInSpeech(boolean z) {
        this.mIsInSpeech = z;
        if (this.mIsInSpeech) {
            sendSceneData(null);
        }
    }

    public boolean isInSpeech() {
        return this.mIsInSpeech;
    }

    private VuiSceneManager() {
        this.TAG = "VuiSceneManager";
        this.mIsInSpeech = false;
        this.mBinder = null;
        this.mReceiver = null;
        this.mSubscribeRunner = new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.1
            @Override // java.lang.Runnable
            public void run() {
                VuiSceneManager.this.subscribe();
            }
        };
        this.mProcessName = null;
        this.sceneIds = new ArrayList();
        this.mVuiSceneInfoMap = new ConcurrentHashMap<>();
        this.mVuiSubSceneInfoMap = new ConcurrentHashMap<>();
        lazyInitThread();
    }

    public static final VuiSceneManager instance() {
        return Holder.Instance;
    }

    public void subscribe(String str) {
        if (!Utils.isCorrectObserver(this.mPackageName, str)) {
            LogUtils.e("VuiSceneManager", "注册observer不合法,observer是app的包名加observer的类名组成");
            return;
        }
        this.mObserver = str;
        if (VuiUtils.canUseVuiFeature()) {
            subscribe();
            sendBroadCast();
            registerReceiver();
        }
    }

    private void lazyInitThread() {
        if (this.mThread == null) {
            this.mThread = new HandlerThread("VuiSceneManager-Thread");
            this.mThread.start();
            this.mHandler = new VuiSceneHandler(this.mThread.getLooper());
        }
        if (this.mApiRouterThread == null) {
            this.mApiRouterThread = new HandlerThread("VuiSceneManager-Apirouter-Thread");
            this.mApiRouterThread.start();
            this.mApiRouterHandler = new Handler(this.mApiRouterThread.getLooper());
        }
    }

    public void reSetBinder() {
        this.mBinder = null;
    }

    public void setFeatureState(boolean z) {
        try {
            if (z) {
                handleSceneDataInfo();
            } else {
                handleAllSceneCache(true);
                handleSceneDataInfo();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class VuiSceneHandler extends Handler {
        public VuiSceneHandler() {
        }

        public VuiSceneHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == VuiSceneManager.SEND_UPLOAD_MESSAGE) {
                int i = message.arg1;
                boolean z = message.arg2 == 1;
                if (i == VuiSceneManager.TYPE_ADD) {
                    VuiSceneManager.this.addSceneElementGroup((VuiScene) message.obj, z);
                } else if (i == VuiSceneManager.TYPE_BUILD) {
                    VuiSceneManager.this.buildScene((VuiScene) message.obj, z, true);
                } else if (i == VuiSceneManager.TYPE_UPDATE) {
                    VuiSceneManager.this.updateDynamicScene((VuiScene) message.obj, z);
                } else if (i == VuiSceneManager.TYPE_UPDATEATTR) {
                    VuiSceneManager.this.updateSceneElementAttr((VuiScene) message.obj, z);
                } else {
                    String str = (String) message.obj;
                    int indexOf = str.indexOf(",");
                    VuiSceneManager.this.removeSceneElementGroup(str.substring(0, indexOf), str.substring(indexOf + 1), z);
                }
            }
        }
    }

    private void registerReceiver() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (VuiUtils.canUseVuiFeature()) {
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction("carspeechservice.SpeechServer.Start");
                            intentFilter.addAction(VuiConstants.INTENT_ACTION_ENV_CHANGED);
                            VuiSceneManager.this.mReceiver = new VuiBroadCastReceiver();
                            ((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).registerReceiver(VuiSceneManager.this.mReceiver, intentFilter);
                        }
                    } catch (Exception e) {
                        LogUtils.e("VuiSceneManager", "registerReceiver e:" + e.getMessage());
                    }
                }
            });
        }
    }

    public void handleSceneDataInfo() {
        String str;
        if (VuiEngineImpl.mActiveSceneId == null || (str = this.mPackageName) == null || !str.equals(getTopRunningPackageName())) {
            return;
        }
        enterScene(VuiEngineImpl.mActiveSceneId, this.mPackageName, true);
    }

    public void handleAllSceneCache(boolean z) {
        try {
            if (this.sceneIds == null) {
                return;
            }
            for (int i = 0; i < this.sceneIds.size(); i++) {
                String str = this.sceneIds.get(i);
                if (z) {
                    VuiSceneCacheFactory.instance().removeAllCache(str);
                    VuiSceneInfo vuiSceneInfo = this.mVuiSceneInfoMap.get(str);
                    if (vuiSceneInfo != null) {
                        vuiSceneInfo.reset(false);
                        this.mVuiSceneInfoMap.put(str, vuiSceneInfo);
                    }
                } else {
                    ((VuiSceneBuildCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType())).setUploadedState(str, false);
                    VuiSceneCacheFactory.instance().removeOtherCache(str);
                }
            }
        } catch (Exception e) {
            LogUtils.e("VuiSceneManager", "handleAllSceneCache e:" + e.getMessage());
        }
    }

    public void sendBroadCast() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.3
                @Override // java.lang.Runnable
                public void run() {
                    if (VuiSceneManager.this.mBinder == null) {
                        VuiSceneManager.this.mBinder = new Binder();
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    intent.setAction("com.xiaopeng.speech.vuiengine.start");
                    intent.setPackage("com.xiaopeng.carspeechservice");
                    bundle.putBinder("client", VuiSceneManager.this.mBinder);
                    bundle.putString("name", VuiSceneManager.this.mPackageName);
                    bundle.putString("version", VuiSceneManager.this.mPackageVersion);
                    if (VuiSceneManager.this.hasProcessFeature()) {
                        bundle.putString("processName", VuiSceneManager.this.getProcessName());
                    }
                    intent.putExtra("bundle", bundle);
                    VuiSceneManager.this.mContext.sendBroadcast(intent);
                }
            });
        }
    }

    public void subscribeVuiFeature() {
        if (VuiUtils.canUseVuiFeature()) {
            subscribe();
            sendBroadCast();
            registerReceiver();
        }
    }

    public void unSubscribeVuiFeature() {
        Handler handler;
        if (VuiUtils.canUseVuiFeature() && (handler = this.mHandler) != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ApiRouter.route(new Uri.Builder().authority(VuiSceneManager.this.getAuthority()).path("unsubscribeVuiFeatureProcess").appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).appendQueryParameter("processName", VuiSceneManager.this.getProcessName()).build());
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public void subscribe() {
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.5
                @Override // java.lang.Runnable
                public void run() {
                    if (VuiUtils.canUseVuiFeature()) {
                        LogUtils.logInfo("VuiSceneManager", "subscribe：" + VuiSceneManager.this.mObserver);
                        if (TextUtils.isEmpty(VuiSceneManager.this.mObserver)) {
                            LogUtils.e("VuiSceneManager", "mObserver == null");
                            try {
                                String str = (String) ApiRouter.route(new Uri.Builder().authority(VuiSceneManager.this.getAuthority()).path("subscribeVuiFeatureProcess").appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).appendQueryParameter("processName", VuiSceneManager.this.getProcessName()).build());
                                LogUtils.logDebug("VuiSceneManager", "subscribeVuiFeature：" + str);
                                if (!TextUtils.isEmpty(str)) {
                                    if (str.contains("dm_start")) {
                                        VuiSceneManager.this.mIsInSpeech = true;
                                    } else if (str.contains("dm_end")) {
                                        VuiSceneManager.this.mIsInSpeech = false;
                                    } else if (str.contains("vui_disabled")) {
                                        VuiSceneManager.this.setFeatureState(false);
                                        VuiUtils.disableVuiFeature();
                                    } else if (str.contains("vui_enable")) {
                                        VuiSceneManager.this.setFeatureState(true);
                                        VuiUtils.enableVuiFeature();
                                    }
                                }
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        }
                        new String[]{VuiEvent.SCENE_CONTROL};
                        if (VuiSceneManager.this.mHandler != null) {
                            VuiSceneManager.this.mHandler.removeCallbacks(VuiSceneManager.this.mSubscribeRunner);
                        }
                        try {
                            if (VuiSceneManager.this.hasProcessFeature()) {
                                ApiRouter.route(new Uri.Builder().authority(VuiSceneManager.this.getAuthority()).path("subscribeProcess").appendQueryParameter("observer", VuiSceneManager.this.mObserver).appendQueryParameter("param", "").appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).appendQueryParameter("sceneList", VuiSceneManager.this.sceneIds.toString()).appendQueryParameter("processName", VuiSceneManager.this.getProcessName()).build());
                            } else {
                                ApiRouter.route(new Uri.Builder().authority(VuiSceneManager.this.getAuthority()).path(MqttServiceConstants.SUBSCRIBE_ACTION).appendQueryParameter("observer", VuiSceneManager.this.mObserver).appendQueryParameter("param", "").appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).appendQueryParameter("sceneList", VuiSceneManager.this.sceneIds.toString()).build());
                            }
                        } catch (Exception e) {
                            LogUtils.e("VuiSceneManager", "subscribe e:" + e.fillInStackTrace());
                        }
                    }
                }
            });
        }
    }

    public String getProcessName() {
        BufferedReader bufferedReader;
        String str = "main";
        if (!TextUtils.isEmpty(this.mProcessName)) {
            return this.mProcessName;
        }
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
                try {
                    try {
                        String trim = bufferedReader.readLine().trim();
                        try {
                            if (trim.startsWith(this.mPackageName)) {
                                trim = trim.replace(this.mPackageName, "");
                            }
                            if (!TextUtils.isEmpty(trim)) {
                                str = trim.substring(1);
                            }
                            this.mProcessName = str + ",pid_" + Process.myPid();
                            String str2 = this.mProcessName;
                            try {
                                bufferedReader.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return str2;
                        } catch (Exception e2) {
                            e = e2;
                            str = trim;
                            bufferedReader2 = bufferedReader;
                            e.printStackTrace();
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            return str;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = bufferedReader2;
        }
    }

    public void setProcessName(String str) {
        this.mProcessName = str + ",pid_" + Process.myPid();
    }

    public void unSubscribe() {
        Handler handler;
        if (VuiUtils.canUseVuiFeature() && (handler = this.mHandler) != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.6
                @Override // java.lang.Runnable
                public void run() {
                    VuiSceneManager.this.unsubscribe();
                }
            });
        }
    }

    public void unsubscribe() {
        if (TextUtils.isEmpty(this.mObserver)) {
            LogUtils.e("VuiSceneManager", "mObserver == null");
            return;
        }
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.7
                @Override // java.lang.Runnable
                public void run() {
                    if (VuiSceneManager.this.hasProcessFeature()) {
                        try {
                            ApiRouter.route(new Uri.Builder().authority(VuiSceneManager.this.getAuthority()).path("unsubscribeProcess").appendQueryParameter("observer", VuiSceneManager.this.mObserver).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).appendQueryParameter("processName", VuiSceneManager.this.getProcessName()).build());
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            LogUtils.e("VuiSceneManager", "unsubscribe e:" + th.getMessage());
                            return;
                        }
                    }
                    try {
                        ApiRouter.route(new Uri.Builder().authority(VuiSceneManager.this.getAuthority()).path(MqttServiceConstants.UNSUBSCRIBE_ACTION).appendQueryParameter("observer", VuiSceneManager.this.mObserver).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).build());
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        LogUtils.e("VuiSceneManager", "unsubscribe e:" + th2.getMessage());
                    }
                }
            });
        }
    }

    public synchronized void sendSceneData(final String str) {
        try {
            this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.8
                @Override // java.lang.Runnable
                public void run() {
                    VuiSceneCache sceneCache;
                    int fusionType;
                    VuiSceneRemoveCache vuiSceneRemoveCache;
                    List<VuiElement> cache;
                    if (VuiUtils.cannotUpload()) {
                        return;
                    }
                    String str2 = str;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = VuiEngineImpl.mActiveSceneId;
                    }
                    if (!VuiSceneManager.this.isUploadScene(str2) || (sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.UPDATE.getType())) == null || (fusionType = sceneCache.getFusionType(str2)) == VuiSceneCacheFactory.CacheType.DEFAULT.getType()) {
                        return;
                    }
                    LogUtils.logInfo("VuiSceneManager", "sendSceneData from cacheType:" + fusionType + ",processName:" + VuiSceneManager.this.getProcessName());
                    VuiScene build = new VuiScene.Builder().sceneId(str2).appVersion(VuiSceneManager.this.mPackageVersion).packageName(VuiSceneManager.this.mPackageName).timestamp(System.currentTimeMillis()).build();
                    if (fusionType == VuiSceneCacheFactory.CacheType.UPDATE.getType()) {
                        build.setElements(sceneCache.getCache(str2));
                        VuiSceneManager.this.sendSceneData(VuiSceneManager.TYPE_UPDATE, false, build);
                    } else if (fusionType == VuiSceneCacheFactory.CacheType.BUILD.getType()) {
                        VuiSceneCache sceneCache2 = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                        if (sceneCache2 == null || (cache = sceneCache2.getCache(str2)) == null || cache.isEmpty()) {
                            return;
                        }
                        build.setElements(sceneCache2.getCache(str2));
                        VuiSceneManager.this.sendSceneData(VuiSceneManager.TYPE_BUILD, false, build);
                    } else if (fusionType != VuiSceneCacheFactory.CacheType.REMOVE.getType() || (vuiSceneRemoveCache = (VuiSceneRemoveCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.REMOVE.getType())) == null) {
                    } else {
                        VuiSceneManager vuiSceneManager = VuiSceneManager.this;
                        int i = VuiSceneManager.TYPE_REMOVE;
                        vuiSceneManager.sendSceneData(i, false, str2 + "," + vuiSceneRemoveCache.getRemoveCache(str2).toString().replace("[", "").replace("]", ""));
                    }
                }
            });
        } catch (Exception e) {
            e.fillInStackTrace();
            LogUtils.e("VuiSceneManager", "sendSceneData e:" + e.getMessage());
        }
    }

    public void sendSceneData(int i, boolean z, Object obj) {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.arg1 = i;
        obtainMessage.what = SEND_UPLOAD_MESSAGE;
        obtainMessage.arg2 = z ? 1 : 0;
        obtainMessage.obj = obj;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Holder {
        private static final VuiSceneManager Instance = new VuiSceneManager();

        private Holder() {
        }
    }

    public void buildScene(final VuiScene vuiScene, final boolean z, final boolean z2) {
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.9
                @Override // java.lang.Runnable
                public void run() {
                    VuiScene vuiScene2;
                    String sceneId;
                    if (VuiUtils.cannotUpload() || (vuiScene2 = vuiScene) == null || vuiScene2.getElements() == null || vuiScene.getElements().size() < 0 || (sceneId = vuiScene.getSceneId()) == null) {
                        return;
                    }
                    VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                    if (z || z2 || !sceneCache.getUploadedState(sceneId)) {
                        if (sceneCache != null && z) {
                            List<VuiElement> cache = sceneCache.getCache(sceneId);
                            if (cache != null && !cache.isEmpty()) {
                                vuiScene.setElements(sceneCache.getUpdateFusionCache(sceneId, vuiScene.getElements(), false));
                            }
                            sceneCache.setCache(sceneId, vuiScene.getElements());
                        }
                        String vuiSceneConvertToString = VuiUtils.vuiSceneConvertToString(vuiScene);
                        VuiSceneInfo sceneInfo = VuiSceneManager.instance().getSceneInfo(sceneId);
                        if (sceneInfo != null && sceneInfo.isWholeScene() && sceneInfo.isFull()) {
                            sceneInfo.setLastAddStr(null);
                            sceneInfo.setLastUpdateStr(null);
                            LogUtils.logDebug("VuiSceneManager", "build full_scene_info:" + vuiSceneConvertToString);
                            if (VuiSceneManager.this.isUploadScene(sceneId)) {
                                Uri.Builder builder = new Uri.Builder();
                                builder.authority(VuiSceneManager.this.getAuthority()).path("buildScene").appendQueryParameter(VuiConstants.SCENE_ID, sceneId).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, vuiScene.getPackageName()).appendQueryParameter("packageVersion", vuiScene.getVersion()).appendQueryParameter("sceneData", vuiSceneConvertToString);
                                try {
                                    LogUtils.logDebug("VuiSceneManager", " send buildScene to CarSpeech" + sceneId);
                                    if (sceneCache != null) {
                                        sceneCache.setUploadedState(sceneId, false);
                                    }
                                    String str = (String) ApiRouter.route(builder.build());
                                    if (!TextUtils.isEmpty(str) && sceneCache != null) {
                                        sceneCache.setUploadedState(sceneId, true);
                                    }
                                    LogUtils.logInfo("VuiSceneManager", " send buildScene to CarSpeech success" + sceneId + ",result:" + str);
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                    if (sceneCache != null) {
                                        sceneCache.setUploadedState(sceneId, false);
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public void addSceneElement(final VuiScene vuiScene, final String str) {
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.10
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (VuiUtils.cannotUpload()) {
                            return;
                        }
                        String vuiSceneConvertToString = VuiUtils.vuiSceneConvertToString(vuiScene);
                        Uri.Builder builder = new Uri.Builder();
                        builder.authority(VuiSceneManager.this.getAuthority()).path("addSceneElement").appendQueryParameter(VuiConstants.SCENE_ID, vuiScene.getSceneId()).appendQueryParameter("parentId", str).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, vuiScene.getPackageName()).appendQueryParameter("packageVersion", vuiScene.getVersion()).appendQueryParameter("sceneData", vuiSceneConvertToString);
                        LogUtils.logDebug("VuiSceneManager", "addSceneElement to CarSpeech " + vuiScene.getSceneId());
                        LogUtils.logInfo("VuiSceneManager", "addSceneElement to CarSpeech success" + vuiScene.getSceneId() + ",result:" + ((String) ApiRouter.route(builder.build())));
                    } catch (Exception e) {
                        e.printStackTrace();
                        LogUtils.e("VuiSceneManager", "addSceneElement e:" + e.getMessage());
                    }
                }
            });
        }
    }

    public void addSceneElementGroup(final VuiScene vuiScene, boolean z) {
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.11
                @Override // java.lang.Runnable
                public void run() {
                    VuiScene vuiScene2;
                    String sceneId;
                    VuiSceneRemoveCache vuiSceneRemoveCache;
                    List<VuiElement> elements;
                    if (VuiUtils.cannotUpload() || (vuiScene2 = vuiScene) == null || (sceneId = vuiScene2.getSceneId()) == null) {
                        return;
                    }
                    VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.UPDATE.getType());
                    VuiSceneCache sceneCache2 = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                    int type = VuiSceneCacheFactory.CacheType.DEFAULT.getType();
                    List<VuiElement> list = null;
                    if (sceneCache != null) {
                        type = sceneCache.getFusionType(sceneId);
                        if (type == VuiSceneCacheFactory.CacheType.UPDATE.getType()) {
                            list = sceneCache.getUpdateFusionCache(sceneId, vuiScene.getElements(), false);
                        } else if (type == VuiSceneCacheFactory.CacheType.BUILD.getType()) {
                            if (sceneCache2 != null) {
                                list = sceneCache2.getFusionCache(sceneId, vuiScene.getElements(), false);
                            }
                        } else if (type == VuiSceneCacheFactory.CacheType.REMOVE.getType() && (vuiSceneRemoveCache = (VuiSceneRemoveCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.REMOVE.getType())) != null && (elements = vuiScene.getElements()) != null && elements.size() == 1) {
                            vuiSceneRemoveCache.deleteRemoveIdFromCache(sceneId, vuiScene.getElements().get(0).id);
                        }
                        if (list != null) {
                            vuiScene.setElements(list);
                        }
                    }
                    if (VuiSceneManager.this.isUploadScene(sceneId)) {
                        if (type == VuiSceneCacheFactory.CacheType.BUILD.getType()) {
                            VuiSceneManager.this.sendBuildCacheInOther(sceneId, vuiScene, sceneCache2);
                            return;
                        }
                        String vuiSceneConvertToString = VuiUtils.vuiSceneConvertToString(vuiScene);
                        Uri.Builder builder = new Uri.Builder();
                        builder.authority(VuiSceneManager.this.getAuthority()).path("addSceneElementGroup").appendQueryParameter(VuiConstants.SCENE_ID, sceneId).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, vuiScene.getPackageName()).appendQueryParameter("packageVersion", vuiScene.getVersion()).appendQueryParameter("sceneData", vuiSceneConvertToString);
                        try {
                            LogUtils.logDebug("VuiSceneManager", "addSceneElementGroup to CarSpeech " + sceneId);
                            String str = (String) ApiRouter.route(builder.build());
                            LogUtils.logInfo("VuiSceneManager", "addSceneElementGroup to CarSpeech success " + sceneId + ",result:" + str);
                            if (TextUtils.isEmpty(str)) {
                                if (sceneCache != null) {
                                    sceneCache.setCache(sceneId, vuiScene.getElements());
                                }
                            } else if (type == VuiSceneCacheFactory.CacheType.UPDATE.getType()) {
                                sceneCache.removeCache(sceneId);
                            }
                        } catch (RemoteException e) {
                            LogUtils.e("VuiSceneManager", "addSceneElementGroup " + e.fillInStackTrace());
                            e.printStackTrace();
                            if (sceneCache != null) {
                                sceneCache.setCache(sceneId, vuiScene.getElements());
                            }
                        }
                        if (sceneCache2 != null) {
                            List<VuiElement> fusionCache = sceneCache2.getFusionCache(sceneId, vuiScene.getElements(), false);
                            if (fusionCache != null) {
                                sceneCache2.setCache(sceneId, fusionCache);
                            }
                            vuiScene.setElements(fusionCache);
                        }
                        if ("user".equals(Build.TYPE) || LogUtils.getLogLevel() > LogUtils.LOG_DEBUG_LEVEL) {
                            return;
                        }
                        LogUtils.logDebug("VuiSceneManager", "addSceneElementGroup full_scene_info:" + VuiUtils.vuiSceneConvertToString(vuiScene));
                        return;
                    }
                    if (type != VuiSceneCacheFactory.CacheType.BUILD.getType()) {
                        if (sceneCache != null) {
                            sceneCache.setCache(sceneId, vuiScene.getElements());
                        }
                        if (sceneCache2 != null) {
                            List<VuiElement> fusionCache2 = sceneCache2.getFusionCache(sceneId, vuiScene.getElements(), false);
                            if (fusionCache2 != null) {
                                sceneCache2.setCache(sceneId, fusionCache2);
                            }
                            vuiScene.setElements(fusionCache2);
                        }
                    } else if (sceneCache2 != null) {
                        sceneCache2.setCache(sceneId, vuiScene.getElements());
                    }
                    if ("user".equals(Build.TYPE) || LogUtils.getLogLevel() > LogUtils.LOG_DEBUG_LEVEL) {
                        return;
                    }
                    LogUtils.logDebug("VuiSceneManager", "addSceneElementGroup from full_scene_info:" + VuiUtils.vuiSceneConvertToString(vuiScene));
                }
            });
        }
    }

    public void removeSceneElementGroup(final String str, final String str2, final boolean z) {
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.12
                /* JADX WARN: Removed duplicated region for block: B:40:0x0165  */
                /* JADX WARN: Removed duplicated region for block: B:73:0x0235  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 752
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.speech.vui.VuiSceneManager.AnonymousClass12.run():void");
                }
            });
        }
    }

    public void vuiFeedBack(final View view, final VuiFeedback vuiFeedback) {
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.13
                @Override // java.lang.Runnable
                public void run() {
                    View view2;
                    if (vuiFeedback == null || (view2 = view) == null) {
                        return;
                    }
                    String str = null;
                    if (view2 != null && view2.getId() != -1 && view.getId() != 0) {
                        str = VuiUtils.getResourceName(view.getId());
                    }
                    Uri.Builder builder = new Uri.Builder();
                    Uri.Builder appendQueryParameter = builder.authority(VuiSceneManager.this.getAuthority()).path("vuiFeedback").appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).appendQueryParameter("resourceName", str);
                    appendQueryParameter.appendQueryParameter("state", "" + vuiFeedback.state).appendQueryParameter("type", vuiFeedback.getFeedbackType().getType()).appendQueryParameter("content", vuiFeedback.content);
                    try {
                        LogUtils.logDebug("VuiSceneManager", "vuiFeedBack ");
                        String str2 = (String) ApiRouter.route(builder.build());
                        LogUtils.logInfo("VuiSceneManager", "vuiFeedBack success");
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void vuiFeedBack(final String str, final VuiFeedback vuiFeedback) {
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.14
                @Override // java.lang.Runnable
                public void run() {
                    if (vuiFeedback == null || TextUtils.isEmpty(str)) {
                        return;
                    }
                    Uri.Builder builder = new Uri.Builder();
                    Uri.Builder appendQueryParameter = builder.authority(VuiSceneManager.this.getAuthority()).path("vuiFeedback").appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).appendQueryParameter("resourceName", "");
                    appendQueryParameter.appendQueryParameter("state", "" + vuiFeedback.state).appendQueryParameter("type", vuiFeedback.getFeedbackType().getType()).appendQueryParameter("content", vuiFeedback.content);
                    try {
                        LogUtils.logDebug("VuiSceneManager", "vuiFeedBack ");
                        String str2 = (String) ApiRouter.route(builder.build());
                        LogUtils.logInfo("VuiSceneManager", "vuiFeedBack success");
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void updateSceneElementAttr(final VuiScene vuiScene, boolean z) {
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.15
                @Override // java.lang.Runnable
                public void run() {
                    VuiScene vuiScene2;
                    String sceneId;
                    if (VuiUtils.cannotUpload() || (vuiScene2 = vuiScene) == null || vuiScene2.getElements() == null || vuiScene.getElements().size() < 0 || (sceneId = vuiScene.getSceneId()) == null) {
                        return;
                    }
                    VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                    VuiSceneCache sceneCache2 = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.UPDATE.getType());
                    int type = VuiSceneCacheFactory.CacheType.DEFAULT.getType();
                    List<VuiElement> list = null;
                    if (sceneCache2 != null) {
                        type = sceneCache2.getFusionType(sceneId);
                        if (type == VuiSceneCacheFactory.CacheType.UPDATE.getType()) {
                            list = sceneCache2.getUpdateFusionCache(sceneId, vuiScene.getElements(), true);
                        } else if (type == VuiSceneCacheFactory.CacheType.BUILD.getType() && sceneCache != null) {
                            list = sceneCache.getFusionCache(sceneId, vuiScene.getElements(), true);
                        }
                        if (list != null) {
                            vuiScene.setElements(list);
                        }
                    }
                    String vuiSceneConvertToString = VuiUtils.vuiSceneConvertToString(vuiScene);
                    if (VuiSceneManager.this.isUploadScene(sceneId)) {
                        if (type == VuiSceneCacheFactory.CacheType.BUILD.getType()) {
                            VuiSceneManager.this.sendBuildCacheInOther(sceneId, vuiScene, sceneCache);
                            return;
                        }
                        Uri.Builder builder = new Uri.Builder();
                        builder.authority(VuiSceneManager.this.getAuthority()).path("updateScene").appendQueryParameter(VuiConstants.SCENE_ID, sceneId).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, vuiScene.getPackageName()).appendQueryParameter("packageVersion", vuiScene.getVersion()).appendQueryParameter("sceneData", vuiSceneConvertToString);
                        try {
                            LogUtils.logDebug("VuiSceneManager", " updateSceneElementAttr to CarSpeech" + sceneId);
                            String str = (String) ApiRouter.route(builder.build());
                            LogUtils.logInfo("VuiSceneManager", "updateSceneElementAttr to CarSpeech success" + sceneId + ",result:" + str);
                            if (TextUtils.isEmpty(str)) {
                                if (sceneCache2 != null) {
                                    sceneCache2.setCache(sceneId, vuiScene.getElements());
                                }
                            } else if (sceneCache2 != null) {
                                sceneCache2.removeCache(sceneId);
                            }
                        } catch (RemoteException e) {
                            e.printStackTrace();
                            LogUtils.e("VuiSceneManager", "updateSceneElementAttr " + e.fillInStackTrace());
                            if (sceneCache2 != null) {
                                sceneCache2.setCache(sceneId, vuiScene.getElements());
                            }
                        }
                        if (sceneCache != null) {
                            List<VuiElement> fusionCache = sceneCache.getFusionCache(sceneId, vuiScene.getElements(), true);
                            if (fusionCache != null) {
                                sceneCache.setCache(sceneId, fusionCache);
                            }
                            vuiScene.setElements(fusionCache);
                        }
                        if ("user".equals(Build.TYPE) || LogUtils.getLogLevel() > LogUtils.LOG_DEBUG_LEVEL) {
                            return;
                        }
                        LogUtils.logDebug("VuiSceneManager", "updateSceneElementAttr " + VuiUtils.vuiSceneConvertToString(vuiScene));
                        return;
                    }
                    if (type != VuiSceneCacheFactory.CacheType.BUILD.getType()) {
                        if (sceneCache2 != null) {
                            sceneCache2.setCache(sceneId, ((VuiScene) new Gson().fromJson(vuiSceneConvertToString, (Class<Object>) VuiScene.class)).getElements());
                        }
                        if (sceneCache != null) {
                            List<VuiElement> fusionCache2 = sceneCache.getFusionCache(sceneId, vuiScene.getElements(), true);
                            if (fusionCache2 != null) {
                                sceneCache.setCache(sceneId, fusionCache2);
                            }
                            vuiScene.setElements(fusionCache2);
                        }
                    } else if (sceneCache != null) {
                        sceneCache.setCache(sceneId, vuiScene.getElements());
                    }
                    if ("user".equals(Build.TYPE) || LogUtils.getLogLevel() > LogUtils.LOG_DEBUG_LEVEL) {
                        return;
                    }
                    LogUtils.logDebug("VuiSceneManager", "updateSceneElementAttr cache" + VuiUtils.vuiSceneConvertToString(vuiScene));
                }
            });
        }
    }

    public void updateDynamicScene(final VuiScene vuiScene, final boolean z) {
        Handler handler = this.mApiRouterHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.16
                @Override // java.lang.Runnable
                public void run() {
                    VuiScene vuiScene2;
                    String sceneId;
                    if (VuiUtils.cannotUpload() || (vuiScene2 = vuiScene) == null || vuiScene2.getElements() == null || vuiScene.getElements().size() < 0 || (sceneId = vuiScene.getSceneId()) == null || VuiSceneManager.this.getSceneInfo(sceneId) == null) {
                        return;
                    }
                    VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                    VuiSceneCache sceneCache2 = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.UPDATE.getType());
                    if (!z) {
                        if (VuiSceneManager.this.isUploadScene(sceneId) && sceneCache2.getFusionType(sceneId) == VuiSceneCacheFactory.CacheType.UPDATE.getType()) {
                            String vuiSceneConvertToString = VuiUtils.vuiSceneConvertToString(vuiScene);
                            Uri.Builder builder = new Uri.Builder();
                            builder.authority(VuiSceneManager.this.getAuthority()).path("updateScene").appendQueryParameter(VuiConstants.SCENE_ID, sceneId).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, vuiScene.getPackageName()).appendQueryParameter("packageVersion", vuiScene.getVersion()).appendQueryParameter("sceneData", vuiSceneConvertToString);
                            try {
                                LogUtils.logDebug("VuiSceneManager", " updateScene to CarSpeech " + sceneId);
                                String str = (String) ApiRouter.route(builder.build());
                                if (TextUtils.isEmpty(str)) {
                                    if (sceneCache2 != null) {
                                        sceneCache2.setCache(sceneId, vuiScene.getElements());
                                    }
                                } else if (sceneCache2 != null) {
                                    sceneCache2.removeCache(sceneId);
                                }
                                LogUtils.logInfo("VuiSceneManager", " updateScene to CarSpeech success" + sceneId + ",result:" + str);
                                return;
                            } catch (RemoteException e) {
                                e.printStackTrace();
                                LogUtils.e("VuiSceneManager", "updateScene " + e.fillInStackTrace());
                                if (sceneCache2 != null) {
                                    sceneCache2.setCache(sceneId, vuiScene.getElements());
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    int type = VuiSceneCacheFactory.CacheType.DEFAULT.getType();
                    List<VuiElement> list = null;
                    if (sceneCache2 != null) {
                        type = sceneCache2.getFusionType(sceneId);
                        if (type == VuiSceneCacheFactory.CacheType.UPDATE.getType()) {
                            list = sceneCache2.getUpdateFusionCache(sceneId, vuiScene.getElements(), false);
                        } else if (type == VuiSceneCacheFactory.CacheType.BUILD.getType() && sceneCache != null) {
                            list = sceneCache.getCache(sceneId);
                        }
                        if (list != null) {
                            vuiScene.setElements(list);
                        }
                    }
                    if (VuiSceneManager.this.isUploadScene(sceneId)) {
                        if (type == VuiSceneCacheFactory.CacheType.BUILD.getType()) {
                            VuiSceneManager.this.sendBuildCacheInOther(sceneId, vuiScene, sceneCache);
                            return;
                        }
                        String vuiSceneConvertToString2 = VuiUtils.vuiSceneConvertToString(vuiScene);
                        Uri.Builder builder2 = new Uri.Builder();
                        builder2.authority(VuiSceneManager.this.getAuthority()).path("updateScene").appendQueryParameter(VuiConstants.SCENE_ID, sceneId).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, vuiScene.getPackageName()).appendQueryParameter("packageVersion", vuiScene.getVersion()).appendQueryParameter("sceneData", vuiSceneConvertToString2);
                        try {
                            LogUtils.logDebug("VuiSceneManager", " updateScene to CarSpeech" + sceneId);
                            String str2 = (String) ApiRouter.route(builder2.build());
                            LogUtils.logInfo("VuiSceneManager", "updateScene to CarSpeech success" + sceneId + ",result:" + str2);
                            if (TextUtils.isEmpty(str2)) {
                                if (sceneCache2 != null) {
                                    sceneCache2.setCache(sceneId, vuiScene.getElements());
                                }
                            } else if (sceneCache2 != null) {
                                sceneCache2.removeCache(sceneId);
                            }
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            LogUtils.e("VuiSceneManager", "updateScene " + e2.fillInStackTrace());
                            if (sceneCache2 != null) {
                                sceneCache2.setCache(sceneId, vuiScene.getElements());
                            }
                        }
                    } else if (type == VuiSceneCacheFactory.CacheType.BUILD.getType() || sceneCache2 == null) {
                    } else {
                        sceneCache2.setCache(sceneId, vuiScene.getElements());
                    }
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x007f, code lost:
        if (isNeedBuild(r6) != false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e1 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String enterScene(final java.lang.String r6, final java.lang.String r7, boolean r8) {
        /*
            r5 = this;
            java.lang.String r0 = "VuiSceneManager"
            java.lang.String r1 = ""
            if (r6 == 0) goto Le2
            if (r7 != 0) goto La
            goto Le2
        La:
            boolean r2 = com.xiaopeng.speech.vui.utils.VuiUtils.canUseVuiFeature()     // Catch: java.lang.Exception -> Lbd
            if (r2 != 0) goto L11
            return r1
        L11:
            int r2 = r5.getVuiSceneState(r6)     // Catch: java.lang.Exception -> Lbd
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lbd
            r3.<init>()     // Catch: java.lang.Exception -> Lbd
            java.lang.String r4 = "enterScene: sceneState:"
            r3.append(r4)     // Catch: java.lang.Exception -> Lbd
            r3.append(r2)     // Catch: java.lang.Exception -> Lbd
            java.lang.String r4 = ",sceneId:"
            r3.append(r4)     // Catch: java.lang.Exception -> Lbd
            r3.append(r6)     // Catch: java.lang.Exception -> Lbd
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> Lbd
            com.xiaopeng.speech.vui.utils.LogUtils.logInfo(r0, r3)     // Catch: java.lang.Exception -> Lbd
            com.xiaopeng.speech.vui.model.VuiSceneState r3 = com.xiaopeng.speech.vui.model.VuiSceneState.INIT     // Catch: java.lang.Exception -> Lbd
            int r3 = r3.getState()     // Catch: java.lang.Exception -> Lbd
            r4 = 0
            if (r2 != r3) goto L49
            if (r8 == 0) goto L3f
            r5.cleanExpiredSceneTime(r6)     // Catch: java.lang.Exception -> Lbd
        L3f:
            com.xiaopeng.speech.vui.model.VuiSceneState r2 = com.xiaopeng.speech.vui.model.VuiSceneState.ACTIVE     // Catch: java.lang.Exception -> Lbd
            int r2 = r2.getState()     // Catch: java.lang.Exception -> Lbd
            r5.updateSceneState(r6, r2)     // Catch: java.lang.Exception -> Lbd
            goto L83
        L49:
            com.xiaopeng.speech.vui.model.VuiSceneState r3 = com.xiaopeng.speech.vui.model.VuiSceneState.UNACTIVE     // Catch: java.lang.Exception -> Lbd
            int r3 = r3.getState()     // Catch: java.lang.Exception -> Lbd
            if (r2 != r3) goto L65
            boolean r2 = r5.isNeedBuild(r6)     // Catch: java.lang.Exception -> Lbd
            if (r2 == 0) goto L58
            goto L59
        L58:
            r4 = r1
        L59:
            com.xiaopeng.speech.vui.model.VuiSceneState r2 = com.xiaopeng.speech.vui.model.VuiSceneState.ACTIVE     // Catch: java.lang.Exception -> L63
            int r2 = r2.getState()     // Catch: java.lang.Exception -> L63
            r5.updateSceneState(r6, r2)     // Catch: java.lang.Exception -> L63
            goto L83
        L63:
            r6 = move-exception
            goto Lbf
        L65:
            com.xiaopeng.speech.vui.model.VuiSceneState r3 = com.xiaopeng.speech.vui.model.VuiSceneState.IDLE     // Catch: java.lang.Exception -> Lbd
            int r3 = r3.getState()     // Catch: java.lang.Exception -> Lbd
            if (r2 != r3) goto L73
            java.lang.String r2 = "未注册场景信息，场景数据将不能使用"
            com.xiaopeng.speech.vui.utils.LogUtils.e(r0, r2)     // Catch: java.lang.Exception -> Lbd
            goto L82
        L73:
            com.xiaopeng.speech.vui.model.VuiSceneState r3 = com.xiaopeng.speech.vui.model.VuiSceneState.ACTIVE     // Catch: java.lang.Exception -> Lbd
            int r3 = r3.getState()     // Catch: java.lang.Exception -> Lbd
            if (r2 != r3) goto L82
            boolean r2 = r5.isNeedBuild(r6)     // Catch: java.lang.Exception -> Lbd
            if (r2 == 0) goto L82
            goto L83
        L82:
            r4 = r1
        L83:
            java.lang.String r2 = "com.xiaopeng.montecarlo"
            java.lang.String r3 = r5.mPackageName     // Catch: java.lang.Exception -> L63
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L63
            if (r2 == 0) goto La1
            java.lang.String r2 = r5.mPackageName     // Catch: java.lang.Exception -> L63
            java.lang.String r3 = r5.getTopRunningPackageName()     // Catch: java.lang.Exception -> L63
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L63
            if (r2 != 0) goto La1
            boolean r6 = com.xiaopeng.speech.vui.utils.VuiUtils.cannotUpload()     // Catch: java.lang.Exception -> L63
            if (r6 == 0) goto La0
            return r1
        La0:
            return r4
        La1:
            if (r8 == 0) goto Lda
            boolean r8 = r5.isUploadScene(r6)     // Catch: java.lang.Exception -> L63
            if (r8 == 0) goto Lb2
            boolean r8 = com.xiaopeng.speech.vui.utils.VuiUtils.cannotUpload()     // Catch: java.lang.Exception -> L63
            if (r8 != 0) goto Lb2
            r5.sendSceneData(r6)     // Catch: java.lang.Exception -> L63
        Lb2:
            android.os.Handler r8 = r5.mApiRouterHandler     // Catch: java.lang.Exception -> L63
            com.xiaopeng.speech.vui.VuiSceneManager$17 r2 = new com.xiaopeng.speech.vui.VuiSceneManager$17     // Catch: java.lang.Exception -> L63
            r2.<init>()     // Catch: java.lang.Exception -> L63
            r8.post(r2)     // Catch: java.lang.Exception -> L63
            goto Lda
        Lbd:
            r6 = move-exception
            r4 = r1
        Lbf:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "enterScene--------------e: "
            r7.append(r8)
            java.lang.Throwable r8 = r6.fillInStackTrace()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.xiaopeng.speech.vui.utils.LogUtils.e(r0, r7)
            r6.printStackTrace()
        Lda:
            boolean r6 = com.xiaopeng.speech.vui.utils.VuiUtils.cannotUpload()
            if (r6 == 0) goto Le1
            return r1
        Le1:
            return r4
        Le2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.speech.vui.VuiSceneManager.enterScene(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    private void updateSceneState(String str, int i) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            sceneInfo.setState(i);
        }
    }

    public void exitScene(final String str, final String str2, final boolean z) {
        if (str == null || str2 == null || !VuiUtils.canUseVuiFeature()) {
            return;
        }
        if (getVuiSceneState(str) == VuiSceneState.ACTIVE.getState()) {
            updateSceneState(str, VuiSceneState.UNACTIVE.getState());
            this.mApiRouterHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.18
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (z) {
                            Uri.Builder builder = new Uri.Builder();
                            builder.authority(VuiSceneManager.this.getAuthority()).path("exitScene").appendQueryParameter(VuiConstants.SCENE_ID, str).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, str2).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion);
                            LogUtils.logDebug("VuiSceneManager", "exitScene-------------- " + str);
                            ApiRouter.route(builder.build());
                            LogUtils.logDebug("VuiSceneManager", "exitScene---success---------- " + str);
                        }
                    } catch (Exception e) {
                        LogUtils.e("VuiSceneManager", "exitScene--e: " + e.fillInStackTrace());
                    }
                }
            });
            return;
        }
        LogUtils.e("VuiSceneManager", "场景未激活不能执行退出");
    }

    public void destroyScene(final String str) {
        Handler handler;
        if (str == null || (handler = this.mApiRouterHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.19
            @Override // java.lang.Runnable
            public void run() {
                VuiSceneBuildCache vuiSceneBuildCache = (VuiSceneBuildCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                if (vuiSceneBuildCache != null && vuiSceneBuildCache.getUploadedState(str) && !VuiUtils.cannotUpload()) {
                    try {
                        Uri.Builder builder = new Uri.Builder();
                        if (!VuiSceneManager.this.hasProcessFeature()) {
                            builder.authority(VuiSceneManager.this.getAuthority()).path("destroyScene").appendQueryParameter("sceneIds", str).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion);
                        } else {
                            builder.authority(VuiSceneManager.this.getAuthority()).path("destroyProcessScene").appendQueryParameter("sceneIds", str).appendQueryParameter(VuiConstants.SCENE_PACKAGE_NAME, VuiSceneManager.this.mPackageName).appendQueryParameter("packageVersion", VuiSceneManager.this.mPackageVersion).appendQueryParameter("processName", VuiSceneManager.this.getProcessName());
                        }
                        LogUtils.logDebug("VuiSceneManager", "destroyScene-------------- " + str);
                        ApiRouter.route(builder.build());
                        LogUtils.logDebug("VuiSceneManager", "destroyScene--------------success " + str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                LogUtils.logDebug("VuiSceneManager", "destory removeAllCache--------------" + str);
                VuiSceneCacheFactory.instance().removeAllCache(str);
            }
        });
    }

    public void cleanExpiredSceneTime(final String str) {
        Handler handler;
        if (str == null || (handler = this.mApiRouterHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiSceneManager.20
            @Override // java.lang.Runnable
            public void run() {
                Uri.Builder builder = new Uri.Builder();
                builder.authority(VuiSceneManager.this.getAuthority()).path("cleanExpiredSceneTime").appendQueryParameter(VuiConstants.SCENE_ID, str);
                LogUtils.logDebug("VuiSceneManager", "cleanExpiredSceneTime-------------- " + str);
                try {
                    ApiRouter.route(builder.build());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VuiSceneInfo getSceneInfo(String str) {
        ConcurrentHashMap<String, VuiSceneInfo> concurrentHashMap;
        if (str == null || (concurrentHashMap = this.mVuiSceneInfoMap) == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.mVuiSceneInfoMap.get(str);
    }

    public void setWholeSceneId(String str, String str2) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            sceneInfo.setWholeSceneId(str2);
            this.mVuiSceneInfoMap.put(str, sceneInfo);
        }
    }

    public void setIsWholeScene(String str, boolean z) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            sceneInfo.setWholeScene(z);
            this.mVuiSceneInfoMap.put(str, sceneInfo);
        }
    }

    public void addSubSceneIds(String str, List<String> list) {
        VuiSceneInfo vuiSceneInfo;
        if (this.mVuiSceneInfoMap.containsKey(str) && (vuiSceneInfo = this.mVuiSceneInfoMap.get(str)) != null) {
            List<String> subSceneList = vuiSceneInfo.getSubSceneList();
            if (subSceneList == null) {
                subSceneList = new ArrayList<>();
            }
            subSceneList.addAll(list);
            vuiSceneInfo.setSubSceneList(subSceneList);
            this.mVuiSceneInfoMap.put(str, vuiSceneInfo);
        }
    }

    public void removeSubSceneIds(String str, String str2) {
        VuiSceneInfo vuiSceneInfo;
        if (this.mVuiSceneInfoMap.containsKey(str) && (vuiSceneInfo = this.mVuiSceneInfoMap.get(str)) != null) {
            List<String> subSceneList = vuiSceneInfo.getSubSceneList();
            if (subSceneList == null) {
                subSceneList = new ArrayList<>();
            }
            if (subSceneList.contains(str2)) {
                subSceneList.remove(str2);
            }
            vuiSceneInfo.setSubSceneList(subSceneList);
            this.mVuiSceneInfoMap.put(str, vuiSceneInfo);
        }
    }

    public void setSceneIdList(String str, List<String> list) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            sceneInfo.setIdList(list);
            this.mVuiSceneInfoMap.put(str, sceneInfo);
        }
    }

    public List<String> getSceneIdList(String str) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            return sceneInfo.getIdList();
        }
        return null;
    }

    public void addVuiSceneListener(String str, View view, IVuiSceneListener iVuiSceneListener, IVuiElementChangedListener iVuiElementChangedListener, boolean z) {
        LogUtils.logInfo("VuiSceneManager", "addVuiSceneListener-- " + str + ",needBuild:" + z);
        if (VuiUtils.canUseVuiFeature()) {
            LogUtils.logInfo("VuiSceneManager", "sceneId-- " + str + ",listener:" + iVuiSceneListener);
            if (TextUtils.isEmpty(str) || iVuiSceneListener == null) {
                LogUtils.logInfo("VuiSceneManager", "sceneId-- " + str + ",listener:" + iVuiSceneListener);
                LogUtils.e("VuiSceneManager", "场景注册时所需变量不能为空");
            } else if (view == null && !VuiUtils.isThirdApp(this.mPackageName) && !str.endsWith("Dialog") && !str.endsWith("dialog")) {
                LogUtils.e("VuiSceneManager", "场景注册时所需变量不能为空");
            } else {
                if (z && (this.mVuiSceneInfoMap.containsKey(str) || this.sceneIds.contains(str))) {
                    if (iVuiSceneListener != null && iVuiSceneListener.equals(getVuiSceneListener(str))) {
                        LogUtils.w("VuiSceneManager", "上次场景撤销未调用removeVuiSceneListener或重复创建场景");
                    }
                    VuiSceneCacheFactory.instance().removeAllCache(str);
                }
                VuiSceneInfo vuiSceneInfo = new VuiSceneInfo();
                boolean z2 = true;
                if (this.mVuiSubSceneInfoMap.containsKey(str)) {
                    vuiSceneInfo = this.mVuiSubSceneInfoMap.get(str);
                    this.mVuiSubSceneInfoMap.remove(str);
                } else {
                    if (this.mVuiSceneInfoMap.containsKey(str)) {
                        vuiSceneInfo = this.mVuiSceneInfoMap.get(str);
                        if (z) {
                            vuiSceneInfo.reset(true);
                        }
                    }
                    z2 = false;
                }
                vuiSceneInfo.setListener(iVuiSceneListener);
                vuiSceneInfo.setRootView(view);
                vuiSceneInfo.setElementChangedListener(iVuiElementChangedListener);
                if (z) {
                    vuiSceneInfo.setState(VuiSceneState.INIT.getState());
                } else if (vuiSceneInfo.isBuildComplete()) {
                    vuiSceneInfo.setState(VuiSceneState.UNACTIVE.getState());
                } else {
                    vuiSceneInfo.reset(false);
                    VuiSceneCacheFactory.instance().removeAllCache(str);
                }
                LogUtils.logDebug("VuiSceneManager", "build:" + vuiSceneInfo.isBuild());
                this.mVuiSceneInfoMap.put(str, vuiSceneInfo);
                if (iVuiSceneListener != null && z2) {
                    LogUtils.i("VuiSceneManager", "onBuildScene");
                    iVuiSceneListener.onBuildScene();
                }
                if (this.sceneIds.contains(str)) {
                    return;
                }
                this.sceneIds.add(str);
            }
        }
    }

    public void initSubSceneInfo(String str, String str2) {
        LogUtils.d("VuiSceneManager", "initSubSceneInfo subSceneId:" + str + ",sceneId:" + str2);
        VuiSceneInfo vuiSceneInfo = new VuiSceneInfo();
        if (this.mVuiSubSceneInfoMap.containsKey(str)) {
            vuiSceneInfo = this.mVuiSubSceneInfoMap.get(str);
        }
        vuiSceneInfo.setWholeScene(false);
        vuiSceneInfo.setWholeSceneId(str2);
        this.mVuiSubSceneInfoMap.put(str, vuiSceneInfo);
    }

    public void removeVuiSceneListener(String str, boolean z, boolean z2, IVuiSceneListener iVuiSceneListener) {
        if (VuiUtils.canUseVuiFeature()) {
            if (str == null) {
                LogUtils.e("VuiSceneManager", "销毁场景时SceneId不能为空");
                return;
            }
            if (!this.mVuiSceneInfoMap.containsKey(str) || !this.sceneIds.contains(str)) {
                LogUtils.w("VuiSceneManager", "销毁场景前请先注册场景，重复销毁信息");
            }
            if (this.mVuiSceneInfoMap.containsKey(str)) {
                VuiSceneInfo vuiSceneInfo = this.mVuiSceneInfoMap.get(str);
                if (iVuiSceneListener != null && vuiSceneInfo.getListener() != null && !iVuiSceneListener.equals(vuiSceneInfo.getListener())) {
                    LogUtils.w("VuiSceneManager", "要销毁的场景和目前持有的场景数据不一致");
                    return;
                } else if (z2) {
                    LogUtils.logInfo("VuiSceneManager", "removeVuiSceneListener-------------- " + z2 + ",info:" + vuiSceneInfo);
                    vuiSceneInfo.resetViewInfo();
                    this.mVuiSceneInfoMap.put(str, vuiSceneInfo);
                } else {
                    List<String> subSceneList = vuiSceneInfo.getSubSceneList();
                    if (subSceneList != null) {
                        for (String str2 : subSceneList) {
                            VuiSceneInfo vuiSceneInfo2 = this.mVuiSceneInfoMap.get(str2);
                            if (vuiSceneInfo2 != null && vuiSceneInfo2.getWholeSceneId() != null && vuiSceneInfo2.getWholeSceneId().contains(str)) {
                                vuiSceneInfo2.getWholeSceneId().remove(str);
                                this.mVuiSceneInfoMap.put(str2, vuiSceneInfo2);
                            }
                        }
                    }
                    vuiSceneInfo.reset(true);
                    this.mVuiSceneInfoMap.remove(str);
                    if (this.sceneIds.contains(str)) {
                        this.sceneIds.remove(str);
                    }
                }
            }
            if (z2) {
                return;
            }
            if (z) {
                destroyScene(str);
            } else {
                VuiSceneCacheFactory.instance().removeAllCache(str);
            }
        }
    }

    public IVuiSceneListener getVuiSceneListener(String str) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            return sceneInfo.getListener();
        }
        return null;
    }

    public View getRootView(String str) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            return sceneInfo.getRootView();
        }
        return null;
    }

    public void setmPackageName(String str) {
        this.mPackageName = str;
    }

    public void setmPackageVersion(String str) {
        this.mPackageVersion = str;
    }

    public String getmPackageName() {
        return this.mPackageName;
    }

    public String getmPackageVersion() {
        return this.mPackageVersion;
    }

    public boolean getVuiSceneBuild(String str) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            return sceneInfo.isBuild();
        }
        return false;
    }

    public int getVuiSceneState(String str) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            return sceneInfo.getState();
        }
        return VuiSceneState.IDLE.getState();
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    private String getTopRunningPackageName() {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks == null || runningTasks.size() <= 0) {
            return null;
        }
        return runningTasks.get(0).topActivity.getPackageName();
    }

    public String checkScrollSubViewIsVisible(String str, String str2) {
        if (str == null || str2 == null || VuiUtils.cannotUpload()) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            JSONArray optJSONArray = jSONObject.optJSONArray(VuiConstants.SCENE_ELEMENTS);
            if (optJSONArray != null || optJSONArray.length() > 0) {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = null;
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("elementId");
                        String optString2 = optJSONObject.optString("scrollViewId");
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("elementId", optString);
                        VuiEventInfo findView = findView(str, optString);
                        VuiEventInfo findView2 = findView(str, optString2);
                        if (findView != null && findView.hitView != null) {
                            if (findView2 != null && findView2.hitView != null) {
                                if (findView2.hitView instanceof ScrollView) {
                                    Rect rect = new Rect();
                                    findView2.hitView.getHitRect(rect);
                                    if (findView.hitView.getLocalVisibleRect(rect)) {
                                        jSONObject3.put("visible", true);
                                    } else {
                                        jSONObject3.put("visible", false);
                                    }
                                }
                            } else {
                                jSONObject3.put("visible", true);
                            }
                        }
                        jSONObject2 = jSONObject3;
                    }
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put(VuiConstants.SCENE_ELEMENTS, jSONArray);
                return String.valueOf(jSONObject);
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getElementState(String str, String str2) {
        VuiElement vuiElementById;
        ViewPager viewPager;
        JSONObject vuiProps;
        if (str == null || str2 == null) {
            return null;
        }
        if (VuiUtils.cannotUpload() || (vuiElementById = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType()).getVuiElementById(str, str2)) == null) {
            return null;
        }
        VuiEventInfo findView = !VuiUtils.isThirdApp(VuiUtils.getPackageNameFromSceneId(str)) ? findView(str, str2) : null;
        String str3 = "VuiSceneManager";
        if (VuiElementType.RECYCLEVIEW.getType().equals(vuiElementById.getType())) {
            if (findView != null && findView.hitView != null && (findView.hitView instanceof RecyclerView)) {
                RecyclerView recyclerView = (RecyclerView) findView.hitView;
                if ((recyclerView instanceof IVuiElement) && (vuiProps = ((IVuiElement) recyclerView).getVuiProps()) != null && vuiProps.has(VuiConstants.PROPS_DISABLETPL)) {
                    try {
                        if (vuiProps.getBoolean(VuiConstants.PROPS_DISABLETPL)) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(VuiConstants.PROPS_SCROLLUP, true);
                            jSONObject.put(VuiConstants.PROPS_SCROLLDOWN, true);
                            return jSONObject.toString();
                        }
                    } catch (Exception unused) {
                    }
                }
                boolean canScrollVertically = recyclerView.canScrollVertically(-1);
                boolean canScrollVertically2 = recyclerView.canScrollVertically(1);
                boolean canScrollHorizontally = recyclerView.canScrollHorizontally(-1);
                boolean canScrollHorizontally2 = recyclerView.canScrollHorizontally(1);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        if (((IVuiElement) recyclerView).getVuiAction().equals(VuiAction.SCROLLBYY.getName())) {
                            jSONObject2.put(VuiConstants.PROPS_SCROLLUP, canScrollVertically);
                            jSONObject2.put(VuiConstants.PROPS_SCROLLDOWN, canScrollVertically2);
                        } else {
                            jSONObject2.put(VuiConstants.PROPS_SCROLLLEFT, canScrollHorizontally);
                            jSONObject2.put(VuiConstants.PROPS_SCROLLRIGHT, canScrollHorizontally2);
                        }
                        str3 = "VuiSceneManager";
                        LogUtils.logInfo(str3, "getElementState jsonObject: " + jSONObject2.toString() + ",sceneId:" + str + ",elementId:" + str2);
                        return jSONObject2.toString();
                    } catch (JSONException e) {
                        e = e;
                        str3 = "VuiSceneManager";
                        LogUtils.e(str3, "getElementState e:" + e.getMessage());
                        return null;
                    }
                } catch (JSONException e2) {
                    e = e2;
                }
            } else if (vuiElementById.getProps() != null) {
                return vuiElementById.getProps().toString();
            } else {
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(VuiConstants.PROPS_SCROLLUP, true);
                    jSONObject3.put(VuiConstants.PROPS_SCROLLDOWN, true);
                    LogUtils.logInfo("VuiSceneManager", "getElementState jsonObject: " + jSONObject3.toString() + ",sceneId:" + str + ",elementId:" + str2);
                    return jSONObject3.toString();
                } catch (JSONException e3) {
                    LogUtils.e("VuiSceneManager", "getElementState e:" + e3.getMessage());
                    return null;
                }
            }
        } else if (VuiElementType.VIEWPAGER.getType().equals(vuiElementById.getType())) {
            if (VuiUtils.getExtraPage(vuiElementById) != -1) {
                try {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(VuiConstants.PROPS_SCROLLLEFT, true);
                    jSONObject4.put(VuiConstants.PROPS_SCROLLRIGHT, true);
                    LogUtils.logInfo("VuiSceneManager", "getElementState jsonObject: " + jSONObject4.toString() + ",sceneId:" + str + ",elementId:" + str2);
                    return jSONObject4.toString();
                } catch (JSONException e4) {
                    LogUtils.e("VuiSceneManager", "getElementState e:" + e4.getMessage());
                    return null;
                }
            } else if (findView == null || findView.hitView == null) {
                return null;
            } else {
                if (!(findView.hitView instanceof ViewPager)) {
                    viewPager = VuiUtils.findViewPager(findView.hitView);
                } else {
                    viewPager = (ViewPager) findView.hitView;
                }
                if (viewPager != null) {
                    try {
                        boolean canScrollHorizontally3 = viewPager.canScrollHorizontally(-1);
                        boolean canScrollHorizontally4 = viewPager.canScrollHorizontally(1);
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put(VuiConstants.PROPS_SCROLLLEFT, canScrollHorizontally3);
                        jSONObject5.put(VuiConstants.PROPS_SCROLLRIGHT, canScrollHorizontally4);
                        LogUtils.logInfo("VuiSceneManager", "getElementState jsonObject: " + jSONObject5.toString() + ",sceneId:" + str + ",elementId:" + str2);
                        return jSONObject5.toString();
                    } catch (JSONException e5) {
                        LogUtils.e("VuiSceneManager", "getElementState e:" + e5.getMessage());
                        return null;
                    }
                }
                return null;
            }
        } else {
            boolean z = false;
            if (VuiElementType.SCROLLVIEW.getType().equals(vuiElementById.getType())) {
                if (vuiElementById == null || vuiElementById.getActions() == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(vuiElementById.actions.entrySet());
                if (arrayList.isEmpty()) {
                    return null;
                }
                if (VuiAction.SCROLLBYY.getName().equals(((Map.Entry) arrayList.get(0)).getKey())) {
                    if (findView == null || findView.hitView == null) {
                        return null;
                    }
                    if (findView.hitView instanceof ScrollView) {
                        View childAt = ((ViewGroup) findView.hitView).getChildAt(0);
                        if (childAt == null) {
                            return null;
                        }
                        try {
                            JSONObject jSONObject6 = new JSONObject();
                            int scrollY = findView.hitView.getScrollY();
                            jSONObject6.put(VuiConstants.PROPS_SCROLLUP, scrollY != 0);
                            if (scrollY + findView.hitView.getHeight() != childAt.getMeasuredHeight()) {
                                z = true;
                            }
                            jSONObject6.put(VuiConstants.PROPS_SCROLLDOWN, z);
                            LogUtils.logInfo("VuiSceneManager", "getElementState jsonObject: " + jSONObject6.toString() + ",sceneId:" + str + ",elementId:" + str2);
                            return jSONObject6.toString();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            LogUtils.e("VuiSceneManager", "getElementState e:" + e6.getMessage());
                            return null;
                        }
                    }
                    Rect rect = new Rect();
                    findView.hitView.getGlobalVisibleRect(rect);
                    try {
                        JSONObject jSONObject7 = new JSONObject();
                        int scrollY2 = findView.hitView.getScrollY();
                        jSONObject7.put(VuiConstants.PROPS_SCROLLUP, scrollY2 != 0);
                        if (scrollY2 + rect.height() < findView.hitView.getMeasuredHeight()) {
                            z = true;
                        }
                        jSONObject7.put(VuiConstants.PROPS_SCROLLDOWN, z);
                        LogUtils.logInfo("VuiSceneManager", "getElementState jsonObject: " + jSONObject7.toString() + ",sceneId:" + str + ",elementId:" + str2);
                        return jSONObject7.toString();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                        LogUtils.e("VuiSceneManager", "getElementState e:" + e7.getMessage());
                        return null;
                    }
                } else if (!VuiAction.SCROLLBYX.getName().equals(((Map.Entry) arrayList.get(0)).getKey()) || findView == null || findView.hitView == null || (findView.hitView instanceof ScrollView)) {
                    return null;
                } else {
                    View view = (View) findView.hitView.getParent();
                    if (view.getWidth() < findView.hitView.getWidth()) {
                        try {
                            JSONObject jSONObject8 = new JSONObject();
                            int scrollX = view.getScrollX();
                            LogUtils.e("VuiSceneManager", "view width:" + findView.hitView.getWidth() + ",parent:" + view.getWidth() + ",scrollX:" + scrollX);
                            jSONObject8.put(VuiConstants.PROPS_SCROLLLEFT, scrollX != 0);
                            if (scrollX + view.getWidth() < findView.hitView.getWidth()) {
                                z = true;
                            }
                            jSONObject8.put(VuiConstants.PROPS_SCROLLRIGHT, z);
                            LogUtils.logInfo("VuiSceneManager", "getElementState jsonObject: " + jSONObject8.toString() + ",sceneId:" + str + ",elementId:" + str2);
                            return jSONObject8.toString();
                        } catch (Exception e8) {
                            e8.printStackTrace();
                            LogUtils.e("VuiSceneManager", "getElementState e:" + e8.getMessage());
                            return null;
                        }
                    }
                    return null;
                }
            }
            if (findView != null && findView.hitView != null) {
                vuiElementById.setEnabled(findView.hitView.isEnabled() ? null : false);
            }
            String json = new Gson().toJson(vuiElementById);
            LogUtils.logInfo("VuiSceneManager", "getElementState:  result:  " + json);
            return json;
        }
    }

    public VuiEventInfo findView(String str, String str2) {
        View hitView;
        if (str != null && str2 != null) {
            try {
                VuiEventInfo findViewFromSceneInfo = findViewFromSceneInfo(str, str2);
                if (findViewFromSceneInfo != null) {
                    LogUtils.logDebug("VuiSceneManager", "findViewFromSceneInfo elementId:" + str2 + ",view:" + findViewFromSceneInfo.hitView + ",sceneId:" + findViewFromSceneInfo.sceneId);
                    return findViewFromSceneInfo;
                }
                VuiEventInfo findRootView = findRootView(str, str2);
                StringBuilder sb = new StringBuilder();
                sb.append("findView elementId:");
                sb.append(str2);
                sb.append(",rootView:");
                sb.append(findRootView != null ? findRootView.hitView : null);
                sb.append(",sceneId:");
                sb.append(findRootView != null ? findRootView.sceneId : "");
                LogUtils.logDebug("VuiSceneManager", sb.toString());
                if (findRootView != null && findRootView.hitView != null) {
                    return new VuiEventInfo(getHitView(findRootView.hitView, str2), findRootView.sceneId);
                }
                VuiSceneInfo sceneInfo = getSceneInfo(str);
                LogUtils.logInfo("VuiSceneManager", "findView view by rootview");
                View rootView = sceneInfo == null ? null : sceneInfo.getRootView();
                if (rootView != null) {
                    View hitView2 = getHitView(rootView, str2);
                    if (hitView2 == null) {
                        List<String> subSceneList = sceneInfo.getSubSceneList();
                        int size = subSceneList == null ? 0 : subSceneList.size();
                        for (int i = 0; i < size; i++) {
                            String str3 = subSceneList.get(i);
                            VuiSceneInfo sceneInfo2 = TextUtils.isEmpty(str3) ? null : getSceneInfo(str3);
                            View rootView2 = sceneInfo2 == null ? null : sceneInfo2.getRootView();
                            if (rootView2 != null && (hitView = getHitView(rootView2, str2)) != null) {
                                return new VuiEventInfo(hitView, str3);
                            }
                        }
                        return findViewFromSceneInfo;
                    }
                    return new VuiEventInfo(hitView2, str);
                }
                return findViewFromSceneInfo;
            } catch (Exception e) {
                LogUtils.e("VuiSceneManager", "findView e:" + e.getMessage());
            }
        }
        return null;
    }

    private View getHitView(View view, String str) {
        if (view != null) {
            View findViewWithTag = view.findViewWithTag(str);
            if (findViewWithTag == null) {
                View findViewWithId = findViewWithId(str, view);
                if (findViewWithId != null) {
                    LogUtils.logDebug("VuiSceneManager", "findViewWithId:   Tag====  " + findViewWithId.getTag());
                    return findViewWithId;
                }
                LogUtils.e("VuiSceneManager", "findViewWithId  View is null");
                return findViewWithId;
            }
            return findViewWithTag;
        }
        return null;
    }

    private VuiEventInfo findViewFromSceneInfo(String str, String str2) {
        VuiSceneInfo sceneInfo;
        List<SoftReference<View>> notChildrenViewList;
        if (str != null && str2 != null && (sceneInfo = getSceneInfo(str)) != null && sceneInfo.isContainNotChildrenView() && (notChildrenViewList = sceneInfo.getNotChildrenViewList()) != null) {
            for (int i = 0; i < notChildrenViewList.size(); i++) {
                SoftReference<View> softReference = notChildrenViewList.get(i);
                if (softReference != null && softReference.get() != null) {
                    View findViewWithTag = softReference.get().findViewWithTag(str2);
                    if (findViewWithTag != null) {
                        return new VuiEventInfo(findViewWithTag, str);
                    }
                    View findViewWithId = findViewWithId(str2, softReference.get());
                    if (findViewWithId != null) {
                        LogUtils.logDebug("VuiSceneManager", "findViewWithId:   Tag====  " + findViewWithId.getTag());
                        return new VuiEventInfo(findViewWithId, str);
                    }
                }
            }
        }
        return null;
    }

    private VuiEventInfo findRootView(String str, String str2) {
        VuiSceneInfo sceneInfo;
        VuiEventInfo vuiEventInfo = null;
        if (str == null || str2 == null || (sceneInfo = getSceneInfo(str)) == null) {
            return null;
        }
        LogUtils.logDebug("VuiSceneManager", "findRootView idList:" + sceneInfo.getIdList());
        if (sceneInfo.getIdList() != null && sceneInfo.getIdList().contains(str2)) {
            return new VuiEventInfo(getRootView(str), str);
        }
        List<String> subSceneList = sceneInfo.getSubSceneList();
        if (subSceneList != null) {
            LogUtils.logDebug("VuiSceneManager", "findRootView subSceneList:" + subSceneList);
        }
        if (subSceneList != null) {
            int size = subSceneList.size();
            for (int i = 0; i < size; i++) {
                vuiEventInfo = findRootView(subSceneList.get(i), str2);
                if (vuiEventInfo != null) {
                    return vuiEventInfo;
                }
            }
            return vuiEventInfo;
        }
        return null;
    }

    public View findViewWithId(String str, View view) {
        String substring;
        LogUtils.logInfo("VuiSceneManager", "findViewWithId  ===  " + str);
        if (view == null || str == null) {
            return view;
        }
        if (str.indexOf(DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT) != -1) {
            String substring2 = str.substring(0, str.indexOf(DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT));
            if (TextUtils.isEmpty(substring2)) {
                return null;
            }
            if (substring2.length() > 4) {
                String[] split = str.split(DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT);
                if (split.length <= 2) {
                    substring = split[1];
                } else {
                    substring = str.substring(str.indexOf(DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT, 1) + 1, str.indexOf(DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT, str.indexOf(DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT) + 1));
                }
                if (substring.length() < 4) {
                    int id = ResourceUtil.getId(this.mContext, substring2);
                    LogUtils.logInfo("VuiSceneManager", "findViewWithId view tag: " + view.findViewById(id).getTag());
                    View listView = getListView(view.findViewById(id));
                    if (listView == null) {
                        return null;
                    }
                    if (listView instanceof RecyclerView) {
                        view = ((RecyclerView) listView).getLayoutManager().findViewByPosition(Integer.valueOf(substring).intValue()).findViewById(id);
                    }
                    return split.length <= 2 ? view : findViewWithId(str.substring(str.indexOf(DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT, str.indexOf(DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT) + 1) + 1), view);
                }
                return findViewWithId(str.substring(str.indexOf(DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT) + 1), view.findViewById(ResourceUtil.getId(this.mContext, substring2)));
            }
            return findViewWithId(str.substring(str.indexOf(DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT) + 1), view);
        }
        return view.findViewById(ResourceUtil.getId(this.mContext, str));
    }

    private View getListView(View view) {
        if (view == null || (view instanceof ListView) || (view instanceof RecyclerView)) {
            return view;
        }
        if (view.getParent() == null) {
            return null;
        }
        return view.getParent() instanceof ViewRootImpl ? view : getListView((View) view.getParent());
    }

    private View getScrollView(View view) {
        if (view == null || (view instanceof ListView) || (view instanceof ScrollView)) {
            return view;
        }
        if (view.getParent() == null) {
            return null;
        }
        return view.getParent() instanceof ViewRootImpl ? view : getScrollView((View) view.getParent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isUploadScene(String str) {
        LogUtils.logDebug("VuiSceneManager", "isUploadScene sceneId:" + str + ",getTopRunningPackageName:" + getTopRunningPackageName() + ",mIsInSpeech:" + this.mIsInSpeech + ",VuiEngine.mActiveSceneId:" + VuiEngineImpl.mActiveSceneId + ",mPackageName" + this.mPackageName);
        String str2 = this.mPackageName;
        if (str2 == null || str == null) {
            return false;
        }
        if ("com.android.systemui".equals(str2)) {
            return true;
        }
        if (this.mIsInSpeech && str.equals(VuiEngineImpl.mActiveSceneId) && (VuiConstants.SETTINS.equals(this.mPackageName) || "com.xiaopeng.carcontrol".equals(this.mPackageName) || "com.xiaopeng.chargecontrol".equals(this.mPackageName))) {
            return true;
        }
        return this.mIsInSpeech && this.mPackageName.equals(getTopRunningPackageName()) && str.equals(VuiEngineImpl.mActiveSceneId);
    }

    public boolean canUpdateScene(String str) {
        if (str == null) {
            return false;
        }
        if (!getVuiSceneBuild(str)) {
            LogUtils.logDebug("VuiSceneManager", str + "场景数据的update必须在场build后");
            return false;
        } else if (getVuiSceneState(str) == VuiSceneState.IDLE.getState()) {
            LogUtils.logDebug("VuiSceneManager", str + "场景数据的build必须在场景被激活后");
            return false;
        } else {
            return true;
        }
    }

    private boolean isNeedBuild(String str) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo != null) {
            return !sceneInfo.isBuild();
        }
        return true;
    }

    public boolean canRunUpdateSceneTask(String str) {
        List<VuiElement> cache;
        if (str == null || (cache = ((VuiSceneBuildCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType())).getCache(str)) == null || cache.isEmpty()) {
            return false;
        }
        if (getVuiSceneState(str) == VuiSceneState.IDLE.getState()) {
            LogUtils.logDebug("VuiSceneManager", str + "场景数据的build必须在场景被激活后");
            return false;
        }
        return true;
    }

    public void addVuiEventListener(String str, IVuiEventListener iVuiEventListener) {
        VuiSceneInfo sceneInfo;
        LogUtils.logInfo("VuiSceneManager", "addVuiEventListener-- " + str);
        if (!VuiUtils.canUseVuiFeature() || str == null || iVuiEventListener == null || (sceneInfo = getSceneInfo(str)) == null) {
            return;
        }
        sceneInfo.setEventListener(iVuiEventListener);
    }

    public IVuiEventListener getVuiEventListener(String str) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo == null) {
            return null;
        }
        return sceneInfo.getEventListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendBuildCacheInOther(String str, VuiScene vuiScene, VuiSceneCache vuiSceneCache) {
        VuiSceneInfo sceneInfo = getSceneInfo(str);
        if (sceneInfo == null || !sceneInfo.isBuildComplete()) {
            return;
        }
        buildScene(vuiScene, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAuthority() {
        return !Utils.isXpDevice() ? VuiConstants.VUI_SCENE_THIRD_AUTHORITY : VuiConstants.VUI_SCENE_AUTHORITY;
    }
}
