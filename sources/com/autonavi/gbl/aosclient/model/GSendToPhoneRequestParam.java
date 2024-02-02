package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GSendToPhoneRequestParam extends BLRequestBase implements Serializable {
    public String message = "";
    public GAimpoiMsg aimpoiMsg = new GAimpoiMsg();
    public String sourceId = "";
    public String bizType = "";
    public boolean isReliable = false;
    public int expiration = 0;
}
