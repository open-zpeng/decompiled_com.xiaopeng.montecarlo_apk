package com.autonavi.gbl.scene.observer.impl;

import com.autonavi.gbl.aosclient.model.GReStrictedAreaDataRuleRes;
import com.autonavi.gbl.common.model.DynamicTips;
import com.autonavi.gbl.common.model.RestrictRuleResult;
import com.autonavi.gbl.scene.model.ClickedInfo;
import com.autonavi.gbl.scene.model.DisplayInfo;
import com.autonavi.gbl.scene.model.PerceptSceneInfo;
import com.autonavi.gbl.scene.model.SceneModuleID;
import com.autonavi.gbl.scene.model.ScenePreviewParam;
import com.autonavi.gbl.scene.model.ScreenParam;
/* loaded from: classes2.dex */
public class SceneObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_IDisplayObserverImpl_onShow(IDisplayObserverImpl iDisplayObserverImpl, DisplayInfo displayInfo) {
        iDisplayObserverImpl.onShow(displayInfo);
    }

    public static void SwigDirector_IDisplayObserverImpl_onHide(IDisplayObserverImpl iDisplayObserverImpl, DisplayInfo displayInfo) {
        iDisplayObserverImpl.onHide(displayInfo);
    }

    public static void SwigDirector_IDisplayObserverImpl_onClick(IDisplayObserverImpl iDisplayObserverImpl, ClickedInfo clickedInfo) {
        iDisplayObserverImpl.onClick(clickedInfo);
    }

    public static ScreenParam SwigDirector_IScreenParamAdapterImpl_getScreenParam(IScreenParamAdapterImpl iScreenParamAdapterImpl, @SceneModuleID.SceneModuleID1 int i, long j) {
        return iScreenParamAdapterImpl.getScreenParam(i, j);
    }

    public static ScenePreviewParam SwigDirector_IViewParamAdapterImpl_getPreviewParam(IViewParamAdapterImpl iViewParamAdapterImpl, @SceneModuleID.SceneModuleID1 int i, PerceptSceneInfo perceptSceneInfo) {
        return iViewParamAdapterImpl.getPreviewParam(i, perceptSceneInfo);
    }

    public static void SwigDirector_IDynamicCloudShowInfoObserverImpl_onRestrictedDataResult(IDynamicCloudShowInfoObserverImpl iDynamicCloudShowInfoObserverImpl, RestrictRuleResult restrictRuleResult, GReStrictedAreaDataRuleRes gReStrictedAreaDataRuleRes) {
        iDynamicCloudShowInfoObserverImpl.onRestrictedDataResult(restrictRuleResult, gReStrictedAreaDataRuleRes);
    }

    public static void SwigDirector_IDynamicCloudShowInfoObserverImpl_onDynamicalTipsNotify(IDynamicCloudShowInfoObserverImpl iDynamicCloudShowInfoObserverImpl, DynamicTips dynamicTips) {
        iDynamicCloudShowInfoObserverImpl.onDynamicalTipsNotify(dynamicTips);
    }
}
