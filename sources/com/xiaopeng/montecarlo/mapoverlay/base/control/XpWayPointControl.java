package com.xiaopeng.montecarlo.mapoverlay.base.control;

import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.navcore.control.BizControlWrapper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class XpWayPointControl extends BaseControl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public XpWayPointControl(MainContext mainContext) {
        super(mainContext);
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.control.BaseControl
    void init() {
        this.mOverlayType = 6003;
        this.mBizControlType = BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE;
        this.mMainContext.getMapView().getBizControlManager().setClickable(this.mBizControlType, this.mOverlayType, true);
    }
}
