package com.autonavi.common.tool.http;

import android.text.TextUtils;
import com.autonavi.common.tool.util.LogUtil;
import java.io.File;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes.dex */
public class HttpEngine {
    private static String HTTPS = "https";

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public void postFileInBody(java.lang.String r8, java.io.File r9, com.autonavi.common.tool.http.HttpCallback r10) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.common.tool.http.HttpEngine.postFileInBody(java.lang.String, java.io.File, com.autonavi.common.tool.http.HttpCallback):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public void restPostFileInBody(java.lang.String r7, long r8, java.lang.String r10, java.lang.String r11, java.io.File r12, com.autonavi.common.tool.http.HttpCallback r13) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.common.tool.http.HttpEngine.restPostFileInBody(java.lang.String, long, java.lang.String, java.lang.String, java.io.File, com.autonavi.common.tool.http.HttpCallback):void");
    }

    private X509TrustManager getSystemDefaultTrustManager() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            LogUtil.logE("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            return null;
        } catch (GeneralSecurityException e) {
            LogUtil.logE("Unexpected exception" + e.getMessage());
            return null;
        }
    }

    public void postFileInParam(String str, File file, HttpCallback httpCallback) {
        HttpURLConnection httpURLConnection;
        if (TextUtils.isEmpty(str) || file == null || !file.exists()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("file", file));
        MultipartEntity multipartEntity = new MultipartEntity(arrayList, "UTF-8");
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            } catch (Throwable th) {
                th = th;
            }
            try {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", multipartEntity.getContentType());
                OutputStream outputStream = httpURLConnection.getOutputStream();
                multipartEntity.writeTo(outputStream);
                outputStream.close();
                if (httpCallback != null) {
                    httpCallback.onFinish(httpURLConnection);
                }
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection2 = httpURLConnection;
                if (httpCallback != null) {
                    try {
                        httpCallback.onError(th);
                    } catch (Throwable th3) {
                        HttpURLConnection httpURLConnection3 = httpURLConnection2;
                        if (httpURLConnection3 != null) {
                            try {
                                httpURLConnection3.disconnect();
                            } catch (Throwable unused) {
                            }
                        }
                        throw th3;
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return;
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable unused2) {
        }
    }
}
