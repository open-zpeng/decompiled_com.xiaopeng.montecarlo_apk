package com.xiaopeng.montecarlo.scenes.settingscene;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.annotation.IdRes;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.BaseFullScenes;
import com.xiaopeng.montecarlo.base.BaseScene;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.constants.SystemConst;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.theme.ThemeType;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.settingscene.ISettingLicencePlateContract;
import com.xiaopeng.montecarlo.scenes.settingscene.SettingLicencePlatePresenter;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.keyboard.KeyboardView;
import com.xiaopeng.xui.widget.XEditText;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.Locale;
@SuppressLint({"ValidFragment"})
/* loaded from: classes3.dex */
public class SettingLicencePlateFragment extends BaseFullScenes implements ISettingLicencePlateContract.LogicView {
    private static final L.Tag TAG = new L.Tag("SettingLicencePlateFragment");
    @BindView(R.id.setting_license_plate_return_btn)
    XImageButton mBtnReturn;
    @BindView(R.id.setting_license_plate_hide_keyboardview_img)
    public XImageView mCloseView;
    private XEditText mEditView;
    @BindView(R.id.expand_text)
    public XTextView mExpandText;
    @BindView(R.id.setting_license_keyboardview_parent)
    public XLinearLayout mKeyboardParent;
    @BindView(R.id.setting_license_plate_keyboard_view)
    public KeyboardView mKeyboardView;
    @BindView(R.id.plate_container)
    public XLinearLayout mPlateContainer;
    @BindView(R.id.setting_license_plate_province_btn)
    public XTextView mProvinceBtn;
    private View mRootView;
    @BindView(R.id.setting_license_plate_save_btn)
    public XTextView mSaveBtn;
    private SettingLicencePlatePresenter mSettingLicencePlatePresenter;
    private Unbinder mUnBinder;

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void hide() {
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public boolean onSceneSaveInstanceState(Bundle bundle) {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void show() {
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean showCover() {
        return true;
    }

    public static BaseScene newInstance() {
        return new SettingLicencePlateFragment();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneCreate(Bundle bundle) {
        super.onSceneCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.DayNightFragment
    public void onThemeSwitchDelegate(ThemeType themeType) {
        super.onThemeSwitchDelegate(themeType);
        updateTheme(themeType);
    }

    private void updateTheme(ThemeType themeType) {
        refreshLicensePlate();
    }

    private void refreshLicensePlate() {
        if (TextUtils.isEmpty(this.mProvinceBtn.getText())) {
            return;
        }
        this.mKeyboardView.initLicencePlate(this.mProvinceBtn.getText().toString());
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDetach() {
        super.onSceneDetach();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    protected View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.fragment_setting_licence_plate, (ViewGroup) null);
        if (L.ENABLE) {
            L.d(TAG, "onCreateContentView");
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneResume() {
        super.onSceneResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onScenePause() {
        super.onScenePause();
    }

    protected void onInitView() {
        SettingLicencePlatePresenter settingLicencePlatePresenter = this.mSettingLicencePlatePresenter;
        if (settingLicencePlatePresenter != null) {
            settingLicencePlatePresenter.onCreate();
        }
    }

    @OnClick({R.id.setting_license_plate_save_btn})
    public void onClickLicencePlate() {
        Editable text = this.mEditView.getText();
        save(((Object) this.mProvinceBtn.getText()) + text.toString().toUpperCase(Locale.getDefault()));
    }

    @OnClick({R.id.setting_license_plate_hide_keyboardview_img})
    public void onClickHideKeyboardViewImg() {
        hiddenKeyboardView();
    }

    @OnClick({R.id.setting_license_plate_province_btn, R.id.setting_license_keyboard_btn})
    public void onClickPopKeyboardView() {
        popUpKeyboardView();
    }

    @OnClick({R.id.setting_license_plate_return_btn, R.id.container})
    public void onClickBack() {
        Bundle bundle = new Bundle();
        bundle.putString(SettingLicencePlatePresenter.KEY_SAVE_LICENCE_PLATE, SettingWrapper.getLicensePlate());
        setReturnResult(bundle);
        exitScene();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save(String str) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "save mLicencePlate =" + str);
        }
        SettingLicencePlatePresenter settingLicencePlatePresenter = this.mSettingLicencePlatePresenter;
        if (settingLicencePlatePresenter != null) {
            if (settingLicencePlatePresenter.save(str)) {
                Bundle bundle = getBridge().getBundle();
                if (bundle != null && bundle.getBoolean(SystemConst.IS_FROM_RESTRICT_TYPE_KEY, false)) {
                    SettingWrapper.openPlateSwitch();
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString(SettingLicencePlatePresenter.KEY_SAVE_LICENCE_PLATE, str);
                setReturnResult(bundle2);
                return;
            }
            showPrompt(getString(R.string.setting_license_plate_error_message));
        }
    }

    private void exitScene() {
        SettingLicencePlatePresenter settingLicencePlatePresenter = this.mSettingLicencePlatePresenter;
        if (settingLicencePlatePresenter != null) {
            settingLicencePlatePresenter.exitScene();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingLicencePlateContract.LogicView
    public void bindView() {
        this.mUnBinder = ButterKnife.bind(this, this.mRootView);
        this.mEditView = (XEditText) findViewById(R.id.setting_license_plate_edit_text);
        this.mEditView.setTransformationMethod(new AllCapTransformationMethod(true));
        this.mKeyboardView.addKeyboardCallback(new SettingLicencePlatePresenter.KeyboardOnclickListener(this));
        this.mEditView.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.SettingLicencePlateFragment.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    Editable text = SettingLicencePlateFragment.this.mEditView.getText();
                    SettingLicencePlateFragment.this.save(((Object) SettingLicencePlateFragment.this.mProvinceBtn.getText()) + text.toString().toUpperCase(Locale.getDefault()));
                    return true;
                }
                return false;
            }
        });
        this.mEditView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.SettingLicencePlateFragment.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    SettingLicencePlateFragment.this.hiddenKeyboardView();
                }
            }
        });
        initLicencePlate();
        SpannableString spannableString = new SpannableString(ContextUtils.getString(R.string.setting_licence_plate_hint_content));
        spannableString.setSpan(new AbsoluteSizeSpan(ContextUtils.getDimensionPixelSize(R.dimen.setting_license_plate_edit_text_hint_size), true), 0, spannableString.length(), 33);
        this.mEditView.setHint(spannableString);
        updateTheme(ThemeWatcherUtil.getCurrentTheme());
    }

    private View findViewById(@IdRes int i) {
        return this.mRootView.findViewById(i);
    }

    private void initLicencePlate() {
        String licensePlate = SettingWrapper.getLicensePlate();
        if (!TextUtils.isEmpty(licensePlate)) {
            String replaceAll = licensePlate.replaceAll(" ", "");
            if (replaceAll.length() > 0) {
                this.mProvinceBtn.setText(replaceAll.substring(0, 1));
            }
            if (replaceAll.length() > 1) {
                this.mEditView.setText(replaceAll.substring(1, replaceAll.length()));
                this.mEditView.requestFocus();
                showSystemKeyboard();
            }
        } else {
            popUpKeyboardView();
        }
        this.mKeyboardView.initLicencePlate(this.mProvinceBtn.getText().toString());
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingLicencePlateContract.LogicView
    public void unBindView() {
        KeyboardView keyboardView = this.mKeyboardView;
        if (keyboardView != null) {
            keyboardView.removeKeyboardCallback();
        }
        Unbinder unbinder = this.mUnBinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingLicencePlateContract.LogicView
    public void updateLicencePlateFirstValue(String str) {
        XTextView xTextView = this.mProvinceBtn;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingLicencePlateContract.LogicView
    public void focusPlateEdit() {
        this.mEditView.requestFocus();
        XEditText xEditText = this.mEditView;
        xEditText.setSelection(xEditText.getText().length());
        hiddenKeyboardView();
        showSystemKeyboard();
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    /* renamed from: getPresenter */
    public SettingLicencePlatePresenter mo118getPresenter() {
        return this.mSettingLicencePlatePresenter;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void setPresenter(SettingLicencePlatePresenter settingLicencePlatePresenter) {
        this.mSettingLicencePlatePresenter = settingLicencePlatePresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hiddenKeyboardView() {
        if (L.ENABLE) {
            L.d(TAG, "hiddenKeyboardView");
        }
        XLinearLayout xLinearLayout = this.mKeyboardParent;
        if (xLinearLayout != null) {
            xLinearLayout.setVisibility(4);
        }
    }

    private void popUpKeyboardView() {
        if (L.ENABLE) {
            L.d(TAG, "popUpKeyboardView");
        }
        XLinearLayout xLinearLayout = this.mKeyboardParent;
        if (xLinearLayout != null) {
            xLinearLayout.setVisibility(0);
        }
        this.mEditView.clearFocus();
        hideSystemKeyboard();
    }

    private void hideSystemKeyboard() {
        ((InputMethodManager) this.mRootView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mRootView.getWindowToken(), 0);
    }

    private void showSystemKeyboard() {
        ((InputMethodManager) this.mRootView.getContext().getSystemService("input_method")).showSoftInput(this.mEditView, 0);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneViewCreated(View view, Bundle bundle) {
        super.onSceneViewCreated(view, bundle);
        SettingLicencePlatePresenter settingLicencePlatePresenter = this.mSettingLicencePlatePresenter;
        if (settingLicencePlatePresenter != null) {
            settingLicencePlatePresenter.onResume();
        }
        onInitView();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroyView() {
        super.onSceneDestroyView();
        SettingLicencePlatePresenter settingLicencePlatePresenter = this.mSettingLicencePlatePresenter;
        if (settingLicencePlatePresenter != null) {
            settingLicencePlatePresenter.onPause();
        }
        hideSystemKeyboard();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean isSceneVuiEnabled() {
        return CommonVuiHelper.getInstance().isSceneVuiSupport();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.vui.commons.IVuiSceneListener
    public void onBuildScene() {
        CommonVuiHelper commonVuiHelper = CommonVuiHelper.getInstance();
        String string = ContextUtils.getString(R.string.vui_general_action_system_close_return);
        MainContext mainContext = getMainContext();
        XImageButton xImageButton = this.mBtnReturn;
        commonVuiHelper.markGeneralAction(string, mainContext, xImageButton, xImageButton, false);
        super.onBuildScene();
    }
}
