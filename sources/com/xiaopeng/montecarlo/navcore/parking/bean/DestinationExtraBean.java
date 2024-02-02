package com.xiaopeng.montecarlo.navcore.parking.bean;

import com.autonavi.gbl.common.path.model.Formway;
import com.autonavi.gbl.common.path.model.RoadClass;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class DestinationExtraBean {
    @SerializedName("road_class")
    @RoadClass.RoadClass1
    private int mRoadClass = -1;
    @SerializedName("road_link_type")
    private int mRoadLinkType = -1;
    @SerializedName("road_formway")
    @Formway.Formway1
    private int mRoadFormway = -1;

    protected boolean canEqual(Object obj) {
        return obj instanceof DestinationExtraBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DestinationExtraBean) {
            DestinationExtraBean destinationExtraBean = (DestinationExtraBean) obj;
            return destinationExtraBean.canEqual(this) && getRoadClass() == destinationExtraBean.getRoadClass() && getRoadLinkType() == destinationExtraBean.getRoadLinkType() && getRoadFormway() == destinationExtraBean.getRoadFormway();
        }
        return false;
    }

    public int hashCode() {
        return ((((getRoadClass() + 59) * 59) + getRoadLinkType()) * 59) + getRoadFormway();
    }

    public DestinationExtraBean setRoadClass(int i) {
        this.mRoadClass = i;
        return this;
    }

    public DestinationExtraBean setRoadFormway(int i) {
        this.mRoadFormway = i;
        return this;
    }

    public DestinationExtraBean setRoadLinkType(int i) {
        this.mRoadLinkType = i;
        return this;
    }

    public String toString() {
        return "DestinationExtraBean(mRoadClass=" + getRoadClass() + ", mRoadLinkType=" + getRoadLinkType() + ", mRoadFormway=" + getRoadFormway() + ")";
    }

    public int getRoadClass() {
        return this.mRoadClass;
    }

    public int getRoadLinkType() {
        return this.mRoadLinkType;
    }

    public int getRoadFormway() {
        return this.mRoadFormway;
    }
}
