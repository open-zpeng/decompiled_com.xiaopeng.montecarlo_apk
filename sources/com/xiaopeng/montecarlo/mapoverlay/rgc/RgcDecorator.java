package com.xiaopeng.montecarlo.mapoverlay.rgc;

import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.mapoverlay.poidetail.PoiDetailDecorator;
/* loaded from: classes.dex */
public class RgcDecorator extends PoiDetailDecorator {
    @Override // com.xiaopeng.montecarlo.mapoverlay.poidetail.PoiDetailDecorator, com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public int getOverlayType() {
        return 20004;
    }

    public RgcDecorator(DecoratorType decoratorType, MainContext mainContext, BaseMapDecorator.IMapDecoratorStatusListener iMapDecoratorStatusListener) {
        super(decoratorType, mainContext, iMapDecoratorStatusListener);
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.poidetail.PoiDetailDecorator, com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public BaseDecoratorPresenter createPresenter() {
        return new RgcDecoratorPresenter(this.mDecoratorCallback);
    }
}
