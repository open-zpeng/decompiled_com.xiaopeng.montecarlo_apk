package com.xiaopeng.montecarlo.scenes.restrictscene;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.views.DetailRestrictRulesView;
import com.xiaopeng.xui.view.XView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
/* loaded from: classes3.dex */
public class RestrictFragment_ViewBinding implements Unbinder {
    private RestrictFragment target;
    private View view7f090354;

    @UiThread
    public RestrictFragment_ViewBinding(final RestrictFragment restrictFragment, View view) {
        this.target = restrictFragment;
        restrictFragment.mRestrictDetailPageview = (DetailRestrictRulesView) Utils.findRequiredViewAsType(view, R.id.restrict_detail_pageview, "field 'mRestrictDetailPageview'", DetailRestrictRulesView.class);
        restrictFragment.mUnderlineView = (XView) Utils.findRequiredViewAsType(view, R.id.underline_view, "field 'mUnderlineView'", XView.class);
        restrictFragment.mRestrictCityTitleList = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.restrict_city_title, "field 'mRestrictCityTitleList'", XLinearLayout.class);
        restrictFragment.mRestrictContainer = (XRelativeLayout) Utils.findRequiredViewAsType(view, R.id.restrict_container, "field 'mRestrictContainer'", XRelativeLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.restrict_detail_close, "method 'onClickClose'");
        this.view7f090354 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.restrictscene.RestrictFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                restrictFragment.onClickClose();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RestrictFragment restrictFragment = this.target;
        if (restrictFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        restrictFragment.mRestrictDetailPageview = null;
        restrictFragment.mUnderlineView = null;
        restrictFragment.mRestrictCityTitleList = null;
        restrictFragment.mRestrictContainer = null;
        this.view7f090354.setOnClickListener(null);
        this.view7f090354 = null;
    }
}
