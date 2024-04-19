package com.autonavi.gbl.data.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class AutoInitResponseData implements Serializable {
    public String strFeedBackContent;

    public AutoInitResponseData() {
        this.strFeedBackContent = "";
    }

    public AutoInitResponseData(String str) {
        this.strFeedBackContent = str;
    }
}
