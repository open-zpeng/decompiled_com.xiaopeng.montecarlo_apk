package com.xiaopeng.montecarlo.scenes.restrictscene;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.autonavi.gbl.layer.model.BizRouteRestrictInfo;
import com.autonavi.gbl.map.model.PreviewParam;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.BaseMapScene;
import com.xiaopeng.montecarlo.base.BaseScene;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.navcore.bean.restrict.XPGReStrictedAreaDataRuleRes;
import com.xiaopeng.montecarlo.navcore.bean.restrict.XPGRestrictCity;
import com.xiaopeng.montecarlo.navcore.bean.restrict.XPRectDouble;
import com.xiaopeng.montecarlo.navcore.control.BizControlWrapper;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.restrictscene.IRestrictContract;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.DetailRestrictRulesView;
import com.xiaopeng.xui.view.XView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes2.dex */
public class RestrictFragment extends BaseMapScene implements IRestrictContract.LogicView, DetailRestrictRulesView.IActionCallback {
    private static final int MAX_LEN_CITY = 5;
    private static final L.Tag TAG = new L.Tag("RestrictFragment");
    private MapViewWrapper mMapViewWrapper;
    @BindView(R.id.restrict_city_title)
    XLinearLayout mRestrictCityTitleList;
    @BindView(R.id.restrict_container)
    XRelativeLayout mRestrictContainer;
    @BindView(R.id.restrict_detail_pageview)
    DetailRestrictRulesView mRestrictDetailPageview;
    private RestrictScenePresenter mRestrictPresenter;
    private View mRootView;
    private Unbinder mUnBinder;
    @BindView(R.id.underline_view)
    XView mUnderlineView;
    private short[] mCityType = new short[5];
    private int mCityNum = 0;
    private boolean mFollowMode = true;
    private boolean mIsShowByPreview = false;
    private boolean mIsOpenRadar = false;
    private int mSelectCityIndex = 0;
    private int mSelectRuleIndex = 0;

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean canPoiCardShow() {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void hide() {
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void show() {
    }

    public static BaseScene newInstance() {
        return new RestrictFragment();
    }

    private void updateTitleLeftImage() {
        int i = this.mCityNum;
        if (i <= 1) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            TextView textView = (TextView) this.mRestrictCityTitleList.getChildAt(i2);
            Drawable leftDrawable = getLeftDrawable(this.mCityType[i2]);
            if (leftDrawable != null) {
                leftDrawable.setBounds(0, 0, leftDrawable.getMinimumWidth(), leftDrawable.getMinimumHeight());
                textView.setCompoundDrawables(leftDrawable, null, null, null);
                textView.setCompoundDrawablePadding(ContextUtils.getDimensionPixelSize(R.dimen.restrict_city_title_drawable_padding));
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    protected View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.layout_restricted_rule, (ViewGroup) null);
        return this.mRootView;
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.IRestrictContract.LogicView
    public void onInitView() {
        if (L.ENABLE) {
            L.d(TAG, " onInitView");
        }
        bindView();
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.IRestrictContract.LogicView
    public void exitRestrictScene() {
        if (L.ENABLE) {
            L.d(TAG, " exitRestrictScene");
        }
        if (this.mIsShowByPreview) {
            getMapView().exitPreviewImplicit();
        } else {
            getMapView().exitPreview(true, true);
        }
        stopSelf();
    }

    @OnClick({R.id.restrict_detail_close})
    public void onClickClose() {
        exitRestrictScene();
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.IRestrictContract.LogicView
    public void bindView() {
        this.mUnBinder = ButterKnife.bind(this, this.mRootView);
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.IRestrictContract.LogicView
    public void unBindView() {
        Unbinder unbinder = this.mUnBinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    /* renamed from: getPresenter */
    public RestrictScenePresenter mo96getPresenter() {
        return this.mRestrictPresenter;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void setPresenter(RestrictScenePresenter restrictScenePresenter) {
        this.mRestrictPresenter = restrictScenePresenter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneCreate(@Nullable Bundle bundle) {
        super.onSceneCreate(bundle);
        if (getMapView().isLaneMode()) {
            getMapView().switchToSD(ThemeWatcherUtil.getMapModeByCurrentTheme());
        }
        resetStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroy() {
        super.onSceneDestroy();
        restoreStatus();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneViewCreated(View view, Bundle bundle) {
        super.onSceneViewCreated(view, bundle);
        this.mSelectCityIndex = getHoldInt(RestrictUtils.KEY_RESTRICT_CITY_INDEX, 0);
        this.mSelectRuleIndex = getHoldInt(RestrictUtils.KEY_RESTRICT_RULE_INDEX, 0);
        this.mRestrictPresenter.onInitView((XPGReStrictedAreaDataRuleRes) getBridge().getBundle().getParcelable(RestrictUtils.KEY_RESTRICT), this.mSelectCityIndex, this.mSelectRuleIndex);
    }

    private void resetStatus() {
        this.mMapViewWrapper = getMapView();
        this.mIsShowByPreview = this.mMapViewWrapper.getBizControlManager().getPreviewMode();
        this.mIsOpenRadar = SettingWrapper.isOpenRadar();
        this.mFollowMode = this.mMapViewWrapper.isFollowMode();
        this.mMapViewWrapper.getBizControlManager().resetStatus(this.mIsShowByPreview, this.mIsOpenRadar);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, " resetStatus:mIsShowByPreview=" + this.mIsShowByPreview + ",mFollowMode=" + this.mFollowMode);
        }
    }

    private void restoreStatus() {
        if (L.ENABLE) {
            L.d(TAG, " restoreStatus");
        }
        this.mMapViewWrapper.getBizControlManager().restoreStatus(this.mIsShowByPreview, this.mIsOpenRadar, this.mFollowMode);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneResume() {
        super.onSceneResume();
        getMainContext().lockMapPoiEvent();
        getMainContext().getDecoratorManager().hide(this, DecoratorType.CHARGE);
        getMainContext().updateSRNaviSwitchStatus(8, false);
        RestrictScenePresenter restrictScenePresenter = this.mRestrictPresenter;
        if (restrictScenePresenter != null) {
            restrictScenePresenter.onResume();
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onScenePause() {
        super.onScenePause();
        getMainContext().unlockMapPoiEvent();
        getMainContext().getDecoratorManager().show(this, DecoratorType.CHARGE);
        RestrictScenePresenter restrictScenePresenter = this.mRestrictPresenter;
        if (restrictScenePresenter != null) {
            restrictScenePresenter.onPause();
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroyView() {
        super.onSceneDestroyView();
        clearRestrictedAreaRules();
        unBindView();
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.IRestrictContract.LogicView
    public void showRestrictedDetail(ArrayList<XPGRestrictCity> arrayList) {
        Collections.reverse(arrayList);
        if (arrayList == null) {
            if (L.ENABLE) {
                L.d(TAG, "showRestrictedDetail:cities is null");
            }
            exitRestrictScene();
            return;
        }
        this.mCityNum = arrayList.size();
        if (L.ENABLE) {
            L.d(TAG, "showRestrictedDetail:mCityNum=" + this.mCityNum);
        }
        if ((this.mCityNum <= 0) | (this.mCityNum > 5)) {
            if (L.ENABLE) {
                L.d(TAG, "showRestrictedDetail:mCityNum is invalid");
            }
            exitRestrictScene();
            return;
        }
        this.mRestrictCityTitleList.setSelected(true);
        for (int i = 0; i < this.mCityNum; i++) {
            XPGRestrictCity xPGRestrictCity = arrayList.get(i);
            if (xPGRestrictCity != null) {
                initTitleView(i, xPGRestrictCity);
            }
        }
        updateTitleUnderLine();
        this.mRestrictDetailPageview.setActionCallback(this);
        this.mRestrictDetailPageview.setRuleData(arrayList.get(this.mSelectCityIndex), this.mSelectRuleIndex);
        this.mRestrictDetailPageview.show();
        this.mRestrictContainer.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTitleUnderLine() {
        if (this.mCityNum <= 1) {
            return;
        }
        this.mRestrictCityTitleList.post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.restrictscene.RestrictFragment.1
            @Override // java.lang.Runnable
            public void run() {
                RestrictFragment.this.mUnderlineView.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) RestrictFragment.this.mUnderlineView.getLayoutParams();
                View childAt = RestrictFragment.this.mRestrictCityTitleList.getChildAt(RestrictFragment.this.mSelectCityIndex);
                layoutParams.width = childAt.getWidth();
                layoutParams.setMarginStart(childAt.getLeft());
                RestrictFragment.this.mUnderlineView.setLayoutParams(layoutParams);
            }
        });
    }

    private void initTitleView(final int i, final XPGRestrictCity xPGRestrictCity) {
        TextView textView = (TextView) this.mRestrictCityTitleList.getChildAt(i);
        if (i != 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.setMarginStart(getResources().getDimensionPixelSize(R.dimen.restrict_title_margin));
            textView.setLayoutParams(layoutParams);
        }
        if (i == this.mSelectCityIndex) {
            textView.setSelected(true);
        } else {
            textView.setSelected(false);
        }
        if (this.mCityNum == 1) {
            textView.setText(xPGRestrictCity.mTitle);
        } else {
            textView.setText(xPGRestrictCity.mCityName);
            setTitleLeftImage(i, textView, xPGRestrictCity.mCityName);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.restrictscene.RestrictFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.isSelected()) {
                    return;
                }
                RestrictFragment.this.clearSelected();
                ((TextView) view).setSelected(true);
                RestrictFragment.this.mSelectRuleIndex = 0;
                RestrictFragment.this.mSelectCityIndex = i;
                RestrictFragment.this.updateTitleUnderLine();
                RestrictFragment.this.mRestrictPresenter.drawRestrictedAreaRules(i, 0);
                RestrictFragment.this.mRestrictDetailPageview.setRuleData(xPGRestrictCity, 0);
            }
        });
        textView.setVisibility(0);
    }

    private void setTitleLeftImage(int i, TextView textView, String str) {
        Drawable leftDrawable;
        short cityType = this.mRestrictPresenter.getCityType(str);
        if (cityType == 0 || (leftDrawable = getLeftDrawable(cityType)) == null) {
            return;
        }
        leftDrawable.setBounds(0, 0, leftDrawable.getMinimumWidth(), leftDrawable.getMinimumHeight());
        textView.setCompoundDrawables(leftDrawable, null, null, null);
        textView.setCompoundDrawablePadding(ContextUtils.getDimensionPixelSize(R.dimen.restrict_city_title_drawable_padding));
        this.mCityType[i] = cityType;
    }

    private Drawable getLeftDrawable(short s) {
        if (s == 1) {
            return getResources().getDrawable(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_small_limit_star));
        }
        if (s == 2) {
            return getResources().getDrawable(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_small_limit_final));
        }
        if (s == 3) {
            return getResources().getDrawable(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_small_limit_though));
        }
        return null;
    }

    private void clearRestrictedAreaRules() {
        this.mMapViewWrapper.getBizControlManager().clearAllItems(BizControlWrapper.BIZ_CONTROL_TYPE_AREA, 1008L);
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.IRestrictContract.LogicView
    public void drawRules(BizRouteRestrictInfo bizRouteRestrictInfo) {
        this.mMapViewWrapper.getBizControlManager().updateRouteRestrict(bizRouteRestrictInfo);
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.IRestrictContract.LogicView
    public void preDrawRestrict(XPRectDouble xPRectDouble, boolean z) {
        if (z) {
            clearRestrictedAreaRules();
        }
        PreviewParam previewParam = new PreviewParam();
        previewParam.screenTop = getRestrictAreaScreenTop();
        previewParam.screenBottom = getRestrictAreaScreenBottom();
        previewParam.screenLeft = getRestrictAreaScreenLeft();
        previewParam.screenRight = getRestrictAreaScreenRight();
        previewParam.mapBound = xPRectDouble.toBLRectDouble();
        previewParam.bUseRect = true;
        previewParam.leftOfMap = previewParam.screenLeft;
        previewParam.topOfMap = previewParam.screenTop;
        previewParam.bAdjustHeaderAngle = true;
        this.mMapViewWrapper.showPreview(previewParam);
    }

    private int getRestrictAreaScreenLeft() {
        return ContextUtils.getDimensionPixelSize(R.dimen.restrict_offset_margin_l);
    }

    private int getRestrictAreaScreenRight() {
        return ContextUtils.getDimensionPixelSize(R.dimen.restrict_offset_margin_r);
    }

    private int getRestrictAreaScreenTop() {
        return ContextUtils.getDimensionPixelSize(R.dimen.restrict_offset_margin_t);
    }

    private int getRestrictAreaScreenBottom() {
        return ContextUtils.getDimensionPixelSize(R.dimen.restrict_offset_margin_b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelected() {
        for (int i = 0; i < 5; i++) {
            ((TextView) this.mRestrictCityTitleList.getChildAt(i)).setSelected(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.DayNightFragment
    public void onThemeSwitchDelegate(int i) {
        updateTitleLeftImage();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public boolean onSceneSaveInstanceState(Bundle bundle) {
        saveHoldInt(RestrictUtils.KEY_RESTRICT_RULE_INDEX, this.mSelectRuleIndex);
        saveHoldInt(RestrictUtils.KEY_RESTRICT_CITY_INDEX, this.mSelectCityIndex);
        return true;
    }

    @Override // com.xiaopeng.montecarlo.views.DetailRestrictRulesView.IActionCallback
    public void updateRuleRectOnly(XPRectDouble xPRectDouble) {
        preDrawRestrict(xPRectDouble, false);
    }

    @Override // com.xiaopeng.montecarlo.views.DetailRestrictRulesView.IActionCallback
    public void drawRuleOnMap(int i) {
        this.mRestrictPresenter.drawRestrictedAreaRules(this.mSelectCityIndex, i);
        this.mSelectRuleIndex = i;
    }
}
