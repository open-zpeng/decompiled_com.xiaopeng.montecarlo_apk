package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GQueryWeatherByLinkExtend implements Serializable {
    public String mKey;
    public String mValue;

    public GQueryWeatherByLinkExtend() {
        this.mKey = "";
        this.mValue = "";
    }

    public GQueryWeatherByLinkExtend(String str, String str2) {
        this.mKey = str;
        this.mValue = str2;
    }
}
