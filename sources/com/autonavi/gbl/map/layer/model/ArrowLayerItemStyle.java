package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ArrowLayerItemStyle implements Serializable {
    public Arrow2DTextureInfo arrow2DTextureInfo;
    public Arrow3DTextureInfo arrow3DTextureInfo;
    public ArrowFineTextureInfo arrowFineTextureInfo;

    public ArrowLayerItemStyle() {
        this.arrow2DTextureInfo = new Arrow2DTextureInfo();
        this.arrow3DTextureInfo = new Arrow3DTextureInfo();
        this.arrowFineTextureInfo = new ArrowFineTextureInfo();
    }

    public ArrowLayerItemStyle(Arrow2DTextureInfo arrow2DTextureInfo, Arrow3DTextureInfo arrow3DTextureInfo, ArrowFineTextureInfo arrowFineTextureInfo) {
        this.arrow2DTextureInfo = arrow2DTextureInfo;
        this.arrow3DTextureInfo = arrow3DTextureInfo;
        this.arrowFineTextureInfo = arrowFineTextureInfo;
    }
}
