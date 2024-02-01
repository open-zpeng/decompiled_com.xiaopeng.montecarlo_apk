package com.autonavi.gbl.activation.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ActivationInitParam implements Serializable {
    public int iCodeLength;
    public int iProjectId;
    public boolean isCheckClientNo;
    public boolean isCheckModelNo;
    public boolean isSupportVolumeAct;
    public String szDeviceID;
    public String szUserDataFileDir;

    public ActivationInitParam() {
        this.isCheckClientNo = false;
        this.isCheckModelNo = false;
        this.isSupportVolumeAct = false;
        this.iProjectId = 0;
        this.iCodeLength = 0;
        this.szDeviceID = "";
        this.szUserDataFileDir = "";
    }

    public ActivationInitParam(boolean z, boolean z2, boolean z3, int i, int i2, String str, String str2) {
        this.isCheckClientNo = z;
        this.isCheckModelNo = z2;
        this.isSupportVolumeAct = z3;
        this.iProjectId = i;
        this.iCodeLength = i2;
        this.szDeviceID = str;
        this.szUserDataFileDir = str2;
    }
}
