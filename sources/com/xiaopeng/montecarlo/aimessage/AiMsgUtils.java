package com.xiaopeng.montecarlo.aimessage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.lib.utils.view.ToastUtils;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.montecarlo.IntentActions;
import com.xiaopeng.montecarlo.MainActivity;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.aimessage.AiMsgManager;
import com.xiaopeng.montecarlo.aimessage.type.MapPoint;
import com.xiaopeng.montecarlo.aimessage.type.MapRouteMsg;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.apirouter.IpcRouterUtil;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.RouteManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.service.navi.INaviStatusService;
import com.xiaopeng.montecarlo.service.navi.LocalNaviService;
import com.xiaopeng.montecarlo.service.navi.binder.NaviServiceManager;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
import com.xiaopeng.speech.protocol.node.navi.bean.ViaBean;
import java.util.ArrayList;
import javax.validation.constraints.NotNull;
/* loaded from: classes.dex */
public class AiMsgUtils {
    public static final String KEY_EXTRA_END_INFO = "endInfo";
    public static final String KEY_EXTRA_IS_SUCCEED = "isSucceed";
    public static final String KEY_EXTRA_VIA = "via";
    private static final L.Tag TAG = new L.Tag("AiMsgUtils");
    private static AiMsgUtils sInstance = new AiMsgUtils();
    private long mRouteRequestId = -1;
    private long mFromPhoneRouteRequestId = -1;
    private boolean mIsRunInBackground = true;
    private boolean mNeedChargeSearchWhenRestore = false;

    private AiMsgUtils() {
    }

    public static AiMsgUtils getInstance() {
        return sInstance;
    }

    public static boolean isCarStateMsg(@NonNull AiMsgManager.IpcMessage ipcMessage) {
        return CarFeatureManager.INSTANCE.isIpcExchange2Apirouter() ? "com.xiaopeng.aiassistant".equals(ipcMessage.getSenderPackageName()) && 10012 == ipcMessage.getMsgID() : IpcConfig.App.MESSAGE_CENTER.equals(ipcMessage.getSenderPackageName()) && 10012 == ipcMessage.getMsgID();
    }

    public static boolean isCarStateGetOnMsg(@NonNull AiMsgManager.IpcMessage ipcMessage) {
        return isCarStateMsg(ipcMessage) && ipcMessage.getIntValue() == 1;
    }

    public long getRouteResult() {
        return this.mRouteRequestId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAppInBackground() {
        return this.mIsRunInBackground;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAppInBackground(boolean z) {
        this.mIsRunInBackground = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendMapToFront() {
        Intent intent = new Intent(ContextUtils.getContext(), MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(IntentActions.ActionsKey.KEY_ACTION, IntentActions.ACTION_ACTIVITY_TO_FRONT);
        intent.putExtras(bundle);
        ContextUtils.startActivityWithNewTask(intent);
    }

    public void doRoute(@NonNull MapRouteMsg mapRouteMsg, int i) {
        doRoute(mapRouteMsg, i, true);
    }

    public void doRoute(@NonNull final MapRouteMsg mapRouteMsg, final int i, final boolean z) {
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.aimessage.AiMsgUtils.1
            @Override // java.lang.Runnable
            public void run() {
                XPPoiInfo startPOIFromCurrent;
                MapPoint start = mapRouteMsg.getStart();
                MapPoint dest = mapRouteMsg.getDest();
                if (dest == null) {
                    L.e(AiMsgUtils.TAG, "doRoute endPoint is null.");
                    return;
                }
                if (start != null) {
                    startPOIFromCurrent = TBTManager.getInstance().generateStartPoint(new XPCoordinate2DDouble(start.getLon(), start.getLat()));
                } else {
                    startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
                }
                XPPoiInfo generateEndPoiInfo = AiMsgUtils.this.generateEndPoiInfo(dest);
                if (L.ENABLE) {
                    L.d(AiMsgUtils.TAG, "doRoute requestRouteSync");
                }
                int i2 = i;
                if (i2 == 0 && z) {
                    routeTask(startPOIFromCurrent, generateEndPoiInfo, i2);
                } else if (i == 4) {
                    AiMsgUtils.this.routeSilenceTask(TBTManager.getInstance().getStartPOIFromCurrent(), generateEndPoiInfo, AiMsgUtils.this.generateViaPoints(mapRouteMsg.getVia()), i);
                } else {
                    naviExploreTask(AiMsgUtils.this.generateViaPoints(mapRouteMsg.getVia()), generateEndPoiInfo, i);
                }
            }

            private void naviExploreTask(ArrayList<XPViaPoint> arrayList, Parcelable parcelable, int i2) {
                Intent intent = new Intent(ContextUtils.getContext(), MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(IntentActions.ActionsKey.KEY_ACTION, IntentActions.ACTION_AI_MSG_DISPATCH_MAP);
                bundle.putBoolean(AiMsgUtils.KEY_EXTRA_IS_SUCCEED, true);
                bundle.putParcelable(AiMsgUtils.KEY_EXTRA_END_INFO, parcelable);
                bundle.putParcelableArrayList(AiMsgUtils.KEY_EXTRA_VIA, arrayList);
                bundle.putInt(MapRouteMsg.MAPROUTEMSG_FUNCTION, i2);
                intent.putExtras(bundle);
                ContextUtils.startActivityWithNewTask(intent);
            }

            private void routeTask(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2, final int i2) {
                AiMsgUtils.this.mRouteRequestId = TBTManager.getInstance().requestRoute(new RouteParams.Builder().setStartInfo(xPPoiInfo).setEndInfo(xPPoiInfo2).setRouteLevel(0).build(), new RouteManager.IRouteResultListener() { // from class: com.xiaopeng.montecarlo.aimessage.AiMsgUtils.1.1
                    @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
                    public void onNewRouteSuccess(long j, RouteResult routeResult) {
                        if (AiMsgUtils.this.mRouteRequestId == j) {
                            AiMsgUtils.this.startMainActivity(i2, true);
                        }
                    }

                    @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
                    public void onNewRouteError(long j, RouteResult routeResult) {
                        L.e(AiMsgUtils.TAG, "requestRouteSync Error!");
                        if (AiMsgUtils.this.mRouteRequestId == j) {
                            if (AiMsgUtils.this.mIsRunInBackground) {
                                Intent intent = new Intent(ContextUtils.getContext(), MainActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString(IntentActions.ActionsKey.KEY_ACTION, IntentActions.ACTION_ACTIVITY_TO_FRONT);
                                intent.putExtras(bundle);
                                ContextUtils.startActivityWithNewTask(intent);
                            } else {
                                AiMsgUtils.this.startMainActivity(i2, false);
                            }
                        }
                        if (routeResult.mErrorCode != 822083620) {
                            TBTManager.getInstance().clearRouteData(j);
                        }
                    }
                });
            }
        });
    }

    public void chargeSearch() {
        this.mNeedChargeSearchWhenRestore = true;
        startMainActivity(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void routeSilenceTask(XPPoiInfo xPPoiInfo, final XPPoiInfo xPPoiInfo2, final ArrayList<XPViaPoint> arrayList, final int i) {
        this.mFromPhoneRouteRequestId = TBTManager.getInstance().requestRoute(new RouteParams.Builder().setStartInfo(xPPoiInfo).setEndInfo(xPPoiInfo2).setViaInfos(arrayList).setRouteLevel(0).build(), new RouteManager.IRouteResultListener() { // from class: com.xiaopeng.montecarlo.aimessage.AiMsgUtils.2
            @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
            public void onNewRouteSuccess(long j, RouteResult routeResult) {
                if (AiMsgUtils.this.mFromPhoneRouteRequestId == j) {
                    AiMsgUtils.this.startMainActivity(i, true, xPPoiInfo2, arrayList);
                }
            }

            @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
            public void onNewRouteError(long j, RouteResult routeResult) {
                L.Tag tag = AiMsgUtils.TAG;
                L.e(tag, "requestRouteSync Error, error code: " + routeResult.mErrorCode);
                if (AiMsgUtils.this.mFromPhoneRouteRequestId == j && routeResult.mErrorCode != 822083620) {
                    ToastUtils.showToast(ContextUtils.getContext(), (822083585 == routeResult.mErrorCode || 822083599 == routeResult.mErrorCode || 822083600 == routeResult.mErrorCode) ? R.string.route_charge_send2car_route_fail_msg : R.string.route_fail_reason_general);
                }
                if (routeResult.mErrorCode != 822083620) {
                    TBTManager.getInstance().clearRouteData(j);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public ArrayList<XPViaPoint> generateViaPoints(MapPoint[] mapPointArr) {
        ArrayList<XPViaPoint> arrayList = new ArrayList<>();
        if (CollectionUtils.isEmpty(mapPointArr)) {
            return arrayList;
        }
        for (MapPoint mapPoint : mapPointArr) {
            if (mapPoint != null) {
                PoiBean poiBean = new PoiBean();
                poiBean.setLatitude(mapPoint.getLat());
                poiBean.setLongitude(mapPoint.getLon());
                poiBean.setName(mapPoint.getName());
                poiBean.setAddress(mapPoint.getAddress());
                poiBean.setTypeCode(mapPoint.getPoiType());
                poiBean.setPoiId(mapPoint.getPoiId());
                ViaBean viaBean = new ViaBean();
                if ("2".equals(mapPoint.getType())) {
                    viaBean.setViaType(4);
                } else if ("1".equals(mapPoint.getType())) {
                    viaBean.setViaType(2);
                }
                viaBean.setPointInfo(poiBean);
                arrayList.add(new XPViaPoint(viaBean));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public XPPoiInfo generateEndPoiInfo(MapPoint mapPoint) {
        XPPoiInfo xPPoiInfo = new XPPoiInfo();
        if (mapPoint == null) {
            return xPPoiInfo;
        }
        xPPoiInfo.setDisplayLat(mapPoint.getLat());
        xPPoiInfo.setDisplayLon(mapPoint.getLon());
        xPPoiInfo.setNaviLat(mapPoint.getLat());
        xPPoiInfo.setNaviLon(mapPoint.getLon());
        xPPoiInfo.setAddress(mapPoint.getAddress());
        xPPoiInfo.setName(mapPoint.getName());
        xPPoiInfo.setBlCategory(mapPoint.getPoiType());
        xPPoiInfo.setCategory(XPPoiCategory.transformCategory(mapPoint.getPoiType()));
        xPPoiInfo.setPoiId(mapPoint.getPoiId());
        XPPoiInfo.generatePoiIdIfEmpty(xPPoiInfo, 4);
        return xPPoiInfo;
    }

    public void startMainActivity(int i) {
        startMainActivity(i, true);
    }

    public void startMainActivity(int i, boolean z) {
        startMainActivity(i, z, null, null);
    }

    public void startMainActivity(int i, boolean z, Parcelable parcelable, ArrayList<XPViaPoint> arrayList) {
        Intent intent = new Intent(ContextUtils.getContext(), MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(IntentActions.ActionsKey.KEY_ACTION, IntentActions.ACTION_AI_MSG_DISPATCH_MAP);
        bundle.putInt(MapRouteMsg.MAPROUTEMSG_FUNCTION, i);
        bundle.putBoolean(KEY_EXTRA_IS_SUCCEED, z);
        if (parcelable != null) {
            bundle.putParcelable(KEY_EXTRA_END_INFO, parcelable);
        }
        if (arrayList != null) {
            bundle.putParcelableArrayList(KEY_EXTRA_VIA, arrayList);
        }
        intent.putExtras(bundle);
        ContextUtils.startActivityWithNewTask(intent);
    }

    public StatusConst.Mode getCurrentSceneMode() {
        INaviStatusService asInterface = INaviStatusService.Stub.asInterface(LocalNaviService.getInstance().getService(ContextUtils.getContext(), NaviServiceManager.NAVI_STATUS));
        if (asInterface != null) {
            try {
                return StatusConst.Mode.valueOf(asInterface.getCurrentSceneName(true));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return StatusConst.Mode.EMPTY;
    }

    public static void closeAIAssistant(String str) {
        L.Tag tag = TAG;
        L.i(tag, "closeAIAssistant " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(IpcConfig.IPCKey.STRING_MSG, str);
        if (CarFeatureManager.INSTANCE.isIpcExchange2Apirouter()) {
            IpcRouterUtil.sendData((int) IpcConfig.AIAssistantConfig.IPC_MESSAGE_CLOSE, bundle, "com.xiaopeng.aiassistant");
        } else {
            ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).sendData(IpcConfig.AIAssistantConfig.IPC_MESSAGE_CLOSE, bundle, "com.xiaopeng.aiassistant");
        }
    }

    public boolean getNeedChargeSearchWhenRestore() {
        return this.mNeedChargeSearchWhenRestore;
    }

    public void setNeedChargeSearchWhenRestore(boolean z) {
        this.mNeedChargeSearchWhenRestore = z;
    }
}
