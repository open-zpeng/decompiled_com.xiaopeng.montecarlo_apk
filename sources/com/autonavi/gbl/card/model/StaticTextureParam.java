package com.autonavi.gbl.card.model;

import com.autonavi.gbl.map.layer.model.LayerIconAnchor;
import java.io.Serializable;
/* loaded from: classes.dex */
public class StaticTextureParam implements Serializable {
    @LayerIconAnchor.LayerIconAnchor1
    public int anchorType;
    public boolean isGenMipmaps;
    public boolean isPreMulAlpha;
    public boolean isRepeat;
    public MarkerKeyParam markerKey;
    public float xRatio;
    public float yRatio;

    public StaticTextureParam() {
        this.markerKey = new MarkerKeyParam();
        this.anchorType = 0;
        this.xRatio = 0.0f;
        this.yRatio = 0.0f;
        this.isGenMipmaps = false;
        this.isRepeat = false;
        this.isPreMulAlpha = true;
    }

    public StaticTextureParam(MarkerKeyParam markerKeyParam, @LayerIconAnchor.LayerIconAnchor1 int i, float f, float f2, boolean z, boolean z2, boolean z3) {
        this.markerKey = markerKeyParam;
        this.anchorType = i;
        this.xRatio = f;
        this.yRatio = f2;
        this.isGenMipmaps = z;
        this.isRepeat = z2;
        this.isPreMulAlpha = z3;
    }
}
