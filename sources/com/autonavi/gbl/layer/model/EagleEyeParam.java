package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.util.model.BinaryStream;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class EagleEyeParam implements Serializable {
    public BinaryStream dataBuff;
    public long endPreviewLength;
    public long endUpdateLength;
    public long endUpdateTimeG;
    public long endUpdateTimeS;
    public boolean isDrawViaPoint;
    public int targetWidth;
    public long viaUpdateLength;
    public long viaUpdateTimeG;
    public long viaUpdateTimeS;

    public EagleEyeParam() {
        this.isDrawViaPoint = false;
        this.targetWidth = -1;
        this.endPreviewLength = 0L;
        this.viaUpdateLength = 3000L;
        this.viaUpdateTimeG = 60L;
        this.viaUpdateTimeS = 10L;
        this.endUpdateLength = 3000L;
        this.endUpdateTimeG = 60L;
        this.endUpdateTimeS = 10L;
        this.dataBuff = new BinaryStream();
    }

    public EagleEyeParam(boolean z, int i, long j, long j2, long j3, long j4, long j5, long j6, long j7, BinaryStream binaryStream) {
        this.isDrawViaPoint = z;
        this.targetWidth = i;
        this.endPreviewLength = j;
        this.viaUpdateLength = j2;
        this.viaUpdateTimeG = j3;
        this.viaUpdateTimeS = j4;
        this.endUpdateLength = j5;
        this.endUpdateTimeG = j6;
        this.endUpdateTimeS = j7;
        this.dataBuff = binaryStream;
    }
}
