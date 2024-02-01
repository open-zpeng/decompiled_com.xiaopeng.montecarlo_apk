package com.autonavi.gbl.aosclient.model;

import com.autonavi.gbl.util.model.BinaryStream;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GHttpGetPostRequestParam extends BLRequestBase implements Serializable {
    public String req_url = "";
    public ArrayList<HttpHeaderKeyValue> req_headers = new ArrayList<>();
    public BinaryStream req_body = new BinaryStream();

    public GHttpGetPostRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_AOS_HTTP_GET_POST;
        this.mEReqMethod = 0;
    }
}
