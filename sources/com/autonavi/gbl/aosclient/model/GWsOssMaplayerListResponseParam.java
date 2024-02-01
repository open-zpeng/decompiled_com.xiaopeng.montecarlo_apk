package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsOssMaplayerListResponseParam extends BLResponseBase implements Serializable {
    public ArrayList<LayerListItem> layer_list = new ArrayList<>();
    public String md5 = "";
    public ArrayList<SkinListItem> skin_list = new ArrayList<>();
    public String skin_md5 = "";

    public GWsOssMaplayerListResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_OSS_WS_OSS_MAPLAYER_LIST;
        this.mNetworkStatus = 0;
    }
}
