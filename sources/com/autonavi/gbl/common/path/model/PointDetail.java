package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PointDetail implements Serializable {
    public PointCloudControl pointControl;
    public ArrayList<RelDetail> vecRelPointDetail;

    public PointDetail() {
        this.pointControl = new PointCloudControl();
        this.vecRelPointDetail = new ArrayList<>();
    }

    public PointDetail(PointCloudControl pointCloudControl, ArrayList<RelDetail> arrayList) {
        this.pointControl = pointCloudControl;
        this.vecRelPointDetail = arrayList;
    }
}
