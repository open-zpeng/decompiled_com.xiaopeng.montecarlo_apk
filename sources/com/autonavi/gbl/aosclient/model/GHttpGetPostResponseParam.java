package com.autonavi.gbl.aosclient.model;

import com.autonavi.gbl.util.model.BinaryStream;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GHttpGetPostResponseParam extends BLResponseBase implements Serializable {
    public int ack_code = 0;
    public ArrayList<HttpHeaderKeyValue> ack_headers = new ArrayList<>();
    public BinaryStream ack_body = new BinaryStream();

    public GHttpGetPostResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_AOS_HTTP_GET_POST;
        this.mNetworkStatus = 0;
    }
}
