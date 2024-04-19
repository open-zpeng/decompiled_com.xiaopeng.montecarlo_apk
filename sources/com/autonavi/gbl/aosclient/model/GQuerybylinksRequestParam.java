package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GQuerybylinksRequestParam extends BLRequestBase implements Serializable {
    public String cpcode = "";
    public String sourcefrom = "";
    public long flag = 0;
    public int vehicleType = 0;
    public ArrayList<GPathsReqParam> paths = new ArrayList<>();
}
