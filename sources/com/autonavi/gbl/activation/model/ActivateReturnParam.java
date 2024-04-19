package com.autonavi.gbl.activation.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ActivateReturnParam implements Serializable {
    public int iErrorCode;
    public String szOutputCode;

    public ActivateReturnParam() {
        this.iErrorCode = 0;
        this.szOutputCode = "";
    }

    public ActivateReturnParam(int i, String str) {
        this.iErrorCode = i;
        this.szOutputCode = str;
    }
}
