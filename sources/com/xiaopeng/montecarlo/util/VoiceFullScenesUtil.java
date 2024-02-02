package com.xiaopeng.montecarlo.util;

import android.text.TextUtils;
import android.view.View;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.speech.vui.VuiEngine;
import com.xiaopeng.speech.vui.model.VuiScene;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.vui.commons.IVuiElementChangedListener;
import com.xiaopeng.vui.commons.IVuiSceneListener;
import com.xiaopeng.vui.commons.VuiMode;
import com.xiaopeng.vui.commons.VuiPriority;
import com.xiaopeng.xui.vui.VuiView;
import com.xiaopeng.xui.vui.floatinglayer.VuiFloatingLayerManager;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class VoiceFullScenesUtil {
    private static final L.Tag TAG = new L.Tag("VoiceFullScenesUtil");
    private static final Hashtable<String, Boolean> sPendingJob = new Hashtable<>();
    private static Hashtable<String, Integer> sUpdateJobs = new Hashtable<>();

    static /* synthetic */ String access$000() {
        return getEngineActiveSceneId();
    }

    /* loaded from: classes3.dex */
    public class SceneVuiState {
        public static final int STATE_ENTERED = 2;
        public static final int STATE_EXITED = 3;
        public static final int STATE_INITED = 1;
        public static final int STATE_UNINIT = 0;

        public SceneVuiState() {
        }
    }

    public static boolean isHavePendingJob(IBaseScene iBaseScene) {
        if (iBaseScene == null) {
            return false;
        }
        Hashtable<String, Boolean> hashtable = sPendingJob;
        Boolean bool = hashtable.get(iBaseScene.getSceneId() + "");
        return bool != null && bool.booleanValue();
    }

    public static void clearPendingJob(IBaseScene iBaseScene) {
        if (iBaseScene != null) {
            Hashtable<String, Boolean> hashtable = sPendingJob;
            if (hashtable.contains(iBaseScene.getSceneId() + "")) {
                Hashtable<String, Boolean> hashtable2 = sPendingJob;
                hashtable2.remove(iBaseScene.getSceneId() + "");
            }
        }
    }

    public static void clearJobs() {
        clearPendingJobs();
        clearUpdateJobs();
    }

    private static void clearPendingJobs() {
        sPendingJob.clear();
    }

    private static void clearUpdateJobs() {
        sUpdateJobs.clear();
    }

    public static void addVuiEventListener(String str, IVuiSceneListener iVuiSceneListener, View view) {
        addVuiEventListener(str, iVuiSceneListener, view, null);
    }

    public static void addVuiEventListener(String str, IVuiSceneListener iVuiSceneListener, View view, IVuiElementChangedListener iVuiElementChangedListener) {
        L.Tag tag = TAG;
        L.i(tag, L.formatVoiceFullScenesLog("addVuiEventListener sceneId:" + str + ",listener:" + iVuiSceneListener + ",view:" + view + ",eleChaListener:" + iVuiElementChangedListener));
        VuiEngine.getInstance(ContextUtils.getContext()).addVuiSceneListener(str, view, iVuiSceneListener, iVuiElementChangedListener);
    }

    public static void removeVuiEventListener(String str, IVuiSceneListener iVuiSceneListener) {
        L.Tag tag = TAG;
        L.i(tag, L.formatVoiceFullScenesLog("removeVuiEventListener sceneId:" + str + ",listener:" + iVuiSceneListener));
        VuiEngine.getInstance(ContextUtils.getContext()).removeVuiSceneListener(str, iVuiSceneListener);
    }

    public static void enterScene(String str) {
        L.Tag tag = TAG;
        L.i(tag, L.formatVoiceFullScenesLog("enterScene sceneId:" + str));
        VuiEngine.getInstance(ContextUtils.getContext()).enterScene(str);
    }

    public static void exitScene(String str) {
        L.Tag tag = TAG;
        L.i(tag, L.formatVoiceFullScenesLog("exitScene sceneId:" + str));
        VuiEngine.getInstance(ContextUtils.getContext()).exitScene(str);
    }

    public static void updateScene(IBaseScene iBaseScene, final View view) {
        if (canUpdate(iBaseScene)) {
            final String vuiSceneId = iBaseScene.getVuiSceneId();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatVoiceFullScenesLog("updateScene sceneId:" + vuiSceneId + ",view:" + view + ",mActiveSceneId:" + getEngineActiveSceneId() + ",isSceneVuiInit:" + iBaseScene.isSceneVuiInit()));
            }
            WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.util.VoiceFullScenesUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    if (VoiceFullScenesUtil.isNeedReenterScene(vuiSceneId, VoiceFullScenesUtil.access$000())) {
                        L.Tag tag2 = VoiceFullScenesUtil.TAG;
                        L.w(tag2, "updateScene but need enter scene first scene:" + vuiSceneId);
                        VoiceFullScenesUtil.enterScene(vuiSceneId);
                    }
                    VuiEngine.getInstance(ContextUtils.getContext()).updateScene(vuiSceneId, view);
                    VoiceFullScenesUtil.refreshUpdateSceneJobs(vuiSceneId);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void refreshUpdateSceneJobs(String str) {
        if (L.ENABLE) {
            Integer num = sUpdateJobs.get(str);
            sUpdateJobs.put(str, Integer.valueOf((num == null ? 0 : num.intValue()) + 1));
            for (Map.Entry<String, Integer> entry : sUpdateJobs.entrySet()) {
                L.Tag tag = TAG;
                L.d(tag, "refreshUpdateSceneJobs scene:" + entry.getKey() + ",count:" + entry.getValue());
            }
        }
    }

    public static void updateScene(IBaseScene iBaseScene, final List<View> list) {
        if (canUpdate(iBaseScene)) {
            final String vuiSceneId = iBaseScene.getVuiSceneId();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatVoiceFullScenesLog("updateScene sceneId:" + vuiSceneId + ",views:" + list + ",mActiveSceneId:" + getEngineActiveSceneId() + ",isVuiRegsit:" + iBaseScene.isSceneVuiInit()));
            }
            WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.util.VoiceFullScenesUtil.2
                @Override // java.lang.Runnable
                public void run() {
                    if (VoiceFullScenesUtil.isNeedReenterScene(vuiSceneId, VoiceFullScenesUtil.access$000())) {
                        L.w(VoiceFullScenesUtil.TAG, "updateScene but need enter scene first");
                        VoiceFullScenesUtil.enterScene(vuiSceneId);
                    }
                    VuiEngine.getInstance(ContextUtils.getContext()).updateScene(vuiSceneId, list);
                }
            });
        }
    }

    private static boolean canUpdate(IBaseScene iBaseScene) {
        boolean isSceneVuiEnabled = iBaseScene.isSceneVuiEnabled();
        boolean z = false;
        if (isSceneVuiEnabled) {
            boolean z2 = !Utils.isEmptyScene(iBaseScene);
            boolean isSceneLegal = iBaseScene.isSceneLegal();
            boolean isSceneVuiInit = iBaseScene.isSceneVuiInit();
            boolean z3 = (iBaseScene.getSceneVuiState() == 0 || 3 == iBaseScene.getSceneVuiState()) ? false : true;
            if (z2 && isSceneLegal && isSceneVuiInit && z3) {
                z = true;
            }
            if (!z) {
                if (L.ENABLE) {
                    L.d(TAG, "canUpdate scene failure flag:" + z + ",flag1:" + z2 + ",flag2:" + isSceneLegal + ",flag3:" + isSceneVuiInit + "flag4:" + z3 + ",isSceneVuiEnabled:" + isSceneVuiEnabled + ",scene:" + iBaseScene);
                }
                sPendingJob.put(iBaseScene.getSceneId() + "", true);
            }
        } else {
            L.w(TAG, "canUpdate scene failure vui is not enabled scene:" + iBaseScene);
        }
        return z;
    }

    public static void buildScene(final View view, final IBaseScene iBaseScene) {
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.util.VoiceFullScenesUtil.3
            @Override // java.lang.Runnable
            public void run() {
                if (L.ENABLE) {
                    L.Tag tag = VoiceFullScenesUtil.TAG;
                    L.d(tag, L.formatVoiceFullScenesLog("buildScene sceneId:" + IBaseScene.this.getVuiSceneId() + ",view:" + view + ",scene:" + IBaseScene.this + ",isSceneVuiInit:" + IBaseScene.this.isSceneVuiInit()));
                }
                if (IBaseScene.this.isSceneVuiInit()) {
                    VuiEngine.getInstance(ContextUtils.getContext()).buildScene(IBaseScene.this.getVuiSceneId(), view);
                }
            }
        });
    }

    public static void buildScene(List<View> list, IBaseScene iBaseScene) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("buildScene sceneId:" + iBaseScene.getVuiSceneId() + ",view:" + list + ",scene:" + iBaseScene + ",isSceneVuiInit:" + iBaseScene.isSceneVuiInit()));
        }
        if (iBaseScene.isSceneVuiInit()) {
            VuiEngine.getInstance(ContextUtils.getContext()).buildScene(iBaseScene.getVuiSceneId(), list);
        }
    }

    public static void dispatchVuiEvent(String str, String str2) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("dispatchVuiEvent event:" + str + ",data:" + str2));
        }
        VuiEngine.getInstance(ContextUtils.getContext()).dispatchVuiEvent(str, str2);
    }

    public static void setVuiElementTag(View view, String str) {
        view.setTag(null);
        VuiEngine.getInstance(ContextUtils.getContext()).setVuiElementTag(view, str);
    }

    public static String getVuiElementTag(View view) {
        return VuiEngine.getInstance(ContextUtils.getContext()).getVuiElementTag(view);
    }

    public static void addSceneElementGroup(View view, String str, VuiPriority vuiPriority, IVuiSceneListener iVuiSceneListener) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("addSceneElementGroup rootView:" + view + ",sceneId:" + str + ",priority:" + vuiPriority + ",listener:" + iVuiSceneListener));
        }
        VuiEngine.getInstance(ContextUtils.getContext()).addSceneElementGroup(view, str, vuiPriority, iVuiSceneListener);
    }

    public static void removeSceneElementGroup(String str, String str2, IVuiSceneListener iVuiSceneListener) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("removeSceneElementGroup elementGroupId:" + str + ",sceneId:" + str2 + ",listener:" + iVuiSceneListener));
        }
        VuiEngine.getInstance(ContextUtils.getContext()).removeSceneElementGroup(str, str2, iVuiSceneListener);
    }

    public static VuiScene createVuiScene(String str, long j) {
        L.Tag tag = TAG;
        L.i(tag, "createVuiScene sceneId:" + str + ",time:" + j);
        return VuiEngine.getInstance(ContextUtils.getContext()).createVuiScene(str, j);
    }

    public static void showVuiAnimation(View view) {
        boolean canShowAnimation = canShowAnimation(view);
        L.Tag tag = TAG;
        L.i(tag, "showVuiAnimation view:" + view + ",canShowAnimation:" + canShowAnimation);
        if (canShowAnimation && view != null) {
            try {
                if (view.getVisibility() == 0) {
                    VuiFloatingLayerManager.show(view);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void updateVuiMode(VuiView vuiView, IBaseScene iBaseScene, VuiMode vuiMode, View view) {
        updateVuiMode(vuiView, iBaseScene, vuiMode, view, true);
    }

    public static void updateVuiMode(VuiView vuiView, IBaseScene iBaseScene, VuiMode vuiMode, View view, boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "updateVuiMode sceneId:" + iBaseScene + ",mode:" + vuiMode + ",vuiView:" + view + ",element:" + vuiView);
        vuiView.setVuiMode(vuiMode);
        if (z) {
            updateScene(iBaseScene, view);
        }
    }

    public static void addNewRootviewToScene(IBaseScene iBaseScene, final List<View> list) {
        if (canUpdate(iBaseScene)) {
            final String vuiSceneId = iBaseScene.getVuiSceneId();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatVoiceFullScenesLog("addNewRootviewToScene sceneId:" + vuiSceneId + ",views:" + list + ",mActiveSceneId:" + getEngineActiveSceneId()));
            }
            WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.util.VoiceFullScenesUtil.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (VoiceFullScenesUtil.isNeedReenterScene(vuiSceneId, VoiceFullScenesUtil.access$000())) {
                            L.w(VoiceFullScenesUtil.TAG, "addNewRootviewToScene but need enter scene first");
                            VoiceFullScenesUtil.enterScene(vuiSceneId);
                        }
                        VuiEngine.getInstance(ContextUtils.getContext()).handleNewRootviewToScene(vuiSceneId, list);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static boolean canShowAnimation(View view) {
        for (int i : new int[]{R.id.route_alert_label_item, R.id.btn_close_poi_card, R.id.tv_favorite_delete, R.id.tv_kwd_delete, R.id.tv_dest_delete, R.id.btn_zoom_in, R.id.btn_zoom_out}) {
            if (i == view.getId()) {
                return false;
            }
        }
        return CommonVuiHelper.getInstance().isViewVisible(view);
    }

    public static void setVuiLogLevel(int i) {
        VuiEngine.getInstance(ContextUtils.getContext()).setLoglevel(i);
        L.Tag tag = TAG;
        L.i(tag, "setVuiLogLevel level:" + i + ",vui log level:" + LogUtils.getLogLevel());
    }

    public static void initVuiLogLevel() {
        if (L.ENABLE) {
            setVuiLogLevel(LogUtils.LOG_DEBUG_LEVEL);
        } else {
            setVuiLogLevel(LogUtils.LOG_INFO_LEVEL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isNeedReenterScene(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return !str2.contains(str);
    }

    public static boolean isSceneVuiSupport() {
        return CarFeatureManager.INSTANCE.isFullScenesVoiceEnable();
    }

    private static String getEngineActiveSceneId() {
        return VuiEngine.getInstance(ContextUtils.getContext()).getActiveSceneId();
    }
}
