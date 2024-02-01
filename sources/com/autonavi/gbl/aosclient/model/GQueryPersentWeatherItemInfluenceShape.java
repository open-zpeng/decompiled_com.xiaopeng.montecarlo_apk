package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GQueryPersentWeatherItemInfluenceShape implements Serializable {
    public GQueryPersentWeatherReqItemPoint center;
    public String id;
    public ArrayList<GQueryPersentWeatherReqItemPoint> points;

    public GQueryPersentWeatherItemInfluenceShape() {
        this.points = new ArrayList<>();
        this.id = "";
        this.center = new GQueryPersentWeatherReqItemPoint();
    }

    public GQueryPersentWeatherItemInfluenceShape(ArrayList<GQueryPersentWeatherReqItemPoint> arrayList, String str, GQueryPersentWeatherReqItemPoint gQueryPersentWeatherReqItemPoint) {
        this.points = arrayList;
        this.id = str;
        this.center = gQueryPersentWeatherReqItemPoint;
    }
}
