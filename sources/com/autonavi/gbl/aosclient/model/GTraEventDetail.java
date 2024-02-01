package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GTraEventDetail extends GSubTraEventDetail implements Serializable {
    public int subdetailcount = 0;
    public int subcount = 0;
    public ArrayList<GSubTraEventDetail> subinfo = new ArrayList<>();
}
