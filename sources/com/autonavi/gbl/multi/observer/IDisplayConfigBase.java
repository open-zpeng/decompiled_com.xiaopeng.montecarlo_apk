package com.autonavi.gbl.multi.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.multi.KldDisplay;
import com.autonavi.gbl.multi.observer.impl.DisplayViewMode;
import com.autonavi.gbl.multi.router.DisplayConfigBaseRouter;
import java.util.ArrayList;
@IntfAuto(target = DisplayConfigBaseRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IDisplayConfigBase extends IKldConfigItemBase {
    @Override // 
    int applyConfig(KldDisplay kldDisplay);

    String getDisplayName();

    boolean getFboEnable();

    boolean getInnerResume();

    String getLaneProfile();

    String getMapProfile();

    ArrayList<DisplayViewMode> getModes();

    int getNeedAntiAlias();

    int getRenderPolicy();

    int getSamples();

    String getSurfaceConfigName();

    DisplayViewMode getViewMode(int i);

    int getWorkedModeIndex();

    DisplayViewMode getWorkedViewMode();

    @Override // 
    int parseConfigString(String str);
}
