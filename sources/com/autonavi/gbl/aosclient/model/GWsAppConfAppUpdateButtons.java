package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsAppConfAppUpdateButtons implements Serializable {
    public String cancel;
    public String download_auto;
    public String download_now;
    public String install_now;
    public String quit;

    public GWsAppConfAppUpdateButtons() {
        this.cancel = "";
        this.download_now = "";
        this.install_now = "";
        this.quit = "";
        this.download_auto = "";
    }

    public GWsAppConfAppUpdateButtons(String str, String str2, String str3, String str4, String str5) {
        this.cancel = str;
        this.download_now = str2;
        this.install_now = str3;
        this.quit = str4;
        this.download_auto = str5;
    }
}
