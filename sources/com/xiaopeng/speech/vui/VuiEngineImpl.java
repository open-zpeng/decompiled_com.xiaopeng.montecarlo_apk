package com.xiaopeng.speech.vui;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.internal.policy.DecorView;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import com.xiaopeng.speech.vui.cache.VuiSceneBuildCache;
import com.xiaopeng.speech.vui.cache.VuiSceneCache;
import com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory;
import com.xiaopeng.speech.vui.constants.Foo;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.speech.vui.listener.IVuiEventListener;
import com.xiaopeng.speech.vui.model.VuiFeedback;
import com.xiaopeng.speech.vui.model.VuiScene;
import com.xiaopeng.speech.vui.model.VuiSceneInfo;
import com.xiaopeng.speech.vui.model.VuiSceneState;
import com.xiaopeng.speech.vui.task.TaskDispatcher;
import com.xiaopeng.speech.vui.task.TaskWrapper;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import com.xiaopeng.speech.vui.vuiengine.BuildConfig;
import com.xiaopeng.speech.vui.vuiengine.R;
import com.xiaopeng.vui.commons.IVuiElement;
import com.xiaopeng.vui.commons.IVuiElementChangedListener;
import com.xiaopeng.vui.commons.IVuiElementListener;
import com.xiaopeng.vui.commons.IVuiSceneListener;
import com.xiaopeng.vui.commons.VuiPriority;
import com.xiaopeng.vui.commons.model.VuiElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class VuiEngineImpl {
    private static final String TAG = "VuiEngine";
    public static String mActiveSceneId;
    public static String mSceneIdPrefix;
    private EventDispatcher eventDispatcher;
    private Context mContext;
    private Handler mDispatherHandler;
    private HandlerThread mDispatherThread;
    private Handler mHandler;
    private String mPackageName;
    private String mPackageVersion;
    private Resources mResources;
    private HandlerThread mThread;
    private TaskDispatcher taskStructure;
    private List<String> mainThreadSceneList = Arrays.asList("MainMusicConcentration");
    private Handler mMainHandler = new Handler(Looper.getMainLooper());
    private List<String> mEnterSceneIds = Collections.synchronizedList(new ArrayList());
    private Handler mainHandler = new Handler(Looper.getMainLooper());
    private List<String> mEnterSceneStack = new ArrayList();
    private UpdateElementAttrRun mUpdateElementAttrRun = null;
    private UpdateSceneRun mUpdateSceneRun = null;

    public VuiEngineImpl(Context context, boolean z) {
        if (VuiUtils.canUseVuiFeature()) {
            LogUtils.logInfo(TAG, BuildConfig.BUILD_VERSION);
            this.mContext = context;
            Foo.setContext(this.mContext);
            lazyInitThread();
            this.mResources = this.mContext.getResources();
            this.mPackageName = context.getApplicationInfo().packageName;
            VuiSceneManager.instance().setmPackageName(this.mPackageName);
            VuiSceneManager.instance().setContext(this.mContext);
            this.eventDispatcher = new EventDispatcher(this.mContext, z);
            this.taskStructure = new TaskDispatcher();
            try {
                this.mPackageVersion = context.getPackageManager().getPackageInfo(this.mPackageName, 0).versionName;
                VuiSceneManager.instance().setmPackageVersion(this.mPackageVersion);
                mSceneIdPrefix = this.mPackageName + "-" + this.mPackageVersion;
            } catch (Exception e) {
                e.printStackTrace();
                LogUtils.e(TAG, "VuiEngine init e:" + e.getMessage());
            }
        }
    }

    private void lazyInitThread() {
        if (this.mThread == null) {
            this.mThread = new HandlerThread("VuiEngine-Thread");
            this.mThread.start();
            this.mHandler = new Handler(this.mThread.getLooper());
        }
        if (this.mDispatherThread == null) {
            this.mDispatherThread = new HandlerThread("VuiEngine-Disptcher-Thread");
            this.mDispatherThread.start();
            this.mDispatherHandler = new Handler(this.mDispatherThread.getLooper());
        }
    }

    public void enterScene(final String str, final boolean z) {
        Handler handler;
        if (!VuiUtils.canUseVuiFeature() || str == null || (handler = this.mHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                    int vuiSceneState = VuiSceneManager.instance().getVuiSceneState(sceneUnqiueId);
                    if (vuiSceneState == VuiSceneState.IDLE.getState()) {
                        LogUtils.e(VuiEngineImpl.TAG, str + "场景的进入必须在场景被激活后");
                    } else if (!sceneUnqiueId.equals(VuiEngineImpl.mActiveSceneId)) {
                        LogUtils.logDebug(VuiEngineImpl.TAG, "enterScene:" + str + ",mEnterSceneStack:" + VuiEngineImpl.this.mEnterSceneStack);
                        if (z) {
                            if (VuiEngineImpl.this.mEnterSceneStack.contains(sceneUnqiueId)) {
                                VuiEngineImpl.this.mEnterSceneStack.remove(sceneUnqiueId);
                            }
                            IVuiSceneListener vuiSceneListener = VuiSceneManager.instance().getVuiSceneListener(sceneUnqiueId);
                            Context context = VuiEngineImpl.this.getContext(sceneUnqiueId);
                            LogUtils.logDebug(VuiEngineImpl.TAG, "enterScene context:" + context);
                            boolean z2 = false;
                            if (!(vuiSceneListener instanceof Dialog) && !str.endsWith("Dialog") && !str.endsWith("dialog") && (vuiSceneState != VuiSceneState.INIT.getState() || !"com.xiaopeng.musicradio".equals(VuiEngineImpl.this.mPackageName))) {
                                for (int i = 0; i < VuiEngineImpl.this.mEnterSceneStack.size(); i++) {
                                    String str2 = (String) VuiEngineImpl.this.mEnterSceneStack.get(i);
                                    IVuiSceneListener vuiSceneListener2 = VuiSceneManager.instance().getVuiSceneListener(str2);
                                    if (!TextUtils.isEmpty(str2) && (str2.endsWith("Dialog") || str2.endsWith("dialog"))) {
                                        VuiEngineImpl.this.mEnterSceneStack.add(i, sceneUnqiueId);
                                        break;
                                    }
                                    if (vuiSceneListener2 instanceof Dialog) {
                                        Context context2 = VuiEngineImpl.this.getContext(str2);
                                        LogUtils.logDebug(VuiEngineImpl.TAG, "enterScene stackContext:" + context2);
                                        if (context2 != null && (context2.equals(context) || ((context instanceof Activity) && ((context2 instanceof Service) || (context2 instanceof Application))))) {
                                            LogUtils.logInfo(VuiEngineImpl.TAG, "enterScene has same context:" + i);
                                            VuiEngineImpl.this.mEnterSceneStack.add(i, sceneUnqiueId);
                                            break;
                                        }
                                    }
                                }
                            }
                            z2 = true;
                            if (z2) {
                                VuiEngineImpl.mActiveSceneId = sceneUnqiueId;
                                VuiEngineImpl.this.mEnterSceneStack.add(sceneUnqiueId);
                                VuiEngineImpl.this.handlerEnterScene(sceneUnqiueId, VuiSceneManager.instance().enterScene(sceneUnqiueId, VuiEngineImpl.this.mPackageName, z));
                            }
                            LogUtils.logDebug(VuiEngineImpl.TAG, "enterScene:" + str + ",mEnterSceneStack:" + VuiEngineImpl.this.mEnterSceneStack);
                            return;
                        }
                        VuiEngineImpl.this.handlerEnterScene(sceneUnqiueId, VuiSceneManager.instance().enterScene(sceneUnqiueId, VuiEngineImpl.this.mPackageName, z));
                    }
                } catch (Exception e) {
                    LogUtils.e(VuiEngineImpl.TAG, e.fillInStackTrace());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerEnterScene(String str, String str2) {
        final IVuiSceneListener vuiSceneListener;
        if (VuiUtils.cannotUpload() || (vuiSceneListener = VuiSceneManager.instance().getVuiSceneListener(str)) == null) {
            return;
        }
        if (str2 == null) {
            vuiSceneListener.onBuildScene();
        } else {
            this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    vuiSceneListener.onVuiStateChanged();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext(String str) {
        View rootView = VuiSceneManager.instance().getRootView(str);
        if (rootView != null) {
            Context context = rootView != null ? rootView.getContext() : null;
            if (rootView instanceof DecorView) {
                return context;
            }
            if (context != null && (context instanceof ContextWrapper)) {
                context = getDialogOwnContext(context);
            }
            if (context != null && (context instanceof Application) && !"com.xiaopeng.musicradio".equals(this.mPackageName)) {
                View findViewById = rootView != null ? rootView.findViewById(16908290) : null;
                if (findViewById != null && (findViewById instanceof ViewGroup)) {
                    return getDialogOwnContext(((ViewGroup) findViewById).getChildAt(0).getContext());
                }
            }
            return context;
        }
        return null;
    }

    private Context getDialogOwnContext(Context context) {
        if ((context instanceof Activity) || (context instanceof Service) || (context instanceof Application)) {
            return context;
        }
        if (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return getDialogOwnContext(context);
    }

    public String getSceneUnqiueId(String str) {
        return mSceneIdPrefix + "-" + str;
    }

    public void exitDupScene(String str, boolean z, IVuiSceneListener iVuiSceneListener) {
        if (iVuiSceneListener == null || TextUtils.isEmpty(str)) {
            return;
        }
        exitScene(iVuiSceneListener.toString() + "-" + str, z);
    }

    public void enterDupScene(String str, boolean z, IVuiSceneListener iVuiSceneListener) {
        if (iVuiSceneListener == null || TextUtils.isEmpty(str)) {
            return;
        }
        enterScene(iVuiSceneListener.toString() + "-" + str, z);
    }

    public void exitScene(final String str, final boolean z) {
        Handler handler;
        if (!VuiUtils.canUseVuiFeature() || str == null || (handler = this.mHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                    if (VuiEngineImpl.this.mEnterSceneStack.contains(sceneUnqiueId)) {
                        VuiEngineImpl.this.mEnterSceneStack.remove(sceneUnqiueId);
                        LogUtils.logInfo(VuiEngineImpl.TAG, "exitScene:" + sceneUnqiueId + ",mEnterSceneStack:" + VuiEngineImpl.this.mEnterSceneStack);
                        VuiSceneManager.instance().exitScene(sceneUnqiueId, VuiEngineImpl.this.mPackageName, z);
                        if (sceneUnqiueId.equals(VuiEngineImpl.mActiveSceneId)) {
                            if (VuiEngineImpl.this.mEnterSceneStack.size() != 0) {
                                VuiEngineImpl.mActiveSceneId = (String) VuiEngineImpl.this.mEnterSceneStack.get(VuiEngineImpl.this.mEnterSceneStack.size() - 1);
                                String str2 = VuiEngineImpl.mActiveSceneId;
                                VuiEngineImpl.this.handlerEnterScene(str2, VuiSceneManager.instance().enterScene(str2, VuiEngineImpl.this.mPackageName, z));
                            } else {
                                VuiEngineImpl.mActiveSceneId = null;
                            }
                        }
                    }
                } catch (Exception e) {
                    LogUtils.e(VuiEngineImpl.TAG, "e:" + e.fillInStackTrace());
                }
            }
        });
    }

    public void buildScene(final String str, final View view, final List<Integer> list, final IVuiElementListener iVuiElementListener, final List<String> list2, final boolean z, final ISceneCallbackHandler iSceneCallbackHandler) {
        if (VuiUtils.cannotUpload()) {
            return;
        }
        if (view == null || str == null) {
            return;
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                    if (VuiSceneManager.instance().getVuiSceneState(sceneUnqiueId) == VuiSceneState.INIT.getState() && z) {
                        LogUtils.e(VuiEngineImpl.TAG, str + "场景数据的创建必须在场景被激活后");
                        return;
                    }
                    LogUtils.logDebug(VuiEngineImpl.TAG, "buildScene:" + str);
                    List list3 = null;
                    if (list2 != null) {
                        list3 = new ArrayList();
                        list3.addAll(list2);
                        int size = list3.size();
                        for (int i = 0; i < size; i++) {
                            String str2 = (String) list3.get(i);
                            list3.remove(str2);
                            list3.add(i, VuiEngineImpl.this.getSceneUnqiueId(str2));
                        }
                    }
                    VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.BUILD, list, iVuiElementListener, list3, Arrays.asList(view), z, iSceneCallbackHandler));
                } catch (Exception e) {
                    LogUtils.e(VuiEngineImpl.TAG, "e:" + e.fillInStackTrace());
                }
            }
        }, 200L);
    }

    public void buildScene(final String str, final List<View> list, final List<Integer> list2, final IVuiElementListener iVuiElementListener, final List<String> list3, final boolean z, final ISceneCallbackHandler iSceneCallbackHandler) {
        if (VuiUtils.cannotUpload() || str == null || this.mMainHandler == null) {
            return;
        }
        if (list == null || list.isEmpty()) {
            View rootView = VuiSceneManager.instance().getRootView(getSceneUnqiueId(str));
            if (rootView != null) {
                buildScene(str, rootView, list2, iVuiElementListener, list3, z, iSceneCallbackHandler);
            }
        } else if (list.size() == 1) {
            buildScene(str, list.get(0), list2, iVuiElementListener, list3, z, iSceneCallbackHandler);
        } else {
            this.mHandler.postDelayed(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                        if (VuiSceneManager.instance().getVuiSceneState(sceneUnqiueId) == VuiSceneState.INIT.getState() && z) {
                            LogUtils.e(VuiEngineImpl.TAG, str + "场景数据的创建必须在场景被激活后");
                            return;
                        }
                        LogUtils.logDebug(VuiEngineImpl.TAG, "buildScene:" + str);
                        List list4 = null;
                        if (list3 != null) {
                            list4 = new ArrayList();
                            list4.addAll(list3);
                            int size = list4.size();
                            for (int i = 0; i < size; i++) {
                                String str2 = (String) list4.get(i);
                                list4.remove(str2);
                                list4.add(i, VuiEngineImpl.this.getSceneUnqiueId(str2));
                            }
                        }
                        VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.BUILD, list2, iVuiElementListener, list4, list, z, iSceneCallbackHandler));
                    } catch (Exception e) {
                        LogUtils.e(VuiEngineImpl.TAG, e.fillInStackTrace());
                    }
                }
            }, 200L);
        }
    }

    public void updateElementAttribute(final String str, final List<View> list) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    if (VuiUtils.cannotUpload() || list == null || TextUtils.isEmpty(str)) {
                        return;
                    }
                    LogUtils.logDebug(VuiEngineImpl.TAG, "updateElementAttribute");
                    if (VuiEngineImpl.this.mUpdateElementAttrRun != null) {
                        if (str.equals(VuiEngineImpl.this.mUpdateElementAttrRun.getSceneId())) {
                            VuiEngineImpl.this.mHandler.removeCallbacks(VuiEngineImpl.this.mUpdateElementAttrRun);
                            HashSet hashSet = new HashSet(VuiEngineImpl.this.mUpdateElementAttrRun.getUpdateViews());
                            hashSet.addAll(list);
                            VuiEngineImpl.this.mUpdateElementAttrRun.setUpdateViews(new ArrayList(hashSet));
                            VuiEngineImpl.this.mHandler.postDelayed(VuiEngineImpl.this.mUpdateElementAttrRun, 50L);
                            return;
                        }
                        VuiEngineImpl.this.mUpdateElementAttrRun.run();
                        VuiEngineImpl vuiEngineImpl = VuiEngineImpl.this;
                        vuiEngineImpl.mUpdateElementAttrRun = new UpdateElementAttrRun();
                        VuiEngineImpl.this.mUpdateElementAttrRun.setSceneId(str);
                        VuiEngineImpl.this.mUpdateElementAttrRun.setUpdateViews(list);
                        VuiEngineImpl.this.mHandler.postDelayed(VuiEngineImpl.this.mUpdateElementAttrRun, 50L);
                        return;
                    }
                    VuiEngineImpl vuiEngineImpl2 = VuiEngineImpl.this;
                    vuiEngineImpl2.mUpdateElementAttrRun = new UpdateElementAttrRun();
                    VuiEngineImpl.this.mUpdateElementAttrRun.setSceneId(str);
                    VuiEngineImpl.this.mUpdateElementAttrRun.setUpdateViews(list);
                    VuiEngineImpl.this.mHandler.postDelayed(VuiEngineImpl.this.mUpdateElementAttrRun, 50L);
                }
            });
        }
    }

    public void setUpdateElementValue(final String str, final String str2, final Object obj) {
        if (VuiUtils.cannotUpload()) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(str) && obj != null) {
                this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.7
                    @Override // java.lang.Runnable
                    public void run() {
                        String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                        if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                            VuiScene newVuiScene = VuiEngineImpl.this.getNewVuiScene(sceneUnqiueId, System.currentTimeMillis());
                            VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                            if (sceneCache != null) {
                                LogUtils.i(VuiEngineImpl.TAG, "newSceneId：" + sceneUnqiueId + "，elementId：" + str2);
                                VuiElement vuiElementById = sceneCache.getVuiElementById(sceneUnqiueId, str2);
                                StringBuilder sb = new StringBuilder();
                                sb.append("targetElement：");
                                sb.append(vuiElementById);
                                LogUtils.i(VuiEngineImpl.TAG, sb.toString());
                                if (vuiElementById != null) {
                                    vuiElementById.setValues(obj);
                                    LogUtils.i(VuiEngineImpl.TAG, "targetElement：" + vuiElementById);
                                    List<VuiElement> asList = Arrays.asList(vuiElementById);
                                    LogUtils.i(VuiEngineImpl.TAG, "resultElement：" + asList);
                                    newVuiScene.setElements(asList);
                                    List<VuiElement> fusionCache = sceneCache.getFusionCache(sceneUnqiueId, asList, false);
                                    sceneCache.setCache(sceneUnqiueId, fusionCache);
                                    if (!"user".equals(Build.TYPE) && LogUtils.getLogLevel() <= LogUtils.LOG_DEBUG_LEVEL) {
                                        VuiScene newVuiScene2 = VuiEngineImpl.this.getNewVuiScene(sceneUnqiueId, System.currentTimeMillis());
                                        newVuiScene2.setElements(fusionCache);
                                        LogUtils.logDebug(VuiEngineImpl.TAG, "updateSceneTask full_scene_info" + VuiUtils.vuiSceneConvertToString(newVuiScene2));
                                    }
                                    VuiSceneManager.instance().sendSceneData(VuiSceneManager.TYPE_UPDATE, true, newVuiScene);
                                }
                            }
                        }
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    public void setUpdateElementVisible(final String str, final String str2, final boolean z) {
        if (VuiUtils.cannotUpload() || TextUtils.isEmpty(str)) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.8
            @Override // java.lang.Runnable
            public void run() {
                VuiElement vuiElementById;
                String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                    VuiScene newVuiScene = VuiEngineImpl.this.getNewVuiScene(sceneUnqiueId, System.currentTimeMillis());
                    VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                    if (sceneCache == null || (vuiElementById = sceneCache.getVuiElementById(sceneUnqiueId, str2)) != null) {
                        return;
                    }
                    vuiElementById.setVisible(Boolean.valueOf(z));
                    List<VuiElement> asList = Arrays.asList(vuiElementById);
                    newVuiScene.setElements(asList);
                    List<VuiElement> fusionCache = sceneCache.getFusionCache(sceneUnqiueId, asList, false);
                    sceneCache.setCache(sceneUnqiueId, fusionCache);
                    if (!"user".equals(Build.TYPE) && LogUtils.getLogLevel() <= LogUtils.LOG_DEBUG_LEVEL) {
                        VuiScene newVuiScene2 = VuiEngineImpl.this.getNewVuiScene(sceneUnqiueId, System.currentTimeMillis());
                        newVuiScene2.setElements(fusionCache);
                        LogUtils.logDebug(VuiEngineImpl.TAG, "updateSceneTask full_scene_info" + VuiUtils.vuiSceneConvertToString(newVuiScene2));
                    }
                    VuiSceneManager.instance().sendSceneData(VuiSceneManager.TYPE_UPDATE, true, newVuiScene);
                }
            }
        });
    }

    /* loaded from: classes3.dex */
    class UpdateElementAttrRun implements Runnable {
        private String sceneId;
        private List<View> updateViews;

        UpdateElementAttrRun() {
        }

        public String getSceneId() {
            return this.sceneId;
        }

        public void setSceneId(String str) {
            this.sceneId = str;
        }

        public List<View> getUpdateViews() {
            return this.updateViews;
        }

        public void setUpdateViews(List<View> list) {
            this.updateViews = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            VuiEngineImpl.this.mHandler.removeCallbacks(VuiEngineImpl.this.mUpdateElementAttrRun);
            VuiEngineImpl.this.mUpdateElementAttrRun = null;
            String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(this.sceneId);
            if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                LogUtils.logDebug(VuiEngineImpl.TAG, "updateSceneElementAttribute:" + this.sceneId);
                VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.UPDATEATTRIBUTE, this.updateViews));
            }
        }
    }

    /* loaded from: classes3.dex */
    class UpdateSceneRun implements Runnable {
        private String sceneId;
        private List<View> updateViews;

        UpdateSceneRun() {
        }

        public String getSceneId() {
            return this.sceneId;
        }

        public void setSceneId(String str) {
            this.sceneId = str;
        }

        public List<View> getUpdateViews() {
            return this.updateViews;
        }

        public void setUpdateViews(List<View> list) {
            this.updateViews = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            VuiEngineImpl.this.mHandler.removeCallbacks(VuiEngineImpl.this.mUpdateSceneRun);
            VuiEngineImpl.this.mUpdateSceneRun = null;
            String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(this.sceneId);
            if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                LogUtils.logDebug(VuiEngineImpl.TAG, "updateScene:" + this.sceneId);
                VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.UPDATE, this.updateViews));
            }
        }
    }

    public void updateRecyclerViewItemView(String str, List<View> list, RecyclerView recyclerView) {
        if (VuiUtils.cannotUpload() || list == null || TextUtils.isEmpty(str)) {
            return;
        }
        String sceneUnqiueId = getSceneUnqiueId(str);
        if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
            LogUtils.logInfo(TAG, "updateRecyclerViewItemView:" + str);
            this.taskStructure.dispatchTask(structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.UPDATERECYCLEVIEWITEM, list, recyclerView));
        }
    }

    public void updateScene(final String str, final View view) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.9
                @Override // java.lang.Runnable
                public void run() {
                    if (VuiUtils.cannotUpload() || view == null || TextUtils.isEmpty(str)) {
                        return;
                    }
                    LogUtils.logDebug(VuiEngineImpl.TAG, "updateScene");
                    if (VuiEngineImpl.this.mUpdateSceneRun != null) {
                        if (str.equals(VuiEngineImpl.this.mUpdateSceneRun.getSceneId())) {
                            VuiEngineImpl.this.mHandler.removeCallbacks(VuiEngineImpl.this.mUpdateSceneRun);
                            HashSet hashSet = new HashSet(VuiEngineImpl.this.mUpdateSceneRun.getUpdateViews());
                            hashSet.add(view);
                            VuiEngineImpl.this.mUpdateSceneRun.setUpdateViews(new ArrayList(hashSet));
                            VuiEngineImpl.this.mHandler.postDelayed(VuiEngineImpl.this.mUpdateSceneRun, 50L);
                            return;
                        }
                        VuiEngineImpl.this.mUpdateSceneRun.run();
                        VuiEngineImpl vuiEngineImpl = VuiEngineImpl.this;
                        vuiEngineImpl.mUpdateSceneRun = new UpdateSceneRun();
                        VuiEngineImpl.this.mUpdateSceneRun.setSceneId(str);
                        VuiEngineImpl.this.mUpdateSceneRun.setUpdateViews(Arrays.asList(view));
                        VuiEngineImpl.this.mHandler.postDelayed(VuiEngineImpl.this.mUpdateSceneRun, 50L);
                        return;
                    }
                    VuiEngineImpl vuiEngineImpl2 = VuiEngineImpl.this;
                    vuiEngineImpl2.mUpdateSceneRun = new UpdateSceneRun();
                    VuiEngineImpl.this.mUpdateSceneRun.setSceneId(str);
                    VuiEngineImpl.this.mUpdateSceneRun.setUpdateViews(Arrays.asList(view));
                    VuiEngineImpl.this.mHandler.postDelayed(VuiEngineImpl.this.mUpdateSceneRun, 50L);
                }
            });
        }
    }

    public void updateScene(final String str, final List<View> list) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.10
                @Override // java.lang.Runnable
                public void run() {
                    if (VuiUtils.cannotUpload() || list == null || TextUtils.isEmpty(str)) {
                        return;
                    }
                    LogUtils.logDebug(VuiEngineImpl.TAG, "updateScene");
                    try {
                        String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                        if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                            LogUtils.logDebug(VuiEngineImpl.TAG, "updateScene:" + str);
                            VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.UPDATE, (List<Integer>) null, (IVuiElementListener) null, list));
                        }
                    } catch (Exception e) {
                        LogUtils.e(VuiEngineImpl.TAG, e.fillInStackTrace());
                    }
                }
            });
        }
    }

    public void updateScene(final String str, final List<View> list, final List<Integer> list2, final IVuiElementListener iVuiElementListener) {
        if (VuiUtils.cannotUpload() || list == null || str == null) {
            return;
        }
        if (list.size() == 1) {
            updateScene(str, list.get(0), list2, iVuiElementListener);
        } else {
            this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.11
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                        if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                            LogUtils.logDebug(VuiEngineImpl.TAG, "updateScene:" + str);
                            VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.UPDATE, list2, iVuiElementListener, list));
                        }
                    } catch (Exception e) {
                        LogUtils.e(VuiEngineImpl.TAG, e.fillInStackTrace());
                    }
                }
            });
        }
    }

    public void updateScene(final String str, final View view, final List<Integer> list, final IVuiElementListener iVuiElementListener) {
        if (VuiUtils.cannotUpload() || view == null || str == null) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (VuiEngineImpl.this.mainThreadSceneList.contains(str) && (view instanceof RecyclerView)) {
                        VuiEngineImpl.this.mMainHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                                if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                                    LogUtils.logDebug(VuiEngineImpl.TAG, "updateScene:" + str);
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(view);
                                    VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.UPDATE, list, iVuiElementListener, arrayList));
                                }
                            }
                        });
                    } else {
                        String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                        if (!VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                            return;
                        }
                        LogUtils.logDebug(VuiEngineImpl.TAG, "updateScene:" + str);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view);
                        VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.UPDATE, list, iVuiElementListener, arrayList));
                    }
                } catch (Exception e) {
                    LogUtils.e(VuiEngineImpl.TAG, e.fillInStackTrace());
                }
            }
        });
    }

    public void handleNewRootviewToScene(final String str, final List<View> list, final VuiPriority vuiPriority) {
        Handler handler;
        if (VuiUtils.cannotUpload() || (handler = this.mHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.13
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                if (list == null || (str2 = str) == null) {
                    return;
                }
                String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str2);
                if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                    LogUtils.logDebug(VuiEngineImpl.TAG, "handleNewRootviewToScene:" + str);
                    VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, vuiPriority, TaskDispatcher.TaskType.ADD, (List<View>) list, true));
                }
            }
        });
    }

    public void removeOtherRootViewFromScene(final String str, final List<View> list) {
        Handler handler;
        if (VuiUtils.cannotUpload() || (handler = this.mHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.14
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 == null) {
                    return;
                }
                String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str2);
                if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                    LogUtils.logDebug(VuiEngineImpl.TAG, "removeOtherRootViewFromScene:" + str);
                    VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.REMOVE, list));
                }
            }
        });
    }

    public void removeOtherRootViewFromScene(final String str) {
        Handler handler;
        if (VuiUtils.cannotUpload() || (handler = this.mHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.15
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 == null) {
                    return;
                }
                String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str2);
                if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                    LogUtils.logDebug(VuiEngineImpl.TAG, "removeOtherRootViewFromScene:" + str);
                    VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.REMOVE, null));
                }
            }
        });
    }

    public void addSceneElementGroup(final View view, final String str, final VuiPriority vuiPriority, final IVuiSceneListener iVuiSceneListener) {
        Handler handler;
        if (VuiUtils.cannotUpload() || view == null || str == null || (handler = this.mHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.16
            @Override // java.lang.Runnable
            public void run() {
                String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                    LogUtils.logDebug(VuiEngineImpl.TAG, "addSceneElementGroup:" + str);
                    VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, (String) null, vuiPriority, iVuiSceneListener, view));
                }
            }
        });
    }

    public void addSceneElement(final View view, final String str, final String str2) {
        Handler handler;
        if (VuiUtils.cannotUpload() || view == null || str2 == null || (handler = this.mHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.17
            @Override // java.lang.Runnable
            public void run() {
                String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str2);
                if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                    LogUtils.logDebug(VuiEngineImpl.TAG, "addSceneElement:" + str2);
                    VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, str, (VuiPriority) null, (IVuiSceneListener) null, view));
                }
            }
        });
    }

    public void removeSceneElementGroup(final String str, final String str2, final IVuiSceneListener iVuiSceneListener) {
        Handler handler;
        if (VuiUtils.cannotUpload() || str2 == null || str == null || (handler = this.mHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.18
            @Override // java.lang.Runnable
            public void run() {
                String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str2);
                if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                    LogUtils.logDebug(VuiEngineImpl.TAG, "removeSceneElementGroup:" + str2);
                    VuiEngineImpl.this.taskStructure.dispatchTask(VuiEngineImpl.this.structureViewWrapper(sceneUnqiueId, TaskDispatcher.TaskType.REMOVE, str, iVuiSceneListener));
                }
            }
        });
    }

    public void removeVuiElement(final String str, final String str2) {
        if (VuiUtils.cannotUpload() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.19
            @Override // java.lang.Runnable
            public void run() {
                if (VuiSceneManager.instance().canUpdateScene(VuiEngineImpl.this.getSceneUnqiueId(str))) {
                    LogUtils.logInfo(VuiEngineImpl.TAG, "removeVuiElement:" + str + ",elementId:" + str2);
                    VuiSceneManager instance = VuiSceneManager.instance();
                    int i = VuiSceneManager.TYPE_REMOVE;
                    instance.sendSceneData(i, true, str + "," + str2);
                }
            }
        });
    }

    public void dispatchVuiEvent(final String str, final String str2) {
        Handler handler = this.mDispatherHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.20
            @Override // java.lang.Runnable
            public void run() {
                if (VuiUtils.canUseVuiFeature()) {
                    LogUtils.logDebug(VuiEngineImpl.TAG, "dispatchVuiEvent:" + str);
                    if (str.equals("disable.vui.feature")) {
                        VuiSceneManager.instance().setFeatureState(false);
                        VuiUtils.disableVuiFeature();
                    } else if (str.equals("enable.vui.feature")) {
                        VuiUtils.enableVuiFeature();
                        VuiSceneManager.instance().setFeatureState(true);
                    } else if (str.equals("jarvis.dm.start")) {
                        VuiSceneManager.instance().setInSpeech(true);
                        VuiEngineImpl.this.sendVuiStateChangedEvent();
                    } else if (str.equals("jarvis.dm.end")) {
                        VuiSceneManager.instance().setInSpeech(false);
                        VuiEngineImpl.this.sendVuiStateChangedEvent();
                    } else if (str.equals(VuiConstants.REBUILD_EVENT) || str.equals("scene.rebuild")) {
                        if (VuiUtils.cannotUpload() || TextUtils.isEmpty(str2) || !VuiUtils.getPackageNameFromSceneId(str2).equals(VuiEngineImpl.this.mPackageName)) {
                            return;
                        }
                        List<VuiElement> cache = ((VuiSceneBuildCache) VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType())).getCache(str2);
                        if (cache != null && !cache.isEmpty()) {
                            VuiScene newVuiScene = VuiEngineImpl.this.getNewVuiScene(str2, System.currentTimeMillis());
                            newVuiScene.setElements(cache);
                            VuiSceneCacheFactory.instance().removeAllCache(str2);
                            VuiSceneManager.instance().sendSceneData(VuiSceneManager.TYPE_BUILD, true, newVuiScene);
                            return;
                        }
                        IVuiSceneListener vuiSceneListener = VuiSceneManager.instance().getVuiSceneListener(str2);
                        if (vuiSceneListener != null) {
                            vuiSceneListener.onBuildScene();
                        }
                    } else if (VuiUtils.cannotUpload() || TextUtils.isEmpty(str2)) {
                    } else {
                        VuiEngineImpl.this.eventDispatcher.dispatch(str, str2);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendVuiStateChangedEvent() {
        final IVuiSceneListener vuiSceneListener;
        if (VuiUtils.cannotUpload()) {
            return;
        }
        try {
            List<String> list = this.mEnterSceneStack;
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if (!TextUtils.isEmpty(str) && (vuiSceneListener = VuiSceneManager.instance().getVuiSceneListener(str)) != null) {
                    this.mainHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.21
                        @Override // java.lang.Runnable
                        public void run() {
                            vuiSceneListener.onVuiStateChanged();
                        }
                    });
                }
            }
        } catch (Exception unused) {
            LogUtils.e(TAG, "sendVuiStateChangedEvent error");
        }
    }

    public String getElementState(String str, String str2) {
        if (VuiUtils.cannotUpload()) {
            return null;
        }
        LogUtils.logDebug(TAG, "getElementState:" + str + ",elementId:" + str2);
        if (getJSONType(str2)) {
            return VuiSceneManager.instance().checkScrollSubViewIsVisible(str, str2);
        }
        return VuiSceneManager.instance().getElementState(str, str2);
    }

    public static boolean getJSONType(String str) {
        if (!TextUtils.isEmpty(str)) {
            String trim = str.trim();
            if (trim.startsWith("{") && trim.endsWith("}")) {
                return true;
            }
            if (trim.startsWith("[") && trim.endsWith("]")) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VuiScene getNewVuiScene(String str, long j) {
        return new VuiScene.Builder().sceneId(str).appVersion(this.mPackageVersion).packageName(this.mPackageName).timestamp(j).build();
    }

    public void vuiFeedback(View view, VuiFeedback vuiFeedback) {
        if (VuiUtils.cannotUpload()) {
            return;
        }
        VuiSceneManager.instance().vuiFeedBack(view, vuiFeedback);
    }

    public void vuiFeedback(String str, VuiFeedback vuiFeedback) {
        if (VuiUtils.cannotUpload()) {
            return;
        }
        VuiSceneManager.instance().vuiFeedBack(str, vuiFeedback);
    }

    public void subscribe(final String str) {
        Handler handler;
        if (VuiUtils.canUseVuiFeature() && (handler = this.mHandler) != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.22
                @Override // java.lang.Runnable
                public void run() {
                    LogUtils.logInfo(VuiEngineImpl.TAG, "subscribe:" + str);
                    VuiSceneManager.instance().subscribe(str);
                }
            });
        }
    }

    public void subscribeVuiFeature() {
        Handler handler;
        if (VuiUtils.canUseVuiFeature() && (handler = this.mHandler) != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.23
                @Override // java.lang.Runnable
                public void run() {
                    LogUtils.logInfo(VuiEngineImpl.TAG, "subscribeVuiFeature");
                    VuiSceneManager.instance().subscribeVuiFeature();
                }
            });
        }
    }

    public void unSubscribeVuiFeature() {
        Handler handler;
        if (VuiUtils.canUseVuiFeature() && (handler = this.mHandler) != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.24
                @Override // java.lang.Runnable
                public void run() {
                    LogUtils.logInfo(VuiEngineImpl.TAG, "subscribeVuiFeature");
                    VuiSceneManager.instance().unSubscribeVuiFeature();
                }
            });
        }
    }

    public void unSubscribe() {
        Handler handler;
        if (VuiUtils.canUseVuiFeature() && (handler = this.mHandler) != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.25
                @Override // java.lang.Runnable
                public void run() {
                    LogUtils.logInfo(VuiEngineImpl.TAG, "unSubscribe");
                    VuiSceneManager.instance().unSubscribe();
                }
            });
        }
    }

    public void addVuiSceneListener(String str, View view, IVuiSceneListener iVuiSceneListener, IVuiElementChangedListener iVuiElementChangedListener, boolean z) {
        addVuiSceneListener(str, view, iVuiSceneListener, iVuiElementChangedListener, z, false);
    }

    public void addDupVuiSceneListener(String str, View view, IVuiSceneListener iVuiSceneListener, IVuiElementChangedListener iVuiElementChangedListener, boolean z) {
        addVuiSceneListener(str, view, iVuiSceneListener, iVuiElementChangedListener, z, true);
    }

    public void addVuiSceneListener(final String str, final View view, final IVuiSceneListener iVuiSceneListener, final IVuiElementChangedListener iVuiElementChangedListener, final boolean z, final boolean z2) {
        Handler handler;
        if (!VuiUtils.canUseVuiFeature() || (handler = this.mHandler) == null || str == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.26
            @Override // java.lang.Runnable
            public void run() {
                LogUtils.logDebug(VuiEngineImpl.TAG, "addVuiSceneListener :" + str);
                String str2 = str;
                if (z2) {
                    str2 = iVuiSceneListener.toString() + "-" + str;
                }
                VuiSceneManager.instance().addVuiSceneListener(VuiEngineImpl.this.getSceneUnqiueId(str2), view, iVuiSceneListener, iVuiElementChangedListener, z);
            }
        });
    }

    public void removeDupVuiSceneListener(String str, IVuiSceneListener iVuiSceneListener, boolean z) {
        if (iVuiSceneListener == null || TextUtils.isEmpty(str)) {
            return;
        }
        removeVuiSceneListener(iVuiSceneListener.toString() + "-" + str, iVuiSceneListener, z);
    }

    public void removeVuiSceneListener(final String str, final IVuiSceneListener iVuiSceneListener, final boolean z) {
        Handler handler;
        if (VuiUtils.canUseVuiFeature() && (handler = this.mHandler) != null) {
            handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.27
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = str;
                    if (str2 == null) {
                        return;
                    }
                    String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str2);
                    VuiSceneInfo sceneInfo = VuiSceneManager.instance().getSceneInfo(sceneUnqiueId);
                    boolean z2 = false;
                    if (sceneInfo != null && sceneInfo.isWholeScene()) {
                        z2 = true;
                    }
                    if (iVuiSceneListener != null && sceneInfo != null && sceneInfo.getListener() != null && !iVuiSceneListener.equals(sceneInfo.getListener())) {
                        LogUtils.w(VuiEngineImpl.TAG, "要销毁的场景和目前持有的场景数据不一致");
                        return;
                    }
                    if (!sceneUnqiueId.equals(VuiEngineImpl.mActiveSceneId)) {
                        if (VuiEngineImpl.this.mEnterSceneStack.contains(sceneUnqiueId)) {
                            VuiEngineImpl.this.mEnterSceneStack.remove(sceneUnqiueId);
                        }
                    } else {
                        VuiEngineImpl.this.exitScene(str, sceneInfo != null ? sceneInfo.isWholeScene() : true);
                    }
                    LogUtils.logDebug(VuiEngineImpl.TAG, "removeVuiSceneListener :" + str + ",isupload:" + z2 + ",keepCache:" + z);
                    VuiEngineImpl.this.taskStructure.removeTask(sceneUnqiueId);
                    VuiSceneManager.instance().removeVuiSceneListener(sceneUnqiueId, z2, z, iVuiSceneListener);
                }
            });
        }
    }

    public void setVuiElementTag(View view, String str) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        String str2 = "4657_" + str;
        view.setTag(str2);
        if (view instanceof IVuiElement) {
            ((IVuiElement) view).setVuiElementId(str2);
        }
    }

    public String getVuiElementTag(View view) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return null;
        }
        String str = (String) view.getTag();
        if (str.startsWith("4657")) {
            return str;
        }
        return null;
    }

    public void setVuiElementUnSupportTag(View view, boolean z) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        view.setTag(R.id.vuiElementUnSupport, Boolean.valueOf(z));
    }

    public void setVuiCustomDisableControlTag(View view) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        view.setTag(R.id.customDisableControl, true);
    }

    public void setHasFeedBackTxtByViewDisable(View view, String str) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        view.setTag(R.id.customDisableFeedbackTTS, str);
    }

    public void setVuiCustomDisableFeedbackTag(View view) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        view.setTag(R.id.customDisableFeedback, true);
    }

    public void setVuiElementDefaultAction(View view, String str, Object obj) {
        if (!VuiUtils.canUseVuiFeature() || view == null || str == null || obj == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            VuiUtils.generateElementValueJSON(jSONObject, str, obj);
            view.setTag(R.id.vuiElementDefaultAction, jSONObject);
        } catch (Exception e) {
            LogUtils.e(TAG, e.fillInStackTrace());
        }
    }

    public void setVuiStatefulButtonClick(View view) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        view.setTag(R.id.vuiStatefulButtonClick, true);
    }

    public void disableChildVuiAttrWhenInvisible(View view) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        view.setTag(R.id.disableChildVuiAttrsWhenInvisible, true);
    }

    public void setVuiLabelUnSupportText(View... viewArr) {
        if (!VuiUtils.canUseVuiFeature() || viewArr == null) {
            return;
        }
        for (View view : viewArr) {
            view.setTag(R.id.vuiLabelUnSupportText, true);
        }
    }

    public void setVuiElementVisibleTag(View view, boolean z) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        view.setTag(R.id.vuiElementVisible, Boolean.valueOf(z));
    }

    public Boolean getVuiElementVisibleTag(View view) {
        Boolean bool;
        if (!VuiUtils.canUseVuiFeature() || view == null || (bool = (Boolean) view.getTag(R.id.vuiElementVisible)) == null) {
            return null;
        }
        return bool;
    }

    public void disableVuiFeature() {
        LogUtils.logInfo(TAG, "user disable feature");
        VuiUtils.userSetFeatureState(true);
    }

    public void enableVuiFeature() {
        LogUtils.logInfo(TAG, "user enable feature");
        VuiUtils.userSetFeatureState(false);
    }

    public boolean isVuiFeatureDisabled() {
        return VuiUtils.cannotUpload();
    }

    public boolean isInSpeech() {
        if (VuiUtils.cannotUpload()) {
            return false;
        }
        return VuiSceneManager.instance().isInSpeech();
    }

    public String getVuiElementId(String str, int i, String str2) {
        if (str != null) {
            str2 = str + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + str2;
        }
        if (i != -1) {
            return str2 + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + i;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TaskWrapper> structureViewWrapper(String str, TaskDispatcher.TaskType taskType, String str2, IVuiSceneListener iVuiSceneListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TaskWrapper((View) null, str, taskType, iVuiSceneListener, str2));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TaskWrapper> structureViewWrapper(String str, VuiPriority vuiPriority, TaskDispatcher.TaskType taskType, List<View> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TaskWrapper(str, vuiPriority, taskType, list, z));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TaskWrapper> structureViewWrapper(String str, TaskDispatcher.TaskType taskType, List<Integer> list, IVuiElementListener iVuiElementListener, List<String> list2, List<View> list3, boolean z, ISceneCallbackHandler iSceneCallbackHandler) {
        ArrayList arrayList = new ArrayList();
        if (list3 != null && list3.size() != 0) {
            if (list3.size() == 1) {
                arrayList.add(new TaskWrapper(list3.get(0), str, list3.get(0).getId(), taskType, list, iVuiElementListener, list2, z, iSceneCallbackHandler));
            } else {
                arrayList.add(new TaskWrapper(list3, str, taskType, list, iVuiElementListener, list2, z, iSceneCallbackHandler));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TaskWrapper> structureViewWrapper(String str, TaskDispatcher.TaskType taskType, List<Integer> list, IVuiElementListener iVuiElementListener, List<View> list2) {
        ArrayList arrayList = new ArrayList();
        if (list2 != null && !list2.isEmpty()) {
            if (list2.size() == 1) {
                View view = list2.get(0);
                if (view.getId() != -1) {
                    arrayList.add(new TaskWrapper(view, str, view.getId(), taskType, list, iVuiElementListener));
                } else {
                    arrayList.add(new TaskWrapper(view, str, taskType, list, iVuiElementListener));
                }
            } else {
                arrayList.add(new TaskWrapper(list2, str, taskType, list, iVuiElementListener));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TaskWrapper> structureViewWrapper(String str, TaskDispatcher.TaskType taskType, List<View> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() == 1) {
            View view = list.get(0);
            if (view.getId() != -1) {
                arrayList.add(new TaskWrapper(view, view.getId(), str, taskType));
            } else {
                arrayList.add(new TaskWrapper(str, taskType, view));
            }
        } else {
            arrayList.add(new TaskWrapper(str, taskType, list));
        }
        return arrayList;
    }

    private List<TaskWrapper> structureViewWrapper(String str, TaskDispatcher.TaskType taskType, List<View> list, RecyclerView recyclerView) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() == 1) {
            View view = list.get(0);
            if (view.getId() != -1) {
                arrayList.add(new TaskWrapper(view, view.getId(), str, taskType, recyclerView));
            } else {
                arrayList.add(new TaskWrapper(str, taskType, view, recyclerView));
            }
        } else {
            arrayList.add(new TaskWrapper(str, taskType, list, recyclerView));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TaskWrapper> structureViewWrapper(String str, String str2, VuiPriority vuiPriority, IVuiSceneListener iVuiSceneListener, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        for (View view : viewArr) {
            if (view != null) {
                if (vuiPriority == null) {
                    arrayList.add(new TaskWrapper(view, str, view.getId(), TaskDispatcher.TaskType.ADD, str2));
                } else {
                    arrayList.add(new TaskWrapper(view, str, view.getId(), TaskDispatcher.TaskType.ADD, vuiPriority, iVuiSceneListener));
                }
            }
        }
        return arrayList;
    }

    public VuiScene createVuiScene(String str, long j) {
        return new VuiScene.Builder().sceneId(getSceneUnqiueId(str)).appVersion(this.mPackageVersion).packageName(this.mPackageName).timestamp(j).build();
    }

    public void setLoglevel(int i) {
        LogUtils.setLogLevel(i);
    }

    public void addVuiEventListener(final String str, final IVuiEventListener iVuiEventListener) {
        Handler handler;
        if (!VuiUtils.canUseVuiFeature() || (handler = this.mHandler) == null || str == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.28
            @Override // java.lang.Runnable
            public void run() {
                LogUtils.logDebug(VuiEngineImpl.TAG, "addVuiEventListener :" + str);
                VuiSceneManager.instance().addVuiEventListener(VuiEngineImpl.this.getSceneUnqiueId(str), iVuiEventListener);
            }
        });
    }

    public void disableViewVuiMode() {
        LogUtils.logInfo(TAG, "user disable view's vui mode");
        VuiUtils.userDisableViewMode();
    }

    public void setExecuteVirtualTag(View view, String str) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            view.setTag(R.id.executeVirtualId, "10000");
            return;
        }
        int i = R.id.executeVirtualId;
        view.setTag(i, "10000_" + str);
    }

    public void setVirtualResourceNameTag(View view, String str) {
        if (!VuiUtils.canUseVuiFeature() || view == null || TextUtils.isEmpty(str)) {
            return;
        }
        view.setTag(R.id.virtualResourceName, str);
    }

    public void setCustomDoActionTag(View view) {
        if (!VuiUtils.canUseVuiFeature() || view == null) {
            return;
        }
        view.setTag(R.id.customDoAction, true);
    }

    public void setProcessName(String str) {
        VuiSceneManager.instance().setProcessName(str);
    }

    public void init(String str) {
        subscribe(this.mPackageName + "." + str);
    }

    public void addVuiSceneListener(String str, IVuiSceneListener iVuiSceneListener) {
        addVuiSceneListener(str, null, iVuiSceneListener, null, true);
    }

    public void setBuildElements(final String str, final List<VuiElement> list) {
        if (VuiUtils.cannotUpload() || TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.29
            @Override // java.lang.Runnable
            public void run() {
                String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                if (VuiSceneManager.instance().getVuiSceneState(sceneUnqiueId) == VuiSceneState.INIT.getState()) {
                    LogUtils.e(VuiEngineImpl.TAG, str + "场景数据的创建必须在场景被激活后");
                    return;
                }
                LogUtils.i(VuiEngineImpl.TAG, "newSceneId:" + sceneUnqiueId + ",elements:" + list);
                VuiScene newVuiScene = VuiEngineImpl.this.getNewVuiScene(sceneUnqiueId, System.currentTimeMillis());
                newVuiScene.setElements(list);
                VuiSceneInfo sceneInfo = VuiSceneManager.instance().getSceneInfo(sceneUnqiueId);
                if (sceneInfo != null) {
                    sceneInfo.setBuild(true);
                    sceneInfo.setBuildComplete(true);
                }
                VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                if (sceneCache != null) {
                    sceneCache.setCache(sceneUnqiueId, list);
                }
                VuiSceneManager.instance().sendSceneData(VuiSceneManager.TYPE_BUILD, false, newVuiScene);
            }
        });
    }

    public void setUpdateElements(final String str, final List<VuiElement> list) {
        if (VuiUtils.cannotUpload() || TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.VuiEngineImpl.30
            @Override // java.lang.Runnable
            public void run() {
                VuiScene newVuiScene;
                String sceneUnqiueId = VuiEngineImpl.this.getSceneUnqiueId(str);
                if (VuiSceneManager.instance().canUpdateScene(sceneUnqiueId)) {
                    VuiScene newVuiScene2 = VuiEngineImpl.this.getNewVuiScene(sceneUnqiueId, System.currentTimeMillis());
                    VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
                    if (sceneCache != null) {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < list.size(); i++) {
                            VuiElement vuiElement = (VuiElement) list.get(i);
                            VuiElement vuiElementById = sceneCache.getVuiElementById(sceneUnqiueId, vuiElement.getId());
                            if (vuiElementById == null || !vuiElementById.equals(vuiElement)) {
                                if (vuiElement.getElements() == null && vuiElementById.getElements() != null) {
                                    vuiElement.setElements(vuiElementById.getElements());
                                }
                                arrayList.add(vuiElement);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return;
                        }
                        newVuiScene2.setElements(arrayList);
                        List<VuiElement> fusionCache = sceneCache.getFusionCache(sceneUnqiueId, arrayList, false);
                        sceneCache.setCache(sceneUnqiueId, fusionCache);
                        if (!"user".equals(Build.TYPE) && LogUtils.getLogLevel() <= LogUtils.LOG_DEBUG_LEVEL) {
                            VuiEngineImpl.this.getNewVuiScene(sceneUnqiueId, System.currentTimeMillis()).setElements(fusionCache);
                            LogUtils.logDebug(VuiEngineImpl.TAG, "updateSceneTask full_scene_info" + VuiUtils.vuiSceneConvertToString(newVuiScene));
                        }
                        VuiSceneManager.instance().sendSceneData(VuiSceneManager.TYPE_UPDATE, true, newVuiScene2);
                    }
                }
            }
        });
    }

    public VuiElement getVuiElement(String str, String str2) {
        VuiSceneCache sceneCache;
        if (VuiUtils.cannotUpload() || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType())) == null) {
            return null;
        }
        return sceneCache.getVuiElementById(getSceneUnqiueId(str), str2);
    }

    public VuiScene getVuiScene(String str) {
        List<VuiElement> cache;
        if (VuiUtils.cannotUpload() || TextUtils.isEmpty(str)) {
            return null;
        }
        VuiScene createVuiScene = createVuiScene(str, System.currentTimeMillis());
        VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
        if (sceneCache != null && (cache = sceneCache.getCache(createVuiScene.getSceneId())) != null && cache.isEmpty()) {
            createVuiScene.setElements(cache);
        }
        return createVuiScene;
    }

    public boolean isSpeechShowNumber() {
        if (VuiUtils.cannotUpload()) {
            return false;
        }
        return VuiSceneManager.instance().isInSpeech();
    }

    public String getActiveSceneId() {
        return mActiveSceneId;
    }
}
