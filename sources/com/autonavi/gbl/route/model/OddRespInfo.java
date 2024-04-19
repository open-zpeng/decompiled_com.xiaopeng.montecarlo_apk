package com.autonavi.gbl.route.model;

import com.autonavi.gbl.common.model.OddRespState;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class OddRespInfo implements Serializable {
    public boolean isOddEnabled;
    public boolean isOddMergeResp;
    @OddRespState.OddRespState1
    public int oddRespState;

    public OddRespInfo() {
        this.isOddEnabled = false;
        this.isOddMergeResp = false;
        this.oddRespState = 0;
    }

    public OddRespInfo(boolean z, boolean z2, @OddRespState.OddRespState1 int i) {
        this.isOddEnabled = z;
        this.isOddMergeResp = z2;
        this.oddRespState = i;
    }
}
