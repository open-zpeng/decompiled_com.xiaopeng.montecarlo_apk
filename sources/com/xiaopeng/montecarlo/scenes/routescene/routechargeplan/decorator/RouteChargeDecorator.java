package com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator;

import android.text.TextUtils;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.observer.impl.ClickViewIdInfo;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.control.BizControlWrapper;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IXpLayerClickObserver;
import com.xiaopeng.montecarlo.navcore.util.MarkUtils;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.IRouteChargeDecoratorContract;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class RouteChargeDecorator implements IRouteChargeDecoratorContract.IRouteChargeDecorator, IXpLayerClickObserver {
    public static final String ROUTE_CHARGE_POST = ")RC_END_";
    public static final String ROUTE_CHARGE_PRE = "RC_START(";
    private static final L.Tag TAG = new L.Tag("ROUTE_CHARGE_RCDec");
    public static final int TYPE_REACHABLE_KEEPER = 15;
    public static final int TYPE_REACHABLE_LAST = 2;
    public static final int TYPE_REACHABLE_NORMAL = 1;
    public static final int TYPE_REACHABLE_NOT = 4;
    public static final int TYPE_SELECTED = 16;
    public static final int TYPE_SELECTED_KEEPER = 240;
    private XPPointBaseData[] mBizPointBaseData;
    private boolean mIsFocused = false;
    private IRouteChargeDecoratorListener mListener;
    private MainContext mMainContext;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface DecoratorType {
    }

    /* loaded from: classes3.dex */
    public interface IRouteChargeDecoratorListener {
        void onFocusCharge(String str, int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int addType(int i, int i2) {
        return (i & (i2 >= 16 ? 15 : TYPE_SELECTED_KEEPER)) | i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int eraseType(int i, int i2) {
        return i ^ i2;
    }

    private int getOverlayType() {
        return 20002;
    }

    static int getReachableType(int i) {
        return i & 15;
    }

    public static boolean isReachable(int i) {
        return ((i & 1) == 0 && (i & 2) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSelected(int i) {
        return (i & 16) != 0;
    }

    public RouteChargeDecorator(MainContext mainContext) {
        this.mMainContext = mainContext;
        this.mMainContext.getMapView().getBizControlManager().setClickable(BizControlWrapper.BIZ_CONTROL_TYPE_CUSTOM, getOverlayType(), true);
        this.mMainContext.getMapView().getBizControlManager().routeChargeDecorator(getOverlayType(), this);
    }

    public static int[] createRouteChargeTexture(String str) {
        int i;
        int parseBizType = parseBizType(str);
        boolean isSelected = isSelected(parseBizType);
        int i2 = -1;
        if ((parseBizType & 2) != 0) {
            i2 = isSelected ? MarkUtils.MARKER_ID_ROUTE_CHARGE_SELECT_LAST_REACHABLE : MarkUtils.MARKER_ID_ROUTE_CHARGE_LAST_REACHABLE;
            i = isSelected ? MarkUtils.MARKER_ID_ROUTE_CHARGE_FOCUS_SELECT_LAST_REACHABLE : MarkUtils.MARKER_ID_ROUTE_CHARGE_FOCUS_LAST_REACHABLE;
        } else if ((parseBizType & 1) != 0) {
            i2 = isSelected ? MarkUtils.MARKER_ID_ROUTE_CHARGE_SELECT_REACHABLE : MarkUtils.MARKER_ID_ROUTE_CHARGE_REACHABLE;
            i = isSelected ? MarkUtils.MARKER_ID_ROUTE_CHARGE_FOCUS_SELECT_REACHABLE : MarkUtils.MARKER_ID_ROUTE_CHARGE_FOCUS_REACHABLE;
        } else if ((parseBizType & 4) != 0) {
            i2 = 493;
            i = 500;
        } else {
            i = -1;
        }
        return new int[]{i2, i};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int parseBizType(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        int indexOf = str.indexOf(ROUTE_CHARGE_PRE);
        int indexOf2 = str.indexOf(ROUTE_CHARGE_POST);
        if (indexOf < 0 || indexOf2 < 0 || (i = indexOf + 9) > str.length() - 1) {
            return -1;
        }
        String substring = str.substring(i, indexOf2);
        if (TextUtils.isEmpty(substring)) {
            return -1;
        }
        return Integer.parseInt(substring);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String parseBizStationId(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(ROUTE_CHARGE_PRE);
        int indexOf2 = str.indexOf(ROUTE_CHARGE_POST);
        return (indexOf < 0 || indexOf2 < 0 || (i = indexOf2 + 8) > str.length() + (-1)) ? "" : str.substring(i);
    }

    public boolean isFocused() {
        return this.mIsFocused;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.IRouteChargeDecoratorContract.IRouteChargeDecorator
    public void focus(int i) {
        if (i <= -1 || i >= this.mBizPointBaseData.length) {
            return;
        }
        this.mIsFocused = true;
        this.mMainContext.getMapView().getBizControlManager().setFocus(BizControlWrapper.BIZ_CONTROL_TYPE_CUSTOM, getOverlayType(), this.mBizPointBaseData[i].id, true);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.IRouteChargeDecoratorContract.IRouteChargeDecorator
    public void unFocus() {
        this.mIsFocused = false;
        this.mMainContext.getMapView().getBizControlManager().clearFocus(BizControlWrapper.BIZ_CONTROL_TYPE_CUSTOM, getOverlayType());
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.IRouteChargeDecoratorContract.IRouteChargeDecorator
    public void showCharges(XPPointBaseData[] xPPointBaseDataArr) {
        L.Tag tag = TAG;
        L.i(tag, "showCharges size " + xPPointBaseDataArr.length);
        this.mBizPointBaseData = xPPointBaseDataArr;
        this.mMainContext.getMapView().getBizControlManager().showCharges(xPPointBaseDataArr, getOverlayType());
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.IRouteChargeDecoratorContract.IRouteChargeDecorator
    public void hideCharges() {
        L.i(TAG, "hideCharges");
        this.mMainContext.getMapView().getBizControlManager().clearAllItems(BizControlWrapper.BIZ_CONTROL_TYPE_CUSTOM, getOverlayType());
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.IRouteChargeDecoratorContract.IRouteChargeDecorator
    public void removeCharges(XPPointBaseData[] xPPointBaseDataArr) {
        this.mMainContext.getMapView().getBizControlManager().clearAllItems(BizControlWrapper.BIZ_CONTROL_TYPE_CUSTOM, getOverlayType());
        if (xPPointBaseDataArr == null || xPPointBaseDataArr.length <= 0) {
            return;
        }
        String[] strArr = new String[xPPointBaseDataArr.length];
        for (int i = 0; i < xPPointBaseDataArr.length; i++) {
            strArr[i] = xPPointBaseDataArr[i].id;
        }
        this.mMainContext.getMapView().getBizControlManager().removeItems(BizControlWrapper.BIZ_CONTROL_TYPE_CUSTOM, getOverlayType(), strArr);
    }

    public void setListener(IRouteChargeDecoratorListener iRouteChargeDecoratorListener) {
        this.mListener = iRouteChargeDecoratorListener;
    }

    public void unInit() {
        this.mMainContext.getMapView().getBizControlManager().removeClickObserver(BizControlWrapper.BIZ_CONTROL_TYPE_CUSTOM, getOverlayType(), this);
        this.mListener = null;
    }

    protected int findIndexByBizData(String str) {
        if (str == null || TextUtils.isEmpty(str) || !CollectionUtils.isNotEmpty(this.mBizPointBaseData)) {
            return -1;
        }
        int i = 0;
        while (true) {
            XPPointBaseData[] xPPointBaseDataArr = this.mBizPointBaseData;
            if (i >= xPPointBaseDataArr.length) {
                return -1;
            }
            XPPointBaseData xPPointBaseData = xPPointBaseDataArr[i];
            if (xPPointBaseData != null && str.equals(xPPointBaseData.id)) {
                return i;
            }
            i++;
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.ILayerClickObserver
    public void onNotifyClick(BaseLayer baseLayer, LayerItem layerItem, ClickViewIdInfo clickViewIdInfo) {
        if (layerItem == null) {
            return;
        }
        String id = layerItem.getID();
        int findIndexByBizData = findIndexByBizData(id);
        String parseBizStationId = parseBizStationId(id);
        int parseBizType = parseBizType(id);
        L.Tag tag = TAG;
        L.i(tag, "ROUTE_CHARGE click id: " + id + ", type: " + parseBizType + ", index: " + findIndexByBizData);
        XPPointBaseData[] xPPointBaseDataArr = this.mBizPointBaseData;
        if (xPPointBaseDataArr == null || findIndexByBizData < 0 || findIndexByBizData > xPPointBaseDataArr.length - 1) {
            return;
        }
        IRouteChargeDecoratorListener iRouteChargeDecoratorListener = this.mListener;
        if (iRouteChargeDecoratorListener != null) {
            iRouteChargeDecoratorListener.onFocusCharge(parseBizStationId, findIndexByBizData, parseBizType);
        }
        this.mIsFocused = true;
        this.mMainContext.getMapView().getBizControlManager().setFocus(BizControlWrapper.BIZ_CONTROL_TYPE_CUSTOM, getOverlayType(), id, true);
    }
}
