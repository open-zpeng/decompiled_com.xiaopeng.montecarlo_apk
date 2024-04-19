package com.autonavi.gbl.map.layer.model;

import com.autonavi.gbl.map.layer.model.LayerIconAnchor;
import com.autonavi.gbl.map.layer.model.LayerIconType;
import com.autonavi.gbl.map.layer.model.LayerTextureErrorCode;
import com.autonavi.gbl.util.model.BinaryStream;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LayerTexture implements Serializable {
    @LayerIconAnchor.LayerIconAnchor1
    public int anchorType;
    public BinaryStream dataBuff;
    @LayerTextureErrorCode.LayerTextureErrorCode1
    public int errorCode;
    public long height;
    @LayerIconType.LayerIconType1
    public int iconType;
    public boolean isGenMipmaps;
    public boolean isPreMulAlpha;
    public boolean isRepeat;
    public String name;
    public int resID;
    public long width;
    public float xRatio;
    public float yRatio;

    public LayerTexture() {
        this.resID = 0;
        this.dataBuff = new BinaryStream();
        this.anchorType = 4;
        this.width = 0L;
        this.height = 0L;
        this.xRatio = 0.0f;
        this.yRatio = 0.0f;
        this.iconType = 1;
        this.isGenMipmaps = false;
        this.isRepeat = false;
        this.errorCode = 0;
        this.name = "";
        this.isPreMulAlpha = true;
    }

    public LayerTexture(int i, BinaryStream binaryStream, @LayerIconAnchor.LayerIconAnchor1 int i2, long j, long j2, float f, float f2, @LayerIconType.LayerIconType1 int i3, boolean z, boolean z2, @LayerTextureErrorCode.LayerTextureErrorCode1 int i4, String str, boolean z3) {
        this.resID = i;
        this.dataBuff = binaryStream;
        this.anchorType = i2;
        this.width = j;
        this.height = j2;
        this.xRatio = f;
        this.yRatio = f2;
        this.iconType = i3;
        this.isGenMipmaps = z;
        this.isRepeat = z2;
        this.errorCode = i4;
        this.name = str;
        this.isPreMulAlpha = z3;
    }
}
