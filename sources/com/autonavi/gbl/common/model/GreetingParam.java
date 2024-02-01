package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GreetingParam implements Serializable {
    public double dSunRise;
    public double dSunSet;
    public String userNickname;

    public GreetingParam() {
        this.dSunRise = 0.0d;
        this.dSunSet = 0.0d;
        this.userNickname = "";
    }

    public GreetingParam(double d, double d2, String str) {
        this.dSunRise = d;
        this.dSunSet = d2;
        this.userNickname = str;
    }
}
