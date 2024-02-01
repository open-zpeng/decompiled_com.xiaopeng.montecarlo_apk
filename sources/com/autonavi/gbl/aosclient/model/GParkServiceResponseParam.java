package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GParkServiceResponseParam extends BLResponseBase implements Serializable {
    public String LicensePlate = "";
    public String LicensePlateColor = "";
    public int status = 0;

    public GParkServiceResponseParam() {
        this.mEAosRequestType = 200008;
    }
}
