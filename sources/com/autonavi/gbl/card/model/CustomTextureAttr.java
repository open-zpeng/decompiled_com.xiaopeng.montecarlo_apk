package com.autonavi.gbl.card.model;

import com.autonavi.gbl.map.layer.model.LayerIconAnchor;
import java.io.Serializable;
/* loaded from: classes.dex */
public class CustomTextureAttr implements Serializable {
    @LayerIconAnchor.LayerIconAnchor1
    public int anchorType;
    public boolean isEnableStrategy;
    public boolean isGenMipmaps;
    public boolean isNightForAsvg;
    public boolean isPreMulAlpha;
    public boolean isRepeat;
    public float scaleFactor;
    public long xOffset;
    public float xRatio;
    public long yOffset;
    public float yRatio;

    public CustomTextureAttr() {
        this.scaleFactor = 1.0f;
        this.isNightForAsvg = false;
        this.isEnableStrategy = false;
        this.anchorType = 0;
        this.xRatio = 0.0f;
        this.yRatio = 0.0f;
        this.xOffset = 0L;
        this.yOffset = 0L;
        this.isGenMipmaps = false;
        this.isRepeat = false;
        this.isPreMulAlpha = true;
    }

    public CustomTextureAttr(float f, boolean z, boolean z2, @LayerIconAnchor.LayerIconAnchor1 int i, float f2, float f3, long j, long j2, boolean z3, boolean z4, boolean z5) {
        this.scaleFactor = f;
        this.isNightForAsvg = z;
        this.isEnableStrategy = z2;
        this.anchorType = i;
        this.xRatio = f2;
        this.yRatio = f3;
        this.xOffset = j;
        this.yOffset = j2;
        this.isGenMipmaps = z3;
        this.isRepeat = z4;
        this.isPreMulAlpha = z5;
    }
}
