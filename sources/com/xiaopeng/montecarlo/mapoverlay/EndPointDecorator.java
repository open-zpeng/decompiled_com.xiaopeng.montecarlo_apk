package com.xiaopeng.montecarlo.mapoverlay;

import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
/* loaded from: classes.dex */
public class EndPointDecorator extends BaseMapDecorator {
    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public int getOverlayType() {
        return 6002;
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public boolean isGlobalDecorator() {
        return true;
    }

    public EndPointDecorator(DecoratorType decoratorType, MainContext mainContext, BaseMapDecorator.IMapDecoratorStatusListener iMapDecoratorStatusListener) {
        super(decoratorType, mainContext, iMapDecoratorStatusListener);
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    protected BaseDecoratorPresenter createPresenter() {
        return new EndPointPresenter(this.mDecoratorCallback);
    }
}
