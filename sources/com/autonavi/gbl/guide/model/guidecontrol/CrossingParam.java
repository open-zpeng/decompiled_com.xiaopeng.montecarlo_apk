package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
import java.lang.reflect.Array;
/* loaded from: classes.dex */
public class CrossingParam extends BaseParam implements Serializable {
    @Deprecated
    public int[][] showRange;
    public boolean enableGridImage = true;
    public boolean enableVectorImage = true;
    public boolean enable3D = true;
    public boolean show3D = true;
    public boolean show2DNavi = true;
    @Deprecated
    public boolean onlineRequest = true;
    public boolean enableOffline3D = true;
    @Deprecated
    public boolean isMobileSupport3D = true;
    public boolean isMultiCross = false;
    public boolean isDayForUseSet = false;
    public int showWidth = 0;
    public int showHeight = 0;

    public CrossingParam() {
        this.paramType = 10;
        this.showRange = (int[][]) Array.newInstance(int.class, 3, 2);
    }
}
