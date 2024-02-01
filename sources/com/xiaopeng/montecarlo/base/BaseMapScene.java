package com.xiaopeng.montecarlo.base;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.common.model.RectInt;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.base.scene.IScene;
import com.xiaopeng.montecarlo.base.scene.SceneLifeScheduler;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.control.BizControlWrapper;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.popdialogscene.PopDialogFragment;
import com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract;
import com.xiaopeng.montecarlo.trafficevent.TrafficEventHelper;
import com.xiaopeng.montecarlo.trafficevent.TrafficEventPopParam;
import com.xiaopeng.montecarlo.util.MapUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.TrafficEventPopView;
import com.xiaopeng.montecarlo.views.poicard.PoiCardHelper;
import com.xiaopeng.montecarlo.views.poicard.PoiCardView;
/* loaded from: classes.dex */
public abstract class BaseMapScene extends BaseFullScenes implements PoiCardHelper.PoiCardManagerCallback, TrafficEventHelper.ITrafficEventCallback {
    private static final L.Tag TAG = new L.Tag("BaseMapScene");
    private PoiCardHelper mPoiCardHelper;
    private TrafficEventHelper mTrafficEventHelper;
    protected TrafficEventPopView mTrafficIncidentPop = null;

    public boolean canShowTrafficEventPop() {
        return true;
    }

    public boolean isEagleEyeEnable() {
        return false;
    }

    protected void setTrafficEventLayerState() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneViewCreated(View view, @Nullable Bundle bundle) {
        super.onSceneViewCreated(view, bundle);
        this.mTrafficEventHelper = new TrafficEventHelper(getMainContext(), this);
        if (!canPoiCardShow() || this.mPoiViewStub == null) {
            return;
        }
        this.mPoiCardHelper = new PoiCardHelper(this, this.mPoiViewStub, this.mMainContext, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneResume() {
        super.onSceneResume();
        setTrafficEventLayerState();
        getMainContext().getDecoratorManager().resumeMapDecorator(this);
        renderEagleView();
    }

    private void renderEagleView() {
        if (isSceneLegal()) {
            MapViewWrapper mapView = getMapView();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "onBaseMapSceneResume isEagleEyeShowing:" + mapView.getBizControlManager().isEagleEyeShowing() + " isEagleEyeEnable : " + isEagleEyeEnable());
            }
            if (!isEagleEyeEnable()) {
                hideEagleEyeView(mapView);
            } else if (mapView.isDayNightSwitching()) {
            } else {
                mapView.enableEagleEyeState(ContextUtils.getDimensionPixelSize(R.dimen.guide_eagle_view_width), ThemeWatcherUtil.isDayMode(), MapUtil.getDefaultEagleLocation());
                if (!mapView.getBizControlManager().isInitEagleye() || mapView.getBizControlManager().isEagleEyeShowing()) {
                    return;
                }
                mapView.getBizControlManager().updateMapEagleEyeView(true, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEagleEyeView(MapViewWrapper mapViewWrapper) {
        if (mapViewWrapper.getBizControlManager().isEagleEyeShowing()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "hideEagleEyeView isEagleEyeShowing:" + mapViewWrapper.getBizControlManager().isEagleEyeShowing() + " show:false refreshRoute : false");
            }
            mapViewWrapper.getBizControlManager().disableEagleEyeState();
            mapViewWrapper.getBizControlManager().updateMapEagleEyeView(false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onScenePause() {
        super.onScenePause();
        getMainContext().getDecoratorManager().pauseMapDecorator(this);
        hideSceneTrafficEventPop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onChildSceneAdded(IBaseScene iBaseScene) {
        super.onChildSceneAdded(iBaseScene);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "POP=> onChildSceneAdded " + iBaseScene);
        }
        if (iBaseScene instanceof PopDialogFragment) {
            if (L.ENABLE) {
                L.d(TAG, "onChildSceneAdded scene is PopDialogFragment ,so return it");
                return;
            }
            return;
        }
        getMainContext().getDecoratorManager().pauseMapDecorator(this);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void onChildSceneRemoved(IScene iScene) {
        super.onChildSceneRemoved(iScene);
        if (hasChildScene()) {
            return;
        }
        if (iScene instanceof PopDialogFragment) {
            if (L.ENABLE) {
                L.d(TAG, "onChildSceneRemoved scene is PopDialogFragment ,so return it");
                return;
            }
            return;
        }
        getMainContext().getDecoratorManager().resumeMapDecorator(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroyView() {
        super.onSceneDestroyView();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onSceneDestroyView " + getClass().getSimpleName());
        }
        PoiCardHelper poiCardHelper = this.mPoiCardHelper;
        if (poiCardHelper != null) {
            poiCardHelper.release();
            this.mPoiCardHelper = null;
        }
        TrafficEventHelper trafficEventHelper = this.mTrafficEventHelper;
        if (trafficEventHelper != null) {
            trafficEventHelper.uInit();
            this.mTrafficEventHelper = null;
        }
        this.mTrafficIncidentPop = null;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IScene
    public void removeScene(@NonNull SceneLifeScheduler sceneLifeScheduler) {
        L.i(TAG, "removeScene");
        super.removeScene(sceneLifeScheduler);
        getMainContext().getDecoratorManager().removeMapDecorator(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroy() {
        super.onSceneDestroy();
        L.Tag tag = TAG;
        L.i(tag, "onSceneDestroy current scene:" + this);
        L.Tag tag2 = TAG;
        L.i(tag2, "removeMapDecorator current scene:" + this);
        getMainContext().getDecoratorManager().removeMapDecorator(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneStart() {
        super.onSceneStart();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardHelper.PoiCardManagerCallback
    @CallSuper
    public void onPoiShow(PoiCardView poiCardView) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onPoiShow poiPop:" + poiCardView);
        }
        hideSceneTrafficEventPop();
        moveViewToFreeArea(poiCardView);
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardHelper.PoiCardManagerCallback
    @CallSuper
    public void onPoiUpdate(PoiCardView poiCardView) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onPoiShowRefresh poiPop:" + poiCardView);
        }
        hideSceneTrafficEventPop();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardHelper.PoiCardManagerCallback
    @CallSuper
    public void onPoiHide(PoiCardView poiCardView) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onPoiHide:" + getClass().getSimpleName());
        }
        hidePopIconDialogScene();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isPoiCardShowing() {
        PoiCardHelper poiCardHelper = this.mPoiCardHelper;
        if (poiCardHelper != null) {
            return poiCardHelper.isPoiPopup();
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public PoiCardView getPoiCard() {
        PoiCardHelper poiCardHelper = this.mPoiCardHelper;
        if (poiCardHelper != null) {
            return poiCardHelper.getCardView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearOverlayElemAllFocus() {
        MapViewWrapper mapView = getMapView();
        if (mapView != null) {
            mapView.getBizControlManager().clearFocus(BizControlWrapper.BIZ_CONTROL_TYPE_ROADFACILITY, 5008L);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void onClickBlank(long j, float f, float f2) {
        super.onClickBlank(j, f, f2);
        hideSceneTrafficEventPop();
    }

    public void showSceneTrafficEventPop(final TrafficEventPopParam trafficEventPopParam) {
        if (!canShowTrafficEventPop()) {
            L.Tag tag = TAG;
            L.i(tag, getClass().getSimpleName() + " can not show traffic Event!");
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.base.BaseMapScene.1
            @Override // java.lang.Runnable
            public void run() {
                if (BaseMapScene.this.mTrafficEventHelper != null) {
                    L.Tag tag2 = BaseMapScene.TAG;
                    L.i(tag2, "showITrafficEventPopView: " + trafficEventPopParam.toString() + ", scene: " + getClass().getSimpleName());
                    BaseMapScene.this.mTrafficEventHelper.showPoiTrafficEventPop(trafficEventPopParam);
                }
            }
        });
    }

    @MainThread
    public void hideSceneTrafficEventPop() {
        TrafficEventHelper trafficEventHelper = this.mTrafficEventHelper;
        if (trafficEventHelper != null) {
            trafficEventHelper.hideSceneTrafficEventPop();
        }
    }

    public boolean isTrafficEventPopShown() {
        TrafficEventPopView trafficEventPopView = this.mTrafficIncidentPop;
        return trafficEventPopView != null && trafficEventPopView.getVisibility() == 0;
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.TrafficEventHelper.ITrafficEventCallback
    public ITrafficEventContract.ITrafficEventPopView getTrafficEventView() {
        if (this.mTrafficIncidentPop == null) {
            this.mTrafficIncidentPop = (TrafficEventPopView) this.mTrafficIncidentStub.inflate();
        }
        return this.mTrafficIncidentPop;
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.TrafficEventHelper.ITrafficEventCallback
    public boolean isLegal() {
        return isSceneLegal();
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.TrafficEventHelper.ITrafficEventCallback
    public void onTrafficEventPopShow(View view, double d, double d2) {
        RectInt currentFreeBound = getCurrentFreeBound();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = currentFreeBound.top;
        view.setLayoutParams(layoutParams);
        getMapView().setPoiToCenter(new XPCoordinate2DDouble(d, d2), true);
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.TrafficEventHelper.ITrafficEventCallback
    public void onTrafficEventPopHide(View view) {
        hidePopIconDialogScene();
    }
}
