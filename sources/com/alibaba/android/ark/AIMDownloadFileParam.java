package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMDownloadFileParam implements Serializable {
    private static final long serialVersionUID = -5193312235886561442L;
    public String downloadUrl;
    public String path;

    public AIMDownloadFileParam(String str, String str2) {
        this.downloadUrl = str;
        this.path = str2;
    }

    public AIMDownloadFileParam() {
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getPath() {
        return this.path;
    }

    public String toString() {
        return "AIMDownloadFileParam{downloadUrl=" + this.downloadUrl + ",path=" + this.path + "}";
    }
}
