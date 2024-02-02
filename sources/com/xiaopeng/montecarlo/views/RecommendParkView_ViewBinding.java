package com.xiaopeng.montecarlo.views;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import com.xiaopeng.xui.widget.XToggleButton;
/* loaded from: classes3.dex */
public class RecommendParkView_ViewBinding implements Unbinder {
    private RecommendParkView target;
    private View view7f0900b8;
    private View view7f0901b3;
    private View view7f09020e;

    @UiThread
    public RecommendParkView_ViewBinding(RecommendParkView recommendParkView) {
        this(recommendParkView, recommendParkView);
    }

    @UiThread
    public RecommendParkView_ViewBinding(final RecommendParkView recommendParkView, View view) {
        this.target = recommendParkView;
        recommendParkView.mRecommendParkNormalContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.guide_recommend_container, "field 'mRecommendParkNormalContainer'", XLinearLayout.class);
        recommendParkView.mRecommendButtonContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.recommend_park_button_container, "field 'mRecommendButtonContainer'", XLinearLayout.class);
        recommendParkView.mBtnRecommendPark1 = (XToggleButton) Utils.findRequiredViewAsType(view, R.id.btn_recommend_park1, "field 'mBtnRecommendPark1'", XToggleButton.class);
        recommendParkView.mBtnRecommendPark2 = (XToggleButton) Utils.findRequiredViewAsType(view, R.id.btn_recommend_park2, "field 'mBtnRecommendPark2'", XToggleButton.class);
        recommendParkView.mBtnRecommendPark3 = (XToggleButton) Utils.findRequiredViewAsType(view, R.id.btn_recommend_park3, "field 'mBtnRecommendPark3'", XToggleButton.class);
        recommendParkView.mTvRecommendParkName = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_recommend_park_name, "field 'mTvRecommendParkName'", XTextView.class);
        recommendParkView.mTvRecommendParkAddress = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_recommend_park_address, "field 'mTvRecommendParkAddress'", XTextView.class);
        recommendParkView.mParkTollLayout = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.park_toll_layout, "field 'mParkTollLayout'", XLinearLayout.class);
        recommendParkView.mParkTollView = (XTextView) Utils.findRequiredViewAsType(view, R.id.park_toll, "field 'mParkTollView'", XTextView.class);
        recommendParkView.mParkChargeStatusView = (ParkChargeStatusView) Utils.findRequiredViewAsType(view, R.id.park_space_view, "field 'mParkChargeStatusView'", ParkChargeStatusView.class);
        recommendParkView.mTvRecommendParkDis = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_recommend_park_distance, "field 'mTvRecommendParkDis'", XTextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.guide_recommend_collapse_container, "field 'mRecommendParkCollapseContainer' and method 'onClickRecommendParkCollapse'");
        recommendParkView.mRecommendParkCollapseContainer = (XRelativeLayout) Utils.castView(findRequiredView, R.id.guide_recommend_collapse_container, "field 'mRecommendParkCollapseContainer'", XRelativeLayout.class);
        this.view7f0901b3 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.views.RecommendParkView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                recommendParkView.onClickRecommendParkCollapse(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.btn_recommend_park_switch, "method 'onClickRecommendPardSwitch'");
        this.view7f0900b8 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.views.RecommendParkView_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                recommendParkView.onClickRecommendPardSwitch(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.iv_parking_collapse_arrow, "method 'onClickRecommendCollapseArrow'");
        this.view7f09020e = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.views.RecommendParkView_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                recommendParkView.onClickRecommendCollapseArrow(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RecommendParkView recommendParkView = this.target;
        if (recommendParkView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        recommendParkView.mRecommendParkNormalContainer = null;
        recommendParkView.mRecommendButtonContainer = null;
        recommendParkView.mBtnRecommendPark1 = null;
        recommendParkView.mBtnRecommendPark2 = null;
        recommendParkView.mBtnRecommendPark3 = null;
        recommendParkView.mTvRecommendParkName = null;
        recommendParkView.mTvRecommendParkAddress = null;
        recommendParkView.mParkTollLayout = null;
        recommendParkView.mParkTollView = null;
        recommendParkView.mParkChargeStatusView = null;
        recommendParkView.mTvRecommendParkDis = null;
        recommendParkView.mRecommendParkCollapseContainer = null;
        this.view7f0901b3.setOnClickListener(null);
        this.view7f0901b3 = null;
        this.view7f0900b8.setOnClickListener(null);
        this.view7f0900b8 = null;
        this.view7f09020e.setOnClickListener(null);
        this.view7f09020e = null;
    }
}
