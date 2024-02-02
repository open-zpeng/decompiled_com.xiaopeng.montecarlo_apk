package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.map.model.MapColorParam;
import com.autonavi.gbl.map.model.MapViewParam;
import java.io.Serializable;
/* loaded from: classes.dex */
public class EagleEyeStyle implements Serializable {
    public EagleEyeParam eagleEyeParam;
    public boolean isNightMode;
    public MapColorParam mapColorParamDay;
    public MapColorParam mapColorParamNight;
    public MapViewParam mapViewParam;

    public EagleEyeStyle() {
        this.mapViewParam = new MapViewParam();
        this.mapColorParamDay = new MapColorParam();
        this.mapColorParamNight = new MapColorParam();
        this.eagleEyeParam = new EagleEyeParam();
        this.isNightMode = false;
    }

    public EagleEyeStyle(MapViewParam mapViewParam, MapColorParam mapColorParam, MapColorParam mapColorParam2, EagleEyeParam eagleEyeParam, boolean z) {
        this.mapViewParam = mapViewParam;
        this.mapColorParamDay = mapColorParam;
        this.mapColorParamNight = mapColorParam2;
        this.eagleEyeParam = eagleEyeParam;
        this.isNightMode = z;
    }
}
