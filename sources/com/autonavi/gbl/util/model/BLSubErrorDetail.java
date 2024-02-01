package com.autonavi.gbl.util.model;

import com.autonavi.gbl.util.model.SubErrorCode;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class BLSubErrorDetail implements Serializable {
    @SubErrorCode.SubErrorCode1
    public int nSubErrorCode;
    public String strErrorDetail;

    public BLSubErrorDetail() {
        this.nSubErrorCode = -1;
        this.strErrorDetail = "";
    }

    public BLSubErrorDetail(@SubErrorCode.SubErrorCode1 int i, String str) {
        this.nSubErrorCode = i;
        this.strErrorDetail = str;
    }
}
