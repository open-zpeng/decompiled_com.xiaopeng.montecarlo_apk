package com.xiaopeng.montecarlo.scenes.searchscene;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.views.XPRecyclerView;
import com.xiaopeng.xui.view.XView;
import com.xiaopeng.xui.widget.XConstraintLayout;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class SearchResultFragment_ViewBinding implements Unbinder {
    private SearchResultFragment target;
    private View view7f090116;
    private View view7f090192;
    private View view7f090193;
    private View view7f0901f4;
    private View view7f090217;
    private View view7f09021d;
    private View view7f09021e;
    private View view7f0903ab;
    private View view7f0903ac;
    private View view7f09051b;
    private View view7f09051c;

    @UiThread
    public SearchResultFragment_ViewBinding(final SearchResultFragment searchResultFragment, View view) {
        this.target = searchResultFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.container_title, "field 'mContainerTitle' and method 'onTitleContainerClick'");
        searchResultFragment.mContainerTitle = (XView) Utils.castView(findRequiredView, R.id.container_title, "field 'mContainerTitle'", XView.class);
        this.view7f090116 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchResultFragment.onTitleContainerClick();
            }
        });
        searchResultFragment.mSingleLayout = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.container_search_result_panel, "field 'mSingleLayout'", XLinearLayout.class);
        searchResultFragment.mTvTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_search_content, "field 'mTvTitle'", XTextView.class);
        searchResultFragment.mTvRadius = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_search_radius, "field 'mTvRadius'", XTextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.iv_search_back, "field 'mIvBack' and method 'onClickBack'");
        searchResultFragment.mIvBack = (XImageButton) Utils.castView(findRequiredView2, R.id.iv_search_back, "field 'mIvBack'", XImageButton.class);
        this.view7f090217 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchResultFragment.onClickBack();
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.iv_single_back, "field 'mIvSingleBack' and method 'onClickBackBySingle'");
        searchResultFragment.mIvSingleBack = (XImageButton) Utils.castView(findRequiredView3, R.id.iv_single_back, "field 'mIvSingleBack'", XImageButton.class);
        this.view7f09021d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchResultFragment.onClickBackBySingle();
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.iv_single_close, "field 'mIvSingleClose' and method 'onClickCloseBySingle'");
        searchResultFragment.mIvSingleClose = (XImageButton) Utils.castView(findRequiredView4, R.id.iv_single_close, "field 'mIvSingleClose'", XImageButton.class);
        this.view7f09021e = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchResultFragment.onClickCloseBySingle();
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.tv_search_result_content, "field 'mTvTitleSingle' and method 'onTitleClickBySingle'");
        searchResultFragment.mTvTitleSingle = (XTextView) Utils.castView(findRequiredView5, R.id.tv_search_result_content, "field 'mTvTitleSingle'", XTextView.class);
        this.view7f09051b = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchResultFragment.onTitleClickBySingle();
            }
        });
        View findRequiredView6 = Utils.findRequiredView(view, R.id.tv_search_result_radius, "field 'mTvRadiusSingle' and method 'onTitleClickBySingle'");
        searchResultFragment.mTvRadiusSingle = (XTextView) Utils.castView(findRequiredView6, R.id.tv_search_result_radius, "field 'mTvRadiusSingle'", XTextView.class);
        this.view7f09051c = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchResultFragment.onTitleClickBySingle();
            }
        });
        searchResultFragment.mFilterContainer = Utils.findRequiredView(view, R.id.search_charge_filter_container, "field 'mFilterContainer'");
        View findRequiredView7 = Utils.findRequiredView(view, R.id.filter_self_sale, "field 'mTvFilterSelfSale' and method 'onClickChargeFilter'");
        searchResultFragment.mTvFilterSelfSale = (XTextView) Utils.castView(findRequiredView7, R.id.filter_self_sale, "field 'mTvFilterSelfSale'", XTextView.class);
        this.view7f090193 = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchResultFragment.onClickChargeFilter(view2);
            }
        });
        View findRequiredView8 = Utils.findRequiredView(view, R.id.filter_free, "field 'mTvFilterFree' and method 'onClickChargeFilter'");
        searchResultFragment.mTvFilterFree = (XTextView) Utils.castView(findRequiredView8, R.id.filter_free, "field 'mTvFilterFree'", XTextView.class);
        this.view7f090192 = findRequiredView8;
        findRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultFragment_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchResultFragment.onClickChargeFilter(view2);
            }
        });
        searchResultFragment.mIvInnerShadow = (XImageView) Utils.findRequiredViewAsType(view, R.id.search_result_inner_shadow, "field 'mIvInnerShadow'", XImageView.class);
        searchResultFragment.mRecyclerView = (XPRecyclerView) Utils.findRequiredViewAsType(view, R.id.keyword_search_result, "field 'mRecyclerView'", XPRecyclerView.class);
        searchResultFragment.mMultipleLayout = (XConstraintLayout) Utils.findRequiredViewAsType(view, R.id.multiple_layout, "field 'mMultipleLayout'", XConstraintLayout.class);
        searchResultFragment.mOfflineContainer = (ViewStub) Utils.findRequiredViewAsType(view, R.id.search_result_offline_container, "field 'mOfflineContainer'", ViewStub.class);
        View findRequiredView9 = Utils.findRequiredView(view, R.id.search_result_expand, "field 'mIvExpand' and method 'onClickExpand'");
        searchResultFragment.mIvExpand = (XImageView) Utils.castView(findRequiredView9, R.id.search_result_expand, "field 'mIvExpand'", XImageView.class);
        this.view7f0903ab = findRequiredView9;
        findRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultFragment_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchResultFragment.onClickExpand();
            }
        });
        View findRequiredView10 = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvClear' and method 'onClickClose'");
        searchResultFragment.mIvClear = (XImageButton) Utils.castView(findRequiredView10, R.id.iv_clear, "field 'mIvClear'", XImageButton.class);
        this.view7f0901f4 = findRequiredView10;
        findRequiredView10.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultFragment_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchResultFragment.onClickClose();
            }
        });
        searchResultFragment.mRouteChargeStub = (ViewStub) Utils.findRequiredViewAsType(view, R.id.route_charge_panel_stub, "field 'mRouteChargeStub'", ViewStub.class);
        searchResultFragment.mSearchNoResultContainerSub = (ViewStub) Utils.findRequiredViewAsType(view, R.id.search_no_result_container_sub, "field 'mSearchNoResultContainerSub'", ViewStub.class);
        View findRequiredView11 = Utils.findRequiredView(view, R.id.search_result_fold, "method 'onClickFold'");
        this.view7f0903ac = findRequiredView11;
        findRequiredView11.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultFragment_ViewBinding.11
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchResultFragment.onClickFold();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchResultFragment searchResultFragment = this.target;
        if (searchResultFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        searchResultFragment.mContainerTitle = null;
        searchResultFragment.mSingleLayout = null;
        searchResultFragment.mTvTitle = null;
        searchResultFragment.mTvRadius = null;
        searchResultFragment.mIvBack = null;
        searchResultFragment.mIvSingleBack = null;
        searchResultFragment.mIvSingleClose = null;
        searchResultFragment.mTvTitleSingle = null;
        searchResultFragment.mTvRadiusSingle = null;
        searchResultFragment.mFilterContainer = null;
        searchResultFragment.mTvFilterSelfSale = null;
        searchResultFragment.mTvFilterFree = null;
        searchResultFragment.mIvInnerShadow = null;
        searchResultFragment.mRecyclerView = null;
        searchResultFragment.mMultipleLayout = null;
        searchResultFragment.mOfflineContainer = null;
        searchResultFragment.mIvExpand = null;
        searchResultFragment.mIvClear = null;
        searchResultFragment.mRouteChargeStub = null;
        searchResultFragment.mSearchNoResultContainerSub = null;
        this.view7f090116.setOnClickListener(null);
        this.view7f090116 = null;
        this.view7f090217.setOnClickListener(null);
        this.view7f090217 = null;
        this.view7f09021d.setOnClickListener(null);
        this.view7f09021d = null;
        this.view7f09021e.setOnClickListener(null);
        this.view7f09021e = null;
        this.view7f09051b.setOnClickListener(null);
        this.view7f09051b = null;
        this.view7f09051c.setOnClickListener(null);
        this.view7f09051c = null;
        this.view7f090193.setOnClickListener(null);
        this.view7f090193 = null;
        this.view7f090192.setOnClickListener(null);
        this.view7f090192 = null;
        this.view7f0903ab.setOnClickListener(null);
        this.view7f0903ab = null;
        this.view7f0901f4.setOnClickListener(null);
        this.view7f0901f4 = null;
        this.view7f0903ac.setOnClickListener(null);
        this.view7f0903ac = null;
    }
}
