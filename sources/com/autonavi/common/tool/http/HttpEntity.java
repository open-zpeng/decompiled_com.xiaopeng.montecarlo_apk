package com.autonavi.common.tool.http;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
interface HttpEntity {
    String getContentType();

    void writeTo(OutputStream outputStream) throws IOException;
}
