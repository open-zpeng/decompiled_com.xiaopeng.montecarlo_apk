package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.layer.model.CustomPriorityMode;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class BizCustomLineInfo extends BizLineBusinessInfo implements Serializable {
    @CustomPriorityMode.CustomPriorityMode1
    public int priorityMode = 1;
    public int valueType = 0;
    public String value = "";
}
