package com.autonavi.gbl.aosclient.model;

import com.autonavi.gbl.aosclient.model.EGAOSREQUESTTYPE;
import com.autonavi.gbl.aosclient.model.EGHTTPREQMETHOD;
import com.autonavi.gbl.aosclient.model.EGPROTOCOL;
import java.io.Serializable;
/* loaded from: classes.dex */
public class BLRequestBase implements Serializable {
    @EGAOSREQUESTTYPE.EGAOSREQUESTTYPE1
    public int mEAosRequestType;
    @EGHTTPREQMETHOD.EGHTTPREQMETHOD1
    public int mEReqMethod;
    @EGPROTOCOL.EGPROTOCOL1
    public int mEReqProtol;
    public long mGroup;
    public long mTimeOut;

    public BLRequestBase() {
        this.mEAosRequestType = 0;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
        this.mTimeOut = 30000L;
        this.mGroup = 0L;
    }

    public BLRequestBase(@EGAOSREQUESTTYPE.EGAOSREQUESTTYPE1 int i, @EGPROTOCOL.EGPROTOCOL1 int i2, @EGHTTPREQMETHOD.EGHTTPREQMETHOD1 int i3, long j, long j2) {
        this.mEAosRequestType = i;
        this.mEReqProtol = i2;
        this.mEReqMethod = i3;
        this.mTimeOut = j;
        this.mGroup = j2;
    }
}
