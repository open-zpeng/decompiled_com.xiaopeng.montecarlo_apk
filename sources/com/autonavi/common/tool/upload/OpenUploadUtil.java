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
            LogUtil.log("upload param is error");
            return;
        }
        String url = getUrl(i, str, str2, str3, str4, file);
        if (TextUtils.isEmpty(url)) {
            return;
        }
        new HttpEngine().postFileInBody(url, file, httpCallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String getUrl(int r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.io.File r13) {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 50
            r2 = 0
            byte[] r3 = new byte[r1]     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb9
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb9
            r4.<init>(r13)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb9
            int r13 = r4.read(r3)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            if (r13 == r1) goto L23
            java.lang.String r8 = "read zip file error"
            com.autonavi.common.tool.util.LogUtil.log(r8)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            r4.close()     // Catch: java.io.IOException -> L1e
            goto L22
        L1e:
            r8 = move-exception
            r8.printStackTrace()
        L22:
            return r2
        L23:
            int r13 = r3.length     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            r1 = 0
        L25:
            if (r1 >= r13) goto L40
            r5 = r3[r1]     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            char[] r6 = com.autonavi.common.tool.upload.OpenUploadUtil.HEXCHARS     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            int r7 = r5 >> 4
            r7 = r7 & 15
            char r6 = r6[r7]     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            r0.append(r6)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            char[] r6 = com.autonavi.common.tool.upload.OpenUploadUtil.HEXCHARS     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            r5 = r5 & 15
            char r5 = r6[r5]     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            r0.append(r5)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            int r1 = r1 + 1
            goto L25
        L40:
            r13 = 64
            r0.append(r13)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            r0.append(r10)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            java.lang.String r10 = r0.toString()     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            java.lang.String r10 = com.autonavi.common.tool.util.MessageDigestUtil.getStringMD5(r10)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            boolean r13 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            if (r13 != 0) goto L5a
            java.lang.String r10 = r10.toUpperCase()     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
        L5a:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            r13.<init>()     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            java.lang.String r0 = "product="
            r13.append(r0)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            r13.append(r8)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            java.lang.String r8 = "&type="
            r13.append(r8)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            r13.append(r11)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            java.lang.String r8 = "&platform="
            r13.append(r8)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            r13.append(r12)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            java.lang.String r8 = "&channel="
            r13.append(r8)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            r13.append(r9)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            java.lang.String r8 = "&sign="
            r13.append(r8)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            r13.append(r10)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            com.autonavi.common.tool.sign.Sign r8 = new com.autonavi.common.tool.sign.Sign     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            r8.<init>()     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            java.lang.String r9 = r13.toString()     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            java.lang.String r8 = r8.sign(r9)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            r9.<init>()     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            java.lang.String r10 = "http://logs.amap.com/ws/log/upload/?in="
            r9.append(r10)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            java.lang.String r10 = "UTF-8"
            java.lang.String r8 = java.net.URLEncoder.encode(r8, r10)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            r9.append(r8)     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            java.lang.String r8 = r9.toString()     // Catch: java.lang.Exception -> Lb4 java.lang.Throwable -> Lc9
            r4.close()     // Catch: java.io.IOException -> Laf
            goto Lb3
        Laf:
            r9 = move-exception
            r9.printStackTrace()
        Lb3:
            return r8
        Lb4:
            r8 = move-exception
            goto Lbb
        Lb6:
            r8 = move-exception
            r4 = r2
            goto Lca
        Lb9:
            r8 = move-exception
            r4 = r2
        Lbb:
            r8.printStackTrace()     // Catch: java.lang.Throwable -> Lc9
            if (r4 == 0) goto Lc8
            r4.close()     // Catch: java.io.IOException -> Lc4
            goto Lc8
        Lc4:
            r8 = move-exception
            r8.printStackTrace()
        Lc8:
            return r2
        Lc9:
            r8 = move-exception
        Lca:
            if (r4 == 0) goto Ld4
            r4.close()     // Catch: java.io.IOException -> Ld0
            goto Ld4
        Ld0:
            r9 = move-exception
            r9.printStackTrace()
        Ld4:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.common.tool.upload.OpenUploadUtil.getUrl(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.io.File):java.lang.String");
    }
}
