package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRecyclerView;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class LinkSeamlessNaviFragment_ViewBinding implements Unbinder {
    private LinkSeamlessNaviFragment target;
    private View view7f09020e;

    @UiThread
    public LinkSeamlessNaviFragment_ViewBinding(final LinkSeamlessNaviFragment linkSeamlessNaviFragment, View view) {
        this.target = linkSeamlessNaviFragment;
        linkSeamlessNaviFragment.mLayoutMain = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_main_content, "field 'mLayoutMain'", XLinearLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_close, "field 'mIbClose' and method 'onClickClose'");
        linkSeamlessNaviFragment.mIbClose = (XImageButton) Utils.castView(findRequiredView, R.id.iv_close, "field 'mIbClose'", XImageButton.class);
        this.view7f09020e = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.LinkSeamlessNaviFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                linkSeamlessNaviFragment.onClickClose(view2);
            }
        });
        linkSeamlessNaviFragment.mTitleView = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleView'", XTextView.class);
        linkSeamlessNaviFragment.mBootstrapIv = (XImageView) Utils.findRequiredViewAsType(view, R.id.iv_bootstrap, "field 'mBootstrapIv'", XImageView.class);
        linkSeamlessNaviFragment.mTvGuideTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_guide_title, "field 'mTvGuideTitle'", XTextView.class);
        linkSeamlessNaviFragment.mTvGuideSubtitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_guide_subtitle, "field 'mTvGuideSubtitle'", XTextView.class);
        linkSeamlessNaviFragment.mPlatformRv = (XRecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_support_platform, "field 'mPlatformRv'", XRecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LinkSeamlessNaviFragment linkSeamlessNaviFragment = this.target;
        if (linkSeamlessNaviFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        linkSeamlessNaviFragment.mLayoutMain = null;
        linkSeamlessNaviFragment.mIbClose = null;
        linkSeamlessNaviFragment.mTitleView = null;
        linkSeamlessNaviFragment.mBootstrapIv = null;
        linkSeamlessNaviFragment.mTvGuideTitle = null;
        linkSeamlessNaviFragment.mTvGuideSubtitle = null;
        linkSeamlessNaviFragment.mPlatformRv = null;
        this.view7f09020e.setOnClickListener(null);
        this.view7f09020e = null;
    }
}
