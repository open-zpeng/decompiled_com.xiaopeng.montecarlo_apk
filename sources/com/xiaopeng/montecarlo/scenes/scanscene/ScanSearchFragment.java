package com.xiaopeng.montecarlo.scenes.scanscene;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.autonavi.gbl.common.model.RectInt;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.base.BaseMapScene;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.mapscene.MapUIStatus;
import com.xiaopeng.montecarlo.scenes.scanscene.IScanSearchContract;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.xui.utils.XInputUtils;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class ScanSearchFragment extends BaseMapScene implements IScanSearchContract.LogicView {
    private static final L.Tag TAG = new L.Tag("ScanSearchFragment");
    private Unbinder mButterBinder;
    @BindView(R.id.container)
    XLinearLayout mContainer;
    @BindView(R.id.iv_scan_search_back)
    XImageButton mIvScanSearchBack;
    private ScanSearchPresenter mPresenter;
    @BindView(R.id.tv_scan_search_content)
    XTextView mTvContent;

    @Override // com.xiaopeng.montecarlo.scenes.scanscene.IScanSearchContract.LogicView
    public BaseBridge getBaseBridge() {
        return null;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    /* renamed from: getPresenter */
    public ScanSearchPresenter mo96getPresenter() {
        return null;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void hide() {
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes
    public boolean isNeedMergeBaseMapViewForVui() {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void show() {
    }

    public static ScanSearchFragment newInstance() {
        return new ScanSearchFragment();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    protected View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_scan_search, (ViewGroup) null, false);
        this.mButterBinder = ButterKnife.bind(this, inflate);
        XInputUtils.ignoreHiddenInput(inflate.findViewById(R.id.iv_scan_search_clear));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneViewCreated(View view, @Nullable Bundle bundle) {
        super.onSceneViewCreated(view, bundle);
        ScanSearchPresenter scanSearchPresenter = this.mPresenter;
        if (scanSearchPresenter != null) {
            scanSearchPresenter.initData(getBridge().getBundle());
            int destMode = this.mPresenter.getDestMode();
            if (1001 == destMode) {
                this.mTvContent.setText(getResources().getString(R.string.scan_search_fragment_home_title));
            } else if (1002 == destMode) {
                this.mTvContent.setText(getResources().getString(R.string.scan_search_fragment_company_title));
            } else {
                int searchMode = this.mPresenter.getSearchMode();
                String searchText = this.mPresenter.getSearchText();
                if (100 == searchMode) {
                    searchText = ((Object) getText(R.string.keyword_search_tip)) + searchText;
                } else if (101 == searchMode) {
                    searchText = ((Object) getText(R.string.around_search_tip)) + searchText;
                } else if (102 == searchMode) {
                    searchText = ((Object) getText(R.string.along_search_tip)) + searchText;
                }
                this.mTvContent.setText(searchText);
            }
        }
        getMainContext().updateSRNaviSwitchStatus(8, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneResume() {
        super.onSceneResume();
        updateMapUi();
    }

    public void updateMapUi() {
        if (isSceneLegal()) {
            MapUIStatus uIStatus = getUIStatus();
            uIStatus.mMapRenderModeVisibility = 0;
            uIStatus.mZoomButtonVisibility = 8;
            uIStatus.mScaleVisibility = 0;
            uIStatus.mVolumeVisibility = 0;
            uIStatus.mSettingVisibility = 0;
            uIStatus.mOverViewVisibility = 8;
            updateUIStatus(uIStatus);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroyView() {
        super.onSceneDestroyView();
        Unbinder unbinder = this.mButterBinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @OnClick({R.id.iv_scan_search_back, R.id.container})
    public void onClickBack() {
        goBack();
    }

    @OnClick({R.id.iv_scan_search_clear})
    public void onClickClose() {
        this.mPresenter.exitCurrentSearch();
    }

    @Override // com.xiaopeng.montecarlo.scenes.scanscene.IScanSearchContract.LogicView
    public void setResult(Bundle bundle) {
        this.mResultBundle = bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onBackResult(int i, Bundle bundle) {
        super.onBackResult(i, bundle);
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void setPresenter(ScanSearchPresenter scanSearchPresenter) {
        this.mPresenter = scanSearchPresenter;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public int getSearchDest() {
        return this.mPresenter.getDestMode();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public int getSearchMode() {
        return this.mPresenter.getSearchMode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public RectInt getCurrentFreeBound() {
        if (Utils.isLandscape()) {
            this.mFreeBound.top = this.mContainer.getBottom() - ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_bg_margin);
        }
        return this.mFreeBound;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public PageType getPageType() {
        return PageType.NAVI_SCAN_SEARCH;
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
        XImageButton xImageButton = this.mIvScanSearchBack;
        commonVuiHelper.markGeneralAction(string, mainContext, xImageButton, xImageButton, false);
        super.onBuildScene();
    }
}
