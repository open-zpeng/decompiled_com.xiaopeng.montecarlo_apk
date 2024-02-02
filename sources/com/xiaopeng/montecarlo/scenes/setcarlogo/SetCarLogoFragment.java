package com.xiaopeng.montecarlo.scenes.setcarlogo;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.BaseFullScenes;
import com.xiaopeng.montecarlo.base.BaseScene;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.scenes.setcarlogo.ISetCarLogoContract;
import com.xiaopeng.montecarlo.stat.SettingStatUtil;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.xui.widget.XImageButton;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SetCarLogoFragment extends BaseFullScenes implements ISetCarLogoContract.LogicView {
    private static final L.Tag TAG = new L.Tag("SetCarLogoFragment");
    private ArrayList<CarLogo> mArrayList = new ArrayList<>();
    @BindView(R.id.set_car_logo_btn_return)
    XImageButton mBtnReturn;
    @BindView(R.id.set_car_logo_gridview)
    public GridView mGridView;
    private int mInitSelectCarIndex;
    private SetCarLogoPresenter mPresenter;
    private int mSelectedCarIndex;
    private SetCarLogoAdapter mSetCarLogoAdapter;

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
        return new SetCarLogoFragment();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    protected View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_layout_set_car_logo, viewGroup);
        ButterKnife.bind(this, inflate);
        if (L.ENABLE) {
            L.d(TAG, "onCreateContentView");
        }
        initData();
        this.mSetCarLogoAdapter = new SetCarLogoAdapter(this.mArrayList, getActivity(), this.mSelectedCarIndex);
        this.mGridView.setAdapter((ListAdapter) this.mSetCarLogoAdapter);
        this.mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.xiaopeng.montecarlo.scenes.setcarlogo.SetCarLogoFragment.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                SetCarLogoFragment.this.mSetCarLogoAdapter.update(i);
                SettingWrapper.saveCarLogo(((CarLogo) SetCarLogoFragment.this.mArrayList.get(i)).getKey());
                SetCarLogoFragment.this.mSelectedCarIndex = i;
                SettingStatUtil.sendStatDataUpateCarLogo(i);
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.setcarlogo.SetCarLogoFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SetCarLogoFragment.this.getMapView().updateCarLocIcon();
                        if (TBTManager.getInstance().isMiniMapEnable()) {
                            Intent intent = new Intent();
                            intent.setClassName(ContextUtils.getContext().getPackageName(), "com.xiaopeng.montecarlo.service.minimap.MiniMapService");
                            intent.setAction("com.xiaopeng.montecarlo.minimap.ACTION_CAR_ICON_CHANGE");
                            ContextUtils.getContext().startService(intent);
                            L.i(SetCarLogoFragment.TAG, "MiniMapService startService ACTION_CAR_ICON_CHANGE in SetCarLogoFragment onItemClick");
                        }
                    }
                });
            }
        });
        return inflate;
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

    private void updateSettingView(boolean z) {
        IBaseScene sceneByType = getSceneByType(PageType.SETTING);
        if (sceneByType != null) {
            sceneByType.getSceneContainer().setVisibility(z ? 8 : 0);
        }
    }

    private String getSelectedPositionKey() {
        return SettingWrapper.getCarLogo();
    }

    private void initData() {
        CharSequence[] textArray = getResources().getTextArray(R.array.set_car_logo_title_arr);
        TypedArray obtainTypedArray = getResources().obtainTypedArray(R.array.set_car_logo_scr_arr);
        CharSequence[] textArray2 = getResources().getTextArray(R.array.set_car_logo_key_arr);
        String selectedPositionKey = getSelectedPositionKey();
        for (int i = 0; i < textArray.length; i++) {
            CarLogo carLogo = new CarLogo();
            carLogo.setTitle(textArray[i].toString());
            carLogo.setLogoSrc(obtainTypedArray.getResourceId(i, -1));
            String charSequence = textArray2[i].toString();
            carLogo.setKey(charSequence);
            if (charSequence.equals(selectedPositionKey)) {
                this.mSelectedCarIndex = i;
                this.mInitSelectCarIndex = i;
            }
            this.mArrayList.add(carLogo);
        }
        obtainTypedArray.recycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneViewCreated(View view, @Nullable Bundle bundle) {
        super.onSceneViewCreated(view, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.DayNightFragment
    public void onThemeSwitchDelegate(int i) {
        super.onThemeSwitchDelegate(i);
        this.mSetCarLogoAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.set_car_logo_btn_return, R.id.base_scene})
    public void onBackPressed(View view) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_need_exit_settings", false);
        bundle.putBoolean(SetCarLogoPresenter.KEY_CAR_LOGO_CHANGE, this.mInitSelectCarIndex != this.mSelectedCarIndex);
        setReturnResult(bundle);
        super.goBack();
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    /* renamed from: getPresenter */
    public SetCarLogoPresenter mo96getPresenter() {
        return this.mPresenter;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void setPresenter(SetCarLogoPresenter setCarLogoPresenter) {
        this.mPresenter = setCarLogoPresenter;
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
