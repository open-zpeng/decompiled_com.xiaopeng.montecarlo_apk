package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsOssMaplayerListRequestParam extends BLRequestBase implements Serializable {
    public String adcode = "";
    public String div = "";
    public String dic = "";
    public String md5 = "";
    public int flag = 0;
    public String skin_md5 = "";
    public int layer_mode = 0;

    public GWsOssMaplayerListRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_OSS_WS_OSS_MAPLAYER_LIST;
        this.mEReqMethod = 0;
    }
}
