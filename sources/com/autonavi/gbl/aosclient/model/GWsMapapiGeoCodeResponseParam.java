package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsMapapiGeoCodeResponseParam extends BLResponseBase implements Serializable {
    public int total = 0;
    public ArrayList<GGeoResult> geoResultVec = new ArrayList<>();
}
