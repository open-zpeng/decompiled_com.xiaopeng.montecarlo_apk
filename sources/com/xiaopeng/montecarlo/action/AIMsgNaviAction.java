package com.xiaopeng.montecarlo.action;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.aimessage.AiMsgManager;
import com.xiaopeng.montecarlo.aimessage.AiMsgUtils;
import com.xiaopeng.montecarlo.aimessage.type.MapRouteMsg;
import com.xiaopeng.montecarlo.base.IRouteUpdateContract;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.bridge.ExploreBridge;
import com.xiaopeng.montecarlo.bridge.NaviBridge;
import com.xiaopeng.montecarlo.bridge.RouteBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.constants.SystemConst;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import com.xiaopeng.montecarlo.util.ChargeSearchAlongWayController;
/* loaded from: classes.dex */
public class AIMsgNaviAction implements IIntentAction {
    private static final L.Tag TAG = new L.Tag("AIMsgNaviAction");
    private ChargeSearchAlongWayController mController;

    @Override // com.xiaopeng.montecarlo.action.IIntentAction
    public boolean handlerIntentAction(IIntentActionContext iIntentActionContext, Intent intent) {
        RouteRequest createNewDesRequestWithVias;
        if (iIntentActionContext != null) {
            if (intent == null) {
                throw new IllegalArgumentException("intent is null");
            }
            final MainContext mainContext = iIntentActionContext.getMainContext();
            if (mainContext != null) {
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    L.e(TAG, "bundle is null");
                    return false;
                }
                final IBaseScene currentScene = mainContext.getCurrentScene();
                if (currentScene == null) {
                    return false;
                }
                final int i = extras.getInt(MapRouteMsg.MAPROUTEMSG_FUNCTION, -1);
                boolean booleanExtra = intent.getBooleanExtra(AiMsgUtils.KEY_EXTRA_IS_SUCCEED, false);
                L.Tag tag = TAG;
                L.i(tag, "operateType=" + i + "  isSucceed=" + booleanExtra);
                XPPoiInfo xPPoiInfo = (XPPoiInfo) intent.getParcelableExtra(AiMsgUtils.KEY_EXTRA_END_INFO);
                PageType pageType = PageType.NAVI_CRUISE;
                if (currentScene.getMode() == StatusConst.Mode.CRUISE) {
                    pageType = PageType.NAVI_CRUISE;
                } else if (currentScene.getMode() == StatusConst.Mode.ROUTE) {
                    pageType = PageType.NAVI_ROUTING;
                } else if (currentScene.getMode() == StatusConst.Mode.EXPLORE) {
                    pageType = PageType.NAVI_DETECT_ROUTE;
                } else if (currentScene.getMode() == StatusConst.Mode.NAVI) {
                    pageType = PageType.NAVI_GUIDANCE;
                } else if (currentScene.getMode() == StatusConst.Mode.SEARCH) {
                    pageType = PageType.SEARCH_MAIN_PAGE;
                } else if (currentScene.getMode() == StatusConst.Mode.SEARCH_RESULT) {
                    pageType = PageType.Navi_Search_Main_Result;
                } else if (currentScene.getMode() == StatusConst.Mode.SEARCH_RESULT) {
                    pageType = PageType.Navi_Search_Main_Result;
                }
                if (i == 0 && xPPoiInfo == null) {
                    if (currentScene == null) {
                        return false;
                    }
                    L.Tag tag2 = TAG;
                    L.i(tag2, "sceneMode=" + currentScene.getMode());
                    if (currentScene.getMode() == StatusConst.Mode.NAVI || currentScene.getMode() == StatusConst.Mode.ROUTE || currentScene.getMode() == StatusConst.Mode.EXPLORE) {
                        return false;
                    }
                    sendMessage2CloseAIAssistant(mainContext);
                    if (booleanExtra) {
                        DataLogUtil.sendStatData(pageType, BtnType.AI_TRAFFIC_DRAW_PATH, Float.valueOf(TBTManager.getInstance().getCarSpeed()));
                        sendStatCallNaviEvent(xPPoiInfo, pageType);
                        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.action.AIMsgNaviAction.1
                            @Override // java.lang.Runnable
                            public void run() {
                                RouteBridge routeBridge = new RouteBridge();
                                Bundle bundle = new Bundle();
                                bundle.putString(RouteBridge.ROUTE_SENDER, RouteBridge.ROUTE_SENDER_AIMSG);
                                routeBridge.setBundle(bundle);
                                mainContext.startScene(routeBridge, 0);
                            }
                        }, 500L);
                    } else {
                        mainContext.showPrompt(R.string.route_fail_reason_general);
                    }
                } else if (i == 3) {
                    if (this.mController == null) {
                        this.mController = new ChargeSearchAlongWayController(mainContext);
                    }
                    this.mController.checkScene(currentScene);
                    if (L.ENABLE) {
                        L.d(TAG, "receive ai message to charge search");
                    }
                } else {
                    if (i == 4) {
                        createNewDesRequestWithVias = RouteRequest.createNewDesRequestWithVias(xPPoiInfo, intent.getParcelableArrayListExtra(AiMsgUtils.KEY_EXTRA_VIA), -1);
                    } else {
                        createNewDesRequestWithVias = RouteRequest.createNewDesRequestWithVias(xPPoiInfo, intent.getParcelableArrayListExtra(AiMsgUtils.KEY_EXTRA_VIA), -1);
                    }
                    sendMessage2CloseAIAssistant(mainContext);
                    if (booleanExtra) {
                        sendStatCallNaviEvent(xPPoiInfo, pageType);
                        final RouteRequest routeRequest = createNewDesRequestWithVias;
                        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.action.AIMsgNaviAction.2
                            @Override // java.lang.Runnable
                            public void run() {
                                L.Tag tag3 = AIMsgNaviAction.TAG;
                                L.i(tag3, "handlerIntentAction scene.getMode()=" + currentScene.getMode());
                                if (i == 0) {
                                    DataLogUtil.sendStatData(currentScene.getPageType(), BtnType.AI_TRAFFIC_START_NAVI, Float.valueOf(TBTManager.getInstance().getCarSpeed()));
                                }
                                currentScene.removeAllChildScene();
                                StateManager.getInstance().switchActiveState();
                                mainContext.getMapView().getBizControlManager().openDynamicLevel(false);
                                mainContext.getDecoratorManager().clearFocus();
                                Bundle bundle = routeRequest.toBundle();
                                bundle.putBoolean(MapRouteMsg.MAPROUTEMSG_IS_FILTER_CHARGE, i != 4);
                                if (i == 4) {
                                    bundle.putString(SystemConst.ROUTE_TYPE_KEY, SystemConst.ROUTE_TYPE_FROM_PHONE);
                                }
                                if (currentScene.getMode() == StatusConst.Mode.NAVI || currentScene.getMode() == StatusConst.Mode.ROUTE || currentScene.getMode() == StatusConst.Mode.EXPLORE) {
                                    L.i(AIMsgNaviAction.TAG, "onRouteUpdate");
                                    if (i == 4) {
                                        ((IRouteUpdateContract) currentScene.getPresenter()).onRouteUpdate(bundle);
                                        return;
                                    } else if (currentScene.getPresenter() instanceof BaseMapDecorator.IMapDecoratorRouteUpdateListener) {
                                        ((BaseMapDecorator.IMapDecoratorRouteUpdateListener) currentScene.getPresenter()).onRouteUpdate(null, bundle);
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                if (TBTManager.getInstance().getCurrentStatus() != 0) {
                                    if (TBTManager.getInstance().getCurrentStatus() == 2) {
                                        currentScene.startScene(new ExploreBridge().setBundle(bundle));
                                    } else {
                                        currentScene.startScene(new NaviBridge().setBundle(bundle));
                                    }
                                } else {
                                    currentScene.startScene(new RouteBridge().setBundle(bundle));
                                }
                                L.i(AIMsgNaviAction.TAG, "startScene");
                            }
                        }, 500L);
                    } else {
                        mainContext.showPrompt(R.string.route_fail_reason_general);
                    }
                }
            }
            return true;
        }
        throw new IllegalArgumentException("IIntentActionContext is null ");
    }

    private void sendStatCallNaviEvent(XPPoiInfo xPPoiInfo, PageType pageType) {
        if (xPPoiInfo != null) {
            XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble();
            xPCoordinate2DDouble.mLat = xPPoiInfo.getNaviLat();
            xPCoordinate2DDouble.mLon = xPPoiInfo.getNaviLon();
            BtnType btnType = BtnType.CALL_NAVI_EVENT;
            Object[] objArr = new Object[4];
            objArr[0] = TextUtils.isEmpty(xPPoiInfo.getPoiId()) ? "" : xPPoiInfo.getPoiId();
            objArr[1] = Integer.valueOf(xPPoiInfo.getType());
            objArr[2] = TextUtils.isEmpty(xPPoiInfo.getBlCategory()) ? "" : xPPoiInfo.getBlCategory();
            objArr[3] = xPCoordinate2DDouble;
            DataLogUtil.sendStatData(pageType, btnType, objArr);
        }
    }

    private void sendMessage2CloseAIAssistant(MainContext mainContext) {
        AiMsgManager aiMsgManager = mainContext.getAiMsgManager();
        if (aiMsgManager != null) {
            aiMsgManager.sendData(IpcConfig.AIAssistantConfig.IPC_APP_CLOSE_AI_HOME, null, "com.xiaopeng.aiassistant");
        }
    }
}
