package com.xiaopeng.montecarlo.scenes.settingscene;

import com.xiaopeng.montecarlo.base.scene.BasePresenter;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.settingscene.ISettingLicencePlateContract;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import com.xiaopeng.montecarlo.views.keyboard.KeyboardCallback;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class SettingLicencePlatePresenter extends BasePresenter implements ISettingLicencePlateContract.Presenter {
    public static final String KEY_SAVE_LICENCE_PLATE = "key_save_licence_plate";
    public static final int REQUEST_CODE_SAVE_LICENCE_PLATE = 10;
    private static final L.Tag TAG = new L.Tag("SettingLicencePlatePresenter");
    private ISettingLicencePlateContract.LogicView mLogicView;

    public SettingLicencePlatePresenter(ISettingLicencePlateContract.LogicView logicView) {
        this.mLogicView = logicView;
        ISettingLicencePlateContract.LogicView logicView2 = this.mLogicView;
        if (logicView2 != null) {
            logicView2.setPresenter(this);
        }
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
        ISettingLicencePlateContract.LogicView logicView = this.mLogicView;
        if (logicView != null) {
            logicView.unBindView();
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void show() {
        super.show();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void hide() {
        super.hide();
    }

    public void onCreate() {
        if (L.ENABLE) {
            L.d(TAG, "onCreate");
        }
        ISettingLicencePlateContract.LogicView logicView = this.mLogicView;
        if (logicView != null) {
            logicView.bindView();
        }
    }

    public boolean save(String str) {
        if (NavCoreUtil.isLicencePlateNo(str)) {
            SettingWrapper.saveLicensePlate(str);
            this.mLogicView.goBack();
            return true;
        }
        return false;
    }

    public void exitScene() {
        this.mLogicView.goBack();
    }

    /* loaded from: classes3.dex */
    protected static class KeyboardOnclickListener implements KeyboardCallback {
        private WeakReference<ISettingLicencePlateContract.LogicView> mView;

        @Override // com.xiaopeng.montecarlo.views.keyboard.KeyboardCallback
        public void onConfirmKey() {
        }

        @Override // com.xiaopeng.montecarlo.views.keyboard.KeyboardCallback
        public void onDeleteKey() {
        }

        public KeyboardOnclickListener(ISettingLicencePlateContract.LogicView logicView) {
            this.mView = new WeakReference<>(logicView);
        }

        @Override // com.xiaopeng.montecarlo.views.keyboard.KeyboardCallback
        public void onTextKey(String str) {
            if (this.mView.get() != null) {
                this.mView.get().updateLicencePlateFirstValue(str);
                this.mView.get().focusPlateEdit();
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        if (speechNaviEvent.what == 312) {
            L.Tag tag = TAG;
            L.i(tag, "SPEECH_ROUTE_NEW_DEST_WITH_VIAS, isSceneLegal:" + this.mLogicView.isSceneLegal());
            if (this.mLogicView.isSceneLegal()) {
                this.mLogicView.getSpeechEventBizHelper().routeNewDestWithVias(this.mLogicView.getMainContext().getCurrentScene(), speechNaviEvent);
                return true;
            }
        }
        return false;
    }
}
