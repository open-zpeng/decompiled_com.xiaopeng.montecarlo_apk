package com.xiaopeng.montecarlo.mapoverlay.base.control;

import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.navcore.control.BizControlWrapper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class XpRGCControl extends BaseControl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public XpRGCControl(MainContext mainContext) {
        super(mainContext);
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.control.BaseControl
    void init() {
        this.mOverlayType = 20004;
        this.mBizControlType = BizControlWrapper.BIZ_CONTROL_TYPE_CUSTOM;
        this.mMainContext.getMapView().getBizControlManager().setClickable(this.mBizControlType, this.mOverlayType, true);
    }
}
