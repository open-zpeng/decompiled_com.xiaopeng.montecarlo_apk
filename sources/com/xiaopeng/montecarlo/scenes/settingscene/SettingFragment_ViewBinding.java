package com.xiaopeng.montecarlo.scenes.settingscene;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XRecyclerView;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class SettingFragment_ViewBinding implements Unbinder {
    private SettingFragment target;
    private View view7f090084;
    private View view7f0900b9;
    private View view7f0903f0;
    private View view7f0903f1;

    @UiThread
    public SettingFragment_ViewBinding(final SettingFragment settingFragment, View view) {
        this.target = settingFragment;
        settingFragment.mSettingTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.setting_title, "field 'mSettingTitle'", XTextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.setting_left_main_tab, "field 'mMainTabView' and method 'onClick'");
        settingFragment.mMainTabView = (XTextView) Utils.castView(findRequiredView, R.id.setting_left_main_tab, "field 'mMainTabView'", XTextView.class);
        this.view7f0903f0 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.SettingFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onClick(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.setting_left_more_tab, "field 'mOtherTabView' and method 'onClick'");
        settingFragment.mOtherTabView = (XTextView) Utils.castView(findRequiredView2, R.id.setting_left_more_tab, "field 'mOtherTabView'", XTextView.class);
        this.view7f0903f1 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.SettingFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onClick(view2);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.btn_return, "field 'mBtnReturn' and method 'onClick'");
        settingFragment.mBtnReturn = (XImageButton) Utils.castView(findRequiredView3, R.id.btn_return, "field 'mBtnReturn'", XImageButton.class);
        this.view7f0900b9 = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.SettingFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onClick(view2);
            }
        });
        settingFragment.mRecyclerView = (XRecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view_setting_preference, "field 'mRecyclerView'", XRecyclerView.class);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.base_scene, "method 'onClick'");
        this.view7f090084 = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.SettingFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SettingFragment settingFragment = this.target;
        if (settingFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        settingFragment.mSettingTitle = null;
        settingFragment.mMainTabView = null;
        settingFragment.mOtherTabView = null;
        settingFragment.mBtnReturn = null;
        settingFragment.mRecyclerView = null;
        this.view7f0903f0.setOnClickListener(null);
        this.view7f0903f0 = null;
        this.view7f0903f1.setOnClickListener(null);
        this.view7f0903f1 = null;
        this.view7f0900b9.setOnClickListener(null);
        this.view7f0900b9 = null;
        this.view7f090084.setOnClickListener(null);
        this.view7f090084 = null;
    }
}
