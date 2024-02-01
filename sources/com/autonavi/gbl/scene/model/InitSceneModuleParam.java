package com.autonavi.gbl.scene.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class InitSceneModuleParam implements Serializable {
    public boolean bEnableDynamicCloudShowInfoModule;
    public boolean bEnableDynamicLayerModule;
    public boolean bEnableDynamicTipsModule;
    public boolean bEnableNaviModule;
    public boolean bEnableNearbyRecommendModule;
    public boolean bEnableSwitchViewModule;
    public InitDynamicParam dynamicInitParam;

    public InitSceneModuleParam() {
        this.dynamicInitParam = new InitDynamicParam();
        this.bEnableSwitchViewModule = false;
        this.bEnableDynamicLayerModule = false;
        this.bEnableDynamicTipsModule = false;
        this.bEnableNaviModule = false;
        this.bEnableDynamicCloudShowInfoModule = false;
        this.bEnableNearbyRecommendModule = false;
    }

    public InitSceneModuleParam(InitDynamicParam initDynamicParam, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.dynamicInitParam = initDynamicParam;
        this.bEnableSwitchViewModule = z;
        this.bEnableDynamicLayerModule = z2;
        this.bEnableDynamicTipsModule = z3;
        this.bEnableNaviModule = z4;
        this.bEnableDynamicCloudShowInfoModule = z5;
        this.bEnableNearbyRecommendModule = z6;
    }
}
