package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpAccountProfileUpdateRequestParam extends BLRequestBase implements Serializable {
    public String div = "";
    public String autodiv = "";
    public String dip = "";
    public String uid = "";
    public String nickname = "";
    public String birthday = "";
    public String signature = "";
    public String avatar = "";
    public long gender = 0;

    public GWsPpAccountProfileUpdateRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_WSPPACCOUNTPROFILEUPDATE;
    }
}
