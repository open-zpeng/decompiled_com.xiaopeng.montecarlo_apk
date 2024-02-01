package com.autonavi.common.tool.http;

import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public interface HttpCallback {
    void onError(Throwable th);

    void onFinish(HttpURLConnection httpURLConnection) throws Throwable;
}
