package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.BaseFullScenes;
import com.xiaopeng.montecarlo.base.BaseScene;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.bridge.LinkPlatformBridge;
import com.xiaopeng.montecarlo.bridge.LinkSeamlessNaviBridge;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkSeamlessNaviContract;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.adapter.PlatformAdapter;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.bean.PlatformItem;
import com.xiaopeng.montecarlo.stat.NaviGuiderStatUtil;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRecyclerView;
import com.xiaopeng.xui.widget.XTextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class LinkSeamlessNaviFragment extends BaseFullScenes implements ILinkSeamlessNaviContract.LogicView, PlatformAdapter.OnClickListener {
    private static final int PLATFORM_LANDSCAPE_SPAN_COUNT = 6;
    private static final int PLATFORM_PORTRAIT_SPAN_COUNT = 3;
    private static final L.Tag TAG = new L.Tag("LinkSeamlessNaviFragment");
    private ViewGroup mBaseView;
    @BindView(R.id.iv_bootstrap)
    XImageView mBootstrapIv;
    private int mFrom;
    @BindView(R.id.iv_close)
    XImageButton mIbClose;
    @BindView(R.id.ll_main_content)
    XLinearLayout mLayoutMain;
    private PlatformAdapter mPlatformAdapter;
    @BindView(R.id.rv_support_platform)
    XRecyclerView mPlatformRv;
    private LinkSeamlessNaviPresenter mPresenter;
    @BindView(R.id.tv_title)
    XTextView mTitleView;
    @BindView(R.id.tv_guide_subtitle)
    XTextView mTvGuideSubtitle;
    @BindView(R.id.tv_guide_title)
    XTextView mTvGuideTitle;
    private Unbinder mUnbinder;

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void hide() {
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void show() {
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean showCover() {
        return true;
    }

    public static BaseScene newInstance() {
        return new LinkSeamlessNaviFragment();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public PageType getPageType() {
        return PageType.NAVI_MESSAGE_NAVI_SYNC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneCreate(@Nullable Bundle bundle) {
        super.onSceneCreate(bundle);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    protected View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_link_seamless_navi, viewGroup, true);
        this.mBaseView = viewGroup;
        this.mUnbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneViewCreated(View view, @Nullable Bundle bundle) {
        super.onSceneViewCreated(view, bundle);
        initData(getBridge().getBundle());
        initView();
        initSpecialViews();
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.mFrom = bundle.getInt(LinkSeamlessNaviBridge.KEY_FROM_WHERE, 0);
    }

    private void initSpecialViews() {
        ViewGroup viewGroup;
        if (!Utils.isLandscape() || (viewGroup = this.mBaseView) == null) {
            return;
        }
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.-$$Lambda$Mv2NiKiUIxtZ44s21otJEOZzAhk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LinkSeamlessNaviFragment.this.onClickClose(view);
            }
        });
    }

    private void initView() {
        this.mPlatformAdapter = new PlatformAdapter(buildPlatformItems());
        this.mPlatformAdapter.setOnClickListener(this);
        this.mPlatformRv.setLayoutManager(new GridLayoutManager(getActivity(), Utils.isLandscape() ? 6 : 3));
        this.mPlatformRv.setAdapter(this.mPlatformAdapter);
        if (this.mFrom == 0) {
            this.mIbClose.setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_small_back));
        } else {
            this.mIbClose.setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_small_close));
        }
        if (Utils.isLandscape()) {
            this.mBootstrapIv.setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.png_sends_addresstocar));
        } else {
            this.mBootstrapIv.setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.png_sends_address2car));
        }
    }

    private List<PlatformItem> buildPlatformItems() {
        PlatformItem platformItem = new PlatformItem(R.drawable.png_xpeng, 256);
        PlatformItem platformItem2 = new PlatformItem(R.drawable.png_wechat, 257);
        PlatformItem platformItem3 = new PlatformItem(R.drawable.png_gaode, 258);
        PlatformItem platformItem4 = new PlatformItem(R.drawable.png_baidu, 259);
        PlatformItem platformItem5 = new PlatformItem(R.drawable.png_dianping, 260);
        PlatformItem platformItem6 = new PlatformItem(R.drawable.png_meituan, 261);
        ArrayList arrayList = new ArrayList();
        arrayList.add(platformItem);
        arrayList.add(platformItem3);
        arrayList.add(platformItem2);
        arrayList.add(platformItem4);
        arrayList.add(platformItem5);
        arrayList.add(platformItem6);
        return arrayList;
    }

    @OnClick({R.id.iv_close})
    public void onClickClose(View view) {
        exitScene();
    }

    private void exitScene() {
        NaviGuiderStatUtil.bINaviGuiderCloseEvent();
        setReturnResult(new Bundle());
        goBack();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.DayNightFragment
    public void onThemeSwitchDelegate(int i) {
        super.onThemeSwitchDelegate(i);
        renderViewByTheme();
    }

    private void renderViewByTheme() {
        if (isSceneLegal()) {
            PlatformAdapter platformAdapter = this.mPlatformAdapter;
            if (platformAdapter != null) {
                platformAdapter.notifyDataSetChanged();
            }
            if (this.mFrom == 0) {
                this.mIbClose.setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_small_back));
            } else {
                this.mIbClose.setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_small_close));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroyView() {
        super.onSceneDestroyView();
        this.mPresenter.onDestroy();
        this.mUnbinder.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneAttach(Context context) {
        super.onSceneAttach(context);
        updateSettingView(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDetach() {
        super.onSceneDetach();
        updateSettingView(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneResume() {
        super.onSceneResume();
        LinkSeamlessNaviPresenter linkSeamlessNaviPresenter = this.mPresenter;
        if (linkSeamlessNaviPresenter != null) {
            linkSeamlessNaviPresenter.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onScenePause() {
        super.onScenePause();
        LinkSeamlessNaviPresenter linkSeamlessNaviPresenter = this.mPresenter;
        if (linkSeamlessNaviPresenter != null) {
            linkSeamlessNaviPresenter.onPause();
        }
    }

    private void updateSettingView(boolean z) {
        IBaseScene sceneByType = getSceneByType(PageType.SETTING);
        if (sceneByType != null) {
            sceneByType.getSceneContainer().setVisibility(z ? 8 : 0);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    /* renamed from: getPresenter */
    public LinkSeamlessNaviPresenter mo96getPresenter() {
        return this.mPresenter;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void setPresenter(LinkSeamlessNaviPresenter linkSeamlessNaviPresenter) {
        this.mPresenter = linkSeamlessNaviPresenter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroy() {
        super.onSceneDestroy();
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.adapter.PlatformAdapter.OnClickListener
    public void onClick(int i) {
        switch (i) {
            case 256:
                NaviGuiderStatUtil.bIXiaopengIconClick();
                break;
            case 257:
                NaviGuiderStatUtil.bIWechatIconClick();
                break;
            case 258:
                NaviGuiderStatUtil.bIAmapIconClick();
                break;
            case 259:
                NaviGuiderStatUtil.bIBaiduIconClick();
                break;
            case 260:
                NaviGuiderStatUtil.bIDianpingIconClick();
                break;
            case 261:
                NaviGuiderStatUtil.bIMeituanIconClick();
                break;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(LinkPlatformBridge.PLATFORM_TYPE_KEY, i);
        startScene(new LinkPlatformBridge().setBundle(bundle));
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
        XImageButton xImageButton = this.mIbClose;
        commonVuiHelper.markGeneralAction(string, mainContext, xImageButton, xImageButton, false);
        super.onBuildScene();
    }
}
