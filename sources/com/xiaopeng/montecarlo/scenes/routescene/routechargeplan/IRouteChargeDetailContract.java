package com.xiaopeng.montecarlo.scenes.routescene.routechargeplan;

import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
/* loaded from: classes3.dex */
public interface IRouteChargeDetailContract {

    /* loaded from: classes3.dex */
    public interface IChargeDetailCallBack {
        void onChargeDetailFetched(String str, XPPoiInfo xPPoiInfo);

        void onDistanceFetched(String str, long j, long j2);

        void onExternalDataFetchError();

        void onExternalDataFetched(String str, boolean z, boolean z2, boolean z3, boolean z4, long j, long j2, long j3, boolean z5, boolean z6);
    }

    /* loaded from: classes3.dex */
    public interface IRouteChargeDetailProvider {
        void renderExternalStatusOnNavi(String str, double d, double d2, int i);

        void route(String str, double d, double d2);

        void setCallBack(IChargeDetailCallBack iChargeDetailCallBack);

        void startRequestDetail(String str);

        void stop();

        void unInit();
    }
}
