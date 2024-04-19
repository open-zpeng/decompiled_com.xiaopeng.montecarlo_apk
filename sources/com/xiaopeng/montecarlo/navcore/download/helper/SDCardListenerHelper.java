package com.xiaopeng.montecarlo.navcore.download.helper;

import android.os.FileObserver;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.regex.Pattern;
import org.apache.commons.compress.archivers.zip.UnixStat;
/* loaded from: classes2.dex */
public class SDCardListenerHelper extends FileObserver {
    private static final long INTERVAL_TIME = 20000;
    private static final L.Tag TAG = new L.Tag("SDCardListenerHelper");
    private long mLastInitTime;
    private Pattern mPattern;

    public SDCardListenerHelper(String str) {
        super(str);
        this.mPattern = Pattern.compile("a[0-9]+\\b");
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (str != null && (i & UnixStat.PERM_MASK) == 512) {
            L.Tag tag = TAG;
            L.i(tag, "DELETE " + str);
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.mPattern.matcher(str).matches() || currentTimeMillis - this.mLastInitTime <= 20000) {
                return;
            }
            L.i(TAG, "force init");
            this.mLastInitTime = currentTimeMillis;
        }
    }
}
