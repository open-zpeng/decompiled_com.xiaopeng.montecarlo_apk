package com.alibaba.sdk.android.man.crashreporter.d;

import android.content.Context;
import com.alibaba.sdk.android.man.crashreporter.global.BaseDataContent;
import java.io.File;
/* loaded from: classes.dex */
public class a extends b {
    private final Context a;
    private com.alibaba.sdk.android.man.crashreporter.c environment;
    private final String TOMBSTONE_PATH = "tombstone";
    private final String FILENAME = com.alibaba.sdk.android.man.crashreporter.handler.c.a.MODULE;
    private final String t = ".base";

    public a(Context context, com.alibaba.sdk.android.man.crashreporter.c cVar) {
        this.environment = null;
        this.a = context;
        this.environment = cVar;
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.d.b, com.alibaba.sdk.android.man.crashreporter.d.c
    public String h() {
        try {
            BaseDataContent a = a();
            return (a == null || a.userNick == null) ? "" : a.userNick;
        } catch (Exception e) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("get local user nick err!", e);
            return "";
        }
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.d.b, com.alibaba.sdk.android.man.crashreporter.d.c
    public void a(BaseDataContent baseDataContent) {
        if (baseDataContent == null) {
            com.alibaba.sdk.android.man.crashreporter.b.a.g("base data object is null!");
            return;
        }
        File dir = this.a.getDir("tombstone", 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        if (dir.canWrite()) {
            try {
                com.alibaba.sdk.android.man.crashreporter.d.a.a.a(baseDataContent, new File(String.format("%s/%s%s", dir, com.alibaba.sdk.android.man.crashreporter.handler.c.a.MODULE, ".base")));
                com.alibaba.sdk.android.man.crashreporter.b.a.e("base data succ");
            } catch (Exception e) {
                com.alibaba.sdk.android.man.crashreporter.b.a.d("base data write error.", e);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
        if (r2 != null) goto L19;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0075: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:34:0x0075 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0078  */
    @Override // com.alibaba.sdk.android.man.crashreporter.d.b, com.alibaba.sdk.android.man.crashreporter.d.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.alibaba.sdk.android.man.crashreporter.global.BaseDataContent a() {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            android.content.Context r2 = r6.a     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.FileNotFoundException -> L62
            java.lang.String r3 = "tombstone"
            android.content.Context r4 = r6.a     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.FileNotFoundException -> L62
            java.io.File r2 = r2.getDir(r3, r0)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.FileNotFoundException -> L62
            java.lang.String r3 = "%s/%s%s"
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.FileNotFoundException -> L62
            java.lang.String r2 = r2.getPath()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.FileNotFoundException -> L62
            r4[r0] = r2     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.FileNotFoundException -> L62
            r2 = 1
            java.lang.String r5 = "crashreporter"
            r4[r2] = r5     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.FileNotFoundException -> L62
            r2 = 2
            java.lang.String r5 = ".base"
            r4[r2] = r5     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.FileNotFoundException -> L62
            java.lang.String r2 = java.lang.String.format(r3, r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.FileNotFoundException -> L62
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.FileNotFoundException -> L62
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.FileNotFoundException -> L62
            boolean r2 = r3.exists()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.FileNotFoundException -> L62
            if (r2 == 0) goto L4e
            boolean r2 = r3.isFile()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.FileNotFoundException -> L62
            if (r2 == 0) goto L4e
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.FileNotFoundException -> L62
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.FileNotFoundException -> L62
            java.lang.Object r3 = com.alibaba.sdk.android.man.crashreporter.d.a.a.a(r2)     // Catch: java.lang.Exception -> L4c java.io.FileNotFoundException -> L63 java.lang.Throwable -> L74
            if (r3 == 0) goto L4f
            boolean r4 = r3 instanceof com.alibaba.sdk.android.man.crashreporter.global.BaseDataContent     // Catch: java.lang.Exception -> L4c java.io.FileNotFoundException -> L63 java.lang.Throwable -> L74
            if (r4 == 0) goto L4f
            com.alibaba.sdk.android.man.crashreporter.global.BaseDataContent r3 = (com.alibaba.sdk.android.man.crashreporter.global.BaseDataContent) r3     // Catch: java.lang.Exception -> L4c java.io.FileNotFoundException -> L63 java.lang.Throwable -> L74
            com.alibaba.sdk.android.man.crashreporter.e.f.a(r2)
            return r3
        L4c:
            r0 = move-exception
            goto L59
        L4e:
            r2 = r1
        L4f:
            if (r2 == 0) goto L61
        L51:
            com.alibaba.sdk.android.man.crashreporter.e.f.a(r2)
            goto L61
        L55:
            r0 = move-exception
            goto L76
        L57:
            r0 = move-exception
            r2 = r1
        L59:
            java.lang.String r3 = "read base data file error."
            com.alibaba.sdk.android.man.crashreporter.b.a.d(r3, r0)     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L61
            goto L51
        L61:
            return r1
        L62:
            r2 = r1
        L63:
            java.lang.String r3 = "Trying to load crash report but base data not found."
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L74
            java.lang.String r0 = java.lang.String.format(r3, r0)     // Catch: java.lang.Throwable -> L74
            com.alibaba.sdk.android.man.crashreporter.b.a.h(r0)     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L73
            com.alibaba.sdk.android.man.crashreporter.e.f.a(r2)
        L73:
            return r1
        L74:
            r0 = move-exception
            r1 = r2
        L76:
            if (r1 == 0) goto L7b
            com.alibaba.sdk.android.man.crashreporter.e.f.a(r1)
        L7b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.man.crashreporter.d.a.a():com.alibaba.sdk.android.man.crashreporter.global.BaseDataContent");
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.d.b, com.alibaba.sdk.android.man.crashreporter.d.c
    public void b(boolean z) {
        BaseDataContent a;
        if (!z || (a = a()) == null) {
            return;
        }
        a.hashCode = null;
        a.path = null;
        a.times = 0;
        a(a);
    }
}
