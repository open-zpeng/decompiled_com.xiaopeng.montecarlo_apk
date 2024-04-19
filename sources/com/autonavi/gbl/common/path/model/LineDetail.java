package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LineDetail implements Serializable {
    public LineCloudControl lineControl;
    public ArrayList<RelDetail> vecRelLineDetail;

    public LineDetail() {
        this.lineControl = new LineCloudControl();
        this.vecRelLineDetail = new ArrayList<>();
    }

    public LineDetail(LineCloudControl lineCloudControl, ArrayList<RelDetail> arrayList) {
        this.lineControl = lineCloudControl;
        this.vecRelLineDetail = arrayList;
    }
}
