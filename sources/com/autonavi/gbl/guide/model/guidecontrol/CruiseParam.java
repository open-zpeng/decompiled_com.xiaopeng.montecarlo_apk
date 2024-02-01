package com.autonavi.gbl.guide.model.guidecontrol;

import com.autonavi.gbl.guide.model.DistanceRange;
import java.io.Serializable;
/* loaded from: classes.dex */
public class CruiseParam extends BaseParam implements Serializable {
    public boolean enableADCode = true;
    public int mode = 7;
    public long cameraNum = 10;
    public long facilityNum = 2;
    public DistanceRange checkFreewayDistance = new DistanceRange();
    public DistanceRange checkCitySpeedwayDistance = new DistanceRange();
    public DistanceRange checkDefaultDistance = new DistanceRange();
    public CruisePredictive predictive = new CruisePredictive();

    public CruiseParam() {
        this.paramType = 6;
        DistanceRange distanceRange = this.checkFreewayDistance;
        distanceRange.min = 100;
        distanceRange.max = 300;
        DistanceRange distanceRange2 = this.checkCitySpeedwayDistance;
        distanceRange2.min = 100;
        distanceRange2.max = 300;
        DistanceRange distanceRange3 = this.checkDefaultDistance;
        distanceRange3.min = 100;
        distanceRange3.max = 300;
    }
}
