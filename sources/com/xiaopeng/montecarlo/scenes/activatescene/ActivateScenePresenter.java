package com.xiaopeng.montecarlo.scenes.activatescene;

import com.xiaopeng.montecarlo.InitializerManager;
import com.xiaopeng.montecarlo.base.scene.BasePresenter;
import com.xiaopeng.montecarlo.navcore.activate.ActivateManager;
import com.xiaopeng.montecarlo.navcore.activate.IActivateResultListener;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.activatescene.IActivateContract;
/* loaded from: classes3.dex */
public class ActivateScenePresenter extends BasePresenter implements IActivateContract.Presenter, IActivateResultListener {
    private static final L.Tag TAG = new L.Tag("ActivateScenePresenter");
    private ActivateManager mActivateManager;
    private boolean mIsFirstEnter = true;
    private IActivateContract.LogicView mLogicView;

    public ActivateScenePresenter(IActivateContract.LogicView logicView) {
        if (logicView == null) {
            throw new IllegalArgumentException("logicView is null");
        }
        this.mLogicView = logicView;
        this.mLogicView.setPresenter(this);
        this.mActivateManager = ActivateManager.getInstance();
        this.mActivateManager.setActivateListener(this);
    }

    public void startCheckActivate(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>> startCheckActivate hasSaveInstanceState=" + z);
        }
        this.mIsFirstEnter = true;
        if (z) {
            int activateType = this.mActivateManager.getActivateType();
            int activateCode = this.mActivateManager.getActivateCode();
            if (-1 == activateType) {
                this.mActivateManager.startCheckActivate();
                return;
            } else if (this.mActivateManager.isActivateSuccess()) {
                resumeActivateSuccessDialog(activateType, activateCode);
                return;
            } else {
                onActivateResult(activateType, activateCode);
                return;
            }
        }
        this.mActivateManager.startCheckActivate();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onResume() {
        super.onResume();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>> onResume mIsFirstEnter=" + this.mIsFirstEnter);
        }
        if (!this.mIsFirstEnter) {
            int activateType = this.mActivateManager.getActivateType();
            int activateCode = this.mActivateManager.getActivateCode();
            if (this.mActivateManager.isActivateSuccess()) {
                resumeActivateSuccessDialog(activateType, activateCode);
            } else {
                onActivateResult(activateType, activateCode);
            }
        }
        this.mIsFirstEnter = false;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onPause() {
        super.onPause();
        this.mIsFirstEnter = false;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onDestroy() {
        super.onDestroy();
        this.mActivateManager.setActivateListener(null);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void show() {
        super.show();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void hide() {
        super.hide();
    }

    private void resumeActivateSuccessDialog(int i, int i2) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>> resumeActivateSuccessDialog activateType=" + i + " activateCode=" + i2);
        }
        if (1 == i2) {
            if (3 == i) {
                this.mLogicView.activateManualSuccess(true);
            } else {
                this.mLogicView.activateSilentSuccess();
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.activate.IActivateResultListener
    public void onActivateResult(int i, int i2) {
        L.Tag tag = TAG;
        L.i(tag, ">>> onActivateResult activateType=" + i + " activateCode=" + i2);
        if (1 == i2) {
            if (3 == i) {
                this.mLogicView.activateManualSuccess(false);
            } else {
                this.mLogicView.activateSilentSuccess();
            }
            InitializerManager.getInstance().initAfterBLActivation();
        } else if (i == 0 || i == 1) {
            this.mLogicView.showActivateNetErrorDialog();
        } else if (i == 2) {
            this.mLogicView.showManualActivateDialog();
        } else if (i != 3) {
        } else {
            this.mLogicView.showManualActivateFail(i2);
        }
    }

    public String getUUID() {
        return this.mActivateManager.getUUID();
    }

    public void manualActivate(String str, String str2) {
        this.mActivateManager.manualActivate(str, str2);
    }

    public boolean isActivateSuccess() {
        return this.mActivateManager.isActivateSuccess();
    }
}
