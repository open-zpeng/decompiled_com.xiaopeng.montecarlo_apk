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
import com.xiaopeng.xui.widget.XLoading;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class LinkPlatformFragment_ViewBinding implements Unbinder {
    private LinkPlatformFragment target;
    private View view7f09020e;

    @UiThread
    public LinkPlatformFragment_ViewBinding(final LinkPlatformFragment linkPlatformFragment, View view) {
        this.target = linkPlatformFragment;
        linkPlatformFragment.mLayoutMain = (XRelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_main_content, "field 'mLayoutMain'", XRelativeLayout.class);
        linkPlatformFragment.mTvTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", XTextView.class);
        linkPlatformFragment.mLayoutAgreement = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.layout_agreement, "field 'mLayoutAgreement'", XLinearLayout.class);
        linkPlatformFragment.mTvAgreement = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_agreement, "field 'mTvAgreement'", XTextView.class);
        linkPlatformFragment.mTvAgreementDeclare = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_agreement_declare, "field 'mTvAgreementDeclare'", XTextView.class);
        linkPlatformFragment.mTvBoundAccount = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_bound_account, "field 'mTvBoundAccount'", XTextView.class);
        linkPlatformFragment.mTvBindAction = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_bind_action, "field 'mTvBindAction'", XTextView.class);
        linkPlatformFragment.mFailLayout = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_fail, "field 'mFailLayout'", XLinearLayout.class);
        linkPlatformFragment.mIvFail = (XImageView) Utils.findRequiredViewAsType(view, R.id.iv_fail, "field 'mIvFail'", XImageView.class);
        linkPlatformFragment.mTvFail = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_fail_explain, "field 'mTvFail'", XTextView.class);
        linkPlatformFragment.mTvRefresh = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_refresh, "field 'mTvRefresh'", XTextView.class);
        linkPlatformFragment.mLoadingView = (XLoading) Utils.findRequiredViewAsType(view, R.id.loading, "field 'mLoadingView'", XLoading.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_close, "field 'mIbClose' and method 'onClickClose'");
        linkPlatformFragment.mIbClose = (XImageButton) Utils.castView(findRequiredView, R.id.iv_close, "field 'mIbClose'", XImageButton.class);
        this.view7f09020e = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.LinkPlatformFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                linkPlatformFragment.onClickClose(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LinkPlatformFragment linkPlatformFragment = this.target;
        if (linkPlatformFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        linkPlatformFragment.mLayoutMain = null;
        linkPlatformFragment.mTvTitle = null;
        linkPlatformFragment.mLayoutAgreement = null;
        linkPlatformFragment.mTvAgreement = null;
        linkPlatformFragment.mTvAgreementDeclare = null;
        linkPlatformFragment.mTvBoundAccount = null;
        linkPlatformFragment.mTvBindAction = null;
        linkPlatformFragment.mFailLayout = null;
        linkPlatformFragment.mIvFail = null;
        linkPlatformFragment.mTvFail = null;
        linkPlatformFragment.mTvRefresh = null;
        linkPlatformFragment.mLoadingView = null;
        linkPlatformFragment.mIbClose = null;
        this.view7f09020e.setOnClickListener(null);
        this.view7f09020e = null;
    }
}
