package com.autonavi.gbl.scene.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ProtocolInfo implements Serializable {
    public String json;
    public String name;

    public ProtocolInfo() {
        this.name = "";
        this.json = "";
    }

    public ProtocolInfo(String str, String str2) {
        this.name = str;
        this.json = str2;
    }
}
