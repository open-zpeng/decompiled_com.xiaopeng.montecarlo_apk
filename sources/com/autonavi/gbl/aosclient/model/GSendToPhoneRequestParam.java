package com.autonavi.gbl.aosclient.model;

import com.autonavi.gbl.map.layer.model.LayerPriorityType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class GSendToPhoneRequestParam extends BLRequestBase implements Serializable {
    public String message = "";
    public GAimpoiMsg aimpoiMsg = new GAimpoiMsg();
    public String sourceId = "autocpp";
    public String bizType = "aimpoi";
    public boolean isReliable = true;
    public int expiration = LayerPriorityType.LayerPriorityRouteArrow;
}
