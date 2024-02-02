package com.xiaopeng.montecarlo.scenes.activatescene;

import com.xiaopeng.montecarlo.base.IBasePresenter;
import com.xiaopeng.montecarlo.base.IMapLogicView;
/* loaded from: classes.dex */
public interface IActivateContract {

    /* loaded from: classes.dex */
    public interface LogicView extends IMapLogicView<ActivateScenePresenter> {
        void activateManualSuccess(boolean z);

        void activateSilentSuccess();

        void showActivateNetErrorDialog();

        void showManualActivateDialog();

        void showManualActivateFail(int i);
    }

    /* loaded from: classes.dex */
    public interface Presenter extends IBasePresenter {
    }
}
