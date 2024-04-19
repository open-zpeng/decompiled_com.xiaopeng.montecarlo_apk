package com.xiaopeng.montecarlo.scenes.settingscene;

import android.view.View;
import com.xiaopeng.montecarlo.base.IBaseLogicView;
import com.xiaopeng.montecarlo.base.IBasePresenter;
import com.xiaopeng.montecarlo.bridge.StatusConst;
/* loaded from: classes3.dex */
public interface ISettingContract {

    /* loaded from: classes3.dex */
    public static class BindViewParam {
        boolean mBindXPAccountStatus;
        public String mInternetMapContent;
        boolean mIsXPAccountLog;
        public String mLaneMapContent;
        String mLicencePlate;
        public String mPublicationMapContent;
        int mValue;
    }

    /* loaded from: classes3.dex */
    public interface LogicView extends IBaseLogicView<SettingPreferencePresenter> {
        void bindView(BindViewParam bindViewParam);

        void controlRestrictSwitchView(boolean z);

        void delUserData();

        void enableCharge(boolean z);

        void enableScratchSpot(boolean z);

        void modifySettingPreference(int i, boolean z);

        void onDelUserData(boolean z);

        void resetView(int i);

        void restoreDefaultData(boolean z);

        void saveSettingPreference();

        void saveSettingPreference(ISettingCallback iSettingCallback);

        void scrollToEnd();

        void showSettingToast(String str);

        void unBindView();

        void updateCarLogo();

        void updateLicencePlate(String str, boolean z);

        void updateMapDownloadSize(long j);

        void updateNaviGuider();

        void updateSceneWithView(View view);
    }

    /* loaded from: classes3.dex */
    public interface Presenter extends IBasePresenter {
        void routeToScene(StatusConst.Mode mode);
    }
}
