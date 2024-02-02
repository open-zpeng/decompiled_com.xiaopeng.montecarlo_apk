package com.xiaopeng.montecarlo.mapoverlay.base.control;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IXpLayerClickObserver;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class BaseControl implements IDecoratorOverlayItemOperation {
    protected String mBizControlType;
    protected MainContext mMainContext;
    protected int mOverlayType;
    private final L.Tag mTag = new L.Tag("POP=>" + getClass().getSimpleName());

    abstract void init();

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.control.IDecoratorOverlayItemOperation
    public boolean updateOverlayItems(List<XPPointBaseData> list) {
        return false;
    }

    public BaseControl(MainContext mainContext) {
        this.mMainContext = mainContext;
        init();
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.control.IDecoratorOverlayItemOperation
    public void addOverlayItems(List<XPPointBaseData> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        this.mMainContext.getMapView().getBizControlManager().addItems(this.mBizControlType, this.mOverlayType, (XPPointBaseData[]) CollectionUtils.toArray(list, XPPointBaseData.class));
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.control.IDecoratorOverlayItemOperation
    public void removeOverlayItems(List<XPPointBaseData> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (XPPointBaseData xPPointBaseData : list) {
            if (xPPointBaseData != null) {
                arrayList.add(xPPointBaseData.id);
            }
        }
        String[] strArr = (String[]) CollectionUtils.toArray(arrayList, String.class);
        if (CollectionUtils.isNotEmpty(strArr)) {
            this.mMainContext.getMapView().getBizControlManager().removeItems(this.mBizControlType, this.mOverlayType, strArr);
        }
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.control.IDecoratorOverlayItemOperation
    public void setOverlayItemFocusStatus(XPPointBaseData xPPointBaseData, boolean z) {
        if (xPPointBaseData != null && !TextUtils.isEmpty(xPPointBaseData.id)) {
            if (L.ENABLE) {
                L.Tag tag = this.mTag;
                L.d(tag, "setOverlayItemFocusStatus " + xPPointBaseData.id + ", focus = " + z);
            }
            this.mMainContext.getMapView().getBizControlManager().setFocus(this.mBizControlType, this.mOverlayType, xPPointBaseData.id, z);
            return;
        }
        L.Tag tag2 = this.mTag;
        L.e(tag2, "setOverlayItemFocusStatus failure bFocus:" + z + ",data:" + xPPointBaseData);
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.control.IDecoratorOverlayItemOperation
    public void clearOverlay() {
        this.mMainContext.getMapView().getBizControlManager().clearAllItems(this.mBizControlType, this.mOverlayType);
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.control.IDecoratorOverlayItemOperation
    public void setOverlayVisible(boolean z) {
        this.mMainContext.getMapView().getBizControlManager().setVisible(this.mBizControlType, this.mOverlayType, z);
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.control.IDecoratorOverlayItemOperation
    public void addOverlayObserver(int i, IXpLayerClickObserver iXpLayerClickObserver) {
        this.mMainContext.getMapView().getBizControlManager().addClickObserver(this.mBizControlType, this.mOverlayType, iXpLayerClickObserver);
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.control.IDecoratorOverlayItemOperation
    public void removeOverlayObserver(int i, IXpLayerClickObserver iXpLayerClickObserver) {
        this.mMainContext.getMapView().getBizControlManager().removeClickObserver(this.mBizControlType, this.mOverlayType, iXpLayerClickObserver);
    }
}
