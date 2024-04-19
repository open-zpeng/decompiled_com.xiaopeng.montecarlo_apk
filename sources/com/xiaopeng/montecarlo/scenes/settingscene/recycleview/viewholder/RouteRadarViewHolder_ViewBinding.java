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
public class RouteRadarViewHolder_ViewBinding implements Unbinder {
    private RouteRadarViewHolder target;
    private View view7f090442;

    @UiThread
    public RouteRadarViewHolder_ViewBinding(final RouteRadarViewHolder routeRadarViewHolder, View view) {
        this.target = routeRadarViewHolder;
        View findRequiredView = Utils.findRequiredView(view, R.id.setting_route_radar_switch_btn, "field 'mRouteRaderSwitchBtn' and method 'onCheckedChanged'");
        routeRadarViewHolder.mRouteRaderSwitchBtn = (XSwitch) Utils.castView(findRequiredView, R.id.setting_route_radar_switch_btn, "field 'mRouteRaderSwitchBtn'", XSwitch.class);
        this.view7f090442 = findRequiredView;
        ((CompoundButton) findRequiredView).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.RouteRadarViewHolder_ViewBinding.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                routeRadarViewHolder.onCheckedChanged((XSwitch) Utils.castParam(compoundButton, "onCheckedChanged", 0, "onCheckedChanged", 0, XSwitch.class));
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RouteRadarViewHolder routeRadarViewHolder = this.target;
        if (routeRadarViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        routeRadarViewHolder.mRouteRaderSwitchBtn = null;
        ((CompoundButton) this.view7f090442).setOnCheckedChangeListener(null);
        this.view7f090442 = null;
    }
}
