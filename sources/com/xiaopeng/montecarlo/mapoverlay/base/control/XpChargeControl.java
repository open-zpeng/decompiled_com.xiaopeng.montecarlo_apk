package com.xiaopeng.montecarlo.mapoverlay.base.control;

import com.autonavi.gbl.layer.model.BizUserType;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.navcore.control.BizControlWrapper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class XpChargeControl extends BaseControl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public XpChargeControl(MainContext mainContext) {
        super(mainContext);
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.control.BaseControl
    void init() {
        this.mOverlayType = BizUserType.BizUserTypeFavoritePoi;
        this.mBizControlType = BizControlWrapper.BIZ_CONTROL_TYPE_USER;
        this.mMainContext.getMapView().getBizControlManager().setClickable(this.mBizControlType, this.mOverlayType, true);
    }
}
