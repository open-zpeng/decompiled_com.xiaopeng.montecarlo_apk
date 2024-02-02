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
public class RoutePreferenceViewHolder_ViewBinding implements Unbinder {
    private RoutePreferenceViewHolder target;

    @UiThread
    public RoutePreferenceViewHolder_ViewBinding(RoutePreferenceViewHolder routePreferenceViewHolder, View view) {
        this.target = routePreferenceViewHolder;
        routePreferenceViewHolder.mSettingRouteTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.setting_route_title, "field 'mSettingRouteTitle'", XTextView.class);
        routePreferenceViewHolder.mSettingRouteAvoidCongestionBtn = (XToggleButton) Utils.findRequiredViewAsType(view, R.id.setting_route_avoid_congestion_btn, "field 'mSettingRouteAvoidCongestionBtn'", XToggleButton.class);
        routePreferenceViewHolder.mSettingRouteAvoidChargeBtn = (XToggleButton) Utils.findRequiredViewAsType(view, R.id.setting_route_avoid_charge_btn, "field 'mSettingRouteAvoidChargeBtn'", XToggleButton.class);
        routePreferenceViewHolder.mSettingRouteNoFreewaysBtn = (XToggleButton) Utils.findRequiredViewAsType(view, R.id.setting_route_no_freeways_btn, "field 'mSettingRouteNoFreewaysBtn'", XToggleButton.class);
        routePreferenceViewHolder.mSettingRouteHighwayPriorityBtn = (XToggleButton) Utils.findRequiredViewAsType(view, R.id.setting_route_highway_priority_btn, "field 'mSettingRouteHighwayPriorityBtn'", XToggleButton.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RoutePreferenceViewHolder routePreferenceViewHolder = this.target;
        if (routePreferenceViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        routePreferenceViewHolder.mSettingRouteTitle = null;
        routePreferenceViewHolder.mSettingRouteAvoidCongestionBtn = null;
        routePreferenceViewHolder.mSettingRouteAvoidChargeBtn = null;
        routePreferenceViewHolder.mSettingRouteNoFreewaysBtn = null;
        routePreferenceViewHolder.mSettingRouteHighwayPriorityBtn = null;
    }
}
