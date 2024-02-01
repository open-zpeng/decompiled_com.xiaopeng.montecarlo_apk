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
public class AvoidLimitRouteViewHolder_ViewBinding implements Unbinder {
    private AvoidLimitRouteViewHolder target;
    private View view7f0903d5;

    @UiThread
    public AvoidLimitRouteViewHolder_ViewBinding(final AvoidLimitRouteViewHolder avoidLimitRouteViewHolder, View view) {
        this.target = avoidLimitRouteViewHolder;
        View findRequiredView = Utils.findRequiredView(view, R.id.setting_avoid_limit_route_switch_btn, "field 'mAvoidLimitRouteSwitchBtn' and method 'onCheckedChanged'");
        avoidLimitRouteViewHolder.mAvoidLimitRouteSwitchBtn = (XSwitch) Utils.castView(findRequiredView, R.id.setting_avoid_limit_route_switch_btn, "field 'mAvoidLimitRouteSwitchBtn'", XSwitch.class);
        this.view7f0903d5 = findRequiredView;
        ((CompoundButton) findRequiredView).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.AvoidLimitRouteViewHolder_ViewBinding.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                avoidLimitRouteViewHolder.onCheckedChanged((XSwitch) Utils.castParam(compoundButton, "onCheckedChanged", 0, "onCheckedChanged", 0, XSwitch.class));
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AvoidLimitRouteViewHolder avoidLimitRouteViewHolder = this.target;
        if (avoidLimitRouteViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        avoidLimitRouteViewHolder.mAvoidLimitRouteSwitchBtn = null;
        ((CompoundButton) this.view7f0903d5).setOnCheckedChangeListener(null);
        this.view7f0903d5 = null;
    }
}
