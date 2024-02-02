package com.xiaopeng.montecarlo.trafficevent;

import android.view.View;
import androidx.annotation.MainThread;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.navcore.control.BizControlWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract;
/* loaded from: classes3.dex */
public class TrafficEventHelper {
    private ITrafficEventCallback mITrafficEventCallback;
    private MainContext mMainContext;
    TrafficEventPresenter mTrafficEventPresenter;

    /* loaded from: classes3.dex */
    public interface ITrafficEventCallback {
        ITrafficEventContract.ITrafficEventPopView getTrafficEventView();

        boolean isLegal();

        void onTrafficEventPopHide(View view);

        void onTrafficEventPopShow(View view, double d, double d2);
    }

    public TrafficEventHelper(MainContext mainContext, ITrafficEventCallback iTrafficEventCallback) {
        this.mMainContext = mainContext;
        this.mITrafficEventCallback = iTrafficEventCallback;
    }

    public void showPoiTrafficEventPop(TrafficEventPopParam trafficEventPopParam) {
        ITrafficEventContract.ITrafficEventPopView trafficEventView;
        ITrafficEventCallback iTrafficEventCallback = this.mITrafficEventCallback;
        if (iTrafficEventCallback == null || !iTrafficEventCallback.isLegal() || (trafficEventView = this.mITrafficEventCallback.getTrafficEventView()) == null) {
            return;
        }
        this.mMainContext.getDecoratorManager().clearFocus(this.mMainContext.getCurrentScene());
        if (this.mTrafficEventPresenter == null) {
            this.mTrafficEventPresenter = new TrafficEventPresenter(trafficEventView, this.mMainContext);
            trafficEventView.setCallback(this.mTrafficEventPresenter);
        }
        this.mTrafficEventPresenter.showITrafficEventPopView(trafficEventPopParam);
        Coord2DDouble location = this.mTrafficEventPresenter.getLocation();
        this.mITrafficEventCallback.onTrafficEventPopShow((View) trafficEventView, location.lon, location.lat);
    }

    @MainThread
    public void hideSceneTrafficEventPop() {
        TrafficEventPresenter trafficEventPresenter;
        ITrafficEventCallback iTrafficEventCallback = this.mITrafficEventCallback;
        if (iTrafficEventCallback == null || !iTrafficEventCallback.isLegal() || (trafficEventPresenter = this.mTrafficEventPresenter) == null || !trafficEventPresenter.isTrafficEventPopViewShown()) {
            return;
        }
        this.mTrafficEventPresenter.closeITrafficEventPopView();
        ITrafficEventContract.ITrafficEventPopView trafficEventView = this.mITrafficEventCallback.getTrafficEventView();
        if (trafficEventView == null) {
            return;
        }
        this.mITrafficEventCallback.onTrafficEventPopHide((View) trafficEventView);
        TBTManager.getInstance().getMap().getBizControlManager().clearFocus(BizControlWrapper.BIZ_CONTROL_TYPE_ROADFACILITY, 5008L);
    }

    public void uInit() {
        this.mITrafficEventCallback = null;
        this.mTrafficEventPresenter = null;
        this.mMainContext = null;
    }
}
