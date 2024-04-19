package com.dingtalk.bifrost;

import android.os.Environment;
import com.dingtalk.mobile.common.transport.utils.BifrostLogCatUtil;
import java.io.File;
/* loaded from: classes2.dex */
public class BifrostObject {
    private static final String PROXY_FILE = "alipay_net.conf";
    private static final String TAG = "BifrostObject";

    /* JADX INFO: Access modifiers changed from: private */
    public static void setProxy() {
    }

    public static void readProxyConfig() {
        new Thread(new Runnable() { // from class: com.dingtalk.bifrost.BifrostObject.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BifrostObject.setProxy();
                } catch (Throwable th) {
                    BifrostLogCatUtil.warn(BifrostObject.TAG, "setProxy error, " + th.toString());
                }
            }
        }).start();
    }

    private static final void setProxy(String str, int i) {
        if (str != null && !str.isEmpty() && i > 0) {
            try {
                System.setProperty("http.proxyHost", str);
                System.setProperty("http.proxyPort", "" + i);
                System.setProperty("bifrost.proxyHost", str);
                System.setProperty("bifrost.proxyPort", "" + i);
            } catch (Throwable unused) {
            }
        }
    }

    private static String getProxyConfigPrefix() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return "";
        }
        File[] listFiles = externalStorageDirectory.getParentFile().listFiles();
        if (listFiles == null) {
            return externalStorageDirectory.getAbsolutePath();
        }
        for (File file : listFiles) {
            if (file.getAbsoluteFile().equals(externalStorageDirectory.getAbsoluteFile())) {
                return file.getAbsolutePath();
            }
            if (file.getAbsolutePath().contains("sdcard")) {
                return file.getAbsolutePath();
            }
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String readFile(java.lang.String r6) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            boolean r6 = r0.exists()
            java.lang.String r1 = ""
            if (r6 != 0) goto Le
            return r1
        Le:
            r6 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L44
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L44
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L44
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L44
            java.lang.String r4 = "UTF-8"
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L44
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L44
        L20:
            java.lang.String r6 = r0.readLine()     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L55
            if (r6 == 0) goto L36
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L55
            r2.<init>()     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L55
            r2.append(r1)     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L55
            r2.append(r6)     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L55
            java.lang.String r1 = r2.toString()     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L55
            goto L20
        L36:
            r0.close()     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L55
        L39:
            r0.close()     // Catch: java.io.IOException -> L54
            goto L54
        L3d:
            r6 = move-exception
            goto L48
        L3f:
            r0 = move-exception
            r5 = r0
            r0 = r6
            r6 = r5
            goto L56
        L44:
            r0 = move-exception
            r5 = r0
            r0 = r6
            r6 = r5
        L48:
            java.lang.String r2 = "BifrostObject"
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L55
            com.dingtalk.mobile.common.transport.utils.BifrostLogCatUtil.error(r2, r6)     // Catch: java.lang.Throwable -> L55
            if (r0 == 0) goto L54
            goto L39
        L54:
            return r1
        L55:
            r6 = move-exception
        L56:
            if (r0 == 0) goto L5b
            r0.close()     // Catch: java.io.IOException -> L5b
        L5b:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dingtalk.bifrost.BifrostObject.readFile(java.lang.String):java.lang.String");
    }
}
