package com.xiaopeng.montecarlo.scenes.settingscene;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.views.keyboard.KeyboardView;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class SettingLicencePlateFragment_ViewBinding implements Unbinder {
    private SettingLicencePlateFragment target;
    private View view7f0900f5;
    private View view7f0903f2;
    private View view7f0903f6;
    private View view7f0903f8;
    private View view7f0903f9;
    private View view7f0903fa;

    @UiThread
    public SettingLicencePlateFragment_ViewBinding(final SettingLicencePlateFragment settingLicencePlateFragment, View view) {
        this.target = settingLicencePlateFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.setting_license_plate_return_btn, "field 'mBtnReturn' and method 'onClickBack'");
        settingLicencePlateFragment.mBtnReturn = (XImageButton) Utils.castView(findRequiredView, R.id.setting_license_plate_return_btn, "field 'mBtnReturn'", XImageButton.class);
        this.view7f0903f9 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.SettingLicencePlateFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingLicencePlateFragment.onClickBack();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.setting_license_plate_province_btn, "field 'mProvinceBtn' and method 'onClickPopKeyboardView'");
        settingLicencePlateFragment.mProvinceBtn = (XTextView) Utils.castView(findRequiredView2, R.id.setting_license_plate_province_btn, "field 'mProvinceBtn'", XTextView.class);
        this.view7f0903f8 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.SettingLicencePlateFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingLicencePlateFragment.onClickPopKeyboardView();
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.setting_license_plate_save_btn, "field 'mSaveBtn' and method 'onClickLicencePlate'");
        settingLicencePlateFragment.mSaveBtn = (XTextView) Utils.castView(findRequiredView3, R.id.setting_license_plate_save_btn, "field 'mSaveBtn'", XTextView.class);
        this.view7f0903fa = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.SettingLicencePlateFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingLicencePlateFragment.onClickLicencePlate();
            }
        });
        settingLicencePlateFragment.mKeyboardParent = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.setting_license_keyboardview_parent, "field 'mKeyboardParent'", XLinearLayout.class);
        settingLicencePlateFragment.mKeyboardView = (KeyboardView) Utils.findRequiredViewAsType(view, R.id.setting_license_plate_keyboard_view, "field 'mKeyboardView'", KeyboardView.class);
        settingLicencePlateFragment.mPlateContainer = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.plate_container, "field 'mPlateContainer'", XLinearLayout.class);
        settingLicencePlateFragment.mExpandText = (XTextView) Utils.findRequiredViewAsType(view, R.id.expand_text, "field 'mExpandText'", XTextView.class);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.setting_license_plate_hide_keyboardview_img, "field 'mCloseView' and method 'onClickHideKeyboardViewImg'");
        settingLicencePlateFragment.mCloseView = (XImageView) Utils.castView(findRequiredView4, R.id.setting_license_plate_hide_keyboardview_img, "field 'mCloseView'", XImageView.class);
        this.view7f0903f6 = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.SettingLicencePlateFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingLicencePlateFragment.onClickHideKeyboardViewImg();
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.setting_license_keyboard_btn, "method 'onClickPopKeyboardView'");
        this.view7f0903f2 = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.SettingLicencePlateFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingLicencePlateFragment.onClickPopKeyboardView();
            }
        });
        View findRequiredView6 = Utils.findRequiredView(view, R.id.container, "method 'onClickBack'");
        this.view7f0900f5 = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.SettingLicencePlateFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingLicencePlateFragment.onClickBack();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SettingLicencePlateFragment settingLicencePlateFragment = this.target;
        if (settingLicencePlateFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        settingLicencePlateFragment.mBtnReturn = null;
        settingLicencePlateFragment.mProvinceBtn = null;
        settingLicencePlateFragment.mSaveBtn = null;
        settingLicencePlateFragment.mKeyboardParent = null;
        settingLicencePlateFragment.mKeyboardView = null;
        settingLicencePlateFragment.mPlateContainer = null;
        settingLicencePlateFragment.mExpandText = null;
        settingLicencePlateFragment.mCloseView = null;
        this.view7f0903f9.setOnClickListener(null);
        this.view7f0903f9 = null;
        this.view7f0903f8.setOnClickListener(null);
        this.view7f0903f8 = null;
        this.view7f0903fa.setOnClickListener(null);
        this.view7f0903fa = null;
        this.view7f0903f6.setOnClickListener(null);
        this.view7f0903f6 = null;
        this.view7f0903f2.setOnClickListener(null);
        this.view7f0903f2 = null;
        this.view7f0900f5.setOnClickListener(null);
        this.view7f0900f5 = null;
    }
}
