package com.xiaopeng.montecarlo.mapoverlay.rgc;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorCallback;
import com.xiaopeng.montecarlo.mapoverlay.poidetail.PoiDetailDecoratorPresenter;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
/* loaded from: classes2.dex */
public class RgcDecoratorPresenter extends PoiDetailDecoratorPresenter {
    public RgcDecoratorPresenter(BaseDecoratorCallback baseDecoratorCallback) {
        super(baseDecoratorCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter
    @NonNull
    public XPPointBaseData generateBizPoint(int i, int i2, @NonNull XPPoiInfo xPPoiInfo) {
        XPPointBaseData generateBizPoint = super.generateBizPoint(i, i2, xPPoiInfo);
        generateBizPoint.id = "rgc_" + generateBizPoint.position.lat + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + generateBizPoint.position.lon + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + generateBizPoint.position.z + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + generateBizPoint.priority;
        return generateBizPoint;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.mapoverlay.poidetail.PoiDetailDecoratorPresenter, com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter
    public boolean lazyLoad() {
        if (this.mRefreshType == 1) {
            getDataProvider().nearestSearch(this.mRGCLonLat.lon, this.mRGCLonLat.lat);
            return true;
        }
        return super.lazyLoad();
    }
}
