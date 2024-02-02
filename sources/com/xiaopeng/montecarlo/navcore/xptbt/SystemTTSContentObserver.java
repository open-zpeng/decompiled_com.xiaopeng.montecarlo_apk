package com.xiaopeng.montecarlo.navcore.xptbt;

import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
/* loaded from: classes2.dex */
public class SystemTTSContentObserver extends ContentObserver {
    public static final String KEY_NGP_BROADCAST_TYPE = "ngp_broadcast_type";
    private static final L.Tag TAG = new L.Tag("SystemTTSContentObserver");

    public SystemTTSContentObserver(Handler handler) {
        super(handler);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        final int i = Settings.System.getInt(ContextUtils.getContext().getContentResolver(), KEY_NGP_BROADCAST_TYPE, 1);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onChange tts type:" + i);
        }
        WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.SystemTTSContentObserver.1
            @Override // java.lang.Runnable
            public void run() {
                TTSManager.getInstance().onNgpBroadCastTypeChanged(i);
            }
        });
    }
}
