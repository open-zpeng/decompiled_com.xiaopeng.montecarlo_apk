package com.xiaopeng.montecarlo.base;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.common.model.RectInt;
import com.xiaopeng.montecarlo.DayNightFragment;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.SceneInfoStack;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.base.scene.IQueueWorker;
import com.xiaopeng.montecarlo.base.scene.IScene;
import com.xiaopeng.montecarlo.base.scene.SceneLifeScheduler;
import com.xiaopeng.montecarlo.base.scene.SceneLifeSchedulerImpl;
import com.xiaopeng.montecarlo.base.scene.WorkQueue;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.lifecycle.Lifecycle;
import com.xiaopeng.montecarlo.lifecycle.LifecycleOwner;
import com.xiaopeng.montecarlo.lifecycle.SceneLifecycle;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapStatus;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.TraceUtils;
import com.xiaopeng.montecarlo.scenes.mapscene.MapUIStatus;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import com.xiaopeng.montecarlo.speech.command.ISpeechEvent;
import com.xiaopeng.montecarlo.util.SpeechEventBizHelper;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.views.poicard.PoiCardView;
import com.xiaopeng.speech.jarvisproto.DMWait;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class BaseScene extends DayNightFragment implements LifecycleOwner, IScene, IBaseScene, ISpeechEvent {
    private static final long MULTI_CLICK_INTERVAL = 500;
    private static final L.Tag TAG = new L.Tag("BaseScene");
    View mChildSceneContainer;
    SceneInfoStack mChildSceneInfoStack;
    private SceneLifeScheduler mChildSceneLifeScheduler;
    protected View mContentView;
    private long mLastClickTime;
    protected MainContext mMainContext;
    private View.OnAttachStateChangeListener mOnAttachStateChangeListener;
    protected ViewStub mPoiViewStub;
    private ScenesManager mScenesManager;
    ViewStub mTrafficIncidentStub;
    private WorkQueue mWorkQueue;
    protected final SpeechEventBizHelper mSpeechEventBizHelper = new SpeechEventBizHelper();
    private final SceneLifecycle mSceneLifecycle = new SceneLifecycle();
    protected boolean mIsCreated = false;
    protected BaseBridge mBridge = null;
    protected Bundle mResultBundle = null;
    protected Bundle mSavedSceneState = new Bundle();
    protected RectInt mFreeBound = new RectInt();
    protected int mOriginMapLeftOffset = 0;
    protected int mOriginMapTopOffset = 0;
    protected MapUIStatus mSavedMapUi = null;
    protected MapUIStatus mUsedMapUi = null;
    protected MapStatus mMapStatus = null;
    protected MapStatus mRestoreMapStatus = null;
    IScene mParentScene = null;
    boolean mIsFirstScene = false;
    private int mSceneId = 0;
    private int mContentViewID = -1;
    private boolean mNeedCallViewCreated = false;
    private boolean mNeedDestroyView = false;
    private boolean mNeedCallNewBridge = false;
    private boolean mIsSavedRestore = false;
    private boolean mBackResultDelay = false;
    private int mDelayBackResultCode = 0;
    private Bundle mDelayBackResultBundle = null;
    private boolean mIsCommitShow = false;
    private Runnable mRestartSceneRunn = null;
    private boolean mIsAttach = false;

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public PoiCardView getPoiCard() {
        return null;
    }

    public final BaseScene getScene() {
        return this;
    }

    public int getSceneVuiState() {
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public int getSearchDest() {
        return 1000;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public int getSearchMode() {
        return 100;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public ISpeechEvent getSpeechEvent() {
        return this;
    }

    public boolean isFirstEnterScene() {
        return false;
    }

    public boolean isFullscreen() {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean isMultipleSearchResult() {
        return false;
    }

    public boolean isSceneVuiEnabled() {
        return false;
    }

    public boolean isSceneVuiInit() {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean isSearchResultFragSinglePoi(XPPoiInfo xPPoiInfo) {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean isShowFavorite() {
        return false;
    }

    public void mockDispatchTouchEventForVui(View view) {
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean onBackPressed() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onBackResult(int i, Bundle bundle) {
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void onMotionEvent(long j, int i, long j2, long j3) {
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void onMoveBegin(long j, long j2) {
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void onMoveEnd(long j, long j2) {
    }

    protected abstract View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSceneDetach() {
    }

    public boolean onSceneSaveInstanceState(Bundle bundle) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MapStatus pickupRestoreMapStatusByRequestCodeDelegate(MapStatus mapStatus, MapStatus mapStatus2, int i) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setBackMapStatusByRequestCodeDelegate(@NonNull MapStatus mapStatus, int i) {
    }

    public void setSceneVuiState(int i) {
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public IBaseScene toBaseScene() {
        return this;
    }

    public void updateScene() {
    }

    public BaseScene() {
        RectInt rectInt = this.mFreeBound;
        rectInt.left = 0;
        rectInt.top = ContextUtils.getDimensionPixelSize(R.dimen.scene_margin);
        this.mFreeBound.right = RootUtil.getScreenWidth();
        this.mFreeBound.bottom = RootUtil.getVisibleBottom();
    }

    private static void checkChildSceneAndCover(IScene iScene, IBaseScene iBaseScene) {
        if (iScene == null || iBaseScene == null) {
            return;
        }
        if (iScene.getParent() != null && iBaseScene.getParentScene() != null) {
            checkChildSceneAndCover(iScene.getParent(), iBaseScene.getParentScene());
        } else if (iBaseScene.getChildSceneContainer() != null && iBaseScene.getSceneContainer() != null) {
            if (iScene.hasChildScene()) {
                iBaseScene.getChildSceneContainer().setVisibility(0);
                for (int i = 0; i < iScene.getChildStackSize(); i++) {
                    if (iScene.getChildSceneInfoStack().get(i).mScene.toBaseScene().showCover()) {
                        iBaseScene.getChildSceneContainer().setBackground(ThemeWatcherUtil.getDrawable(R.drawable.png_mask_map));
                        iBaseScene.getSceneContainer().setBackground(null);
                        return;
                    }
                }
                iBaseScene.getChildSceneContainer().setBackground(null);
            } else {
                iBaseScene.getChildSceneContainer().setVisibility(8);
            }
            if (iBaseScene.showCover()) {
                iBaseScene.getSceneContainer().setBackground(ThemeWatcherUtil.getDrawable(R.drawable.png_mask_map));
            } else {
                iBaseScene.getSceneContainer().setBackground(null);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public void update(SceneState sceneState) {
        this.mSceneId = sceneState.mSceneId;
        this.mResultBundle = sceneState.mResultBundle;
        this.mSavedSceneState = sceneState.mSavedSceneState;
        Bundle bundle = this.mSavedSceneState;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        this.mSavedMapUi = sceneState.mSavedMapUi;
        this.mUsedMapUi = sceneState.mUsedMapUi;
        this.mMapStatus = sceneState.mMapStatus;
        this.mRestoreMapStatus = sceneState.mRestoreMapStatus;
        this.mIsSavedRestore = true;
        this.mIsCreated = sceneState.mIsCreated;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public int getSceneId() {
        return this.mSceneId;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public void setSceneId(int i) {
        this.mSceneId = i;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public boolean isCreated() {
        return this.mIsCreated;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public boolean isAttach() {
        return this.mIsAttach;
    }

    @NonNull
    public MapViewWrapper getMapView() {
        return getMainContext().getMapView();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public void addChildScene(@NonNull IScene iScene) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "addChildScene " + iScene.getClass().getSimpleName() + " to:" + getClass().getSimpleName());
        }
        if (this.mChildSceneInfoStack == null) {
            this.mChildSceneInfoStack = new SceneInfoStack();
        }
        if (this.mChildSceneLifeScheduler == null && isAdded() && !isDetached()) {
            this.mChildSceneLifeScheduler = new SceneLifeScheduler(new SceneLifeSchedulerImpl(getChildFragmentManager()));
        }
        iScene.setContentViewID(R.id.child_scene);
        SceneInfoStack.SceneInfo sceneInfo = new SceneInfoStack.SceneInfo(iScene);
        onChildSceneReadyToAdd(sceneInfo.mScene.toBaseScene());
        sceneInfo.mScene.setParentScene(this);
        this.mChildSceneInfoStack.push(sceneInfo);
        if (isAdded() && !isDetached()) {
            iScene.showScene(this.mChildSceneLifeScheduler);
        }
        onChildSceneAdded(iScene.toBaseScene());
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public SceneInfoStack getChildSceneInfoStack() {
        return this.mChildSceneInfoStack;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public final boolean hasChildScene() {
        SceneInfoStack sceneInfoStack = this.mChildSceneInfoStack;
        return sceneInfoStack != null && sceneInfoStack.size() > 0;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final boolean hasChildMode(StatusConst.Mode mode) {
        SceneInfoStack sceneInfoStack = this.mChildSceneInfoStack;
        if (sceneInfoStack != null) {
            Iterator<SceneInfoStack.SceneInfo> it = sceneInfoStack.iterator();
            while (it.hasNext()) {
                if (it.next().mMode == mode) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final SceneInfoStack.SceneInfo findChildByMode(StatusConst.Mode mode) {
        SceneInfoStack sceneInfoStack = this.mChildSceneInfoStack;
        if (sceneInfoStack != null) {
            Iterator<SceneInfoStack.SceneInfo> it = sceneInfoStack.iterator();
            while (it.hasNext()) {
                SceneInfoStack.SceneInfo next = it.next();
                if (next.mMode == mode) {
                    return next;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public final IBaseScene getTopChildScene() {
        int size;
        SceneInfoStack sceneInfoStack = this.mChildSceneInfoStack;
        if (sceneInfoStack == null || (size = sceneInfoStack.size()) <= 0) {
            return null;
        }
        return this.mChildSceneInfoStack.get(size - 1).mScene.toBaseScene();
    }

    public final IBaseScene getSceneByType(PageType pageType) {
        if (isChildScene() && this.mParentScene.hasChildScene()) {
            for (int size = this.mParentScene.getChildSceneInfoStack().size() - 1; size >= 0; size--) {
                SceneInfoStack.SceneInfo sceneInfo = this.mParentScene.getChildSceneInfoStack().get(size);
                if (sceneInfo.mScene.getPageType() == pageType) {
                    return sceneInfo.mScene.toBaseScene();
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public BaseBridge getBridge() {
        return this.mBridge;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public void setBridge(BaseBridge baseBridge) {
        L.i(TAG, "setBridge");
        if (baseBridge == null) {
            throw new RuntimeException("setBridge NULL");
        }
        this.mBridge = baseBridge;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public int getContentViewID() {
        return this.mContentViewID;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public void setContentViewID(int i) {
        this.mContentViewID = i;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public StatusConst.Mode getMode() {
        return this.mBridge.getMode();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void backToMode(StatusConst.Mode mode, boolean z) {
        this.mScenesManager.backToMode(mode, z);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void backToLastMode(StatusConst.Mode mode, boolean z) {
        this.mScenesManager.backToLastMode(mode, z);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public final void startScene(BaseBridge baseBridge, int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "startScene:" + getClass().getSimpleName() + ", requestCode: " + i);
        }
        getMainContext().startScene(this, baseBridge, i);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public final void startScene(BaseBridge baseBridge) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "startScene:" + getClass().getSimpleName());
        }
        getMainContext().startScene(this, baseBridge, 0);
    }

    public final void setOnAttachStateChangeListener(@NonNull View.OnAttachStateChangeListener onAttachStateChangeListener) {
        this.mOnAttachStateChangeListener = onAttachStateChangeListener;
        View view = this.mContentView;
        if (view != null) {
            view.addOnAttachStateChangeListener(this.mOnAttachStateChangeListener);
            if (this.mContentView.isAttachedToWindow()) {
                this.mOnAttachStateChangeListener.onViewAttachedToWindow(this.mContentView);
            }
        }
    }

    public final void removeOnAttachStateChangeListener() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        View view = this.mContentView;
        if (view != null && (onAttachStateChangeListener = this.mOnAttachStateChangeListener) != null) {
            view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        this.mOnAttachStateChangeListener = null;
    }

    private void removeAllRunTimeHandlerMsg() {
        ScenesManager scenesManager = this.mScenesManager;
        if (scenesManager != null) {
            scenesManager.getRunTimeHandler().removeCallbacksAndMessages(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (L.ENABLE) {
            L.d(TAG, "onAttach:" + getClass().getSimpleName());
        }
        this.mIsAttach = true;
        this.mWorkQueue = new WorkQueue(this, this.mScenesManager.getRunTimeHandler());
        try {
            onSceneAttach(context);
        } catch (Exception e) {
            String str = "onSceneAttach Exception:" + getClass().getSimpleName();
            L.e(TAG, str);
            L.printStackTrace(TAG, e);
            if (!RootUtil.isUserVersion() || RootUtil.isTabletApp()) {
                showPrompt(str);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.DayNightFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (L.ENABLE) {
            L.d(TAG, "onCreate:" + getClass().getSimpleName());
        }
        this.mIsCreated = true;
        TraceUtils.alwaysTraceBegin("onSceneCreate:" + getClass().getName());
        if (this.mBridge == null) {
            throw new RuntimeException("Scene has null bridge.");
        }
        MapUIStatus mapUIStatus = this.mSavedMapUi;
        if (mapUIStatus != null) {
            this.mMainContext.updateUIStatus(mapUIStatus);
        }
        saveMapUI(null);
        if (this.mParentScene == null && this.mMapStatus == null) {
            this.mMapStatus = getMapView().storeMapState();
            if (L.ENABLE) {
                L.d(TAG, getClass().getSimpleName() + " storeMapState ==>  " + this.mMapStatus);
            }
        }
        try {
            onSceneCreate(this.mIsSavedRestore ? this.mSavedSceneState : null);
        } catch (Exception e) {
            String str = "onSceneCreate Exception:" + getClass().getSimpleName();
            L.e(TAG, str);
            L.printStackTrace(TAG, e);
            if (!RootUtil.isUserVersion() || RootUtil.isTabletApp()) {
                showPrompt(str);
            }
        }
        TraceUtils.alwaysTraceEnd();
    }

    private void saveOriginMapOffset() {
        this.mOriginMapLeftOffset = getMapView().getDefaultMapViewLeft();
        this.mOriginMapTopOffset = getMapView().getDefaultMapViewTop();
        L.Tag tag = TAG;
        L.i(tag, "save origin map offset left:" + this.mOriginMapLeftOffset + ",top:" + this.mOriginMapTopOffset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.DayNightFragment, java.lang.Object] */
    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        if (L.ENABLE) {
            L.d(TAG, "onCreateView:" + getClass().getSimpleName());
        }
        TraceUtils.alwaysTraceBegin("onSceneCreateView:" + getClass().getName());
        if (this.mContentView == null) {
            LinearLayout linearLayout = null;
            linearLayout = null;
            this.mContentView = (ViewGroup) layoutInflater.inflate(R.layout.base_scene_root, (ViewGroup) null);
            ViewGroup viewGroup2 = (ViewGroup) this.mContentView.findViewById(R.id.base_scene);
            this.mContentView.setTag(getPageType().name());
            if (canPoiCardShow()) {
                this.mPoiViewStub = (ViewStub) this.mContentView.findViewById(R.id.poi_pop_stub);
            }
            this.mTrafficIncidentStub = (ViewStub) this.mContentView.findViewById(R.id.map_traffic_incident_info_stub);
            this.mChildSceneContainer = this.mContentView.findViewById(R.id.child_scene);
            try {
                linearLayout = onSceneCreateView(layoutInflater, viewGroup2, this.mIsSavedRestore ? this.mSavedSceneState : null);
            } catch (Exception e) {
                String str = "onSceneCreateView Exception:" + getClass().getSimpleName();
                L.e(TAG, str);
                L.printStackTrace(TAG, e);
                if (!RootUtil.isUserVersion() || RootUtil.isTabletApp()) {
                    showPrompt(str);
                }
            }
            if (L.ENABLE) {
                L.d(TAG, "onSceneCreateView:" + getClass().getSimpleName());
            }
            if (linearLayout == null) {
                TextView textView = new TextView(getActivity());
                textView.setText(getClass().getSimpleName() + " onCreateView Error!");
                textView.setBackgroundColor(-65536);
                textView.setTextSize(40.0f);
                linearLayout = new LinearLayout(getActivity());
                linearLayout.addView(textView);
            }
            linearLayout.setSaveFromParentEnabled(false);
            if (linearLayout.getParent() == null) {
                viewGroup2.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -1));
            }
            View.OnAttachStateChangeListener onAttachStateChangeListener = this.mOnAttachStateChangeListener;
            if (onAttachStateChangeListener != null) {
                this.mContentView.addOnAttachStateChangeListener(onAttachStateChangeListener);
            }
            this.mNeedCallViewCreated = true;
        }
        dispatch(Lifecycle.Event.ON_CREATE);
        TraceUtils.alwaysTraceEnd();
        return this.mContentView;
    }

    @Override // com.xiaopeng.montecarlo.DayNightFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (L.ENABLE) {
            L.d(TAG, "onViewCreated:" + getClass().getSimpleName());
        }
        TraceUtils.alwaysTraceBegin("onSceneViewCreated:" + getClass().getName());
        if (this.mNeedCallViewCreated) {
            try {
                onSceneViewCreated(view, this.mIsSavedRestore ? this.mSavedSceneState : null);
            } catch (Exception e) {
                String str = "onSceneViewCreated Exception:" + getClass().getSimpleName();
                L.e(TAG, str);
                L.printStackTrace(TAG, e);
                if (!RootUtil.isUserVersion() || RootUtil.isTabletApp()) {
                    showPrompt(str);
                }
            }
            this.mNeedCallViewCreated = false;
        }
        TraceUtils.alwaysTraceEnd();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        if (L.ENABLE) {
            L.d(TAG, "onActivityCreated:" + getClass().getSimpleName());
        }
        TraceUtils.alwaysTraceBegin("onSceneActivityCreated:" + getClass().getName());
        try {
            onSceneActivityCreated(this.mIsSavedRestore ? this.mSavedSceneState : null);
        } catch (Exception e) {
            String str = "onSceneActivityCreated Exception:" + getClass().getSimpleName();
            L.e(TAG, str);
            L.printStackTrace(TAG, e);
            if (!RootUtil.isUserVersion() || RootUtil.isTabletApp()) {
                showPrompt(str);
            }
        }
        if (this.mChildSceneInfoStack != null) {
            boolean z = false;
            if (this.mChildSceneLifeScheduler == null) {
                this.mChildSceneLifeScheduler = new SceneLifeScheduler(new SceneLifeSchedulerImpl(getChildFragmentManager()));
                z = true;
            }
            if (this.mIsSavedRestore || z) {
                Iterator<SceneInfoStack.SceneInfo> it = this.mChildSceneInfoStack.iterator();
                while (it.hasNext()) {
                    it.next().mScene.showScene(this.mChildSceneLifeScheduler);
                }
            }
        }
        TraceUtils.alwaysTraceEnd();
    }

    @Override // com.xiaopeng.montecarlo.DayNightFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        if (L.ENABLE) {
            L.d(TAG, "onStart:" + getClass().getSimpleName());
        }
        TraceUtils.alwaysTraceBegin("onSceneStart:" + getClass().getName());
        try {
            onSceneStart();
        } catch (Exception e) {
            String str = "onSceneStart Exception:" + getClass().getSimpleName();
            L.e(TAG, str);
            L.printStackTrace(TAG, e);
            if (!RootUtil.isUserVersion() || RootUtil.isTabletApp()) {
                showPrompt(str);
            }
        }
        TraceUtils.alwaysTraceEnd();
    }

    @Override // com.xiaopeng.montecarlo.DayNightFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        checkChildSceneAndCover(this, this);
        if (L.ENABLE) {
            L.d(TAG, "onResume:" + getClass().getSimpleName());
        }
        restorePreviousMapState();
        TraceUtils.alwaysTraceBegin("onSceneResume:" + getClass().getName());
        try {
            onSceneResume();
        } catch (Exception e) {
            String str = "onSceneResume Exception:" + getClass().getSimpleName();
            L.e(TAG, str);
            L.printStackTrace(TAG, e);
            if (!RootUtil.isUserVersion() || RootUtil.isTabletApp()) {
                showPrompt(str);
            }
        }
        dispatch(Lifecycle.Event.ON_RESUME);
        SceneInfoStack sceneInfoStack = this.mChildSceneInfoStack;
        if (sceneInfoStack != null && this.mChildSceneLifeScheduler != null) {
            Iterator<SceneInfoStack.SceneInfo> it = sceneInfoStack.iterator();
            while (it.hasNext()) {
                IScene iScene = it.next().mScene;
                if (!iScene.isAdded()) {
                    iScene.showScene(this.mChildSceneLifeScheduler);
                }
            }
        }
        TraceUtils.alwaysTraceEnd();
        if (this.mNeedCallNewBridge) {
            this.mNeedCallNewBridge = false;
            TraceUtils.alwaysTraceBegin("onSceneNewBridge:" + getClass().getName());
            try {
                onSceneNewBridge(getBridge());
            } catch (Exception e2) {
                String str2 = "onSceneNewBridge Exception:" + getClass().getSimpleName();
                L.e(TAG, str2);
                L.printStackTrace(TAG, e2);
                if (!RootUtil.isUserVersion() || RootUtil.isTabletApp()) {
                    showPrompt(str2);
                }
            }
            if (L.ENABLE) {
                L.d(TAG, "onSceneNewBridge:" + getClass().getSimpleName());
            }
            TraceUtils.alwaysTraceEnd();
        }
        if (this.mBackResultDelay) {
            this.mBackResultDelay = false;
            try {
                onBackResult(this.mDelayBackResultCode, this.mDelayBackResultBundle);
            } catch (Exception e3) {
                String str3 = "onBackResult Exception:" + getClass().getSimpleName();
                L.e(TAG, str3);
                L.printStackTrace(TAG, e3);
                if (!RootUtil.isUserVersion() || RootUtil.isTabletApp()) {
                    showPrompt(str3);
                }
            }
        }
        if (Utils.isLandscape()) {
            saveOriginMapOffset();
        }
    }

    protected void restorePreviousMapState() {
        if (this.mRestoreMapStatus != null) {
            getMapView().restoreMapState(this.mRestoreMapStatus);
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, getClass().getSimpleName() + " restorePreviousMapState ==> " + this.mRestoreMapStatus);
            }
            this.mRestoreMapStatus = null;
        } else if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, getClass().getSimpleName() + " mRestoreMapStatus is null, restorePreviousMapState do nothing !");
        }
    }

    @Override // com.xiaopeng.montecarlo.DayNightFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        checkChildSceneAndCover(this, this);
        if (L.ENABLE) {
            L.d(TAG, "onPause:" + getClass().getSimpleName());
        }
        TraceUtils.alwaysTraceBegin("onScenePause:" + getClass().getName());
        try {
            onScenePause();
        } catch (Exception e) {
            String str = "onScenePause Exception:" + getClass().getSimpleName();
            L.e(TAG, str);
            L.printStackTrace(TAG, e);
            if (!RootUtil.isUserVersion() || RootUtil.isTabletApp()) {
                showPrompt(str);
            }
        }
        dispatch(Lifecycle.Event.ON_PAUSE);
        TraceUtils.alwaysTraceEnd();
    }

    @Override // com.xiaopeng.montecarlo.DayNightFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        if (L.ENABLE) {
            L.d(TAG, "onStop:" + getClass().getSimpleName());
        }
        TraceUtils.alwaysTraceBegin("onSceneStop:" + getClass().getName());
        try {
            onSceneStop();
        } catch (Exception e) {
            String str = "onSceneStop Exception:" + getClass().getSimpleName();
            L.e(TAG, str);
            L.printStackTrace(TAG, e);
            if (!RootUtil.isUserVersion() || RootUtil.isTabletApp()) {
                showPrompt(str);
            }
        }
        TraceUtils.alwaysTraceEnd();
    }

    protected void restoreMapOffset() {
        int mapViewLeft = getMapView().getMapViewLeft();
        int mapViewTop = getMapView().getMapViewTop();
        if (mapViewLeft != this.mOriginMapLeftOffset || mapViewTop != this.mOriginMapTopOffset) {
            L.Tag tag = TAG;
            L.i(tag, "restore map offset left:" + this.mOriginMapLeftOffset + ",top:" + this.mOriginMapTopOffset);
            getMapView().setMapViewLeftTop(this.mOriginMapLeftOffset, this.mOriginMapTopOffset);
        }
        this.mOriginMapLeftOffset = 0;
        this.mOriginMapTopOffset = 0;
    }

    @Override // com.xiaopeng.montecarlo.DayNightFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        SceneInfoStack sceneInfoStack;
        super.onDestroyView();
        if (getActivity() != null && getActivity().isFinishing()) {
            L.i(TAG, "onDestroyView activity finishing need to destroy scene:" + this);
            this.mNeedDestroyView = true;
        }
        if (L.ENABLE) {
            L.d(TAG, "onDestroyView:" + getClass().getSimpleName() + ",mNeedDestroyView:" + this.mNeedDestroyView);
        }
        Runnable runnable = this.mRestartSceneRunn;
        if (runnable != null) {
            runnable.run();
        }
        if (this.mNeedDestroyView) {
            this.mNeedDestroyView = false;
            if (this.mContentView != null) {
                TraceUtils.alwaysTraceBegin("onSceneDestroyView:" + getClass().getName());
                try {
                    onSceneDestroyView();
                } catch (Exception e) {
                    String str = "onSceneStop Exception:" + getClass().getSimpleName();
                    L.e(TAG, str);
                    L.printStackTrace(TAG, e);
                    if (!RootUtil.isUserVersion() || RootUtil.isTabletApp()) {
                        showPrompt(str);
                    }
                }
                if (L.ENABLE) {
                    L.d(TAG, "onDestroyView onSceneDestroyView:" + getClass().getSimpleName());
                }
                dispatch(Lifecycle.Event.ON_DESTROY);
                TraceUtils.alwaysTraceEnd();
                removeOnAttachStateChangeListener();
                this.mContentView = null;
                this.mPoiViewStub = null;
                this.mTrafficIncidentStub = null;
                this.mChildSceneContainer = null;
                removeAllRunTimeHandlerMsg();
            }
        }
        if ((!this.mBridge.isOverMode() || this.mIsFirstScene) && (sceneInfoStack = this.mChildSceneInfoStack) != null) {
            Iterator<SceneInfoStack.SceneInfo> it = sceneInfoStack.iterator();
            while (it.hasNext()) {
                SceneInfoStack.SceneInfo next = it.next();
                if (next.mScene.getBridge().isOverNotHideMode()) {
                    it.remove();
                    if (this.mChildSceneLifeScheduler != null) {
                        next.mScene.removeScene(this.mChildSceneLifeScheduler);
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (L.ENABLE) {
            L.d(TAG, "onDestroy:" + getClass().getSimpleName());
        }
        if (this.mContentView != null) {
            TraceUtils.alwaysTraceBegin("onSceneDestroyView:" + getClass().getName());
            try {
                onSceneDestroyView();
            } catch (Exception e) {
                String str = "onSceneDestroyView Exception:" + getClass().getSimpleName();
                L.e(TAG, str);
                L.printStackTrace(TAG, e);
                if (!RootUtil.isUserVersion() || RootUtil.isTabletApp()) {
                    showPrompt(str);
                }
            }
            if (L.ENABLE) {
                L.d(TAG, "onDestroy onSceneDestroyView:" + getClass().getSimpleName());
            }
            dispatch(Lifecycle.Event.ON_DESTROY);
            TraceUtils.alwaysTraceEnd();
            removeOnAttachStateChangeListener();
            this.mContentView = null;
            removeAllRunTimeHandlerMsg();
        }
        TraceUtils.alwaysTraceBegin("onSceneDestroy:" + getClass().getName());
        try {
            onSceneDestroy();
        } catch (Exception e2) {
            String str2 = "onSceneDestroy Exception:" + getClass().getSimpleName();
            L.e(TAG, str2);
            L.printStackTrace(TAG, e2);
            if (!RootUtil.isUserVersion() || RootUtil.isTabletApp()) {
                showPrompt(str2);
            }
        }
        TraceUtils.alwaysTraceEnd();
        SceneInfoStack sceneInfoStack = this.mChildSceneInfoStack;
        if (sceneInfoStack != null) {
            sceneInfoStack.clear();
            this.mChildSceneInfoStack = null;
        }
        SceneLifecycle sceneLifecycle = this.mSceneLifecycle;
        if (sceneLifecycle != null) {
            sceneLifecycle.removeAllObserver();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        if (L.ENABLE) {
            L.d(TAG, "onDetach:" + getClass().getSimpleName());
        }
        this.mIsAttach = false;
        try {
            onSceneDetach();
        } catch (Exception e) {
            String str = "onDetach Exception:" + getClass().getSimpleName();
            L.e(TAG, str);
            L.printStackTrace(TAG, e);
            if (!RootUtil.isUserVersion() || RootUtil.isTabletApp()) {
                showPrompt(str);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final void onNewBridge(BaseBridge baseBridge) {
        if (L.ENABLE) {
            L.d(TAG, "onNewBridge:" + getClass().getSimpleName());
        }
        try {
            onSceneNewBridge(baseBridge);
        } catch (Exception e) {
            String str = "onSceneNewBridge Exception:" + getClass().getSimpleName();
            L.e(TAG, str);
            L.printStackTrace(TAG, e);
            if (!RootUtil.isUserVersion() || RootUtil.isTabletApp()) {
                showPrompt(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSceneAttach(Context context) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onSceneAttach:" + getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSceneCreate(@Nullable Bundle bundle) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onSceneCreate:" + getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSceneNewBridge(BaseBridge baseBridge) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onSceneNewBridge:" + getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSceneViewCreated(View view, @Nullable Bundle bundle) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onSceneViewCreated:" + getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSceneActivityCreated(@Nullable Bundle bundle) {
        if (L.ENABLE) {
            L.d(TAG, "onSceneActivityCreated");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSceneStart() {
        if (L.ENABLE) {
            L.d(TAG, "onSceneStart");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSceneResume() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onSceneResume:" + getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChildSceneReadyToAdd(IBaseScene iBaseScene) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onChildSceneReadyToAdd childScene:" + iBaseScene + ",scene:" + getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChildSceneAdded(IBaseScene iBaseScene) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onChildSceneAdded childScene:" + iBaseScene + ",scene:" + getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onScenePause() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onScenePause:" + getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSceneStop() {
        if (L.ENABLE) {
            L.d(TAG, "onSceneStop");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSceneDestroyView() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onSceneDestroyView:" + getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSceneDestroy() {
        if (L.ENABLE) {
            L.d(TAG, "onSceneDestroy");
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    @Nullable
    public View getSceneContentView() {
        View view = this.mContentView;
        if (view != null) {
            return ((ViewGroup) view.findViewById(R.id.base_scene)).getChildAt(0);
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.DayNightFragment, com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
    public void onThemeSwitch(int i) {
        super.onThemeSwitch(i);
        checkChildSceneAndCover(this, this);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public View getSceneContainer() {
        return this.mContentView;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public View getChildSceneContainer() {
        return this.mChildSceneContainer;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public ViewGroup getBaseView() {
        View view = this.mContentView;
        if (view != null) {
            return (ViewGroup) view.findViewById(R.id.base_scene);
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public void backResult(int i, Bundle bundle) {
        if (L.ENABLE) {
            L.d(TAG, "backResult:" + getClass().getSimpleName() + "  requestCode:" + i);
        }
        if (isSceneLegal()) {
            try {
                onBackResult(i, bundle);
                return;
            } catch (Exception e) {
                String str = "onDetach Exception:" + getClass().getSimpleName();
                L.e(TAG, str);
                L.printStackTrace(TAG, e);
                if (!RootUtil.isUserVersion() || RootUtil.isTabletApp()) {
                    showPrompt(str);
                    return;
                }
                return;
            }
        }
        this.mBackResultDelay = true;
        this.mDelayBackResultCode = i;
        this.mDelayBackResultBundle = bundle;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final void onSaveState(Bundle bundle) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onSaveState:" + getClass().getSimpleName());
        }
        if (onSceneSaveInstanceState(bundle)) {
            bundle.putBoolean("scene:save_enable", true);
        } else {
            bundle.putBoolean("scene:save_enable", false);
        }
    }

    public void saveHoldString(String str, String str2) {
        this.mSavedSceneState.putString(str, str2);
    }

    public String getHoldString(String str, String str2) {
        return this.mSavedSceneState.getString(str, str2);
    }

    public void saveHoldBoolean(String str, boolean z) {
        this.mSavedSceneState.putBoolean(str, z);
    }

    public boolean getHoldBoolean(String str, boolean z) {
        return this.mSavedSceneState.getBoolean(str, z);
    }

    public void saveHoldLong(String str, long j) {
        this.mSavedSceneState.putLong(str, j);
    }

    public long getHoldLong(String str, long j) {
        return this.mSavedSceneState.getLong(str, j);
    }

    public void saveHoldInt(String str, int i) {
        this.mSavedSceneState.putInt(str, i);
    }

    public int getHoldInt(String str, int i) {
        return this.mSavedSceneState.getInt(str, i);
    }

    public void saveHoldDouble(String str, double d) {
        this.mSavedSceneState.putDouble(str, d);
    }

    public double getHoldDouble(String str, double d) {
        return this.mSavedSceneState.getDouble(str, d);
    }

    public void saveHoldParcelable(@Nullable String str, @Nullable Parcelable parcelable) {
        this.mSavedSceneState.putParcelable(str, parcelable);
    }

    public Parcelable getHoldParcelable(String str) {
        return this.mSavedSceneState.getParcelable(str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public void showScene(SceneLifeScheduler sceneLifeScheduler) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "showScene:" + getClass().getSimpleName());
        }
        if (this.mRestartSceneRunn != null) {
            if (L.ENABLE) {
                L.d(TAG, "showScene return for is restartScene !");
            }
        } else if (this.mBridge.getMode() == StatusConst.Mode.EMPTY) {
        } else {
            if (this.mIsCommitShow) {
                if (L.ENABLE) {
                    L.d(TAG, "showScene return for is commited!");
                    return;
                }
                return;
            }
            if (isHidden()) {
                sceneLifeScheduler.show(this);
            } else if (isDetached()) {
                sceneLifeScheduler.attach(this);
            } else if (!isAdded()) {
                sceneLifeScheduler.add(getContentViewID(), this);
            }
            this.mIsCommitShow = true;
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public void hideScene(SceneLifeScheduler sceneLifeScheduler) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "hideScene:" + getClass().getSimpleName());
        }
        if (Utils.isLandscape()) {
            restoreMapOffset();
        }
        if (this.mBridge.getMode() == StatusConst.Mode.EMPTY) {
            return;
        }
        if ((isDetached() || !isAdded()) && !this.mIsCommitShow) {
            return;
        }
        sceneLifeScheduler.detach(this);
        this.mIsCommitShow = false;
        if (L.ENABLE) {
            L.d(TAG, "commit hideScene");
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public void restartScene(final SceneLifeScheduler sceneLifeScheduler) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "restartScene:" + getClass().getSimpleName());
        }
        if (this.mBridge.getMode() == StatusConst.Mode.EMPTY || isDetached()) {
            return;
        }
        hideScene(sceneLifeScheduler);
        this.mRestartSceneRunn = new Runnable() { // from class: com.xiaopeng.montecarlo.base.BaseScene.1
            @Override // java.lang.Runnable
            public void run() {
                BaseScene.this.mRestartSceneRunn = null;
                BaseScene.this.showScene(sceneLifeScheduler);
            }
        };
    }

    public void removeScene(@NonNull SceneLifeScheduler sceneLifeScheduler) {
        if (L.ENABLE) {
            L.d(TAG, "removeScene:" + getClass().getSimpleName());
        }
        if (this.mBridge.getMode() == StatusConst.Mode.EMPTY) {
            return;
        }
        if (!isDetached() || !isAdded()) {
            restoreMapUI();
        }
        if (this.mBackResultDelay) {
            this.mBackResultDelay = false;
            try {
                onBackResult(this.mDelayBackResultCode, this.mDelayBackResultBundle);
            } catch (Exception e) {
                String str = "onBackResult Exception:" + getClass().getSimpleName();
                L.e(TAG, str);
                L.printStackTrace(TAG, e);
                if (!RootUtil.isUserVersion() || RootUtil.isTabletApp()) {
                    showPrompt(str);
                }
            }
        }
        Bundle bundle = this.mResultBundle;
        if (bundle != null) {
            this.mBridge.onSceneResult(bundle, this.mScenesManager);
        }
        removeAllChildScene();
        sceneLifeScheduler.remove(this);
        IScene iScene = this.mParentScene;
        if (iScene != null) {
            iScene.toBaseScene().onChildSceneRemoved(this);
        }
    }

    public void onChildSceneRemoved(IScene iScene) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onChildSceneRemoved childScene:" + iScene + ",scene:" + getClass().getSimpleName());
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public final void removeAllChildScene() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "removeAllChildScene:" + getClass().getSimpleName());
        }
        SceneInfoStack sceneInfoStack = this.mChildSceneInfoStack;
        if (sceneInfoStack != null) {
            if (this.mChildSceneLifeScheduler == null) {
                sceneInfoStack.clear();
                return;
            }
            Iterator<SceneInfoStack.SceneInfo> it = sceneInfoStack.iterator();
            while (it.hasNext()) {
                it.remove();
                it.next().mScene.removeScene(this.mChildSceneLifeScheduler);
            }
            this.mChildSceneInfoStack.clear();
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public final void removeChildScene(@NonNull IBaseScene iBaseScene) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "removeChildScene:" + getClass().getSimpleName() + "   child:" + iBaseScene.getClass().getSimpleName());
        }
        SceneInfoStack sceneInfoStack = this.mChildSceneInfoStack;
        if (sceneInfoStack != null && this.mChildSceneLifeScheduler != null) {
            SceneInfoStack.SceneInfo findBySceneId = sceneInfoStack.findBySceneId(iBaseScene.getSceneId(), false);
            if (findBySceneId != null) {
                this.mChildSceneInfoStack.remove(findBySceneId);
                findBySceneId.mScene.removeScene(this.mChildSceneLifeScheduler);
                return;
            }
            L.w(TAG, "removeChildScene info is null");
            removeFromFragmentManager(iBaseScene);
            return;
        }
        L.w(TAG, "removeChildScene mChildSceneInfoStack is null or mChildSceneLifeScheduler is null");
    }

    private void removeFromFragmentManager(IBaseScene iBaseScene) {
        int sceneId = iBaseScene.getSceneId();
        BaseScene findSceneById = this.mChildSceneLifeScheduler.findSceneById(sceneId);
        if (findSceneById == null) {
            sceneId = iBaseScene.getContentViewID();
            findSceneById = this.mChildSceneLifeScheduler.findSceneById(sceneId);
        }
        L.Tag tag = TAG;
        L.i(tag, "removeChildScene find fragment by id:" + sceneId + " is " + findSceneById);
        if (findSceneById != null) {
            L.Tag tag2 = TAG;
            L.i(tag2, "removeChildScene remove fragment:" + findSceneById + " from fragment manager");
            this.mChildSceneLifeScheduler.remove(findSceneById);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public void enableNeedDestoryView() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "enableNeedDestoryView:" + getClass().getSimpleName());
        }
        this.mNeedDestroyView = true;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public void enableNeedCallNewBridge() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "enableNeedCallNewBridge:" + getClass().getSimpleName());
        }
        this.mNeedCallNewBridge = true;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final SceneInfoStack.SceneInfo findChildSceneById(int i) {
        SceneInfoStack sceneInfoStack = this.mChildSceneInfoStack;
        if (sceneInfoStack != null) {
            return sceneInfoStack.findBySceneId(i, false);
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public final boolean backChildScene() {
        SceneInfoStack.SceneInfo pop;
        L.Tag tag = TAG;
        L.i(tag, "backChildScene " + getClass().getSimpleName());
        SceneInfoStack sceneInfoStack = this.mChildSceneInfoStack;
        if (sceneInfoStack == null || (pop = sceneInfoStack.pop()) == null) {
            return false;
        }
        L.Tag tag2 = TAG;
        L.i(tag2, "backChildScene " + pop.mScene + " from:" + getClass().getSimpleName());
        if (this.mChildSceneLifeScheduler != null) {
            pop.mScene.removeScene(this.mChildSceneLifeScheduler);
            return true;
        }
        return true;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final boolean backChildToMode(StatusConst.Mode mode, boolean z) {
        int i;
        SceneInfoStack.SceneInfo pop;
        if (L.ENABLE) {
            L.d(TAG, "backChildToMode:" + getClass().getSimpleName());
        }
        SceneInfoStack sceneInfoStack = this.mChildSceneInfoStack;
        if (sceneInfoStack != null) {
            int size = sceneInfoStack.size();
            int i2 = size - 1;
            while (true) {
                if (i2 < 0) {
                    i = -1;
                    break;
                } else if (this.mChildSceneInfoStack.get(i2).mScene.getMode() == mode) {
                    i = (size - i2) - 1;
                    break;
                } else {
                    i2--;
                }
            }
            if (i == 0) {
                if (z) {
                    SceneInfoStack.SceneInfo pop2 = this.mChildSceneInfoStack.pop();
                    if (this.mChildSceneLifeScheduler != null) {
                        pop2.mScene.removeScene(this.mChildSceneLifeScheduler);
                    }
                }
                return true;
            } else if (i > 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    SceneInfoStack.SceneInfo pop3 = this.mChildSceneInfoStack.pop();
                    if (pop3 != null && this.mChildSceneLifeScheduler != null) {
                        pop3.mScene.removeScene(this.mChildSceneLifeScheduler);
                    }
                }
                if (z && (pop = this.mChildSceneInfoStack.pop()) != null && this.mChildSceneLifeScheduler != null) {
                    pop.mScene.removeScene(this.mChildSceneLifeScheduler);
                }
                return true;
            }
        }
        return false;
    }

    public void removeChildAfterIndex(int i) {
        if (L.ENABLE) {
            L.d(TAG, "removeChildAfterIndex index:" + i + "  " + getClass().getSimpleName());
        }
        SceneInfoStack sceneInfoStack = this.mChildSceneInfoStack;
        if (sceneInfoStack != null) {
            int size = sceneInfoStack.size();
            if (i < 0 || i >= size || this.mChildSceneLifeScheduler == null) {
                return;
            }
            for (int i2 = size - 1; i2 >= i; i2--) {
                SceneInfoStack.SceneInfo pop = this.mChildSceneInfoStack.pop();
                if (pop != null) {
                    pop.mScene.removeScene(this.mChildSceneLifeScheduler);
                }
            }
        }
    }

    public final void stopSelf() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "stopSelf:" + getClass().getSimpleName());
        }
        ScenesManager scenesManager = this.mScenesManager;
        if (scenesManager != null) {
            scenesManager.backScene(this);
        }
    }

    public final SpeechEventBizHelper getSpeechEventBizHelper() {
        return this.mSpeechEventBizHelper;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public final void goBack() {
        L.Tag tag = TAG;
        L.i(tag, "goBack:" + getClass().getSimpleName());
        if (this.mBridge.isOverMode() && !this.mIsFirstScene) {
            if (!isCreated()) {
                L.i(TAG, "goBack but child scene was not create!!!");
                return;
            }
            IScene iScene = this.mParentScene;
            if (iScene != null && iScene.backChildScene()) {
                return;
            }
        }
        if (Utils.isCruiseScene(this) || Utils.isEmptyScene(this)) {
            L.Tag tag2 = TAG;
            L.e(tag2, "goBack error current scene can not go back:" + this);
            return;
        }
        L.printDebugStackTrace(TAG, new Error());
        this.mScenesManager.backScene(this);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public final void goToMap() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "goToMap:" + getClass().getSimpleName());
        }
        this.mScenesManager.goToMap();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void setReturnResult(Bundle bundle) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setReturnResult:" + getClass().getSimpleName());
        }
        this.mResultBundle = bundle;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public Bundle getResultBundle() {
        return this.mResultBundle;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public final int getSceneStackSize() {
        return this.mScenesManager.getSceneStackSize();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public final int getChildStackSize() {
        SceneInfoStack sceneInfoStack = this.mChildSceneInfoStack;
        if (sceneInfoStack != null) {
            return sceneInfoStack.size();
        }
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public final void removeSceneAfterIndex(int i, int i2) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "removeSceneAfterIndex:" + getClass().getSimpleName());
            L.Tag tag2 = TAG;
            L.d(tag2, "removeSceneAfterIndex index:" + i + "  childIndex:" + i2);
        }
        this.mScenesManager.removeSceneAfterIndex(i, i2);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public final boolean isPreScene(StatusConst.Mode mode) {
        return isPreScene(mode, false);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public final boolean isPreScene(StatusConst.Mode mode, boolean z) {
        return this.mScenesManager.isPreScene(mode, z);
    }

    public final BaseScene getCurrentScene() {
        return (BaseScene) this.mScenesManager.getCurrentScene();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public final StatusConst.Mode getCurrentSceneMode() {
        return this.mScenesManager.getCurrentScene().getMode();
    }

    public final MainContext getMainContext() {
        return this.mMainContext;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final void setMainContext(MainContext mainContext) {
        this.mMainContext = mainContext;
    }

    public void onClickBlank(long j, float f, float f2) {
        if (!isSceneLegal()) {
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public void setScenesManager(ScenesManager scenesManager) {
        this.mScenesManager = scenesManager;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final void saveMapUI(MapUIStatus mapUIStatus) {
        if (isSceneLegal() && this.mParentScene == null && this.mSavedMapUi == null) {
            if (mapUIStatus == null) {
                this.mSavedMapUi = this.mMainContext.getUIStatus();
            } else {
                this.mSavedMapUi = mapUIStatus;
                this.mMainContext.updateUIStatus(mapUIStatus);
            }
            MapUIStatus mapUIStatus2 = this.mSavedMapUi;
            this.mUsedMapUi = mapUIStatus2 != null ? mapUIStatus2.copy() : null;
        }
    }

    final void restoreMapUI() {
        MapUIStatus mapUIStatus;
        if (this.mParentScene == null && (mapUIStatus = this.mSavedMapUi) != null) {
            this.mMainContext.updateUIStatus(mapUIStatus);
            this.mSavedMapUi = null;
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final MapUIStatus getSavedMapUi() {
        return this.mSavedMapUi;
    }

    @MainThread
    public final void updateUIStatus(@NonNull MapUIStatus mapUIStatus) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateUIStatus:" + getClass().getSimpleName());
            L.Tag tag2 = TAG;
            L.d(tag2, "updateUIStatus:" + mapUIStatus);
        }
        this.mUsedMapUi = mapUIStatus;
        this.mMainContext.updateUIStatus(mapUIStatus);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final MapUIStatus getUIStatus() {
        MapUIStatus mapUIStatus = this.mUsedMapUi;
        return mapUIStatus != null ? mapUIStatus : this.mMainContext.getUIStatus();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final MapUIStatus getUsedMapUi() {
        return this.mUsedMapUi;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public final MapStatus getMapStatus() {
        return this.mMapStatus;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final void setMapStatus(MapStatus mapStatus) {
        this.mMapStatus = mapStatus;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final MapStatus getRestoreMapStatus() {
        return this.mRestoreMapStatus;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public final void setRestoreMapStatus(MapStatus mapStatus) {
        this.mRestoreMapStatus = mapStatus;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final Bundle getSavedSceneState() {
        return this.mSavedSceneState;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final boolean isSceneResumed() {
        return isResumed();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public final boolean isSceneLegal() {
        boolean z = (!isAdded() || isHidden() || isDetached() || getActivity() == null) ? false : true;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "isSceneLegal flag:" + z + ",scene:" + getClass().getSimpleName());
        }
        return z;
    }

    public final String sceneLegalStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("isSceneLegal ");
        sb.append("isAdded:");
        sb.append(isAdded());
        sb.append(",");
        sb.append("!isHidden:");
        sb.append(!isHidden());
        sb.append(",");
        sb.append("!isDetached:");
        sb.append(!isDetached());
        sb.append(",");
        sb.append("null != getActivity:");
        sb.append(getActivity() != null);
        sb.append(",");
        sb.append("scene:");
        sb.append(this);
        return sb.toString();
    }

    @Override // com.xiaopeng.montecarlo.DayNightFragment
    protected boolean canSwitchDayNight() {
        return isSceneLegal();
    }

    public final void runOnUiThread(Runnable runnable) {
        this.mMainContext.runOnUiThread(this, runnable, 1);
    }

    public final void runOnUiThreadDelayed(Runnable runnable, long j) {
        this.mMainContext.runOnUiThreadDelayed(this, runnable, 1, j);
    }

    public final void runOnUiThreadRelyMap(Runnable runnable) {
        this.mMainContext.runOnUiThreadRelyMap(runnable);
    }

    @Override // androidx.fragment.app.Fragment
    public final String toString() {
        return getClass().getSimpleName();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final void setBackMapStatusByRequestCode(@NonNull MapStatus mapStatus, IScene iScene, int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, getClass().getSimpleName() + " back to scene : " + iScene + " before setBackMapStatusByRequestCode " + mapStatus);
        }
        setBackMapStatusByRequestCodeDelegate(mapStatus, i);
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, getClass().getSimpleName() + " after setBackMapStatusByRequestCode " + mapStatus);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final MapStatus pickupRestoreMapStatusByRequestCode(MapStatus mapStatus, MapStatus mapStatus2, int i) {
        MapStatus pickupRestoreMapStatusByRequestCodeDelegate = pickupRestoreMapStatusByRequestCodeDelegate(mapStatus, mapStatus2, i);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, getClass().getSimpleName() + " pickupRestoreMapStatusByRequestCode lastSceneSavedMapStatus ==> " + mapStatus2 + " mapStatusFromResult ==> " + mapStatus + " requestCode : " + i + " return map status => " + pickupRestoreMapStatusByRequestCodeDelegate);
        }
        return pickupRestoreMapStatusByRequestCodeDelegate;
    }

    @Override // com.xiaopeng.montecarlo.lifecycle.LifecycleOwner
    public Lifecycle getSceneLifecycle() {
        return this.mSceneLifecycle;
    }

    private void dispatch(Lifecycle.Event event) {
        SceneLifecycle sceneLifecycle = this.mSceneLifecycle;
        if (sceneLifecycle != null) {
            sceneLifecycle.handlerDispatch(this, event);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public PageType getPageType() {
        return PageType.NAVI_CRUISE;
    }

    public final boolean preventMultiClick(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < MULTI_CLICK_INTERVAL) {
            return false;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        return true;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public final IBaseScene getParentScene() {
        IScene iScene = this.mParentScene;
        if (iScene != null) {
            return iScene.toBaseScene();
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final void setParentScene(IScene iScene) {
        this.mParentScene = iScene;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final IScene getParent() {
        return this.mParentScene;
    }

    public boolean isChildScene() {
        return this.mParentScene != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RectInt getCurrentFreeBound() {
        return this.mFreeBound;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void setFreeBound(int i, int i2, int i3, int i4) {
        RectInt rectInt = this.mFreeBound;
        rectInt.left = i;
        rectInt.top = i2;
        rectInt.right = i3;
        rectInt.bottom = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @MainThread
    public void moveViewToFreeArea(PoiCardView poiCardView) {
        if (isSceneLegal() && poiCardView != null) {
            setCardDisplayPosition(poiCardView);
            if (poiCardView.getPoiInfo() == null) {
                return;
            }
            double displayLon = poiCardView.getPoiInfo().getDisplayLon();
            double displayLat = poiCardView.getPoiInfo().getDisplayLat();
            MapViewWrapper mapView = getMapView();
            mapView.setPoiToCenter(new XPCoordinate2DDouble(displayLon, displayLat), true);
            if (Utils.isLandscape()) {
                int right = poiCardView.getRight() + (((RootUtil.getScreenWidth() - getResources().getDimensionPixelSize(R.dimen.info_flow_width)) - poiCardView.getRight()) / 2);
                int screenHeight = RootUtil.getScreenHeight() / 2;
                if (right == mapView.getMapViewLeft() && screenHeight == mapView.getMapViewTop()) {
                    return;
                }
                mapView.setMapViewLeftTop(right, screenHeight);
            } else if (mapView.getMapMode() == 0) {
                mapView.setMapProjectionCenter(0.5f, 0.7f);
            }
        }
    }

    protected void setCardDisplayPosition(View view) {
        RectInt currentFreeBound = getCurrentFreeBound();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = currentFreeBound.top;
        view.setLayoutParams(layoutParams);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public void setIsFirstScene(boolean z) {
        this.mIsFirstScene = z;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void commitQueueWorker(IQueueWorker iQueueWorker) {
        this.mWorkQueue.enqueueWorker(iQueueWorker);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void endWorker(IQueueWorker iQueueWorker) {
        this.mWorkQueue.endWorker(iQueueWorker);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public String dump() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(":{");
        sb.append("mBridge:{");
        BaseBridge baseBridge = this.mBridge;
        sb.append(baseBridge != null ? baseBridge.toString() : "null");
        sb.append("},");
        sb.append("mSceneId:{");
        sb.append(this.mSceneId);
        sb.append("},");
        sb.append("mSavedMapUi:{");
        MapUIStatus mapUIStatus = this.mSavedMapUi;
        sb.append(mapUIStatus != null ? mapUIStatus.toString() : "null");
        sb.append("},");
        sb.append("mUsedMapUi:{");
        MapUIStatus mapUIStatus2 = this.mUsedMapUi;
        sb.append(mapUIStatus2 != null ? mapUIStatus2.toString() : "null");
        sb.append("},");
        sb.append("mMapStatus:{");
        MapStatus mapStatus = this.mMapStatus;
        sb.append(mapStatus != null ? mapStatus.toString() : "null");
        sb.append("},");
        sb.append("mMapStatus:{");
        MapStatus mapStatus2 = this.mRestoreMapStatus;
        sb.append(mapStatus2 != null ? mapStatus2.toString() : "null");
        sb.append("},");
        sb.append("mWorkQueue:{");
        WorkQueue workQueue = this.mWorkQueue;
        sb.append(workQueue != null ? workQueue.dump() : "null");
        sb.append("},");
        SceneInfoStack sceneInfoStack = this.mChildSceneInfoStack;
        if (sceneInfoStack != null) {
            Iterator<SceneInfoStack.SceneInfo> it = sceneInfoStack.iterator();
            while (it.hasNext()) {
                sb.append("ChildScene:{");
                sb.append(it.next().mScene.dump());
                sb.append("},");
            }
        }
        sb.append("},");
        return sb.toString();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public void showDebugMsg(String str) {
        FullScreenSceneDialog fullScreenSceneDialog = new FullScreenSceneDialog(getActivity(), this);
        TextView textView = new TextView(getActivity());
        textView.setText(str);
        textView.setTextSize(24.0f);
        fullScreenSceneDialog.setContentView(textView);
        fullScreenSceneDialog.setTitle("Debug");
        commitQueueWorker(fullScreenSceneDialog);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public final boolean onInterceptSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onInterceptSpeechEvent " + getClass().getSimpleName() + " event: " + speechNaviEvent.what);
        }
        if (getBridge().isOverMode()) {
            return false;
        }
        boolean onInterceptSpeechEvent = getPresenter() != null ? getPresenter().onInterceptSpeechEvent(speechNaviEvent, iCommandCallback) : false;
        String simpleName = getClass().getSimpleName();
        String[] strArr = new String[1];
        strArr[0] = onInterceptSpeechEvent ? "intercept" : "do nothing";
        speechNaviEvent.record(simpleName, "onInterceptSpeechEvent", strArr);
        return onInterceptSpeechEvent;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public final boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        boolean closeScene;
        if (L.ENABLE) {
            L.d(TAG, getClass().getSimpleName() + " onSpeechEvent event: " + speechNaviEvent.what);
        }
        if (speechNaviEvent.what == 905) {
            closeScene = this.mSpeechEventBizHelper.closeScene(speechNaviEvent, this);
        } else if (getPresenter() != null) {
            TraceUtils.alwaysTraceBegin("onSpeechEvent:" + getClass().getSimpleName());
            closeScene = getPresenter().onSpeechEvent(speechNaviEvent, iCommandCallback);
            TraceUtils.alwaysTraceEnd();
        } else {
            closeScene = false;
        }
        String simpleName = getClass().getSimpleName();
        String[] strArr = new String[1];
        strArr[0] = closeScene ? "consume" : "";
        speechNaviEvent.record(simpleName, "onSpeechEvent", strArr);
        return closeScene;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public final boolean dispatchSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        SceneInfoStack sceneInfoStack;
        speechNaviEvent.record(getClass().getSimpleName(), "dispatchSpeechEvent", "start");
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(" dispatchSpeechEvent event: ");
            sb.append(speechNaviEvent.what);
            sb.append(" mChildSceneInfoStack.size=");
            SceneInfoStack sceneInfoStack2 = this.mChildSceneInfoStack;
            sb.append(sceneInfoStack2 != null ? Integer.valueOf(sceneInfoStack2.size()) : "null");
            L.d(tag, sb.toString());
        }
        BaseBridge baseBridge = this.mBridge;
        if (baseBridge != null && !baseBridge.isOverMode() && (sceneInfoStack = this.mChildSceneInfoStack) != null) {
            if (sceneInfoStack.size() == 0) {
                speechNaviEvent.record(getClass().getSimpleName(), "dispatchSpeechEvent", "run on main scene");
                return onSpeechEvent(speechNaviEvent, iCommandCallback);
            }
            int i = 0;
            if (1 == this.mChildSceneInfoStack.size()) {
                ISpeechEvent iSpeechEvent = this.mChildSceneInfoStack.get(0).mSpeech;
                speechNaviEvent.record(getClass().getSimpleName(), "dispatchSpeechEvent", "run on main scene with one sub scene");
                return onSpeechEvent(speechNaviEvent, iCommandCallback) || iSpeechEvent.onSpeechEvent(speechNaviEvent, iCommandCallback);
            }
            int i2 = 0;
            while (true) {
                if (i >= this.mChildSceneInfoStack.size()) {
                    break;
                } else if (this.mChildSceneInfoStack.get(i).mSpeech.onInterceptSpeechEvent(speechNaviEvent, iCommandCallback)) {
                    i2 = i;
                    break;
                } else {
                    int i3 = i;
                    i++;
                    i2 = i3;
                }
            }
            while (i2 >= 0) {
                if (this.mChildSceneInfoStack.get(i2).mSpeech.onSpeechEvent(speechNaviEvent, iCommandCallback)) {
                    speechNaviEvent.record(getClass().getSimpleName(), "dispatchSpeechEvent", "end by sub scene");
                    return true;
                }
                i2--;
            }
        }
        speechNaviEvent.record(getClass().getSimpleName(), "dispatchSpeechEvent", DMWait.STATUS_END);
        return onSpeechEvent(speechNaviEvent, iCommandCallback);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean allowRgc() {
        StatusConst.Mode mode = getMode();
        return mode == StatusConst.Mode.CRUISE || mode == StatusConst.Mode.ROUTE || mode == StatusConst.Mode.EXPLORE || mode == StatusConst.Mode.NAVI || mode == StatusConst.Mode.SEARCH_RESULT || mode == StatusConst.Mode.SCAN_SEARCH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hidePopIconDialogScene() {
        IBaseScene topChildScene;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, getClass().getSimpleName() + ": has child: " + hasChildScene());
        }
        if (hasChildScene() && (topChildScene = getTopChildScene()) != null && topChildScene.getMode() == StatusConst.Mode.POPDIALOG) {
            L.i(TAG, "hidePopIconDialogScene: has POPDIALOG child, remove it");
            removeChildScene(topChildScene);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public View getWindowDecorView() {
        if (getActivity() == null) {
            return null;
        }
        return getActivity().getWindow().getDecorView();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void dialNum(String str) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "dialNum num:" + str);
        }
        startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + str)));
    }

    public final void showPrompt(int i) {
        this.mMainContext.showPrompt(i);
    }

    public final void showPrompt(String str) {
        this.mMainContext.showPrompt(str);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final void updateSRNaviSwitchStatus(int i, boolean z) {
        this.mMainContext.updateSRNaviSwitchStatus(i, z);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final void updateSRNaviGuideLineStatus(boolean z) {
        this.mMainContext.updateSRNaviGuideLineStatus(z);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IScene
    public final void updateAutoLogoStatus(int i) {
        this.mMainContext.updateAutoLogoStatus(i);
    }

    public String getVuiSceneId() {
        return getClass().getSimpleName();
    }
}
