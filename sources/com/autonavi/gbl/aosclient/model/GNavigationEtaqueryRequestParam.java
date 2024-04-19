package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GNavigationEtaqueryRequestParam extends BLRequestBase implements Serializable {
    public String OneToN = "";
    public GNavigationEtaqueryReqRoute route = new GNavigationEtaqueryReqRoute();
    public GNavigationEtaqueryReqClient client = new GNavigationEtaqueryReqClient();
    public GNavigationEtaqueryReqVehicle vehicle = new GNavigationEtaqueryReqVehicle();
    public GNavigationEtaqueryReqStartEnd start = new GNavigationEtaqueryReqStartEnd();
    public GNavigationEtaqueryReqStartEnd end = new GNavigationEtaqueryReqStartEnd();
    public GNavigationEtaqueryReqStartEnd via = new GNavigationEtaqueryReqStartEnd();
}
