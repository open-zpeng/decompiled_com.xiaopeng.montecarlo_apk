package com.xiaopeng.montecarlo.scenes.navi;

import com.xiaopeng.montecarlo.base.IRouteUpdateContract;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener;
import com.xiaopeng.montecarlo.navcore.state.IStateListener;
import com.xiaopeng.montecarlo.navcore.xptbt.GuideManager;
import com.xiaopeng.montecarlo.navcore.xptbt.INaviListener;
import com.xiaopeng.montecarlo.root.network.IXPNetworkListener;
import com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener;
import com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper;
import com.xiaopeng.montecarlo.views.RecommendRoutePop;
/* loaded from: classes2.dex */
public class NaviPresenterListener {
    private IRouteUpdateContract mIRouteUpdateContract;
    private BaseMapDecorator.IMapDecoratorRouteUpdateListener mMapDecoratorRouteUpdateListener;
    private IMapSceneEventHandler mMapSceneEventHandler;
    private INaviListener mNaviListener;
    private INaviSpeechEventHandler mNaviSpeechEventHandler;
    private IStateListener mNaviStateListener;
    private IParallelRoadEventHandler mParallelRoadEventHandler;
    private IRecommendParkingListener mRecommendParkingListener;
    private RecommendRoutePop.IRecommendRouteSwitchListener mRecommendRouteSwitchListener;
    private GuideManager.IRerouteListener mRerouteListener;
    private RestrictHelper.IRestrictEventCallback mRestrictEventCallback;
    private ISRInfoChangedListener mSRInfoChangedListener;
    private ISceneMapFragmentListener mSceneMapFragmentListener;
    private IXPNetworkListener mXPNetWorkListener;

    public NaviPresenterListener(Builder builder) {
        this.mNaviStateListener = builder.mNaviStateListener;
        this.mNaviSpeechEventHandler = builder.mNaviSpeechEventHandler;
        this.mMapSceneEventHandler = builder.mMapSceneEventHandler;
        this.mRestrictEventCallback = builder.mRestrictEventCallback;
        this.mRerouteListener = builder.mRerouteListener;
        this.mNaviListener = builder.mNaviListener;
        this.mMapDecoratorRouteUpdateListener = builder.mMapDecoratorRouteUpdateListener;
        this.mRecommendRouteSwitchListener = builder.mRecommendRouteSwitchListener;
        this.mRecommendParkingListener = builder.mRecommendParkingListener;
        this.mParallelRoadEventHandler = builder.mParallelRoadEventHandler;
        this.mSceneMapFragmentListener = builder.mSceneMapFragmentListener;
        this.mXPNetWorkListener = builder.mXPNetWorkListener;
        this.mIRouteUpdateContract = builder.mIRouteUpdateListener;
        this.mSRInfoChangedListener = builder.mSRInfoChangedListener;
    }

    public IStateListener getStateListener() {
        return this.mNaviStateListener;
    }

    public INaviSpeechEventHandler getNaviSpeechEventHandler() {
        return this.mNaviSpeechEventHandler;
    }

    public IMapSceneEventHandler getMapSceneEventHandler() {
        return this.mMapSceneEventHandler;
    }

    public RestrictHelper.IRestrictEventCallback getRestrictEventCallback() {
        return this.mRestrictEventCallback;
    }

    public GuideManager.IRerouteListener getRerouteListener() {
        return this.mRerouteListener;
    }

    public INaviListener getNaviListener() {
        return this.mNaviListener;
    }

    public BaseMapDecorator.IMapDecoratorRouteUpdateListener getMapDecoratorRouteUpdateListener() {
        return this.mMapDecoratorRouteUpdateListener;
    }

    public RecommendRoutePop.IRecommendRouteSwitchListener getRecommendRouteSwitchListener() {
        return this.mRecommendRouteSwitchListener;
    }

    public IRecommendParkingListener getRecommendParkingListener() {
        return this.mRecommendParkingListener;
    }

    public IParallelRoadEventHandler getParallelRoadEventHandler() {
        return this.mParallelRoadEventHandler;
    }

    public ISceneMapFragmentListener getSceneMapFragmentListener() {
        return this.mSceneMapFragmentListener;
    }

    public IXPNetworkListener getXPNetworkListener() {
        return this.mXPNetWorkListener;
    }

    public IRouteUpdateContract getRouteUpdateContractImpl() {
        return this.mIRouteUpdateContract;
    }

    public ISRInfoChangedListener getSRInfoChangedListener() {
        return this.mSRInfoChangedListener;
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private IRouteUpdateContract mIRouteUpdateListener;
        private BaseMapDecorator.IMapDecoratorRouteUpdateListener mMapDecoratorRouteUpdateListener;
        private IMapSceneEventHandler mMapSceneEventHandler;
        private INaviListener mNaviListener;
        private INaviSpeechEventHandler mNaviSpeechEventHandler;
        private IStateListener mNaviStateListener;
        private IParallelRoadEventHandler mParallelRoadEventHandler;
        private IRecommendParkingListener mRecommendParkingListener;
        private RecommendRoutePop.IRecommendRouteSwitchListener mRecommendRouteSwitchListener;
        private GuideManager.IRerouteListener mRerouteListener;
        private RestrictHelper.IRestrictEventCallback mRestrictEventCallback;
        private ISRInfoChangedListener mSRInfoChangedListener;
        private ISceneMapFragmentListener mSceneMapFragmentListener;
        public IXPNetworkListener mXPNetWorkListener;

        public Builder naviStateListener(IStateListener iStateListener) {
            this.mNaviStateListener = iStateListener;
            return this;
        }

        public Builder naviSpeechEventHandler(INaviSpeechEventHandler iNaviSpeechEventHandler) {
            this.mNaviSpeechEventHandler = iNaviSpeechEventHandler;
            return this;
        }

        public Builder mapSceneEventHandler(IMapSceneEventHandler iMapSceneEventHandler) {
            this.mMapSceneEventHandler = iMapSceneEventHandler;
            return this;
        }

        public Builder restrictEventCallback(RestrictHelper.IRestrictEventCallback iRestrictEventCallback) {
            this.mRestrictEventCallback = iRestrictEventCallback;
            return this;
        }

        public Builder rerouteListener(GuideManager.IRerouteListener iRerouteListener) {
            this.mRerouteListener = iRerouteListener;
            return this;
        }

        public Builder naviListener(INaviListener iNaviListener) {
            this.mNaviListener = iNaviListener;
            return this;
        }

        public Builder mapDecoratorRouteUpdateListener(BaseMapDecorator.IMapDecoratorRouteUpdateListener iMapDecoratorRouteUpdateListener) {
            this.mMapDecoratorRouteUpdateListener = iMapDecoratorRouteUpdateListener;
            return this;
        }

        public Builder recommendRouteSwitchListener(RecommendRoutePop.IRecommendRouteSwitchListener iRecommendRouteSwitchListener) {
            this.mRecommendRouteSwitchListener = iRecommendRouteSwitchListener;
            return this;
        }

        public Builder recommendParkingListener(IRecommendParkingListener iRecommendParkingListener) {
            this.mRecommendParkingListener = iRecommendParkingListener;
            return this;
        }

        public Builder parallelRoadEventHandler(IParallelRoadEventHandler iParallelRoadEventHandler) {
            this.mParallelRoadEventHandler = iParallelRoadEventHandler;
            return this;
        }

        public Builder sceneMapFragmentListener(ISceneMapFragmentListener iSceneMapFragmentListener) {
            this.mSceneMapFragmentListener = iSceneMapFragmentListener;
            return this;
        }

        public Builder setXPNetworkListener(IXPNetworkListener iXPNetworkListener) {
            this.mXPNetWorkListener = iXPNetworkListener;
            return this;
        }

        public Builder setRouteUpdateListener(IRouteUpdateContract iRouteUpdateContract) {
            this.mIRouteUpdateListener = iRouteUpdateContract;
            return this;
        }

        public Builder setSRInfoChangedListener(ISRInfoChangedListener iSRInfoChangedListener) {
            this.mSRInfoChangedListener = iSRInfoChangedListener;
            return this;
        }

        public NaviPresenterListener build() {
            return new NaviPresenterListener(this);
        }
    }
}
