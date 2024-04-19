package com.autonavi.gbl.multi.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.ChannelParcel;
import com.autonavi.gbl.consis.model.CHANNEL_MSG_TYPE;
import com.autonavi.gbl.multi.KldDisplay;
import com.autonavi.gbl.multi.impl.CKldSceneContextImpl;
import com.autonavi.gbl.multi.impl.IKldDisplayCrop;
import com.autonavi.gbl.multi.model.DisplayType;
import com.autonavi.gbl.multi.router.KldDisplayObserverRouter;
@IntfAuto(target = KldDisplayObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IKldDisplayObserver {
    void beforeEGLDevCreated(KldDisplay kldDisplay);

    void beforeEGLMapCreated(KldDisplay kldDisplay);

    void beforeSceneContextInit(CKldSceneContextImpl cKldSceneContextImpl);

    boolean onCheckSyncAllowed(int i, int i2, int i3);

    void onDisplayCreated(int i, @DisplayType.DisplayType1 int i2);

    void onDisplayCropCustom(KldDisplay kldDisplay, IKldDisplayCrop iKldDisplayCrop);

    void onMainDisplayCreated(int i);

    void onMapDoRender(int i, @DisplayType.DisplayType1 int i2);

    void onMapFirstPaint(int i, @DisplayType.DisplayType1 int i2);

    boolean onProcessCustomInComeMsg(int i, @CHANNEL_MSG_TYPE.CHANNEL_MSG_TYPE1 int i2, int i3, ChannelParcel channelParcel);
}
