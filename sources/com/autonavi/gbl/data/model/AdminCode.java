package com.autonavi.gbl.data.model;

import com.autonavi.gbl.data.model.RegionCode;
import java.io.Serializable;
/* loaded from: classes.dex */
public class AdminCode implements Serializable {
    @RegionCode.RegionCode1
    public int euRegionCode;
    public int nAdCode;
    public int nCityAdCode;

    public AdminCode() {
        this.euRegionCode = 0;
        this.nCityAdCode = 0;
        this.nAdCode = 0;
    }

    public AdminCode(@RegionCode.RegionCode1 int i, int i2, int i3) {
        this.euRegionCode = i;
        this.nCityAdCode = i2;
        this.nAdCode = i3;
    }
}
