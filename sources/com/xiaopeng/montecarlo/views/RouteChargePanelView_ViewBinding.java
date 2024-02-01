package com.xiaopeng.montecarlo.views;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class RouteChargePanelView_ViewBinding implements Unbinder {
    private RouteChargePanelView target;
    private View view7f090353;

    @UiThread
    public RouteChargePanelView_ViewBinding(RouteChargePanelView routeChargePanelView) {
        this(routeChargePanelView, routeChargePanelView);
    }

    @UiThread
    public RouteChargePanelView_ViewBinding(final RouteChargePanelView routeChargePanelView, View view) {
        this.target = routeChargePanelView;
        routeChargePanelView.mTitleTipsView = (XTextView) Utils.findRequiredViewAsType(view, R.id.route_charge_title_tips, "field 'mTitleTipsView'", XTextView.class);
        routeChargePanelView.mArrivalEstiView = (XTextView) Utils.findRequiredViewAsType(view, R.id.route_charge_arrival_estimation, "field 'mArrivalEstiView'", XTextView.class);
        routeChargePanelView.mNextChargeDistanceView = (XTextView) Utils.findRequiredViewAsType(view, R.id.route_charge_next_distance, "field 'mNextChargeDistanceView'", XTextView.class);
        routeChargePanelView.mBatteryView = (BatteryView) Utils.findRequiredViewAsType(view, R.id.route_charge_battery, "field 'mBatteryView'", BatteryView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.route_charge_add_remove, "field 'mChargeAddView' and method 'onAddRouteCharge'");
        routeChargePanelView.mChargeAddView = (ImageTextButton) Utils.castView(findRequiredView, R.id.route_charge_add_remove, "field 'mChargeAddView'", ImageTextButton.class);
        this.view7f090353 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.views.RouteChargePanelView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                routeChargePanelView.onAddRouteCharge(view2);
            }
        });
        routeChargePanelView.mDetailContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.route_charge_detail_container, "field 'mDetailContainer'", ViewGroup.class);
        routeChargePanelView.mNameTextView = (XTextView) Utils.findRequiredViewAsType(view, R.id.route_charge_name, "field 'mNameTextView'", XTextView.class);
        routeChargePanelView.mNavDistanceView = (XTextView) Utils.findRequiredViewAsType(view, R.id.route_charge_nav_distance, "field 'mNavDistanceView'", XTextView.class);
        routeChargePanelView.mRoot = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.route_charge_root, "field 'mRoot'", XLinearLayout.class);
        routeChargePanelView.mDivider = (XImageView) Utils.findRequiredViewAsType(view, R.id.route_charge_divider, "field 'mDivider'", XImageView.class);
        routeChargePanelView.mRouteChargeMsgView = (XTextView) Utils.findRequiredViewAsType(view, R.id.route_charge_msg_view, "field 'mRouteChargeMsgView'", XTextView.class);
        routeChargePanelView.mRouteChargeBarContainer = (XRelativeLayout) Utils.findRequiredViewAsType(view, R.id.route_charge_bar_container, "field 'mRouteChargeBarContainer'", XRelativeLayout.class);
        routeChargePanelView.mRouteChargeBar = (ChargeRouteView) Utils.findRequiredViewAsType(view, R.id.route_charge_bar, "field 'mRouteChargeBar'", ChargeRouteView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RouteChargePanelView routeChargePanelView = this.target;
        if (routeChargePanelView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        routeChargePanelView.mTitleTipsView = null;
        routeChargePanelView.mArrivalEstiView = null;
        routeChargePanelView.mNextChargeDistanceView = null;
        routeChargePanelView.mBatteryView = null;
        routeChargePanelView.mChargeAddView = null;
        routeChargePanelView.mDetailContainer = null;
        routeChargePanelView.mNameTextView = null;
        routeChargePanelView.mNavDistanceView = null;
        routeChargePanelView.mRoot = null;
        routeChargePanelView.mDivider = null;
        routeChargePanelView.mRouteChargeMsgView = null;
        routeChargePanelView.mRouteChargeBarContainer = null;
        routeChargePanelView.mRouteChargeBar = null;
        this.view7f090353.setOnClickListener(null);
        this.view7f090353 = null;
    }
}
