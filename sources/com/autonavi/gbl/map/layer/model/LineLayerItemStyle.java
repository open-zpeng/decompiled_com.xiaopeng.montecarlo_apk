package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class LineLayerItemStyle implements Serializable {
    public LineLayerItemTexture borderTexture;
    public boolean canBeCoveredByLabel;
    public LineCapTextureInfo capTextureInfo;
    public boolean drawCover;
    public LineLayerItemTexture fillTexture;
    public boolean halfSide;
    public int oddWidth;
    public LineLayerItemPassedColor passedColorInfo;
    public LineTextureInfo textureInfo;
    public boolean useCap;
    public boolean useColor;

    public LineLayerItemStyle() {
        this.useCap = false;
        this.useColor = false;
        this.drawCover = false;
        this.canBeCoveredByLabel = false;
        this.halfSide = false;
        this.oddWidth = 0;
        this.fillTexture = new LineLayerItemTexture();
        this.borderTexture = new LineLayerItemTexture();
        this.textureInfo = new LineTextureInfo();
        this.capTextureInfo = new LineCapTextureInfo();
        this.passedColorInfo = new LineLayerItemPassedColor();
    }

    public LineLayerItemStyle(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, LineLayerItemTexture lineLayerItemTexture, LineLayerItemTexture lineLayerItemTexture2, LineTextureInfo lineTextureInfo, LineCapTextureInfo lineCapTextureInfo, LineLayerItemPassedColor lineLayerItemPassedColor) {
        this.useCap = z;
        this.useColor = z2;
        this.drawCover = z3;
        this.canBeCoveredByLabel = z4;
        this.halfSide = z5;
        this.oddWidth = i;
        this.fillTexture = lineLayerItemTexture;
        this.borderTexture = lineLayerItemTexture2;
        this.textureInfo = lineTextureInfo;
        this.capTextureInfo = lineCapTextureInfo;
        this.passedColorInfo = lineLayerItemPassedColor;
    }
}
