package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.guide.model.CrossType;
import com.autonavi.gbl.guide.model.VectorCrossImageType;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CrossImageInfo implements Serializable {
    public byte[] arrowDataBuf;
    public ArrayList<CrossCardChangeInfo> cardChangeInfo;
    public BigInteger crossImageID;
    public byte[] dataBuf;
    public long distance;
    public long firstMixforkLink;
    public boolean isOnlyVector;
    public long lastMixforkLink;
    public ArrayList<Long> mixforkLinkArray;
    public ArrayList<CrossLinkLocation> motionChangeInfo;
    @CrossType.CrossType1
    public int type;
    @VectorCrossImageType.VectorCrossImageType1
    public int vectorType;

    public CrossImageInfo() {
        this.type = 1;
        this.vectorType = -1;
        this.crossImageID = new BigInteger("0");
        this.isOnlyVector = false;
        this.distance = 0L;
        this.firstMixforkLink = 0L;
        this.lastMixforkLink = 0L;
        this.mixforkLinkArray = new ArrayList<>();
        this.motionChangeInfo = new ArrayList<>();
        this.cardChangeInfo = new ArrayList<>();
        this.dataBuf = null;
        this.arrowDataBuf = null;
    }

    public CrossImageInfo(@CrossType.CrossType1 int i, @VectorCrossImageType.VectorCrossImageType1 int i2, byte[] bArr, byte[] bArr2, BigInteger bigInteger, boolean z, long j, long j2, long j3, ArrayList<Long> arrayList, ArrayList<CrossLinkLocation> arrayList2, ArrayList<CrossCardChangeInfo> arrayList3) {
        this.type = i;
        this.vectorType = i2;
        this.dataBuf = bArr;
        this.arrowDataBuf = bArr2;
        this.crossImageID = bigInteger;
        this.isOnlyVector = z;
        this.distance = j;
        this.firstMixforkLink = j2;
        this.lastMixforkLink = j3;
        this.mixforkLinkArray = arrayList;
        this.motionChangeInfo = arrayList2;
        this.cardChangeInfo = arrayList3;
    }
}
