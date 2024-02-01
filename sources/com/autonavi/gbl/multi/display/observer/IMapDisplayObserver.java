package com.autonavi.gbl.multi.display.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.ChannelParcel;
import com.autonavi.gbl.consis.model.ChannelMessageType;
import com.autonavi.gbl.multi.display.Display;
import com.autonavi.gbl.multi.display.DisplayCrop;
import com.autonavi.gbl.multi.display.model.DisplayType;
import com.autonavi.gbl.multi.router.MapDisplayObserverRouter;
@IntfAuto(target = MapDisplayObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IMapDisplayObserver {
    default void beforeEGLDevCreated(Display display) {
    }

    default void beforeEGLMapCreated(Display display) {
    }

    boolean onCheckSyncAllowed(int i, int i2, int i3);

    default void onDisplayCreated(int i, @DisplayType.DisplayType1 int i2) {
    }

    default void onDisplayCropCustom(Display display, DisplayCrop displayCrop) {
    }

    default void onMainDisplayCreated(int i) {
    }

    default void onMapDoRender(int i, @DisplayType.DisplayType1 int i2) {
    }

    default void onMapFirstPaint(int i, @DisplayType.DisplayType1 int i2) {
    }

    boolean onProcessCustomInComeMsg(int i, @ChannelMessageType.ChannelMessageType1 int i2, int i3, ChannelParcel channelParcel);
}
