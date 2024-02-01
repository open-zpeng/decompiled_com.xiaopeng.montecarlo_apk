package com.autonavi.gbl.map.model;

import com.autonavi.gbl.map.model.MapStyleMode;
import com.autonavi.gbl.map.model.MapStyleTime;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class MapStyleParam implements Serializable {
    public int channel;
    public boolean fadeOut;
    public boolean forceUpdate;
    public String indoorParkStyleName;
    @MapStyleMode.MapStyleMode1
    public int mode;
    public int state;
    public String style;
    public int themeId;
    @MapStyleTime.MapStyleTime1
    public int time;

    public MapStyleParam() {
        this.mode = 0;
        this.time = 0;
        this.state = 0;
        this.channel = 0;
        this.fadeOut = true;
        this.style = "";
        this.indoorParkStyleName = "";
        this.forceUpdate = false;
        this.themeId = -1;
    }

    public MapStyleParam(@MapStyleMode.MapStyleMode1 int i, @MapStyleTime.MapStyleTime1 int i2, int i3, int i4, boolean z, String str, String str2, boolean z2, int i5) {
        this.mode = i;
        this.time = i2;
        this.state = i3;
        this.channel = i4;
        this.fadeOut = z;
        this.style = str;
        this.indoorParkStyleName = str2;
        this.forceUpdate = z2;
        this.themeId = i5;
    }
}
