package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GLbpEventSyncCommonRequestParam extends BLRequestBase implements Serializable {
    public ArrayList<EventSyncCommonRequestPush> push = new ArrayList<>();
    public String partner = "";
}
