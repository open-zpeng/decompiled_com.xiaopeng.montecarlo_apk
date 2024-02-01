package com.autonavi.gbl.aosclient.model;

import com.autonavi.gbl.util.model.BinaryStream;
import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsAutoCollectRequestParam extends BLRequestBase implements Serializable {
    public String mode = "";
    public BinaryStream content = new BinaryStream();
    public long uploadTime = 0;
    public String group = "";

    public GWsAutoCollectRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WS_AUTO_COLLECT;
        this.mEReqProtol = 0;
        this.mEReqMethod = 1;
    }
}
