package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.layer.model.PoiParentType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class BizSearchParentPoint extends BizPointBusinessInfo implements Serializable {
    @PoiParentType.PoiParentType1
    public int poiType = 4;
    public int typeCode = 0;
    public int index = 0;
    public String text = "";
    public String poiName = "";
    public String markerBGRes = "";
}
