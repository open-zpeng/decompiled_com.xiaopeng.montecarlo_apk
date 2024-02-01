package com.autonavi.gbl.guide.model.guidecontrol;

import com.autonavi.gbl.guide.model.guidecontrol.Type;
import java.io.Serializable;
/* loaded from: classes.dex */
public class BaseParam implements Serializable {
    @Type.Type1
    public int paramType;

    public BaseParam() {
        this.paramType = 0;
    }

    public BaseParam(@Type.Type1 int i) {
        this.paramType = i;
    }
}
