package com.xiaopeng.montecarlo.scenes.searchscene;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.views.TrafficBar;
import com.xiaopeng.montecarlo.views.XPRecyclerView;
import com.xiaopeng.montecarlo.views.XpMixedTextView;
import com.xiaopeng.xui.view.XView;
import com.xiaopeng.xui.widget.XEditText;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class SearchFragment_ViewBinding implements Unbinder {
    private SearchFragment target;
    private View view7f090084;
    private View view7f0900b9;
    private View view7f090109;
    private View view7f09010d;
    private View view7f09010f;
    private View view7f090176;
    private View view7f090207;
    private View view7f090208;
    private View view7f09020d;
    private View view7f090218;
    private View view7f0904d3;
    private View view7f0904d6;
    private View view7f0904f7;
    private View view7f090501;
    private View view7f090502;
    private View view7f090530;
    private View view7f090547;
    private View view7f090551;
    private View view7f09057a;

    @UiThread
    public SearchFragment_ViewBinding(final SearchFragment searchFragment, View view) {
        this.target = searchFragment;
        searchFragment.mSearchInputContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.search_input_container, "field 'mSearchInputContainer'", ViewGroup.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.btn_return, "field 'mBtnReturn' and method 'onClickBack'");
        searchFragment.mBtnReturn = (XImageButton) Utils.castView(findRequiredView, R.id.btn_return, "field 'mBtnReturn'", XImageButton.class);
        this.view7f0900b9 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchFragment.onClickBack();
            }
        });
        searchFragment.mViewHeadVerticalLine = (XView) Utils.findRequiredViewAsType(view, R.id.view_head_vertical_line, "field 'mViewHeadVerticalLine'", XView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.et_search, "field 'mEtSearch' and method 'onTitleClick'");
        searchFragment.mEtSearch = (XEditText) Utils.castView(findRequiredView2, R.id.et_search, "field 'mEtSearch'", XEditText.class);
        this.view7f090176 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchFragment.onTitleClick();
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvClear' and method 'onClickClear'");
        searchFragment.mIvClear = (XImageButton) Utils.castView(findRequiredView3, R.id.iv_clear, "field 'mIvClear'", XImageButton.class);
        this.view7f09020d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchFragment.onClickClear();
            }
        });
        searchFragment.mAroundLeft = (XpMixedTextView) Utils.findRequiredViewAsType(view, R.id.tv_around_left, "field 'mAroundLeft'", XpMixedTextView.class);
        searchFragment.mAroundRight = (XpMixedTextView) Utils.findRequiredViewAsType(view, R.id.tv_around_right, "field 'mAroundRight'", XpMixedTextView.class);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.tv_scan_search, "field 'mTvScanSearch' and method 'onScanSearch'");
        searchFragment.mTvScanSearch = (XTextView) Utils.castView(findRequiredView4, R.id.tv_scan_search, "field 'mTvScanSearch'", XTextView.class);
        this.view7f090547 = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchFragment.onScanSearch();
            }
        });
        searchFragment.mTvScanSearchLine = (XView) Utils.findRequiredViewAsType(view, R.id.search_vertical_line_scan, "field 'mTvScanSearchLine'", XView.class);
        searchFragment.mSearchFavoriteParent = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.search_favorite_parent, "field 'mSearchFavoriteParent'", XLinearLayout.class);
        searchFragment.mRecyclerViewHeader = Utils.findRequiredView(view, R.id.search_recyclerview_header, "field 'mRecyclerViewHeader'");
        searchFragment.mSearchHeaderLayout = (XRelativeLayout) Utils.findRequiredViewAsType(view, R.id.search_header_layout, "field 'mSearchHeaderLayout'", XRelativeLayout.class);
        View findRequiredView5 = Utils.findRequiredView(view, R.id.container_home, "field 'mHomeContainer' and method 'onClickHome'");
        searchFragment.mHomeContainer = (XRelativeLayout) Utils.castView(findRequiredView5, R.id.container_home, "field 'mHomeContainer'", XRelativeLayout.class);
        this.view7f09010d = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchFragment.onClickHome();
            }
        });
        searchFragment.mTvHome = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_home, "field 'mTvHome'", XTextView.class);
        searchFragment.mTvSetHome = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_set_home, "field 'mTvSetHome'", XTextView.class);
        View findRequiredView6 = Utils.findRequiredView(view, R.id.iv_change_home, "field 'mIvChangeHome' and method 'onEditHome'");
        searchFragment.mIvChangeHome = (XImageView) Utils.castView(findRequiredView6, R.id.iv_change_home, "field 'mIvChangeHome'", XImageView.class);
        this.view7f090207 = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchFragment.onEditHome();
            }
        });
        searchFragment.mTvHomeTipsDis = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_home_tips_dis, "field 'mTvHomeTipsDis'", XTextView.class);
        searchFragment.mTvHomeTipsTime = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_home_tips_time, "field 'mTvHomeTipsTime'", XTextView.class);
        searchFragment.mTrafficBarHome = (TrafficBar) Utils.findRequiredViewAsType(view, R.id.trafficbar_home, "field 'mTrafficBarHome'", TrafficBar.class);
        View findRequiredView7 = Utils.findRequiredView(view, R.id.container_office, "field 'mOfficeContainer' and method 'onClickOffice'");
        searchFragment.mOfficeContainer = (XRelativeLayout) Utils.castView(findRequiredView7, R.id.container_office, "field 'mOfficeContainer'", XRelativeLayout.class);
        this.view7f09010f = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchFragment.onClickOffice();
            }
        });
        searchFragment.mTvOffice = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_office, "field 'mTvOffice'", XTextView.class);
        searchFragment.mTvSetOffice = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_set_office, "field 'mTvSetOffice'", XTextView.class);
        View findRequiredView8 = Utils.findRequiredView(view, R.id.iv_change_office, "field 'mIvChangeOffice' and method 'onEditCompany'");
        searchFragment.mIvChangeOffice = (XImageView) Utils.castView(findRequiredView8, R.id.iv_change_office, "field 'mIvChangeOffice'", XImageView.class);
        this.view7f090208 = findRequiredView8;
        findRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchFragment.onEditCompany();
            }
        });
        searchFragment.mTvOfficeTipsDis = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_office_tips_dis, "field 'mTvOfficeTipsDis'", XTextView.class);
        searchFragment.mTvOfficeTipsDisTime = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_office_tips_time, "field 'mTvOfficeTipsDisTime'", XTextView.class);
        searchFragment.mTrafficBarOffice = (TrafficBar) Utils.findRequiredViewAsType(view, R.id.trafficbar_office, "field 'mTrafficBarOffice'", TrafficBar.class);
        searchFragment.mFavoriteUpdateTime = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_favorite_update_time, "field 'mFavoriteUpdateTime'", XTextView.class);
        View findRequiredView9 = Utils.findRequiredView(view, R.id.container_favorite, "field 'mFavoriteContainer' and method 'onClickFavorite'");
        searchFragment.mFavoriteContainer = (XRelativeLayout) Utils.castView(findRequiredView9, R.id.container_favorite, "field 'mFavoriteContainer'", XRelativeLayout.class);
        this.view7f090109 = findRequiredView9;
        findRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchFragment.onClickFavorite();
            }
        });
        View findRequiredView10 = Utils.findRequiredView(view, R.id.iv_favorite_next, "field 'mFavoriteNext' and method 'onClickFavorite'");
        searchFragment.mFavoriteNext = (XImageButton) Utils.castView(findRequiredView10, R.id.iv_favorite_next, "field 'mFavoriteNext'", XImageButton.class);
        this.view7f090218 = findRequiredView10;
        findRequiredView10.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchFragment.onClickFavorite();
            }
        });
        searchFragment.mTvFavorite = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_favorite, "field 'mTvFavorite'", XTextView.class);
        searchFragment.mSearchContainer = Utils.findRequiredView(view, R.id.search_container, "field 'mSearchContainer'");
        searchFragment.mSearchContainerSub = (ViewStub) Utils.findRequiredViewAsType(view, R.id.search_container_sub, "field 'mSearchContainerSub'", ViewStub.class);
        searchFragment.mFavoriteRecyclerView = (XPRecyclerView) Utils.findRequiredViewAsType(view, R.id.favorite_container_recyclerview, "field 'mFavoriteRecyclerView'", XPRecyclerView.class);
        searchFragment.mHistorySubContainer = (XRelativeLayout) Utils.findRequiredViewAsType(view, R.id.history_sub_container, "field 'mHistorySubContainer'", XRelativeLayout.class);
        searchFragment.mHistoryRecyclerView = (XPRecyclerView) Utils.findRequiredViewAsType(view, R.id.history_record_recyclerview, "field 'mHistoryRecyclerView'", XPRecyclerView.class);
        searchFragment.mSearchTipStub = (ViewStub) Utils.findRequiredViewAsType(view, R.id.search_tip_stub, "field 'mSearchTipStub'", ViewStub.class);
        searchFragment.mHaveMoreDataDecorator = (XImageView) Utils.findRequiredViewAsType(view, R.id.iv_have_more_data, "field 'mHaveMoreDataDecorator'", XImageView.class);
        searchFragment.mPbHistoryLoad = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.progressbar_history_container_loading, "field 'mPbHistoryLoad'", ProgressBar.class);
        searchFragment.mTvHistoryLoad = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_history_container_loading, "field 'mTvHistoryLoad'", XTextView.class);
        View findRequiredView11 = Utils.findRequiredView(view, R.id.base_scene, "method 'onClickOutside'");
        this.view7f090084 = findRequiredView11;
        findRequiredView11.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment_ViewBinding.11
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchFragment.onClickOutside();
            }
        });
        View findRequiredView12 = Utils.findRequiredView(view, R.id.tv_charge, "method 'onClickCategory'");
        this.view7f0904d6 = findRequiredView12;
        findRequiredView12.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment_ViewBinding.12
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchFragment.onClickCategory(view2);
            }
        });
        View findRequiredView13 = Utils.findRequiredView(view, R.id.tv_park, "method 'onClickCategory'");
        this.view7f090530 = findRequiredView13;
        findRequiredView13.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment_ViewBinding.13
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchFragment.onClickCategory(view2);
            }
        });
        View findRequiredView14 = Utils.findRequiredView(view, R.id.tv_food, "method 'onClickCategory'");
        this.view7f090502 = findRequiredView14;
        findRequiredView14.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment_ViewBinding.14
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchFragment.onClickCategory(view2);
            }
        });
        View findRequiredView15 = Utils.findRequiredView(view, R.id.tv_wc, "method 'onClickCategory'");
        this.view7f09057a = findRequiredView15;
        findRequiredView15.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment_ViewBinding.15
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchFragment.onClickCategory(view2);
            }
        });
        View findRequiredView16 = Utils.findRequiredView(view, R.id.tv_expcenter, "method 'onClickCategory'");
        this.view7f0904f7 = findRequiredView16;
        findRequiredView16.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment_ViewBinding.16
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchFragment.onClickCategory(view2);
            }
        });
        View findRequiredView17 = Utils.findRequiredView(view, R.id.tv_server_center, "method 'onClickCategory'");
        this.view7f090551 = findRequiredView17;
        findRequiredView17.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment_ViewBinding.17
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchFragment.onClickCategory(view2);
            }
        });
        View findRequiredView18 = Utils.findRequiredView(view, R.id.tv_carwash, "method 'onClickCategory'");
        this.view7f0904d3 = findRequiredView18;
        findRequiredView18.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment_ViewBinding.18
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchFragment.onClickCategory(view2);
            }
        });
        View findRequiredView19 = Utils.findRequiredView(view, R.id.tv_fix, "method 'onClickCategory'");
        this.view7f090501 = findRequiredView19;
        findRequiredView19.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment_ViewBinding.19
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                searchFragment.onClickCategory(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchFragment searchFragment = this.target;
        if (searchFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        searchFragment.mSearchInputContainer = null;
        searchFragment.mBtnReturn = null;
        searchFragment.mViewHeadVerticalLine = null;
        searchFragment.mEtSearch = null;
        searchFragment.mIvClear = null;
        searchFragment.mAroundLeft = null;
        searchFragment.mAroundRight = null;
        searchFragment.mTvScanSearch = null;
        searchFragment.mTvScanSearchLine = null;
        searchFragment.mSearchFavoriteParent = null;
        searchFragment.mRecyclerViewHeader = null;
        searchFragment.mSearchHeaderLayout = null;
        searchFragment.mHomeContainer = null;
        searchFragment.mTvHome = null;
        searchFragment.mTvSetHome = null;
        searchFragment.mIvChangeHome = null;
        searchFragment.mTvHomeTipsDis = null;
        searchFragment.mTvHomeTipsTime = null;
        searchFragment.mTrafficBarHome = null;
        searchFragment.mOfficeContainer = null;
        searchFragment.mTvOffice = null;
        searchFragment.mTvSetOffice = null;
        searchFragment.mIvChangeOffice = null;
        searchFragment.mTvOfficeTipsDis = null;
        searchFragment.mTvOfficeTipsDisTime = null;
        searchFragment.mTrafficBarOffice = null;
        searchFragment.mFavoriteUpdateTime = null;
        searchFragment.mFavoriteContainer = null;
        searchFragment.mFavoriteNext = null;
        searchFragment.mTvFavorite = null;
        searchFragment.mSearchContainer = null;
        searchFragment.mSearchContainerSub = null;
        searchFragment.mFavoriteRecyclerView = null;
        searchFragment.mHistorySubContainer = null;
        searchFragment.mHistoryRecyclerView = null;
        searchFragment.mSearchTipStub = null;
        searchFragment.mHaveMoreDataDecorator = null;
        searchFragment.mPbHistoryLoad = null;
        searchFragment.mTvHistoryLoad = null;
        this.view7f0900b9.setOnClickListener(null);
        this.view7f0900b9 = null;
        this.view7f090176.setOnClickListener(null);
        this.view7f090176 = null;
        this.view7f09020d.setOnClickListener(null);
        this.view7f09020d = null;
        this.view7f090547.setOnClickListener(null);
        this.view7f090547 = null;
        this.view7f09010d.setOnClickListener(null);
        this.view7f09010d = null;
        this.view7f090207.setOnClickListener(null);
        this.view7f090207 = null;
        this.view7f09010f.setOnClickListener(null);
        this.view7f09010f = null;
        this.view7f090208.setOnClickListener(null);
        this.view7f090208 = null;
        this.view7f090109.setOnClickListener(null);
        this.view7f090109 = null;
        this.view7f090218.setOnClickListener(null);
        this.view7f090218 = null;
        this.view7f090084.setOnClickListener(null);
        this.view7f090084 = null;
        this.view7f0904d6.setOnClickListener(null);
        this.view7f0904d6 = null;
        this.view7f090530.setOnClickListener(null);
        this.view7f090530 = null;
        this.view7f090502.setOnClickListener(null);
        this.view7f090502 = null;
        this.view7f09057a.setOnClickListener(null);
        this.view7f09057a = null;
        this.view7f0904f7.setOnClickListener(null);
        this.view7f0904f7 = null;
        this.view7f090551.setOnClickListener(null);
        this.view7f090551 = null;
        this.view7f0904d3.setOnClickListener(null);
        this.view7f0904d3 = null;
        this.view7f090501.setOnClickListener(null);
        this.view7f090501 = null;
    }
}
