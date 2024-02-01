package com.xiaopeng.montecarlo.mapoverlay;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorCallback;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
/* loaded from: classes.dex */
public class WayPointDecoratorPresenter extends BaseDecoratorPresenter {
    /* JADX INFO: Access modifiers changed from: package-private */
    public WayPointDecoratorPresenter(BaseDecoratorCallback baseDecoratorCallback) {
        super(baseDecoratorCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter
    @NonNull
    public XPPointBaseData generateBizPoint(int i, int i2, @NonNull XPPoiInfo xPPoiInfo) {
        XPPointBaseData generateBizPoint = super.generateBizPoint(i, i2, xPPoiInfo);
        generateBizPoint.id = "" + i2;
        return generateBizPoint;
    }
}
