package com.xiaopeng.speech.vui.task;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaopeng.speech.vui.VuiEngineImpl;
import com.xiaopeng.speech.vui.VuiSceneManager;
import com.xiaopeng.speech.vui.cache.VuiSceneCache;
import com.xiaopeng.speech.vui.cache.VuiSceneCacheFactory;
import com.xiaopeng.speech.vui.model.VuiScene;
import com.xiaopeng.speech.vui.model.VuiSceneInfo;
import com.xiaopeng.speech.vui.task.base.BaseTask;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import com.xiaopeng.vui.commons.IVuiElement;
import com.xiaopeng.vui.commons.IVuiElementChangedListener;
import com.xiaopeng.vui.commons.IVuiElementListener;
import com.xiaopeng.vui.commons.model.VuiElement;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class UpdateSceneTask extends BaseTask {
    private String TAG;
    private List<String> allIdList;
    private List<String> bizIds;
    private SoftReference<IVuiElementListener> callback;
    private IVuiElementChangedListener elementChangedListener;
    private List<VuiElement> elements;
    private List<String> idList;
    private List<Integer> ids;
    private VuiSceneInfo info;
    private boolean isRecyclerView;
    private List<String> mainThreadSceneList;
    private String sceneId;
    private long time;
    private SoftReference<View> updateView;
    private List<SoftReference<View>> viewList;
    private TaskWrapper viewWrapper;
    private VuiScene vuiScene;
    private VuiSceneCache vuiSceneCache;

    public UpdateSceneTask(TaskWrapper taskWrapper) {
        super(taskWrapper);
        this.TAG = "VuiEngine_UpdateSceneTask";
        this.vuiScene = null;
        this.elements = new ArrayList();
        this.bizIds = new ArrayList();
        this.time = -1L;
        this.info = null;
        this.isRecyclerView = false;
        this.allIdList = null;
        this.idList = new ArrayList();
        this.vuiSceneCache = null;
        this.mainThreadSceneList = Arrays.asList("MainMusicConcentration");
        this.viewWrapper = taskWrapper;
        this.sceneId = taskWrapper.getSceneId();
        this.viewList = taskWrapper.getViewList();
        this.updateView = taskWrapper.getView();
        this.ids = taskWrapper.getCustomizeIds();
        this.callback = taskWrapper.getElementListener();
    }

    @Override // com.xiaopeng.speech.vui.task.base.Task
    public void execute() {
        updateSceneByElement();
    }

    private void updateSceneByElement() {
        try {
            if ((this.viewList == null && this.updateView == null) || TextUtils.isEmpty(this.sceneId) || !VuiSceneManager.instance().canUpdateScene(this.sceneId)) {
                return;
            }
            this.time = System.currentTimeMillis();
            this.vuiScene = getNewVuiScene(this.sceneId, this.time);
            this.allIdList = VuiSceneManager.instance().getSceneIdList(this.sceneId);
            this.info = VuiSceneManager.instance().getSceneInfo(this.sceneId);
            this.vuiSceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
            if (this.info == null) {
                return;
            }
            this.elementChangedListener = this.info.getElementChangedListener();
            if (this.viewList != null) {
                int size = this.viewList.size();
                if (size == 0) {
                    return;
                }
                for (int i = 0; i < size; i++) {
                    SoftReference<View> softReference = this.viewList.get(i);
                    if (isNeedUpdate(softReference)) {
                        if (softReference != null && (softReference.get() instanceof RecyclerView)) {
                            this.isRecyclerView = true;
                        }
                        String str = this.TAG;
                        LogUtils.logDebug(str, "updateScene updateView" + softReference.get());
                        buildUpdateView(softReference);
                    }
                }
                handleUpdateElement();
            } else if (this.updateView != null) {
                String str2 = this.TAG;
                LogUtils.logDebug(str2, "updateScene updateView" + this.updateView.get());
                if (isNeedUpdate(this.updateView)) {
                    if (this.updateView != null && (this.updateView.get() instanceof RecyclerView)) {
                        this.isRecyclerView = true;
                    }
                    String substring = this.sceneId.substring(this.sceneId.lastIndexOf("-") + 1);
                    if (this.isRecyclerView && this.mainThreadSceneList.contains(substring)) {
                        buildUpdateView(this.updateView);
                        handleUpdateElement();
                        return;
                    }
                    buildUpdateView(this.updateView);
                    handleUpdateElement();
                }
            }
        } catch (Exception e) {
            String str3 = this.TAG;
            LogUtils.e(str3, "e:" + e.getMessage());
        }
    }

    @Override // com.xiaopeng.vui.commons.IVuiElementBuilder
    public List<VuiElement> build(int i, View view) {
        return build(i, view);
    }

    @Override // com.xiaopeng.vui.commons.IVuiElementBuilder
    public List<VuiElement> build(int i, List<View> list) {
        return build(i, list);
    }

    private boolean isNeedUpdate(SoftReference<View> softReference) {
        return softReference == null || softReference.get() == null || !(softReference.get() instanceof RecyclerView) || this.sceneId.equals(VuiEngineImpl.mActiveSceneId) || ((RecyclerView) softReference.get()).getChildCount() != 0;
    }

    private boolean isAddToScene(SoftReference<View> softReference, boolean z, VuiSceneInfo vuiSceneInfo) {
        if (softReference != null && softReference.get() != null) {
            View rootView = vuiSceneInfo.getRootView();
            if ("com.xiaopeng.musicradio".equals(VuiSceneManager.instance().getmPackageName())) {
                if (z) {
                    if (isRecyclerViewChild((View) softReference.get().getParent(), rootView)) {
                        String str = this.TAG;
                        LogUtils.logDebug(str, "view:" + softReference + "isRecyclerView," + z + ",rootView:" + rootView + ",ignore addToScene");
                        return false;
                    }
                } else if (isRecyclerViewChild(softReference.get(), rootView)) {
                    String str2 = this.TAG;
                    LogUtils.logDebug(str2, "view:" + softReference + "isRecyclerView," + z + ",rootView:" + rootView + ",ignore addToScene");
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isRecyclerViewChild(View view, View view2) {
        if (view2 == null || view == null) {
            return false;
        }
        if (view instanceof RecyclerView) {
            return true;
        }
        if (view == view2) {
            return false;
        }
        return isRecyclerViewChild((View) view.getParent(), view2);
    }

    private void buildUpdateView(SoftReference<View> softReference) {
        List<VuiElement> list = this.elements;
        List<Integer> list2 = this.ids;
        SoftReference<IVuiElementListener> softReference2 = this.callback;
        List<String> list3 = this.idList;
        long j = this.time;
        List<String> list4 = this.allIdList;
        List<String> list5 = this.bizIds;
        boolean isVuiLayoutLoadable = (softReference == null || !(softReference.get() instanceof IVuiElement)) ? false : ((IVuiElement) softReference.get()).isVuiLayoutLoadable();
        boolean z = this.isRecyclerView;
        VuiElement buildView = buildView(softReference, list, list2, softReference2, list3, j, list4, list5, null, 0, isVuiLayoutLoadable, z, z ? null : this.elementChangedListener);
        if (buildView != null && buildView.getId() != null) {
            buildView.setTimestamp(this.time);
            setVuiTag(softReference, buildView.getId());
            VuiElement vuiElementById = this.vuiSceneCache.getVuiElementById(this.sceneId, buildView.getId());
            if (vuiElementById != null) {
                if (!buildView.equals(vuiElementById)) {
                    this.elements.add(buildView);
                } else {
                    LogUtils.logDebug(this.TAG, "updateScene element same");
                }
            } else if (isAddToScene(softReference, this.isRecyclerView, this.info)) {
                this.elements.add(buildView);
            }
        }
        int i = 0;
        while (i < this.elements.size()) {
            VuiElement vuiElement = this.elements.get(i);
            VuiElement vuiElementById2 = this.vuiSceneCache.getVuiElementById(this.sceneId, vuiElement.getId());
            if (vuiElementById2 == null || !vuiElement.equals(vuiElementById2)) {
                i++;
            } else {
                this.elements.remove(vuiElement);
            }
        }
    }

    private void setWholeSceneCache(String str, VuiSceneCache vuiSceneCache, List<VuiElement> list) {
        if (vuiSceneCache != null) {
            List<VuiElement> fusionCache = vuiSceneCache.getFusionCache(str, list, false);
            vuiSceneCache.setCache(str, fusionCache);
            if ("user".equals(Build.TYPE) || LogUtils.getLogLevel() > LogUtils.LOG_DEBUG_LEVEL) {
                return;
            }
            VuiScene newVuiScene = getNewVuiScene(str, System.currentTimeMillis());
            newVuiScene.setElements(fusionCache);
            String str2 = this.TAG;
            LogUtils.logDebug(str2, "updateSceneTask full_scene_info" + VuiUtils.vuiSceneConvertToString(newVuiScene));
        }
    }

    private void handleUpdateElement() {
        if (this.elements.isEmpty()) {
            return;
        }
        this.vuiScene.setElements(this.elements);
        VuiSceneInfo vuiSceneInfo = this.info;
        boolean isWholeScene = vuiSceneInfo != null ? vuiSceneInfo.isWholeScene() : true;
        VuiSceneManager.instance().setSceneIdList(this.sceneId, this.allIdList);
        if (!"user".equals(Build.TYPE) && LogUtils.getLogLevel() <= LogUtils.LOG_DEBUG_LEVEL) {
            String str = this.TAG;
            LogUtils.logDebug(str, "updateScene completed time:" + (System.currentTimeMillis() - this.time) + "," + VuiUtils.vuiUpdateSceneConvertToString(this.vuiScene));
        }
        if (Thread.currentThread().isInterrupted()) {
            LogUtils.logInfo(this.TAG, "取消当前任务");
            return;
        }
        VuiSceneCache sceneCache = VuiSceneCacheFactory.instance().getSceneCache(VuiSceneCacheFactory.CacheType.BUILD.getType());
        if (isWholeScene) {
            setWholeSceneCache(this.sceneId, sceneCache, this.elements);
            VuiSceneManager.instance().sendSceneData(VuiSceneManager.TYPE_UPDATE, true, this.vuiScene);
            return;
        }
        if (sceneCache != null) {
            sceneCache.setCache(this.sceneId, sceneCache.getFusionCache(this.sceneId, this.elements, false));
        }
        VuiSceneInfo vuiSceneInfo2 = this.info;
        List<String> wholeSceneId = vuiSceneInfo2 != null ? vuiSceneInfo2.getWholeSceneId() : null;
        int size = wholeSceneId == null ? 0 : wholeSceneId.size();
        String str2 = this.TAG;
        LogUtils.logDebug(str2, "updateScene wholeSceneIds:" + wholeSceneId);
        if (size > 0) {
            if (wholeSceneId.contains(VuiEngineImpl.mActiveSceneId)) {
                this.vuiScene = getNewVuiScene(VuiEngineImpl.mActiveSceneId, this.time);
                this.vuiScene.setElements(this.elements);
                setWholeSceneCache(VuiEngineImpl.mActiveSceneId, sceneCache, this.elements);
                VuiSceneManager.instance().sendSceneData(VuiSceneManager.TYPE_UPDATE, true, this.vuiScene);
            }
            for (int i = 0; i < size; i++) {
                String str3 = wholeSceneId.get(i);
                if (!TextUtils.isEmpty(str3) && !str3.equals(VuiEngineImpl.mActiveSceneId)) {
                    this.vuiScene = getNewVuiScene(str3, this.time);
                    this.vuiScene.setElements(this.elements);
                    setWholeSceneCache(str3, sceneCache, this.elements);
                    VuiSceneManager.instance().sendSceneData(VuiSceneManager.TYPE_UPDATE, true, this.vuiScene);
                }
            }
        }
    }
}
