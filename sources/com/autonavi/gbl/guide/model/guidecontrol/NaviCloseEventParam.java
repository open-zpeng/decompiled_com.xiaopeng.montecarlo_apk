package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class NaviCloseEventParam extends BaseParam implements Serializable {
    public boolean closeEvent = false;

    public NaviCloseEventParam() {
        this.paramType = 27;
    }
}
