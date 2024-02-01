package com.xiaopeng.montecarlo.base.scene;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.SceneInfoStack;
import com.xiaopeng.montecarlo.base.SceneState;
import com.xiaopeng.montecarlo.base.ScenesManager;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapStatus;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.scenes.mapscene.MapUIStatus;
import com.xiaopeng.montecarlo.speech.command.ISpeechEvent;
/* loaded from: classes.dex */
public interface IScene {
    void addChildScene(@NonNull IScene iScene);

    boolean backChildScene();

    boolean backChildToMode(StatusConst.Mode mode, boolean z);

    void backResult(int i, Bundle bundle);

    String dump();

    void enableNeedCallNewBridge();

    void enableNeedDestoryView();

    SceneInfoStack.SceneInfo findChildSceneById(int i);

    BaseBridge getBridge();

    SceneInfoStack getChildSceneInfoStack();

    int getChildStackSize();

    MapStatus getMapStatus();

    StatusConst.Mode getMode();

    PageType getPageType();

    IScene getParent();

    MapStatus getRestoreMapStatus();

    Bundle getResultBundle();

    MapUIStatus getSavedMapUi();

    Bundle getSavedSceneState();

    int getSceneId();

    ISpeechEvent getSpeechEvent();

    MapUIStatus getUIStatus();

    MapUIStatus getUsedMapUi();

    boolean hasChildMode(StatusConst.Mode mode);

    boolean hasChildScene();

    void hideScene(SceneLifeScheduler sceneLifeScheduler);

    boolean isAdded();

    boolean isAttach();

    boolean isCreated();

    boolean isDetached();

    boolean isPreScene(StatusConst.Mode mode);

    boolean isSceneLegal();

    boolean isSceneResumed();

    boolean isVisible();

    void onDestroyView();

    void onNewBridge(BaseBridge baseBridge);

    void onPause();

    void onResume();

    void onSaveState(Bundle bundle);

    MapStatus pickupRestoreMapStatusByRequestCode(MapStatus mapStatus, MapStatus mapStatus2, int i);

    void removeAllChildScene();

    void removeChildAfterIndex(int i);

    void removeChildScene(@NonNull IBaseScene iBaseScene);

    void removeScene(@NonNull SceneLifeScheduler sceneLifeScheduler);

    void restartScene(SceneLifeScheduler sceneLifeScheduler);

    void saveMapUI(MapUIStatus mapUIStatus);

    void setBackMapStatusByRequestCode(@NonNull MapStatus mapStatus, IScene iScene, int i);

    void setBridge(BaseBridge baseBridge);

    void setContentViewID(int i);

    void setIsFirstScene(boolean z);

    void setMainContext(MainContext mainContext);

    void setMapStatus(MapStatus mapStatus);

    void setParentScene(IScene iScene);

    void setRestoreMapStatus(MapStatus mapStatus);

    void setSceneId(int i);

    void setScenesManager(ScenesManager scenesManager);

    void showDebugMsg(String str);

    void showScene(SceneLifeScheduler sceneLifeScheduler);

    IBaseScene toBaseScene();

    void update(SceneState sceneState);

    void updateAutoLogoStatus(int i);

    void updateSRNaviGuideLineStatus(boolean z);

    void updateSRNaviSwitchStatus(int i, boolean z);
}
