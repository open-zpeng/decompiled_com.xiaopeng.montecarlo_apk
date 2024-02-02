package com.xiaopeng.montecarlo.navcore.speech.voicefusion;

import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
/* loaded from: classes2.dex */
public class SystemUIValueContentObserver extends ContentObserver {
    public static final String KEY_INFOFLOW_CARD_HEIGHT = "infoflow_card_height";
    private static final L.Tag TAG = new L.Tag("SysUIValConObserver");
    private Handler mHandler;
    private int mOldHeight;

    public SystemUIValueContentObserver(Handler handler) {
        super(handler);
        this.mOldHeight = 0;
        this.mHandler = handler;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        try {
            int i = Settings.System.getInt(ContextUtils.getContext().getContentResolver(), KEY_INFOFLOW_CARD_HEIGHT);
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "onChange infoflow card height:" + i + ",old height:" + this.mOldHeight);
            }
            if (i == this.mOldHeight || i <= 0) {
                return;
            }
            this.mOldHeight = i;
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.speech.voicefusion.SystemUIValueContentObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    VoiceFusionUtil.getInstance().onInfoflowCardHeightChanged(SystemUIValueContentObserver.this.mOldHeight);
                }
            });
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
    }
}
