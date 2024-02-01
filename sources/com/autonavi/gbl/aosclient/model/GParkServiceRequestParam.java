package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GParkServiceRequestParam extends BLRequestBase implements Serializable {
    public String LicensePlate = "";
    public String LicensePlateColor = "";
    public int status = -1;
    public String vid = "";
    public String pid = "";
    public String dic = "";
    public String serverid = "";
    public String needauth = "";

    public GParkServiceRequestParam() {
        this.mEAosRequestType = 200008;
    }
}
