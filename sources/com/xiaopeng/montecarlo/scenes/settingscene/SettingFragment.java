package com.xiaopeng.montecarlo.scenes.settingscene;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.account.AccountManager;
import com.xiaopeng.montecarlo.base.BaseFullScenes;
import com.xiaopeng.montecarlo.base.BaseScene;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.setting.constant.MinimapTypeEnum;
import com.xiaopeng.montecarlo.navcore.setting.constant.NaviBroadcastTypeEnum;
import com.xiaopeng.montecarlo.root.account.AccountEventCallback;
import com.xiaopeng.montecarlo.root.account.AccountObservable;
import com.xiaopeng.montecarlo.root.account.AccountObserver;
import com.xiaopeng.montecarlo.root.account.UserInfo;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.searchscene.TopSmoothScroller;
import com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.SettingPreferenceAdapterView;
import com.xiaopeng.montecarlo.stat.SettingStatUtil;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.montecarlo.views.XpLinearLayoutManager;
import com.xiaopeng.montecarlo.views.dialog.XNoTitleDialog;
import com.xiaopeng.vui.commons.model.VuiEvent;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XRecyclerView;
import com.xiaopeng.xui.widget.XTextView;
import java.lang.ref.WeakReference;
import java.util.Observable;
@SuppressLint({"ValidFragment"})
/* loaded from: classes3.dex */
public class SettingFragment extends BaseFullScenes implements ISettingContract.LogicView, AccountObserver {
    private static final L.Tag TAG = new L.Tag("SettingF");
    private AccountEventCallback mAccountEventCallback = new AccountEventCallbackImpl();
    private SettingPreferenceAdapterView mAdapter;
    @BindView(R.id.btn_return)
    XImageButton mBtnReturn;
    private LinearLayoutManager mLayoutManager;
    @BindView(R.id.setting_left_main_tab)
    XTextView mMainTabView;
    @BindView(R.id.setting_left_more_tab)
    XTextView mOtherTabView;
    @BindView(R.id.recycler_view_setting_preference)
    XRecyclerView mRecyclerView;
    private View mRootView;
    private TopSmoothScroller mScroller;
    private SettingPreferencePresenter mSettingPreferencePresenter;
    @BindView(R.id.setting_title)
    XTextView mSettingTitle;
    private Unbinder mUnbinder;

    private boolean isSelectView(int i, int i2) {
        return (i & i2) != 0;
    }

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
        return new SettingFragment();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneCreate(Bundle bundle) {
        super.onSceneCreate(bundle);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDetach() {
        super.onSceneDetach();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneActivityCreated(@Nullable Bundle bundle) {
        super.onSceneActivityCreated(bundle);
        XPAccountServiceWrapper.getInstance().registerAccountEventCallback(this.mAccountEventCallback);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    protected View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.fragment_setting, viewGroup, true);
        this.mUnbinder = ButterKnife.bind(this, this.mRootView);
        AccountObservable.getInstance().addObserver(this);
        this.mAdapter = new SettingPreferenceAdapterView(getContext(), this);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mLayoutManager = new XpLinearLayoutManager(getContext(), new XpLinearLayoutManager.XpLinearLayoutManagerListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.SettingFragment.1
            @Override // com.xiaopeng.montecarlo.views.XpLinearLayoutManager.XpLinearLayoutManagerListener
            public void onLayoutCompleted() {
                SettingFragment.this.executeOnRecyclerViewLayoutCompleted();
            }
        });
        this.mScroller = new TopSmoothScroller(getActivity());
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.addItemDecoration(new SpacesItemDecoration(R.dimen.setting_item_card_group_top_margin));
        this.mRecyclerView.addOnScrollListener(new SettingRecyclerViewScrollListener());
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeOnRecyclerViewLayoutCompleted() {
        if (L.ENABLE) {
            L.d(TAG, "executeOnRecyclerViewLayoutCompleted");
        }
        updateSceneWithView(this.mRecyclerView);
    }

    protected void onInitView() {
        SettingPreferencePresenter settingPreferencePresenter = this.mSettingPreferencePresenter;
        if (settingPreferencePresenter != null) {
            settingPreferencePresenter.onCreate();
        }
        renderSettingByThemeSwitch(this.mCurrentSceneTheme);
        updateCarLogo();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneViewCreated(View view, Bundle bundle) {
        super.onSceneViewCreated(view, bundle);
        SettingPreferencePresenter settingPreferencePresenter = this.mSettingPreferencePresenter;
        if (settingPreferencePresenter != null) {
            settingPreferencePresenter.onResume();
        }
        if (getCurrentSceneMode() == StatusConst.Mode.CRUISE) {
            getMainContext().getAiMsgManager().setOnlyMapShow(false);
        }
        onInitView();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroyView() {
        super.onSceneDestroyView();
        SettingPreferencePresenter settingPreferencePresenter = this.mSettingPreferencePresenter;
        if (settingPreferencePresenter != null) {
            settingPreferencePresenter.onPause();
        }
        SettingPreferencePresenter settingPreferencePresenter2 = this.mSettingPreferencePresenter;
        if (settingPreferencePresenter2 != null) {
            settingPreferencePresenter2.onDestroy();
        }
        AccountObservable.getInstance().deleteObserver(this);
        if (getCurrentSceneMode() == StatusConst.Mode.CRUISE) {
            getMainContext().getAiMsgManager().setOnlyMapShow(true);
        }
        XPAccountServiceWrapper.getInstance().unRegisterAccountEventCallback(this.mAccountEventCallback);
        XRecyclerView xRecyclerView = this.mRecyclerView;
        if (xRecyclerView != null) {
            xRecyclerView.setAdapter(null);
        }
        SettingPreferenceAdapterView settingPreferenceAdapterView = this.mAdapter;
        if (settingPreferenceAdapterView != null) {
            settingPreferenceAdapterView.release();
            this.mAdapter = null;
        }
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    /* renamed from: getPresenter */
    public SettingPreferencePresenter mo116getPresenter() {
        return this.mSettingPreferencePresenter;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void setPresenter(SettingPreferencePresenter settingPreferencePresenter) {
        this.mSettingPreferencePresenter = settingPreferencePresenter;
    }

    @OnClick({R.id.btn_return, R.id.base_scene, R.id.setting_left_main_tab, R.id.setting_left_more_tab})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.base_scene /* 2131296388 */:
            case R.id.btn_return /* 2131296441 */:
                if (preventMultiClick(view)) {
                    this.mSettingPreferencePresenter.exitScene();
                    return;
                }
                return;
            case R.id.setting_left_main_tab /* 2131297264 */:
                this.mScroller.setTargetPosition(0);
                this.mLayoutManager.startSmoothScroll(this.mScroller);
                this.mMainTabView.setSelected(true);
                this.mOtherTabView.setSelected(false);
                return;
            case R.id.setting_left_more_tab /* 2131297265 */:
                this.mScroller.setTargetPosition(this.mAdapter.getOtherTabPosition());
                this.mLayoutManager.startSmoothScroll(this.mScroller);
                this.mMainTabView.setSelected(false);
                this.mOtherTabView.setSelected(true);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.LogicView
    public void delUserData() {
        if (this.mSettingPreferencePresenter == null) {
            return;
        }
        SettingStatUtil.sendStatDataDelUserData();
        XNoTitleDialog xNoTitleDialog = new XNoTitleDialog(getActivity());
        xNoTitleDialog.setOkButtonText(R.string.ok_del_btn);
        if (this.mSettingPreferencePresenter.isXPAccountLogin() && this.mSettingPreferencePresenter.getBindAMapStatus()) {
            xNoTitleDialog.setContentText(R.string.favorite_delete_all_dialog_title);
        } else {
            xNoTitleDialog.setContentText(R.string.setting_del_user_history_data);
        }
        xNoTitleDialog.setOkButtonClickListener(new XNoTitleOkBtnAction(this, xNoTitleDialog));
        xNoTitleDialog.setCancelButtonClickListener(new XNoTitleCancelBtnAction(xNoTitleDialog));
        xNoTitleDialog.show();
        if (isSceneVuiEnabled()) {
            CommonVuiHelper.getInstance().addDialogVuiSupport(xNoTitleDialog, "DelUserData");
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.LogicView
    public void restoreDefaultData(boolean z) {
        this.mSettingPreferencePresenter.resetDefaultSetting();
        SettingStatUtil.sendStatDataOnClickReset(z);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.LogicView
    public void bindView(ISettingContract.BindViewParam bindViewParam) {
        if (this.mRootView == null || bindViewParam == null) {
            return;
        }
        resetView(bindViewParam.mValue);
        this.mAdapter.getProvider().setMapVersionDescription(bindViewParam.mMapContent);
        this.mAdapter.switchXpengGuideIcon(bindViewParam.mIsXPAccountLog);
        this.mAdapter.switchMapBindGuideIcon(bindViewParam.mBindXPAccountStatus);
        this.mSettingPreferencePresenter.checkBindAmapStatus();
        this.mMainTabView.setSelected(true);
        this.mAdapter.setLicencePlate(bindViewParam.mLicencePlate);
        this.mSettingPreferencePresenter.toggleLicencePlate(bindViewParam.mLicencePlate);
        this.mAdapter.getProvider().setMapVersion(getString(R.string.setting_map_version_explanation_content, this.mSettingPreferencePresenter.getVersionName()));
        this.mAdapter.getProvider().setMapDownloadSize(this.mSettingPreferencePresenter.getMapDownloadSize());
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.LogicView
    public void updateNaviGuider() {
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.SettingFragment.2
            @Override // java.lang.Runnable
            public void run() {
                if (SettingFragment.this.mSettingPreferencePresenter.isXPAccountLogin()) {
                    SettingFragment.this.mAdapter.switchMapBindGuideIcon(SettingFragment.this.mSettingPreferencePresenter.getBindAMapStatus());
                    return;
                }
                AccountManager.getInstance().logoutAMapAccount();
                SettingFragment.this.mAdapter.switchMapBindGuideIcon(false);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.LogicView
    public void updateMapDownloadSize(long j) {
        this.mAdapter.updateMapDownloadSize(j);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.LogicView
    public void unBindView() {
        this.mUnbinder.unbind();
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.LogicView
    public void updateLicencePlate(String str, boolean z) {
        if (!z) {
            SettingStatUtil.sendStatDataSavePlate(true, str);
        }
        this.mAdapter.setLicencePlate(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onBackResult(int i, Bundle bundle) {
        this.mSettingPreferencePresenter.onBackResult(i, bundle);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bindmap account update = " + GsonUtil.toJson(obj));
        }
        UserInfo userInfo = (UserInfo) obj;
        if (userInfo == null || userInfo.getInfoType() != UserInfo.InfoType.CHANGED) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "bindmap account update is change usertype=" + userInfo.getUserType());
        }
        boolean isAccountGuest = this.mSettingPreferencePresenter.isAccountGuest();
        SettingStatUtil.sendStatDataMsgLoginXPAccount(!isAccountGuest);
        if (!isAccountGuest) {
            SettingStatUtil.sendStatDataLoginXPAccount();
        }
        this.mAdapter.switchXpengGuideIcon(!isAccountGuest);
        this.mAdapter.switchMapBindGuideIcon(SettingWrapper.getBindAMapStatus() && !isAccountGuest);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.LogicView
    public void resetView(int i) {
        boolean z = true;
        this.mAdapter.getProvider().setAvoidCongestionEnable(isSelectView(i, 1));
        this.mAdapter.getProvider().setAvoidChargeEnable(isSelectView(i, 2));
        this.mAdapter.getProvider().setNoFreewaysEnable(isSelectView(i, 4));
        this.mAdapter.getProvider().setHighwayPriorityEnable(isSelectView(i, 8));
        this.mAdapter.getProvider().setCruiseAheadTrafficEnable(isSelectView(i, 64));
        this.mAdapter.getProvider().setCruiseElectronicEyeBroadcastEnable(isSelectView(i, 128));
        this.mAdapter.getProvider().setCruiseSafetyBroadcastEnable(isSelectView(i, 256));
        this.mAdapter.getProvider().setRouteRadarEnable(isSelectView(i, 1024));
        this.mAdapter.getProvider().setChargingStationDisplayEnable(isSelectView(i, 16384));
        this.mAdapter.getProvider().setRealTimeTrafficEnable(isSelectView(i, 32768));
        this.mAdapter.getProvider().setScratchSpotEnable(isSelectView(i, 8388608));
        this.mAdapter.getProvider().setMapDataAutoUpdateEnable(isSelectView(i, 65536));
        this.mAdapter.getProvider().setMapDynamicLevelEnable(isSelectView(i, 131072));
        this.mAdapter.getProvider().setRecommendParkEnable(isSelectView(i, 16777216));
        this.mAdapter.getProvider().setAvoidRestrictionRouteEnable((!isSelectView(i, 512) || TextUtils.isEmpty(SettingWrapper.getLicensePlate())) ? false : false);
        if (isSelectView(i, 16)) {
            this.mAdapter.getProvider().setNaviBroadcastType(NaviBroadcastTypeEnum.NAVI_DETAIL_BROADCAST);
        } else if (isSelectView(i, 32)) {
            this.mAdapter.getProvider().setNaviBroadcastType(NaviBroadcastTypeEnum.NAVI_NORMAL_BROADCAST);
        } else if (isSelectView(i, 1048576)) {
            this.mAdapter.getProvider().setNaviBroadcastType(NaviBroadcastTypeEnum.NAVI_SIMPLE_BROADCAST);
        }
        if (isSelectView(i, 4194304)) {
            this.mAdapter.getProvider().setMinimapTypeEnum(MinimapTypeEnum.MINIMAP_MAPMODE_2D_CAR);
        } else if (isSelectView(i, 2097152)) {
            this.mAdapter.getProvider().setMinimapTypeEnum(MinimapTypeEnum.MINIMAP_MAPMODE_3D_CAR);
        }
        this.mAdapter.notifyDataSetChanged();
        updateCarLogo();
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.LogicView
    public void controlRestrictSwitchView(boolean z) {
        this.mAdapter.switchAvoidLimitRoute(z);
        if (z) {
            SettingStatUtil.sendStatDataAvoidRestrictionRoute(z);
            modifySettingPreference(9, z);
            saveSettingPreference();
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public PageType getPageType() {
        return PageType.SETTING;
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.LogicView
    public void enableCharge(boolean z) {
        getMainContext().onChargeEnableChanged(z);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.LogicView
    public void enableScratchSpot(boolean z) {
        getMainContext().onScratchSpotChanged(z);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.LogicView
    public void updateCarLogo() {
        this.mAdapter.updateCarLogo(SettingWrapper.getCarLogo());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.DayNightFragment
    public void onThemeSwitchDelegate(int i) {
        super.onThemeSwitchDelegate(i);
        renderSettingByThemeSwitch(i);
    }

    private void renderSettingByThemeSwitch(int i) {
        renderTextColorByTheme();
    }

    private void renderTextColorByTheme() {
        Drawable drawable = ThemeWatcherUtil.getDrawable(R.drawable.selector_setting_left_main_tab_img);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        if (Utils.isLandscape()) {
            this.mMainTabView.setCompoundDrawables(drawable, null, null, null);
        } else {
            this.mMainTabView.setCompoundDrawables(null, drawable, null, null);
        }
        Drawable drawable2 = ThemeWatcherUtil.getDrawable(R.drawable.selector_setting_left_more_tab_img);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        if (Utils.isLandscape()) {
            this.mOtherTabView.setCompoundDrawables(drawable2, null, null, null);
        } else {
            this.mOtherTabView.setCompoundDrawables(null, drawable2, null, null);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.LogicView
    public void onDelUserData(boolean z) {
        showPrompt(z ? R.string.del_user_data_sucess : R.string.del_user_data_fail);
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

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.LogicView
    public void modifySettingPreference(int i, boolean z) {
        this.mSettingPreferencePresenter.modifySettingPreference(i, z);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.LogicView
    public void saveSettingPreference() {
        saveSettingPreference(null);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.LogicView
    public void saveSettingPreference(ISettingCallback iSettingCallback) {
        this.mSettingPreferencePresenter.saveSettingPreference();
        if (iSettingCallback != null) {
            iSettingCallback.onFinish(this.mSettingPreferencePresenter.getSettingPreferenceValue());
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.LogicView
    public void updateSceneWithView(View view) {
        if (isSceneVuiEnabled()) {
            VoiceFullScenesUtil.updateScene(this, view);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.LogicView
    public void scrollToEnd() {
        this.mScroller.setTargetPosition(this.mAdapter.getItemCount() - 1);
        this.mLayoutManager.startSmoothScroll(this.mScroller);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingContract.LogicView
    public void showSettingToast(String str) {
        showPrompt(str);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.vui.commons.IVuiSceneListener
    public boolean onInterceptVuiEvent(View view, VuiEvent vuiEvent) {
        if (view != null && this.mAdapter != null && (R.id.setting_map_data_update_switch_btn == view.getId() || R.id.setting_scratch_spot_switch_btn == view.getId())) {
            view.setPressed(true);
        }
        return super.onInterceptVuiEvent(view, vuiEvent);
    }

    /* loaded from: classes3.dex */
    private class XNoTitleOkBtnAction implements View.OnClickListener {
        private XNoTitleDialog mDialog;
        private WeakReference<SettingFragment> mReference;

        public XNoTitleOkBtnAction(SettingFragment settingFragment, XNoTitleDialog xNoTitleDialog) {
            this.mReference = new WeakReference<>(settingFragment);
            this.mDialog = xNoTitleDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SettingFragment settingFragment = this.mReference.get();
            if (settingFragment != null) {
                settingFragment.mSettingPreferencePresenter.deleteUserData();
            }
            SettingStatUtil.sendStatDataSecdCofrimDelUserData();
            this.mDialog.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    private class XNoTitleCancelBtnAction implements View.OnClickListener {
        private XNoTitleDialog mDialog;

        public XNoTitleCancelBtnAction(XNoTitleDialog xNoTitleDialog) {
            this.mDialog = xNoTitleDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SettingStatUtil.sendStatDataCancleUserData();
            this.mDialog.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    private class SettingRecyclerViewScrollListener extends RecyclerView.OnScrollListener {
        private SettingRecyclerViewScrollListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            if (SettingFragment.this.isSceneLegal()) {
                if ((i == 0 || i == 1) && SettingFragment.this.mLayoutManager != null && SettingFragment.this.mAdapter != null) {
                    boolean z = SettingFragment.this.mLayoutManager.findFirstVisibleItemPosition() >= SettingFragment.this.mAdapter.getOtherTabPosition();
                    if (SettingFragment.this.mMainTabView != null && SettingFragment.this.mOtherTabView != null) {
                        SettingFragment.this.mMainTabView.setSelected(!z);
                        SettingFragment.this.mOtherTabView.setSelected(z);
                    }
                }
                if (i == 0) {
                    SettingFragment.this.updateScene();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int mSpace;

        SpacesItemDecoration(int i) {
            this.mSpace = ContextUtils.getDimensionPixelSize(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.bottom = this.mSpace;
        }
    }

    /* loaded from: classes3.dex */
    private class AccountEventCallbackImpl implements AccountEventCallback {
        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void accountSyncFinish() {
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void amapQuickLogin() {
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void initAccountFinish() {
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void xpMapLogin() {
        }

        private AccountEventCallbackImpl() {
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void refreshSettingInfos(int i, int i2) {
            SettingFragment.this.mSettingPreferencePresenter.refreshSettingView();
        }
    }
}
