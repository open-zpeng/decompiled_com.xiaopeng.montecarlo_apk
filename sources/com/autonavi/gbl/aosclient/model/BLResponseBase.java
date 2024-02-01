package com.autonavi.gbl.aosclient.model;

import com.autonavi.gbl.aosclient.model.EGAOSREQUESTTYPE;
import com.autonavi.gbl.aosclient.model.ENETWORKSTATUS;
import java.io.Serializable;
/* loaded from: classes.dex */
public class BLResponseBase implements Serializable {
    public int code;
    public BLHttpHeader headers;
    @EGAOSREQUESTTYPE.EGAOSREQUESTTYPE1
    public int mEAosRequestType;
    public int mHttpAckCode;
    public int mNetErrorCode;
    @ENETWORKSTATUS.ENETWORKSTATUS1
    public int mNetworkStatus;
    public long mReqHandle;
    public String message;
    public String result;
    public String timestamp;
    public String version;

    public BLResponseBase() {
        this.mEAosRequestType = 0;
        this.mNetErrorCode = 2;
        this.mNetworkStatus = 0;
        this.mReqHandle = 0L;
        this.mHttpAckCode = 0;
        this.code = 0;
        this.timestamp = "";
        this.message = "";
        this.version = "";
        this.result = "";
        this.headers = new BLHttpHeader();
    }

    public BLResponseBase(@EGAOSREQUESTTYPE.EGAOSREQUESTTYPE1 int i, int i2, @ENETWORKSTATUS.ENETWORKSTATUS1 int i3, long j, int i4, int i5, String str, String str2, String str3, String str4, BLHttpHeader bLHttpHeader) {
        this.mEAosRequestType = i;
        this.mNetErrorCode = i2;
        this.mNetworkStatus = i3;
        this.mReqHandle = j;
        this.mHttpAckCode = i4;
        this.code = i5;
        this.timestamp = str;
        this.message = str2;
        this.version = str3;
        this.result = str4;
        this.headers = bLHttpHeader;
    }
}
