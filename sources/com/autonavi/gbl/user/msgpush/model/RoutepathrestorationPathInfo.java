package com.autonavi.gbl.user.msgpush.model;

import com.autonavi.gbl.aosclient.model.RoutepathrestorationPathsInfo;
import com.autonavi.gbl.aosclient.model.RoutepathrestorationPoints;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class RoutepathrestorationPathInfo implements Serializable {
    public RoutepathrestorationPoints endPoints;
    public ArrayList<RoutepathrestorationPathsInfo> paths;
    public RoutepathrestorationPoints startPoints;
    public RoutepathrestorationPoints viaPoints;

    public RoutepathrestorationPathInfo() {
        this.startPoints = new RoutepathrestorationPoints();
        this.viaPoints = new RoutepathrestorationPoints();
        this.endPoints = new RoutepathrestorationPoints();
        this.paths = new ArrayList<>();
    }

    public RoutepathrestorationPathInfo(RoutepathrestorationPoints routepathrestorationPoints, RoutepathrestorationPoints routepathrestorationPoints2, RoutepathrestorationPoints routepathrestorationPoints3, ArrayList<RoutepathrestorationPathsInfo> arrayList) {
        this.startPoints = routepathrestorationPoints;
        this.viaPoints = routepathrestorationPoints2;
        this.endPoints = routepathrestorationPoints3;
        this.paths = arrayList;
    }
}
