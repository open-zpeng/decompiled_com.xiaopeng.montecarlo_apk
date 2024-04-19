package com.xiaopeng.montecarlo.scenes.setcarlogo;

import com.xiaopeng.montecarlo.base.scene.BasePresenter;
import com.xiaopeng.montecarlo.scenes.setcarlogo.ISetCarLogoContract;
/* loaded from: classes3.dex */
public class SetCarLogoPresenter extends BasePresenter {
    public static final String KEY_CAR_LOGO_CHANGE = "key_car_logo_change";
    public static final String KEY_NEED_EXIT_SETTINGS = "key_need_exit_settings";
    private ISetCarLogoContract.LogicView mLogicView;

    public SetCarLogoPresenter(ISetCarLogoContract.LogicView logicView) {
        this.mLogicView = logicView;
        this.mLogicView.setPresenter(this);
    }

    void exitScene() {
        this.mLogicView.goBack();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onResume() {
        super.onResume();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onPause() {
        super.onPause();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void show() {
        super.show();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void hide() {
        super.hide();
    }
}
