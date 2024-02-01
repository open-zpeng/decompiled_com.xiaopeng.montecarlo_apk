package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpAccountProfileUpdateResponseParam extends BLResponseBase implements Serializable {
    public String uid = "";
    public String username = "";
    public String nickname = "";
    public String avatar = "";
    public String birthday = "";
    public String description = "";
    public long gender = 0;
    public long credit = 0;

    public GWsPpAccountProfileUpdateResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_WSPPACCOUNTPROFILEUPDATE;
    }
}
