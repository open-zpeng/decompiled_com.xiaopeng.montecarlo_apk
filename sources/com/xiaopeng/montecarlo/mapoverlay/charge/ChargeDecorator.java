package com.xiaopeng.montecarlo.mapoverlay.charge;

import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
/* loaded from: classes.dex */
public class ChargeDecorator extends BaseMapDecorator {
    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public int getOverlayType() {
        return 8005;
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public boolean isGlobalDecorator() {
        return true;
    }

    public ChargeDecorator(DecoratorType decoratorType, MainContext mainContext, BaseMapDecorator.IMapDecoratorStatusListener iMapDecoratorStatusListener) {
        super(decoratorType, mainContext, iMapDecoratorStatusListener);
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public void onDecoratorRemove() {
        super.onDecoratorRemove();
        ChargeBizDataManager.getInstance().clearChargeBizData();
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public BaseDecoratorPresenter createPresenter() {
        return new ChargeDecoratorPresenter(this.mDecoratorCallback);
    }
}
