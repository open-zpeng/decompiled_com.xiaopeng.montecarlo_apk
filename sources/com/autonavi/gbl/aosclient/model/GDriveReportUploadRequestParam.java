package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GDriveReportUploadRequestParam extends BLRequestBase implements Serializable {
    public float f32X = 0.0f;
    public float f32Y = 0.0f;
    public String id = "";
    public float startX = 0.0f;
    public float startY = 0.0f;
    public String startPoiName = "";
    public float endX = 0.0f;
    public float endY = 0.0f;
    public String endPoiName = "";
    public String viaPoints = "";
    public boolean finished = false;
    public int duration = 0;
    public int distance = 0;
    public int totalDistance = 0;
    public int residualDistance = 0;
    public float speed = 0.0f;
    public int leftTime = 0;
    public String option = "";
    public ArrayList<GWsShieldNavigationRoutepathrestorationRequestParam> link_info = new ArrayList<>();

    public GDriveReportUploadRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_OSS_DRIVEREPORTUPLOAD;
    }
}
