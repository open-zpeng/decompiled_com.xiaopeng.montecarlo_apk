package com.xiaopeng.montecarlo.base.scene;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapStatus;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.views.poicard.PoiCardView;
/* loaded from: classes.dex */
public interface IBaseScene {
    boolean allowRgc();

    boolean backChildScene();

    void backToLastMode(StatusConst.Mode mode, boolean z);

    void backToMode(StatusConst.Mode mode, boolean z);

    default boolean canPoiCardShow() {
        return true;
    }

    void commitQueueWorker(IQueueWorker iQueueWorker);

    void dialNum(String str);

    boolean dispatchTouchEvent(MotionEvent motionEvent);

    void endWorker(IQueueWorker iQueueWorker);

    ViewGroup getBaseView();

    BaseBridge getBridge();

    View getChildSceneContainer();

    int getChildStackSize();

    int getContentViewID();

    StatusConst.Mode getCurrentSceneMode();

    MapStatus getMapStatus();

    StatusConst.Mode getMode();

    PageType getPageType();

    IBaseScene getParentScene();

    PoiCardView getPoiCard();

    <T extends AbstractBasePresenter> T getPresenter();

    View getSceneContainer();

    View getSceneContentView();

    int getSceneId();

    int getSceneStackSize();

    int getSceneVuiState();

    int getSearchDest();

    int getSearchMode();

    IBaseScene getTopChildScene();

    String getVuiSceneId();

    View getWindowDecorView();

    void goBack();

    void goToMap();

    boolean hasChildScene();

    boolean isAdded();

    boolean isDetached();

    boolean isFirstEnterScene();

    boolean isHidden();

    boolean isMultipleSearchResult();

    boolean isPreScene(StatusConst.Mode mode);

    boolean isPreScene(StatusConst.Mode mode, boolean z);

    boolean isSceneLegal();

    boolean isSceneVuiEnabled();

    boolean isSceneVuiInit();

    boolean isSearchResultFragSinglePoi(XPPoiInfo xPPoiInfo);

    boolean isShowFavorite();

    void mockDispatchTouchEventForVui(View view);

    boolean onBackPressed();

    void onChildSceneRemoved(IScene iScene);

    void onClickBlank(long j, float f, float f2);

    void onMotionEvent(long j, int i, long j2, long j3);

    void onMoveBegin(long j, long j2);

    void onMoveEnd(long j, long j2);

    void removeAllChildScene();

    void removeChildScene(@NonNull IBaseScene iBaseScene);

    void removeSceneAfterIndex(int i, int i2);

    void setFreeBound(int i, int i2, int i3, int i4);

    void setRestoreMapStatus(MapStatus mapStatus);

    void setReturnResult(Bundle bundle);

    void setSceneVuiState(int i);

    default boolean showCover() {
        return false;
    }

    void startScene(BaseBridge baseBridge);

    void startScene(BaseBridge baseBridge, int i);

    void updateScene();
}
