package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class Arrow3DTextureInfo implements Serializable {
    public boolean autoZoomerWidth;
    public int biasWidth;
    public boolean drawSolidArrow;
    public ArrowHeaderParam solidArrowHeaderParam;
    public long solidBorderLineBottomLineColor;
    public int solidBorderLineBottomLineWidth;
    public long solidBorderLineSideLineColor;
    public int solidBorderLineSideLineWidth;
    public long solidBorderLineTopLineColor;
    public int solidBorderLineTopLineWidth;
    public LineCapTextureInfo solidCapTextureInfo;
    public LineCapTextureInfo solidHeaderTextureInfo;
    public int solidHeight;
    public int solidResMarkerId;
    public long solidShadowColor;
    public long solidSideFaceColor;
    public LineTextureInfo solidTextureInfo;
    public int solidThickness;
    public long solidTopFaceColor;

    public Arrow3DTextureInfo() {
        this.drawSolidArrow = true;
        this.biasWidth = 0;
        this.autoZoomerWidth = true;
        this.solidResMarkerId = -1;
        this.solidTopFaceColor = 0L;
        this.solidSideFaceColor = 0L;
        this.solidShadowColor = 0L;
        this.solidHeight = 0;
        this.solidThickness = 0;
        this.solidBorderLineTopLineWidth = 0;
        this.solidBorderLineSideLineWidth = 0;
        this.solidBorderLineBottomLineWidth = 0;
        this.solidBorderLineTopLineColor = 0L;
        this.solidBorderLineSideLineColor = 0L;
        this.solidBorderLineBottomLineColor = 0L;
        this.solidArrowHeaderParam = new ArrowHeaderParam();
        this.solidTextureInfo = new LineTextureInfo();
        this.solidCapTextureInfo = new LineCapTextureInfo();
        this.solidHeaderTextureInfo = new LineCapTextureInfo();
    }

    public Arrow3DTextureInfo(boolean z, int i, boolean z2, int i2, long j, long j2, long j3, int i3, int i4, int i5, int i6, int i7, long j4, long j5, long j6, ArrowHeaderParam arrowHeaderParam, LineTextureInfo lineTextureInfo, LineCapTextureInfo lineCapTextureInfo, LineCapTextureInfo lineCapTextureInfo2) {
        this.drawSolidArrow = z;
        this.biasWidth = i;
        this.autoZoomerWidth = z2;
        this.solidResMarkerId = i2;
        this.solidTopFaceColor = j;
        this.solidSideFaceColor = j2;
        this.solidShadowColor = j3;
        this.solidHeight = i3;
        this.solidThickness = i4;
        this.solidBorderLineTopLineWidth = i5;
        this.solidBorderLineSideLineWidth = i6;
        this.solidBorderLineBottomLineWidth = i7;
        this.solidBorderLineTopLineColor = j4;
        this.solidBorderLineSideLineColor = j5;
        this.solidBorderLineBottomLineColor = j6;
        this.solidArrowHeaderParam = arrowHeaderParam;
        this.solidTextureInfo = lineTextureInfo;
        this.solidCapTextureInfo = lineCapTextureInfo;
        this.solidHeaderTextureInfo = lineCapTextureInfo2;
    }
}
