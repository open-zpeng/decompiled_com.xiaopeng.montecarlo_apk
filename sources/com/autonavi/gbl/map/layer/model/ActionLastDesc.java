package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ActionLastDesc implements Serializable {
    public String actionName;
    public float lastTime;

    public ActionLastDesc() {
        this.actionName = "";
        this.lastTime = 0.0f;
    }

    public ActionLastDesc(String str, float f) {
        this.actionName = str;
        this.lastTime = f;
    }
}
