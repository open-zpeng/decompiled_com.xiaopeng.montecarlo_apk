package com.xiaopeng.montecarlo.scenes.settingscene;

import com.xiaopeng.montecarlo.base.IBaseLogicView;
import com.xiaopeng.montecarlo.base.IBasePresenter;
/* loaded from: classes3.dex */
public interface ISettingLicencePlateContract {

    /* loaded from: classes3.dex */
    public interface LogicView extends IBaseLogicView<SettingLicencePlatePresenter> {
        void bindView();

        void focusPlateEdit();

        void unBindView();

        void updateLicencePlateFirstValue(String str);
    }

    /* loaded from: classes3.dex */
    public interface Presenter extends IBasePresenter {
    }
}
