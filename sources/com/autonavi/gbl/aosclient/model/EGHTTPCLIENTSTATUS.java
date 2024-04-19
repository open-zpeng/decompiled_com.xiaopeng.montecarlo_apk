package com.autonavi.gbl.aosclient.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class EGHTTPCLIENTSTATUS {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int CLIENTSTATUS_CONNECT_ERROR = 4;
    public static final int CLIENTSTATUS_DNS_TIMEOUT = 3;
    public static final int CLIENTSTATUS_FINISH = 11;
    public static final int CLIENTSTATUS_INIT = 0;
    public static final int CLIENTSTATUS_NO_NET = 2;
    public static final int CLIENTSTATUS_RECV_BODY = 10;
    public static final int CLIENTSTATUS_RECV_ERROR = 8;
    public static final int CLIENTSTATUS_RECV_HEADER = 9;
    public static final int CLIENTSTATUS_SEND_BODY = 7;
    public static final int CLIENTSTATUS_SEND_ERROR = 5;
    public static final int CLIENTSTATUS_SEND_HEADER = 6;
    public static final int CLIENTSTATUS_UNKNOWN = 1000000;
    public static final int CLIENTSTATUS_USER_ABORT = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface EGHTTPCLIENTSTATUS1 {
    }
}
