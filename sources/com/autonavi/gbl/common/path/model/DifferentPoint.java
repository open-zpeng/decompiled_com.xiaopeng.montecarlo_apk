package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DifferentPoint implements Serializable {
    public ArrayList<Long> firstPathDivergeIndexs;
    public long firstPathID;
    public ArrayList<Long> firstPathMergeIndexs;
    public ArrayList<Long> secondPathDivergeIndexs;
    public long secondPathID;
    public ArrayList<Long> secondPathMergeIndexs;

    public DifferentPoint() {
        this.firstPathID = 0L;
        this.secondPathID = 0L;
        this.firstPathDivergeIndexs = new ArrayList<>();
        this.firstPathMergeIndexs = new ArrayList<>();
        this.secondPathDivergeIndexs = new ArrayList<>();
        this.secondPathMergeIndexs = new ArrayList<>();
    }

    public DifferentPoint(long j, long j2, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, ArrayList<Long> arrayList3, ArrayList<Long> arrayList4) {
        this.firstPathID = j;
        this.secondPathID = j2;
        this.firstPathDivergeIndexs = arrayList;
        this.firstPathMergeIndexs = arrayList2;
        this.secondPathDivergeIndexs = arrayList3;
        this.secondPathMergeIndexs = arrayList4;
    }
}
