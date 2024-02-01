package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataDownloadItem implements Serializable {
    public String download_url;
    public long dynamic_id;
    public String file_md5;

    public WsNavigationDynamicDataDownloadItem() {
        this.file_md5 = "";
        this.dynamic_id = 0L;
        this.download_url = "";
    }

    public WsNavigationDynamicDataDownloadItem(String str, long j, String str2) {
        this.file_md5 = str;
        this.dynamic_id = j;
        this.download_url = str2;
    }
}
