package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsMapapiBenzLinkidsRequestParam extends BLRequestBase implements Serializable {
    public int projected_route = 0;
    public ArrayList<WSMapapiBenzLinkidsGp> gps = new ArrayList<>();
}
