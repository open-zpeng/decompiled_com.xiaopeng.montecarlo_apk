package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcOrderDetailFailReason implements Serializable {
    public String content;
    public String name;

    public WsTcOrderDetailFailReason() {
        this.name = "";
        this.content = "";
    }

    public WsTcOrderDetailFailReason(String str, String str2) {
        this.name = str;
        this.content = str2;
    }
}
