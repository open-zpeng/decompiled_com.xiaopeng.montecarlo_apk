package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.xui.widget.XTextView;
import com.xiaopeng.xui.widget.XToggleButton;
/* loaded from: classes3.dex */
public class CruiseBroadcastViewHolder_ViewBinding implements Unbinder {
    private CruiseBroadcastViewHolder target;

    @UiThread
    public CruiseBroadcastViewHolder_ViewBinding(CruiseBroadcastViewHolder cruiseBroadcastViewHolder, View view) {
        this.target = cruiseBroadcastViewHolder;
        cruiseBroadcastViewHolder.mSettingCruiseTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.setting_cruise_title, "field 'mSettingCruiseTitle'", XTextView.class);
        cruiseBroadcastViewHolder.mSettingCruiseAheadTrafficBtn = (XToggleButton) Utils.findRequiredViewAsType(view, R.id.setting_cruise_ahead_traffic_btn, "field 'mSettingCruiseAheadTrafficBtn'", XToggleButton.class);
        cruiseBroadcastViewHolder.mSettingCruiseSafetyBroadcastBtn = (XToggleButton) Utils.findRequiredViewAsType(view, R.id.setting_cruise_safety_broadcast_btn, "field 'mSettingCruiseSafetyBroadcastBtn'", XToggleButton.class);
        cruiseBroadcastViewHolder.mSettingCruiseElecronicEyeBroadcastBtn = (XToggleButton) Utils.findRequiredViewAsType(view, R.id.setting_cruise_electronic_eye_broadcast_btn, "field 'mSettingCruiseElecronicEyeBroadcastBtn'", XToggleButton.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CruiseBroadcastViewHolder cruiseBroadcastViewHolder = this.target;
        if (cruiseBroadcastViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        cruiseBroadcastViewHolder.mSettingCruiseTitle = null;
        cruiseBroadcastViewHolder.mSettingCruiseAheadTrafficBtn = null;
        cruiseBroadcastViewHolder.mSettingCruiseSafetyBroadcastBtn = null;
        cruiseBroadcastViewHolder.mSettingCruiseElecronicEyeBroadcastBtn = null;
    }
}
