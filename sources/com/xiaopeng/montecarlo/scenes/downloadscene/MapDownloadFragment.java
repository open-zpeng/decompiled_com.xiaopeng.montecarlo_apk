package com.xiaopeng.montecarlo.scenes.downloadscene;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.BaseFullScenes;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationErrCodeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationTypeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.TaskStatusCodeEnum;
import com.xiaopeng.montecarlo.root.IWorkCallback;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.downloadscene.IMapDownloadContract;
import com.xiaopeng.montecarlo.scenes.downloadscene.MapDownloadFragment;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.adapter.MapDataAdapterView;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.listener.IScrollListener;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.listener.MapDataClickListener;
import com.xiaopeng.montecarlo.scenes.searchscene.TopSmoothScroller;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRecyclerView;
import java.util.ArrayList;
import java.util.function.Consumer;
/* loaded from: classes3.dex */
public class MapDownloadFragment extends BaseFullScenes implements IMapDownloadContract.LogicView {
    private static final L.Tag TAG = new L.Tag("MapDownloadFragment");
    private MapDataAdapterView mAdapterView;
    @BindView(R.id.recyclerview_all_city)
    XRecyclerView mAllCityRecyclerView;
    @BindView(R.id.btn_return)
    XImageButton mBtnReturn;
    private Unbinder mButterBinder;
    private MapDownloadPresenter mPresenter;
    private TopSmoothScroller mScroller;
    @BindView(R.id.map_downlload_waiting_parent)
    XLinearLayout mWaitingHitLayout;
    private DownloadDataChangeCallback mDownloadDataChangeCallback = new DownloadDataChangeCallback();
    private LinearLayoutManager mAllCityLinearLayoutManager = new LinearLayoutManager(getActivity()) { // from class: com.xiaopeng.montecarlo.scenes.downloadscene.MapDownloadFragment.1
        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            try {
                super.onLayoutChildren(recycler, state);
            } catch (IndexOutOfBoundsException e) {
                L.printStackTrace(MapDownloadFragment.TAG, e);
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutCompleted(RecyclerView.State state) {
            super.onLayoutCompleted(state);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onScrollStateChanged(int i) {
            super.onScrollStateChanged(i);
            if (i == 0) {
                MapDownloadFragment.this.refreshFullView();
            }
        }
    };
    private IScrollListener mScrollListener = new AnonymousClass2();

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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.scenes.downloadscene.MapDownloadFragment$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass2 implements IScrollListener {
        AnonymousClass2() {
        }

        @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.listener.IScrollListener
        public boolean isScrollEnd() {
            return (MapDownloadFragment.this.mAllCityRecyclerView == null || MapDownloadFragment.this.mAllCityRecyclerView.getScrollState() != 0 || MapDownloadFragment.this.mAllCityRecyclerView.isComputingLayout()) ? false : true;
        }

        @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.listener.IScrollListener
        public void scrollToPosition(final int i, final int i2) {
            L.Tag tag = MapDownloadFragment.TAG;
            L.i(tag, "scrollToPosition:" + i);
            MapDownloadFragment.this.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.downloadscene.-$$Lambda$MapDownloadFragment$2$CeEAwO0SMvdQXN5_goctH4orkQM
                @Override // java.lang.Runnable
                public final void run() {
                    MapDownloadFragment.AnonymousClass2.this.lambda$scrollToPosition$0$MapDownloadFragment$2(i, i2);
                }
            });
        }

        public /* synthetic */ void lambda$scrollToPosition$0$MapDownloadFragment$2(int i, int i2) {
            if (i < 0 || i >= i2) {
                return;
            }
            MapDownloadFragment.this.mScroller.setTargetPosition(i);
            MapDownloadFragment.this.mAllCityLinearLayoutManager.startSmoothScroll(MapDownloadFragment.this.mScroller);
            MapDownloadFragment.this.mAllCityLinearLayoutManager.setStackFromEnd(false);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.DayNightFragment, com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
    public void onThemeSwitch(int i) {
        super.onThemeSwitch(i);
        refreshFullView();
    }

    public static MapDownloadFragment newInstance() {
        Bundle bundle = new Bundle();
        MapDownloadFragment mapDownloadFragment = new MapDownloadFragment();
        mapDownloadFragment.setArguments(bundle);
        return mapDownloadFragment;
    }

    private void initAllCityRecyclerView() {
        L.i(TAG, "initAllCityRecyclerView");
        if (this.mPresenter != null && this.mAllCityLinearLayoutManager != null && this.mAllCityRecyclerView != null) {
            this.mAdapterView = new MapDataAdapterView(getActivity(), this);
            this.mAdapterView.setOnItemClickListener(new MapDataClickListener(this.mPresenter.getDownloadStateManager()));
            this.mAdapterView.setScrollListener(this.mScrollListener);
            this.mScroller = new TopSmoothScroller(getActivity());
            this.mAllCityLinearLayoutManager.setOrientation(1);
            this.mAllCityRecyclerView.setLayoutManager(this.mAllCityLinearLayoutManager);
            this.mAllCityRecyclerView.setAdapter(this.mAdapterView);
            return;
        }
        L.Tag tag = TAG;
        L.w(tag, "initAllCityRecyclerView failed, " + this.mPresenter + " " + this.mAllCityLinearLayoutManager + " " + this.mAllCityRecyclerView);
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.IMapDownloadContract.LogicView
    public void refreshFullView() {
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.downloadscene.-$$Lambda$MapDownloadFragment$n6_L0cWgsB7-ELXrp_S_Ib6xtmQ
            @Override // java.lang.Runnable
            public final void run() {
                MapDownloadFragment.this.lambda$refreshFullView$0$MapDownloadFragment();
            }
        });
    }

    public /* synthetic */ void lambda$refreshFullView$0$MapDownloadFragment() {
        MapDataAdapterView mapDataAdapterView = this.mAdapterView;
        if (mapDataAdapterView == null) {
            showLoading(true);
            return;
        }
        showLoading(!mapDataAdapterView.isRecycleViewDataReady());
        this.mAdapterView.notifyDataSetChangedWhenIdle();
    }

    private void showLoading(boolean z) {
        if (z) {
            this.mAllCityRecyclerView.setVisibility(8);
            this.mWaitingHitLayout.setVisibility(0);
            return;
        }
        this.mAllCityRecyclerView.setVisibility(0);
        this.mWaitingHitLayout.setVisibility(8);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneCreate(Bundle bundle) {
        L.i(TAG, "onSceneCreate");
        super.onSceneCreate(bundle);
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

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneResume() {
        L.i(TAG, "onSceneResume");
        super.onSceneResume();
        MapDataManager.getInstance().registerDownloadDataChangeObserver(this.mDownloadDataChangeCallback);
        DataLogUtil.sendStatData(PageType.SETTING, BtnType.DOWNLOAD_VIEW_RESUME, new Object[0]);
        MapDownloadPresenter mapDownloadPresenter = this.mPresenter;
        if (mapDownloadPresenter != null) {
            mapDownloadPresenter.onResume();
            recreateRecycleViewData();
        }
    }

    private void updateSettingView(boolean z) {
        IBaseScene sceneByType = getSceneByType(PageType.SETTING);
        if (sceneByType != null) {
            sceneByType.getSceneContainer().setVisibility(z ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recreateRecycleViewData() {
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.downloadscene.-$$Lambda$MapDownloadFragment$X4T_xanmYsCoevktNlDkyglpZIA
            @Override // java.lang.Runnable
            public final void run() {
                MapDownloadFragment.this.lambda$recreateRecycleViewData$1$MapDownloadFragment();
            }
        });
    }

    public /* synthetic */ void lambda$recreateRecycleViewData$1$MapDownloadFragment() {
        MapDataAdapterView mapDataAdapterView = this.mAdapterView;
        if (mapDataAdapterView != null) {
            showLoading(!mapDataAdapterView.isRecycleViewDataReady());
            this.mAdapterView.recreateRecycleViewData(new IWorkCallback() { // from class: com.xiaopeng.montecarlo.scenes.downloadscene.-$$Lambda$yqNTUwhqm_92zgDLSIni20c8f7U
                @Override // com.xiaopeng.montecarlo.root.IWorkCallback
                public final void onFinish() {
                    MapDownloadFragment.this.refreshFullView();
                }
            });
            return;
        }
        showLoading(true);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onScenePause() {
        L.i(TAG, "onScenePause");
        super.onScenePause();
        MapDataManager.getInstance().unregisterObserver(this.mDownloadDataChangeCallback);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    @Nullable
    public View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        L.i(TAG, "onSceneCreateView");
        View inflate = layoutInflater.inflate(R.layout.fragment_offline_download, viewGroup, true);
        this.mButterBinder = ButterKnife.bind(this, inflate);
        initAllCityRecyclerView();
        return inflate;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroy() {
        L.i(TAG, "onSceneDestroy");
        super.onSceneDestroy();
        if (this.mAdapterView != null) {
            this.mAdapterView = null;
        }
        MapDownloadPresenter mapDownloadPresenter = this.mPresenter;
        if (mapDownloadPresenter != null) {
            mapDownloadPresenter.onDestroy();
            this.mPresenter = null;
        }
    }

    @OnClick({R.id.btn_return, R.id.base_scene})
    public void onBackPressed(View view) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_need_exit_settings", false);
        setReturnResult(bundle);
        super.goBack();
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    /* renamed from: getPresenter */
    public MapDownloadPresenter mo116getPresenter() {
        return this.mPresenter;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void setPresenter(MapDownloadPresenter mapDownloadPresenter) {
        if (mapDownloadPresenter != null) {
            this.mPresenter = mapDownloadPresenter;
        } else {
            L.w(TAG, "setPresenter failed, presenter is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneViewCreated(View view, @Nullable Bundle bundle) {
        super.onSceneViewCreated(view, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroyView() {
        super.onSceneDestroyView();
        this.mScrollListener = null;
        Unbinder unbinder = this.mButterBinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class DownloadDataChangeCallback implements IDownloadDataChangeCallback {
        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onCityDataFetched() {
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onCityListCreated() {
        }

        private DownloadDataChangeCallback() {
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onCityDataGenerated() {
            MapDownloadFragment.this.recreateRecycleViewData();
        }

        public /* synthetic */ void lambda$onOperated$0$MapDownloadFragment$DownloadDataChangeCallback(OperationTypeEnum operationTypeEnum, Integer num) {
            MapDownloadFragment.this.mAdapterView.onOperated(operationTypeEnum, num);
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onOperated(final OperationTypeEnum operationTypeEnum, ArrayList<Integer> arrayList) {
            arrayList.forEach(new Consumer() { // from class: com.xiaopeng.montecarlo.scenes.downloadscene.-$$Lambda$MapDownloadFragment$DownloadDataChangeCallback$tr9j5EfFLohny7S_Yt20rTQcNAc
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    MapDownloadFragment.DownloadDataChangeCallback.this.lambda$onOperated$0$MapDownloadFragment$DownloadDataChangeCallback(operationTypeEnum, (Integer) obj);
                }
            });
            MapDownloadFragment.this.refreshFullView();
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onPercent(Integer num, Integer num2, Float f) {
            MapDownloadFragment.this.mAdapterView.onPercent(num, num2, f);
            MapDownloadFragment.this.refreshFullView();
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onDownLoadStatus(int i, TaskStatusCodeEnum taskStatusCodeEnum, OperationErrCodeEnum operationErrCodeEnum) {
            MapDownloadFragment.this.mAdapterView.onDownLoadStatus(Integer.valueOf(i), taskStatusCodeEnum, operationErrCodeEnum);
            MapDownloadFragment.this.refreshFullView();
        }
    }
}
