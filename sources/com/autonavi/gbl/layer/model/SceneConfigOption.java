package com.autonavi.gbl.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SceneConfigOption implements Serializable {
    public String confName;
    public String ctrlName;
    public String json;
    public String sceneName;

    public SceneConfigOption() {
        this.ctrlName = "";
        this.sceneName = "";
        this.confName = "";
        this.json = "";
    }

    public SceneConfigOption(String str, String str2, String str3, String str4) {
        this.ctrlName = str;
        this.sceneName = str2;
        this.confName = str3;
        this.json = str4;
    }
}
