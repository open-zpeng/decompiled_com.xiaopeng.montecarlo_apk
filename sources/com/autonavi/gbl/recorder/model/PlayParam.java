package com.autonavi.gbl.recorder.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PlayParam implements Serializable {
    public boolean isLooping;
    public String playPath;

    public PlayParam() {
        this.isLooping = true;
        this.playPath = "";
    }

    public PlayParam(boolean z, String str) {
        this.isLooping = z;
        this.playPath = str;
    }
}
