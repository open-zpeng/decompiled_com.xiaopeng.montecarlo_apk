package com.xiaopeng.montecarlo.base;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.autonavi.gbl.map.adapter.MapSurfaceView;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.views.MapScaleLineView;
import com.xiaopeng.montecarlo.views.mapmode.MapModeIconView;
import com.xiaopeng.montecarlo.views.road.CurrentRoadNameView;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes.dex */
public class MapFragment_ViewBinding implements Unbinder {
    private MapFragment target;
    private View view7f0900af;
    private View view7f0900b1;
    private View view7f0900b2;
    private View view7f0900b4;
    private View view7f0900bc;
    private View view7f0900c5;
    private View view7f0900c7;
    private View view7f0900c8;
    private View view7f090448;

    @UiThread
    public MapFragment_ViewBinding(final MapFragment mapFragment, View view) {
        this.target = mapFragment;
        mapFragment.mMapView = (MapSurfaceView) Utils.findRequiredViewAsType(view, R.id.map_view, "field 'mMapView'", MapSurfaceView.class);
        mapFragment.mMapZoomContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.map_level_stepper, "field 'mMapZoomContainer'", ViewGroup.class);
        mapFragment.mMapScaleTextContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.map_scale_text_container, "field 'mMapScaleTextContainer'", XLinearLayout.class);
        mapFragment.mMapScaleText = (XTextView) Utils.findRequiredViewAsType(view, R.id.map_scale_text_content, "field 'mMapScaleText'", XTextView.class);
        mapFragment.mMapScale = (MapScaleLineView) Utils.findRequiredViewAsType(view, R.id.map_scale_text_bg, "field 'mMapScale'", MapScaleLineView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.btn_zoom_in, "field 'mBtnZoomIn' and method 'onClickZoomIn'");
        mapFragment.mBtnZoomIn = (XImageButton) Utils.castView(findRequiredView, R.id.btn_zoom_in, "field 'mBtnZoomIn'", XImageButton.class);
        this.view7f0900c7 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.base.MapFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapFragment.onClickZoomIn(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.btn_zoom_out, "field 'mBtnZoomOut' and method 'onClickZoomOut'");
        mapFragment.mBtnZoomOut = (XImageButton) Utils.castView(findRequiredView2, R.id.btn_zoom_out, "field 'mBtnZoomOut'", XImageButton.class);
        this.view7f0900c8 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.base.MapFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapFragment.onClickZoomOut(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.btn_map_mode, "field 'mBtnMapMode' and method 'onClickMapMode'");
        mapFragment.mBtnMapMode = (MapModeIconView) Utils.castView(findRequiredView3, R.id.btn_map_mode, "field 'mBtnMapMode'", MapModeIconView.class);
        this.view7f0900af = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.base.MapFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapFragment.onClickMapMode(view2);
            }
        });
        mapFragment.mModeContainer = Utils.findRequiredView(view, R.id.mode_container, "field 'mModeContainer'");
        View findRequiredView4 = Utils.findRequiredView(view, R.id.btn_parallel, "field 'mBtnRoadChange' and method 'onClickRoadChange'");
        mapFragment.mBtnRoadChange = (XImageButton) Utils.castView(findRequiredView4, R.id.btn_parallel, "field 'mBtnRoadChange'", XImageButton.class);
        this.view7f0900b2 = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.base.MapFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapFragment.onClickRoadChange(view2);
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.btn_overview, "field 'mBtnOverView', method 'onClickOverView', and method 'onLongClickOverView'");
        mapFragment.mBtnOverView = (XImageButton) Utils.castView(findRequiredView5, R.id.btn_overview, "field 'mBtnOverView'", XImageButton.class);
        this.view7f0900b1 = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.base.MapFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapFragment.onClickOverView(view2);
            }
        });
        findRequiredView5.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.xiaopeng.montecarlo.base.MapFragment_ViewBinding.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return mapFragment.onLongClickOverView(view2);
            }
        });
        View findRequiredView6 = Utils.findRequiredView(view, R.id.btn_setting, "field 'mBtnSetting' and method 'onClickSetting'");
        mapFragment.mBtnSetting = (XImageButton) Utils.castView(findRequiredView6, R.id.btn_setting, "field 'mBtnSetting'", XImageButton.class);
        this.view7f0900bc = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.base.MapFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapFragment.onClickSetting(view2);
            }
        });
        View findRequiredView7 = Utils.findRequiredView(view, R.id.btn_recenter, "field 'mBtnMapRecenter' and method 'onClickMapRecenter'");
        mapFragment.mBtnMapRecenter = (CurrentRoadNameView) Utils.castView(findRequiredView7, R.id.btn_recenter, "field 'mBtnMapRecenter'", CurrentRoadNameView.class);
        this.view7f0900b4 = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.base.MapFragment_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapFragment.onClickMapRecenter(view2);
            }
        });
        View findRequiredView8 = Utils.findRequiredView(view, R.id.btn_volume, "field 'mBtnVolume' and method 'onClickVolume'");
        mapFragment.mBtnVolume = (XImageButton) Utils.castView(findRequiredView8, R.id.btn_volume, "field 'mBtnVolume'", XImageButton.class);
        this.view7f0900c5 = findRequiredView8;
        findRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.base.MapFragment_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapFragment.onClickVolume(view2);
            }
        });
        mapFragment.mImgAutologo = (XImageView) Utils.findRequiredViewAsType(view, R.id.img_auto_logo, "field 'mImgAutologo'", XImageView.class);
        mapFragment.mLocationInfoContainer = (ViewStub) Utils.findRequiredViewAsType(view, R.id.location_info_container_stub, "field 'mLocationInfoContainer'", ViewStub.class);
        mapFragment.mLeftBtnContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.left_btn_container, "field 'mLeftBtnContainer'", ViewGroup.class);
        mapFragment.mRouteChargeSwitchContainer = Utils.findRequiredView(view, R.id.route_charge_switch_container, "field 'mRouteChargeSwitchContainer'");
        mapFragment.mRouteChargeSwitchBtn = (XImageButton) Utils.findRequiredViewAsType(view, R.id.route_charge_plan_switch_btn, "field 'mRouteChargeSwitchBtn'", XImageButton.class);
        mapFragment.mButtonsContainer = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.map_buttons, "field 'mButtonsContainer'", RelativeLayout.class);
        View findRequiredView9 = Utils.findRequiredView(view, R.id.sr_normal_switch, "field 'mSRNaviSwitch' and method 'onClickSrAndNormalSwitch'");
        mapFragment.mSRNaviSwitch = (XImageView) Utils.castView(findRequiredView9, R.id.sr_normal_switch, "field 'mSRNaviSwitch'", XImageView.class);
        this.view7f090448 = findRequiredView9;
        findRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.base.MapFragment_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapFragment.onClickSrAndNormalSwitch(view2);
            }
        });
        mapFragment.mSRDataDebugStub = (ViewStub) Utils.findRequiredViewAsType(view, R.id.sr_data_debug_stub, "field 'mSRDataDebugStub'", ViewStub.class);
        mapFragment.mStubProtoPlay = (ViewStub) Utils.findRequiredViewAsType(view, R.id.debug_proto_play_stub, "field 'mStubProtoPlay'", ViewStub.class);
        mapFragment.mStubLaneRecordPlay = (ViewStub) Utils.findRequiredViewAsType(view, R.id.debug_lane_record_play_stub, "field 'mStubLaneRecordPlay'", ViewStub.class);
        mapFragment.mTakeOverWeak = (XImageView) Utils.findRequiredViewAsType(view, R.id.ngp_mask_take_over_weak, "field 'mTakeOverWeak'", XImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MapFragment mapFragment = this.target;
        if (mapFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mapFragment.mMapView = null;
        mapFragment.mMapZoomContainer = null;
        mapFragment.mMapScaleTextContainer = null;
        mapFragment.mMapScaleText = null;
        mapFragment.mMapScale = null;
        mapFragment.mBtnZoomIn = null;
        mapFragment.mBtnZoomOut = null;
        mapFragment.mBtnMapMode = null;
        mapFragment.mModeContainer = null;
        mapFragment.mBtnRoadChange = null;
        mapFragment.mBtnOverView = null;
        mapFragment.mBtnSetting = null;
        mapFragment.mBtnMapRecenter = null;
        mapFragment.mBtnVolume = null;
        mapFragment.mImgAutologo = null;
        mapFragment.mLocationInfoContainer = null;
        mapFragment.mLeftBtnContainer = null;
        mapFragment.mRouteChargeSwitchContainer = null;
        mapFragment.mRouteChargeSwitchBtn = null;
        mapFragment.mButtonsContainer = null;
        mapFragment.mSRNaviSwitch = null;
        mapFragment.mSRDataDebugStub = null;
        mapFragment.mStubProtoPlay = null;
        mapFragment.mStubLaneRecordPlay = null;
        mapFragment.mTakeOverWeak = null;
        this.view7f0900c7.setOnClickListener(null);
        this.view7f0900c7 = null;
        this.view7f0900c8.setOnClickListener(null);
        this.view7f0900c8 = null;
        this.view7f0900af.setOnClickListener(null);
        this.view7f0900af = null;
        this.view7f0900b2.setOnClickListener(null);
        this.view7f0900b2 = null;
        this.view7f0900b1.setOnClickListener(null);
        this.view7f0900b1.setOnLongClickListener(null);
        this.view7f0900b1 = null;
        this.view7f0900bc.setOnClickListener(null);
        this.view7f0900bc = null;
        this.view7f0900b4.setOnClickListener(null);
        this.view7f0900b4 = null;
        this.view7f0900c5.setOnClickListener(null);
        this.view7f0900c5 = null;
        this.view7f090448.setOnClickListener(null);
        this.view7f090448 = null;
    }
}
