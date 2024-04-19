package com.xiaopeng.montecarlo.scenes.navi.explorescene;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.views.LaneInfoView;
import com.xiaopeng.montecarlo.views.RouteDetailPanel;
import com.xiaopeng.montecarlo.views.road.CurrentRoadNameView;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class ExploreFragment_ViewBinding implements Unbinder {
    private ExploreFragment target;

    @UiThread
    public ExploreFragment_ViewBinding(ExploreFragment exploreFragment, View view) {
        this.target = exploreFragment;
        exploreFragment.mRoutePanel = (RouteDetailPanel) Utils.findRequiredViewAsType(view, R.id.route_panel, "field 'mRoutePanel'", RouteDetailPanel.class);
        exploreFragment.mRoutDetailContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.route_view_container, "field 'mRoutDetailContainer'", XLinearLayout.class);
        exploreFragment.mTvCurrentRoad = (CurrentRoadNameView) Utils.findRequiredViewAsType(view, R.id.explore_curroad_name, "field 'mTvCurrentRoad'", CurrentRoadNameView.class);
        exploreFragment.mRouteChargeStub = (ViewStub) Utils.findRequiredViewAsType(view, R.id.route_charge_panel_stub, "field 'mRouteChargeStub'", ViewStub.class);
        exploreFragment.mLanesLayout = (LaneInfoView) Utils.findOptionalViewAsType(view, R.id.explore_lanes_layout, "field 'mLanesLayout'", LaneInfoView.class);
        exploreFragment.mTurnInfoLayout = (RelativeLayout) Utils.findOptionalViewAsType(view, R.id.layout_turn_info, "field 'mTurnInfoLayout'", RelativeLayout.class);
        exploreFragment.mTurnIcon = (XImageView) Utils.findOptionalViewAsType(view, R.id.iv_navi_info_turn, "field 'mTurnIcon'", XImageView.class);
        exploreFragment.mDistanceToTurn = (XTextView) Utils.findOptionalViewAsType(view, R.id.tv_navi_info_turn_distance, "field 'mDistanceToTurn'", XTextView.class);
        exploreFragment.mDistanceToTurnUnit = (XTextView) Utils.findOptionalViewAsType(view, R.id.tv_navi_info_turn_distance_unit, "field 'mDistanceToTurnUnit'", XTextView.class);
        exploreFragment.mTvRoadName = (XTextView) Utils.findOptionalViewAsType(view, R.id.tv_navi_info_turn_road_name, "field 'mTvRoadName'", XTextView.class);
        exploreFragment.mIvEndShadow = (XImageView) Utils.findOptionalViewAsType(view, R.id.iv_end_shadow, "field 'mIvEndShadow'", XImageView.class);
        exploreFragment.mCameraSimpleViewStub = (ViewStub) Utils.findOptionalViewAsType(view, R.id.view_camera_simple_stub, "field 'mCameraSimpleViewStub'", ViewStub.class);
        exploreFragment.mIntervalCameraViewStub = (ViewStub) Utils.findOptionalViewAsType(view, R.id.interval_camera_container_stub, "field 'mIntervalCameraViewStub'", ViewStub.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ExploreFragment exploreFragment = this.target;
        if (exploreFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        exploreFragment.mRoutePanel = null;
        exploreFragment.mRoutDetailContainer = null;
        exploreFragment.mTvCurrentRoad = null;
        exploreFragment.mRouteChargeStub = null;
        exploreFragment.mLanesLayout = null;
        exploreFragment.mTurnInfoLayout = null;
        exploreFragment.mTurnIcon = null;
        exploreFragment.mDistanceToTurn = null;
        exploreFragment.mDistanceToTurnUnit = null;
        exploreFragment.mTvRoadName = null;
        exploreFragment.mIvEndShadow = null;
        exploreFragment.mCameraSimpleViewStub = null;
        exploreFragment.mIntervalCameraViewStub = null;
    }
}
