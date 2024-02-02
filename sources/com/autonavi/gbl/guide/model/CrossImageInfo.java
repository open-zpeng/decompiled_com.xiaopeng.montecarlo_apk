package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.guide.model.CrossType;
import com.autonavi.gbl.guide.model.VectorCrossImageType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class CrossImageInfo implements Serializable {
    public byte[] arrowDataBuf;
    public BigInteger crossImageID;
    public byte[] dataBuf;
    public long distance;
    public boolean isOnlyVector;
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
        this.dataBuf = null;
        this.arrowDataBuf = null;
    }

    public CrossImageInfo(@CrossType.CrossType1 int i, @VectorCrossImageType.VectorCrossImageType1 int i2, byte[] bArr, byte[] bArr2, BigInteger bigInteger, boolean z, long j) {
        this.type = i;
        this.vectorType = i2;
        this.dataBuf = bArr;
        this.arrowDataBuf = bArr2;
        this.crossImageID = bigInteger;
        this.isOnlyVector = z;
        this.distance = j;
    }
}
