package com.alibaba.sdk.android.httpdns.probe;

import androidx.annotation.NonNull;
import com.alibaba.sdk.android.httpdns.i;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
class g implements Runnable {
    private ConcurrentHashMap<String, Long> a;

    /* renamed from: a  reason: collision with other field name */
    private CountDownLatch f108a;
    private String k;
    private int port;

    public g(@NonNull String str, int i, CountDownLatch countDownLatch, ConcurrentHashMap<String, Long> concurrentHashMap) {
        this.f108a = null;
        this.k = str;
        this.port = i;
        this.f108a = countDownLatch;
        this.a = concurrentHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long a(java.lang.String r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "socket close failed:"
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
            r5 = 0
            java.net.Socket r6 = new java.net.Socket     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            r6.<init>()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.net.InetSocketAddress r5 = new java.net.InetSocketAddress     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3d
            r5.<init>(r8, r9)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3d
            r8 = 5000(0x1388, float:7.006E-42)
            r6.connect(r5, r8)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3d
            long r8 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3d
            r6.close()     // Catch: java.io.IOException -> L22
            goto L79
        L22:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            java.lang.String r0 = r5.toString()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            com.alibaba.sdk.android.httpdns.i.f(r0)
            goto L79
        L3a:
            r8 = move-exception
            r5 = r6
            goto L80
        L3d:
            r8 = move-exception
            r5 = r6
            goto L43
        L40:
            r8 = move-exception
            goto L80
        L42:
            r8 = move-exception
        L43:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40
            r9.<init>()     // Catch: java.lang.Throwable -> L40
            java.lang.String r6 = "connect failed:"
            r9.append(r6)     // Catch: java.lang.Throwable -> L40
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L40
            r9.append(r8)     // Catch: java.lang.Throwable -> L40
            java.lang.String r8 = r9.toString()     // Catch: java.lang.Throwable -> L40
            com.alibaba.sdk.android.httpdns.i.f(r8)     // Catch: java.lang.Throwable -> L40
            if (r5 == 0) goto L78
            r5.close()     // Catch: java.io.IOException -> L61
            goto L78
        L61:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r0)
            java.lang.String r8 = r8.toString()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.alibaba.sdk.android.httpdns.i.f(r8)
        L78:
            r8 = r3
        L79:
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 != 0) goto L7e
            return r3
        L7e:
            long r8 = r8 - r1
            return r8
        L80:
            if (r5 == 0) goto L9d
            r5.close()     // Catch: java.io.IOException -> L86
            goto L9d
        L86:
            r9 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r9 = r9.toString()
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.alibaba.sdk.android.httpdns.i.f(r9)
        L9d:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.probe.g.a(java.lang.String, int):long");
    }

    private boolean a(int i) {
        return i >= 1 && i <= 65535;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.k == null || !a(this.port)) {
            i.f("invalid params, give up");
        } else {
            long a = a(this.k, this.port);
            i.d("connect cost for ip:" + this.k + " is " + a);
            ConcurrentHashMap<String, Long> concurrentHashMap = this.a;
            if (concurrentHashMap != null) {
                concurrentHashMap.put(this.k, Long.valueOf(a));
            }
        }
        CountDownLatch countDownLatch = this.f108a;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }
}
