package com.autonavi.gbl.servicemanager;

import com.autonavi.auto.bl.puglin.annotations.JniCallbackMethod;
import com.autonavi.gbl.util.model.ServiceInitStatus;
/* loaded from: classes2.dex */
public interface IService {
    @JniCallbackMethod(parameters = {})
    long getPtr();

    @ServiceInitStatus.ServiceInitStatus1
    int isInit();

    boolean isRecycled();

    void onCreate();

    void onDestroy();
}
