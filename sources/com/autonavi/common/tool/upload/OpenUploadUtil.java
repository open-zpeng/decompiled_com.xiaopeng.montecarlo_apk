package com.autonavi.common.tool.upload;

import android.text.TextUtils;
import com.autonavi.common.tool.http.HttpCallback;
import com.autonavi.common.tool.http.HttpEngine;
import com.autonavi.common.tool.util.LogUtil;
import java.io.File;
/* loaded from: classes.dex */
public class OpenUploadUtil {
    private static char[] HEXCHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String TAG = "RestUploadFile";
    private static final String UPLOAD_URL = "http://logs.amap.com/ws/log/upload/?in=";

    public static void upload(int i, String str, String str2, String str3, String str4, File file, HttpCallback httpCallback) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || file == null || !file.exists()) {
            LogUtil.logE("upload param is error");
            return;
        }
        LogUtil.logE("channel: " + str + "; key: " + str2);
        String url = getUrl(i, str, str2, str3, str4, file);
        if (TextUtils.isEmpty(url)) {
            return;
        }
        LogUtil.logE("post url = " + url);
        new HttpEngine().postFileInBody(url, file, httpCallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String getUrl(int r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.io.File r15) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.common.tool.upload.OpenUploadUtil.getUrl(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.io.File):java.lang.String");
    }
}
