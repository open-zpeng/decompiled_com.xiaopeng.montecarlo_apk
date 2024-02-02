package com.xiaopeng.montecarlo.views.poicard;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.views.ChildPoiGridView;
import com.xiaopeng.montecarlo.views.ExpandableTextView;
import com.xiaopeng.montecarlo.views.NaviImageView;
import com.xiaopeng.montecarlo.views.XpPoiPopScrollView;
import com.xiaopeng.xui.view.XView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XLoading;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class PoiCardView_ViewBinding implements Unbinder {
    private PoiCardView target;
    private View view7f0900a3;
    private View view7f0900ae;

    @UiThread
    public PoiCardView_ViewBinding(PoiCardView poiCardView) {
        this(poiCardView, poiCardView);
    }

    @UiThread
    public PoiCardView_ViewBinding(final PoiCardView poiCardView, View view) {
        this.target = poiCardView;
        poiCardView.mLoading = (XLoading) Utils.findRequiredViewAsType(view, R.id.loading_poi_card, "field 'mLoading'", XLoading.class);
        poiCardView.mMainBody = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.main_body, "field 'mMainBody'", XLinearLayout.class);
        poiCardView.mPoiPopContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.poi_pop_container, "field 'mPoiPopContainer'", XLinearLayout.class);
        poiCardView.mTopScroller = (XpPoiPopScrollView) Utils.findRequiredViewAsType(view, R.id.poi_xp_scroller, "field 'mTopScroller'", XpPoiPopScrollView.class);
        poiCardView.mPoiScrollDividerContainer = (XRelativeLayout) Utils.findRequiredViewAsType(view, R.id.poi_xp_scroller_and_divider, "field 'mPoiScrollDividerContainer'", XRelativeLayout.class);
        poiCardView.mPoiScrollContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.poi_scroll_container, "field 'mPoiScrollContainer'", XLinearLayout.class);
        poiCardView.mTitleLayoutContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.poi_title_container, "field 'mTitleLayoutContainer'", XLinearLayout.class);
        poiCardView.mTvAddress = (ExpandableTextView) Utils.findRequiredViewAsType(view, R.id.poi_address, "field 'mTvAddress'", ExpandableTextView.class);
        poiCardView.mEvaluationLayoutContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.container_evaluation, "field 'mEvaluationLayoutContainer'", XLinearLayout.class);
        poiCardView.mCarServiceLayoutContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.container_car_service, "field 'mCarServiceLayoutContainer'", XLinearLayout.class);
        poiCardView.mCarRemainDistanceLayoutContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.car_remain_distance_container, "field 'mCarRemainDistanceLayoutContainer'", XLinearLayout.class);
        poiCardView.mPicLayoutContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.poi_pic_container, "field 'mPicLayoutContainer'", XLinearLayout.class);
        poiCardView.mChargeDetailLayoutContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.poi_charge_detail_container, "field 'mChargeDetailLayoutContainer'", XLinearLayout.class);
        poiCardView.mChargeDownLockLayoutContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.poi_charge_down_lock_container, "field 'mChargeDownLockLayoutContainer'", XLinearLayout.class);
        poiCardView.mParkLayoutContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.poi_item_park_container, "field 'mParkLayoutContainer'", XLinearLayout.class);
        poiCardView.mTimeLayoutContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.poi_time_container, "field 'mTimeLayoutContainer'", XLinearLayout.class);
        poiCardView.mPriceLayoutContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.poi_price_container, "field 'mPriceLayoutContainer'", XLinearLayout.class);
        poiCardView.mPoiChildContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.poi_children_container, "field 'mPoiChildContainer'", XLinearLayout.class);
        poiCardView.mChildTopDivider = (XView) Utils.findRequiredViewAsType(view, R.id.poi_children_divider_top, "field 'mChildTopDivider'", XView.class);
        poiCardView.mPoiChildView = (ChildPoiGridView) Utils.findRequiredViewAsType(view, R.id.poi_children, "field 'mPoiChildView'", ChildPoiGridView.class);
        poiCardView.mRoadInfoLayoutContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.tv_road_info_container, "field 'mRoadInfoLayoutContainer'", XLinearLayout.class);
        poiCardView.mPoiDividerBottom = (XView) Utils.findRequiredViewAsType(view, R.id.poi_divider_bottom, "field 'mPoiDividerBottom'", XView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.btn_left_button, "field 'mBtnLeftButton' and method 'onLeftButtonClick'");
        poiCardView.mBtnLeftButton = (NaviImageView) Utils.castView(findRequiredView, R.id.btn_left_button, "field 'mBtnLeftButton'", NaviImageView.class);
        this.view7f0900ae = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                poiCardView.onLeftButtonClick(view2);
            }
        });
        poiCardView.mPoiEntryLayoutContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.poi_entry_layout, "field 'mPoiEntryLayoutContainer'", XLinearLayout.class);
        poiCardView.mPoiBottom = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.poi_bottom, "field 'mPoiBottom'", XLinearLayout.class);
        poiCardView.mRatingBar = (RatingBar) Utils.findRequiredViewAsType(view, R.id.search_result_rating_bar, "field 'mRatingBar'", RatingBar.class);
        poiCardView.mCost = (XTextView) Utils.findRequiredViewAsType(view, R.id.search_result_cost, "field 'mCost'", XTextView.class);
        poiCardView.mStarContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.search_result_rating_star_container, "field 'mStarContainer'", ViewGroup.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.btn_close_poi_card, "field 'mBtnClose' and method 'onCloseButtonClick'");
        poiCardView.mBtnClose = (XTextView) Utils.castView(findRequiredView2, R.id.btn_close_poi_card, "field 'mBtnClose'", XTextView.class);
        this.view7f0900a3 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                poiCardView.onCloseButtonClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PoiCardView poiCardView = this.target;
        if (poiCardView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        poiCardView.mLoading = null;
        poiCardView.mMainBody = null;
        poiCardView.mPoiPopContainer = null;
        poiCardView.mTopScroller = null;
        poiCardView.mPoiScrollDividerContainer = null;
        poiCardView.mPoiScrollContainer = null;
        poiCardView.mTitleLayoutContainer = null;
        poiCardView.mTvAddress = null;
        poiCardView.mEvaluationLayoutContainer = null;
        poiCardView.mCarServiceLayoutContainer = null;
        poiCardView.mCarRemainDistanceLayoutContainer = null;
        poiCardView.mPicLayoutContainer = null;
        poiCardView.mChargeDetailLayoutContainer = null;
        poiCardView.mChargeDownLockLayoutContainer = null;
        poiCardView.mParkLayoutContainer = null;
        poiCardView.mTimeLayoutContainer = null;
        poiCardView.mPriceLayoutContainer = null;
        poiCardView.mPoiChildContainer = null;
        poiCardView.mChildTopDivider = null;
        poiCardView.mPoiChildView = null;
        poiCardView.mRoadInfoLayoutContainer = null;
        poiCardView.mPoiDividerBottom = null;
        poiCardView.mBtnLeftButton = null;
        poiCardView.mPoiEntryLayoutContainer = null;
        poiCardView.mPoiBottom = null;
        poiCardView.mRatingBar = null;
        poiCardView.mCost = null;
        poiCardView.mStarContainer = null;
        poiCardView.mBtnClose = null;
        this.view7f0900ae.setOnClickListener(null);
        this.view7f0900ae = null;
        this.view7f0900a3.setOnClickListener(null);
        this.view7f0900a3 = null;
    }
}
