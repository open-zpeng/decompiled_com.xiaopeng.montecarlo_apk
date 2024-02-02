package com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator;

import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
/* loaded from: classes3.dex */
public interface IRouteChargeDecoratorContract {

    /* loaded from: classes3.dex */
    public interface IPresenter {
        void onClick();
    }

    /* loaded from: classes3.dex */
    public interface IRouteChargeDecorator {
        void focus(int i);

        void hideCharges();

        void removeCharges(XPPointBaseData[] xPPointBaseDataArr);

        void showCharges(XPPointBaseData[] xPPointBaseDataArr);

        void unFocus();
    }
}
