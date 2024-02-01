package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.path.model.FacilityType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class BizRoadFacilityInfo extends BizPointBusinessInfo implements Serializable {
    @FacilityType.FacilityType1
    public int type = 0;
    public int distance = 0;
}
