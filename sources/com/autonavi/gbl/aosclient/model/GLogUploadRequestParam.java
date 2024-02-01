package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GLogUploadRequestParam extends BLRequestBase implements Serializable {
    public String m_product = "";
    public String m_type = "";
    public String m_platform = "";
    public String m_channel = "";
    public String m_aoskey = "";
    public String m_strZipLogFile = "";

    public GLogUploadRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_PAGE_LOGUPLOAD;
    }
}
