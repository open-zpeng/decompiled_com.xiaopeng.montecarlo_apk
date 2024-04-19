package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsShieldNavigationRoutepathrestorationRequestParam extends BLRequestBase implements Serializable {
    public String type = "";
    public String encoder_version = "";
    public String content_options = "";
    public String sdk_vers = "";
    public String brief = "";
    public ArrayList<RoutepathrestorationPathsInfo> paths = new ArrayList<>();
    public RoutepathrestorationVehicleInfo vehicle = new RoutepathrestorationVehicleInfo();
    public RoutepathrestorationPoints start = new RoutepathrestorationPoints();
    public RoutepathrestorationPoints via = new RoutepathrestorationPoints();
    public RoutepathrestorationViaPoints via_info = new RoutepathrestorationViaPoints();
    public RoutepathrestorationEndPoints end = new RoutepathrestorationEndPoints();
}
