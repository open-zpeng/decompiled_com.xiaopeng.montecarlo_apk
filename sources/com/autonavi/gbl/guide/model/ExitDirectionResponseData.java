package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ExitDirectionResponseData implements Serializable {
    public boolean bValid;
    public ExitDirectionInfo data;
    public boolean isAnyExit;
    public int requestID;

    public ExitDirectionResponseData() {
        this.requestID = 0;
        this.data = new ExitDirectionInfo();
        this.bValid = false;
        this.isAnyExit = false;
    }

    public ExitDirectionResponseData(int i, ExitDirectionInfo exitDirectionInfo, boolean z, boolean z2) {
        this.requestID = i;
        this.data = exitDirectionInfo;
        this.bValid = z;
        this.isAnyExit = z2;
    }
}
