package com.autonavi.gbl.aosclient.model;

import com.autonavi.gbl.util.model.BinaryStream;
import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsShieldNavigationRoutepathrestorationResponseParam extends BLResponseBase implements Serializable {
    public BinaryStream ack_body = new BinaryStream();

    public GWsShieldNavigationRoutepathrestorationResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SHIELD_NAVIGATION_ROUTEPATHRESTORATION;
        this.mNetworkStatus = 0;
    }
}
