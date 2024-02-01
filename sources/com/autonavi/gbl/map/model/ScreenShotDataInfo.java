package com.autonavi.gbl.map.model;

import com.autonavi.gbl.map.model.ScreenShotDataFormatType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class ScreenShotDataInfo implements Serializable {
    @ScreenShotDataFormatType.ScreenShotDataFormatType1
    public int format;
    public int height;
    public int pixelByte;
    public int width;

    public ScreenShotDataInfo() {
        this.format = 0;
        this.pixelByte = 0;
        this.width = 0;
        this.height = 0;
    }

    public ScreenShotDataInfo(@ScreenShotDataFormatType.ScreenShotDataFormatType1 int i, int i2, int i3, int i4) {
        this.format = i;
        this.pixelByte = i2;
        this.width = i3;
        this.height = i4;
    }
}
