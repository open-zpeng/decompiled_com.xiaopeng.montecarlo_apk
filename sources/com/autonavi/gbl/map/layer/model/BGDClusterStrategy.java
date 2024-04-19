package com.autonavi.gbl.map.layer.model;

import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.map.layer.model.ClusterCenterType;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class BGDClusterStrategy implements Serializable {
    @ClusterCenterType.ClusterCenterType1
    public int centerType;
    public RectInt clusterRange;
    public long minClusterSize;
    public int[] vecClusterDis;
    public ArrayList<ClusterDisplayScale> vecDisplayScale;

    public BGDClusterStrategy() {
        this.centerType = 0;
        this.minClusterSize = 2L;
        this.clusterRange = new RectInt();
        this.vecDisplayScale = new ArrayList<>();
        this.vecClusterDis = new int[23];
    }

    public BGDClusterStrategy(@ClusterCenterType.ClusterCenterType1 int i, long j, RectInt rectInt, int[] iArr, ArrayList<ClusterDisplayScale> arrayList) {
        this.centerType = i;
        this.minClusterSize = j;
        this.clusterRange = rectInt;
        this.vecClusterDis = iArr;
        this.vecDisplayScale = arrayList;
    }
}
