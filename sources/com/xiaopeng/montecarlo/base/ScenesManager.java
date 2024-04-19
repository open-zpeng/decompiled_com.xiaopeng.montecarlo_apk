package com.xiaopeng.montecarlo.base;

import android.os.Bundle;
import android.os.Message;
import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.common.tool.FDManager;
import com.xiaopeng.montecarlo.action.IIntentActionContext;
import com.xiaopeng.montecarlo.action.schedule.IntentTaskScheduler;
import com.xiaopeng.montecarlo.base.SceneInfoStack;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.base.scene.IScene;
import com.xiaopeng.montecarlo.base.scene.IXPBroadcastReceiver;
import com.xiaopeng.montecarlo.base.scene.IXPHandlerReceiver;
import com.xiaopeng.montecarlo.base.scene.SceneBuilder;
import com.xiaopeng.montecarlo.base.scene.SceneLifeScheduler;
import com.xiaopeng.montecarlo.base.scene.XPBroadcast;
import com.xiaopeng.montecarlo.base.scene.XPHandler;
import com.xiaopeng.montecarlo.base.scene.XPHandlerBuilder;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapStatus;
import com.xiaopeng.montecarlo.navcore.speech.utils.NaviSpeechUtils;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import com.xiaopeng.montecarlo.speech.command.ISpeechEvent;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class ScenesManager {
    private static final int EMPTY_SCENE_ID = 1;
    public static final int MAP_ID = 10;
    private static final L.Tag TAG = new L.Tag("ScenesManager");
    private static int sSceneIdCount = 100;
    private SceneInfoStack.SceneInfo mCurrentSceneInfo;
    private IntentTaskScheduler mIntentTaskScheduler;
    private MainContext mMainContext;
    private XPHandler mRunTimeHandler;
    private SceneBuilder mSceneBuilder;
    private SceneInfoStack mSceneInfoStack;
    private SceneManagerListener mSceneTaskStatusListener;
    private IBaseScene mStartScene;
    private XPHandlerBuilder mXPHandlerBuilder;
    private final Object mStackLock = new Object();
    private SceneLifeScheduler mSceneLifeScheduler = null;
    private boolean mIsInitialized = false;
    private int mNotifySceneTaskSize = 0;
    private XPBroadcast mXPBroadcast = null;
    private UiHandler mUiHandler = null;
    private boolean mCreateCruise = false;
    private IXPBroadcastReceiver mXPBroadcastReceiver = new IXPBroadcastReceiver() { // from class: com.xiaopeng.montecarlo.base.ScenesManager.1
        @Override // com.xiaopeng.montecarlo.base.scene.IXPBroadcastReceiver
        public String[] getDataKeys() {
            return null;
        }

        @Override // com.xiaopeng.montecarlo.base.scene.IXPBroadcastReceiver
        public String[] getActions() {
            return new String[]{DebugConfiguration.RegisterAction.PRINT_SCENES_STACKS_ACTION};
        }

        @Override // com.xiaopeng.montecarlo.base.scene.IXPBroadcastReceiver
        public void onReceive(String str, HashMap<String, String> hashMap) {
            if (DebugConfiguration.RegisterAction.PRINT_SCENES_STACKS_ACTION.equals(str)) {
                ScenesManager.this.dumpStackInfo();
            }
        }
    };
    private ISpeechEvent mSpeechEvent = new ISpeechEvent() { // from class: com.xiaopeng.montecarlo.base.ScenesManager.2
        @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
        public final boolean onInterceptSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
            return false;
        }

        @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
        public final boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x00c7, code lost:
            if (r0 < 0) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00d9, code lost:
            if (r6.this$0.mSceneInfoStack.get(r0).mSpeech.dispatchSpeechEvent(r7, r8) == false) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00db, code lost:
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00dc, code lost:
            r0 = r0 - 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00df, code lost:
            r7.record("ScenesManager", "dispatchSpeechEvent", com.xiaopeng.speech.jarvisproto.DMWait.STATUS_END);
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00ec, code lost:
            return onSpeechEvent(r7, r8);
         */
        @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean dispatchSpeechEvent(com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent r7, com.xiaopeng.montecarlo.speech.command.ICommandCallback r8) {
            /*
                r6 = this;
                java.lang.String r0 = "start"
                java.lang.String[] r0 = new java.lang.String[]{r0}
                java.lang.String r1 = "dispatchSpeechEvent"
                java.lang.String r2 = "ScenesManager"
                r7.record(r2, r1, r0)
                com.xiaopeng.montecarlo.base.ScenesManager r0 = com.xiaopeng.montecarlo.base.ScenesManager.this
                com.xiaopeng.montecarlo.base.SceneInfoStack r0 = com.xiaopeng.montecarlo.base.ScenesManager.access$100(r0)
                r3 = 0
                if (r0 != 0) goto L20
                java.lang.String r8 = "error happened, mSceneInfoStack is null"
                java.lang.String[] r8 = new java.lang.String[]{r8}
                r7.record(r2, r1, r8)
                return r3
            L20:
                boolean r0 = com.xiaopeng.montecarlo.root.util.L.ENABLE
                if (r0 == 0) goto L50
                com.xiaopeng.montecarlo.root.util.L$Tag r0 = com.xiaopeng.montecarlo.base.ScenesManager.access$200()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "ScenesManager dispatchSpeechEvent event: "
                r4.append(r5)
                int r5 = r7.what
                r4.append(r5)
                java.lang.String r5 = " mSceneInfoStack.size="
                r4.append(r5)
                com.xiaopeng.montecarlo.base.ScenesManager r5 = com.xiaopeng.montecarlo.base.ScenesManager.this
                com.xiaopeng.montecarlo.base.SceneInfoStack r5 = com.xiaopeng.montecarlo.base.ScenesManager.access$100(r5)
                int r5 = r5.size()
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                com.xiaopeng.montecarlo.root.util.L.d(r0, r4)
            L50:
                com.xiaopeng.montecarlo.base.ScenesManager r0 = com.xiaopeng.montecarlo.base.ScenesManager.this
                com.xiaopeng.montecarlo.base.SceneInfoStack r0 = com.xiaopeng.montecarlo.base.ScenesManager.access$100(r0)
                int r0 = r0.size()
                r4 = 1
                if (r0 != 0) goto L75
                com.xiaopeng.montecarlo.base.ScenesManager r0 = com.xiaopeng.montecarlo.base.ScenesManager.this
                com.xiaopeng.montecarlo.base.SceneInfoStack$SceneInfo r0 = com.xiaopeng.montecarlo.base.ScenesManager.access$300(r0)
                if (r0 == 0) goto L74
                com.xiaopeng.montecarlo.base.ScenesManager r0 = com.xiaopeng.montecarlo.base.ScenesManager.this
                com.xiaopeng.montecarlo.base.SceneInfoStack$SceneInfo r0 = com.xiaopeng.montecarlo.base.ScenesManager.access$300(r0)
                com.xiaopeng.montecarlo.speech.command.ISpeechEvent r0 = r0.mSpeech
                boolean r7 = r0.dispatchSpeechEvent(r7, r8)
                if (r7 == 0) goto L74
                r3 = r4
            L74:
                return r3
            L75:
                r0 = r3
            L76:
                com.xiaopeng.montecarlo.base.ScenesManager r5 = com.xiaopeng.montecarlo.base.ScenesManager.this
                com.xiaopeng.montecarlo.base.SceneInfoStack r5 = com.xiaopeng.montecarlo.base.ScenesManager.access$100(r5)
                int r5 = r5.size()
                if (r3 >= r5) goto Lc7
                com.xiaopeng.montecarlo.base.ScenesManager r5 = com.xiaopeng.montecarlo.base.ScenesManager.this
                com.xiaopeng.montecarlo.base.SceneInfoStack r5 = com.xiaopeng.montecarlo.base.ScenesManager.access$100(r5)
                com.xiaopeng.montecarlo.base.SceneInfoStack$SceneInfo r5 = r5.get(r3)
                com.xiaopeng.montecarlo.speech.command.ISpeechEvent r5 = r5.mSpeech
                boolean r5 = r5.onInterceptSpeechEvent(r7, r8)
                if (r5 == 0) goto L96
                r0 = r3
                goto Lc7
            L96:
                com.xiaopeng.montecarlo.base.ScenesManager r5 = com.xiaopeng.montecarlo.base.ScenesManager.this
                com.xiaopeng.montecarlo.base.SceneInfoStack r5 = com.xiaopeng.montecarlo.base.ScenesManager.access$100(r5)
                int r5 = r5.size()
                int r5 = r5 - r4
                if (r3 != r5) goto Lc4
                com.xiaopeng.montecarlo.base.ScenesManager r0 = com.xiaopeng.montecarlo.base.ScenesManager.this
                com.xiaopeng.montecarlo.base.SceneInfoStack$SceneInfo r0 = com.xiaopeng.montecarlo.base.ScenesManager.access$300(r0)
                if (r0 == 0) goto Lc3
                com.xiaopeng.montecarlo.base.ScenesManager r0 = com.xiaopeng.montecarlo.base.ScenesManager.this
                com.xiaopeng.montecarlo.base.SceneInfoStack$SceneInfo r0 = com.xiaopeng.montecarlo.base.ScenesManager.access$300(r0)
                com.xiaopeng.montecarlo.speech.command.ISpeechEvent r0 = r0.mSpeech
                boolean r0 = r0.dispatchSpeechEvent(r7, r8)
                if (r0 == 0) goto Lc3
                java.lang.String r8 = "current scene consume event"
                java.lang.String[] r8 = new java.lang.String[]{r8}
                r7.record(r2, r1, r8)
                return r4
            Lc3:
                r0 = r3
            Lc4:
                int r3 = r3 + 1
                goto L76
            Lc7:
                if (r0 < 0) goto Ldf
                com.xiaopeng.montecarlo.base.ScenesManager r3 = com.xiaopeng.montecarlo.base.ScenesManager.this
                com.xiaopeng.montecarlo.base.SceneInfoStack r3 = com.xiaopeng.montecarlo.base.ScenesManager.access$100(r3)
                com.xiaopeng.montecarlo.base.SceneInfoStack$SceneInfo r3 = r3.get(r0)
                com.xiaopeng.montecarlo.speech.command.ISpeechEvent r3 = r3.mSpeech
                boolean r3 = r3.dispatchSpeechEvent(r7, r8)
                if (r3 == 0) goto Ldc
                return r4
            Ldc:
                int r0 = r0 + (-1)
                goto Lc7
            Ldf:
                java.lang.String r0 = "end"
                java.lang.String[] r0 = new java.lang.String[]{r0}
                r7.record(r2, r1, r0)
                boolean r7 = r6.onSpeechEvent(r7, r8)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.base.ScenesManager.AnonymousClass2.dispatchSpeechEvent(com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent, com.xiaopeng.montecarlo.speech.command.ICommandCallback):boolean");
        }
    };
    private IScene mEmptyScene = new EmptyScene();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface SceneManagerListener {
        void backResultToMap(int i, Bundle bundle);

        void sceneCountChanged(int i);
    }

    public ScenesManager() {
        this.mEmptyScene.setBridge(new EmptyBridge());
        this.mEmptyScene.setSceneId(1);
        this.mEmptyScene.setScenesManager(this);
    }

    public void setStartScene(IBaseScene iBaseScene) {
        this.mStartScene = iBaseScene;
    }

    public void setXPBroadcast(@NonNull XPBroadcast xPBroadcast) {
        this.mXPBroadcast = xPBroadcast;
        this.mXPBroadcast.setReceiver(this.mXPBroadcastReceiver);
    }

    public void setXPHandlerBuilder(@NonNull XPHandlerBuilder xPHandlerBuilder) {
        this.mXPHandlerBuilder = xPHandlerBuilder;
    }

    @NonNull
    public final XPHandler getRunTimeHandler() {
        return this.mRunTimeHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SceneLifeScheduler getSceneLifeScheduler() {
        return this.mSceneLifeScheduler;
    }

    public void init(@NonNull SceneLifeScheduler sceneLifeScheduler, @NonNull SceneBuilder sceneBuilder, @Nullable IntentTaskScheduler intentTaskScheduler) {
        if (this.mIsInitialized) {
            return;
        }
        this.mIsInitialized = true;
        this.mIntentTaskScheduler = intentTaskScheduler;
        this.mSceneLifeScheduler = sceneLifeScheduler;
        this.mSceneBuilder = sceneBuilder;
        this.mSceneInfoStack = new SceneInfoStack();
        this.mUiHandler = new UiHandler(this.mXPHandlerBuilder);
        if (DebugConfiguration.Debug.DEBUG_RECEIVER) {
            this.mXPBroadcast.register();
        }
        this.mRunTimeHandler = this.mXPHandlerBuilder.createMainThreadHandler();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void createScene(BaseBridge baseBridge) {
        if (L.ENABLE) {
            L.printDebugStackTrace(TAG, new Error());
        }
        this.mUiHandler.sendCreateScene(baseBridge);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createSceneHandler(BaseBridge baseBridge) {
        IScene iScene;
        BaseBridge createBridge;
        synchronized (this.mStackLock) {
            L.i(TAG, "createSceneHandler:" + baseBridge.getClass() + ",isOverMode:" + baseBridge.isOverMode());
            StatusConst.Mode mode = baseBridge.getMode();
            if (L.ENABLE && this.mCurrentSceneInfo != null) {
                L.d(TAG, "mCurrentSceneInfo:" + this.mCurrentSceneInfo.mScene.getClass().getSimpleName());
            }
            if (baseBridge.isOverMode()) {
                L.i(TAG, "createSceneHandler is over mode");
                iScene = this.mSceneBuilder.createScene(mode);
                iScene.setBridge(baseBridge);
                iScene.setMainContext(this.mMainContext);
                iScene.setScenesManager(this);
                sSceneIdCount++;
                iScene.setSceneId(sSceneIdCount);
                if (this.mCurrentSceneInfo != null) {
                    this.mCurrentSceneInfo.mScene.addChildScene(iScene);
                    return;
                }
            } else {
                iScene = null;
            }
            boolean z = false;
            if (baseBridge.isSingleMode() && this.mCurrentSceneInfo != null) {
                L.i(TAG, "createSceneHandler use single");
                if (mode == this.mCurrentSceneInfo.mMode) {
                    L.i(TAG, "createSceneHandler find current");
                    iScene = this.mCurrentSceneInfo.mScene;
                } else {
                    int findInTask = findInTask(mode, false);
                    L.i(TAG, "createSceneHandler find hide index:" + findInTask);
                    if (findInTask >= 0) {
                        for (int i = 0; i < findInTask - 1; i++) {
                            backHandler(false);
                        }
                        SceneInfoStack.SceneInfo pop = pop();
                        if (pop != null) {
                            if (isSceneCreated(this.mCurrentSceneInfo)) {
                                sendMapStatusSceneByScene(this.mCurrentSceneInfo.mScene, pop.mScene);
                            }
                            iScene = pop.mScene;
                            if (this.mCurrentSceneInfo != null) {
                                removeScene(this.mCurrentSceneInfo.mScene);
                            }
                            this.mCurrentSceneInfo = pop;
                            NaviSpeechUtils.setPageType(pop.mScene.getPageType());
                        }
                    }
                }
                if (iScene != null && iScene.hasChildScene()) {
                    iScene.removeAllChildScene();
                }
            }
            if (iScene == null) {
                L.i(TAG, "createSceneHandler createScene: " + mode);
                iScene = this.mSceneBuilder.createScene(mode);
                iScene.setScenesManager(this);
                sSceneIdCount = sSceneIdCount + 1;
                iScene.setSceneId(sSceneIdCount);
                if (StatusConst.Mode.CRUISE == mode) {
                    this.mCreateCruise = true;
                }
            }
            iScene.setBridge(baseBridge);
            iScene.setMainContext(this.mMainContext);
            if (baseBridge.mSceneState != null) {
                iScene.update(baseBridge.mSceneState);
                SceneState[] sceneStateArr = baseBridge.mSceneState.mChild;
                if (sceneStateArr != null && sceneStateArr.length > 0) {
                    int length = sceneStateArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        SceneState sceneState = baseBridge.mSceneState.mChild[(length - 1) - i2];
                        sceneState.mSavedSceneState.setClassLoader(getClass().getClassLoader());
                        if (sceneState.mResultBundle != null) {
                            sceneState.mResultBundle.setClassLoader(getClass().getClassLoader());
                        }
                        if (sceneState.mSavedSceneState.getBoolean("scene:save_enable", false) && (createBridge = StatusConst.Mode.createBridge(sceneState.mBridge)) != null) {
                            createBridge.mSceneState = sceneState;
                            IScene createScene = this.mSceneBuilder.createScene(createBridge.getMode());
                            createScene.setScenesManager(this);
                            createScene.setBridge(createBridge);
                            createScene.setMainContext(this.mMainContext);
                            createScene.update(sceneState);
                            iScene.addChildScene(createScene);
                        }
                    }
                }
            }
            boolean z2 = iScene.getSavedSceneState().getBoolean("scene:save_enable", false);
            if (this.mCurrentSceneInfo == null) {
                iScene.saveMapUI(null);
                iScene.setIsFirstScene(true);
            } else if (baseBridge.isKillTopSceneMode() && !z2) {
                iScene.saveMapUI(this.mCurrentSceneInfo.mScene.getSavedMapUi());
                iScene.setMapStatus(this.mCurrentSceneInfo.mScene.getMapStatus());
            } else {
                iScene.saveMapUI(this.mCurrentSceneInfo.mScene.getUIStatus());
            }
            if (L.ENABLE) {
                L.d(TAG, "createSceneHandler mCurrentSceneInfo:" + this.mCurrentSceneInfo + ",scene:" + iScene + ",isSingleNotDestroyMode:" + baseBridge.isSingleNotDestroyMode());
            }
            if (this.mCurrentSceneInfo != null && iScene == this.mCurrentSceneInfo.mScene) {
                if (!baseBridge.isSingleNotDestroyMode()) {
                    if (iScene.isDetached()) {
                        iScene.enableNeedDestoryView();
                        iScene.onDestroyView();
                    } else if (iScene.isVisible()) {
                        iScene.enableNeedDestoryView();
                        iScene.restartScene(this.mSceneLifeScheduler);
                    }
                } else if (iScene.isVisible()) {
                    iScene.onNewBridge(baseBridge);
                } else {
                    iScene.enableNeedCallNewBridge();
                }
            }
            if (this.mCurrentSceneInfo != null && iScene != this.mCurrentSceneInfo.mScene) {
                if (baseBridge.isKillTopSceneMode() && !z2 && StatusConst.Mode.CRUISE != this.mCurrentSceneInfo.mScene.getMode()) {
                    this.mCurrentSceneInfo.mScene.removeScene(this.mSceneLifeScheduler);
                    this.mCurrentSceneInfo = null;
                } else {
                    this.mCurrentSceneInfo.mScene.hideScene(this.mSceneLifeScheduler);
                    push(this.mCurrentSceneInfo);
                }
            }
            if (this.mCurrentSceneInfo == null || iScene != this.mCurrentSceneInfo.mScene) {
                SceneInfoStack.SceneInfo sceneInfo = new SceneInfoStack.SceneInfo(iScene);
                this.mCurrentSceneInfo = sceneInfo;
                NaviSpeechUtils.setPageType(sceneInfo.mScene.getPageType());
            }
            if (iScene.getSavedSceneState() != null) {
                if (iScene.getSavedSceneState().getBoolean("scene:isDetached", false)) {
                    iScene.getSavedSceneState().remove("scene:isDetached");
                    z = true;
                }
                if (!iScene.getSavedSceneState().getBoolean("scene:isAdded", true)) {
                    iScene.getSavedSceneState().remove("scene:isAdded");
                    z = true;
                }
            }
            if (!z) {
                IScene parent = iScene.getParent();
                if (parent != null) {
                    showScene(parent);
                } else {
                    showScene(iScene);
                }
                notifySceneTaskSizeChanged();
            }
            SceneInfoStack.SceneInfo sceneInfo2 = this.mCurrentSceneInfo;
            if (sceneInfo2 == null || this.mIntentTaskScheduler == null || sceneInfo2.mScene.getMode() != StatusConst.Mode.CRUISE) {
                return;
            }
            this.mIntentTaskScheduler.executeTaskCustomer(new IIntentActionContext() { // from class: com.xiaopeng.montecarlo.base.ScenesManager.3
                @Override // com.xiaopeng.montecarlo.action.IIntentActionContext
                public MainContext getMainContext() {
                    return ScenesManager.this.mMainContext;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void back() {
        if (L.ENABLE) {
            L.printDebugStackTrace(TAG, new Error());
        }
        this.mUiHandler.sendBackScene();
    }

    private boolean isSceneCreated(SceneInfoStack.SceneInfo sceneInfo) {
        return (sceneInfo == null || sceneInfo.mScene == null || !sceneInfo.mScene.isCreated()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void backHandler(boolean z) {
        L.printDebugStackTrace(TAG, new Error());
        synchronized (this.mStackLock) {
            L.i(TAG, "backHandler:");
            if (this.mCurrentSceneInfo == null) {
                L.i(TAG, "backHandler mCurrentSceneInfo is null");
            } else if (this.mCurrentSceneInfo.mScene.getMode() == StatusConst.Mode.CRUISE) {
            } else {
                if (!this.mCurrentSceneInfo.mScene.isAttach()) {
                    L.i(TAG, "backHandler but the scene is not attach");
                    return;
                }
                removeScene(this.mCurrentSceneInfo.mScene);
                SceneInfoStack.SceneInfo pop = pop();
                if (pop != null && pop.mScene != null) {
                    if (isSceneCreated(this.mCurrentSceneInfo)) {
                        sendMapStatusSceneByScene(this.mCurrentSceneInfo.mScene, pop.mScene);
                    }
                    this.mCurrentSceneInfo = pop;
                    NaviSpeechUtils.setPageType(pop.mScene.getPageType());
                    if (z) {
                        showScene(this.mCurrentSceneInfo.mScene);
                    }
                    notifySceneTaskSizeChanged();
                    return;
                }
                NaviSpeechUtils.setPageType(PageType.NAVI_CRUISE);
                notifySceneTaskSizeChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void backScene(@NonNull IBaseScene iBaseScene) {
        this.mUiHandler.sendBackScene(iBaseScene);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void backSceneHandler(@NonNull IBaseScene iBaseScene) {
        synchronized (this.mStackLock) {
            L.i(TAG, "backSceneHandler:");
            if (this.mCurrentSceneInfo == null) {
                L.i(TAG, "backSceneHandler mCurrentSceneInfo is null");
                return;
            }
            IScene iScene = (IScene) iBaseScene.getParentScene();
            if (iScene != null) {
                iScene.removeChildScene(iBaseScene);
            } else if (iBaseScene == this.mCurrentSceneInfo.mScene) {
                backHandler(true);
            } else {
                SceneInfoStack.SceneInfo findBySceneId = this.mSceneInfoStack.findBySceneId(iBaseScene.getSceneId(), false);
                if (findBySceneId != null) {
                    removeScene((IScene) iBaseScene);
                    this.mSceneInfoStack.remove(findBySceneId);
                }
            }
        }
    }

    private void sendMapStatusSceneByScene(@NonNull IScene iScene, @NonNull IScene iScene2) {
        iScene2.setRestoreMapStatus(mergeMapStatus(iScene, iScene2));
    }

    private MapStatus mergeMapStatus(@NonNull IScene iScene, @NonNull IScene iScene2) {
        MapStatus mapStatus = iScene.getMapStatus();
        Parcel obtain = Parcel.obtain();
        mapStatus.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        MapStatus createFromParcel = MapStatus.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        if (iScene.getRestoreMapStatus() != null) {
            mapStatus.setMapStatus(iScene.getRestoreMapStatus());
        }
        iScene.setBackMapStatusByRequestCode(mapStatus, iScene2, iScene.getBridge().getRequestCode());
        MapStatus pickupRestoreMapStatusByRequestCode = iScene2.pickupRestoreMapStatusByRequestCode(mapStatus, createFromParcel, iScene.getBridge().getRequestCode());
        return pickupRestoreMapStatusByRequestCode == null ? mapStatus : pickupRestoreMapStatusByRequestCode;
    }

    public IBaseScene getCurrentScene() {
        synchronized (this.mStackLock) {
            if (this.mCurrentSceneInfo == null) {
                return this.mEmptyScene.toBaseScene();
            }
            return this.mCurrentSceneInfo.mScene.toBaseScene();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSceneStackSize() {
        int size;
        synchronized (this.mStackLock) {
            size = this.mSceneInfoStack.size();
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAllSceneClosed() {
        return this.mCurrentSceneInfo == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isPreScene(StatusConst.Mode mode, boolean z) {
        synchronized (this.mStackLock) {
            if (z) {
                if (this.mCurrentSceneInfo != null && this.mCurrentSceneInfo.mMode == mode) {
                    return true;
                }
            }
            Iterator<SceneInfoStack.SceneInfo> it = this.mSceneInfoStack.iterator();
            while (it.hasNext()) {
                SceneInfoStack.SceneInfo next = it.next();
                if (next != null && next.mMode == mode) {
                    return true;
                }
            }
            return false;
        }
    }

    public int findInTask(StatusConst.Mode mode, boolean z) {
        int i;
        synchronized (this.mStackLock) {
            int size = this.mSceneInfoStack.size();
            for (int i2 = size - 1; i2 >= 0; i2--) {
                SceneInfoStack.SceneInfo sceneInfo = this.mSceneInfoStack.get(i2);
                if (mode != sceneInfo.mMode && (!z || !sceneInfo.mScene.hasChildMode(mode))) {
                }
                i = size - i2;
                break;
            }
            i = -1;
            if (StatusConst.Mode.CRUISE == mode && i < 0 && this.mCreateCruise && this.mCurrentSceneInfo != null && this.mCurrentSceneInfo.mMode != StatusConst.Mode.CRUISE) {
                L.w(TAG, "not found cruise scene");
                dumpStackInfo();
                RootUtil.delayExitApp(RootUtil.KILL_NAVI_LOST_CRUISE_SCENCE);
            }
        }
        return i;
    }

    private int findLastInTask(StatusConst.Mode mode) {
        synchronized (this.mStackLock) {
            int size = this.mSceneInfoStack.size();
            for (int i = 0; i < size; i++) {
                SceneInfoStack.SceneInfo sceneInfo = this.mSceneInfoStack.get(i);
                if (mode == sceneInfo.mMode) {
                    return i;
                }
                if (sceneInfo.mScene.hasChildMode(mode)) {
                    return i;
                }
            }
            return -1;
        }
    }

    private void removeScene(IScene iScene) {
        if (iScene != null) {
            L.Tag tag = TAG;
            L.i(tag, "removeScene:" + iScene.getClass());
            iScene.removeScene(this.mSceneLifeScheduler);
        }
    }

    private void notifySceneTaskSizeChanged() {
        synchronized (this.mStackLock) {
            if (this.mSceneTaskStatusListener != null) {
                int size = this.mCurrentSceneInfo != null ? this.mSceneInfoStack.size() + 1 : 0;
                L.Tag tag = TAG;
                L.i(tag, "notifySceneTaskSizeChanged mSceneInfoStack " + this.mSceneInfoStack + ", " + this.mCurrentSceneInfo);
                if (this.mNotifySceneTaskSize != size) {
                    this.mNotifySceneTaskSize = size;
                    this.mSceneTaskStatusListener.sceneCountChanged(size);
                }
            }
        }
    }

    private void showScene(IScene iScene) {
        if (iScene != null) {
            iScene.showScene(this.mSceneLifeScheduler);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void goToMap() {
        this.mUiHandler.sendGoToMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToMapHandler() {
        backToMode(StatusConst.Mode.CRUISE, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void backToMode(StatusConst.Mode mode, boolean z) {
        this.mUiHandler.sendBackToMode(mode, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void backToModeHandler(StatusConst.Mode mode, boolean z) {
        L.i(TAG, "backToModeHandler mode:" + mode + ", backSelf: " + z);
        synchronized (this.mStackLock) {
            if (this.mCurrentSceneInfo == null) {
                return;
            }
            if (this.mCurrentSceneInfo.mMode == mode) {
                this.mCurrentSceneInfo.mScene.removeAllChildScene();
                if (z) {
                    backHandler(true);
                }
            } else if (this.mCurrentSceneInfo.mScene.hasChildMode(mode)) {
                this.mCurrentSceneInfo.mScene.backChildToMode(mode, z);
            } else {
                int findInTask = findInTask(mode, true);
                if (findInTask >= 0) {
                    for (int i = 0; i < findInTask; i++) {
                        backHandler(false);
                    }
                    if (this.mCurrentSceneInfo.mMode != mode) {
                        this.mCurrentSceneInfo.mScene.backChildToMode(mode, z);
                    } else if (z) {
                        backHandler(false);
                    } else {
                        this.mCurrentSceneInfo.mScene.removeAllChildScene();
                    }
                    if (this.mCurrentSceneInfo != null) {
                        showScene(this.mCurrentSceneInfo.mScene);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void backToLastMode(StatusConst.Mode mode, boolean z) {
        this.mUiHandler.sendBackToLastMode(mode, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void backToLastModeHandler(StatusConst.Mode mode, boolean z) {
        L.i(TAG, "backToLastModeHandler mode:" + mode + ", backSelf: " + z);
        synchronized (this.mStackLock) {
            if (this.mCurrentSceneInfo == null) {
                return;
            }
            int findLastInTask = findLastInTask(mode);
            if (findLastInTask > 0) {
                int size = this.mSceneInfoStack.size();
                for (int i = 0; i < size - findLastInTask; i++) {
                    backHandler(false);
                }
                if (this.mCurrentSceneInfo.mMode != mode) {
                    this.mCurrentSceneInfo.mScene.backChildToMode(mode, z);
                } else if (z) {
                    backHandler(false);
                }
                if (this.mCurrentSceneInfo != null) {
                    showScene(this.mCurrentSceneInfo.mScene);
                }
            }
        }
    }

    private void push(SceneInfoStack.SceneInfo sceneInfo) {
        synchronized (this.mStackLock) {
            this.mSceneInfoStack.push(sceneInfo);
        }
    }

    private SceneInfoStack.SceneInfo pop() {
        SceneInfoStack.SceneInfo pop;
        synchronized (this.mStackLock) {
            pop = this.mSceneInfoStack.pop();
        }
        return pop;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeSceneAfterIndex(int i, int i2) {
        this.mUiHandler.sendRemoveSceneAfterIndex(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSceneAfterIndexHandler(int i, int i2) {
        L.i(TAG, "removeSceneAfterIndexHandler index:" + i + "  childIndex:" + i2);
        synchronized (this.mStackLock) {
            int sceneStackSize = getSceneStackSize() - 1;
            if (i >= -1 && i <= sceneStackSize) {
                while (sceneStackSize >= i) {
                    backHandler(false);
                    sceneStackSize--;
                }
                if (this.mCurrentSceneInfo != null) {
                    this.mCurrentSceneInfo.mScene.removeChildAfterIndex(i2);
                    showScene(this.mCurrentSceneInfo.mScene);
                }
                return;
            }
            L.w(TAG, "error index:" + i + " getSceneStackSize():" + sceneStackSize);
            if (this.mCurrentSceneInfo != null) {
                this.mCurrentSceneInfo.mScene.removeChildAfterIndex(i2);
            }
        }
    }

    public void onDestroy() {
        if (this.mIsInitialized) {
            this.mIsInitialized = false;
            this.mUiHandler.removeAllWaitMessage();
            this.mSceneInfoStack.clear();
            this.mCurrentSceneInfo = null;
            NaviSpeechUtils.setPageType(PageType.NONE);
            if (DebugConfiguration.Debug.DEBUG_RECEIVER) {
                this.mXPBroadcast.unregister();
            }
            this.mMainContext = null;
            this.mEmptyScene.setMainContext(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void backResult(int i, int i2, Bundle bundle) {
        synchronized (this.mStackLock) {
            L.Tag tag = TAG;
            L.i(tag, "backResult sceneId:" + i + "  requestCode:" + i2);
            if (i <= 0) {
                return;
            }
            if (i != 10 && i != 1) {
                if (this.mCurrentSceneInfo != null) {
                    r2 = this.mCurrentSceneInfo.mScene.getSceneId() == i ? this.mCurrentSceneInfo : null;
                    if (r2 == null) {
                        r2 = this.mCurrentSceneInfo.mScene.findChildSceneById(i);
                    }
                }
                if (r2 == null) {
                    r2 = this.mSceneInfoStack.findBySceneId(i, true);
                }
                if (r2 != null) {
                    r2.mScene.backResult(i2, bundle);
                }
                return;
            }
            if (this.mSceneTaskStatusListener != null) {
                this.mSceneTaskStatusListener.backResultToMap(i2, bundle);
            }
        }
    }

    public MainContext getMainContext() {
        return this.mMainContext;
    }

    public void setMainContext(MainContext mainContext) {
        this.mMainContext = mainContext;
        this.mEmptyScene.setMainContext(mainContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SceneInfoStack getSceneInfoStack() {
        return this.mSceneInfoStack;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SceneInfoStack.SceneInfo getCurrentSceneInfo() {
        return this.mCurrentSceneInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSceneTaskStatusListener(SceneManagerListener sceneManagerListener) {
        this.mSceneTaskStatusListener = sceneManagerListener;
    }

    public IBaseScene getEmptyScene() {
        return this.mEmptyScene.toBaseScene();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearSceneManagerState() {
        synchronized (this.mStackLock) {
            if (this.mCurrentSceneInfo != null) {
                this.mCurrentSceneInfo.mScene.getSavedSceneState().clear();
            }
            if (this.mSceneInfoStack != null) {
                Iterator<SceneInfoStack.SceneInfo> it = this.mSceneInfoStack.iterator();
                while (it.hasNext()) {
                    it.next().mScene.getSavedSceneState().clear();
                }
            }
        }
    }

    public ISpeechEvent getSpeechEvent() {
        return this.mSpeechEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class UiHandler {
        static final int BACK_SCENE_MSG = 1;
        static final int BACK_TO_LAST_MODE = 5;
        static final int BACK_TO_MODE = 4;
        static final int CREATE_SCENE_MSG = 0;
        static final int GOTO_MAP_MSG = 2;
        static final int REMOVE_SCENE_AFTER_INDEX_MSG = 3;
        private IXPHandlerReceiver mIXPHandlerReceiver = new IXPHandlerReceiver() { // from class: com.xiaopeng.montecarlo.base.ScenesManager.UiHandler.1
            @Override // com.xiaopeng.montecarlo.base.scene.IXPHandlerReceiver
            public void handleMessage(int i, int i2, int i3, Object obj, Bundle bundle) {
                if (L.ENABLE) {
                    L.Tag tag = ScenesManager.TAG;
                    L.d(tag, "handleMessage: what = " + i + " , arg1 = " + i2 + " , arg2 = " + i3 + " , obj = " + obj);
                }
                if (i == 0) {
                    ScenesManager.this.createSceneHandler((BaseBridge) obj);
                    return;
                }
                if (i == 1) {
                    if (obj == null) {
                        ScenesManager.this.backHandler(true);
                    } else {
                        ScenesManager.this.backSceneHandler((IBaseScene) obj);
                    }
                } else if (i == 2) {
                    ScenesManager.this.goToMapHandler();
                } else if (i == 3) {
                    ScenesManager.this.removeSceneAfterIndexHandler(i2, i3);
                } else if (i == 4) {
                    ScenesManager.this.backToModeHandler((StatusConst.Mode) obj, i2 == 1);
                } else if (i != 5) {
                } else {
                    ScenesManager.this.backToLastModeHandler((StatusConst.Mode) obj, i2 == 1);
                }
            }
        };
        private XPHandler mXPHandler;

        UiHandler(XPHandlerBuilder xPHandlerBuilder) {
            this.mXPHandler = xPHandlerBuilder.createMainThreadHandler();
            this.mXPHandler.setXPHandlerReceiver(this.mIXPHandlerReceiver);
        }

        void sendCreateScene(BaseBridge baseBridge) {
            this.mXPHandler.sendMessage(this.mXPHandler.obtainMessage(0, baseBridge));
        }

        void sendBackScene() {
            this.mXPHandler.sendMessage(this.mXPHandler.obtainMessage(1));
        }

        void sendBackScene(@NonNull IBaseScene iBaseScene) {
            this.mXPHandler.sendMessage(this.mXPHandler.obtainMessage(1, iBaseScene));
        }

        void sendGoToMap() {
            this.mXPHandler.sendMessage(this.mXPHandler.obtainMessage(2));
        }

        void sendRemoveSceneAfterIndex(int i, int i2) {
            Message obtainMessage = this.mXPHandler.obtainMessage(3);
            obtainMessage.arg1 = i;
            obtainMessage.arg2 = i2;
            this.mXPHandler.sendMessage(obtainMessage);
        }

        void sendBackToMode(StatusConst.Mode mode, boolean z) {
            Message obtainMessage = this.mXPHandler.obtainMessage(4, mode);
            obtainMessage.arg1 = z ? 1 : 0;
            this.mXPHandler.sendMessage(obtainMessage);
        }

        void sendBackToLastMode(StatusConst.Mode mode, boolean z) {
            Message obtainMessage = this.mXPHandler.obtainMessage(5, mode);
            obtainMessage.arg1 = z ? 1 : 0;
            this.mXPHandler.sendMessage(obtainMessage);
        }

        void removeAllWaitMessage() {
            this.mXPHandler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dumpStackInfo() {
        synchronized (this.mStackLock) {
            StringBuilder sb = new StringBuilder();
            if (this.mCurrentSceneInfo != null) {
                sb.append("show scene:");
                sb.append(this.mCurrentSceneInfo.mScene.getClass());
                sb.append(FDManager.LINE_SEPERATOR);
                sb.append("SceneDump:");
                sb.append(this.mCurrentSceneInfo.mScene.dump());
                sb.append(FDManager.LINE_SEPERATOR);
            }
            int sceneStackSize = getSceneStackSize() - 1;
            if (sceneStackSize < 0) {
                sb.append("hide SceneStack is empty.");
                sb.append(FDManager.LINE_SEPERATOR);
            } else {
                for (int i = sceneStackSize; i >= 0; i--) {
                    SceneInfoStack.SceneInfo sceneInfo = this.mSceneInfoStack.get(i);
                    sb.append("hide index:");
                    sb.append(sceneStackSize - i);
                    sb.append("  Scene:");
                    sb.append(sceneInfo.mScene.getClass());
                    sb.append(FDManager.LINE_SEPERATOR);
                    sb.append("SceneDump:");
                    sb.append(sceneInfo.mScene.dump());
                    sb.append(FDManager.LINE_SEPERATOR);
                }
            }
            SceneInfoStack.SceneInfo sceneInfo2 = this.mCurrentSceneInfo;
            L.i(TAG, sb.toString());
        }
    }
}
