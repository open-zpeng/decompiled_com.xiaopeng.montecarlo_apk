package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import android.widget.CompoundButton;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.xui.widget.XSwitch;
/* loaded from: classes3.dex */
public class ChargingStationViewHolder_ViewBinding implements Unbinder {
    private ChargingStationViewHolder target;
    private View view7f0903de;

    @UiThread
    public ChargingStationViewHolder_ViewBinding(final ChargingStationViewHolder chargingStationViewHolder, View view) {
        this.target = chargingStationViewHolder;
        View findRequiredView = Utils.findRequiredView(view, R.id.setting_charging_station_show_switch_btn, "field 'mChargingStationShowSwitchBtn' and method 'onCheckedChanged'");
        chargingStationViewHolder.mChargingStationShowSwitchBtn = (XSwitch) Utils.castView(findRequiredView, R.id.setting_charging_station_show_switch_btn, "field 'mChargingStationShowSwitchBtn'", XSwitch.class);
        this.view7f0903de = findRequiredView;
        ((CompoundButton) findRequiredView).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.ChargingStationViewHolder_ViewBinding.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                chargingStationViewHolder.onCheckedChanged((XSwitch) Utils.castParam(compoundButton, "onCheckedChanged", 0, "onCheckedChanged", 0, XSwitch.class));
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChargingStationViewHolder chargingStationViewHolder = this.target;
        if (chargingStationViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        chargingStationViewHolder.mChargingStationShowSwitchBtn = null;
        ((CompoundButton) this.view7f0903de).setOnCheckedChangeListener(null);
        this.view7f0903de = null;
    }
}
