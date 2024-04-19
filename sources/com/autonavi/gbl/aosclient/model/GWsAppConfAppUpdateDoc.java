package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsAppConfAppUpdateDoc implements Serializable {
    public GWsAppConfAppUpdateButtons buttons;
    public String finish;
    public String mobile_remind;

    public GWsAppConfAppUpdateDoc() {
        this.mobile_remind = "";
        this.finish = "";
        this.buttons = new GWsAppConfAppUpdateButtons();
    }

    public GWsAppConfAppUpdateDoc(String str, String str2, GWsAppConfAppUpdateButtons gWsAppConfAppUpdateButtons) {
        this.mobile_remind = str;
        this.finish = str2;
        this.buttons = gWsAppConfAppUpdateButtons;
    }
}
