package com.xiaopeng.montecarlo.scenes.restrictscene;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.views.DetailRestrictRulesLandView;
import com.xiaopeng.xui.view.XView;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
/* loaded from: classes3.dex */
public class RestrictLandFragment_ViewBinding implements Unbinder {
    private RestrictLandFragment target;
    private View view7f090354;

    @UiThread
    public RestrictLandFragment_ViewBinding(final RestrictLandFragment restrictLandFragment, View view) {
        this.target = restrictLandFragment;
        restrictLandFragment.mRestrictDetailPageview = (DetailRestrictRulesLandView) Utils.findRequiredViewAsType(view, R.id.restrict_detail_pageview, "field 'mRestrictDetailPageview'", DetailRestrictRulesLandView.class);
        restrictLandFragment.mUnderlineView = (XView) Utils.findRequiredViewAsType(view, R.id.underline_view, "field 'mUnderlineView'", XView.class);
        restrictLandFragment.mRestrictCityTitleList = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.restrict_city_title, "field 'mRestrictCityTitleList'", XLinearLayout.class);
        restrictLandFragment.mRestrictContainer = (XRelativeLayout) Utils.findRequiredViewAsType(view, R.id.restrict_container, "field 'mRestrictContainer'", XRelativeLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.restrict_detail_close, "field 'mRestrictDetailClose' and method 'onClickClose'");
        restrictLandFragment.mRestrictDetailClose = (XImageButton) Utils.castView(findRequiredView, R.id.restrict_detail_close, "field 'mRestrictDetailClose'", XImageButton.class);
        this.view7f090354 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.restrictscene.RestrictLandFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                restrictLandFragment.onClickClose();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RestrictLandFragment restrictLandFragment = this.target;
        if (restrictLandFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        restrictLandFragment.mRestrictDetailPageview = null;
        restrictLandFragment.mUnderlineView = null;
        restrictLandFragment.mRestrictCityTitleList = null;
        restrictLandFragment.mRestrictContainer = null;
        restrictLandFragment.mRestrictDetailClose = null;
        this.view7f090354.setOnClickListener(null);
        this.view7f090354 = null;
    }
}
