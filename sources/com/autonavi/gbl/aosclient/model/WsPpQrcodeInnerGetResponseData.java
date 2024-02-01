package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsPpQrcodeInnerGetResponseData implements Serializable {
    public String amap_qrcode_id;
    public int amap_qrcode_type;
    public String baseurl;
    public int biz_type;
    public int login_type;
    public int uid;

    public WsPpQrcodeInnerGetResponseData() {
        this.baseurl = "";
        this.amap_qrcode_type = 0;
        this.amap_qrcode_id = "";
        this.uid = 0;
        this.login_type = 0;
        this.biz_type = 0;
    }

    public WsPpQrcodeInnerGetResponseData(String str, int i, String str2, int i2, int i3, int i4) {
        this.baseurl = str;
        this.amap_qrcode_type = i;
        this.amap_qrcode_id = str2;
        this.uid = i2;
        this.login_type = i3;
        this.biz_type = i4;
    }
}
