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
public class RealTimeTrafficViewHolder_ViewBinding implements Unbinder {
    private RealTimeTrafficViewHolder target;
    private View view7f090419;

    @UiThread
    public RealTimeTrafficViewHolder_ViewBinding(final RealTimeTrafficViewHolder realTimeTrafficViewHolder, View view) {
        this.target = realTimeTrafficViewHolder;
        View findRequiredView = Utils.findRequiredView(view, R.id.setting_real_time_traffic_switch_btn, "field 'mRealTimeTrafficSwitchBtn' and method 'onCheckedChanged'");
        realTimeTrafficViewHolder.mRealTimeTrafficSwitchBtn = (XSwitch) Utils.castView(findRequiredView, R.id.setting_real_time_traffic_switch_btn, "field 'mRealTimeTrafficSwitchBtn'", XSwitch.class);
        this.view7f090419 = findRequiredView;
        ((CompoundButton) findRequiredView).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.RealTimeTrafficViewHolder_ViewBinding.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                realTimeTrafficViewHolder.onCheckedChanged((XSwitch) Utils.castParam(compoundButton, "onCheckedChanged", 0, "onCheckedChanged", 0, XSwitch.class));
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RealTimeTrafficViewHolder realTimeTrafficViewHolder = this.target;
        if (realTimeTrafficViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        realTimeTrafficViewHolder.mRealTimeTrafficSwitchBtn = null;
        ((CompoundButton) this.view7f090419).setOnCheckedChangeListener(null);
        this.view7f090419 = null;
    }
}
