package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.layer.model.ThreeUrgentType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class BizThreeUrgentInfo extends BizPointBusinessInfo implements Serializable {
    @ThreeUrgentType.ThreeUrgentType1
    public int mType = 0;
    public int mPassingSpeed = 0;
    public int mElectronicEyeSpeed = 0;
    public boolean mbIsMaxOverSpeedPoint = false;
}
