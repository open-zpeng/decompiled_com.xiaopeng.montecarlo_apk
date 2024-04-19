package com.xiaopeng.montecarlo.mapoverlay;

import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
/* loaded from: classes2.dex */
public class WayPointDecorator extends BaseMapDecorator {
    public static final String KEY_VIA_LIST = "via_list";

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public int getOverlayType() {
        return 6003;
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public boolean isGlobalDecorator() {
        return true;
    }

    public WayPointDecorator(DecoratorType decoratorType, MainContext mainContext, BaseMapDecorator.IMapDecoratorStatusListener iMapDecoratorStatusListener) {
        super(decoratorType, mainContext, iMapDecoratorStatusListener);
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    protected BaseDecoratorPresenter createPresenter() {
        return new WayPointDecoratorPresenter(this.mDecoratorCallback);
    }
}
