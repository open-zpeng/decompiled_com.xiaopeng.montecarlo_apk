package com.alibaba.sdk.android.httpdns;
/* loaded from: classes.dex */
public class s {
    private static s a;
    private long g = 0;
    private boolean f = true;
    private String hostName = null;

    private s() {
    }

    public static s a() {
        if (a == null) {
            synchronized (s.class) {
                if (a == null) {
                    a = new s();
                }
            }
        }
        return a;
    }

    private void a(String str, String str2) {
        com.alibaba.sdk.android.httpdns.d.a a2 = com.alibaba.sdk.android.httpdns.d.a.a();
        if (a2 != null) {
            a2.a(str, t.a(o.SNIFF_HOST), str2);
        }
    }

    private boolean d() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.g;
        if (j == 0 || currentTimeMillis - j >= 30000) {
            this.g = currentTimeMillis;
            return true;
        }
        return false;
    }

    public synchronized void b(boolean z) {
        this.f = z;
    }

    public synchronized void e() {
        this.g = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0028 A[Catch: all -> 0x0062, TryCatch #0 {, blocks: (B:4:0x0003, B:5:0x0005, B:17:0x0028, B:18:0x004c, B:9:0x0011, B:12:0x001a), top: B:24:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c A[Catch: all -> 0x0062, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:5:0x0005, B:17:0x0028, B:18:0x004c, B:9:0x0011, B:12:0x001a), top: B:24:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void g(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            if (r6 == 0) goto L5
            r5.hostName = r6     // Catch: java.lang.Throwable -> L62
        L5:
            r0 = 1
            boolean r1 = r5.f     // Catch: java.lang.Throwable -> L62
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L11
            java.lang.String r0 = "sniffer is turned off"
        Le:
            r1 = r0
            r0 = r3
            goto L26
        L11:
            boolean r1 = r5.d()     // Catch: java.lang.Throwable -> L62
            if (r1 != 0) goto L1a
            java.lang.String r0 = "sniff too often"
            goto Le
        L1a:
            java.lang.String r1 = r5.hostName     // Catch: java.lang.Throwable -> L62
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L62
            if (r1 == 0) goto L25
            java.lang.String r0 = "hostname is null"
            goto Le
        L25:
            r1 = r2
        L26:
            if (r0 == 0) goto L4c
            java.lang.String r0 = "launch a sniff task"
            com.alibaba.sdk.android.httpdns.i.d(r0)     // Catch: java.lang.Throwable -> L62
            com.alibaba.sdk.android.httpdns.m r0 = new com.alibaba.sdk.android.httpdns.m     // Catch: java.lang.Throwable -> L62
            java.lang.String r1 = r5.hostName     // Catch: java.lang.Throwable -> L62
            com.alibaba.sdk.android.httpdns.o r4 = com.alibaba.sdk.android.httpdns.o.SNIFF_HOST     // Catch: java.lang.Throwable -> L62
            r0.<init>(r1, r4)     // Catch: java.lang.Throwable -> L62
            r0.a(r3)     // Catch: java.lang.Throwable -> L62
            java.util.concurrent.ExecutorService r1 = com.alibaba.sdk.android.httpdns.c.a()     // Catch: java.lang.Throwable -> L62
            r1.submit(r0)     // Catch: java.lang.Throwable -> L62
            com.alibaba.sdk.android.httpdns.o r0 = com.alibaba.sdk.android.httpdns.o.SNIFF_HOST     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = com.alibaba.sdk.android.httpdns.t.a(r0)     // Catch: java.lang.Throwable -> L62
            r5.a(r6, r0)     // Catch: java.lang.Throwable -> L62
            r5.hostName = r2     // Catch: java.lang.Throwable -> L62
            goto L60
        L4c:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r6.<init>()     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = "launch sniffer failed due to "
            r6.append(r0)     // Catch: java.lang.Throwable -> L62
            r6.append(r1)     // Catch: java.lang.Throwable -> L62
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L62
            com.alibaba.sdk.android.httpdns.i.d(r6)     // Catch: java.lang.Throwable -> L62
        L60:
            monitor-exit(r5)
            return
        L62:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.s.g(java.lang.String):void");
    }
}
