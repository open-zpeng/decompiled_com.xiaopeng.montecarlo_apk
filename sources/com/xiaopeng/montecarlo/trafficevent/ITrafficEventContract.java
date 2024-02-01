package com.xiaopeng.montecarlo.trafficevent;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.bean.traffic.TrafficEventData;
/* loaded from: classes3.dex */
public interface ITrafficEventContract {

    /* loaded from: classes3.dex */
    public interface ITrafficEventPopView {

        /* loaded from: classes3.dex */
        public interface ICallBack {
            void onClose();

            void onReload();

            void onShowLargePic();
        }

        void close();

        boolean isVisible();

        void move(int i, int i2);

        void setCallback(ICallBack iCallBack);

        void setPresenter(TrafficEventPresenter trafficEventPresenter);

        void show();

        void showEventData(TrafficEventData trafficEventData);

        void showFailed();

        void showLoading();
    }

    /* loaded from: classes3.dex */
    public interface ITrafficEventPresenter {
        void closeITrafficEventPopView();

        Coord2DDouble getLocation();

        void moveITrafficEventPopView();

        void showITrafficEventPopView(TrafficEventPopParam trafficEventPopParam);
    }
}
