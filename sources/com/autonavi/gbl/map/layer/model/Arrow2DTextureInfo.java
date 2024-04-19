package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class Arrow2DTextureInfo implements Serializable {
    public boolean arrowIn2dMap;
    public LineLayerItemTexture borderTexture;
    public boolean canBeCoveredByLabel;
    public LineCapTextureInfo capTextureInfo;
    public boolean drawCover;
    public LineLayerItemTexture fillTexture;
    public LineTextureInfo textureInfo;
    public boolean useCap;
    public boolean useColor;

    public Arrow2DTextureInfo() {
        this.useCap = false;
        this.useColor = false;
        this.drawCover = false;
        this.canBeCoveredByLabel = false;
        this.arrowIn2dMap = false;
        this.fillTexture = new LineLayerItemTexture();
        this.borderTexture = new LineLayerItemTexture();
        this.textureInfo = new LineTextureInfo();
        this.capTextureInfo = new LineCapTextureInfo();
    }

    public Arrow2DTextureInfo(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, LineLayerItemTexture lineLayerItemTexture, LineLayerItemTexture lineLayerItemTexture2, LineTextureInfo lineTextureInfo, LineCapTextureInfo lineCapTextureInfo) {
        this.useCap = z;
        this.useColor = z2;
        this.drawCover = z3;
        this.canBeCoveredByLabel = z4;
        this.arrowIn2dMap = z5;
        this.fillTexture = lineLayerItemTexture;
        this.borderTexture = lineLayerItemTexture2;
        this.textureInfo = lineTextureInfo;
        this.capTextureInfo = lineCapTextureInfo;
    }
}
