package com.autonavi.gbl.map.model;

import com.autonavi.gbl.map.model.MapLabelType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class MapLabelItem implements Serializable {
    public int anchor;
    public int angle;
    public boolean bFouces;
    public int borderColor;
    public int fontColor;
    public int fontSize;
    public int iconID;
    public int labelx;
    public int labely;
    public String name;
    public int pixel20X;
    public int pixel20Y;
    public String poiid;
    public int sublayerId;
    @MapLabelType.MapLabelType1
    public int type;
    public int x;
    public int y;

    public MapLabelItem() {
        this.name = "";
        this.poiid = "";
        this.x = 0;
        this.y = 0;
        this.angle = 0;
        this.iconID = 0;
        this.labelx = 0;
        this.labely = 0;
        this.pixel20X = 0;
        this.pixel20Y = 0;
        this.fontColor = 0;
        this.borderColor = 0;
        this.type = 0;
        this.anchor = 0;
        this.fontSize = 0;
        this.sublayerId = 0;
        this.bFouces = false;
    }

    public MapLabelItem(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, @MapLabelType.MapLabelType1 int i11, int i12, int i13, int i14, boolean z) {
        this.name = str;
        this.poiid = str2;
        this.x = i;
        this.y = i2;
        this.angle = i3;
        this.iconID = i4;
        this.labelx = i5;
        this.labely = i6;
        this.pixel20X = i7;
        this.pixel20Y = i8;
        this.fontColor = i9;
        this.borderColor = i10;
        this.type = i11;
        this.anchor = i12;
        this.fontSize = i13;
        this.sublayerId = i14;
        this.bFouces = z;
    }
}
