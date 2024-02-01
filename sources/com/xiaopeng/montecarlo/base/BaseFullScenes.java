package com.xiaopeng.montecarlo.base;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.base.SceneInfoStack;
import com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.base.scene.IScene;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.scenes.mapscene.MapVuiHelper;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.montecarlo.util.VuiSceneStateHashTable;
import com.xiaopeng.speech.vui.VuiEngine;
import com.xiaopeng.vui.commons.IVuiElementChangedListener;
import com.xiaopeng.vui.commons.IVuiSceneListener;
import com.xiaopeng.vui.commons.VuiUpdateType;
import com.xiaopeng.vui.commons.model.VuiEvent;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class BaseFullScenes extends BaseScene implements IVuiSceneListener {
    private static final L.Tag TAG = new L.Tag("BaseFullScenes");
    protected String mVuiSceneId = getClass().getSimpleName();
    private VuiSceneStateHashTable<String, Integer> mSceneVuiStateMap = new VuiSceneStateHashTable<>();
    private boolean mIsFirstEnterScene = true;
    public IVuiElementChangedListener mEleChaListener = new IVuiElementChangedListener() { // from class: com.xiaopeng.montecarlo.base.BaseFullScenes.1
        @Override // com.xiaopeng.vui.commons.IVuiElementChangedListener
        public void onVuiElementChaned(View view, VuiUpdateType vuiUpdateType) {
            if (L.ENABLE) {
                L.Tag tag = BaseFullScenes.TAG;
                L.d(tag, "onVuiElementChaned view:" + view + ",vuiUpdateType:" + vuiUpdateType + ",visible:" + view.getVisibility());
            }
            if (VuiUpdateType.UPDATE_VIEW.equals(vuiUpdateType)) {
                VoiceFullScenesUtil.updateScene(BaseFullScenes.this.getCurrentScene(), view);
            } else {
                VuiEngine.getInstance(BaseFullScenes.this.getContext()).updateElementAttribute(BaseFullScenes.this.getCurrentScene().getVuiSceneId(), view);
            }
        }
    };

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public <T extends AbstractBasePresenter> T getPresenter() {
        return null;
    }

    protected boolean isNeedMergeBaseMapViewForVui() {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean isSceneVuiEnabled() {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    protected View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public String getVuiSceneId() {
        IBaseScene topChildScene = getTopChildScene();
        if (topChildScene != null) {
            return topChildScene.getVuiSceneId();
        }
        return this.mVuiSceneId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneViewCreated(View view, @Nullable Bundle bundle) {
        super.onSceneViewCreated(view, bundle);
        initSceneVui();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneResume() {
        super.onSceneResume();
        enterVuiScene();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onScenePause() {
        super.onScenePause();
        exitVuiScene();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroyView() {
        super.onSceneDestroyView();
        unInitSceneVui();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onChildSceneReadyToAdd(IBaseScene iBaseScene) {
        super.onChildSceneReadyToAdd(iBaseScene);
        vuiOperationWhenAddChildSceneBefore();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onChildSceneAdded(IBaseScene iBaseScene) {
        super.onChildSceneAdded(iBaseScene);
        vuiOperationWhenAddChildSceneAfter(iBaseScene);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void onChildSceneRemoved(IScene iScene) {
        super.onChildSceneRemoved(iScene);
        vuiOperationWhenBackChildScene();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IScene
    public final void removeChildAfterIndex(int i) {
        super.removeChildAfterIndex(i);
        vuiOperationWhenBackChildScene();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initSceneVui() {
        if (isSceneVuiEnabled()) {
            String vuiSceneId = getVuiSceneId();
            this.mSceneVuiStateMap.put(vuiSceneId, 0);
            VoiceFullScenesUtil.addVuiEventListener(vuiSceneId, this, getWindowDecorView(), this.mEleChaListener);
            this.mSceneVuiStateMap.put(vuiSceneId, 1);
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "initSceneVui scene:" + getClass().getSimpleName() + ",current state:" + this.mSceneVuiStateMap.get((Object) vuiSceneId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void enterVuiScene() {
        enterVuiScene(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void exitVuiScene() {
        exitVuiScene(null);
    }

    protected void unInitSceneVui() {
        if (isSceneVuiEnabled()) {
            String vuiSceneId = getVuiSceneId();
            VoiceFullScenesUtil.removeVuiEventListener(vuiSceneId, this);
            this.mSceneVuiStateMap.remove(vuiSceneId);
            this.mIsFirstEnterScene = true;
            this.mEleChaListener = null;
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "unInitSceneVui scene:" + getClass().getSimpleName() + ",current state:" + this.mSceneVuiStateMap.get((Object) vuiSceneId));
            }
        }
    }

    protected void enterVuiScene(IBaseScene iBaseScene) {
        String vuiSceneId;
        if (isSceneVuiEnabled()) {
            int sceneVuiState = iBaseScene == null ? getSceneVuiState() : iBaseScene.getSceneVuiState();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "enterVuiScene specify scene:" + iBaseScene + ",currentState:" + sceneVuiState);
            }
            if (iBaseScene == null) {
                vuiSceneId = getVuiSceneId();
            } else {
                vuiSceneId = iBaseScene.getVuiSceneId();
            }
            if (this.mSceneVuiStateMap.get((Object) vuiSceneId).intValue() == 2) {
                L.Tag tag2 = TAG;
                L.w(tag2, "enterVuiScene failure already entered，vuiSceneId:" + vuiSceneId + ", scene:" + getClass().getSimpleName());
                return;
            }
            if (iBaseScene == null) {
                setSceneVuiState(2);
            } else {
                iBaseScene.setSceneVuiState(2);
            }
            if (this.mIsFirstEnterScene) {
                this.mIsFirstEnterScene = false;
            }
            VoiceFullScenesUtil.enterScene(vuiSceneId);
            int sceneVuiState2 = iBaseScene == null ? getSceneVuiState() : iBaseScene.getSceneVuiState();
            if (L.ENABLE) {
                L.Tag tag3 = TAG;
                L.d(tag3, "enterVuiScene vuiSceneId:" + vuiSceneId + ", scene:" + getClass().getSimpleName() + ",currentState:" + sceneVuiState2);
            }
            delayUpdateSceneAfterBuild();
        }
    }

    protected void exitVuiScene(IBaseScene iBaseScene) {
        String vuiSceneId;
        if (isSceneVuiEnabled()) {
            int sceneVuiState = iBaseScene == null ? getSceneVuiState() : iBaseScene.getSceneVuiState();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "exitVuiScene specify scene:" + iBaseScene + ",currentState:" + sceneVuiState);
            }
            if (iBaseScene == null) {
                vuiSceneId = getVuiSceneId();
            } else {
                vuiSceneId = iBaseScene.getVuiSceneId();
            }
            if (this.mSceneVuiStateMap.get((Object) vuiSceneId).intValue() == 3) {
                L.Tag tag2 = TAG;
                L.w(tag2, "exitVuiScene failure already exit，vuiSceneId:" + vuiSceneId + ", scene:" + getClass().getSimpleName());
                return;
            }
            if (iBaseScene == null) {
                setSceneVuiState(3);
            } else {
                iBaseScene.setSceneVuiState(3);
            }
            VoiceFullScenesUtil.exitScene(vuiSceneId);
            int sceneVuiState2 = iBaseScene == null ? getSceneVuiState() : iBaseScene.getSceneVuiState();
            if (L.ENABLE) {
                L.Tag tag3 = TAG;
                L.d(tag3, "exitVuiScene vuiSceneId:" + vuiSceneId + ", scene:" + getClass().getSimpleName() + ",currentState:" + sceneVuiState2);
            }
        }
    }

    @Override // com.xiaopeng.vui.commons.IVuiSceneListener
    public void onVuiEvent(View view, VuiEvent vuiEvent) {
        if (isSceneLegal() && isSceneVuiEnabled()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatVoiceFullScenesLog("onVuiEvent view:" + view + ",vuiEvent:" + vuiEvent));
            }
            CommonVuiHelper.getInstance().executeVuiEventBaseOperation(this, view);
            VoiceFullScenesUtil.showVuiAnimation(view);
            MapVuiHelper.getInstance().dispatchVuiEvent(this.mMainContext, view, vuiEvent);
        }
    }

    @Override // com.xiaopeng.vui.commons.IVuiSceneListener
    public boolean onInterceptVuiEvent(View view, VuiEvent vuiEvent) {
        if (isSceneLegal() && isSceneVuiEnabled()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatVoiceFullScenesLog("onInterceptVuiEvent view:" + view + ",vuiEvent:" + vuiEvent));
            }
            CommonVuiHelper.getInstance().executeVuiEventBaseOperation(this, view);
            if (CommonVuiHelper.getInstance().isEffectOnly(view, vuiEvent)) {
                return true;
            }
            VoiceFullScenesUtil.showVuiAnimation(view);
            return CommonVuiHelper.getInstance().handleCommonVuiEvent(view, vuiEvent, this);
        }
        return false;
    }

    @Override // com.xiaopeng.vui.commons.IVuiSceneListener
    public void onBuildScene() {
        if (isSceneLegal() && isSceneVuiEnabled()) {
            View formatRootViewForVui = formatRootViewForVui();
            final ArrayList arrayList = new ArrayList();
            if (isNeedMergeBaseMapViewForVui()) {
                arrayList.add(getMainContext().getMapSceneView());
            }
            arrayList.add(formatRootViewForVui);
            new Handler().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.base.BaseFullScenes.2
                @Override // java.lang.Runnable
                public void run() {
                    VoiceFullScenesUtil.buildScene(arrayList, BaseFullScenes.this);
                }
            }, 300L);
        }
    }

    private void delayUpdateSceneAfterBuild() {
        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.base.BaseFullScenes.3
            @Override // java.lang.Runnable
            public void run() {
                if (L.ENABLE) {
                    L.d(BaseFullScenes.TAG, "delayUpdateSceneAfterBuild");
                }
                if (BaseFullScenes.this.getTopChildScene() == null || BaseFullScenes.this.getTopChildScene().getMode() != StatusConst.Mode.SETTING) {
                    BaseFullScenes.this.updateScene();
                }
            }
        }, 500L);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void updateScene() {
        if (isSceneLegal() && isSceneVuiEnabled()) {
            VoiceFullScenesUtil.updateScene(this, formatRootViewForVui());
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean isSceneVuiInit() {
        String vuiSceneId = getVuiSceneId();
        boolean z = this.mSceneVuiStateMap.get((Object) vuiSceneId).intValue() != 0;
        if (!z) {
            L.Tag tag = TAG;
            L.w(tag, "isSceneVuiInit current state:" + this.mSceneVuiStateMap.get((Object) vuiSceneId));
        }
        return z;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean isFirstEnterScene() {
        return this.mIsFirstEnterScene;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void mockDispatchTouchEventForVui(View view) {
        if (view != null) {
            long currentTimeMillis = System.currentTimeMillis();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            MotionEvent obtain = MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, iArr[0], iArr[1], 0);
            if (getActivity() != null) {
                getActivity().dispatchTouchEvent(obtain);
            }
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "mockDispatchTouchEventForVui view:" + view + ",event:" + obtain);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void setSceneVuiState(int i) {
        this.mSceneVuiStateMap.put(getVuiSceneId(), Integer.valueOf(i));
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public int getSceneVuiState() {
        return this.mSceneVuiStateMap.get((Object) getVuiSceneId()).intValue();
    }

    protected View formatRootViewForVui() {
        return this.mContentView;
    }

    protected void vuiOperationWhenAddChildSceneBefore() {
        if (isSceneVuiEnabled()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "vuiOperationWhenAddChildSceneBefore scene:" + getClass().getSimpleName());
            }
            exitVuiScene();
        }
    }

    protected void vuiOperationWhenAddChildSceneAfter(IBaseScene iBaseScene) {
        if (isSceneVuiEnabled()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "vuiOperationWhenAddChildSceneAfter childScene:" + iBaseScene + ", scene:" + getClass().getSimpleName());
            }
            Iterator<SceneInfoStack.SceneInfo> it = this.mChildSceneInfoStack.iterator();
            while (it.hasNext()) {
                SceneInfoStack.SceneInfo next = it.next();
                if (!next.mScene.getMode().equals(iBaseScene.getMode())) {
                    exitVuiScene(next.mScene.toBaseScene());
                }
            }
        }
    }

    protected void vuiOperationWhenBackChildScene() {
        IBaseScene topChildScene;
        if (isSceneVuiEnabled()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "vuiOperationWhenBackChildScene scene:" + getClass().getSimpleName());
            }
            if (this.mChildSceneInfoStack != null && (topChildScene = getTopChildScene()) != null) {
                enterVuiScene(topChildScene);
            } else {
                enterVuiScene();
            }
        }
    }
}
