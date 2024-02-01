package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpAutoWeixinStatusResponseParam extends BLResponseBase implements Serializable {
    public String avatar = "";
    public String nickname = "";

    public GWsPpAutoWeixinStatusResponseParam() {
        this.mEAosRequestType = 100011;
    }
}
