package com.xiaopeng.montecarlo.action;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.montecarlo.IntentActions;
import com.xiaopeng.montecarlo.appengine.CallThirdPartLoginService;
import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.bean.NaviRouteInfo;
import com.xiaopeng.montecarlo.bridge.ExploreBridge;
import com.xiaopeng.montecarlo.bridge.LinkSeamlessNaviBridge;
import com.xiaopeng.montecarlo.bridge.NaviBridge;
import com.xiaopeng.montecarlo.bridge.RouteBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import com.xiaopeng.montecarlo.stat.SettingStatUtil;
import com.xiaopeng.montecarlo.util.NaviUtil;
/* loaded from: classes.dex */
public class ThirdAPPUriAccessAction implements IIntentAction {
    private static final String PACKAGE_NAME_CAR_ACCOUNT = "com.xiaopeng.caraccount";
    private static final String PACKAGE_NAME_STATE_GRID = "com.stategrid.vehicle";
    private static final L.Tag TAG = new L.Tag("3thAppUri");

    @Override // com.xiaopeng.montecarlo.action.IIntentAction
    public boolean handlerIntentAction(final IIntentActionContext iIntentActionContext, Intent intent) {
        if (iIntentActionContext != null) {
            if (intent == null) {
                throw new IllegalArgumentException("intent is null");
            }
            if (IntentActions.ACTION_THIRD_APP_ACCESS.equals(intent.getStringExtra(IntentActions.ActionsKey.KEY_ACTION))) {
                Uri parse = Uri.parse(intent.getStringExtra(IntentActions.ActionsKey.KEY_URI));
                L.Tag tag = TAG;
                L.i(tag, "mRouteUri = " + parse);
                final NaviRouteInfo parseNaviUri = NaviUtil.parseNaviUri(parse);
                final MainContext mainContext = iIntentActionContext.getMainContext();
                if (parseNaviUri != null) {
                    UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.action.ThirdAPPUriAccessAction.1
                        @Override // java.lang.Runnable
                        public void run() {
                            IBaseScene currentScene = mainContext.getCurrentScene();
                            if (currentScene == null) {
                                return;
                            }
                            L.Tag tag2 = ThirdAPPUriAccessAction.TAG;
                            L.i(tag2, "handlerIntentAction scene.getMode()=" + currentScene.getMode());
                            currentScene.removeAllChildScene();
                            StateManager.getInstance().switchActiveState();
                            mainContext.getMapView().getBizControlManager().openDynamicLevel(false);
                            mainContext.getDecoratorManager().clearFocus(mainContext.getCurrentScene());
                            ThirdAPPUriAccessAction.this.getMapViewWrapper(iIntentActionContext).getBizControlManager().removeRoute(769, true);
                            RouteRequest createNormalRequest = RouteRequest.createNormalRequest(parseNaviUri.getStartInfo(), parseNaviUri.getEndInfo(), parseNaviUri.getViaList());
                            if (currentScene.getMode() == StatusConst.Mode.NAVI || currentScene.getMode() == StatusConst.Mode.ROUTE || currentScene.getMode() == StatusConst.Mode.EXPLORE) {
                                if (currentScene.getPresenter() instanceof BaseMapDecorator.IMapDecoratorRouteUpdateListener) {
                                    ((BaseMapDecorator.IMapDecoratorRouteUpdateListener) currentScene.getPresenter()).onRouteUpdate(null, createNormalRequest.toBundle());
                                }
                            } else if (TBTManager.getInstance().getCurrentStatus() != 0) {
                                if (TBTManager.getInstance().getCurrentStatus() == 2) {
                                    currentScene.startScene(new ExploreBridge().setBundle(createNormalRequest.toBundle()));
                                } else {
                                    currentScene.startScene(new NaviBridge().setBundle(createNormalRequest.toBundle()));
                                }
                            } else {
                                currentScene.startScene(new RouteBridge().setBundle(createNormalRequest.toBundle()));
                            }
                        }
                    }, 500L);
                    sendStatData(mainContext, parse, parseNaviUri);
                } else {
                    if (L.ENABLE) {
                        L.d(TAG, "user center call weChat function");
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt(LinkSeamlessNaviBridge.KEY_FROM_WHERE, 2);
                    if (mainContext != null) {
                        StatusConst.Mode currentSceneMode = mainContext.getCurrentScene().getCurrentSceneMode();
                        final BaseBridge bundle2 = new LinkSeamlessNaviBridge().setBundle(bundle);
                        int findInTask = mainContext.getScenesManager().findInTask(bundle2.getMode(), false);
                        if (L.ENABLE) {
                            L.Tag tag2 = TAG;
                            L.d(tag2, "currentMode= " + currentSceneMode + " index= " + findInTask);
                        }
                        if (findInTask >= 0 && (StatusConst.Mode.ROUTE == currentSceneMode || StatusConst.Mode.EXPLORE == currentSceneMode || StatusConst.Mode.NAVI == currentSceneMode)) {
                            TBTManager.getInstance().stopNavi(true);
                            UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.action.ThirdAPPUriAccessAction.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    mainContext.startScene(bundle2, 3);
                                }
                            }, 300L);
                        } else {
                            mainContext.startScene(bundle2, 3);
                        }
                        CallThirdPartLoginService.closeUserCenterFromClient();
                        SettingStatUtil.sendStatDataWhenCallWeChat(mainContext);
                    }
                }
            }
            return true;
        }
        throw new IllegalArgumentException("IIntentActionContext is null ");
    }

    private void sendStatData(MainContext mainContext, Uri uri, NaviRouteInfo naviRouteInfo) {
        String str;
        if (mainContext == null || uri == null || naviRouteInfo == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter(ThemeManager.AttributeSet.SRC);
        if (!TextUtils.isEmpty(queryParameter)) {
            if (PACKAGE_NAME_STATE_GRID.equals(queryParameter)) {
                str = String.valueOf(108);
                SettingStatUtil.sendStatDataWhenThirdPartCalled(mainContext, naviRouteInfo, BtnType.NAVI_GUIDER_GUO_DIAN_CALLED, str);
            } else if ("com.xiaopeng.caraccount".equals(queryParameter)) {
                str = String.valueOf(113);
                SettingStatUtil.sendStatDataWhenThirdPartCalled(mainContext, naviRouteInfo, BtnType.NAVI_GUIDER_MAINTENANCE_SUPPORT_CALLED, str);
            }
            SettingStatUtil.sendStatDataWhenThirdPartCalled(mainContext, naviRouteInfo, BtnType.NAVI_GUIDER_INTERFACE_CALLED, str);
        }
        str = "";
        SettingStatUtil.sendStatDataWhenThirdPartCalled(mainContext, naviRouteInfo, BtnType.NAVI_GUIDER_INTERFACE_CALLED, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MapViewWrapper getMapViewWrapper(IIntentActionContext iIntentActionContext) {
        return iIntentActionContext.getMainContext().getMapView();
    }
}
