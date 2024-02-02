package com.xiaopeng.montecarlo.mapoverlay;

import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
/* loaded from: classes2.dex */
public class StartPointDecorator extends BaseMapDecorator {
    public static final String KEY_ROUTE_SELECT_REF = "route_select_ref";
    public static final String KEY_SETTING_PARAM = "setting_param";
    public static final String KEY_START_TYPE = "start_type";

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public int getOverlayType() {
        return 6001;
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public boolean isGlobalDecorator() {
        return true;
    }

    public StartPointDecorator(DecoratorType decoratorType, MainContext mainContext, BaseMapDecorator.IMapDecoratorStatusListener iMapDecoratorStatusListener) {
        super(decoratorType, mainContext, iMapDecoratorStatusListener);
    }
}
