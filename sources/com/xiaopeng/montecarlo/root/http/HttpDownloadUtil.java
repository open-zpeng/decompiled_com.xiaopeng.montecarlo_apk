package com.xiaopeng.montecarlo.root.http;

import com.xiaopeng.montecarlo.root.util.L;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes3.dex */
public class HttpDownloadUtil {
    private static final L.Tag TAG = new L.Tag("HttpDownloadUtil");

    /* JADX WARN: Removed duplicated region for block: B:69:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean downloadFromUrl(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.root.http.HttpDownloadUtil.downloadFromUrl(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public static boolean saveUrlAs(String str, String str2, String str3) {
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.connect();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2 + File.separator + str3));
            byte[] bArr = new byte[4096];
            for (int read = bufferedInputStream.read(bArr); read != -1; read = bufferedInputStream.read(bArr)) {
                bufferedOutputStream.write(bArr, 0, read);
            }
            bufferedOutputStream.close();
            bufferedInputStream.close();
            httpURLConnection.disconnect();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("抛出异常！！");
            return false;
        }
    }
}
