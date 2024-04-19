package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.os.SystemClock;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.SettingPreferenceAdapterView;
import com.xiaopeng.xui.widget.XSwitch;
/* loaded from: classes3.dex */
public abstract class BaseSettingViewHolder extends RecyclerView.ViewHolder {
    private static final long MULTI_CLICK_INTERVAL = 500;
    SettingPreferenceAdapterView mAdapter;
    private long mLastClickTime;

    public XSwitch getXSwitch() {
        return null;
    }

    public abstract void refreshViewFromData();

    public BaseSettingViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view);
        this.mAdapter = settingPreferenceAdapterView;
    }

    public final boolean preventMultiClick(View view) {
        boolean z = SystemClock.elapsedRealtime() - this.mLastClickTime >= MULTI_CLICK_INTERVAL;
        this.mLastClickTime = SystemClock.elapsedRealtime();
        return z;
    }
}
