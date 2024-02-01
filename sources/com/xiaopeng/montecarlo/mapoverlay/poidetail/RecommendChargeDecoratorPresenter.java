package com.xiaopeng.montecarlo.mapoverlay.poidetail;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorCallback;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
/* loaded from: classes.dex */
public class RecommendChargeDecoratorPresenter extends PoiDetailDecoratorPresenter {
    private int mRecommendChargeType;

    public RecommendChargeDecoratorPresenter(BaseDecoratorCallback baseDecoratorCallback) {
        super(baseDecoratorCallback);
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.poidetail.PoiDetailDecoratorPresenter, com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter
    public void update(Bundle bundle) {
        if (bundle != null) {
            this.mRecommendChargeType = bundle.getInt(RecommendChargeDecorator.RECOMMEND_CHARGE_TYPE, -1);
        }
        super.update(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter
    @NonNull
    public XPPointBaseData generateBizPoint(int i, int i2, @NonNull XPPoiInfo xPPoiInfo) {
        XPPointBaseData generateBizPoint = super.generateBizPoint(i, i2, xPPoiInfo);
        generateBizPoint.id = RecommendChargeDecorator.RECOMMEND_CHARGE_DECORATOR_ID_PREFIX + this.mRecommendChargeType + RecommendChargeDecorator.RECOMMEND_CHARGE_DECORATOR_ID_SUFFIX + generateBizPoint.id;
        return generateBizPoint;
    }
}
