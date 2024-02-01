package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GNavigationEtaqueryResponseParam extends BLResponseBase implements Serializable {
    public ArrayList<GNavigationEtaqueryAckRouteList> route_list = new ArrayList<>();

    public GNavigationEtaqueryResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_NAVIGATIONETAQUERY;
    }
}
