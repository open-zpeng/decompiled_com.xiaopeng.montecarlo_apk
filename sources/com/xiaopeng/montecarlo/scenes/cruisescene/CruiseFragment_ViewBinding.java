package com.xiaopeng.montecarlo.scenes.cruisescene;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.views.road.CurrentRoadNameView;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class CruiseFragment_ViewBinding implements Unbinder {
    private CruiseFragment target;
    private View view7f0904bb;
    private View view7f090526;

    @UiThread
    public CruiseFragment_ViewBinding(final CruiseFragment cruiseFragment, View view) {
        this.target = cruiseFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_search_content, "field 'mTvSearchContent' and method 'onClickSearchBox'");
        cruiseFragment.mTvSearchContent = (XTextView) Utils.castView(findRequiredView, R.id.tv_search_content, "field 'mTvSearchContent'", XTextView.class);
        this.view7f090526 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.CruiseFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                cruiseFragment.onClickSearchBox();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_charge_count, "field 'mTvChargeCount' and method 'onClickChargePanel'");
        cruiseFragment.mTvChargeCount = (XTextView) Utils.castView(findRequiredView2, R.id.tv_charge_count, "field 'mTvChargeCount'", XTextView.class);
        this.view7f0904bb = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.CruiseFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                cruiseFragment.onClickChargePanel(view2);
            }
        });
        cruiseFragment.mCruiseLaneStub = (ViewStub) Utils.findRequiredViewAsType(view, R.id.mapfragment_cruise_lanes_stub, "field 'mCruiseLaneStub'", ViewStub.class);
        cruiseFragment.mCameraSimpleViewStub = (ViewStub) Utils.findRequiredViewAsType(view, R.id.view_camera_simple_stub, "field 'mCameraSimpleViewStub'", ViewStub.class);
        cruiseFragment.mRecommendChargersStub = (ViewStub) Utils.findRequiredViewAsType(view, R.id.cruise_recommend_chargers_stub, "field 'mRecommendChargersStub'", ViewStub.class);
        cruiseFragment.mMapCurrentRoadName = (CurrentRoadNameView) Utils.findRequiredViewAsType(view, R.id.map_current_road_name, "field 'mMapCurrentRoadName'", CurrentRoadNameView.class);
        cruiseFragment.mCruiseCongestionInfoStub = (ViewStub) Utils.findRequiredViewAsType(view, R.id.cruise_congestion_info_stub, "field 'mCruiseCongestionInfoStub'", ViewStub.class);
        cruiseFragment.mViewContainer = (XRelativeLayout) Utils.findRequiredViewAsType(view, R.id.view_container, "field 'mViewContainer'", XRelativeLayout.class);
        cruiseFragment.mGifGuideLayoutStub = (ViewStub) Utils.findRequiredViewAsType(view, R.id.rl_seamless_stub, "field 'mGifGuideLayoutStub'", ViewStub.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CruiseFragment cruiseFragment = this.target;
        if (cruiseFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        cruiseFragment.mTvSearchContent = null;
        cruiseFragment.mTvChargeCount = null;
        cruiseFragment.mCruiseLaneStub = null;
        cruiseFragment.mCameraSimpleViewStub = null;
        cruiseFragment.mRecommendChargersStub = null;
        cruiseFragment.mMapCurrentRoadName = null;
        cruiseFragment.mCruiseCongestionInfoStub = null;
        cruiseFragment.mViewContainer = null;
        cruiseFragment.mGifGuideLayoutStub = null;
        this.view7f090526.setOnClickListener(null);
        this.view7f090526 = null;
        this.view7f0904bb.setOnClickListener(null);
        this.view7f0904bb = null;
    }
}
