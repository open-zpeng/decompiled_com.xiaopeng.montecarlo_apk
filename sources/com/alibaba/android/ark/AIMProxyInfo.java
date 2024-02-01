package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMProxyInfo implements Serializable {
    private static final long serialVersionUID = 5910732621542675608L;
    public String host;
    public String ip;
    public String password;
    public String port;
    public AIMProxyType proxyType;
    public String username;

    public AIMProxyInfo(AIMProxyType aIMProxyType, String str, String str2, String str3, String str4, String str5) {
        this.proxyType = AIMProxyType.PROXY_TYPE_UNKNOWN;
        if (aIMProxyType != null) {
            this.proxyType = aIMProxyType;
        }
        this.host = str;
        this.ip = str2;
        this.port = str3;
        this.username = str4;
        this.password = str5;
    }

    public AIMProxyInfo() {
        this.proxyType = AIMProxyType.PROXY_TYPE_UNKNOWN;
    }

    public AIMProxyType getProxyType() {
        return this.proxyType;
    }

    public String getHost() {
        return this.host;
    }

    public String getIp() {
        return this.ip;
    }

    public String getPort() {
        return this.port;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String toString() {
        return "AIMProxyInfo{proxyType=" + this.proxyType + ",host=" + this.host + ",ip=" + this.ip + ",port=" + this.port + ",username=" + this.username + ",password=" + this.password + "}";
    }
}
