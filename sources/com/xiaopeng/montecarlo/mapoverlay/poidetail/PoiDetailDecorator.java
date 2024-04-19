package com.xiaopeng.montecarlo.mapoverlay.poidetail;

import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
/* loaded from: classes2.dex */
public class PoiDetailDecorator extends BaseMapDecorator {
    public static final String POI_INFO = "poi_info";
    public static final String SEARCH_NAME = "poi_name";
    public static final String SEARCH_POI_ID = "poi_id";
    public static final String SEARCH_PX = "poi_px";
    public static final String SEARCH_PY = "poi_py";

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public int getOverlayType() {
        return 20003;
    }

    public PoiDetailDecorator(DecoratorType decoratorType, MainContext mainContext, BaseMapDecorator.IMapDecoratorStatusListener iMapDecoratorStatusListener) {
        super(decoratorType, mainContext, iMapDecoratorStatusListener);
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public BaseDecoratorPresenter createPresenter() {
        return new PoiDetailDecoratorPresenter(this.mDecoratorCallback);
    }
}
