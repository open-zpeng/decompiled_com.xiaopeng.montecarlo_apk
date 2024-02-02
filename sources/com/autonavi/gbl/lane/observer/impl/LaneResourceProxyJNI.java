package com.autonavi.gbl.lane.observer.impl;

import com.autonavi.gbl.lane.model.LaneResourceRequest;
import com.autonavi.gbl.lane.model.LaneResourceRequestFile;
import com.autonavi.gbl.lane.model.LaneResourceResponse;
/* loaded from: classes.dex */
public class LaneResourceProxyJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static LaneResourceResponse SwigDirector_ILaneResourceProxyImpl_onRequestResource(ILaneResourceProxyImpl iLaneResourceProxyImpl, LaneResourceRequest laneResourceRequest) {
        return iLaneResourceProxyImpl.onRequestResource(laneResourceRequest);
    }

    public static LaneResourceResponse SwigDirector_ILaneResourceProxyImpl_onRequestResourceFile(ILaneResourceProxyImpl iLaneResourceProxyImpl, LaneResourceRequestFile laneResourceRequestFile) {
        return iLaneResourceProxyImpl.onRequestResourceFile(laneResourceRequestFile);
    }
}
