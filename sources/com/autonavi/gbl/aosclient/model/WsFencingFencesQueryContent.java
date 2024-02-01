package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsFencingFencesQueryContent implements Serializable {
    public String geometry;
    public WsFencingFencesQueryProperty properties;
    public String type;

    public WsFencingFencesQueryContent() {
        this.type = "";
        this.geometry = "";
        this.properties = new WsFencingFencesQueryProperty();
    }

    public WsFencingFencesQueryContent(String str, String str2, WsFencingFencesQueryProperty wsFencingFencesQueryProperty) {
        this.type = str;
        this.geometry = str2;
        this.properties = wsFencingFencesQueryProperty;
    }
}
