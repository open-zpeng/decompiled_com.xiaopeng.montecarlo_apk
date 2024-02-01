package com.alibaba.sdk.android.man.crashreporter.handler.b;

import android.content.Context;
import com.alibaba.sdk.android.man.crashreporter.handler.b.b;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private AtomicBoolean crashing;
    private AtomicBoolean a = new AtomicBoolean(false);
    private Timer timer = new Timer();

    public a(final Context context, final com.alibaba.sdk.android.man.crashreporter.handler.a aVar, AtomicBoolean atomicBoolean, final int i, final boolean z) {
        this.crashing = atomicBoolean;
        this.timer.schedule(new TimerTask() { // from class: com.alibaba.sdk.android.man.crashreporter.handler.b.a.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b bVar = new b(i);
                if (z) {
                    bVar.a();
                }
                bVar.a(new b.a() { // from class: com.alibaba.sdk.android.man.crashreporter.handler.b.a.1.1
                    @Override // com.alibaba.sdk.android.man.crashreporter.handler.b.b.a
                    public void a(String str, int i2) {
                        if (a.this.a.compareAndSet(false, true)) {
                            com.alibaba.sdk.android.man.crashreporter.handler.c.a.d("crash_anr");
                        }
                        String m60b = com.alibaba.sdk.android.man.crashreporter.a.c.a.m60b(context);
                        if (m60b == null) {
                            m60b = "-";
                        }
                        com.alibaba.sdk.android.man.crashreporter.handler.c.a.a(m60b, "crash_anr", str, i2);
                    }

                    @Override // com.alibaba.sdk.android.man.crashreporter.handler.b.b.a
                    public void c(String str) {
                        try {
                            if (aVar != null) {
                                aVar.m70b(str);
                            } else {
                                com.alibaba.sdk.android.man.crashreporter.b.a.e("stuck: crash manager is null!");
                            }
                        } finally {
                            try {
                            } finally {
                            }
                        }
                    }
                }).start();
            }
        }, SRNaviManager.SR_DATA_INTERVAL_LEVEL1);
    }

    public void c() {
        this.timer.cancel();
    }
}
