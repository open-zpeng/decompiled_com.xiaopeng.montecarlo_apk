package com.xiaopeng.montecarlo.mapoverlay.vpa;

import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter;
/* loaded from: classes.dex */
public class VPADecorator extends BaseMapDecorator {
    private static final L.Tag TAG = new L.Tag("VPADecorator");

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public int getOverlayType() {
        return 20006;
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public boolean isGlobalDecorator() {
        return true;
    }

    public static void showVPA(MapScenePresenter mapScenePresenter, String str) {
        if (mapScenePresenter != null) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "showVPA version = " + str);
            }
            mapScenePresenter.updateVPAOverlay();
        }
    }

    public VPADecorator(DecoratorType decoratorType, MainContext mainContext, BaseMapDecorator.IMapDecoratorStatusListener iMapDecoratorStatusListener) {
        super(decoratorType, mainContext, iMapDecoratorStatusListener);
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public BaseDecoratorPresenter createPresenter() {
        return new VPADecoratorPresenter(this.mDecoratorCallback);
    }
}
