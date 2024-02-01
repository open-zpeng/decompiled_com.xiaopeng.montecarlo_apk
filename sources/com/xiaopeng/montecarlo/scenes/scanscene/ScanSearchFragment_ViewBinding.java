package com.xiaopeng.montecarlo.scenes.scanscene;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class ScanSearchFragment_ViewBinding implements Unbinder {
    private ScanSearchFragment target;
    private View view7f0900f5;
    private View view7f090216;
    private View view7f090217;

    @UiThread
    public ScanSearchFragment_ViewBinding(final ScanSearchFragment scanSearchFragment, View view) {
        this.target = scanSearchFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.container, "field 'mContainer' and method 'onClickBack'");
        scanSearchFragment.mContainer = (XLinearLayout) Utils.castView(findRequiredView, R.id.container, "field 'mContainer'", XLinearLayout.class);
        this.view7f0900f5 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.scanscene.ScanSearchFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                scanSearchFragment.onClickBack();
            }
        });
        scanSearchFragment.mTvContent = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_scan_search_content, "field 'mTvContent'", XTextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.iv_scan_search_back, "field 'mIvScanSearchBack' and method 'onClickBack'");
        scanSearchFragment.mIvScanSearchBack = (XImageButton) Utils.castView(findRequiredView2, R.id.iv_scan_search_back, "field 'mIvScanSearchBack'", XImageButton.class);
        this.view7f090216 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.scanscene.ScanSearchFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                scanSearchFragment.onClickBack();
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.iv_scan_search_clear, "method 'onClickClose'");
        this.view7f090217 = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.scanscene.ScanSearchFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                scanSearchFragment.onClickClose();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ScanSearchFragment scanSearchFragment = this.target;
        if (scanSearchFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        scanSearchFragment.mContainer = null;
        scanSearchFragment.mTvContent = null;
        scanSearchFragment.mIvScanSearchBack = null;
        this.view7f0900f5.setOnClickListener(null);
        this.view7f0900f5 = null;
        this.view7f090216.setOnClickListener(null);
        this.view7f090216 = null;
        this.view7f090217.setOnClickListener(null);
        this.view7f090217 = null;
    }
}
