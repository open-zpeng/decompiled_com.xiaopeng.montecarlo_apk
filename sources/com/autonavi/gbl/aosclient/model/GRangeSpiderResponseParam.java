package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GRangeSpiderResponseParam extends BLResponseBase implements Serializable {
    public GRangeSpiderAckMetaInfo metaInfo = new GRangeSpiderAckMetaInfo();
    public GRangeSpiderPoint start = new GRangeSpiderPoint();
    public GRangeSpiderPoint end = new GRangeSpiderPoint();
    public ArrayList<GRangeSpiderAckLineGroup> linegroup = new ArrayList<>();

    public GRangeSpiderResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_RANGESPIDER;
    }
}
