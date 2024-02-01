package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsSearchPoiAutoCmallFillOrderProtocolInfo implements Serializable {
    public String agreement_text;
    public String agreement_tips;
    public String agreement_url;

    public WsSearchPoiAutoCmallFillOrderProtocolInfo() {
        this.agreement_text = "";
        this.agreement_url = "";
        this.agreement_tips = "";
    }

    public WsSearchPoiAutoCmallFillOrderProtocolInfo(String str, String str2, String str3) {
        this.agreement_text = str;
        this.agreement_url = str2;
        this.agreement_tips = str3;
    }
}
