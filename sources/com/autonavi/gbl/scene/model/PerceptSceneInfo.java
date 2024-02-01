package com.autonavi.gbl.scene.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PerceptSceneInfo implements Serializable {
    public int naviStatus;
    public int naviType;
    public String sceneName;
    public int sceneType;

    public PerceptSceneInfo() {
        this.sceneName = "";
        this.sceneType = 1;
        this.naviType = -1;
        this.naviStatus = 0;
    }

    public PerceptSceneInfo(String str, int i, int i2, int i3) {
        this.sceneName = str;
        this.sceneType = i;
        this.naviType = i2;
        this.naviStatus = i3;
    }
}
