package com.xiaopeng.montecarlo.mapoverlay.poidetail;

import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
/* loaded from: classes.dex */
public class RecommendChargeDecorator extends PoiDetailDecorator {
    public static final String RECOMMEND_CHARGE_DECORATOR_ID_PREFIX = "recommend_charge_start_";
    public static final String RECOMMEND_CHARGE_DECORATOR_ID_SUFFIX = "_recommend_charge_end_";
    public static final String RECOMMEND_CHARGE_TYPE = "recommend_charge_type";

    public RecommendChargeDecorator(DecoratorType decoratorType, MainContext mainContext, BaseMapDecorator.IMapDecoratorStatusListener iMapDecoratorStatusListener) {
        super(decoratorType, mainContext, iMapDecoratorStatusListener);
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.poidetail.PoiDetailDecorator, com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public BaseDecoratorPresenter createPresenter() {
        return new RecommendChargeDecoratorPresenter(this.mDecoratorCallback);
    }
}
