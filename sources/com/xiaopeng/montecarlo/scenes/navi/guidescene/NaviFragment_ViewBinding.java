package com.xiaopeng.montecarlo.scenes.navi.guidescene;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.views.TrafficBar;
import com.xiaopeng.montecarlo.views.XpNgpPanelView;
import com.xiaopeng.montecarlo.views.road.CurrentRoadNameView;
import com.xiaopeng.xui.widget.XFrameLayout;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRadioGroup;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes2.dex */
public class NaviFragment_ViewBinding implements Unbinder {
    private NaviFragment target;
    private View view7f0900ab;
    private View view7f0901a5;
    private View view7f09029e;

    @UiThread
    public NaviFragment_ViewBinding(final NaviFragment naviFragment, View view) {
        this.target = naviFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.btn_guide_add_waypoint, "field 'mBtnAddWaypoint' and method 'onClickAddWaypoint'");
        naviFragment.mBtnAddWaypoint = (XLinearLayout) Utils.castView(findRequiredView, R.id.btn_guide_add_waypoint, "field 'mBtnAddWaypoint'", XLinearLayout.class);
        this.view7f0900ab = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                naviFragment.onClickAddWaypoint(view2);
            }
        });
        naviFragment.mBtnAddWaypointIcon = (XImageView) Utils.findRequiredViewAsType(view, R.id.btn_guide_add_waypoint_icon, "field 'mBtnAddWaypointIcon'", XImageView.class);
        naviFragment.mBtnAddWaypointTips = (XTextView) Utils.findRequiredViewAsType(view, R.id.btn_guide_add_waypoint_text, "field 'mBtnAddWaypointTips'", XTextView.class);
        naviFragment.mSuggestSpeedCameras = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.interval_camera_container, "field 'mSuggestSpeedCameras'", XLinearLayout.class);
        naviFragment.mCrossLayout = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.guide_cross_layout, "field 'mCrossLayout'", ViewGroup.class);
        naviFragment.mImCross = (XImageView) Utils.findRequiredViewAsType(view, R.id.im_guide_cross_cross, "field 'mImCross'", XImageView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.guide_3d_to_2d, "field 'mGuideBackTo2D' and method 'onClick3DTo2D'");
        naviFragment.mGuideBackTo2D = (XFrameLayout) Utils.castView(findRequiredView2, R.id.guide_3d_to_2d, "field 'mGuideBackTo2D'", XFrameLayout.class);
        this.view7f0901a5 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                naviFragment.onClick3DTo2D(view2);
            }
        });
        naviFragment.mTvBackTo2D = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_3d_to_2d, "field 'mTvBackTo2D'", XTextView.class);
        naviFragment.mNaviTrafficbarContainer = (XRelativeLayout) Utils.findRequiredViewAsType(view, R.id.navi_traffic_bar_container, "field 'mNaviTrafficbarContainer'", XRelativeLayout.class);
        naviFragment.mTrafficBar = (TrafficBar) Utils.findRequiredViewAsType(view, R.id.navi_info_trafficbar, "field 'mTrafficBar'", TrafficBar.class);
        naviFragment.mTvCurrentRoad = (CurrentRoadNameView) Utils.findRequiredViewAsType(view, R.id.guide_curroad_name, "field 'mTvCurrentRoad'", CurrentRoadNameView.class);
        naviFragment.mTvContinuNavi = (CurrentRoadNameView) Utils.findRequiredViewAsType(view, R.id.guide_continue_navi, "field 'mTvContinuNavi'", CurrentRoadNameView.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.navi_info_eagle_bg_mask, "field 'mEagleBgMask', method 'onClickEagleBgMask', and method 'onLongTouchEagleBgMask'");
        naviFragment.mEagleBgMask = (XImageView) Utils.castView(findRequiredView3, R.id.navi_info_eagle_bg_mask, "field 'mEagleBgMask'", XImageView.class);
        this.view7f09029e = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                naviFragment.onClickEagleBgMask(view2);
            }
        });
        findRequiredView3.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviFragment_ViewBinding.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return naviFragment.onLongTouchEagleBgMask(view2);
            }
        });
        naviFragment.mRouteChargeStub = (ViewStub) Utils.findRequiredViewAsType(view, R.id.route_charge_panel_stub, "field 'mRouteChargeStub'", ViewStub.class);
        naviFragment.mXpNgpPanelView = (XpNgpPanelView) Utils.findRequiredViewAsType(view, R.id.srnavi_ngp_panel_view, "field 'mXpNgpPanelView'", XpNgpPanelView.class);
        naviFragment.mAccSpeedViewText = (XTextView) Utils.findRequiredViewAsType(view, R.id.srnavi_acc_view_text, "field 'mAccSpeedViewText'", XTextView.class);
        naviFragment.mLimitSpeedViewText = (XTextView) Utils.findRequiredViewAsType(view, R.id.srnavi_limit_speed_view_text, "field 'mLimitSpeedViewText'", XTextView.class);
        naviFragment.mTrafficPanel = (XRelativeLayout) Utils.findRequiredViewAsType(view, R.id.srnavi_traffic_panel, "field 'mTrafficPanel'", XRelativeLayout.class);
        naviFragment.mTrafficPanelIcon = (XImageView) Utils.findRequiredViewAsType(view, R.id.srnavi_traffic_panel_icon, "field 'mTrafficPanelIcon'", XImageView.class);
        naviFragment.mTrafficPanelText = (XTextView) Utils.findRequiredViewAsType(view, R.id.srnavi_traffic_panel_text, "field 'mTrafficPanelText'", XTextView.class);
        naviFragment.mSRViewAngleBtnGroup = (XRadioGroup) Utils.findRequiredViewAsType(view, R.id.sr_view_angle_group, "field 'mSRViewAngleBtnGroup'", XRadioGroup.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        NaviFragment naviFragment = this.target;
        if (naviFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        naviFragment.mBtnAddWaypoint = null;
        naviFragment.mBtnAddWaypointIcon = null;
        naviFragment.mBtnAddWaypointTips = null;
        naviFragment.mSuggestSpeedCameras = null;
        naviFragment.mCrossLayout = null;
        naviFragment.mImCross = null;
        naviFragment.mGuideBackTo2D = null;
        naviFragment.mTvBackTo2D = null;
        naviFragment.mNaviTrafficbarContainer = null;
        naviFragment.mTrafficBar = null;
        naviFragment.mTvCurrentRoad = null;
        naviFragment.mTvContinuNavi = null;
        naviFragment.mEagleBgMask = null;
        naviFragment.mRouteChargeStub = null;
        naviFragment.mXpNgpPanelView = null;
        naviFragment.mAccSpeedViewText = null;
        naviFragment.mLimitSpeedViewText = null;
        naviFragment.mTrafficPanel = null;
        naviFragment.mTrafficPanelIcon = null;
        naviFragment.mTrafficPanelText = null;
        naviFragment.mSRViewAngleBtnGroup = null;
        this.view7f0900ab.setOnClickListener(null);
        this.view7f0900ab = null;
        this.view7f0901a5.setOnClickListener(null);
        this.view7f0901a5 = null;
        this.view7f09029e.setOnClickListener(null);
        this.view7f09029e.setOnLongClickListener(null);
        this.view7f09029e = null;
    }
}
