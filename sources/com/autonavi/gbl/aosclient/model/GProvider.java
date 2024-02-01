package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GProvider implements Serializable {
    public int auth_id;
    public String auth_username;
    public int provider;

    public GProvider() {
        this.provider = 0;
        this.auth_id = 0;
        this.auth_username = "";
    }

    public GProvider(int i, int i2, String str) {
        this.provider = i;
        this.auth_id = i2;
        this.auth_username = str;
    }
}
